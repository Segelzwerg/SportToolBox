package segelzwerg.sporttooolbox.web.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.MinutesPerKilometer;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PaceServiceTest {

    private SpeedForm paceForm;
    private PaceService paceService;

    @BeforeEach
    void setUp() {
        paceForm = new SpeedForm();
        paceForm.setMajor(22);
        paceForm.setHour(1);
        paceService = new PaceService();
    }

    @Test
    public void only_kilometer() {
        paceForm.setDistanceMajorUnit("kilometer");

        Pace pace = paceService.calculatePace(paceForm);

        MinutesPerKilometer expectedPace = new MinutesPerKilometer((float) 2.7272727);
        assertThat(pace, equalTo(expectedPace));
    }

    @Test
    public void distance_speed_test_time() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(34);
        speedForm.setMinor(300);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setDistanceMinorUnit("meter");
        speedForm.setPace(4.5f);
        speedForm.setPaceUnit("minutesPerKilometer");

        Time time = paceService.calculateTime(speedForm);

        Time expectedTime = new Time(2, 34, 21);
        assertThat(time, equalTo(expectedTime));
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