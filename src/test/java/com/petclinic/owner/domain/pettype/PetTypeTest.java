package com.petclinic.owner.domain.pettype;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.petclinic.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class PetTypeTest {

  @Test
  void shouldGetId() {
    PetTypeId id = PetTypeId.newId();
    PetTypeName name = new PetTypeName("Dog");
    PetType petType = PetType.builder().id(id).name(name).build();

    assertThat(petType.name().get()).isEqualTo("Dog");
  }
}
