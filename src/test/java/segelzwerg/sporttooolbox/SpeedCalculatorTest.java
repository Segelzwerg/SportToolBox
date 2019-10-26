package segelzwerg.sporttooolbox;

import org.junit.Test;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * The SpeedCalculatorTest runs on a fest tests:
 * What is the speed when the distance 30 km for one hour?
 * What is the speed when the distance 15 km for half an hour?
 */
public class SpeedCalculatorTest {
    /**
     * Use Case 1
     * Distance: 30 km
     * Time: 1 hour
     * Expected Speed: 30 km / hour
     * @result the result of computeSpeed() is 30
     */
    @Test
    public void thirty_kilometer_one_hour_test_speed() {
        Distance thirtyKilometer = new Distance(30);
        Time oneHour = new Time(1);
        SpeedCalculator speedCalculator = new SpeedCalculator(thirtyKilometer, oneHour);
        Speed expectedSpeed = new KilometerPerHour(30);

        Speed speed = speedCalculator.computeSpeed();

        assertThat(speed, equalTo(expectedSpeed));
    }

    /**
     * Use Case 2
     * Distance: 15 km
     * Time: 0.5 hour
     * Expected Speed: 30 km / hour
     * @result the result of computeSpeed() is 30
     */
    @Test
    public void fifteen_kilometer_half_hour_test_speed() {
        Distance thirtyKilometer = new Distance(15);
        Time halfAnHour = new Time(0, 30);
        SpeedCalculator speedCalculator = new SpeedCalculator(thirtyKilometer, halfAnHour);
        Speed expectedSpeed = new KilometerPerHour(30);

        Speed speed = speedCalculator.computeSpeed();

        assertThat(speed, equalTo(expectedSpeed));
    }
}