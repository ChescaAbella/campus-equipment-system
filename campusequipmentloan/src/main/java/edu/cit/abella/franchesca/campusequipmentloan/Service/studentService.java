package edu.cit.abella.franchesca.campusequipmentloan.Service;

import edu.cit.abella.franchesca.campusequipmentloan.Entity.studentEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Repository.studentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    private studentRepo studentrepo;

    public studentEntity createStudent(Long studentNo, String name, String email){
        studentEntity student = new studentEntity();
        student.setStudentNo(studentNo);
        student.setName(name);
        student.setEmail(email);
        return studentrepo.save(student);
    }

    public List<studentEntity> getAllStudent(){
        return studentrepo.findAll();
    }

}
