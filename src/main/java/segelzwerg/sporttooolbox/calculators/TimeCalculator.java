package segelzwerg.sporttooolbox.calculators;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Time;

@EqualsAndHashCode
public class TimeCalculator {
    private final Distance distance;
    private final Distance.Speed speed;

    /**
     * constructor
     *
     * @param distance {@link Distance}
     * @param speed    {@link Distance.Speed}
     */
    public TimeCalculator(Distance distance, Distance.Speed speed) {

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
