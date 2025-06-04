package com.petclinic.owner.application;

import com.petclinic.shared.kipe.domain.Resource;

enum OwnerResource implements Resource {
  PETTYPES("pettypes");

  private final String key;

  OwnerResource(String key) {
    this.key = key;
  }

  @Override
  public String key() {
    return key;
  }
}
