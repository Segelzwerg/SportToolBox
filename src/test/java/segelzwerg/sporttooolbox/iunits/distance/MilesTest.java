package segelzwerg.sporttooolbox.iunits.distance;

import org.assertj.core.util.FloatComparator;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerMile;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.MilePerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertTrue;

public class MilesTest {

    private final FloatComparator floatComparator = new FloatComparator(0.0001f);

    @Test
    public void constructorTest() {
        Miles miles = new Miles(1);

        Miles expectedMile = new Miles(1, 0);

        assertThat(miles).isEqualToComparingFieldByField(expectedMile);
    }

    @Test
    public void floatConstructorTest() {
        Miles miles = new Miles(48.24f);
        Miles expectedDistance = new Miles(48, 422);

        assertThat(miles).isEqualToComparingFieldByField(expectedDistance);
    }


    @Test
    public void floatConstructorNegativeInput() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Miles(-1f));
    }

    @Test
    public void overflowTest() {
        Miles miles = new Miles(0, 1761);
        Miles expectedMiles = new Miles(1, 1);

        assertThat(miles).isEqualToComparingFieldByField(expectedMiles);
    }

    @Test
    public void addMilesTest() {
        Miles miles = new Miles(0, 1759);
        Miles oneYard = new Miles(0, 1);

        Distance distance = miles.addDistance(oneYard);

        Miles expectedDistance = new Miles(1, 0);

        assertThat(distance).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void sixtyMilesTestSpeed() {
        Miles miles = new Miles(60, 0);
        Time time = new Time(2, 0, 0);
        MilePerHour expectedSpeed = new MilePerHour(30f);

        Speed speed = miles.computeSpeed(time);

        assertThat(speed).isEqualToComparingFieldByField(expectedSpeed);
    }

    @Test
    public void speedWithYards() {
        Miles yards = new Miles(0, 1250);
        Time time = new Time(2, 0, 0);
        Speed speed = yards.computeSpeed(time);

        MilePerHour expectedSpeed = new MilePerHour(0.3551f);

        assertThat(speed).usingComparatorForFields(floatComparator, "speed").isEqualToComparingFieldByField(expectedSpeed);
    }

    @Test
    public void negativeInput() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Miles(-1, -1));
    }

    @Test
    public void computeTimeTest() {
        Miles miles = new Miles(23, 284);
        MilePerHour milePerHour = new MilePerHour(12.5f);
        Time expectedTime = new Time(1, 51, 10);

        Time time = miles.computeTime(milePerHour);


        assertThat(time).isEqualToComparingFieldByField(expectedTime);
    }

    @Test
    public void computePaceTest() {
        Miles miles = new Miles(65, 123);
        Time time = new Time(1, 43, 12);
        Pace expectedPace = new MinutesPerMile(1.585987f);

        Pace pace = miles.computePace(time);

        assertThat(pace).usingComparatorForFields(floatComparator).isEqualToComparingFieldByField(expectedPace);

    }

    @Test
    public void convertToKilometerTest() {
        Miles milesFrom = new Miles(343);
        Kilometer expectedDistance = new Kilometer(552, 5);

		Distance convertedDistance = milesFrom.convertTo(new Kilometer(0));
		assertTrue(convertedDistance instanceof Kilometer);
		assertThat(convertedDistance).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void convertToMilesTest() {
        Miles milesFrom = new Miles(1000);

        Distance convertedDistance = milesFrom.convertTo(new Miles(0));
        assertTrue(convertedDistance instanceof Miles);
        assertThat(convertedDistance).isEqualToComparingFieldByField(milesFrom);
    }

    @Test
    public void convertToNauticalTest() {
        Miles milesFrom = new Miles(1000);
        Nautical expectedDistance = new Nautical(1150, 789.9);

        Distance convertedDistance = milesFrom.convertTo(new Nautical(0));
        assertTrue(convertedDistance instanceof Nautical);
        assertThat(convertedDistance).isEqualToComparingFieldByField(expectedDistance);
    }
}