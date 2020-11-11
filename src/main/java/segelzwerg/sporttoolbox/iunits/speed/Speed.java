package segelzwerg.sporttoolbox.iunits.speed;

import segelzwerg.sporttoolbox.iunits.Time;
import segelzwerg.sporttoolbox.iunits.distance.Distance;

/**
 * Speed interface
 */
public interface Speed {

    public static final float METER_PER_SECOND_TO_KILOMETER_PER_HOUR = 3.6f;
    public static final float MILE_PER_HOUR_TO_KILOMETER_PER_HOUR = 1.609344f;
    public static final float KNOT_TO_KILOMETER_PER_HOUR = 1.852f;

    /**
     * Convert to kilometer per hour
     *
     * @return speed in kilometer per hour
     */
    Speed toKilometerPerHour();

    /**
     * Convert to meter per second
     *
     * @return speed in meter per second
     */
    Speed toMeterPerSecond();

    /**
     * Convert to mile per hour
     *
     * @return speed in mile per hour
     */
    Speed toMilePerHour();

    /**
     * Convert to knot
     *
     * @return speed in knot
     */
    Speed toKnot();

    /**
     * deprecated no getter for private fields.
     *
     * @return
     */
    @Deprecated
    float getSpeed();

    public Speed format();

    /**
     * computes the time for a given major and minor
     *
     * @param major integer of the distance in major
     * @param minor decimal of distance as integer
     * @return time with hours, minutes and seconds
     */
    Time computeTime(float major, float minor);

    Distance computeDistance(Time time);
}
