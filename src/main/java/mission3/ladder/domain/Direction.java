package mission3.ladder.domain;

import static java.lang.Boolean.FALSE;

import java.util.Objects;

public class Direction {

  private final boolean left;
  private final boolean right;

  private Direction(boolean left, boolean right) {
    if (left && right) {
      throw new IllegalStateException();
    }
    this.left = left;
    this.right = right;
  }

  public boolean isRight() {
    return this.right;
  }

  public boolean isLeft() {
    return this.left;
  }

  public Direction next(boolean nextRight) {
    return of(this.right, nextRight);
  }

  public Direction next(ConnectStrategy connectStrategy) {
    if (this.right) {
      return next(FALSE);
    }
    return next(connectStrategy.connect());
  }

  public static Direction of(boolean first, boolean second) {
    return new Direction(first, second);
  }

  public static Direction first(boolean right) {
    return of(FALSE, right);
  }

  public Direction last() {
    return of(this.right, FALSE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Direction pair = (Direction) o;
    return left == pair.left &&
        right == pair.right;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }

  @Override
  public String toString() {
    return "Direction{" +
        "left=" + left +
        ", right=" + right +
        '}';
  }
}
