package segelzwerg.sporttooolbox.IUnits;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MeterPerSecondTest {

    private static final float THIRTY_METERS_PER_SECOND = 30f;
    private static Speed thirtyMetersPerSecond;

    /**
     * Set up before all tests
     * Initialization of static Speed thirtyMetersPerSecond
     */
    @BeforeClass
    public static void setUp() {
        thirtyMetersPerSecond = new MeterPerSecond(THIRTY_METERS_PER_SECOND);
    }

    /**
     * toKilometerPerHour
     * Speed: thirtyMetersPerSecond
     * Expected Speed: 108.0
     * @result 30m/s = 108.0km/h
     */
    @Test
    public void toKilometerPerHour() {

        Speed convertedSpeed = thirtyMetersPerSecond.toKilometerPerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(108.0F));
    }

    /**
     * toMeterPerSecond
     * Speed: thirtyMetersPerSecond
     * Expected Speed: thirtyMetersPerSecond
     * @result thirtyMetersPerSecond return itself
     */
    @Test
    public void toMeterPerSecond() {
        Speed convertedSpeed = thirtyMetersPerSecond.toMeterPerSecond();

        assertThat(convertedSpeed, is(thirtyMetersPerSecond));
    }

    /**
     * toMilePerHour
     * Speed: thirtyMetersPerSecond
     * Expected Speed: 67.108086
     * @result 30m/s = 67.108086mph
     */
    @Test
    public void toMilePerHour() {
        Speed convertedSpeed = thirtyMetersPerSecond.toMilePerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(67.108086F));
    }

    /**
     * toKnot
     * Speed: thirtyMetersPerSecond
     * Expected Speed: 58.315334
     * @result 30m/s = 58.315334kn
     */
    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyMetersPerSecond.toKnot();

        assertThat(convertedSpeed.getSpeed(), equalTo(58.315334F));
    }
}