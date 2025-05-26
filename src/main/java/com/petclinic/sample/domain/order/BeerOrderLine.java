package com.petclinic.sample.domain.order;

import com.petclinic.sample.domain.Amount;
import com.petclinic.shared.error.domain.Assert;

public record BeerOrderLine(OrderedBeer beer, int quantity) {
  public BeerOrderLine {
    Assert.notNull("beer", beer);
    Assert.field("quantity", quantity).min(1);
  }

  Amount amount() {
    return beer().unitPrice().times(quantity());
  }
}
