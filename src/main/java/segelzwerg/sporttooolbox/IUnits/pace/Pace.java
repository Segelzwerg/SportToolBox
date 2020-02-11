package segelzwerg.sporttooolbox.IUnits.pace;

/**
 * Pace interface
 */
public interface Pace {
    float KILO = 1000.0f;
    float PER_KILOMETER_TO_PER_HUNDRED_METER = 0.1f;
    float PER_HUNDRED_METER_TO_PER_KILOMETER = 10.0f;

    /**
     * Converts to minutes per kilometers
     *
     * @return an instance of Pace
     */
    Pace toMinutesPerKilometer();

    /**
     * Converts to minutes per hundred-meters
     *
     * @return an instance of Pace
     */
    Pace toMinutesPerHundredMeters();
}
