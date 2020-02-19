package segelzwerg.sporttooolbox.iunits.distance;

class Nautical {
    private final int nautical;
    private final int fathoms;

    Nautical(int nautical, int fathoms) {
        this.nautical = nautical;
        this.fathoms = fathoms;
    }

    Nautical(int nautical) {
        this(nautical, 0);
    }
}
