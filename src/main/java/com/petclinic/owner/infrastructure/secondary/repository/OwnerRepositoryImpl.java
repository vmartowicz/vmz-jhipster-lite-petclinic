package com.petclinic.owner.infrastructure.secondary.repository;

import com.petclinic.owner.domain.Owner;
import com.petclinic.owner.domain.OwnerRepository;
import com.petclinic.owner.infrastructure.secondary.entity.OwnerEntity;
import com.petclinic.owner.infrastructure.secondary.mapper.OwnerMapper;
import com.petclinic.owner.infrastructure.secondary.repository.jpa.OwnerJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerRepositoryImpl implements OwnerRepository {

  private final OwnerJpaRepository jpaRepository;

  public OwnerRepositoryImpl(OwnerJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Owner save(Owner owner) {
    OwnerEntity entity = OwnerMapper.toEntity(owner);
    OwnerEntity savedEntity = jpaRepository.save(entity);
    return OwnerMapper.toDomain(savedEntity);
  }

  @Override
  public Optional<Owner> findById(Long id) {
    return jpaRepository.findById(id).map(OwnerMapper::toDomain);
  }

  @Override
  public List<Owner> findByLastNameContaining(String lastName) {
    return jpaRepository.findByLastNameContainingIgnoreCase(lastName).stream().map(OwnerMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public List<Owner> findAll() {
    return jpaRepository.findAll().stream().map(OwnerMapper::toDomain).collect(Collectors.toList());
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
