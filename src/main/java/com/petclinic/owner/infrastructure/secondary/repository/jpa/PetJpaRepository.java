package com.petclinic.owner.infrastructure.secondary.repository.jpa;

import com.petclinic.owner.infrastructure.secondary.entity.PetEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJpaRepository extends JpaRepository<PetEntity, Long> {
  List<PetEntity> findByOwnerId(Long ownerId);
}
