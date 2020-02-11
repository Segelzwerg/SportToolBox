package segelzwerg.sporttooolbox.web;

import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.SpeedCalculator;
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
