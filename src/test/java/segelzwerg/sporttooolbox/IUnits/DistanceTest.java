package segelzwerg.sporttooolbox.IUnits;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class DistanceTest {
    @Test
    public void overflow_test() {
        Distance thirtyKM_twoThousandTwoMeter = new Distance(30, 2002);
        Distance expectedDistance = new Distance(32, 2);

        assertThat(thirtyKM_twoThousandTwoMeter, equalTo(expectedDistance));
    }

    @Test
    public void add_distance_test() {
        Distance thirtyKilometer = new Distance(30, 999);
        Distance thirtyonekilometer = thirtyKilometer.addDistance(new Distance(0, 1));

        Distance expected = new Distance(31, 0);

        assertThat(thirtyonekilometer, equalTo(expected));
    }

    @Test
    public void sixty_kilometer_two_hour_test_speed() {
        Distance tenKilometer = new Distance(60);
        Time twoHours = new Time(2);
        Speed expectedSpeed = new KilometerPerHour(30);
        Speed speed = tenKilometer.computeSpeed(twoHours);

        assertThat(speed, equalTo(expectedSpeed));
    }
}
