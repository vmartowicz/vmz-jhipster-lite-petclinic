package com.petclinic.owner.application;

import com.petclinic.shared.authentication.domain.Role;
import com.petclinic.shared.kipe.domain.RolesAccesses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OwnerAccessesConfiguration {

  @Bean
  RolesAccesses ownerAccesses() {
    return RolesAccesses.builder()
      .role(Role.ADMIN)
      .allAuthorized("create", OwnerResource.PETTYPES)
      .allAuthorized("remove", OwnerResource.PETTYPES)
      .and()
      .build();
  }
}
