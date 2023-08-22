package co.in.srdt.bus_management_system.repositories;

import co.in.srdt.bus_management_system.entities.BasicDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicDetailsRepository extends JpaRepository<BasicDetailsEntity, Long> {
}
