package com.petclinic.vet.domain;

import java.util.HashSet;
import java.util.Set;

public class Vet {

  private Long id;
  private String firstName;
  private String lastName;
  private boolean isPersisted;
  private Set<Specialty> specialties = new HashSet<>();
}
