package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Street(String value) {
  public Street {
    Assert.notBlank("value", value);
  }
}
