package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record ZipCode(String value) {
  public ZipCode {
    Assert.notBlank("value", value);
  }
}
