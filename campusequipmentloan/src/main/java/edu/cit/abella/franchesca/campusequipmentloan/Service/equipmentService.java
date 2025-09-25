package edu.cit.abella.franchesca.campusequipmentloan.Service;

import edu.cit.abella.franchesca.campusequipmentloan.Entity.equipmentEntity;
import edu.cit.abella.franchesca.campusequipmentloan.Repository.equipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class equipmentService {

    @Autowired
    private equipmentRepo equipmentrepo;

    public equipmentEntity createEquipment(String name, String type, Long serialNumber, boolean availability){
        equipmentEntity equipment = new equipmentEntity();
        equipment.setName(name);
        equipment.setType(type);
        equipment.setSerialNumber(serialNumber);
        equipment.setAvailability(availability);
        return equipmentrepo.save(equipment);
    }

    public List<equipmentEntity> getAllEquipment(){
        return equipmentrepo.findAll();
    }

}
