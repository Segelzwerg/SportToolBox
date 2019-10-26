package segelzwerg.sporttooolbox.IUnits;
import lombok.EqualsAndHashCode;
/**
 * Time in hours
 */
@EqualsAndHashCode(of = "seconds")
public class Time {
    private final long seconds;

    public Time(int hour) {
        this(hour, 0, 0);
    }

    public Time(int hour, int minutes) {
        this(hour, minutes, 0);
    }

    public Time(int hour, int minutes, int seconds) {
        if (hour < 0 || minutes < 0 || seconds < 0) {
            throw new IllegalArgumentException("Times must not be negative");
        }
        this.seconds = (hour * 3_600) + (minutes * 60) + seconds;
    }

    /**
     * Compute speed on specific distance
     * @param kilometer amount of kilometers
     * @param meter amount of meters
     * @return calculated speed
     */
    public Speed computeSpeed(float kilometer, float meter) {
        return new KilometerPerHour(3_600f * (kilometer + meter / 1000) / seconds);
    }
}
