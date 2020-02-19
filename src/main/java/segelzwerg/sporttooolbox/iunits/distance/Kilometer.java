package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

public class Kilometer extends Distance {
    private final int kilometer;
    private final int meter;

    public Kilometer(int kilometer) {
        this(kilometer, 0);
    }

    public Kilometer(int kilometer, int meter) {
        super(kilometer, meter);
        if (kilometer < 0 || meter < 0)
            throw new IllegalArgumentException("Distance must not be negative: " + kilometer + "km " + meter + "m.");
        this.kilometer = kilometer;
        this.meter = meter;
    }

    @Override
    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer, meter);
    }

    @Override
    public Kilometer addDistance(Distance distance) {
        if (Kilometer.class != distance.getClass())
            throw new IllegalArgumentException("Currently only Kilometer Additions is allowed.");
        Kilometer otherKilometer = (Kilometer) distance;
        int kilometer = otherKilometer.kilometer + this.kilometer;
        int meter = otherKilometer.meter + this.meter;
        return new Kilometer(kilometer, meter);
    }
}
