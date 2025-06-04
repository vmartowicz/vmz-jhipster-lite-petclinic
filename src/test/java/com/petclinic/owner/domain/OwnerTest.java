package com.petclinic.owner.domain;

import static com.petclinic.owner.domain.OwnerFixture.owner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.petclinic.UnitTest;
import java.util.UUID;
import org.junit.jupiter.api.Test;

@UnitTest
class OwnerTest {

  @Test
  void shoudGetId() {
    assertThat(owner().id().value()).isEqualTo(UUID.fromString("d4c3b2a1-0f9e-8d7c-6b5a-4c3b2a1d0e9f"));
  }

  @Test
  void shoudGetRecipient() {
    assertThat(owner().recipient().name().firstname().value()).isEqualTo("John");
    assertThat(owner().recipient().name().lastname().value()).isEqualTo("Doe");

    assertThat(owner().recipient().address().street().value()).isEqualTo("123 Main St");
    assertThat(owner().recipient().address().city().value()).isEqualTo("Springfield");
    assertThat(owner().recipient().address().zipCode().value()).isEqualTo("62701");

    assertThat(owner().recipient().phone().value()).isEqualTo("123-456-7890");
  }
}
