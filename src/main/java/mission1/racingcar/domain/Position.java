package mission1.racingcar.domain;

public class Position {

  private int position;

  public Position(int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public void move() {
    position++;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return position;
  }
}
