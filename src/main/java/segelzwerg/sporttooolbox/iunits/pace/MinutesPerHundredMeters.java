package segelzwerg.sporttooolbox.iunits.pace;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Pace of minutes per hundred meters
 */
@Getter
@EqualsAndHashCode
public class MinutesPerHundredMeters implements Pace {
    public static final String unit = "minutes per 100 meters";
    private final float pace;

    public MinutesPerHundredMeters(float pace) {
        this.pace = pace;
    }

    /**
     * Converting to minutes per kilometers
     *
     * @return Pace instance with a converted numeric value
     */
    @Override
    public Pace toMinutesPerKilometer() {
        return new MinutesPerKilometer(pace * PER_HUNDRED_METER_TO_PER_KILOMETER);
    }

    /**
     * Converting to minutes per hundred meters
     *
     * @return itself, since there's no conversion to be made
     */
    @Override
    public Pace toMinutesPerHundredMeters() {
        return this;
    }

    /**
     * Converts to minutes per mile
     *
     * @return an instance of Pace
     */
    @Override
    public Pace toMinutesPerMile() {
        return new MinutesPerMile(pace * 16.09344f);
    }

    @Override
    public Speed getSpeed() {
        return new KilometerPerHour(6f / pace);
    }

    /**
     * returns the pace in min:ss
     *
     * @return formatted String
     */
    @Override
    public String toString() {
        return (int) Math.floor(pace) + ":" + (int) (Math.round(pace * 60.0));
    }
}
