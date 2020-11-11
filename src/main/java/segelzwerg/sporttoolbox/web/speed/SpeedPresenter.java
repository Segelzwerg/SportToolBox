package segelzwerg.sporttoolbox.web.speed;

import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttoolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttoolbox.iunits.speed.Knot;
import segelzwerg.sporttoolbox.iunits.speed.MilePerHour;
import segelzwerg.sporttoolbox.iunits.speed.Speed;

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
