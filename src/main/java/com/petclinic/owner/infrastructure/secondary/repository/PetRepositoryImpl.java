package com.petclinic.owner.infrastructure.secondary.repository;

import com.petclinic.owner.domain.Pet;
import com.petclinic.owner.domain.PetRepository;
import com.petclinic.owner.infrastructure.secondary.entity.PetEntity;
import com.petclinic.owner.infrastructure.secondary.mapper.PetMapper;
import com.petclinic.owner.infrastructure.secondary.repository.jpa.PetJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class PetRepositoryImpl implements PetRepository {

  private final PetJpaRepository jpaRepository;

  public PetRepositoryImpl(PetJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Pet save(Pet pet) {
    PetEntity entity = PetMapper.toEntity(pet);
    PetEntity savedEntity = jpaRepository.save(entity);
    return PetMapper.toDomain(savedEntity);
  }

  @Override
  public Optional<Pet> findById(Long id) {
    return jpaRepository.findById(id).map(PetMapper::toDomain);
  }

  @Override
  public List<Pet> findByOwnerId(Long ownerId) {
    return jpaRepository.findByOwnerId(ownerId).stream().map(PetMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public void deleteById(Long id) {
    jpaRepository.deleteById(id);
  }

  @Override
  public boolean existsById(Long id) {
    return jpaRepository.existsById(id);
  }
}
