package segelzwerg.sporttooolbox.IUnits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

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
}