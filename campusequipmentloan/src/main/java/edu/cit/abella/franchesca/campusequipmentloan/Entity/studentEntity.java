package edu.cit.abella.franchesca.campusequipmentloan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class studentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentNo;

    private String name;

    private String email;

    public studentEntity(Long studentNo, String name, String email) {
        this.studentNo = studentNo;
        this.name = name;
        this.email = email;
    }
    public studentEntity() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
