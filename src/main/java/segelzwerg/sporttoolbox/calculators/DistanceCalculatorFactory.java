package segelzwerg.sporttoolbox.calculators;

import segelzwerg.sporttoolbox.iunits.Time;
import segelzwerg.sporttoolbox.iunits.pace.Pace;
import segelzwerg.sporttoolbox.iunits.pace.PaceFactory;
import segelzwerg.sporttoolbox.iunits.speed.Speed;
import segelzwerg.sporttoolbox.iunits.speed.SpeedFactory;
import segelzwerg.sporttoolbox.web.speed.SpeedForm;

public class DistanceCalculatorFactory {
    /**
     * Builds a SpeedCalculator.
     *
     * @param form      {@link SpeedForm} must contain time and speed/pace
     * @param majorUnit
     * @param minorUnit
     * @return {@link DistanceCalculator}
     */
    public static DistanceCalculator buildFromSpeed(SpeedForm form, String majorUnit, String minorUnit) {
        int hour = form.getHour();
        int minute = form.getMinute();
        int second = form.getSecond();
        Time time = new Time(hour, minute, second);

        float speed = form.getSpeed();
        String speedUnit = form.getSpeedUnit();
        Speed speedObject = SpeedFactory.createSpeedFromUnit(speed, speedUnit);

        return new DistanceCalculator(speedObject, time);
    }

    public static DistanceCalculator buildFromPace(SpeedForm form, String majorUnit, String minorUnit) {
        int hour = form.getHour();
        int minute = form.getMinute();
        int second = form.getSecond();
        Time time = new Time(hour, minute, second);

        float pace = form.getPace();
        String paceUnit = form.getPaceUnit();
        Pace paceObject = PaceFactory.createPaceFromUnit(pace, paceUnit);
        return new DistanceCalculator(paceObject, time);
    }
}
