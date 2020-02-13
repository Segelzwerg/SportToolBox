package segelzwerg.sporttooolbox.IUnits;

import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Knot;
import segelzwerg.sporttooolbox.iunits.speed.MeterPerSecond;
import segelzwerg.sporttooolbox.iunits.speed.MilePerHour;

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
            default:
                throw new IllegalArgumentException("The unit was invalid: " + speedUnit);
        }
    }
}
