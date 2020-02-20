package segelzwerg.sporttooolbox.iunits.distance;

import org.assertj.core.util.FloatComparator;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Knot;

import static org.assertj.core.api.Assertions.assertThat;

public class NauticalTest {

    private final FloatComparator fathomComparator = new FloatComparator(0.001f);

    @Test
    public void constructorTest() {
        Nautical nautical = new Nautical(1);

        Nautical expectedNautical = new Nautical(1, 0);

        assertThat(nautical).isEqualToComparingFieldByField(expectedNautical);
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
}