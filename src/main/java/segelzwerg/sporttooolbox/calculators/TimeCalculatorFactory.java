package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Speed;
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

        Speed speed = speedForm.getSpeed();

        return new TimeCalculator(distance, speed);
    }
}
