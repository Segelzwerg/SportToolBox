package segelzwerg.sporttoolbox.iunits.pace;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import segelzwerg.sporttoolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttoolbox.iunits.speed.Speed;

/**
 * Pace of minutes per kilometers
 */
@Getter
@EqualsAndHashCode
public class MinutesPerKilometer implements Pace {
    public static final String unit = "minutes per kilometer";
    private final float pace;

    public MinutesPerKilometer(float pace) {
        this.pace = pace;
    }

    /**
     * Converting to minutes per kilometers
     *
     * @return itself, since there's no conversion to be made
     */
    @Override
    public Pace toMinutesPerKilometer() {
        return this;
    }

    /**
     * Converting to minutes per hundred meters
     *
     * @return Pace instance with a converted numeric value
     */
    @Override
    public Pace toMinutesPerHundredMeters() {
        return new MinutesPerHundredMeters(pace * PER_KILOMETER_TO_PER_HUNDRED_METER);
    }

    /**
     * Converts to minutes per mile
     *
     * @return an instance of Pace
     */
    @Override
    public Pace toMinutesPerMile() {
        return null;
    }

    @Override
    public Speed getSpeed() {
        return new KilometerPerHour(60f / pace);
    }

    /**
     * returns the pace in min:ss
     *
     * @return formatted String
     */
    @Override
    public String toString() {
        double seconds = pace - Math.floor(pace);
        return (int) Math.floor(pace) + ":" + (int) (Math.round(seconds * 60.0));
    }
}
