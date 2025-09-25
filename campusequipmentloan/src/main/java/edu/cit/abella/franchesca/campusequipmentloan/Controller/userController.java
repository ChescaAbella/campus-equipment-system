package edu.cit.abella.franchesca.campusequipmentloan.Controller;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.userEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Service.userService;
import edu.cit.abella.franchesca.campusequipmentloan.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
public class userController {

    @PutMapping("/add")
    public equipmentEntity create(@RequestBody equipmentEntity equipment) {
        return equipmentservice.createEquipment(
                equipment.getName(),
                equipment.getType(),
                equipment.getSerialNumber(),
                equipment.getAvailability()
        );
    }

    @GetMapping("/available")
    public List<equipmentEntity> getAvailableEquipment() {
        return loanservice.getAvailableEquipment();
    }
}

