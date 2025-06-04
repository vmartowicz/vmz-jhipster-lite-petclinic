package com.petclinic.owner.domain.pettype;

class UnknownPetTypeException extends RuntimeException {

  public UnknownPetTypeException(PetTypeId id) {
    super("Pet Type " + id.get() + " is unknown");
  }
}
