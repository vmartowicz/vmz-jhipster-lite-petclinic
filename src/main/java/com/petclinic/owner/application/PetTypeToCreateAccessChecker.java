package com.petclinic.owner.application;

import com.petclinic.owner.domain.pettype.PetTypeToCreate;
import com.petclinic.shared.kipe.application.AccessChecker;
import com.petclinic.shared.kipe.application.AccessContext;
import com.petclinic.shared.kipe.application.JhipetclinicAuthorizations;
import org.springframework.stereotype.Component;

@Component
class PetTypeToCreateAccessChecker implements AccessChecker<PetTypeToCreate> {

  private final JhipetclinicAuthorizations authorizations;

  public PetTypeToCreateAccessChecker(JhipetclinicAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<PetTypeToCreate> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), OwnerResource.PETTYPES);
  }
}
