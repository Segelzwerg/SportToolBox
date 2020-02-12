package segelzwerg.sporttooolbox.IUnits.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.speed.Speed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MinutesPerKilometerTest {

    private MinutesPerKilometer threeMinutesfifthteenPerKM;

    @BeforeEach
    void setUp() {
        threeMinutesfifthteenPerKM = new MinutesPerKilometer(3.25f);
    }

    @Test
    void convert_to_minutes_per_kilometer() {
        assertThat(threeMinutesfifthteenPerKM, equalTo(threeMinutesfifthteenPerKM.toMinutesPerKilometer()));
    }

    @Test
    void convert_to_minutes_per_100_meters() {
        MinutesPerHundredMeters pace = (MinutesPerHundredMeters) threeMinutesfifthteenPerKM.toMinutesPerHundredMeters();
        MinutesPerHundredMeters expectedPace = new MinutesPerHundredMeters(0.325f);
        assertThat(pace, equalTo(expectedPace));
    }

    @Test
    void convert_to_kph() {
        Speed speed = threeMinutesfifthteenPerKM.getSpeed();

        KilometerPerHour kilometerPerHour = new KilometerPerHour(18.46f);

        assertThat(speed, equalTo(kilometerPerHour));
    }

    @Test
    void convert_4_30_to_kph() {
        MinutesPerKilometer minutesPerKilometer = new MinutesPerKilometer(4.5f);

        Speed speed = minutesPerKilometer.getSpeed();

        KilometerPerHour expectedSpeed = new KilometerPerHour(13.3333f);

        assertThat(speed, equalTo(expectedSpeed));
    }
}