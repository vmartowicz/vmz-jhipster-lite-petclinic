package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record City(String value) {
  public City {
    Assert.notBlank("value", value);
  }
}
