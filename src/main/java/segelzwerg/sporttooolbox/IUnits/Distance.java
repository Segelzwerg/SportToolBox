package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;

/**
 * Represents distance in kilometers and meters
 */
@EqualsAndHashCode
public class Distance {
    private final float kilometer;
    private final float meter;

    /**
     * Constructor
     *
     * @param kilometer - the distance in kilometers
     * @throws IllegalArgumentException - if kilometer is negative
     */
    public Distance(float kilometer) {
        this(kilometer, 0);
        if (kilometer < 0.0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Constructor
     *
     * @param kilometer - the distance in kilometers
     * @param meter     - and meters.  meters will be added to the kilometers
     */
    public Distance(float kilometer, float meter) {
        this.kilometer = kilometer + (int) meter / 1000;
        this.meter = meter % 1000;
    }

    /**
     * Factory Method
     *
     * @param major     - the distance in the major unit
     * @param minor     - the distance in the minor unit
     * @param majorUnit - the major unit itself
     * @param minorUnit - the minor unit itself
     * @return Distance
     */
    public static Distance createWithOtherThanSIUnits(int major, int minor, String majorUnit, String minorUnit) {
        return new Distance((float) convertMajorToKilometer(major, majorUnit), (float) convertMinorToMeter(minor, minorUnit));
    }

    private static double convertMinorToMeter(float minor, String minorUnit) {
        switch (minorUnit) {
            case "yards":
                return minor * 0.9144;
            case "fathom":
                return minor * 1.8288;
            default:
                return minor;
        }
    }

    private static double convertMajorToKilometer(float major, String majorUnit) {
        switch (majorUnit) {
            case "miles":
                return major * 1.609344;
            case "nautical":
                return major * 1.852;
            default:
                return major;
        }
    }

    /**
     * Add distance
     *
     * @param toAdd distance to add
     * @return new distance
     */
    public Distance addDistance(Distance toAdd) {
        float kilometer = this.kilometer + toAdd.kilometer;
        float meter = this.meter + toAdd.meter;

        return new Distance(kilometer, meter);
    }

    /**
     * Compute speed for specific time
     *
     * @param time Amount of time
     * @return calculated speed
     */
    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer, meter);
    }

    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    public Pace computePace(Time time) {
        return time.computePace(kilometer, meter);
    }
}
