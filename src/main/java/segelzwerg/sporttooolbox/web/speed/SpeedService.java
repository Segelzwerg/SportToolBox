package segelzwerg.sporttooolbox.web.speed;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.SpeedCalculator;
import segelzwerg.sporttooolbox.web.SpeedCalculatorFactory;

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
        String resultUnit = ((resultUnit = form.getResultUnit()) != null) ? resultUnit : "kilometerPerHour";

        checkValidUnit(validSpeedUnits, resultUnit);

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

        return null;
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
