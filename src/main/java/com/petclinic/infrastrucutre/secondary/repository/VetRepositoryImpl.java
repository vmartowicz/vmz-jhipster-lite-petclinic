package com.petclinic.infrastrucutre.secondary.repository;

import com.petclinic.domain.VetRepository;
import com.petclinic.infrastrucutre.secondary.repository.jpa.VetJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VetRepositoryImpl implements VetRepository {

  private final VetJpaRepository jpaRepository;

  public VetRepositoryImpl(VetJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }
}
