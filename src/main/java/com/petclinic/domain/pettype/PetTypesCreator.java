package com.petclinic.domain.pettype;

import com.petclinic.domain.PetTypesRepository;
import com.petclinic.shared.error.domain.Assert;

public class PetTypesCreator {

  private final PetTypesRepository pettypes;

  public PetTypesCreator(PetTypesRepository pettypes) {
    Assert.notNull("beers", pettypes);

    this.pettypes = pettypes;
  }

  public PetType create(PetTypeToCreate petTypeToCreate) {
    var createdPetType = petTypeToCreate.create();
    return pettypes.save(createdPetType);
  }
}
