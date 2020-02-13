package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.iunits.Distance;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

public class SpeedCalculatorFactory {
    public static SpeedCalculator build(SpeedForm form, String majorUnit, String minorUnit) {
        int major = form.getMajor();
        int minor = form.getMinor();
        Distance distance = Distance.createWithOtherThanSIUnits(major, minor, majorUnit, minorUnit);

        int hour = form.getHour();
        int minute = form.getMinute();
        int second = form.getSecond();
        Time time = new Time(hour, minute, second);

        return new SpeedCalculator(distance, time);
    }
}
