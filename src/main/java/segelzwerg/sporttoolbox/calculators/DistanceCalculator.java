package segelzwerg.sporttoolbox.calculators;

import segelzwerg.sporttoolbox.iunits.Time;
import segelzwerg.sporttoolbox.iunits.distance.Distance;
import segelzwerg.sporttoolbox.iunits.pace.Pace;
import segelzwerg.sporttoolbox.iunits.speed.Speed;

public class DistanceCalculator {
    private final Speed speed;
    private final Time time;

    DistanceCalculator(Speed speed, Time time) {
        this.speed = speed;
        this.time = time;
    }

    DistanceCalculator(Pace pace, Time time) {
        this(pace.getSpeed(), time);
    }

    public Distance computeDistance() {
        return speed.computeDistance(time);
    }
}
