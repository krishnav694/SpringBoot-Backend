package co.in.srdt.bus_management_system.repositories;

import co.in.srdt.bus_management_system.entities.BasicDetailsEntity;
import co.in.srdt.bus_management_system.entities.ContactDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity, Long> {
    List<ContactDetailsEntity> findByBasicDetailsEntity(BasicDetailsEntity data);
}
