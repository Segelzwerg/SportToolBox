package segelzwerg.sporttooolbox.IUnits.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.speed.SpeedFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaceFactoryTest {
    float pace;

    @BeforeEach
    void setUp() {
        pace = 3.81f;
    }

    @Test
    void build_minutes_per_km() {
        Pace paceFromUnit = PaceFactory.createPaceFromUnit(pace, "minutesPerKilometer");

        MinutesPerKilometer expectedPace = new MinutesPerKilometer(pace);

        assertThat(paceFromUnit, equalTo(expectedPace));
    }

    @Test
    void build_minutes_per_100_meters() {
        Pace paceFromUnit = PaceFactory.createPaceFromUnit(pace, "minutesPerHundredMeters");

        MinutesPerHundredMeters expectedPace = new MinutesPerHundredMeters(pace);

        assertThat(paceFromUnit, equalTo(expectedPace));
    }

    @Test
    void invalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> SpeedFactory.createSpeedFromUnit(pace, "invalidUnit"));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void nullUnit() {
        String unit = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(pace, unit));
    }

    @Test
    void nullValue() {
        Float value = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, "kilometerPerHour"));
    }
}