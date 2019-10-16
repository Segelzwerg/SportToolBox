package segelzwerg.sporttooolbox.IUnits;

public class Distance {
    private final float hour;

    public Distance(float hour) {
        this.hour = hour;
    }

    public Speed computeSpeed(Time time) {
        return time.computeSpeed(hour);
    }
}
