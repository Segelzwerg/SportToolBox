package segelzwerg.sporttoolbox.calculators;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttoolbox.iunits.distance.Distance;
import segelzwerg.sporttoolbox.iunits.Time;
import segelzwerg.sporttoolbox.iunits.pace.Pace;
import segelzwerg.sporttoolbox.iunits.speed.Speed;

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

