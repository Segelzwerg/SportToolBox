package segelzwerg.sporttooolbox.calculators;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Distance;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class SpeedCalculatorFactoryTest {
    @Test
    void test_build() {
        int kilometer = 10;
        int meter = 455;
        String majorUnit = "kilometer";
        String minorUnit = "meter";
        int hour = 0;
        int minutes = 34;
        int seconds = 55;

        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(kilometer);
        speedForm.setMinor(meter);
        speedForm.setDistanceMajorUnit(majorUnit);
        speedForm.setDistanceMinorUnit(minorUnit);
        speedForm.setHour(hour);
        speedForm.setMinute(minutes);
        speedForm.setSecond(seconds);

        Distance distance = new Distance(kilometer, meter);
        Time time = new Time(hour, minutes, seconds);

        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(speedForm, majorUnit, minorUnit);

        SpeedCalculator expectedSpeedCalculator = new SpeedCalculator(distance, time);

        assertThat(speedCalculator, equalTo(expectedSpeedCalculator));
    }
}