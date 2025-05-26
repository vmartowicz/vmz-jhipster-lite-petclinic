package com.petclinic.application;

import com.petclinic.shared.authentication.domain.Role;
import com.petclinic.shared.kipe.domain.RolesAccesses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PetsClinicAccessesConfiguration {

  @Bean
  RolesAccesses petClinicAccesses() {
    return RolesAccesses.builder()
      .role(Role.ADMIN)
      .allAuthorized("create", PetClinicResource.PETTYPES)
      .allAuthorized("remove", PetClinicResource.PETTYPES)
      .and()
      .build();
  }
}
