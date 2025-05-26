package com.petclinic.sample.application;

import com.petclinic.sample.domain.beer.BeerToCreate;
import com.petclinic.shared.kipe.application.AccessChecker;
import com.petclinic.shared.kipe.application.AccessContext;
import com.petclinic.shared.kipe.application.JhipetclinicAuthorizations;
import org.springframework.stereotype.Component;

@Component
class BeerToCreateAccessChecker implements AccessChecker<BeerToCreate> {

  private final JhipetclinicAuthorizations authorizations;

  public BeerToCreateAccessChecker(JhipetclinicAuthorizations authorizations) {
    this.authorizations = authorizations;
  }

  @Override
  public boolean can(AccessContext<BeerToCreate> access) {
    return authorizations.allAuthorized(access.authentication(), access.action(), BeerResource.BEERS);
  }
}
