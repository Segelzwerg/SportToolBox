package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;

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

    public Speed computeSpeed(float kilometer, float meter) {
        return new Speed(3_600f * (kilometer + meter / 1000) / seconds);
    }
}
