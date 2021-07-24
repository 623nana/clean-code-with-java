package bowlingstate.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import mission4.bowlingstate.domain.frame.FinalFrame;
import mission4.bowlingstate.domain.frame.Frame;
import mission4.bowlingstate.domain.frame.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrameTest {

  @Test
  @DisplayName("[Frame] NormalFrame 전체 투구 합쳐 10핀이 넘을 경우 예외 발생 테스트")
  void validate_normal_frame_test() {
    Frame frame = new NormalFrame();
    frame.play(5);
    assertThatThrownBy(() -> frame.play(6))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("[Frame] NormalFrame 프레임이 끝났는지 판정 테스트")
  void normal_frame_end_test() {
    Frame frame = new NormalFrame();
    frame.play(10);
    assertThat(frame.isEndFrame()).isTrue();
  }

  @Test
  @DisplayName("[Frame] FinalFrame 프레임이 끝났는지 판정 테스트")
  void final_frame_end_test() {
    Frame frame = FinalFrame.of();
    frame.play(5);
    frame.play(4);
    assertThat(frame.isEndFrame()).isTrue();
  }

  @Test
  @DisplayName("[Frame] FinalFrame 프레임 보너스 투구 가능한지 판정 테스트")
  void final_frame_bonus_test() {
    Frame frame = FinalFrame.of();
    frame.play(10);
    frame.play(10);
    assertThat(frame.isEndFrame()).isFalse();
  }
}
