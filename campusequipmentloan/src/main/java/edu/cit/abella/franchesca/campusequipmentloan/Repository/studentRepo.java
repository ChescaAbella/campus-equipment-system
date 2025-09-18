package edu.cit.abella.franchesca.campusequipmentloan.Repository;
import edu.cit.abella.franchesca.campusequipmentloan.Entity.studentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<studentEntity, Long> {
}