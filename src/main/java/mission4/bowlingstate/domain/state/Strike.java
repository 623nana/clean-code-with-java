package mission4.bowlingstate.domain.state;

import mission4.bowlingstate.domain.Score;
import mission4.bowlingstate.domain.States;
import java.util.List;

public class Strike implements State {

  public static final String STRIKE_SYMBOL = "X";

  @Override
  public State bowl(int countOfHitPin) {
    throw new IllegalStateException("프레임을 진행할 수 없습니다.");
  }

  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public List<String> state() {
    States states = new States();
    states.add(STRIKE_SYMBOL);
    return states.states();
  }

  @Override
  public Score of() {
    return Score.ofStrike();
  }
}
