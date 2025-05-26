package com.petclinic.infrastrucutre.secondary.repository.jpa;

import com.petclinic.infrastrucutre.secondary.entity.VetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetJpaRepository extends JpaRepository<VetEntity, Long> {}
