package edu.cit.abella.franchesca.campusequipmentloan.Repository;


import edu.cit.abella.franchesca.campusequipmentloan.Entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepo extends JpaRepository<userEntity, Long> {
    Optional<userEntity> findByUsername(String username);
}
