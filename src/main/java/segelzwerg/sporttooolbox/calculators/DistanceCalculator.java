package segelzwerg.sporttooolbox.calculators;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttooolbox.iunits.Distance;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

@EqualsAndHashCode
public class DistanceCalculator {
    private final Speed speed;
    private final Time time;

    public DistanceCalculator(Speed speed, Time time) {

        this.speed = speed;
        this.time = time;
    }

    public Distance computeDistance() {
        return null;
    }
}
