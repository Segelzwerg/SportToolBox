package segelzwerg.sporttooolbox.calculators;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.distance.Kilometer;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

public class SpeedCalculatorFactoryTest {
    @Test
    public void testBuild() {
        final int kilometer = 10;
        final int meter = 455;
        final String majorUnit = "kilometer";
        final String minorUnit = "meter";
        final int hour = 0;
        final int minutes = 34;
        final int seconds = 55;

        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(kilometer);
        speedForm.setMinor(meter);
        speedForm.setDistanceMajorUnit(majorUnit);
        speedForm.setDistanceMinorUnit(minorUnit);
        speedForm.setHour(hour);
        speedForm.setMinute(minutes);
        speedForm.setSecond(seconds);

        Distance distance = new Kilometer(kilometer, meter);
        Time time = new Time(hour, minutes, seconds);

        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(speedForm, majorUnit, minorUnit);

        SpeedCalculator expectedSpeedCalculator = new SpeedCalculator(distance, time);

        Assertions.assertThat(speedCalculator).isEqualToComparingFieldByFieldRecursively(expectedSpeedCalculator);
    }
}