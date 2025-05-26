package com.petclinic.domain;

import com.petclinic.domain.pettype.PetType;
import com.petclinic.domain.pettype.PetTypeId;
import com.petclinic.domain.pettype.PetTypes;
import java.util.Optional;

public interface PetTypeRepository {
  PetTypes findAll();

  PetType save(PetType petType);

  void remove(PetTypeId pettype);

  Optional<PetType> get(PetTypeId pettype);
}
