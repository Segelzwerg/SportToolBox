package segelzwerg.sporttooolbox.IUnits;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MilePerHourTest {

    private static final float THIRTY_MILES_PER_HOUR = 30f;
    private static Speed thirtyMilesPerHour;

    @BeforeClass
    public static void setUp() {
        thirtyMilesPerHour = new MilePerHour(THIRTY_MILES_PER_HOUR);
    }

    /**
     * toKilometerPerHour
     * Speed: thirtyMilesPerHour
     * Expected Speed: 48.28032
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
     * @result 26.069286kn is the same as 30mph
     */
    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyMilesPerHour.toKnot();

        assertThat(convertedSpeed.getSpeed(), equalTo(26.069286F));
    }
}