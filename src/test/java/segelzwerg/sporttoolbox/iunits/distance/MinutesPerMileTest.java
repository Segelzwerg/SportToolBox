package segelzwerg.sporttoolbox.iunits.distance;

import org.assertj.core.util.FloatComparator;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttoolbox.iunits.pace.MinutesPerHundredMeters;
import segelzwerg.sporttoolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttoolbox.iunits.pace.MinutesPerMile;
import segelzwerg.sporttoolbox.iunits.pace.Pace;

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
        MinutesPerHundredMeters expectedPace = new MinutesPerHundredMeters(0.3728227f);

        Pace pace = minutesPerMile.toMinutesPerHundredMeters();

        assertThat(pace).usingComparatorForFields(floatComparator, "pace").isEqualToComparingFieldByField(expectedPace);
    }

    @Test
    public void convertToMinutesPerMile() {
        MinutesPerMile minutesPerMile = new MinutesPerMile(6f);

        Pace pace = minutesPerMile.toMinutesPerMile();

        assertThat(pace).usingComparatorForFields(floatComparator, "pace").isEqualToComparingFieldByField(minutesPerMile);
    }
}