package segelzwerg.sporttooolbox.IUnits.speed;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Time;

@Getter
@Setter
@EqualsAndHashCode
public class MilePerHour implements Distance.Speed {
    public static final String unit = "miles per hour";
    private final float speed;

    public MilePerHour(float speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed must not be negative");
        }
        this.speed = speed;
    }

    /**
     * Convert to kilometer per hour
     *
     * @return speed in kilometer per hour
     */
    public Distance.Speed toKilometerPerHour() {
        return new KilometerPerHour(speed * Distance.Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to meter per second
     *
     * @return speed in meter per second
     */
    public Distance.Speed toMeterPerSecond() {
        return new MeterPerSecond(speed * Distance.Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR / Distance.Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to mile per hour
     *
     * @return speed in mile per hour
     */
    public Distance.Speed toMilePerHour() {
        return this;
    }

    /**
     * Convert to knot
     *
     * @return speed in knot
     */
    public Distance.Speed toKnot() {
        return new Knot(speed * Distance.Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR / Distance.Speed.KNOT_TO_KILOMETER_PER_HOUR);
    }

    /**
     * formats the decimal to 2 digits
     *
     * @return a new MilePerHour
     */
    @Override
    public Distance.Speed format() {
        return new MilePerHour(((float) (Math.round(speed * 100.0) / 100.0)));
    }

    @Override
    public Time computeTime(float miles, float yards) {
        float time = (float) ((miles + yards / Distance.MILES_TO_YARDS) / speed);
        return new Time(time);
    }
}
