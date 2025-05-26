package com.petclinic.account.domain;

import static com.petclinic.shared.useridentity.domain.UsersIdentitiesFixture.*;

import com.petclinic.shared.authentication.domain.Role;
import java.util.List;

public final class AccountsFixture {

  private AccountsFixture() {}

  public static Account account() {
    return Account.builder()
      .username(username())
      .firstname(firstname())
      .lastname(lastname())
      .email(email())
      .roles(List.of(Role.ADMIN.key()))
      .build();
  }
}
