package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Name(Firstname firstname, Lastname lastname) {
  public Name {
    Assert.notNull("firstname", firstname);
    Assert.notNull("lastname", lastname);
  }
}
