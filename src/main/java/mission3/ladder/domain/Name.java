package mission3.ladder.domain;

import java.util.Objects;

public class Name {

  private static final int MAX_NAME_LENGTH = 5;
  private final String name;

  public Name(String name) {
    validateName(name.trim());
    this.name = name.trim();
  }

  public String getName() {
    return name;
  }

  private void validateName(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Name name1 = (Name) o;

    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
