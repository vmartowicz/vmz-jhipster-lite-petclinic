package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Address(Street street, City city, ZipCode zipCode) {
  public Address {
    Assert.notNull("street", street);
    Assert.notNull("city", city);
    Assert.notNull("zipCode", zipCode);
  }
}
