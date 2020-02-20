package segelzwerg.sporttooolbox.iunits.distance;

import org.assertj.core.util.FloatComparator;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerMile;
import segelzwerg.sporttooolbox.iunits.pace.Pace;

import static org.assertj.core.api.Assertions.assertThat;

public class MinutesPerMileTest {

    private final FloatComparator floatComparator = new FloatComparator(0.001f);

    @Test
    public void convertToMinutesPerKM() {
        MinutesPerMile minutesPerMile = new MinutesPerMile(6f);
        MinutesPerKilometer expectedPace = new MinutesPerKilometer(3.728227f);

        Pace pace = minutesPerMile.toMinutesPerKilometer();

        assertThat(pace).usingComparatorForFields(floatComparator, "pace").isEqualToComparingFieldByField(expectedPace);
    }

    @Test
    public void convertToMinutesPerHundredMeters() {
        MinutesPerMile minutesPerMile = new MinutesPerMile(6f);
        MinutesPerKilometer expectedPace = new MinutesPerKilometer(0.3728227f);

        Pace pace = minutesPerMile.toMinutesPerHundredMeters();

        assertThat(pace).usingComparatorForFields(floatComparator, "pace").isEqualToComparingFieldByField(expectedPace);
    }
}