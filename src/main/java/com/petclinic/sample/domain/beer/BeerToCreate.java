package com.petclinic.sample.domain.beer;

import com.petclinic.sample.domain.Amount;
import com.petclinic.sample.domain.BeerId;
import com.petclinic.shared.error.domain.Assert;

public record BeerToCreate(BeerName name, Amount unitPrice) {
  public BeerToCreate {
    Assert.notNull("name", name);
    Assert.notNull("unitPrice", unitPrice);
  }

  public Beer create() {
    return Beer.builder().id(BeerId.newId()).name(name()).unitPrice(unitPrice()).sellingState(BeerSellingState.SOLD).build();
  }
}
