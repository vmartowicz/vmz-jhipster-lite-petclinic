package com.petclinic.owner.domain;

import com.petclinic.owner.domain.recipient.Recipient;
import com.petclinic.shared.error.domain.Assert;
import org.jmolecules.ddd.annotation.AggregateRoot;

@AggregateRoot
public final class Owner {

  private final OwnerId id;
  private final Recipient recipient;

  public Owner(OwnerId id, Recipient recipient) {
    Assert.notNull("id", id);
    Assert.notNull("recipient", recipient);
    this.id = id;
    this.recipient = recipient;
  }

  public OwnerId id() {
    return id;
  }

  public Recipient recipient() {
    return recipient;
  }
  // Logique métier
  /*  public void addPet(Pet pet) {
    pets.add(pet);
    pet.setOwner(this);
  }*/

}
