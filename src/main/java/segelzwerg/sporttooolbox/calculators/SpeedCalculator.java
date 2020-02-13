package segelzwerg.sporttooolbox.calculators;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Class to calculate speed
 */
@EqualsAndHashCode
public class SpeedCalculator {

    private final Distance distance;
    private final Time time;

    public SpeedCalculator(Distance distance, Time time) {

        this.distance = distance;
        this.time = time;
    }

    /**
     * Compute speed
     *
     * @return calculated speed
     */
    public Speed computeSpeed() {
        return distance.computeSpeed(time);
    }

    /**
     * Compute pace
     *
     * @return calculated pace
     */
    public Pace computePace() {
        return distance.computePace(time);
    }
}

