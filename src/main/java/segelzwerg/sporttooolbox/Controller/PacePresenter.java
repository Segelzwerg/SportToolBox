package segelzwerg.sporttooolbox.Controller;

import lombok.Getter;
import lombok.ToString;
import segelzwerg.sporttooolbox.IUnits.MinutesPerHundredMeters;
import segelzwerg.sporttooolbox.IUnits.MinutesPerKilometer;
import segelzwerg.sporttooolbox.IUnits.Pace;

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
