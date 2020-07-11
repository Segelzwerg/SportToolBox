package segelzwerg.sporttooolbox.iunits.pace;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MinutesPerHundredMetersTest {
    private MinutesPerHundredMeters oneMinutefifthteenPerKM;

    @BeforeEach
    public void setUp() {
        oneMinutefifthteenPerKM = new MinutesPerHundredMeters(1.25f);
    }

    @Test
    public void convert_to_minutes_per_100_meters() {
        assertThat(oneMinutefifthteenPerKM, equalTo(oneMinutefifthteenPerKM.toMinutesPerHundredMeters()));
    }

    @Test
    public void convert_to_minutes_per_kilometer() {
        MinutesPerKilometer pace = (MinutesPerKilometer) oneMinutefifthteenPerKM.toMinutesPerKilometer();
        MinutesPerKilometer expectedPace = new MinutesPerKilometer(12.5f);
        assertThat(pace, equalTo(expectedPace));
    }

    @Test
    public void convert_to_minutes_per_miles() {
        MinutesPerMile pace = (MinutesPerMile) oneMinutefifthteenPerKM.toMinutesPerMile();
        MinutesPerMile expectedPace = new MinutesPerMile(20.1168f);
        Assertions.assertThat(pace)
                .isEqualToComparingOnlyGivenFields(expectedPace)
                .usingDefaultComparator();
    }

    @Test
    public void convert_to_kph() {
        Speed speed = oneMinutefifthteenPerKM.getSpeed();

        KilometerPerHour kilometerPerHour = new KilometerPerHour(4.8f);

        assertThat(speed, equalTo(kilometerPerHour));
    }
}