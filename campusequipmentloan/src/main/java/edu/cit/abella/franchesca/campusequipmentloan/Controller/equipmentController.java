package edu.cit.abella.franchesca.campusequipmentloan.Controller;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.equipmentEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Service.equipmentService;
import edu.cit.abella.franchesca.campusequipmentloan.Service.loanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/equipment")
public class equipmentController {

    @Autowired
    private loanService loanservice;

    @Autowired
    private equipmentService equipmentservice;

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

