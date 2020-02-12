package segelzwerg.sporttooolbox.IUnits;

import java.util.Objects;

public class SpeedFactory {
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
        }
        throw new IllegalArgumentException("The unit was invalid: " + speedUnit);
    }
}
