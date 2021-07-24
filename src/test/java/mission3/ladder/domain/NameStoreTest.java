package mission3.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import mission3.ladder.domain.store.NameStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameStoreTest {

  @Test
  @DisplayName("[NameStore] 입력 받은 텍스트 Name 리스트로 반환하는 기능 테스트")
  void inputNamesToListTest() {
    String inputNames = "pobi,crong,honux";
    int size = NameStore.createPlayers(inputNames).size();

    assertThat(size).isEqualTo(3);
  }

  @Test
  @DisplayName("[NameStore] 입력 값 검증 테스트")
  void validateInputNamesTest() {
    String inputNames = null;

    assertThatThrownBy(() -> NameStore.createPlayers(inputNames))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[NameStore] 최소 참가자 검증 테스트")
  void validateMinPlayersTest() {
    String inputNames = "pobi";

    assertThatThrownBy(() -> NameStore.createPlayers(inputNames))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
