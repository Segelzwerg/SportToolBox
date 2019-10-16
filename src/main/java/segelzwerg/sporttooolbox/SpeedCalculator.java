package segelzwerg.sporttooolbox;

import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;

public class SpeedCalculator {

    private final Distance distance;
    private final Time time;

    public SpeedCalculator(Distance distance, Time time) {

        this.distance = distance;
        this.time = time;
    }

    public Speed computeSpeed() {
        return distance.computeSpeed(time);
    }
}
