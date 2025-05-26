package com.petclinic.infrastrucutre.secondary.repository.jpa;
import com.petclinic.infrastrucutre.secondary.entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetJpaRepository extends JpaRepository<PetEntity, Long> {
    List<PetEntity> findByOwnerId(Long ownerId);
}
