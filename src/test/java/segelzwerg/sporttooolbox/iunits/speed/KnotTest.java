package segelzwerg.sporttooolbox.iunits.speed;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Time;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KnotTest {
    private static final float THIRTY_KNOTS = 30f;
    private static Speed thirtyKnots;

    /**
     * Set up before all tests
     * Initialization of static Speed thirtyKnots
     */
    @BeforeAll
    public static void setUp() {
        thirtyKnots = new Knot(THIRTY_KNOTS);
    }

    /**
     * toKilometerPerHour
     * Speed: thirtyKnots
     * Expected Speed: 55.56
     *
     * @result 30kn = 55.56mph
     */
    @Test
    public void toKilometerPerHour() {

        Speed convertedSpeed = thirtyKnots.toKilometerPerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(55.56F));
    }

    /**
     * toMeterPerSecond
     * Speed: thirtyKnots
     * Expected Speed: 15.433334
     *
     * @result 30kn = 15.433334mph
     */
    @Test
    public void toMeterPerSecond() {
        Speed convertedSpeed = thirtyKnots.toMeterPerSecond();

        assertThat(convertedSpeed.getSpeed(), equalTo(15.433334F));
    }

    /**
     * toMilePerHour
     * Speed: thirtyKnots
     * Expected Speed: 34.523384
     *
     * @result 30kn = 34.523384mph
     */
    @Test
    public void toMilePerHour() {
        Speed convertedSpeed = thirtyKnots.toMilePerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(34.523384F));
    }

    /**
     * toKnot
     * Speed: thirtyKnots
     * Expected Speed: thirtyKnots
     *
     * @result thirtyKnots return itself
     */
    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyKnots.toKnot();

        assertThat(convertedSpeed, is(thirtyKnots));
    }

    /**
     * negative Input
     * Speed: -1 Knots
     *
     * @expected IllegalArgumentException
     */
    @Test
    public void negativeInput() {
        assertThrows(IllegalArgumentException.class, () -> new Knot(-1));
    }

    /**
     * tests calculating a time needed for given a distance
     * Speed: 17.63 knots
     * Distance: 25.27 nm
     */
    @Test
    public void computeTime() {
        Knot knots = new Knot((float) 17.63);
        float fathoms = (float) (0.270 / Distance.FATHOMS_TO_NAUTICAL_MILES);
        Time time = knots.computeTime(25, fathoms);

        Time expectedTime = new Time(1, 26, 0);

        assertThat(time, equalTo(expectedTime));
    }
}