package mission3.ladder.util;

public class InputValidator {

  public static boolean isEmptyOrBlank(String input) {
    return isEmpty(input) || isBlank(input);
  }

  public static boolean isEmpty(String input) {
    return "".equals(input);
  }

  public static boolean isBlank(String input) {
    return input == null;
  }

}
