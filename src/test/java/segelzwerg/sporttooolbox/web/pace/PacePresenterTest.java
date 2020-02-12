package segelzwerg.sporttooolbox.web.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerHundredMeters;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PacePresenterTest {

    private MinutesPerKilometer minutesPerKilometer;
    private PacePresenter presenter;

    @BeforeEach
    public void setUp() {
        minutesPerKilometer = new MinutesPerKilometer((float) 5.321);
        presenter = new PacePresenter(minutesPerKilometer);
    }

    @Test
    public void constructorTest() {

        MinutesPerHundredMeters expectedMinutesPerHundredMeters = new MinutesPerHundredMeters((float) 0.5321);

        assertThat(presenter.getMinutesPerKilometer(), equalTo(minutesPerKilometer));
        assertThat(presenter.getMinutesPerHundredMeters(), equalTo(expectedMinutesPerHundredMeters));
    }

    @Test
    public void twoSecondsDigits() {
        String expectedString = "5:19";
        assertThat(presenter.getMinutesPerKilometer().toString(), equalTo(expectedString));
    }

}