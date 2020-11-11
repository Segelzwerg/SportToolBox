package segelzwerg.sporttoolbox.calculators;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttoolbox.iunits.distance.Distance;
import segelzwerg.sporttoolbox.iunits.distance.Kilometer;
import segelzwerg.sporttoolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttoolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttoolbox.iunits.speed.Speed;
import segelzwerg.sporttoolbox.web.speed.SpeedForm;

public class TimeCalculatorFactoryTest {
    @Test
    public void testBuildFromSpeed() {
        final int kilometer = 10;
        final int meter = 455;
        final String majorUnit = "kilometer";
        final String minorUnit = "meter";
        final float speedValue = (float) (10.455 / 0.4);
        Speed speed = new KilometerPerHour(speedValue);

        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(kilometer);
        speedForm.setMinor(meter);
        speedForm.setDistanceMajorUnit(majorUnit);
        speedForm.setDistanceMinorUnit(minorUnit);
        speedForm.setSpeed(speedValue);
        speedForm.setSpeedUnit("kilometerPerHour");

        Distance distance = new Kilometer(kilometer, meter);

        TimeCalculator timeCalculator = TimeCalculatorFactory.buildFromSpeed(speedForm, majorUnit, minorUnit);

        TimeCalculator expectedTimeCalculator = new TimeCalculator(distance, speed);

        Assertions.assertThat(timeCalculator).isEqualToComparingFieldByFieldRecursively(expectedTimeCalculator);

    }

    @Test
    public void testBuildFromPace() {
        SpeedForm paceForm = new SpeedForm();
        final int kilometer = 26;
        final int meter = 415;
        final String majorUnit = "kilometer";
        final String minorUnit = "meter";
        final float paceValue = 4.87f;
        MinutesPerKilometer pace = new MinutesPerKilometer(paceValue);

        paceForm.setMajor(kilometer);
        paceForm.setMinor(meter);
        paceForm.setDistanceMajorUnit(majorUnit);
        paceForm.setDistanceMinorUnit(minorUnit);
        paceForm.setPace(paceValue);
        paceForm.setPaceUnit("minutesPerKilometer");

        Distance distance = new Kilometer(kilometer, meter);

        TimeCalculator timeCalculator = TimeCalculatorFactory.buildFromPace(paceForm, majorUnit, minorUnit);

        TimeCalculator expectedTimeCalculator = new TimeCalculator(distance, pace);

        Assertions.assertThat(timeCalculator).isEqualToComparingFieldByFieldRecursively(expectedTimeCalculator);
    }
}