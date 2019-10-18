package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class KilometerPerHour implements Speed {
	private final float speed;

	public KilometerPerHour(float speed) {

		this.speed = speed;
	}

	public Speed toKilometerPerHour() {
		return this;
	}

	public Speed toMeterPerSecond() {
		return new MeterPerSecond(speed / Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
	}

	public Speed toMilePerHour() {
		return new MilePerHour(speed / Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
	}

	public Speed toKnot() {
		return new Knot(speed / Speed.KNOT_TO_KILOMETER_PER_HOUR);
	}
}
