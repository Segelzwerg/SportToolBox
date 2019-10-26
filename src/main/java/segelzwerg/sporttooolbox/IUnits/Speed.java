package segelzwerg.sporttooolbox.IUnits;

/**
 * Speed interface
 */
public abstract class Speed {

	public static final float METER_PER_SECOND_TO_KILOMETER_PER_HOUR = 3.6f;
	public static final float MILE_PER_HOUR_TO_KILOMETER_PER_HOUR = 1.609344f;
	public static final float KNOT_TO_KILOMETER_PER_HOUR = 1.852f;

	private float speed;
	
	public Speed(float speed) {
		this.speed = speed;
	}

	/**
	 * Convert to kilometer per hour
	 * @return speed in kilometer per hour
	 */
	public abstract Speed toKilometerPerHour();
	/**
	 * Convert to meter per second
	 * @return speed in meter per second
	 */
	public abstract Speed toMeterPerSecond();
	/**
	 * Convert to mile per hour
	 * @return speed in mile per hour
	 */
	public abstract Speed toMilePerHour();
	/**
	 * Convert to knot
	 * @return speed in knot
	 */
	public abstract Speed toKnot();

    float getSpeed() {
    	return speed;
    }
}
