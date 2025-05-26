package com.petclinic.sample.application;

import com.petclinic.sample.domain.BeerId;
import com.petclinic.shared.kipe.application.AccessChecker;
import com.petclinic.shared.kipe.application.AccessContext;
import com.petclinic.shared.kipe.application.JhipetclinicAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerIdAccessChecker implements AccessChecker<BeerId> {

  private final JhipetclinicAuthorizations authorizations;

  public BeerIdAccessChecker(JhipetclinicAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerId> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
