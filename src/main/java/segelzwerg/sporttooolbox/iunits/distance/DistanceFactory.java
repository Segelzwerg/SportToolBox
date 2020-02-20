package segelzwerg.sporttooolbox.iunits.distance;

public class DistanceFactory {
    public static Distance createWithOtherThanSIUnits(int majorValue, int minorValue, String majorUnit, String minorUnit) {
        Distance major;
        switch (majorUnit) {
            case "kilometer":
                major = new Kilometer(majorValue);
                break;
            default:
                throw new IllegalArgumentException("Unexpected unit: " + majorUnit);
        }
        Distance minor;
        switch (minorUnit) {
            case "meter":
                minor = new Kilometer(0, minorValue);
                break;
            default:
                throw new IllegalArgumentException("Unexpected unit: " + minorUnit);
        }

        return major.addDistance(minor);
    }
}