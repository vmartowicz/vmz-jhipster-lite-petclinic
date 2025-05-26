package com.petclinic.domain;

import java.util.HashSet;
import java.util.Set;

public class Specialty {

  private Long id;
  private String name;

  private Set<Vet> vets = new HashSet<>();
}
