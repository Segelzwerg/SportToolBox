package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Speed;
import segelzwerg.sporttooolbox.iunits.speed.SpeedFactory;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

public class DistanceCalculatorFactory {
    /**
     * Builds a SpeedCalculator.
     *
     * @param form      {@link SpeedForm} must contain time and speed/pace
     * @param majorUnit
     * @param minorUnit
     * @return {@link DistanceCalculator}
     */
    public static DistanceCalculator build(SpeedForm form, String majorUnit, String minorUnit) {
        int hour = form.getHour();
        int minute = form.getMinute();
        int second = form.getSecond();
        Time time = new Time(hour, minute, second);

        float speed = form.getSpeed();
        String speedUnit = form.getSpeedUnit();
        Speed speedObject = SpeedFactory.createSpeedFromUnit(speed, speedUnit);

        return new DistanceCalculator(speedObject, time);
    }
}
