package edu.cit.abella.franchesca.campusequipmentloan.Repository;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.equipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface equipmentRepo extends JpaRepository<equipmentEntity, Long> {
    List<equipmentEntity> findByAvailabilityTrue();
}

