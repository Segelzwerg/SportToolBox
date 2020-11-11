package segelzwerg.sporttoolbox.iunits.pace;

import org.assertj.core.util.FloatComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttoolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttoolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;


public class MinutesPerKilometerTest {
    private static FloatComparator closeEnough;
    private MinutesPerKilometer threeMinutesFifteenPerKM;

    @BeforeAll
    public static void beforeAll() {
        closeEnough = new FloatComparator(0.0001f);
    }

    @BeforeEach
    public void setUp() {
        threeMinutesFifteenPerKM = new MinutesPerKilometer(3.25f);
    }

    @Test
    public void convert_to_minutes_per_kilometer() {
        assertThat(threeMinutesFifteenPerKM).isEqualToComparingFieldByField(threeMinutesFifteenPerKM.toMinutesPerKilometer());
    }

    @Test
    public void convert_to_minutes_per_100_meters() {
        MinutesPerHundredMeters pace = (MinutesPerHundredMeters) threeMinutesFifteenPerKM.toMinutesPerHundredMeters();
        MinutesPerHundredMeters expectedPace = new MinutesPerHundredMeters(0.325f);
        assertThat(pace)
                .usingComparatorForFields(closeEnough, "pace")
                .isEqualToComparingFieldByField(expectedPace);
    }

    @Test
    public void convert_to_kph() {
        Speed speed = threeMinutesFifteenPerKM.getSpeed();

        Speed kilometerPerHour = new KilometerPerHour(18.4615f);

        assertThat(speed)
                .usingComparatorForFields(closeEnough, "speed")
                .isEqualToComparingFieldByField(kilometerPerHour);
    }

    @Test
    public void convert_4_30_to_kph() {
        MinutesPerKilometer minutesPerKilometer = new MinutesPerKilometer(4.5f);

        Speed speed = minutesPerKilometer.getSpeed();

        KilometerPerHour expectedSpeed = new KilometerPerHour(13.3333f);

        assertThat(speed)
                .usingComparatorForFields(closeEnough, "speed")
                .isEqualToComparingFieldByField(expectedSpeed);
    }
}