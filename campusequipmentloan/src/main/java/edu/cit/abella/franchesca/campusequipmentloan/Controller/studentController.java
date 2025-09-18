package edu.cit.abella.franchesca.campusequipmentloan.Controller;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.studentEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/student")
public class studentController {

    @Autowired
    studentService studentservice;

    @PutMapping("/add")
    public studentEntity create(@RequestBody studentEntity student){
        return studentservice.createStudent(student.getStudentNo(),student.getName(), student.getEmail());
    }

}
