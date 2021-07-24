package mission2.lotto.domain;

import java.util.List;

public class Lottos {

  private final List<LottoNumbers> lottos;

  public Lottos(Amount amount, ManualNumbers manualNumbers) {
    this.lottos = LottoStore.generateLottos(amount, manualNumbers);
  }

  public List<LottoNumbers> getLottos() {
    return lottos;
  }

}
