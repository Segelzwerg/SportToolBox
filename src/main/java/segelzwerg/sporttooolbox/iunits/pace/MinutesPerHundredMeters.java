package segelzwerg.sporttooolbox.iunits.pace;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import segelzwerg.sporttooolbox.Provisional;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

/**
 * Pace of minutes per hundred meters
 */
@Getter
@EqualsAndHashCode
public class MinutesPerHundredMeters implements Pace {
    /**
     * String of the English unit used for output.
     */
    @Provisional
    public static final String UNIT = "minutes per 100 meters";
    private final float pace;

    /**
     * @param pace float the value of the pace. Seconds as decimals of a minute
     */
    public MinutesPerHundredMeters(float pace) {
        this.pace = Math.round(pace * 1000.0) / 1000.0f;
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
     * converts the pace to kilometer per hour
     *
     * @return
     */
    @Override
    public Speed getSpeed() {
        float speedValue = Math.round((1 / pace) * 600f) / 100f;
        return new KilometerPerHour(speedValue);
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
