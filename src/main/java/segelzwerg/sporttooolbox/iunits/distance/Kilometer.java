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
        this.kilometer = kilometer;
        this.meter = meter;
    }

    public Speed computeSpeed(Time time) {
        return null;
    }

    public Kilometer addDistance(Distance distance) {
        return null;
    }
}
