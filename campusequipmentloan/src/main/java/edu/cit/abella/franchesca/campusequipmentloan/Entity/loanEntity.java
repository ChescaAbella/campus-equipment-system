package edu.cit.abella.franchesca.campusequipmentloan.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class loanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    private String status;

    @ManyToOne
    private equipmentEntity equipment;

    @ManyToOne
    private studentEntity student;


    public loanEntity() {}


    public loanEntity(equipmentEntity equipment, studentEntity student,LocalDateTime startDate, LocalDateTime dueDate, LocalDateTime returnDate, String status) {
        this.equipment = equipment;
        this.student = student;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // ✅ Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public equipmentEntity getEquipment() {
        return equipment;
    }

    public void setEquipment(equipmentEntity equipment) {
        this.equipment = equipment;
    }

    public studentEntity getStudent() {
        return student;
    }

    public void setStudent(studentEntity student) {
        this.student = student;
    }
}
