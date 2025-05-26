package com.petclinic.infrastrucutre.secondary.repository.jpa;

import com.petclinic.infrastrucutre.secondary.entity.VisitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitJpaRepository extends JpaRepository<VisitEntity, Long> {
    List<VisitEntity> findByPetIdOrderByDateDesc(Long petId);
}
