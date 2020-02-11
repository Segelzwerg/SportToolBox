package segelzwerg.sporttooolbox.calculators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.IUnits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.IUnits.speed.KilometerPerHour;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class TimeCalculatorTest {

    private Distance sixtyKilometer;

    @BeforeEach
    void setUp() {
        sixtyKilometer = new Distance(60);
    }

    /**
     * test for 60km with 12kph
     *
     * @result {@link Time} with 5 hours, 0 minutes and 0 seconds
     */
    @Test
    void sixty_kilometer_with_twelve_kph() {
        KilometerPerHour twelveKPH = new KilometerPerHour(12);
        Time expectedTime = new Time(5, 0, 0);

        TimeCalculator timeCalculator = new TimeCalculator(sixtyKilometer, twelveKPH);
        Time time = timeCalculator.computeTime();

        assertThat(time, equalTo(expectedTime));
    }

    @Test
    void sixty_kilometer_with_four_min_per_km() {
        MinutesPerKilometer fiveMinutesPerKilometer = new MinutesPerKilometer(4);
        Time expectedTime = new Time(4, 0, 0);

        TimeCalculator timeCalculator = new TimeCalculator(sixtyKilometer, fiveMinutesPerKilometer);
        Time time = timeCalculator.computeTime();

        assertThat(time, equalTo(expectedTime));

    }
}