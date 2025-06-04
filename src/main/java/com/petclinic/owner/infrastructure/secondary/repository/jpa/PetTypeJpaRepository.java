package com.petclinic.owner.infrastructure.secondary.repository.jpa;

import com.petclinic.owner.infrastructure.secondary.entity.PetTypeEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeJpaRepository extends JpaRepository<PetTypeEntity, UUID> {}
