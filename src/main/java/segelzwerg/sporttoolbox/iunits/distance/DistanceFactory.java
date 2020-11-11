package segelzwerg.sporttoolbox.iunits.distance;

public final class DistanceFactory {
    /**
     * prevents instantiating
     */
    private DistanceFactory() {
    }

    public static Distance createWithOtherThanSIUnits(int majorValue, int minorValue, String majorUnit, String minorUnit) {
        Distance major = getMajorDistance(majorValue, majorUnit);
        Distance minor = getMinorDistance(minorValue, minorUnit);

        return major.addDistance(minor);
    }

    private static Distance getMinorDistance(int minorValue, String minorUnit) {
        switch (minorUnit) {
            case "meter":
                return new Kilometer(0, minorValue);
            case "yards":
                return new Miles(0, minorValue);
            case "fathoms":
                return new Nautical(0, minorValue);
            default:
                throw new IllegalArgumentException("Unexpected unit: " + minorUnit);
        }
    }

    private static Distance getMajorDistance(int majorValue, String majorUnit) {
        switch (majorUnit) {
            case "kilometer":
                return new Kilometer(majorValue);
            case "miles":
                return new Miles(majorValue);
            case "nautical":
                return new Nautical(majorValue);
            default:
                throw new IllegalArgumentException("Unexpected unit: " + majorUnit);
        }
    }
}