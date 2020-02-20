package segelzwerg.sporttooolbox.iunits.distance;

import segelzwerg.sporttooolbox.iunits.pace.Pace;
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
        return null;
    }

    /**
     * Converts to minutes per hundred-meters
     *
     * @return an instance of Pace
     */
    @Override
    public Pace toMinutesPerHundredMeters() {
        return null;
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
