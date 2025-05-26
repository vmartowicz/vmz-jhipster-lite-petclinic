package com.petclinic.infrastrucutre.secondary.repository;

import com.petclinic.domain.Owner;
import com.petclinic.domain.OwnerRepository;
import com.petclinic.infrastrucutre.secondary.entity.OwnerEntity;
import com.petclinic.infrastrucutre.secondary.mapper.OwnerMapper;
import com.petclinic.infrastrucutre.secondary.repository.jpa.OwnerJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return jpaRepository.findById(id)
                .map(OwnerMapper::toDomain);
    }

    @Override
    public List<Owner> findByLastNameContaining(String lastName) {
        return jpaRepository.findByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(OwnerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Owner> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(OwnerMapper::toDomain)
                .collect(Collectors.toList());
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
