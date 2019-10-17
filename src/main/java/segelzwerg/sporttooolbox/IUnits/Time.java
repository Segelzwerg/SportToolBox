package segelzwerg.sporttooolbox.IUnits;

public class Time {
    private final int hour;

    public Time(int hour) {
        this.hour = hour;
    }

    public Speed computeSpeed(float kilometer, float meter) {
        return new Speed((kilometer + meter / 1000) / hour);
    }
}
