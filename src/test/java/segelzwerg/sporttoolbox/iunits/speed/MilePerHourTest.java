package segelzwerg.sporttoolbox.iunits.speed;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttoolbox.iunits.Time;
import segelzwerg.sporttoolbox.iunits.distance.Distance;
import segelzwerg.sporttoolbox.iunits.distance.Miles;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MilePerHourTest {

    private static final float THIRTY_MILES_PER_HOUR = 30f;
    private static Speed thirtyMilesPerHour;

    /**
     * Set up before all tests
     * Initialization of static Speed thirtyMilesPerHour
     */
    @BeforeAll
    public static void setUp() {
        thirtyMilesPerHour = new MilePerHour(THIRTY_MILES_PER_HOUR);
    }

    /**
     * toKilometerPerHour
     * Speed: thirtyMilesPerHour
     * Expected Speed: 48.28032
     *
     * @result 48.28032km/h is the same as 30mph
     */
    @Test
    public void toKilometerPerHour() {

        Speed convertedSpeed = thirtyMilesPerHour.toKilometerPerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(48.28032f));
    }

    /**
     * toMeterPerSecond
     * Speed: thirtyMilesPerHour
     * Expected Speed: 13.411201
     *
     * @result 13.411201m/s is the same as 30mph
     */
    @Test
    public void toMeterPerSecond() {
        Speed convertedSpeed = thirtyMilesPerHour.toMeterPerSecond();

        assertThat(convertedSpeed.getSpeed(), equalTo(13.411201F));
    }

    /**
     * toMilePerHour
     * Speed: thirtyMilesPerHour
     * Expected Speed: thirtyMilesPerHour
     *
     * @result thirtyMilesPerHour returns itself
     */
    @Test
    public void toMilePerHour() {
        Speed convertedSpeed = thirtyMilesPerHour.toMilePerHour();

        assertThat(convertedSpeed, is(thirtyMilesPerHour));
    }

    /**
     * toKnot
     * Speed: thirtyMilesPerHour
     * Expected Speed: 26.069286
     *
     * @result 26.069286kn is the same as 30mph
     */
    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyMilesPerHour.toKnot();

        assertThat(convertedSpeed.getSpeed(), equalTo(26.069286F));
    }

    /**
     * negative Input
     * Speed: -1 mph
     *
     * @expected IllegalArgumentException
     */
    @Test
    public void negativeInput() {
        assertThrows(IllegalArgumentException.class, () -> new MilePerHour(-1));
    }

    /**
     * tests calculating a time needed for given a distance
     * Speed: 6.19 mph
     * Distance: 13.78 miles
     */
    @Test
    public void computeTime() {
        MilePerHour milesPerHour = new MilePerHour((float) 6.19);
        Time time = milesPerHour.computeTime(13, (float) (0.780 * Distance.MILES_TO_YARDS));

        Time expectedTime = new Time(2, 13, 34);

        assertThat(time, equalTo(expectedTime));
    }

    @Test
    public void computeDistance() {
        MilePerHour milePerHour = new MilePerHour(34.56f);
        Time time = new Time(1, 23, 45);
        Miles expectedDistance = new Miles(48.24f);

        Distance distance = milePerHour.computeDistance(time);

        Assertions.assertThat(distance).isEqualToComparingFieldByField(expectedDistance);

    }
}
