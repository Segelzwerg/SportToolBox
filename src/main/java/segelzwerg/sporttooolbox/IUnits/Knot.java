package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Knot implements Speed {
	private final float speed;

	public Knot(float speed) {

		this.speed = speed;
	}

	public Speed toKilometerPerHour() {
		return new KilometerPerHour(speed * Speed.KNOT_TO_KILOMETER_PER_HOUR);
	}

	public Speed toMeterPerSecond() {
		return new MeterPerSecond(speed * Speed.KNOT_TO_KILOMETER_PER_HOUR / Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
	}

	public Speed toMilePerHour() {
		return new MilePerHour(speed * Speed.KNOT_TO_KILOMETER_PER_HOUR / Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
	}

	public Speed toKnot() {
		return this;
	}
}
