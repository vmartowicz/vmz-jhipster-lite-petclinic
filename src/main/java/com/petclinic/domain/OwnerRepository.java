package com.petclinic.domain;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    Owner save(Owner owner);
    Optional<Owner> findById(Long id);
    List<Owner> findByLastNameContaining(String lastName);
    List<Owner> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
