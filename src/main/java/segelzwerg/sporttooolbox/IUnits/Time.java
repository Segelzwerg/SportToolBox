package segelzwerg.sporttooolbox.IUnits;

/**
 * Time in hours
 */
public class Time {
    private final int hour;

    public Time(int hour) {
        this.hour = hour;
    }

    /**
     * Compute speed on specific distance
     * @param kilometer amount of kilometers
     * @param meter amount of meters
     * @return calculated speed
     */
    public Speed computeSpeed(float kilometer, float meter) {
        return new KilometerPerHour((kilometer + meter / 1000) / hour);
    }
}
