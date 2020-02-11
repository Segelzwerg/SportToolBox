package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

public class TimeCalculatorFactory {
    public static TimeCalculator build(SpeedForm speedForm, String majorUnit, String minorUnit) {
        int major = speedForm.getMajor();
        int minor = speedForm.getMinor();
        Distance distance = Distance.createWithOtherThanSIUnits(major, minor, majorUnit, minorUnit);

        Speed speed = speedForm.getSpeed();

        return new TimeCalculator(distance, speed);
    }
}
