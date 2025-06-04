package com.petclinic.owner.infrastructure.secondary.repository.jpa;

import com.petclinic.owner.infrastructure.secondary.entity.VisitEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitJpaRepository extends JpaRepository<VisitEntity, Long> {
  List<VisitEntity> findByPetIdOrderByDateDesc(Long petId);
}
