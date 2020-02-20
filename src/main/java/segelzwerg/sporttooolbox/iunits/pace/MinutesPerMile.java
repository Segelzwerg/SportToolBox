package segelzwerg.sporttooolbox.iunits.pace;

import segelzwerg.sporttooolbox.iunits.speed.MeterPerSecond;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

public class MinutesPerMile implements Pace {
    private final float pace;

    public MinutesPerMile(float pace) {
        this.pace = pace;
    }

    /**
     * Converts to minutes per kilometers
     *
     * @return an instance of Pace
     */
    @Override
    public Pace toMinutesPerKilometer() {
        return new MinutesPerKilometer(pace * Pace.PER_MILE_TO_PER_KM);
    }

    /**
     * Converts to minutes per hundred-meters
     *
     * @return an instance of Pace
     */
    @Override
    public Pace toMinutesPerHundredMeters() {
        return new MinutesPerHundredMeters(pace * Pace.PER_MILE_TO_PER_100_M);
    }

    /**
     * Converts to minutes per mile
     *
     * @return an instance of Pace
     */
    @Override
    public Pace toMinutesPerMile() {
        return this;
    }

    /**
     * converts pace to speed
     *
     * @return {@link MeterPerSecond} as it is SI
     */
    @Override
    public Speed getSpeed() {
        return null;
    }
}
