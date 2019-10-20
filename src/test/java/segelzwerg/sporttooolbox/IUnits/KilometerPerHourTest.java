package segelzwerg.sporttooolbox.IUnits;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class KilometerPerHourTest {

    private static final float THIRTY_KM_PER_HOUR = 30f;
    private static Speed thirtyKilometersPerHour = new KilometerPerHour(THIRTY_KM_PER_HOUR);

    @BeforeClass
    public static void setUp() {
        thirtyKilometersPerHour = new KilometerPerHour(THIRTY_KM_PER_HOUR);
    }

    @Test
    public void toKilometerPerHour() {

        Speed convertedSpeed = thirtyKilometersPerHour.toKilometerPerHour();

        assertThat(convertedSpeed, is(thirtyKilometersPerHour));
    }

    @Test
    public void toMeterPerSecond() {
        Speed convertedSpeed = thirtyKilometersPerHour.toMeterPerSecond();

        assertThat(convertedSpeed.getSpeed(), equalTo(8.333334f));
    }

    @Test
    public void toMilePerHour() {
        Speed convertedSpeed = thirtyKilometersPerHour.toMilePerHour();

        assertThat(convertedSpeed.getSpeed(), equalTo(18.641136f));
    }

    @Test
    public void toKnot() {
        Speed convertedSpeed = thirtyKilometersPerHour.toKnot();

        assertThat(convertedSpeed.getSpeed(), equalTo(16.198704f));
    }
}