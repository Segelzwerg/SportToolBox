package segelzwerg.sporttooolbox.iunits.speed;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MeterPerSecondTest {

    private static final float THIRTY_METERS_PER_SECOND = 30f;
    private static Speed thirtyMetersPerSecond;

    /**
     * Set up before all tests
     * Initialization of static Speed thirtyMetersPerSecond
     */
    @BeforeAll
    public static void setUp() {
        thirtyMetersPerSecond = new MeterPerSecond(THIRTY_METERS_PER_SECOND);
    }

    /**
     * toKilometerPerHour
     * Speed: thirtyMetersPerSecond
     * Expected Speed: 108.0
     *
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
     *
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
     *
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
     *
     * @result 30m/s = 58.315334kn
     */
    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyMetersPerSecond.toKnot();

        assertThat(convertedSpeed.getSpeed(), equalTo(58.315334F));
    }

    /**
     * negative Input
     * Speed: -1 m/s
     *
     * @expected IllegalArgumentException
     */
    @Test
    public void negativeInput() {
        assertThrows(IllegalArgumentException.class, () -> new MeterPerSecond(-1));
    }

    /**
     * tests calculating a time needed for given a distance
     * Speed: 56.9 m/s
     * Distance: 3.7km
     */
    @Test
    public void computeTime() {
        MeterPerSecond meterPerSecond = new MeterPerSecond((float) 56.9);
        Time time = meterPerSecond.computeTime(3, 700);

        Time expectedTime = new Time(0, 1, 5);

        assertThat(time, equalTo(expectedTime));
    }
}