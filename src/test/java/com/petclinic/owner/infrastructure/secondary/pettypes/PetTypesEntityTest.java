package com.petclinic.owner.infrastructure.secondary.pettypes;

import static com.petclinic.owner.domain.pettype.PetTypesFixture.petType;
import static org.assertj.core.api.Assertions.assertThat;

import com.petclinic.UnitTest;
import com.petclinic.owner.infrastructure.secondary.entity.PetTypeEntity;
import org.junit.jupiter.api.Test;

@UnitTest
class PetTypesEntityTest {

  @Test
  void shouldConvertFromAndToDomain() {
    assertThat(PetTypeEntity.from(petType()).toDomain()).usingRecursiveComparison().isEqualTo(petType());
  }
}
