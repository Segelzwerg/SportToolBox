package segelzwerg.sporttoolbox.iunits.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttoolbox.iunits.speed.SpeedFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaceFactoryTest {
    private float value;

    @BeforeEach
    public void setUp() {
        value = 3.81f;
    }

    @Test
    public void build_minutes_per_km() {
        Pace paceFromUnit = PaceFactory.createPaceFromUnit(value, "minutesPerKilometer");

        MinutesPerKilometer expectedPace = new MinutesPerKilometer(value);

        assertThat(paceFromUnit, equalTo(expectedPace));
    }

    @Test
    public void build_minutes_per_100_meters() {
        Pace paceFromUnit = PaceFactory.createPaceFromUnit(value, "minutesPerHundredMeters");

        MinutesPerHundredMeters expectedPace = new MinutesPerHundredMeters(value);

        assertThat(paceFromUnit, equalTo(expectedPace));
    }

    @Test
    public void invalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> SpeedFactory.createSpeedFromUnit(value, "invalidUnit"));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void nullUnit() {
        String unit = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, unit));
    }

    @Test
    public void nullValue() {
        Float value = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, "kilometerPerHour"));
    }
}