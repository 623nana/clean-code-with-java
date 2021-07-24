package mission2.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import mission2.lotto.domain.Amount;
import mission2.lotto.domain.LottoNumbers;
import mission2.lotto.domain.LottoStore;
import mission2.lotto.domain.ManualNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

  @Test
  @DisplayName("[LottoStore] 수량만큼 로또 생성 테스트")
  void generateLottoTest() {
    LottoStore store = new LottoStore();
    List<LottoNumbers> lottos = store.generateLottos(new Amount(14000, 0), new ManualNumbers(new ArrayList<>()));

    int size = lottos.size();

    assertThat(size).isEqualTo(14);
  }
}
