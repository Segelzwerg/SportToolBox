package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Represents distance in kilometers and meters
 */
public interface Distance {
    double MILES_TO_YARDS = 1760.0;
    double FATHOMS_TO_NAUTICAL_MILES = 1 / 1013.3333334;


    static double convertMinorToMeter(float minor, String minorUnit) {
        double result;
        switch (minorUnit) {
            case "yards":
                result = minor * 0.9144;
                break;
            case "fathom":
                result = minor * 1.8288;
                break;
            case "meter":
                result = minor;
                break;
            default:
                throw new IllegalArgumentException("This is not a valid unit: " + minorUnit);
        }
        return result;
    }

    static double convertMajorToKilometer(float major, String majorUnit) {
        switch (majorUnit) {
            case "miles":
                return major * 1.609344;
            case "nautical":
                return major * 1.852;
            case "kilometer":
                return major;
            default:
                throw new IllegalArgumentException("This is not a valid unit: " + majorUnit);
        }
    }

    /**
     * Add distance
     *
     * @param toAdd distance to add
     * @return new distance
     */
    Distance addDistance(Distance toAdd);

    /**
     * Compute speed for specific time
     *
     * @param time Amount of time
     * @return calculated speed
     */
    Speed computeSpeed(Time time);

    /**
     * Compute pace given a specific time
     *
     * @param time amount of time
     * @return calculated pace
     */
    Pace computePace(Time time);

    /**
     * computes the time for a given speed
     *
     * @param speed {@link Speed}
     * @return {@link Time}
     */
    Time computeTime(Speed speed);
}
