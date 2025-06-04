package com.petclinic.owner.infrastructure.secondary.mapper;

import com.petclinic.owner.domain.Pet;
import com.petclinic.owner.infrastructure.secondary.entity.VisitEntity;
import com.petclinic.visit.domain.Visit;

public class VisitMapper {

  public static Visit toDomain(VisitEntity entity) {
    if (entity == null) return null;

    Pet pet = PetMapper.toDomain(entity.getPet());
    Visit visit = new Visit(entity.getDate(), entity.getDescription(), pet);
    visit.setId(entity.getId());
    return visit;
  }

  public static VisitEntity toEntity(Visit domain) {
    if (domain == null) return null;

    VisitEntity entity = new VisitEntity(domain.getDate(), domain.getDescription(), PetMapper.toEntity(domain.getPet()));
    entity.setId(domain.getId());
    return entity;
  }
}
