package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

class Miles implements Distance {
    private static final float MILES_TO_KM = 1.6093444f;
    private static final float MILES_TO_YARDS = 1760f;
    private final int miles;
    private final int yards;

    Miles(int miles) {
        this(miles, 0);
    }

    Miles(int miles, int yards) {
        if (miles < 0 || yards < 0) {
            throw new IllegalArgumentException("Distances must not be negative. " + miles + "mi " + yards + "yrd.");
        }
        this.yards = (int) (yards % MILES_TO_YARDS);
        this.miles = (int) (miles + Math.floor(yards / MILES_TO_YARDS));
    }

    /**
     * Add distance
     *
     * @param toAdd distance to add
     * @return new distance
     */
    @Override
    public Distance addDistance(Distance toAdd) {
        if (Miles.class != toAdd.getClass()) {
            throw new IllegalArgumentException("Currently only Miles addition is allowed.");
        }
        Miles otherMiles = (Miles) toAdd;

        int miles = this.miles + otherMiles.miles;
        int yards = this.yards + otherMiles.yards;
        return new Miles(miles, yards);
    }

    /**
     * Compute speed for specific time
     *
     * @param time Amount of time
     * @return calculated speed
     */
    @Override
    public Speed computeSpeed(Time time) {
        return time.computeMPH(getMiles());
    }

    private float getMiles() {
        return miles + yards / MILES_TO_YARDS;
    }

    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    @Override
    public Pace computePace(Time time) {
        return time.computeMinPerMI(getMiles());
    }

    @Override
    public Kilometer toKilometer() {
        return new Kilometer(getMiles() * MILES_TO_KM);
    }

    /**
     * computes the time for a given speed
     *
     * @param speed {@link Speed}
     * @return {@link Time}
     */
    @Override
    public Time computeTime(Speed speed) {
        return speed.computeTime(miles, yards);
    }
}
