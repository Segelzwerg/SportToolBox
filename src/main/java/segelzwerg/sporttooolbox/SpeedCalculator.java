package segelzwerg.sporttooolbox;

import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;

/**
 * Class to calculate speed
 */
public class SpeedCalculator {

    private final Distance distance;
    private final Time time;

    public SpeedCalculator(Distance distance, Time time) {

        this.distance = distance;
        this.time = time;
    }

    /**
     * Compute speed
     * @return calculated speed
     */
    public Speed computeSpeed() {
        return distance.computeSpeed(time);
    }

    /**
     * Compute pace
     * @return calculated pace
     */
    public Pace computePace() {
        return distance.computePace(time);
    }
}

