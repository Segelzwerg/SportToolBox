package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

class Nautical implements Distance {
    private final float NAUTICAL_TO_FATHOMS = 1012.68591f;
    private final int nautical;
    private final float fathoms;

    Nautical(int nautical, float fathoms) {
        this.fathoms = fathoms % NAUTICAL_TO_FATHOMS;
        this.nautical = (int) (nautical + fathoms / NAUTICAL_TO_FATHOMS);
    }

    Nautical(int nautical) {
        this(nautical, 0);
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
        return null;
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
}
