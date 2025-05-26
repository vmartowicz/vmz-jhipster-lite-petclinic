package com.petclinic.shared.kipe.application;

import static org.assertj.core.api.Assertions.*;

import ch.qos.logback.classic.Level;
import com.petclinic.Logs;
import com.petclinic.LogsSpy;
import com.petclinic.LogsSpyExtension;
import com.petclinic.UnitTest;
import com.petclinic.shared.error.domain.MissingMandatoryValueException;
import com.petclinic.shared.kipe.domain.KipeDummy;
import com.petclinic.shared.kipe.domain.KipeDummyChild;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;

@UnitTest
@ExtendWith({ MockitoExtension.class, LogsSpyExtension.class })
class AccessEvaluatorTest {

  @Mock
  private Authentication authentication;

  @Logs
  private LogsSpy logs;

  @Test
  void shouldNotBuildWithoutObjectChecker() {
    assertThatThrownBy(() -> new AccessEvaluator(List.of())).isExactlyInstanceOf(MissingMandatoryValueException.class);
  }

  @Test
  void shouldResolveOnDefaultCheckerForNullObject() {
    var canEvaluator = new AccessEvaluator(List.of(new ObjectAccessChecker()));

    boolean can = canEvaluator.can(authentication, "action", null);

    assertThat(can).isFalse();
    logs.shouldHave(Level.WARN, "using default");
  }

  @Test
  void shouldResolveOnDefaultCheckerForUnknownType() {
    var canEvaluator = new AccessEvaluator(List.of(new ObjectAccessChecker()));

    boolean can = canEvaluator.can(authentication, "action", "yo");

    assertThat(can).isFalse();
    logs.shouldHave(Level.WARN, "using default");
  }

  @Test
  void shouldGetMatchingEvaluator() {
    var canEvaluator = new AccessEvaluator(List.of(new ObjectAccessChecker(), new KipeDummyAccessChecker()));

    assertThat(canEvaluator.can(authentication, "action", new KipeDummy("authorized"))).isTrue();
  }

  @Test
  void shouldGetMatchingEvaluatorForChildClass() {
    var canEvaluator = new AccessEvaluator(List.of(new ObjectAccessChecker(), new KipeDummyAccessChecker()));

    assertThat(canEvaluator.can(authentication, "action", new KipeDummyChild("authorized"))).isTrue();
    logs.shouldHave(Level.INFO, "evaluator", 1);
  }
}
