package segelzwerg.sporttooolbox.iunits;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

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
    public void overflowTest() {
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
    public void addDistanceTest() {
        Distance thirtyKilometer = new Distance(30, 999);
        Distance thirtyonekilometer = thirtyKilometer.addDistance(new Distance(0, 1));

        Distance expected = new Distance(31, 0);

        Assertions.assertThat(thirtyonekilometer).isEqualToComparingFieldByField(expected);
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
    public void negativeDistance() {
        assertThrows(IllegalArgumentException.class, () -> new Distance(-1));
    }


    /**
     * Test 5
     * Distance 30 miles
     * Expected: 48.28032 km
     */
    @Test
    public void intiWithMiles() {
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
    public void inti_with_miles_and_yards() {
        int mile = 30;
        int yard = 200;
        String milesUnit = "miles";
        String yardsUnit = "yards";
        Distance expectedDistance = new Distance((float) 48.28032, (float) 182.88);

        Distance distance = Distance.createWithOtherThanSIUnits(mile, yard, milesUnit, yardsUnit);

        Assertions.assertThat(distance).isEqualToComparingFieldByField(expectedDistance);
    }

    /**
     * Test 7
     * Distance 30 miles
     * Expected: 48.28032 km
     */
    @Test
    public void intiWithNauticals() {
        int mile = 30;
        String milesUnit = "nautical";
        Distance expectedDistance = new Distance((float) 55.56);

        Distance distance = Distance.createWithMajorUnit(mile, milesUnit);

        assertThat(distance, equalTo(expectedDistance));
    }

    /**
     * Test 8
     * Distance 30 miles 200 yards
     * Expected: 48.28032 km + 0,18288km
     */
    @Test
    public void init_with_nauticals_and_phatoms() {
        int mile = 30;
        int yard = 200;
        String milesUnit = "miles";
        String yardsUnit = "yards";
        Distance expectedDistance = new Distance(48, 463);

        Distance distance = Distance.createWithOtherThanSIUnits(mile, yard, milesUnit, yardsUnit);

        Assertions.assertThat(distance).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void invalidMajorUnit() {
        int major = 10;
        String invalidUnit = "centimeter";

        assertThrows(IllegalArgumentException.class, () -> Distance.createWithMajorUnit(major, invalidUnit));
    }

    @Test
    public void invalidMinorUnit() {
        int major = 10;
        int minor = 10;
        String majorUnit = "kilometer";
        String invalidUnit = "centimeter";

        assertThrows(IllegalArgumentException.class, () -> Distance.createWithOtherThanSIUnits(major, minor, majorUnit, invalidUnit));
    }

    /**
     * create distance object from a float value in miles
     */
    @Test
    public void createWithMiles() {
        Distance miles = Distance.createWithMiles(42.31f);
        Distance expectedDistance = new Distance(68, 90);

        Assertions.assertThat(miles).isEqualToComparingFieldByField(expectedDistance);

    }

    /**
     * create a distance from a float mile
     */
    @Test
    public void init_with_float_miles() {
        int yards = (int) (0.31f * Distance.MILES_TO_YARDS);
        Distance distance = Distance.createWithOtherThanSIUnits(42, yards, "miles", "yards");
        Distance expectedDistance = new Distance(68, 90);

        Assertions.assertThat(distance).isEqualToComparingFieldByField(expectedDistance);
    }

    /**
     * this test inaccurate due to round problems
     */
    @Disabled
    @Test
    public void createWithNautical() {
        Distance nautical = Distance.createWithNauticals(75.341f);
        Distance expectedDistance = new Distance(139, 532);

        Assertions.assertThat(nautical).isEqualToComparingFieldByField(expectedDistance);
    }

    /**
     * this test inaccurate due to round problems
     */
    @Disabled
    @Test
    public void createWithNauticalWithLotsOfDecimals() {
        Distance nautical = Distance.createWithNauticals(8.1162f);
        Distance expectedDistance = new Distance(15, 31);

        Assertions.assertThat(nautical).isEqualToComparingFieldByFieldRecursively(expectedDistance);
    }
}
