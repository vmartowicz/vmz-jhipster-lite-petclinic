package com.petclinic.infrastrucutre.secondary.repository;

import com.petclinic.domain.Visit;
import com.petclinic.domain.VisitRepository;
import com.petclinic.infrastrucutre.secondary.entity.VisitEntity;
import com.petclinic.infrastrucutre.secondary.mapper.VisitMapper;
import com.petclinic.infrastrucutre.secondary.repository.jpa.VisitJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return jpaRepository.findByPetIdOrderByDateDesc(petId)
                .stream()
                .map(VisitMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Visit> findById(Long id) {
        return jpaRepository.findById(id)
                .map(VisitMapper::toDomain);
    }
}
