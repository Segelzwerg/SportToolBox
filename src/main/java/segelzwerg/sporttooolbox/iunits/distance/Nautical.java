package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.converters.DistanceConverterService;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import java.text.DecimalFormat;

import static segelzwerg.sporttooolbox.converters.DistanceConverterService.*;

public class Nautical implements Distance {
    private final int nautical;
    private final double fathoms;

    Nautical(int nautical, double fathoms) {
        if (nautical < 0 || fathoms < 0) {
            throw new IllegalArgumentException("Distance must not be negative: " + nautical + "nm " + fathoms + "fathoms.");
        }
        this.fathoms = getFathoms(fathoms);
        this.nautical = (int) (nautical + fathoms * FATHOMS_TO_NAUTICAL);
    }

    public Nautical(int nautical) {
        this(nautical, 0);
    }

    public Nautical(double nautical) {
        if (nautical < 0) {
            throw new IllegalArgumentException("Distance must not be negative: " + nautical + "nm.");
        }
        this.nautical = (int) Math.abs(nautical);
        double fathomsCalculated = (nautical - this.nautical) * NAUTICAL_TO_FATHOMS;
        DecimalFormat decimalFormat = new DecimalFormat(".00");
        String format = decimalFormat.format(fathomsCalculated);
        fathoms = Double.parseDouble(format.replace(",", "."));
    }

    private static double getFathoms(double fathoms) {
        if (fathoms < NAUTICAL_TO_FATHOMS) {
            return fathoms % NAUTICAL_TO_FATHOMS;
        }
        double miles = fathoms / NAUTICAL_TO_FATHOMS;
        double absMiles = Math.floor(miles);
        double diffMiles = miles - absMiles;
        return diffMiles * 1000;
    }

    /**
     * Add distance
     *
     * @param toAdd distance to add
     * @return new distance
     */
    @Override
    public Distance addDistance(Distance toAdd) {
        if (Nautical.class != toAdd.getClass()) {
            throw new IllegalArgumentException("Currently only Nauticals are allowed to add.");
        }
        Nautical otherNautical = (Nautical) toAdd;
        int nautical = this.nautical + otherNautical.nautical;
        double fathoms = this.fathoms + otherNautical.fathoms;
        return new Nautical(nautical, fathoms);
    }

    /**
     * Compute speed for specific time
     *
     * @param time Amount of time
     * @return calculated speed
     */
    @Override
    public Speed computeSpeed(Time time) {
        return time.computeKnots((float) getNautical());
    }


    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    @Override
    public Pace computePace(Time time) {
        Kilometer kilometer = new Kilometer(getNautical() * NAUTICAL_TO_KM);
        return kilometer.computePace(time);
    }

    @Override
    public Distance convertTo(Distance distance) {
        return DistanceConverterService.convertTo(this, distance);
    }

    @Override
    public Nautical convertFrom(Distance distance) {
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
        return speed.computeTime(nautical, (float) fathoms);
    }

    public double getNautical() {
        return (nautical + fathoms / NAUTICAL_TO_FATHOMS);
    }
}
