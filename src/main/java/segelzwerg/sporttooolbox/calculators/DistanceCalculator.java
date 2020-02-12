package segelzwerg.sporttooolbox.calculators;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttooolbox.iunits.Distance;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Calculator for distance from time and speed or pace
 */
@EqualsAndHashCode
public class DistanceCalculator {
    private final Speed speed;
    private final Time time;

    /**
     * constructor
     *
     * @param speed {@link Speed}
     * @param time  {@link Time}
     */
    public DistanceCalculator(Speed speed, Time time) {

        this.speed = speed;
        this.time = time;
    }

    /**
     * computes the distance from a given speed and time
     *
     * @return {@link Distance}
     */
    public Distance computeDistance() {
        return null;
    }
}
