package segelzwerg.sporttooolbox.iunits.Kilometer;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Kilometer;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KilometerTest {
    @Test
    void constructorTest() {
        Kilometer kilometer = new Kilometer(1);

        Kilometer expectedKilometer = new Kilometer(1, 0);

        assertThat(kilometer).isEqualToComparingFieldByField(expectedKilometer);
    }

    /**
     * Kilometer: 30km and 2002m
     * Expected Kilometer: 32km and 2m
     *
     * @result 30km and 2002m is the same as 32km and 2m
     */
    @Test
    public void overflowTest() {
        Kilometer kilometer = new Kilometer(30, 2002);
        Kilometer expectedKilometer = new Kilometer(32, 2);

        MatcherAssert.assertThat(kilometer, equalTo(expectedKilometer));
    }

    /**
     * Kilometer: 30km and 999m plus 0km and 1m
     * Expected Kilometer: 31km
     *
     * @result the result is 31
     */
    @Test
    public void addKilometerTest() {
        Kilometer thirtyKilometer = new Kilometer(30, 999);
        Kilometer thirtyOneKilometer = thirtyKilometer.addDistance(new Kilometer(0, 1));

        Kilometer expected = new Kilometer(31, 0);

        MatcherAssert.assertThat(thirtyOneKilometer, equalTo(expected));
    }

    /**
     * Kilometer: 60km
     * Time: 2hrs
     * Expected Speed: 30km/hr
     *
     * @result the result is 30
     */
    @Test
    public void sixtyKilometerTwoHourTestSpeed() {
        Kilometer tenKilometer = new Kilometer(60);
        Time twoHours = new Time(2);
        Speed expectedSpeed = new KilometerPerHour(30);
        Speed speed = tenKilometer.computeSpeed(twoHours);

        MatcherAssert.assertThat(speed, equalTo(expectedSpeed));
    }

    /**
     * Kilometer: -1km
     * Expected: IllegalArgumentException
     */

    @Test
    public void negativeKilometer() {
        assertThrows(IllegalArgumentException.class, () -> new Kilometer(-1));
    }
    
}
