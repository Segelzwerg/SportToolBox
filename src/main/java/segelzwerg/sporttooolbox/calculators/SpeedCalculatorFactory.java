package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.iunits.Distance;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

/**
 * Factory class for building a speed calculator
 */
public class SpeedCalculatorFactory {
    /**
     * build a {@link SpeedCalculator}
     *
     * @param form      must contain major and minor distance, and all time fields
     * @param majorUnit unit of the major distance
     * @param minorUnit unit of the minor distance
     * @return a {@link SpeedCalculator}
     */
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
