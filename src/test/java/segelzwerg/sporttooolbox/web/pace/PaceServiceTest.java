package segelzwerg.sporttooolbox.web.pace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.MinutesPerKilometer;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaceServiceTest {

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
    void only_kilometer() {
        paceForm.setDistanceMajorUnit("kilometer");

        Pace pace = paceService.calculatePace(paceForm);

        MinutesPerKilometer expectedPace = new MinutesPerKilometer((float) 2.7272727);
        assertThat(pace, equalTo(expectedPace));
    }

    @Test
    void invalidMajorUnit() {
        paceForm.setDistanceMajorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> paceService.calculatePace(paceForm));
    }

    @Test
    void invalidMinorUnit() {
        paceForm.setDistanceMinorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> paceService.calculatePace(paceForm));
    }
}