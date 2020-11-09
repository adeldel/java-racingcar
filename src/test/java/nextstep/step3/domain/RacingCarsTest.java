package nextstep.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
	@Test
	@DisplayName("자동차수만큼 레이싱카를 만든다.")
	public void racingCarsTest() {
		RacingCars racingCars = new RacingCars(Arrays.asList("adel","joy","ruby"));
		assertThat(racingCars.getRacingCars().size()).isEqualTo(3);
	}
}
