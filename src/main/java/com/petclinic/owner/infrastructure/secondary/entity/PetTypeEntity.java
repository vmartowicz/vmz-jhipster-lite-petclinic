package com.petclinic.owner.infrastructure.secondary.entity;

import com.petclinic.owner.domain.pettype.PetType;
import com.petclinic.owner.domain.pettype.PetTypeId;
import com.petclinic.shared.error.domain.Assert;
import com.petclinic.shared.generation.domain.ExcludeFromGeneratedCodeCoverage;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@Table(name = "types")
public class PetTypeEntity {

  @Id
  private UUID id;

  @Column(nullable = false, unique = true)
  private String name;

  @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
  private List<PetEntity> pets = new ArrayList<>();

  public static PetTypeEntity from(PetType petType) {
    Assert.notNull("pettypes", petType);
    return new PetTypeEntity().id(petType.id().get()).name(petType.name().get());
  }

  public PetTypeEntity id(UUID id) {
    this.id = id;

    return this;
  }

  public PetTypeEntity name(String name) {
    this.name = name;

    return this;
  }

  public PetType toDomain() {
    return PetType.builder().id(new PetTypeId(id)).name(name).build();
  }

  @Override
  @ExcludeFromGeneratedCodeCoverage
  public int hashCode() {
    return new HashCodeBuilder().append(id).hashCode();
  }

  @Override
  @ExcludeFromGeneratedCodeCoverage
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    PetTypeEntity other = (PetTypeEntity) obj;

    return new EqualsBuilder().append(id, other.id).isEquals();
  }
}
