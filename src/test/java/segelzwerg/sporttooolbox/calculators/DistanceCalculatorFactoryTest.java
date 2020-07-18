package segelzwerg.sporttooolbox.calculators;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceCalculatorFactoryTest {

    @Test
    public void testBuild() {
        final float speedValue = 30f;
        final String majorUnit = "kilometer";
        final String minorUnit = "meter";
        final String speedUnit = "kilometerPerHour";
        final int hour = 0;
        final int minutes = 34;
        final int seconds = 55;

        SpeedForm speedForm = new SpeedForm();
        speedForm.setDistanceMajorUnit(majorUnit);
        speedForm.setDistanceMinorUnit(minorUnit);
        speedForm.setHour(hour);
        speedForm.setMinute(minutes);
        speedForm.setSecond(seconds);
        speedForm.setSpeed(speedValue);
        speedForm.setSpeedUnit(speedUnit);

        KilometerPerHour speed = new KilometerPerHour(speedValue);
        Time time = new Time(hour, minutes, seconds);

        DistanceCalculator distanceCalculator = DistanceCalculatorFactory.buildFromSpeed(speedForm, majorUnit, minorUnit);

        DistanceCalculator expectedDistanceCalculator = new DistanceCalculator(speed, time);

        assertThat(distanceCalculator).isEqualToComparingFieldByFieldRecursively(expectedDistanceCalculator);
    }
}