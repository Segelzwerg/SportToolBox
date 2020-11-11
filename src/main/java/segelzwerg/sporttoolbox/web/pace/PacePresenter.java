package segelzwerg.sporttoolbox.web.pace;

import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttoolbox.iunits.pace.MinutesPerHundredMeters;
import segelzwerg.sporttoolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttoolbox.iunits.pace.Pace;

@Getter
@ToString

public class PacePresenter {
    private MinutesPerHundredMeters minutesPerHundredMeters;
    private MinutesPerKilometer minutesPerKilometer;

    public PacePresenter(Pace pace) {
        minutesPerKilometer = (MinutesPerKilometer) pace.toMinutesPerKilometer();
        minutesPerHundredMeters = (MinutesPerHundredMeters) pace.toMinutesPerHundredMeters();
    }
}
