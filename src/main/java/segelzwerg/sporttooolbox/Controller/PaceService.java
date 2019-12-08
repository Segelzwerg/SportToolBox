package segelzwerg.sporttooolbox.Controller;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.SpeedCalculator;


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
    public Pace calculatePace(PaceForm form) {
        int kilometer = form.getKilometer();
        int meter = form.getMeter();
        Distance distance = new Distance(kilometer, meter);

        int hour = form.getHour();
        int minute = form.getMinute();
        int second = form.getSecond();
        Time time = new Time(hour, minute, second);

        SpeedCalculator speedCalculator = new SpeedCalculator(distance, time);

        return speedCalculator.computePace();
    }
}
