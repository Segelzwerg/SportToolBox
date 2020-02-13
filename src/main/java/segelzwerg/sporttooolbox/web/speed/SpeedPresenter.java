package segelzwerg.sporttooolbox.web.speed;

import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Knot;
import segelzwerg.sporttooolbox.iunits.speed.MilePerHour;

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
        kilometerPerHour = (KilometerPerHour) speed.toKilometerPerHour().format();
        milesPerHour = (MilePerHour) speed.toMilePerHour().format();
        knots = (Knot) speed.toKnot().format();
    }
}
