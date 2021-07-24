package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;

import mission4.bowling.domain.ScoreSymbol;
import mission4.bowling.domain.States;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatesTest {

  @Test
  @DisplayName("[States] 핀의 상태로 현재 해당 프레임의 상태 및 점수를 추가")
  void states_add_test() {
    States states = new States();
    states.add(ScoreSymbol.STRIKE.mark());

    int size = states.states().size();

    assertThat(size).isEqualTo(1);
  }
}
