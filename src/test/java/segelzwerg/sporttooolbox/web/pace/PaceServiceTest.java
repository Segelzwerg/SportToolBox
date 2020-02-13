package segelzwerg.sporttooolbox.web.pace;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.MinutesPerKilometer;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaceServiceTest {

    private SpeedForm paceForm;
    private PaceService paceService;

    @BeforeEach
    public void setUp() {
        paceForm = new SpeedForm();
        paceForm.setMajor(22);
        paceForm.setHour(1);
        paceService = new PaceService();
    }

    @Test
    public void onlyKilometer() {
        paceForm.setDistanceMajorUnit("kilometer");

        Pace pace = paceService.calculatePace(paceForm);

        MinutesPerKilometer expectedPace = new MinutesPerKilometer((float) 2.7272727);
        assertThat(pace, equalTo(expectedPace));
    }

    @Test
    public void testTimeFromDistanceAndSpeed() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(34);
        speedForm.setMinor(300);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setDistanceMinorUnit("meter");
        speedForm.setPace(4.5f);
        speedForm.setPaceUnit("minutesPerKilometer");

        Time time = paceService.calculateTime(speedForm);

        Time expectedTime = new Time(2, 34, 21);
        Assertions.assertThat(time).isEqualToComparingFieldByField(expectedTime);
    }

    @Test
    public void invalidMajorUnit() {
        paceForm.setDistanceMajorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> paceService.calculatePace(paceForm));
    }

    @Test
    public void invalidMinorUnit() {
        paceForm.setDistanceMinorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> paceService.calculatePace(paceForm));
    }

    @Test
    public void invalidResultUnit() {
        paceForm.setPaceUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> paceService.calculatePace(paceForm));
    }
}