package segelzwerg.sporttooolbox;

import org.junit.Test;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SpeedCalculatorTest {
    @Test
    public void thirty_kilometer_one_hour_test_speed() {
        Distance thirtyKilometer = new Distance(30);
        Time oneHour = new Time(1);
        SpeedCalculator speedCalculator = new SpeedCalculator(thirtyKilometer, oneHour);
        Speed expectedSpeed = new Speed(30);

        Speed speed = speedCalculator.computeSpeed();

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void fifteen_kilometer_half_hour_test_speed() {
        Distance thirtyKilometer = new Distance(15);
        Time halfAnHour = new Time(0, 30);
        SpeedCalculator speedCalculator = new SpeedCalculator(thirtyKilometer, halfAnHour);
        Speed expectedSpeed = new Speed(30);

        Speed speed = speedCalculator.computeSpeed();

        assertThat(speed, equalTo(expectedSpeed));
    }
}