package segelzwerg.sporttooolbox.calculators;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.Time;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class TimeCalculatorTest {
    /**
     * test for 60km with 12kph
     *
     * @result {@link Time} with 5 hours, 0 minutes and 0 seconds
     */
    @Test
    void sixty_kilometer_with_twelve_kph() {
        Distance sixtyKilometer = new Distance(60);
        KilometerPerHour twelveKPH = new KilometerPerHour(12);
        Time expectedTime = new Time(5, 0, 0);

        TimeCalculator timeCalculator = new TimeCalculator(sixtyKilometer, twelveKPH);
        Time time = timeCalculator.computeTime();

        assertThat(time, equalTo(expectedTime));
    }
}