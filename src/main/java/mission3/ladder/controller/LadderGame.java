package mission3.ladder.controller;

import mission3.ladder.domain.LadderResult;
import mission3.ladder.domain.Ladder;
import mission3.ladder.domain.store.NameStore;
import mission3.ladder.domain.Players;
import mission3.ladder.domain.Results;
import mission3.ladder.domain.store.ResultStore;
import mission3.ladder.view.InputView;
import mission3.ladder.view.ResultView;

public class LadderGame {

  public void run() {
    Players players = new Players(NameStore.createPlayers(InputView.inputPlayerName()));
    Ladder ladder = new Ladder(players, InputView.inputHeight());

    Results results = new Results(ResultStore.createResult(InputView.inputResult(), players));
    ResultView.showPlayers(players);
    ResultView.showLadder(ladder, results);

    LadderResult ladderResult = new LadderResult(ladder, results);
    ladderResult.result(players);

    String resultName = InputView.inputResultOfPerson();
    while (!"all".equals(resultName)) {
      ResultView.showResultOfPerson(results, resultName);
      resultName = InputView.inputResultOfPerson();
    }
    ResultView.showResultAll(results);
  }
}
