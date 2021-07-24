package mission1.racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import mission1.racingcar.controller.Movement;
import mission1.racingcar.domain.Car;
import mission1.racingcar.domain.Name;

public class ResultView {

  public static void showRacingResult(List<Car> cars) {
    cars.stream()
        .map(car -> car.getName() + " : " + Movement.trackingMovement(car.getPosition(), "-"))
        .forEach(System.out::println);
    System.out.println();
  }

  public static void showWinnerName(List<Car> cars) {
    System.out.println(
        cars.stream().map(Car::getName).map(Name::toString).collect(Collectors.joining(", "))
            + "가 최종 우승했습니다.");

  }
}
