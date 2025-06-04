package com.petclinic.visit.domain;

import java.util.List;
import java.util.Optional;

public interface VisitRepository {
  Visit save(Visit visit);
  List<Visit> findByPetId(Long petId);
  Optional<Visit> findById(Long id);
}
