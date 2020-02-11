package segelzwerg.sporttooolbox.calculators;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;

@EqualsAndHashCode
public class TimeCalculator {
    private final Distance distance;
    private final Speed speed;

    /**
     * constructor
     *
     * @param distance {@link Distance}
     * @param speed    {@link Speed}
     */
    public TimeCalculator(Distance distance, Speed speed) {

        this.distance = distance;
        this.speed = speed;
    }

    /**
     * calculates the time for a given distance and speed
     *
     * @return {@link Time}
     */
    public Time computeTime() {
        return distance.computeTime(speed);
    }
}
