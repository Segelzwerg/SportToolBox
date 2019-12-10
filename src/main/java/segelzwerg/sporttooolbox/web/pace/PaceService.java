package segelzwerg.sporttooolbox.web.pace;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.SpeedCalculator;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;


/**
 * Pace calculating service
 */
@Component
public class PaceService {

    /**
     * calulates pace
     *
     * @param form
     * @return calculated pace
     */
    public Pace calculatePace(SpeedForm form) {
        String majorUnit = form.getDistanceMajorUnit();
        String minorUnit = form.getDistanceMinorUnit();
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
}
