package com.petclinic.infrastrucutre.secondary.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "vets")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class VetEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
  @SequenceGenerator(name = "sequenceGenerator")
  @Column(name = "id")
  private Long id;

  @NotNull
  @Size(max = 30)
  @Column(name = "first_name", length = 30, nullable = false)
  private String firstName;

  @NotNull
  @Size(max = 30)
  @Column(name = "last_name", length = 30, nullable = false)
  private String lastName;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "rel_vets__specialties",
    joinColumns = @JoinColumn(name = "vets_id"),
    inverseJoinColumns = @JoinColumn(name = "specialties_id")
  )
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  @JsonIgnoreProperties(value = { "vets" }, allowSetters = true)
  private Set<SpecialtyEntity> specialties = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public VetEntity id(Long id) {
    this.setId(id);
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public VetEntity firstName(String firstName) {
    this.setFirstName(firstName);
    return this;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public VetEntity lastName(String lastName) {
    this.setLastName(lastName);
    return this;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<SpecialtyEntity> getSpecialties() {
    return this.specialties;
  }

  public void setSpecialties(Set<SpecialtyEntity> specialties) {
    this.specialties = specialties;
  }

  public VetEntity specialties(Set<SpecialtyEntity> specialties) {
    this.setSpecialties(specialties);
    return this;
  }

  public VetEntity addSpecialties(SpecialtyEntity specialty) {
    this.specialties.add(specialty);
    return this;
  }

  public VetEntity removeSpecialties(SpecialtyEntity specialty) {
    this.specialties.remove(specialty);
    return this;
  }
}
