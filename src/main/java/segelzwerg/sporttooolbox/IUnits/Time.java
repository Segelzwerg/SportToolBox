package segelzwerg.sporttooolbox.IUnits;

public class Time {
    private final float hour;

    public Time(float hour) {
        this.hour = hour;
    }

    public Speed computeSpeed(float kilometer) {
        return new Speed(kilometer / hour);
    }
}
