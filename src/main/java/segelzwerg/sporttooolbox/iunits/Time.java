package segelzwerg.sporttooolbox.iunits;

import lombok.EqualsAndHashCode;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerMile;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Knot;
import segelzwerg.sporttooolbox.iunits.speed.MilePerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Time in hours, minutes and second
 */
@EqualsAndHashCode(of = "seconds")
public class Time {
    private static final float HOURS_TO_MINUTES = 60.0f;
    private static final float HOURS_TO_SECONDS = 3_600f;
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
        this.seconds = (long) ((hour * HOURS_TO_SECONDS) + (minutes * 60) + seconds);
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
     * Get meters from parameters
     *
     * @param kilometer amount of kilometers
     * @param meter     amount of meters
     * @return numeric representation of meters
     */
    @Deprecated
    private static float getMeters(float kilometer, float meter) {
        return (kilometer + meter / 1000);
    }

    public KilometerPerHour computeKPH(float kilometer) {
        return new KilometerPerHour(HOURS_TO_SECONDS * kilometer / seconds);
    }

    /**
     * calculates the speed in miles per hour
     *
     * @param miles float representing the distance in miles
     * @return {@link MilePerHour}
     */
    public MilePerHour computeMPH(float miles) {
        return new MilePerHour(HOURS_TO_SECONDS * miles / seconds);
    }

    public Knot computeKnots(float nautical) {
        return new Knot(HOURS_TO_SECONDS * nautical / seconds);
    }

    /**
     * Compute speed on specific distance
     *
     * @param kilometer amount of kilometers
     * @param meter     amount of meters
     * @return calculated speed
     */
    @Deprecated
    public Speed computeSpeed(float kilometer, float meter) {
        return new KilometerPerHour(HOURS_TO_SECONDS * getMeters(kilometer, meter) / seconds);
    }

    public MinutesPerKilometer computeMinPerKM(float kilometer) {
        return new MinutesPerKilometer(getMinutes() / kilometer);
    }

    public MinutesPerMile computeMinPerMI(float miles) {
        return new MinutesPerMile(getMinutes() / miles);
    }

    /**
     * Compute pace given some distances
     *
     * @param kilometer amount of kilometers
     * @param meter     amout of meters
     * @return calculated pace
     */
    @Deprecated
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
        return (int) (seconds / HOURS_TO_SECONDS);
    }

    /**
     * calculates only the minutes
     *
     * @return minutes as integer
     */
    private int getOnlyMinutes() {
        return (int) (((seconds / 3600.0) - getOnlyHours()) * HOURS_TO_MINUTES);
    }

    /**
     * calculates only the seconds
     *
     * @return seconds as integer
     */
    private int getOnlySeconds() {
        return (int) (seconds - getOnlyHours() * HOURS_TO_SECONDS - getOnlyMinutes() * HOURS_TO_MINUTES);
    }

    /**
     * Get minutes from class properties
     *
     * @return numeric representation of minutes
     */
    private float getMinutes() {
        return seconds / HOURS_TO_MINUTES;
    }


}
