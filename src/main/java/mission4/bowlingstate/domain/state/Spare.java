package mission4.bowlingstate.domain.state;

import mission4.bowlingstate.domain.Score;
import mission4.bowlingstate.domain.States;
import java.util.List;

public class Spare implements State {

  private static final String GUTTER_SYMBOL = "-";
  private static final String SPARE_SYMBOL = "/";
  private static final int GUTTER_PIN_COUNT = 0;
  private final int firstPin;
  private final int secondPin;

  public Spare(int firstPin, int secondPin) {
    this.firstPin = firstPin;
    this.secondPin = secondPin;
  }

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
    states.add(eachState(firstPin));
    states.add(SPARE_SYMBOL);
    return states.states();
  }

  @Override
  public Score of() {
    return Score.ofSpare();
  }

  private String eachState(int countOfHitPin) {
    if (countOfHitPin == GUTTER_PIN_COUNT) {
      return GUTTER_SYMBOL;
    }
    return String.valueOf(countOfHitPin);
  }
}
