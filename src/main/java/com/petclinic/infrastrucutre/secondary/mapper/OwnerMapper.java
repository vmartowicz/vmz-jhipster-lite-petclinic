package com.petclinic.infrastrucutre.secondary.mapper;

import com.petclinic.domain.Owner;
import com.petclinic.domain.Pet;
import com.petclinic.infrastrucutre.secondary.entity.OwnerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerMapper {

    public static Owner toDomain(OwnerEntity entity) {
        if (entity == null) return null;

        Owner owner = new Owner(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getAddress(),
                entity.getCity(),
                entity.getTelephone()
        );
        owner.setId(entity.getId());

        // Mapper les pets si nécessaire
        if (entity.getPets() != null) {
            List<Pet> pets = entity.getPets().stream()
                    .map(PetMapper::toDomain)
                    .collect(Collectors.toList());
            owner.setPets(pets);
        }

        return owner;
    }

    public static OwnerEntity toEntity(Owner domain) {
        if (domain == null) return null;

        OwnerEntity entity = new OwnerEntity(
                domain.getFirstName(),
                domain.getLastName(),
                domain.getAddress(),
                domain.getCity(),
                domain.getTelephone()
        );
        entity.setId(domain.getId());

        return entity;
    }
}
