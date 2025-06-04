package com.petclinic.owner.domain.pettype;

import java.util.UUID;

public final class PetTypesIdentityFixture {

  private PetTypesIdentityFixture() {}

  public static PetTypeId cloackOfFeathersId() {
    return new PetTypeId(UUID.fromString("5ea9bbb1-3a55-4701-9006-3bbd2878f241"));
  }

  public static PetTypeId anteMeridiemId() {
    return new PetTypeId(UUID.fromString("b38c2933-1a61-4bac-995d-8e535f4f64a4"));
  }
}
