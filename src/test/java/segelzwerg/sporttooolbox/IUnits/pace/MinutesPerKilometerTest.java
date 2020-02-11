package segelzwerg.sporttooolbox.IUnits.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}