package segelzwerg.sporttooolbox.IUnits.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.speed.Speed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MinutesPerHundredMetersTest {
    private MinutesPerHundredMeters oneMinutefifthteenPerKM;

    @BeforeEach
    void setUp() {
        oneMinutefifthteenPerKM = new MinutesPerHundredMeters(1.25f);
    }

    @Test
    void convert_to_minutes_per_100_meters() {
        assertThat(oneMinutefifthteenPerKM, equalTo(oneMinutefifthteenPerKM.toMinutesPerHundredMeters()));
    }

    @Test
    void convert_to_minutes_per_kilometer() {
        MinutesPerKilometer pace = (MinutesPerKilometer) oneMinutefifthteenPerKM.toMinutesPerKilometer();
        MinutesPerKilometer expectedPace = new MinutesPerKilometer(12.5f);
        assertThat(pace, equalTo(expectedPace));
    }

    @Test
    void convert_to_kph() {
        Speed speed = oneMinutefifthteenPerKM.getSpeed();

        KilometerPerHour kilometerPerHour = new KilometerPerHour(4.8f);

        assertThat(speed, equalTo(kilometerPerHour));
    }
}