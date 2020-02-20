package segelzwerg.sporttooolbox.iunits.speed;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Distance;

/**
 * Speed in kilometer per hour
 */
@Getter
@ToString
@EqualsAndHashCode
public class KilometerPerHour implements Speed {
    public final static String UNIT = "kilometer per hour";
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
    @Override
    public Speed toKilometerPerHour() {
        return this;
    }

    /**
     * Convert to meter per second
     *
     * @return speed in meter per second
     */
    @Override
    public Speed toMeterPerSecond() {
        return new MeterPerSecond(speed / Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to mile per hour
     *
     * @return speed in mile per hour
     */
    @Override
    public Speed toMilePerHour() {
        return new MilePerHour(speed / Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to knot
     *
     * @return speed in knot
     */
    @Override
    public Speed toKnot() {
        return new Knot(speed / Speed.KNOT_TO_KILOMETER_PER_HOUR);
    }

    /**
     * formats the decimal to 2 digits
     *
     * @return a new KilometerPerHour
     */
    @Override
    public Speed format() {
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

    @Override
    public Distance computeDistance() {
        return null;
    }
}
