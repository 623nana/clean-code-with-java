package mission1.racingcar;

import mission1.racingcar.controller.RacingGame;
import mission1.racingcar.view.InputView;

public class Main {

  public static void main(String[] args) {
    RacingGame racingGame = new RacingGame();
    racingGame.readyGame(InputView.inputNameOfCars());
    racingGame.run(InputView.inputNumOfAttempt());
  }
}
