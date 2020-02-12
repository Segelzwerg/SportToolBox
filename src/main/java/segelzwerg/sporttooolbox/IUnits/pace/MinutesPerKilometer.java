package segelzwerg.sporttooolbox.IUnits.pace;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import segelzwerg.sporttooolbox.IUnits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.speed.Speed;

/**
 * Pace of minutes per kilometers
 */
@Getter
@EqualsAndHashCode
public class MinutesPerKilometer implements Pace {
    public static final String unit = "minutes per kilometer";
    private final float pace;

    public MinutesPerKilometer(float pace) {
        this.pace = Math.round(pace * 1000.0) / 1000.0f;
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

    @Override
    public Speed getSpeed() {
        float speedValue = Math.round((1 / pace) * 600000f) / 10000f;
        return new KilometerPerHour(speedValue);
    }

    /**
     * returns the pace in min:ss
     *
     * @return formatted String
     */
    @Override
    public String toString() {
        double seconds = pace - Math.floor(pace);
        return (int) Math.floor(this.pace) + ":" + (int) (Math.round(seconds * 60.0));
    }

}
