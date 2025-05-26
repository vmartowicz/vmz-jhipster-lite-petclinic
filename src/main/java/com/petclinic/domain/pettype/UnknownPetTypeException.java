package com.petclinic.domain.pettype;

public class UnknownPetTypeException extends RuntimeException {

  public UnknownPetTypeException(PetTypeId id) {
    super("Pet Type " + id.get() + " is unknown");
  }
}
