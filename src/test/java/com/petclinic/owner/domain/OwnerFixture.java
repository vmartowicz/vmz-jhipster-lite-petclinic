package com.petclinic.owner.domain;

import com.petclinic.owner.domain.recipient.*;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

public final class OwnerFixture {

  private OwnerFixture() {}

  public static Owner owner() {
    return new Owner(ownerId(), recipient());
  }

  private static Recipient recipient() {
    return new Recipient(recipientName(), address(), phone());
  }

  private static Phone phone() {
    return new Phone("123-456-7890");
  }

  private static Address address() {
    return new Address(new Street("123 Main St"), new City("Springfield"), new ZipCode("62701"));
  }

  private static @NotNull Name recipientName() {
    return new Name(new Firstname("John"), new Lastname("Doe"));
  }

  private static OwnerId ownerId() {
    return new OwnerId(UUID.fromString("d4c3b2a1-0f9e-8d7c-6b5a-4c3b2a1d0e9f"));
  }
}
