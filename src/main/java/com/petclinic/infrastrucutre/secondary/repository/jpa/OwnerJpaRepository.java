package com.petclinic.infrastrucutre.secondary.repository.jpa;

import com.petclinic.infrastrucutre.secondary.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerJpaRepository extends JpaRepository<OwnerEntity, Long> {
    List<OwnerEntity> findByLastNameContainingIgnoreCase(String lastName);
}
