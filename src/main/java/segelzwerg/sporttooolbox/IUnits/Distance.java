package segelzwerg.sporttooolbox.IUnits;

public class Distance {
    private final float kilometer;

    public Distance(float kilometer) {
        this.kilometer = kilometer;
    }

    public Speed computeSpeed(Time time) {
        return time.computeSpeed(kilometer);
    }
}
