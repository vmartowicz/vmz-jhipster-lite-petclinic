package com.petclinic.owner.domain;

import com.petclinic.owner.domain.pettype.PetType;
import java.time.LocalDate;
import java.time.Period;

// Entités du domaine
public class Pet {

  private Long id;
  private String name;
  private LocalDate birthDate;
  private PetType type;
  private Owner owner;

  public Pet(String name, LocalDate birthDate, PetType type, Owner owner) {
    this.name = name;
    this.birthDate = birthDate;
    this.type = type;
    this.owner = owner;
  }

  // Logique métier
  public int getAge() {
    return Period.between(birthDate, LocalDate.now()).getYears();
  }

  public boolean isAdult() {
    return getAge() >= 1;
  }

  // Getters/Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public PetType getType() {
    return type;
  }

  public void setType(PetType type) {
    this.type = type;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
  }
}
