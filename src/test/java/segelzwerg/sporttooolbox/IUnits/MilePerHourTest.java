package segelzwerg.sporttooolbox.IUnits;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MilePerHourTest {

    private static final float THIRTY_MILES_PER_HOUR = 30f;
    private static Speed thirtyMilesPerHour;

    /**
     * Set up before all tests
     * Initialization of static Speed thirtyMilesPerHour
     */
    @BeforeClass
    public static void setUp() {
        thirtyMilesPerHour = new MilePerHour(THIRTY_MILES_PER_HOUR);
    }

    /**
     * toKilometerPerHour
     * Speed: thirtyMilesPerHour
     * Expected Distance: 32km and 2m
     * @result 30km and 2002m is the same as 32km and 2m
     */
    @Test
    public void toKilometerPerHour() {

        Speed convertedSpeed = thirtyMilesPerHour.toKilometerPerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(48.28032f));
    }

    /**
     * toMeterPerSecond
     * Speed: thirtyMilesPerHour
     * Expected Distance: 32km and 2m
     * @result 30km and 2002m is the same as 32km and 2m
     */
    @Test
    public void toMeterPerSecond() {
        Speed convertedSpeed = thirtyMilesPerHour.toMeterPerSecond();

        assertThat(convertedSpeed.getSpeed(), equalTo(13.411201F));
    }

    /**
     * toMilePerHour
     * Speed: thirtyMilesPerHour
     * Expected Distance: 32km and 2m
     * @result 30km and 2002m is the same as 32km and 2m
     */
    @Test
    public void toMilePerHour() {
        Speed convertedSpeed = thirtyMilesPerHour.toMilePerHour();

        assertThat(convertedSpeed, is(thirtyMilesPerHour));
    }

    /**
     * toKnot
     * Speed: thirtyMilesPerHour
     * Expected Distance: 32km and 2m
     * @result 30km and 2002m is the same as 32km and 2m
     */
    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyMilesPerHour.toKnot();

        assertThat(convertedSpeed.getSpeed(), equalTo(26.069286F));
    }
}