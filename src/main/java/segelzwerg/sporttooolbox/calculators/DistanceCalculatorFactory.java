package segelzwerg.sporttooolbox.calculators;

import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Speed;
import segelzwerg.sporttooolbox.iunits.speed.SpeedFactory;

public class DistanceCalculatorFactory {
    public static DistanceCalculator buildFromSpeed(Time time, float speed, String speedUnit) {
        Speed speedFromUnit = SpeedFactory.createSpeedFromUnit(speed, speedUnit);
        return new DistanceCalculator(speedFromUnit, time);
    }
}
