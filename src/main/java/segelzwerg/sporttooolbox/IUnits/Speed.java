package segelzwerg.sporttooolbox.IUnits;

public interface Speed {

	public static final float METER_PER_SECOND_TO_KILOMETER_PER_HOUR = 3.6f;
	public static final float MILE_PER_HOUR_TO_KILOMETER_PER_HOUR = 1.609344f;
	public static final float KNOT_TO_KILOMETER_PER_HOUR = 1.852f;

	public Speed toKilometerPerHour();
	public Speed toMeterPerSecond();
	public Speed toMilePerHour();
	public Speed toKnot();
}
