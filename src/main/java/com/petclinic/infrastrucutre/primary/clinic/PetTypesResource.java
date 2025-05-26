package com.petclinic.infrastrucutre.primary.clinic;

import com.petclinic.application.PetClinicApplicationService;
import com.petclinic.domain.pettype.PetTypeId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "PetTypes")
@RequestMapping("/api/pet-types")
class PetTypesResource {

  private final PetClinicApplicationService pettypes;

  public PetTypesResource(PetClinicApplicationService pettypes) {
    this.pettypes = pettypes;
  }

  @PostMapping
  @Operation(summary = "Add a pet type to the clinic")
  @ApiResponse(description = "Pet type added to the clinic", responseCode = "201")
  ResponseEntity<RestPetType> addPetType(@RequestBody @Validated RestPetTypeToCreate petTypeToCreate) {
    var createdPetType = pettypes.create(petTypeToCreate.toDomain());
    return new ResponseEntity<>(RestPetType.from(createdPetType), HttpStatus.CREATED);
  }

  @GetMapping
  @Operation(summary = "Get all available pet types")
  @ApiResponse(description = "Pet Types", responseCode = "200")
  ResponseEntity<RestPetTypes> getPetTypes() {
    return ResponseEntity.ok(RestPetTypes.from(pettypes.findAllPetTypes()));
  }

  @DeleteMapping("/{pettype-id}")
  @Operation(summary = "Remove pet type from clinic")
  @ApiResponse(description = "Pet type removed from the clinic", responseCode = "200")
  void removePetType(@PathVariable("pettype-id") UUID id) {
    pettypes.remove(new PetTypeId(id));
  }
}
