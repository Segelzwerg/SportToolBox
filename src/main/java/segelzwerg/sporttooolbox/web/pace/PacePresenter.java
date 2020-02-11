package segelzwerg.sporttooolbox.web.pace;

import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttooolbox.IUnits.pace.MinutesPerHundredMeters;
import segelzwerg.sporttooolbox.IUnits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.IUnits.pace.Pace;

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
