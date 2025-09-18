package edu.cit.abella.franchesca.campusequipmentloan.Service;

import edu.cit.abella.franchesca.campusequipmentloan.Entity.equipmentEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.loanEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.studentEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Repository.loanRepo;
import edu.cit.abella.franchesca.campusequipmentloan.Repository.equipmentRepo;
import edu.cit.abella.franchesca.campusequipmentloan.Repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class loanService {

    @Autowired
    private loanRepo loanrepo;

    @Autowired
    private equipmentRepo equipmentRepo;

    @Autowired
    private studentRepo studentRepo;

    public loanEntity createLoan(Long equipmentId, Long studentId) {
        studentEntity student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        equipmentEntity equipment = equipmentRepo.findById(equipmentId)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));


        long activeLoans = loanrepo.countByStudentAndStatus(student, "ACTIVE");
        if (activeLoans >= 2) {
            throw new RuntimeException("Student already has 2 active loans.");
        }


        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime dueDate = startDate.plusDays(7);

        if (!equipment.getAvailability()) {
            throw new RuntimeException("Equipment not available");
        }
        equipment.setAvailability(false);
        equipmentRepo.save(equipment);

        loanEntity loan = new loanEntity();
        loan.setEquipment(equipment);
        loan.setStudent(student);
        loan.setStartDate(startDate);
        loan.setDueDate(dueDate);
        loan.setStatus("ACTIVE");

        return loanrepo.save(loan);
    }

    public loanEntity returnLoan(Long loanId) {
        loanEntity loan = loanrepo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (!"ACTIVE".equals(loan.getStatus())) {
            throw new RuntimeException("Loan already returned");
        }

        loan.setReturnDate(LocalDateTime.now());
        loan.setStatus("RETURNED");


        long daysLate = ChronoUnit.DAYS.between(loan.getDueDate(), loan.getReturnDate());
        long penalty = daysLate > 0 ? daysLate * 50 : 0;


        equipmentEntity equipment = loan.getEquipment();
        equipment.setAvailability(true);
        equipmentRepo.save(equipment);

        loanrepo.save(loan);

        if (penalty > 0) {
            System.out.println("Late penalty: ₱" + penalty);
        }

        return loan;
    }

    public List<equipmentEntity> getAvailableEquipment() {
        return equipmentRepo.findByAvailabilityTrue();
    }
}
