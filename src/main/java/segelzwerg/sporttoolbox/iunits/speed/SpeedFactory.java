package segelzwerg.sporttoolbox.iunits.speed;

import java.util.Objects;

public final class SpeedFactory {
    /**
     * private constructor to prevent instantiating
     */
    private SpeedFactory() {
    }

    /**
     * constructs a speed object
     *
     * @param speed     float - value of the speed
     * @param speedUnit String - name of the speed unit
     * @return {@link Speed}s
     */
    public static Speed createSpeedFromUnit(Float speed, String speedUnit) {
        Objects.requireNonNull(speed, "Speed must be set.");
        Objects.requireNonNull(speedUnit);
        switch (speedUnit) {
            case "kilometerPerHour":
                return new KilometerPerHour(speed);
            case "milesPerHour":
                return new MilePerHour(speed);
            case "meterPerSecond":
                return new MeterPerSecond(speed);
            case "knots":
                return new Knot(speed);
            default:
                throw new IllegalArgumentException("The unit was invalid: " + speedUnit);
        }
    }
}
