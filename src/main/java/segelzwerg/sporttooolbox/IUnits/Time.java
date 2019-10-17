package segelzwerg.sporttooolbox.IUnits;

public class Time {
    private final int hour;
    private final int minutes;
    private final int seconds;

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
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Speed computeSpeed(float kilometer, float meter) {
        return new Speed((kilometer + meter / 1000) / inHours());
    }

    protected float inHours() {
        return hour + (minutes / 60f) + (seconds / 3_600f);
    }
}
