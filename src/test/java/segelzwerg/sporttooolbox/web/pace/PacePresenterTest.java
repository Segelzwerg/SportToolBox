package segelzwerg.sporttooolbox.web.pace;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.MinutesPerHundredMeters;
import segelzwerg.sporttooolbox.IUnits.MinutesPerKilometer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class PacePresenterTest {
    @Test
    void constructorTest() {
        MinutesPerKilometer minutesPerKilometer = new MinutesPerKilometer((float) 5.321);
        PacePresenter presenter = new PacePresenter(minutesPerKilometer);

        MinutesPerHundredMeters expectedMinutesPerHundredMeters = new MinutesPerHundredMeters((float) 0.5321);

        assertThat(presenter.getMinutesPerKilometer(), equalTo(minutesPerKilometer));
        assertThat(presenter.getMinutesPerHundredMeters(), equalTo(expectedMinutesPerHundredMeters));
    }

}