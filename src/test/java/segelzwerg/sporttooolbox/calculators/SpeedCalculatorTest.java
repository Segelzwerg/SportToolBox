package segelzwerg.sporttooolbox.calculators;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Distance;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerHundredMeters;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

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
     *
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
     *
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

    /**
     * Use Case 3
     * Distance: 1 km
     * Time: 1 hour, 1 minute and 3 seconds
     * Expected Pace: 61.05 min / km
     *
     * @result the computed result is 61.05
     */
    @Test
    public void one_kilometer_ran_through_one_hour_one_minute_and_three_seconds_should_generate_sixty_one_dot_zero_five_minutes_per_kilometer() {
        Distance distance = new Distance(1);
        Time time = new Time(1, 1, 3);
        SpeedCalculator speedCalculator = new SpeedCalculator(distance, time);
        Pace expectedPace = new MinutesPerKilometer(61.05f);

        Pace pace = speedCalculator.computePace();

        assertThat(pace, equalTo(expectedPace));
    }

    /**
     * Use Case 4
     * Distance: 1 km
     * Time: 1 hour, 1 minute and 3 seconds
     * Expected Pace: 6.105 min / 100m
     *
     * @result the converted result is 6.105
     */
    @Test
    public void converting_minutes_per_kilometer_to_minutes_per_hundred_meters_should_work() {
        Distance distance = new Distance(1);
        Time time = new Time(1, 1, 3);
        SpeedCalculator speedCalculator = new SpeedCalculator(distance, time);
        Pace expectedPace = new MinutesPerHundredMeters(6.105f);

        Pace pace = speedCalculator.computePace().toMinutesPerHundredMeters();

        assertThat(pace, equalTo(expectedPace));
    }

    /**
     * Use Case 5
     * Distance: 1 km
     * Time: 1 hour, 1 minute and 3 seconds
     * Expected Pace: 61.05 min / km
     *
     * @result the converted result is 61.05
     */
    @Test
    public void converting_minutes_per_hundred_meters_to_minutes_per_kilometers_should_work() {
        Pace expectedPace = new MinutesPerKilometer(61.05f);
        Pace pace = new MinutesPerHundredMeters(6.105f).toMinutesPerKilometer();

        assertThat(pace, equalTo(expectedPace));
    }
}
