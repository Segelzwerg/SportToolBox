package segelzwerg.sporttooolbox.IUnits.speed;

import segelzwerg.sporttooolbox.IUnits.Distance;

public class SpeedFactory {
    public static Distance.Speed createSpeedFromUnit(Float speed, String speedUnit) {
        if (speedUnit == null) {
            throw new NullPointerException("Unit must be set.");
        }
        if (speed == null) {
            throw new NullPointerException("Speed value must be set.");
        }
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
