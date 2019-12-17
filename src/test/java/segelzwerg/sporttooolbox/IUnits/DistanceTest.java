package segelzwerg.sporttooolbox.IUnits;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests the Distance class
 */
public class DistanceTest {
    /**
     * Test 1
     * Distance: 30km and 2002m
     * Expected Distance: 32km and 2m
     *
     * @result 30km and 2002m is the same as 32km and 2m
     */
    @Test
    public void overflow_test() {
        Distance thirtyKM_twoThousandTwoMeter = new Distance(30, 2002);
        Distance expectedDistance = new Distance(32, 2);

        assertThat(thirtyKM_twoThousandTwoMeter, equalTo(expectedDistance));
    }

    /**
     * Test 2
     * Distance: 30km and 999m plus 0km and 1m
     * Expected Distance: 31km
     *
     * @result the result is 31
     */
    @Test
    public void add_distance_test() {
        Distance thirtyKilometer = new Distance(30, 999);
        Distance thirtyonekilometer = thirtyKilometer.addDistance(new Distance(0, 1));

        Distance expected = new Distance(31, 0);

        assertThat(thirtyonekilometer, equalTo(expected));
    }

    /**
     * Test 3
     * Distance: 60km
     * Time: 2hrs
     * Expected Speed: 30km/hr
     *
     * @result the result is 30
     */
    @Test
    public void sixty_kilometer_two_hour_test_speed() {
        Distance tenKilometer = new Distance(60);
        Time twoHours = new Time(2);
        Speed expectedSpeed = new KilometerPerHour(30);
        Speed speed = tenKilometer.computeSpeed(twoHours);

        assertThat(speed, equalTo(expectedSpeed));
    }

    /**
     * Test 4
     * Distance: -1km
     * Expected: IllegalArgumentException
     */

    @Test
    public void negative_distance() {
        assertThrows(IllegalArgumentException.class, () -> new Distance(-1));
    }


    /**
     * Test 5
     * Distance 30 miles
     * Expected: 48.28032 km
     */
    @Test
    void inti_with_miles() {
        int mile = 30;
        String milesUnit = "miles";
        Distance expectedDistance = new Distance((float) 48.28032);

        Distance distance = Distance.createWithMajorUnit(mile, milesUnit);

        assertThat(distance, equalTo(expectedDistance));
    }

    /**
     * Test 6
     * Distance 30 miles 200 yards
     * Expected: 48.28032 km + 0,18288km
     */
    @Test
    void inti_with_miles_and_yards() {
        int mile = 30;
        int yard = 200;
        String milesUnit = "miles";
        String yardsUnit = "yards";
        Distance expectedDistance = new Distance((float) 48.28032, (float) 182.88);

        Distance distance = Distance.createWithOtherThanSIUnits(mile, yard, milesUnit, yardsUnit);

        assertThat(distance, equalTo(expectedDistance));
    }
}
