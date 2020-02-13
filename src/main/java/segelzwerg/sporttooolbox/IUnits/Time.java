package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Time in hours, minutes and second
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
     * converts the time from float to seconds in long
     *
     * @param time in hour decimals: HH.XXX
     */
    public Time(float time) {
        seconds = (long) (time * 3600);
    }

    /**
     * Compute speed on specific distance
     *
     * @param kilometer amount of kilometers
     * @param meter     amount of meters
     * @return calculated speed
     */
    public Speed computeSpeed(float kilometer, float meter) {
        return new KilometerPerHour(3_600f * getMeters(kilometer, meter) / seconds);
    }

    /**
     * Compute pace given some distances
     *
     * @param kilometer amount of kilometers
     * @param meter     amout of meters
     * @return calculated pace
     */
    public Pace computePace(float kilometer, float meter) {
        return new MinutesPerKilometer(getMinutes() / getMeters(kilometer, meter));
    }

    /**
     * Prints the time.
     *
     * @return hours minutes and seconds
     */
    @Override
    public String toString() {
        int hour = getOnlyHours();
        int minute = getOnlyMinutes();
        int second = getOnlySeconds();
        //TODO: multilanguage support
        return hour + " hour(s), " + minute + " minute(s) and " + second + " second(s)";
    }

    /**
     * calculates only the hours
     *
     * @return hours as integer
     */
    private int getOnlyHours() {
        return (int) (seconds / 3600);
    }

    /**
     * calculates only the minutes
     *
     * @return minutes as integer
     */
    private int getOnlyMinutes() {
        return (int) (((seconds / 3600.0) - getOnlyHours()) * 60.0);
    }

    /**
     * calculates only the seconds
     *
     * @return seconds as integer
     */
    private int getOnlySeconds() {
        return (int) (seconds - getOnlyHours() * 3600 - getOnlyMinutes() * 60);
    }

    /**
     * Get meters from parameters
     *
     * @param kilometer amount of kilometers
     * @param meter     amount of meters
     * @return numeric representation of meters
     */
    private float getMeters(float kilometer, float meter) {
        return (kilometer + meter / 1000);
    }

    /**
     * Get minutes from class properties
     *
     * @return numeric representation of minutes
     */
    private float getMinutes() {
        return seconds / 60.0f;
    }
}
