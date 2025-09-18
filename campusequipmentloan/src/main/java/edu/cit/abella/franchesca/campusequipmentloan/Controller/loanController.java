package edu.cit.abella.franchesca.campusequipmentloan.Controller;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.loanEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Service.loanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@RestController
@RequestMapping("/api/loans")
public class loanController {

    @Autowired
    private loanService loanservice;

    @PostMapping
    public ResponseEntity<loanEntity> createLoan(@RequestParam Long studentId, @RequestParam Long equipmentId) {
        return ResponseEntity.ok(loanservice.createLoan(equipmentId, studentId));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<loanEntity> returnLoan(@PathVariable Long id) {
        return ResponseEntity.ok(loanservice.returnLoan(id));
    }
}

