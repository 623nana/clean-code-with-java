package mission1.racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import mission1.racingcar.exception.CarNameException;
import mission1.racingcar.domain.Name;

public class NameTest {

  @ParameterizedTest(name = "[Name] validateName 테스트 - {index}")
  @ValueSource(strings = {"", "abcdef", "abcdefg"})
  void validateNameTest(String input) {
    assertThatThrownBy(() -> {
      new Name(input);
    }).isInstanceOf(CarNameException.class);
  }
}
