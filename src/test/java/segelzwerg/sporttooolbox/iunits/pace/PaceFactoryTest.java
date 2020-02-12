package segelzwerg.sporttooolbox.iunits.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.speed.SpeedFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaceFactoryTest {
    float pace;

    @BeforeEach
    public void setUp() {
        pace = 3.81f;
    }

    @Test
    public void build_minutes_per_km() {
        Pace paceFromUnit = PaceFactory.createPaceFromUnit(pace, "minutesPerKilometer");

        MinutesPerKilometer expectedPace = new MinutesPerKilometer(pace);

        assertThat(paceFromUnit, equalTo(expectedPace));
    }

    @Test
    public void build_minutes_per_100_meters() {
        Pace paceFromUnit = PaceFactory.createPaceFromUnit(pace, "minutesPerHundredMeters");

        MinutesPerHundredMeters expectedPace = new MinutesPerHundredMeters(pace);

        assertThat(paceFromUnit, equalTo(expectedPace));
    }

    @Test
    public void invalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> SpeedFactory.createSpeedFromUnit(pace, "invalidUnit"));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void nullUnit() {
        String unit = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(pace, unit));
    }

    @Test
    public void nullValue() {
        Float value = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, "kilometerPerHour"));
    }
}