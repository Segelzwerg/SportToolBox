package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

public class Kilometer implements Distance {
    private final int kilometer;
    private final int meter;

    public Kilometer(int kilometer) {
        this(kilometer, 0);
    }

    public Kilometer(int kilometer, int meter) {
        if (kilometer < 0 || meter < 0) {
            throw new IllegalArgumentException("Distance must not be negative: " + kilometer + "km " + meter + "m.");
        }
        this.kilometer = kilometer;
        this.meter = meter;
    }

    public Kilometer(float kilometer) {
        this.kilometer = (int) Math.abs(kilometer);
        meter = (int) ((kilometer - this.kilometer) * 1000);
    }

    @Override
    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer, meter);
    }

    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    @Override
    public Pace computePace(Time time) {
        return null;
    }

    /**
     * computes the time for a given speed
     *
     * @param speed {@link Speed}
     * @return {@link Time}
     */
    @Override
    public Time computeTime(Speed speed) {
        return null;
    }

    @Override
    public Kilometer addDistance(Distance distance) {
        if (Kilometer.class != distance.getClass()) {
            throw new IllegalArgumentException("Currently only Kilometer Additions is allowed.");
        }
        Kilometer otherKilometer = (Kilometer) distance;
        int kilometer = otherKilometer.kilometer + this.kilometer;
        int meter = otherKilometer.meter + this.meter;
        return new Kilometer(kilometer, meter);
    }
}
