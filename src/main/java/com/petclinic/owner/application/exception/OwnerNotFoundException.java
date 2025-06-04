package com.petclinic.owner.application.exception;

public class OwnerNotFoundException extends RuntimeException {

  public OwnerNotFoundException(String message) {
    super(message);
  }
}
