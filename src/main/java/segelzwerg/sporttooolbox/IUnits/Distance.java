package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Distance {
    private final float kilometer;
    private final float meter;

    /**
     * Constructor
     * @param kilometer - the distance in kilometers
     *
     */
    public Distance(float kilometer) {
        this(kilometer, 0);
    }

    /**
     * Constructor
     * @param kilometer - the distance in kilometers
     * @param meter - and meters.  meters will be added to the kilometers
     *
     */
    public Distance(float kilometer, float meter) {
        this.kilometer = kilometer + (int) meter / 1000;
        this.meter = meter % 1000;
    }

    /**
     * Adds two distance objects together
     * @param toAdd
     * @return 🦄
     *
     */
    public Distance addDistance(Distance toAdd)
    {
        float kilometer= this.kilometer + toAdd.kilometer;
        float meter= this.meter+toAdd.meter;

        return new Distance(kilometer, meter);
    }

    /**
     * Compute the speed based on the distance and the time parameter
     * @param time
     * @return 🏇
     *
     */
    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer, meter);
    }
}
