package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Phone(String value) {
  public Phone {
    Assert.notBlank("value", value);
  }
}
