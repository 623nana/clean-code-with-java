package mission4.bowling.domain.frame;

import mission4.bowling.domain.Score;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Frames {

  private static final int FINAL_ROUND = 10;
  private final List<Frame> frames;
  private List<Integer> scores;

  public Frames(List<Frame> frames) {
    this.frames = frames;
    this.scores = new ArrayList<>();
  }

  public static Frames init() {
    List<Frame> frames = normalFrames();
    frames.add(FinalFrame.of());
    return new Frames(frames);
  }

  private static List<Frame> normalFrames() {
    return IntStream.range(0, 9)
        .mapToObj(i -> new NormalFrame())
        .collect(Collectors.toList());
  }

  public void throwBall(int countOfHitPin, int currFrame) {
    Frame frame = frames.get(currFrame);
    frame.play(countOfHitPin);

    calculateScore(countOfHitPin);
    if (frame.isEndFrame()) {
      frame.initScore();
    }
  }

  private void calculateScore(int countOfPins) {
    frames.stream()
        .filter(Frame::hasScore)
        .map(frame -> frame.score)
        .filter(score -> !score.canCalculateScore())
        .forEach(score -> score.bowl(countOfPins));
  }

  public List<Integer> frameScores() {
    this.scores = new ArrayList<>();
    IntStream.range(0, FINAL_ROUND)
        .forEach(i -> addScore(frames.get(i), i));
    return scores;
  }

  private void addScore(Frame frame, int index) {
    Score score = frame.score;
    if (frame.hasScore() && score.canCalculateScore()) {
      scores.add(accumulateScores(index));
    }
  }

  private int accumulateScores(int index) {
    return frames.stream()
        .limit(index + 1)
        .mapToInt(frame -> frame.score.getScore())
        .sum();
  }

  public boolean isEndFrame(int currFrame) {
    return frames.get(currFrame).isEndFrame();
  }

  public List<Frame> frames() {
    return Collections.unmodifiableList(frames);
  }
}
