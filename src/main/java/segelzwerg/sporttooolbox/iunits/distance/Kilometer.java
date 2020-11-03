package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.converters.DistanceConverterService;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static segelzwerg.sporttooolbox.converters.DistanceConverterService.KILOMETER_TO_METERS;

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

        this.meter = meter % 1000;
        this.kilometer = (int) (kilometer + Math.floor(meter / 1000f));
    }

    public Kilometer(double kilometer) {
        if (kilometer < 0) {
            throw new IllegalArgumentException("Distance must not be negative: " + kilometer + "km.");
        }
        this.kilometer = (int) Math.abs(kilometer);
        double kilometerDifference = kilometer % this.kilometer;
        meter = (int) (Math.round(kilometerDifference * KILOMETER_TO_METERS * 10) / 10f);
    }

    @Override
    public Speed computeSpeed(Time time) {
        return time.computeKPH(getKilometer());
    }

    public float getKilometer() {
        return (float) (kilometer + meter / KILOMETER_TO_METERS);
    }

    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    @Override
    public Pace computePace(Time time) {
        return time.computeMinPerKM(getKilometer());
    }

    @Override
    public Distance convertTo(Distance distance) {
        return DistanceConverterService.convertTo(this, distance);
    }

    @Override
    public Kilometer convertFrom(Distance distance) {
        return DistanceConverterService.convertFrom(distance, this);
    }

    /**
     * computes the time for a given speed
     *
     * @param speed {@link Speed}
     * @return {@link Time}
     */
    @Override
    public Time computeTime(Speed speed) {
        return speed.computeTime(kilometer, meter);
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

    @Override
    public String toString() {
        return kilometer + " kilometer and " + meter + " meter";
    }
}
