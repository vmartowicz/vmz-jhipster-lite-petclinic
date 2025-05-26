package com.petclinic.infrastrucutre.secondary.mapper;

import com.petclinic.domain.Vet;
import com.petclinic.infrastrucutre.secondary.entity.VetEntity;

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
