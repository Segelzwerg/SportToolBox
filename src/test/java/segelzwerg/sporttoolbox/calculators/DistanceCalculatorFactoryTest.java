package segelzwerg.sporttoolbox.calculators;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttoolbox.iunits.Time;
import segelzwerg.sporttoolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttoolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttoolbox.web.speed.SpeedForm;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceCalculatorFactoryTest {

    @Test
    public void testBuildFromSpeed() {
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

        DistanceCalculator distanceCalculator = DistanceCalculatorFactory.buildFromSpeed(speedForm,
                majorUnit,
                minorUnit);

        DistanceCalculator expectedDistanceCalculator = new DistanceCalculator(speed, time);

        assertThat(distanceCalculator).isEqualToComparingFieldByFieldRecursively(expectedDistanceCalculator);
    }

    @Test
    public void testBuildFromPace() {
        final float paceValue = 30f;
        final String majorUnit = "kilometer";
        final String minorUnit = "meter";
        final String paceUnit = "minutesPerKilometer";
        final int hour = 0;
        final int minutes = 34;
        final int seconds = 55;

        SpeedForm paceForm = new SpeedForm();
        paceForm.setDistanceMajorUnit(majorUnit);
        paceForm.setDistanceMinorUnit(minorUnit);
        paceForm.setHour(hour);
        paceForm.setMinute(minutes);
        paceForm.setSecond(seconds);
        paceForm.setPace(paceValue);
        paceForm.setPaceUnit(paceUnit);

        MinutesPerKilometer pace = new MinutesPerKilometer(paceValue);
        Time time = new Time(hour, minutes, seconds);

        DistanceCalculator distanceCalculator = DistanceCalculatorFactory.buildFromPace(paceForm,
                majorUnit,
                minorUnit);
        DistanceCalculator expectedDistanceCalculator = new DistanceCalculator(pace, time);
        assertThat(distanceCalculator).isEqualToComparingFieldByFieldRecursively(expectedDistanceCalculator);
    }
}