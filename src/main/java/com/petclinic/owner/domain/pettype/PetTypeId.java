package com.petclinic.owner.domain.pettype;

import com.petclinic.shared.error.domain.Assert;
import java.util.UUID;

public record PetTypeId(UUID id) {
  public PetTypeId {
    Assert.notNull("id", id);
  }

  public static PetTypeId newId() {
    return new PetTypeId(UUID.randomUUID());
  }

  public UUID get() {
    return id();
  }
}
