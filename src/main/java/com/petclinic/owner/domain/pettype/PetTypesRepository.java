package com.petclinic.owner.domain.pettype;

import java.util.Optional;

public interface PetTypesRepository {
  PetTypes findAll();

  PetType save(PetType petType);

  void remove(PetTypeId pettype);

  Optional<PetType> get(PetTypeId pettype);
}
