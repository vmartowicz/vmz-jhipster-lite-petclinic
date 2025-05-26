package com.petclinic.domain.pettype;

import com.petclinic.domain.PetTypeRepository;
import com.petclinic.shared.error.domain.Assert;

public class PetTypesRemover {

  private final PetTypeRepository pettypes;

  public PetTypesRemover(PetTypeRepository pettypes) {
    Assert.notNull("pettypes", pettypes);

    this.pettypes = pettypes;
  }

  public void remove(PetTypeId id) {
    Assert.notNull("id", id);
    pettypes.remove(id);
  }
}
