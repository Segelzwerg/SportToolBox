package segelzwerg.sporttooolbox.iunits.pace;

public final class PaceFactory {
    /**
     * prevents instantiating
     */
    private PaceFactory() {
    }

    /**
     * pace unit builder
     *
     * @param pace
     * @param paceUnit
     * @return
     */
    public static Pace createPaceFromUnit(float pace, String paceUnit) {
        switch (paceUnit) {
            case "minutesPerKilometer":
                return new MinutesPerKilometer(pace);
            case "minutesPerHundredMeters":
                return new MinutesPerHundredMeters(pace);
            default:
                throw new IllegalArgumentException("The unit was invalid: " + paceUnit);
        }
    }
}
