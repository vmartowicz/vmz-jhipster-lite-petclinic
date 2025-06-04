package com.petclinic.owner.infrastructure.secondary.repository.jpa;

import com.petclinic.owner.infrastructure.secondary.entity.VetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetJpaRepository extends JpaRepository<VetEntity, Long> {}
