package segelzwerg.sporttooolbox.Controller;

import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttooolbox.IUnits.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.Knot;
import segelzwerg.sporttooolbox.IUnits.MilePerHour;
import segelzwerg.sporttooolbox.IUnits.Speed;

/**
 * Represent speed in different units
 */
@Getter
@ToString
public class SpeedPresenter {
    private KilometerPerHour kilometerPerHour;
    private MilePerHour milesPerHour;
    private Knot knots;

    public SpeedPresenter(Speed speed) {
        kilometerPerHour = (KilometerPerHour) speed.toKilometerPerHour();
        milesPerHour = (MilePerHour) speed.toMilePerHour();
        knots = (Knot) speed.toKnot();
    }
}
