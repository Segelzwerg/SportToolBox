package segelzwerg.sporttooolbox.web.speed;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.SpeedCalculator;

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

        int major = form.getMajor();
        int minor = form.getMinor();
        Distance distance = Distance.createWithOtherThanSIUnits(major, minor, majorUnit, minorUnit);

        int hour = form.getHour();
        int minute = form.getMinute();
        int second = form.getSecond();
        Time time = new Time(hour, minute, second);

        SpeedCalculator speedCalculator = new SpeedCalculator(distance, time);

        return speedCalculator.computeSpeed();
    }

    private void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }

}
