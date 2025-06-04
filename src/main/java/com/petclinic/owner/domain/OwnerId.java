package com.petclinic.owner.domain;

import com.petclinic.shared.error.domain.Assert;
import java.util.UUID;

public record OwnerId(UUID value) {
  public OwnerId {
    Assert.notNull("value", value);
  }
}
