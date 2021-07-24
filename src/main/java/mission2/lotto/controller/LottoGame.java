package mission2.lotto.controller;

import mission2.lotto.domain.Amount;
import mission2.lotto.domain.HitNumbers;
import mission2.lotto.domain.LotteryMachine;
import mission2.lotto.domain.Lottos;
import mission2.lotto.domain.ManualNumbers;
import mission2.lotto.view.InputView;
import mission2.lotto.view.ResultView;

public class LottoGame {

  public void run() {
    Amount amount = new Amount(InputView.inputPriceOfBuy(), InputView.inputManualBuy());
    ManualNumbers manualNumbers = new ManualNumbers(InputView.inputManualNumbers(amount));
    Lottos lottos = new Lottos(amount, manualNumbers);

    ResultView.showAmountOfLotto(amount);
    ResultView.showLottoNumbers(lottos);

    HitNumbers hitNumbers = new HitNumbers(InputView.inputPrizeNumber(),
        InputView.inputBonusNumber());
    LotteryMachine lottery = new LotteryMachine(hitNumbers);
    lottery.draw(lottos);

    ResultView.showLotteryResult(lottery, amount);
  }
}
