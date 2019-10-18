package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MilePerHour implements Speed {
    private final float speed;

    public MilePerHour(float speed) {

        this.speed = speed;
    }

	public Speed toKilometerPerHour() {
		return new KilometerPerHour(speed * Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
	}

	public Speed toMeterPerSecond() {
		return new MeterPerSecond(speed * Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR / Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
	}

	public Speed toMilePerHour() {
		return this;
	}

	public Speed toKnot() {
		return new Knot(speed * Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR / Speed.KNOT_TO_KILOMETER_PER_HOUR);
	}
}
