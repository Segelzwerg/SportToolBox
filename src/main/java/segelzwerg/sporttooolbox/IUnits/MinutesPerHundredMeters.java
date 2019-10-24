package segelzwerg.sporttooolbox.IUnits;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Pace of minutes per hundred meters
 */
@Getter
@Setter
@EqualsAndHashCode
public class MinutesPerHundredMeters implements Pace {
    private final float pace;

    public MinutesPerHundredMeters(float pace) {
        this.pace = pace;
    }

    /**
     * Converting to minutes per kilometers
     * @return Pace instance with a converted numeric value
     */
    @Override
    public Pace toMinutesPerKilometer() {
        return new MinutesPerKilometer(pace * PER_HUNDRED_METER_TO_PER_KILOMETER);
    }

    /**
     * Converting to minutes per hundred meters
     * @return itself, since there's no conversion to be made
     */
    @Override
    public Pace toMinutesPerHundredMeters() {
        return this;
    }
}
