package segelzwerg.sporttooolbox.IUnits;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class KnotTest {
    private static final float THIRTY_KNOTS = 30f;
    private static Speed thirtyKnots;

    @BeforeClass
    public static void setUp() {
        thirtyKnots = new Knot(THIRTY_KNOTS);
    }

    @Test
    public void toKilometerPerHour() {

        Speed convertedSpeed = thirtyKnots.toKilometerPerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(55.56F));
    }

    @Test
    public void toMeterPerSecond() {
        Speed convertedSpeed = thirtyKnots.toMeterPerSecond();

        assertThat(convertedSpeed.getSpeed(), equalTo(15.433334F));
    }

    @Test
    public void toMilePerHour() {
        Speed convertedSpeed = thirtyKnots.toMilePerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(34.523384F));
    }

    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyKnots.toKnot();

        assertThat(convertedSpeed, is(thirtyKnots));
    }
}