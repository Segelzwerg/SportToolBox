package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Speed in kilometer per hour
 */
@Getter
@ToString
@EqualsAndHashCode
public class KilometerPerHour extends Speed {

	public KilometerPerHour(float speed) {
		super(speed);
	}

	/**
	 * Convert to kilometer per hour
	 * @return speed in kilometer per hour
	 */
	public Speed toKilometerPerHour() {
		return this;
	}

	/**
	 * Convert to meter per second
	 * @return speed in meter per second
	 */
	public Speed toMeterPerSecond() {
		return new MeterPerSecond(getSpeed() / Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
	}

	/**
	 * Convert to mile per hour
	 * @return speed in mile per hour
	 */
	public Speed toMilePerHour() {
		return new MilePerHour(getSpeed() / Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
	}

	/**
	 * Convert to knot
	 * @return speed in knot
	 */
	public Speed toKnot() {
		return new Knot(getSpeed() / Speed.KNOT_TO_KILOMETER_PER_HOUR);
	}
}
