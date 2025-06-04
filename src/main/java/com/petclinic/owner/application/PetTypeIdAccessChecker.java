package com.petclinic.owner.application;

import com.petclinic.owner.domain.pettype.PetTypeId;
import com.petclinic.shared.kipe.application.AccessChecker;
import com.petclinic.shared.kipe.application.AccessContext;
import com.petclinic.shared.kipe.application.JhipetclinicAuthorizations;
import org.springframework.stereotype.Component;

@Component
class PetTypeIdAccessChecker implements AccessChecker<PetTypeId> {

  private final JhipetclinicAuthorizations authorizations;

  public PetTypeIdAccessChecker(JhipetclinicAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<PetTypeId> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), OwnerResource.PETTYPES);
  }
}
