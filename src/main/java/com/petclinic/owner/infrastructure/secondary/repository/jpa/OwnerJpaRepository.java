package com.petclinic.owner.infrastructure.secondary.repository.jpa;

import com.petclinic.owner.infrastructure.secondary.entity.OwnerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerJpaRepository extends JpaRepository<OwnerEntity, Long> {
  List<OwnerEntity> findByLastNameContainingIgnoreCase(String lastName);
}
