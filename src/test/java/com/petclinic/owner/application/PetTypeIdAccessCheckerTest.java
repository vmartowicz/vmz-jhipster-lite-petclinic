package com.petclinic.owner.application;

import static com.petclinic.owner.domain.pettype.PetTypesIdentityFixture.cloackOfFeathersId;
import static com.petclinic.shared.kipe.application.TestAuthentications.admin;
import static org.assertj.core.api.Assertions.assertThat;

import com.petclinic.UnitTest;
import com.petclinic.shared.kipe.application.AccessContext;
import com.petclinic.shared.kipe.application.JhipetclinicAuthorizations;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class PetTypeIdAccessCheckerTest {

  private static final PetTypeIdAccessChecker checker = new PetTypeIdAccessChecker(
    new JhipetclinicAuthorizations(List.of(new OwnerAccessesConfiguration().ownerAccesses()))
  );

  @Test
  void shouldNotAuthorizedUnauthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "unauthorized", cloackOfFeathersId()))).isFalse();
  }

  @Test
  void shouldAuthorizedAuthorizedAction() {
    assertThat(checker.can(AccessContext.of(admin(), "create", cloackOfFeathersId()))).isTrue();
  }
}
