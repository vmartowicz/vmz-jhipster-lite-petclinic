package com.petclinic.infrastrucutre.secondary.repository;

import com.petclinic.domain.PetTypeRepository;
import com.petclinic.domain.pettype.PetType;
import com.petclinic.domain.pettype.PetTypeId;
import com.petclinic.domain.pettype.PetTypes;
import com.petclinic.infrastrucutre.secondary.entity.PetTypeEntity;
import com.petclinic.infrastrucutre.secondary.repository.jpa.PetTypeJpaRepository;
import com.petclinic.shared.error.domain.Assert;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class PetTypeRepositoryImpl implements PetTypeRepository {

  private final PetTypeJpaRepository pettypes;

  public PetTypeRepositoryImpl(PetTypeJpaRepository pettypes) {
    this.pettypes = pettypes;
  }

  @Override
  public PetTypes findAll() {
    return new PetTypes(pettypes.findAll().stream().map(PetTypeEntity::toDomain).collect(Collectors.toList()));
  }

  @Override
  public PetType save(PetType petType) {
    Assert.notNull("petType", petType);
    PetTypeEntity entity = PetTypeEntity.from(petType);
    PetTypeEntity savedEntity = pettypes.save(entity);
    return savedEntity.toDomain();
  }

  @Override
  public void remove(PetTypeId pettype) {
    Assert.notNull("pettype", pettype);
    pettypes.deleteById(pettype.id());
  }

  @Override
  public Optional<PetType> get(PetTypeId pettype) {
    Assert.notNull("pettype", pettype);
    return pettypes.findById(pettype.id()).map(PetTypeEntity::toDomain);
  }
}
