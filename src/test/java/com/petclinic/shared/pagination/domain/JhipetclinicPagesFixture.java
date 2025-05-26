package com.petclinic.shared.pagination.domain;

import com.petclinic.shared.pagination.domain.JhipetclinicPage.JhipetclinicPageBuilder;
import java.util.List;

public final class JhipetclinicPagesFixture {

  private JhipetclinicPagesFixture() {}

  public static JhipetclinicPage<String> page() {
    return pageBuilder().build();
  }

  public static JhipetclinicPageBuilder<String> pageBuilder() {
    return JhipetclinicPage.builder(List.of("test")).currentPage(2).pageSize(10).totalElementsCount(21);
  }
}
