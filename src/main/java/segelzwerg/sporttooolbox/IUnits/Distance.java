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

    public Distance addDistance(Distance newDistance){
       float kilometer= this.kilometer + newDistance.kilometer + (int) (newDistance.meter + this.meter) / 1000;
        float meter=(this.meter + newDistance.meter) % 1000;

        return new Distance(kilometer,meter);
    }


    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer, meter);
    }
}
