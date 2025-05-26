package com.petclinic.infrastrucutre.secondary.repository.jpa;

import com.petclinic.infrastrucutre.secondary.entity.PetTypeEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeJpaRepository extends JpaRepository<PetTypeEntity, UUID> {}
