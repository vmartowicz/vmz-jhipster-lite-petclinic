package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Lastname(String value) {
  public Lastname {
    Assert.notBlank("value", value);
  }
}
