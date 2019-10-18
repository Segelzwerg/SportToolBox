package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class MeterPerSecond implements Speed {
    private final float speed;

    public MeterPerSecond(float speed) {

        this.speed = speed;
    }

	public Speed toKilometerPerHour() {
		return new KilometerPerHour(speed * Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR);
	}

	public Speed toMeterPerSecond() {
		return this;
	}

	public Speed toMilePerHour() {
		return new MilePerHour(speed * Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR / Speed.MILE_PER_HOUR_TO_KILOMETER_PER_HOUR);
	}

	public Speed toKnot() {
		return new Knot(speed * Speed.METER_PER_SECOND_TO_KILOMETER_PER_HOUR / Speed.KNOT_TO_KILOMETER_PER_HOUR);
	}
}
