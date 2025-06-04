package com.petclinic.owner.domain.pettype;

import com.petclinic.shared.error.domain.Assert;

public record PetTypeName(String name) {
  public PetTypeName {
    Assert.field("name", name).notBlank().maxLength(80);
  }

  public String get() {
    return name();
  }
}
