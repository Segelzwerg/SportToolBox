package segelzwerg.sporttooolbox.iunits.distance;

import org.assertj.core.util.FloatComparator;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KilometerTest {
    private final FloatComparator floatComparator = new FloatComparator(0.001f);

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

        assertThat(kilometer).isEqualToComparingFieldByField(expectedKilometer);
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
        Kilometer oneMeter = new Kilometer(0, 1);
        Kilometer thirtyOneKilometer = thirtyKilometer.addDistance(oneMeter);

        Kilometer expected = new Kilometer(31, 0);

        assertThat(thirtyOneKilometer).isEqualToComparingFieldByField(expected);
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
        Kilometer sixty = new Kilometer(60);
        Time twoHours = new Time(2);
        Speed expectedSpeed = new KilometerPerHour(30);
        Speed speed = sixty.computeSpeed(twoHours);

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

    @Test
    public void computeTimeTest() {
        Kilometer kilometer = new Kilometer(23, 500);
        KilometerPerHour kilometerPerHour = new KilometerPerHour(12.5f);
        Time expectedTime = new Time(1, 52, 48);

        Time time = kilometer.computeTime(kilometerPerHour);


        assertThat(time).isEqualToComparingFieldByField(expectedTime);
    }

    @Test
    public void computePaceTest() {
        Kilometer kilometer = new Kilometer(65, 123);
        Time time = new Time(1, 43, 12);
        Pace expectedPace = new MinutesPerKilometer(1.5847f);

        Pace pace = kilometer.computePace(time);

        assertThat(pace).usingComparatorForFields(floatComparator, "pace").isEqualToComparingFieldByField(expectedPace);

    }

    @Test
    public void floatConstructorTest() {
        Kilometer kilometer = new Kilometer(22.4f);
        Kilometer expectedDistance = new Kilometer(22, 400);

        assertThat(kilometer).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void toKilometer() {
        Kilometer kilometer = new Kilometer(234, 23);

        Kilometer convertedKilometer = kilometer.toKilometer();

        assertThat(convertedKilometer).isEqualToComparingFieldByField(kilometer);
    }
}
