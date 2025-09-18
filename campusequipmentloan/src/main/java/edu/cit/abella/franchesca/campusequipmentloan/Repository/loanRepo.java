package edu.cit.abella.franchesca.campusequipmentloan.Repository;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.loanEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.studentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loanRepo extends JpaRepository<loanEntity, Long> {
    long countByStudentAndStatus(studentEntity student, String status);
}
