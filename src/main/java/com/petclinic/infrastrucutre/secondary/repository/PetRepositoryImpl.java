package com.petclinic.infrastrucutre.secondary.repository;

import com.petclinic.domain.Pet;
import com.petclinic.domain.PetRepository;
import com.petclinic.infrastrucutre.secondary.entity.PetEntity;
import com.petclinic.infrastrucutre.secondary.mapper.PetMapper;
import com.petclinic.infrastrucutre.secondary.repository.jpa.PetJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return jpaRepository.findById(id)
                .map(PetMapper::toDomain);
    }

    @Override
    public List<Pet> findByOwnerId(Long ownerId) {
        return jpaRepository.findByOwnerId(ownerId)
                .stream()
                .map(PetMapper::toDomain)
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
