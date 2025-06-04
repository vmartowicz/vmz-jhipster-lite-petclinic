package com.petclinic.owner.domain.pettype;

import com.petclinic.shared.error.domain.Assert;

public final class PetType {

  private final PetTypeId id;
  private final PetTypeName name;

  public PetType(PetTypeBuilder builder) {
    assertMandatoryFields(builder);
    id = builder.id;
    name = builder.name;
  }

  private void assertMandatoryFields(PetTypeBuilder builder) {
    Assert.notNull("id", builder.id);
    Assert.notNull("name", builder.name);
  }

  public static PetTypeIdBuilder builder() {
    return new PetTypeBuilder();
  }

  private static final class PetTypeBuilder implements PetTypeIdBuilder, PetTypeNameBuilder, PetTypeOptionalBuilder {

    private PetTypeId id;
    private PetTypeName name;

    @Override
    public PetTypeNameBuilder id(PetTypeId id) {
      this.id = id;

      return this;
    }

    @Override
    public PetTypeOptionalBuilder name(PetTypeName name) {
      this.name = name;
      return this;
    }

    @Override
    public PetType build() {
      return new PetType(this);
    }
  }

  public interface PetTypeIdBuilder {
    PetTypeNameBuilder id(PetTypeId id);
  }

  public interface PetTypeNameBuilder {
    PetTypeOptionalBuilder name(PetTypeName name);

    default PetTypeOptionalBuilder name(String name) {
      return name(new PetTypeName(name));
    }
  }

  public interface PetTypeOptionalBuilder {
    PetType build();
  }

  public PetTypeId id() {
    return id;
  }

  public PetTypeName name() {
    return name;
  }
}
