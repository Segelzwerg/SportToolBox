package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

public class Nautical implements Distance {
    private static final float NAUTICAL_TO_KM = 1.852f;
    private static final float NAUTICAL_TO_FATHOMS = 1012.685914261f;
    private final int nautical;
    private final float fathoms;

    Nautical(int nautical, float fathoms) {
        if (nautical < 0 || fathoms < 0) {
            throw new IllegalArgumentException("Distance must not be negative: " + nautical + "nm " + fathoms + "fathoms.");
        }
        this.fathoms = getFathoms(fathoms);
        this.nautical = (int) (nautical + fathoms / NAUTICAL_TO_FATHOMS);
    }

    public Nautical(int nautical) {
        this(nautical, 0);
    }

    public Nautical(float nautical) {
        if (nautical < 0) {
            throw new IllegalArgumentException("Distance must not be negative: " + nautical + "nm.");
        }
        this.nautical = (int) Math.abs(nautical);
        fathoms = (nautical - this.nautical) * NAUTICAL_TO_FATHOMS;
    }

    private static float getFathoms(float fathoms) {
        if (fathoms < NAUTICAL_TO_FATHOMS) {
            return fathoms % NAUTICAL_TO_FATHOMS;
        }
        float miles = fathoms / NAUTICAL_TO_FATHOMS;
        double absMiles = Math.floor(miles);
        double diffMiles = miles - absMiles;
        return (float) (diffMiles * 1000f);
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
        float fathoms = this.fathoms + otherNautical.fathoms;
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
        return time.computeKnots(getNautical());
    }


    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    @Override
    public Pace computePace(Time time) {
        Kilometer kilometer = toKilometer();
        return kilometer.computePace(time);
    }

    @Override
    public Kilometer toKilometer() {
        return new Kilometer(getNautical() * NAUTICAL_TO_KM);
    }

    /**
     * computes the time for a given speed
     *
     * @param speed {@link Speed}
     * @return {@link Time}
     */
    @Override
    public Time computeTime(Speed speed) {
        return speed.computeTime(nautical, fathoms);
    }

    private float getNautical() {
        return nautical + fathoms / NAUTICAL_TO_FATHOMS;
    }
}
