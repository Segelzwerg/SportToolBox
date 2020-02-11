package segelzwerg.sporttooolbox.IUnits.speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SpeedFactoryTest {
    float value;

    @BeforeEach
    void setUp() {
        value = 123;
    }

    @Test
    void build_kilometerPerHour() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "kilometerPerHour");

        KilometerPerHour expectedSpeed = new KilometerPerHour(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    void build_milesPerHour() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "milesPerHour");

        MilePerHour expectedSpeed = new MilePerHour(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    void build_knots() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "knots");

        Knot expectedSpeed = new Knot(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    void build_meterPerSecond() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "meterPerSecond");

        MeterPerSecond expectedSpeed = new MeterPerSecond(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    void invalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> SpeedFactory.createSpeedFromUnit(value, "invalidUnit"));
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void nullUnit() {
        String unit = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, unit));
    }

    @Test
    void nullValue() {
        Float value = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, "kilometerPerHour"));
    }
}