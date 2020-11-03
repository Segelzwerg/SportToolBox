package segelzwerg.sporttooolbox.iunits.speed;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Distance;

import static segelzwerg.sporttooolbox.converters.DistanceConverterService.FATHOMS_TO_NAUTICAL;

/**
 * Speed in knot
 */
@Getter
@Setter
@EqualsAndHashCode
public class Knot implements Speed {
    public static final String UNIT = "knots";
    private final float speed;

    public Knot(float speed) {
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
        return new KilometerPerHour(speed * Speed.KNOT_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to meter per second
     *
     * @return speed in meter per second
     */
    @Override
    public Speed toMeterPerSecond() {
        return new MeterPerSecond(speed * Speed.KNOT_TO_KILOMETER_PER_HOUR / Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to mile per hour
     *
     * @return speed in mile per hour
     */
    @Override
    public Speed toMilePerHour() {
        return new MilePerHour(speed * Speed.KNOT_TO_KILOMETER_PER_HOUR / Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
    }

    /**
     * Convert to knot
     *
     * @return speed in knot
     */
    @Override
    public Speed toKnot() {
        return this;
    }

    /**
     * formats the decimal to 2 digits
     *
     * @return a new Speed
     */
    @Override
    public Speed format() {
        return new Knot((float) (Math.round(speed * 100.0) / 100.0));
    }

    @Override
    public Time computeTime(float nauticalMiles, float fathoms) {
        float time = (float) ((nauticalMiles + fathoms * FATHOMS_TO_NAUTICAL) / speed);
        return new Time(time);
    }

    @Override
    public Distance computeDistance(Time time) {
        return time.computeNautical(getSpeed());
    }
}
