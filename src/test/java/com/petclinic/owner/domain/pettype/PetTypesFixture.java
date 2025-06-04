package com.petclinic.owner.domain.pettype;

import static com.petclinic.owner.domain.pettype.PetTypesIdentityFixture.cloackOfFeathersId;

public final class PetTypesFixture {

  private PetTypesFixture() {}

  public static PetType petType() {
    return PetType.builder().id(cloackOfFeathersId()).name(cloakOfFeathersName().get()).build();
  }

  public static PetTypeToCreate petTypeToCreate() {
    return new PetTypeToCreate(cloakOfFeathersName());
  }

  private static PetTypeName cloakOfFeathersName() {
    return new PetTypeName("Dog");
  }
}
