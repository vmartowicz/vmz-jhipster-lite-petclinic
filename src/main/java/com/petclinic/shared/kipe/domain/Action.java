package com.petclinic.shared.kipe.domain;

import com.petclinic.shared.error.domain.Assert;

public record Action(String action) {
  public Action {
    Assert.notBlank("action", action);
  }

  @Override
  public String toString() {
    return action();
  }
}
