package com.petclinic.sample.infrastructure.secondary;

import static com.petclinic.sample.domain.beer.BeersFixture.*;
import static org.assertj.core.api.Assertions.*;

import com.petclinic.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class BeerEntityTest {

  @Test
  void shouldConvertFromAndToDomain() {
    assertThat(BeerEntity.from(beer()).toDomain()).usingRecursiveComparison().isEqualTo(beer());
  }
}
