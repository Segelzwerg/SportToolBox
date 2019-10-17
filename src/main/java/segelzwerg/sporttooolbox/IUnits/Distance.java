package segelzwerg.sporttooolbox.IUnits;

public class Distance {
    private final float kilometer;
	private final float meter;

    public Distance(float kilometer) {
		this(kilometer, 0);
    }

	public Distance(float kilometer, float meter) {
		this.kilometer = kilometer + (int) meter / 1000;
		this.meter = meter % 1000;
	}

    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer, meter);
    }
}
