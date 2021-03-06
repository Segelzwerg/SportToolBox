package segelzwerg.sporttooolbox.web.pace;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.SpeedCalculator;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Pace calculating service
 */
@Component
public class PaceService {

    List<String> validPaceUnits = new ArrayList<>(Arrays.asList("minutesPerKilometer", "minutesPerHundredMeters"));

    /**
     * calulates pace
     *
     * @param form
     * @return calculated pace
     */
    public Pace calculatePace(SpeedForm form) {
        String majorUnit = ((majorUnit = form.getDistanceMajorUnit()) != null) ? majorUnit : "kilometer";
        String minorUnit = ((minorUnit = form.getDistanceMinorUnit()) != null) ? minorUnit : "meter";
        String resultUnit = ((resultUnit = form.getResultUnit()) != null) ? resultUnit : "minutesPerKilometer";

        checkValidUnit(validPaceUnits, resultUnit);
        int major = form.getMajor();
        int minor = form.getMinor();
        Distance distance = Distance.createWithOtherThanSIUnits(major, minor, majorUnit, minorUnit);

        int hour = form.getHour();
        int minute = form.getMinute();
        int second = form.getSecond();
        Time time = new Time(hour, minute, second);

        SpeedCalculator speedCalculator = new SpeedCalculator(distance, time);

        return speedCalculator.computePace();
    }

    private void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }
}
