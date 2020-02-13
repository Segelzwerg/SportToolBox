package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.iunits.speed.Speed;
import segelzwerg.sporttooolbox.iunits.speed.SpeedFactory;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

public class TimeCalculatorFactory {
    /**
     * builds a {@link TimeCalculator}
     *
     * @param speedForm {@link SpeedForm}
     * @param majorUnit major unit of the distance
     * @param minorUnit minor unit of the distance
     * @return {@link TimeCalculator}
     */
    public static TimeCalculator build(SpeedForm speedForm, String majorUnit, String minorUnit) {
        int major = speedForm.getMajor();
        int minor = speedForm.getMinor();
        Distance distance = Distance.createWithOtherThanSIUnits(major, minor, majorUnit, minorUnit);

        float speed = speedForm.getSpeed();
        String speedUnit = speedForm.getSpeedUnit();
        Speed speedObject = SpeedFactory.createSpeedFromUnit(speed, speedUnit);

        return new TimeCalculator(distance, speedObject);
    }
}
