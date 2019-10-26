package segelzwerg.sporttooolbox.IUnits;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MeterPerSecondTest {

    private static final float THIRTY_METERS_PER_SECOND = 30f;
    private static Speed thirtyMetersPerSecond;

    @BeforeClass
    public static void setUp() {
        thirtyMetersPerSecond = new MeterPerSecond(THIRTY_METERS_PER_SECOND);
    }

    @Test
    public void toKilometerPerHour() {

        Speed convertedSpeed = thirtyMetersPerSecond.toKilometerPerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(108.0F));
    }

    @Test
    public void toMeterPerSecond() {
        Speed convertedSpeed = thirtyMetersPerSecond.toMeterPerSecond();

        assertThat(convertedSpeed, is(thirtyMetersPerSecond));
    }

    @Test
    public void toMilePerHour() {
        Speed convertedSpeed = thirtyMetersPerSecond.toMilePerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(67.108086F));
    }

    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyMetersPerSecond.toKnot();

        assertThat(convertedSpeed.getSpeed(), equalTo(58.315334F));
    }
}