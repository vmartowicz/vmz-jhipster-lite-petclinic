package com.petclinic.owner.infrastructure.secondary.repository;

import com.petclinic.owner.infrastructure.secondary.entity.VisitEntity;
import com.petclinic.owner.infrastructure.secondary.mapper.VisitMapper;
import com.petclinic.owner.infrastructure.secondary.repository.jpa.VisitJpaRepository;
import com.petclinic.visit.domain.Visit;
import com.petclinic.visit.domain.VisitRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class VisitRepositoryImpl implements VisitRepository {

  private final VisitJpaRepository jpaRepository;

  public VisitRepositoryImpl(VisitJpaRepository jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public Visit save(Visit visit) {
    VisitEntity entity = VisitMapper.toEntity(visit);
    VisitEntity savedEntity = jpaRepository.save(entity);
    return VisitMapper.toDomain(savedEntity);
  }

  @Override
  public List<Visit> findByPetId(Long petId) {
    return jpaRepository.findByPetIdOrderByDateDesc(petId).stream().map(VisitMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public Optional<Visit> findById(Long id) {
    return jpaRepository.findById(id).map(VisitMapper::toDomain);
  }
}
