package com.petclinic.owner.domain.pettype;

import com.petclinic.shared.error.domain.Assert;

public record PetTypeToCreate(PetTypeName name) {
  public PetTypeToCreate {
    Assert.notNull("name", name);
  }

  public PetType create() {
    return PetType.builder().id(PetTypeId.newId()).name(name()).build();
  }
}
