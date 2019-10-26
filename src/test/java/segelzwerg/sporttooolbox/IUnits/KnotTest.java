package segelzwerg.sporttooolbox.IUnits;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class KnotTest {
    private static final float THIRTY_KNOTS = 30f;
    private static Speed thirtyKnots;

    /**
     * Set up before all tests
     * Initialization of static Speed thirtyKnots
     */
    @BeforeClass
    public static void setUp() {
        thirtyKnots = new Knot(THIRTY_KNOTS);
    }

    /**
     * toKilometerPerHour
     * Speed: thirtyKnots
     * Expected Speed: 55.56
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
     * @result thirtyKnots return itself
     */
    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyKnots.toKnot();

        assertThat(convertedSpeed, is(thirtyKnots));
    }
}