package com.petclinic.sample.domain.order;

import com.petclinic.sample.domain.Amount;
import com.petclinic.sample.domain.BeerId;
import com.petclinic.shared.error.domain.Assert;

public record OrderedBeer(BeerId beer, Amount unitPrice) {
  public OrderedBeer {
    Assert.notNull("beer", beer);
    Assert.notNull("unitPrice", unitPrice);
  }
}
