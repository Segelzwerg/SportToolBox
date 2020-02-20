package segelzwerg.sporttooolbox.iunits.distance;

import org.assertj.core.util.FloatComparator;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Knot;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;

public class NauticalTest {

    private final FloatComparator fathomComparator = new FloatComparator(0.1f);
    private final FloatComparator speedComparator = new FloatComparator(0.001f);

    @Test
    public void constructorTest() {
        Nautical nautical = new Nautical(1);

        Nautical expectedNautical = new Nautical(1, 0);

        assertThat(nautical).isEqualToComparingFieldByField(expectedNautical);
    }

    @Test
    public void floatConstructorTest() {
        Nautical nautical = new Nautical(24.56f);
        Nautical expectedDistance = new Nautical(24, 567.1f);

        assertThat(nautical).usingComparatorForFields(fathomComparator, "fathoms").isEqualToComparingFieldByField(expectedDistance);
        assertThat(nautical).isEqualToIgnoringGivenFields(expectedDistance, "fathoms");
    }

    @Test
    public void overflowTest() {
        Nautical nautical = new Nautical(0, 1013);

        Distance expectedDistance = new Nautical(1, 0.3101f);

        assertThat(nautical).usingComparatorForFields(fathomComparator, "fathoms").isEqualToComparingFieldByField(expectedDistance);
        assertThat(nautical).isEqualToIgnoringGivenFields(expectedDistance, "fathoms");
    }

    @Test
    public void additionTest() {
        Nautical nautical = new Nautical(1, 300);
        Nautical otherNautical = new Nautical(0, 800);

        Nautical expectedDistance = new Nautical(2, 86.22f);

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
    public void toKilometer() {
        Nautical nautical = new Nautical(233);
        Kilometer expectedDistance = new Kilometer(431, 516);

        Kilometer kilometer = nautical.toKilometer();

        assertThat(kilometer).isEqualToComparingFieldByField(expectedDistance);
    }
}