package mission4.bowlingstate.domain.state;

import mission4.bowlingstate.domain.Score;
import java.util.List;

public interface State {

  State bowl(int countOfHitPin);

  boolean isFinished();

  List<String> state();

  Score of();
}
