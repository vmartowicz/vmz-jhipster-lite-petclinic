package com.petclinic.owner.infrastructure.secondary.repository;

import com.petclinic.owner.infrastructure.secondary.repository.jpa.VetJpaRepository;
import com.petclinic.vet.domain.VetRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VetRepositoryImpl implements VetRepository {

  private final VetJpaRepository jpaRepository;

  public VetRepositoryImpl(VetJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }
}
