package nextstep.step3;

import nextstep.step3.domain.RacingCars;
import nextstep.step3.domain.RandomGenerator;
import nextstep.step3.view.InputView;
import nextstep.step3.view.ResultView;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingCarGame {
	public static void main(String[] args) {
		InputView inputView = new InputView(new Scanner(System.in));
		startGame(inputView.getInputMessageCarNumber(), inputView.getInputMessageTryNumber());
	}

	protected static void startGame(int carNumber, int tryNumber) {
		validate(carNumber, tryNumber);
		RacingCars racingCars = new RacingCars(carNumber);
		tryRacing(tryNumber, racingCars);
	}

	private static void validate(int carNumber, int tryNumber) {
		if (carNumber < 0 || tryNumber < 0) {
			throw new IllegalArgumentException("입력값은 양수이어야 합니다.");
		}
	}

	private static void tryRacing(int tryNumber, RacingCars racingCars) {
		System.out.println("실행 결과");
		IntStream.range(0, tryNumber).forEach(i ->  {
			racingCarMove(racingCars);
			printRacingResult(racingCars);
		});
	}

	private static void racingCarMove(RacingCars racingCars) {
		RandomGenerator randomGenerator = new RandomGenerator();
		racingCars.getRacingCars().forEach( car -> {
			car.move(randomGenerator.getRandomNumber());
		});
	}

	private static void printRacingResult(RacingCars racingCars) {
		ResultView resultView = new ResultView();
		resultView.showRacingResult(racingCars);
	}
}
