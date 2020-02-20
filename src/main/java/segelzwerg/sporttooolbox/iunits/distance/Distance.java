package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Represents distance in kilometers and meters
 */
public interface Distance {
    double MILES_TO_YARDS = 1760.0;
    double FATHOMS_TO_NAUTICAL_MILES = 1 / 1013.3333334;


    /**
     * Add distance
     *
     * @param toAdd distance to add
     * @return new distance
     */
    Distance addDistance(Distance toAdd);

    /**
     * Compute speed for specific time
     *
     * @param time Amount of time
     * @return calculated speed
     */
    Speed computeSpeed(Time time);

    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    Pace computePace(Time time);

    Kilometer toKilometer();

    /**
     * computes the time for a given speed
     *
     * @param speed {@link Speed}
     * @return {@link Time}
     */
    Time computeTime(Speed speed);
}
