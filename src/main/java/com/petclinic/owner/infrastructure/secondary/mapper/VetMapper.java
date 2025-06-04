package com.petclinic.owner.infrastructure.secondary.mapper;

import com.petclinic.owner.infrastructure.secondary.entity.VetEntity;
import com.petclinic.vet.domain.Vet;

public class VetMapper {

  public static Vet toDomain(VetEntity entity) {
    if (entity == null) return null;

    return new Vet();
  }

  public static VetEntity toEntity(Vet domain) {
    if (domain == null) return null;

    return new VetEntity();
  }
}
