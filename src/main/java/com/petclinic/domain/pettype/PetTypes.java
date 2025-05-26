package com.petclinic.domain.pettype;

import com.petclinic.shared.error.domain.Assert;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public record PetTypes(Collection<PetType> pettypes) {
  private static final Comparator<PetType> PETTYPE_NAME_COMPARATOR = Comparator.comparing(pettype -> pettype.name().get());

  public PetTypes(Collection<PetType> pettypes) {
    Assert.field("beers", pettypes).notNull().noNullElement();

    this.pettypes = pettypes.stream().sorted(PETTYPE_NAME_COMPARATOR).toList();
  }

  public Collection<PetType> get() {
    return pettypes();
  }

  public Stream<PetType> stream() {
    return pettypes().stream();
  }
}
