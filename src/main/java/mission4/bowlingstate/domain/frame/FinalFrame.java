package mission4.bowlingstate.domain.frame;

import mission4.bowlingstate.domain.Pin;
import mission4.bowlingstate.domain.Score;
import mission4.bowlingstate.domain.state.Ready;
import mission4.bowlingstate.domain.state.State;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FinalFrame extends Frame {

  private static final int FINAL_FRAME_MAX_SIZE = 3;
  private static final int BONUS_MIN_PIN_COUNT = 10;
  private static final int FINAL_MAX_PIN_COUNT = 30;
  private static final int SECOND_ROUND = 2;
  private final LinkedList<State> states = new LinkedList<>();

  public FinalFrame() {
    states.add(new Ready());
  }

  public static FinalFrame of() {
    return new FinalFrame();
  }

  public List<String> frameState() {
    List<String> frameState = new ArrayList<>();
    states.forEach(state -> frameState.addAll(state.state()));
    return frameState;
  }

  protected void validateHitPin(int countOfHitPin) {
    if (pins.totalHitPin() + countOfHitPin > FINAL_MAX_PIN_COUNT) {
      throw new IllegalArgumentException("핀의 갯수는 " + FINAL_MAX_PIN_COUNT + "개를 넘을 수 없습니다.");
    }
  }

  public void play(int countOfHitPin) {
    validateHitPin(countOfHitPin);
    pins.add(new Pin(countOfHitPin));

    State currState = states.getLast();
    if (currState.isFinished()) {
      states.add(new Ready());
    }
    currState = states.getLast();
    states.removeLast();
    states.add(currState.bowl(countOfHitPin));
  }

  public void initScore() {
    score = new Score(pins.totalHitPin(), 0);
  }

  public boolean isEndFrame() {
    if (pins.size() == SECOND_ROUND) {
      return pins.totalHitPin() < BONUS_MIN_PIN_COUNT;
    }
    return pins.size() >= FINAL_FRAME_MAX_SIZE;
  }
}
