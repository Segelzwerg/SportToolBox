package segelzwerg.sporttooolbox.iunits.speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpeedFactoryTest {
    private float value;

    @BeforeEach
    public void setUp() {
        value = 123;
    }

    @Test
    public void buildKilometerPerHour() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "kilometerPerHour");

        KilometerPerHour expectedSpeed = new KilometerPerHour(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void buildMilesPerHour() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "milesPerHour");

        MilePerHour expectedSpeed = new MilePerHour(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void buildKnots() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "knots");

        Knot expectedSpeed = new Knot(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void buildMeterPerSecond() {
        Speed speed = SpeedFactory.createSpeedFromUnit(value, "meterPerSecond");

        MeterPerSecond expectedSpeed = new MeterPerSecond(value);

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void invalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> SpeedFactory.createSpeedFromUnit(value, "invalidUnit"));
    }

    @SuppressWarnings({"ConstantConditions", "PMD"})
    @Test
    public void nullUnit() {
        String unit = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, unit));
    }

    @SuppressWarnings("PMD")
    @Test
    public void nullValue() {
        Float value = null;
        assertThrows(NullPointerException.class, () -> SpeedFactory.createSpeedFromUnit(value, "kilometerPerHour"));
    }
}