package com.petclinic.owner.domain.recipient;

import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
public record Recipient(Name name, Address address, Phone phone) {
  public Recipient {
    Assert.notNull("name", name);
    Assert.notNull("address", address);
    Assert.notNull("phone", phone);
  }
}
