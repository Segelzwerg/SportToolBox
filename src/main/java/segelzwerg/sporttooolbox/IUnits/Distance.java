package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;

/**
 * Represents distance in kilometers and meters
 */
@EqualsAndHashCode
public class Distance {
    private final float kilometer;
    private final float meter;

    public Distance(float kilometer) {
        this(kilometer, 0);
    }

    public Distance(float kilometer, float meter) {
        this.kilometer = kilometer + (int) meter / 1000;
        this.meter = meter % 1000;
    }


    /**
     * Add distance
     * @param toAdd distance to add
     * @return new distance
     */
    public Distance addDistance(Distance toAdd)
    {
        float kilometer= this.kilometer + toAdd.kilometer;
        float meter= this.meter+toAdd.meter;

        return new Distance(kilometer, meter);
    }

    /**
     * Compute speed for specific time
     * @param time Amount of time
     * @return calculated speed
     */
    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer, meter);
    }
}
