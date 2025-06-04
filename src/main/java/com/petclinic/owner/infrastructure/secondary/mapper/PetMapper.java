package com.petclinic.owner.infrastructure.secondary.mapper;

import com.petclinic.owner.domain.Owner;
import com.petclinic.owner.domain.Pet;
import com.petclinic.owner.infrastructure.secondary.entity.PetEntity;

public class PetMapper {

  public static Pet toDomain(PetEntity entity) {
    if (entity == null) return null;

    Owner owner = OwnerMapper.toDomain(entity.getOwner());

    Pet pet = new Pet(entity.getName(), entity.getBirthDate(), null, owner);
    pet.setId(entity.getId());

    return pet;
  }

  public static PetEntity toEntity(Pet domain) {
    if (domain == null) return null;

    PetEntity entity = new PetEntity();
    entity.setId(domain.getId());
    entity.setName(domain.getName());
    entity.setBirthDate(domain.getBirthDate());
    entity.setType(null);
    entity.setOwner(OwnerMapper.toEntity(domain.getOwner()));

    return entity;
  }
}
