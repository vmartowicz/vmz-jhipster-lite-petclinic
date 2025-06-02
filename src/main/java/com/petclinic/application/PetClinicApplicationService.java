package com.petclinic.application;

import com.petclinic.domain.*;
import com.petclinic.domain.pettype.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PetClinicApplicationService {

  private final PetTypesRepository pettypes;
  private final PetTypesCreator creator;
  private final PetTypesRemover remover;

  public PetClinicApplicationService(PetTypesRepository petTypesRepository) {
    this.pettypes = petTypesRepository;
    creator = new PetTypesCreator(pettypes);
    remover = new PetTypesRemover(pettypes);
  }

  @Transactional(readOnly = true)
  public PetTypes findAllPetTypes() {
    return pettypes.findAll();
  }

  @Transactional
  @PreAuthorize("can('create', #petTypeToCreate)")
  public PetType create(PetTypeToCreate petTypeToCreate) {
    return creator.create(petTypeToCreate);
  }

  @Transactional
  @PreAuthorize("can('remove', #pettype)")
  public void remove(PetTypeId pettype) {
    remover.remove(pettype);
  }
}
