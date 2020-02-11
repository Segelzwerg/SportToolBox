package segelzwerg.sporttooolbox.IUnits;

public class SpeedFactory {
    public static Speed createSpeedFromUnit(float speed, String speedUnit) {
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
