package segelzwerg.sporttooolbox.IUnits.speed;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Time;

/**
 * Speed in kilometer per hour
 */
@Getter
@ToString
@EqualsAndHashCode
public class KilometerPerHour implements Distance.Speed {
    public final static String unit = "kilometer per hour";
    private final float speed;

    public KilometerPerHour(float speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed must not be negative.");
        }
        this.speed = speed;
    }

    /**
     * Convert to kilometer per hour
     *
     * @return speed in kilometer per hour
     */
    public Distance.Speed toKilometerPerHour() {
        return this;
    }

    /**
     * Convert to meter per second
     *
     * @return speed in meter per second
     */
    public Distance.Speed toMeterPerSecond() {
        return new MeterPerSecond(speed / Distance.Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to mile per hour
     *
     * @return speed in mile per hour
     */
    public Distance.Speed toMilePerHour() {
        return new MilePerHour(speed / Distance.Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to knot
     *
     * @return speed in knot
     */
    public Distance.Speed toKnot() {
        return new Knot(speed / Distance.Speed.KNOT_TO_KILOMETER_PER_HOUR);
    }

    /**
     * formats the decimal to 2 digits
     *
     * @return a new KilometerPerHour
     */
    @Override
    public Distance.Speed format() {
        return new KilometerPerHour((float) (Math.round(speed * 100.0) / 100.0));
    }

    /**
     * computes the time for a given distance
     *
     * @param kilometer integer of the distance in kilometer
     * @param meter     decimal of distance as integer
     * @return {@link Time} in hours, minutes and seconds
     */
    @Override
    public Time computeTime(float kilometer, float meter) {
        float time = (kilometer + meter / 1000) / speed;
        return new Time(time);
    }
}
