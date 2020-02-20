package segelzwerg.sporttooolbox.iunits.distance;

public class DistanceFactory {
    public static Distance createWithOtherThanSIUnits(int majorValue, int minorValue, String majorUnit, String minorUnit) {
        Distance major;
        switch (majorUnit) {
            case "kilometer":
                major = new Kilometer(majorValue);
                break;
            case "miles":
                major = new Miles(majorValue);
                break;
            case "nautical":
                major = new Nautical(majorValue);
                break;
            default:
                throw new IllegalArgumentException("Unexpected unit: " + majorUnit);
        }
        Distance minor;
        switch (minorUnit) {
            case "meter":
                minor = new Kilometer(0, minorValue);
                break;
            case "yards":
                minor = new Miles(0, minorValue);
                break;
            case "fathoms":
                minor = new Nautical(0, minorValue);
                break;
            default:
                throw new IllegalArgumentException("Unexpected unit: " + minorUnit);
        }

        return major.addDistance(minor);
    }
}