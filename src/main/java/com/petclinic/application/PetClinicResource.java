package com.petclinic.application;

import com.petclinic.shared.kipe.domain.Resource;

enum PetClinicResource implements Resource {
  PETTYPES("pettypes");

  private final String key;

  PetClinicResource(String key) {
    this.key = key;
  }

  @Override
  public String key() {
    return key;
  }
}
