package segelzwerg.sporttooolbox.iunits.distance;

import org.assertj.core.util.DoubleComparator;
import org.assertj.core.util.FloatComparator;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Knot;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertTrue;

public class NauticalTest {

    private final DoubleComparator fathomComparator = new DoubleComparator(0.1);
    private final FloatComparator speedComparator = new FloatComparator(0.001f);

    @Test
    public void constructorTest() {
        Nautical nautical = new Nautical(1);

        Nautical expectedNautical = new Nautical(1, 0);

        assertThat(nautical).isEqualToComparingFieldByField(expectedNautical);
    }

    @Test
    public void floatConstructorTest() {
        Nautical nautical = new Nautical(24.56);
        Nautical expectedDistance = new Nautical(24, 567.1);

        assertThat(nautical).usingComparatorForFields(fathomComparator, "fathoms").isEqualToComparingFieldByField(expectedDistance);
        assertThat(nautical).isEqualToIgnoringGivenFields(expectedDistance, "fathoms");
    }

    @Test
    public void negativeInput() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Nautical(-1, -1));
    }

    @Test
    public void negativeFloatInput() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Nautical(-1f));
    }

    @Test
    public void overflowTest() {
        Nautical nautical = new Nautical(0, 1013);

        Distance expectedDistance = new Nautical(1, 0.31015118762578453);

        assertThat(nautical).usingComparatorForFields(fathomComparator, "fathoms").isEqualToComparingFieldByField(expectedDistance);
        assertThat(nautical).isEqualToIgnoringGivenFields(expectedDistance, "fathoms");
    }

    @Test
    public void additionTest() {
        Nautical nautical = new Nautical(1, 300);
        Nautical otherNautical = new Nautical(0, 800);

        Nautical expectedDistance = new Nautical(2, 86.22030237550682);

        Distance distance = nautical.addDistance(otherNautical);

        assertThat(distance).usingComparatorForFields(fathomComparator, "fathoms").isEqualToComparingFieldByField(expectedDistance);
        assertThat(distance).isEqualToIgnoringGivenFields(expectedDistance, "fathoms");
    }

    @Test
    public void computeTimeTest() {
        Nautical nautical = new Nautical(23, 500);
        Knot knot = new Knot(12.5f);
        Time expectedTime = new Time(1, 52, 46);

        Time time = nautical.computeTime(knot);


        assertThat(time).isEqualToComparingFieldByField(expectedTime);
    }

    @Test
    public void computeSpeedTest() {
        Nautical nautical = new Nautical(100, 200);
        Time time = new Time(48, 0, 0);
        Knot expectedSpeed = new Knot(2.08745f);

        Speed speed = nautical.computeSpeed(time);

        assertThat(speed).usingComparatorForFields(speedComparator, "speed").isEqualToComparingFieldByField(expectedSpeed);
    }

    @Test
    public void computePaceTest() {
        Nautical nautical = new Nautical(100, 200);
        Time time = new Time(48, 0, 0);

        MinutesPerKilometer expectedPace = new MinutesPerKilometer(15.5201f);

        Pace pace = nautical.computePace(time);

        assertThat(pace).usingComparatorForFields(speedComparator, "pace").isEqualToComparingFieldByField(expectedPace);

    }

    @Test
    public void convertToKilometerTest() {
        Nautical nautical = new Nautical(233);
        Kilometer expectedDistance = new Kilometer(431, 516);

		Distance convertedDistance = nautical.convertTo(new Kilometer(0));
		assertTrue(convertedDistance instanceof Kilometer);
        assertThat(convertedDistance).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void convertToMilesTest() {
        Nautical nautical = new Nautical(233);
        Miles expectedDistance = new Miles(268, 231);

		Distance convertedDistance = nautical.convertTo(new Miles(0));
		assertTrue(convertedDistance instanceof Miles);
        assertThat(convertedDistance).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void convertToNauticalTest() {
        Nautical nautical = new Nautical(1000);

        Distance convertedDistance = nautical.convertTo(new Nautical(0));
        assertTrue(convertedDistance instanceof Nautical);
        assertThat(nautical).isEqualToComparingFieldByField(nautical);
    }
}