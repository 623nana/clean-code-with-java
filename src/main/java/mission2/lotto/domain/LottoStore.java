package mission2.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

  public static List<LottoNumbers> generateLottos(Amount amount, ManualNumbers manualNumbers) {
    List<LottoNumbers> lottoNumbers = new ArrayList<>();

    lottoNumbers.addAll(generateManualLottos(manualNumbers));
    lottoNumbers.addAll(generateAutoLottos(amount));

    return lottoNumbers;
  }

  private static List<LottoNumbers> generateAutoLottos(Amount amount) {
    return IntStream.range(0, amount.getAutoAmount())
        .mapToObj(i -> new LottoNumbers())
        .collect(Collectors.toList());
  }

  private static List<LottoNumbers> generateManualLottos(ManualNumbers manualNumbers) {
    List<LottoNumbers> manualLottos = new ArrayList<>();

    for (String manualNumber : manualNumbers.manualNumbers()) {
      manualLottos.add(new LottoNumbers(manualNumber));
    }

    return manualLottos;
  }
}
