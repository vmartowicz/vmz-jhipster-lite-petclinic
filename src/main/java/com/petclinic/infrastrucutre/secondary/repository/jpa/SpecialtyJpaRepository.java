package com.petclinic.infrastrucutre.secondary.repository.jpa;

import com.petclinic.infrastrucutre.secondary.entity.SpecialtyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyJpaRepository extends JpaRepository<SpecialtyEntity, Long> {}
