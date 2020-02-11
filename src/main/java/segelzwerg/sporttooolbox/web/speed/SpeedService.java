package segelzwerg.sporttooolbox.web.speed;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.calculators.SpeedCalculator;
import segelzwerg.sporttooolbox.calculators.SpeedCalculatorFactory;
import segelzwerg.sporttooolbox.calculators.TimeCalculator;
import segelzwerg.sporttooolbox.calculators.TimeCalculatorFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Speed calculating service
 */
@Component
public class SpeedService {
    List<String> validSpeedUnits = new ArrayList<>(Arrays.asList("kilometerPerHour", "milesPerHour", "knots"));

    /**
     * Calculate speed
     *
     * @param form form with values
     * @return calculated speed
     */
    public Speed calculateSpeed(SpeedForm form) {

        String majorUnit = ((majorUnit = form.getDistanceMajorUnit()) != null) ? majorUnit : "kilometer";
        String minorUnit = ((minorUnit = form.getDistanceMinorUnit()) != null) ? minorUnit : "meter";
        String speedUnit = ((speedUnit = form.getSpeedUnit()) != null) ? speedUnit : "kilometerPerHour";

        checkValidUnit(validSpeedUnits, speedUnit);

        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(form, majorUnit, minorUnit);

        return speedCalculator.computeSpeed();
    }

    /**
     * calculates the time given a distance and speed
     *
     * @param speedForm contains distance and speed and their units
     * @return a Time object containing hours, minutes and seconds
     */
    public Time calculateTime(SpeedForm speedForm) {
        String majorUnit = ((majorUnit = speedForm.getDistanceMajorUnit()) != null) ? majorUnit : "kilometer";
        String minorUnit = ((minorUnit = speedForm.getDistanceMinorUnit()) != null) ? minorUnit : "meter";
        String speedUnit = ((speedUnit = speedForm.getSpeedUnit()) != null) ? speedUnit : "kilometerPerHour";

        checkValidUnit(validSpeedUnits, speedUnit);

        TimeCalculator timeCalculator = TimeCalculatorFactory.build(speedForm, majorUnit, minorUnit);
        return timeCalculator.computeTime();
    }

    /**
     * validates if the input units are acceptable
     *
     * @param validUnits given valid units
     * @param unit       the unit to check
     */
    private void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }
}
