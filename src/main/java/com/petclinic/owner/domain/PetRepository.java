package com.petclinic.owner.domain;

import java.util.List;
import java.util.Optional;

public interface PetRepository {
  Pet save(Pet pet);
  Optional<Pet> findById(Long id);
  List<Pet> findByOwnerId(Long ownerId);
  void deleteById(Long id);
  boolean existsById(Long id);
}
