package com.petclinic.infrastrucutre.secondary.mapper;

import com.petclinic.domain.Pet;
import com.petclinic.domain.Visit;
import com.petclinic.infrastrucutre.secondary.entity.VisitEntity;

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

        VisitEntity entity = new VisitEntity(
                domain.getDate(),
                domain.getDescription(),
                PetMapper.toEntity(domain.getPet())
        );
        entity.setId(domain.getId());
        return entity;
    }
}
