package mission2.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mission2.lotto.domain.Hit;
import mission2.lotto.domain.HitNumbers;
import mission2.lotto.domain.LottoNumber;
import mission2.lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HitTest {

  @Test
  @DisplayName("[Hit] 당첨 번호 갯수 count 테스트")
  void countHitTest() {
    List<LottoNumber> numbers = IntStream.rangeClosed(1, 6)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.toList());
    LottoNumbers lottoNumbers = new LottoNumbers(numbers);
    HitNumbers hitNumbers = new HitNumbers("1, 2, 3, 4, 5, 7", 10);

    int hitCount = Hit.countHit(hitNumbers, lottoNumbers);

    assertThat(hitCount).isEqualTo(5);
  }
}
