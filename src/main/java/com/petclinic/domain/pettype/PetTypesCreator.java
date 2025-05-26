package com.petclinic.domain.pettype;

import com.petclinic.domain.PetTypeRepository;
import com.petclinic.shared.error.domain.Assert;

public class PetTypesCreator {

  private final PetTypeRepository pettypes;

  public PetTypesCreator(PetTypeRepository pettypes) {
    Assert.notNull("beers", pettypes);

    this.pettypes = pettypes;
  }

  public PetType create(PetTypeToCreate petTypeToCreate) {
    var createdPetType = petTypeToCreate.create();
    return pettypes.save(createdPetType);
  }
}
