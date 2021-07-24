package mission4.bowling.controller;

import mission4.bowling.domain.player.Player;
import mission4.bowling.domain.player.Players;
import mission4.bowling.view.InputView;
import mission4.bowling.view.ResultView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BowlingController {

  private static final int FINAL_ROUND = 10;

  public void run() {
    Players players = new Players(initPlayers());
    ResultView.showScoreBoard(players);

    IntStream.range(0, FINAL_ROUND)
        .forEach(i -> play(players, i));
  }

  private List<Player> initPlayers() {
    int countOfPlayer = InputView.inputCountOfPlayer();

    return IntStream.range(0, countOfPlayer)
        .mapToObj(i -> new Player(InputView.inputOfPlayerName(i)))
        .collect(Collectors.toList());
  }

  private void play(Players players, int currFrame) {
    players.players().forEach(
        player -> playEachPlayer(players, player, currFrame)
    );
  }

  private void playEachPlayer(Players players, Player player, int currFrame) {
    while (!player.isEndFrame(currFrame)) {
      player.throwBall(InputView.inputCountOfHitPin(player.name()), currFrame);
      ResultView.showScoreBoard(players);
    }
  }
}
