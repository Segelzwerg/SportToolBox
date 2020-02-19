package segelzwerg.sporttooolbox.iunits.distance;

public class Kilometer {
    private final int kilometer;
    private final int meter;

    public Kilometer(int kilometer) {
        this(kilometer, 0);
    }

    public Kilometer(int kilometer, int meter) {

        this.kilometer = kilometer;
        this.meter = meter;
    }
}
