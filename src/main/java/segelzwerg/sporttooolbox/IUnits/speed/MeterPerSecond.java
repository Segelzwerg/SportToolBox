package segelzwerg.sporttooolbox.IUnits.speed;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Time;

/**
 * Speed in meter per second
 */
@Getter
@Setter
@EqualsAndHashCode
public class MeterPerSecond implements Distance.Speed {
    public static final String unit = "meter per second";
    private final float speed;

    public MeterPerSecond(float speed) {
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
        return new KilometerPerHour(speed * Distance.Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to meter per second
     *
     * @return speed in meter per second
     */
    public Distance.Speed toMeterPerSecond() {
        return this;
    }

    /**
     * Convert to mile per hour
     *
     * @return speed in mile per hour
     */
    public Distance.Speed toMilePerHour() {
        return new MilePerHour(speed * Distance.Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR / Distance.Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to knot
     *
     * @return speed in knot
     */
    public Distance.Speed toKnot() {
        return new Knot(speed * Distance.Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR / Distance.Speed.KNOT_TO_KILOMETER_PER_HOUR);
    }

    /**
     * formats the decimal to 2 digits
     *
     * @return a new MeterPerSecond
     */
    @Override
    public Distance.Speed format() {
        return new MeterPerSecond((float) (Math.round(speed * 100.0) / 100.0));
    }

    /**
     * @param kilometer integer of the distance in kilometer
     * @param meter     decimal of distance as integer
     * @return
     */
    @Override
    public Time computeTime(float kilometer, float meter) {
        float distance = kilometer * 1000 + meter;
        float time = (distance / speed);
        return new Time(0, 0, (int) time);
    }
}
