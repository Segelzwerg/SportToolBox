package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

public class DistanceCalculator {
    private final Speed speed;
    private final Time time;

    DistanceCalculator(Speed speed, Time time) {
        this.speed = speed;
        this.time = time;
    }

    public Distance computeDistance() {
        return speed.computeDistance(time);
    }
}
