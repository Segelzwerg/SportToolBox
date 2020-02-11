package segelzwerg.sporttooolbox.web.speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.Speed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SpeedServiceTest {

    private SpeedForm speedForm;
    private SpeedService speedService;

    @BeforeEach
    void setUp() {
        speedForm = new SpeedForm();
        speedForm.setMajor(22);
        speedForm.setHour(1);
        speedService = new SpeedService();
    }

    @Test
    void only_kilometer_test_speed() {
        speedForm.setDistanceMajorUnit("kilometer");

        Speed speed = speedService.calculateSpeed(speedForm);

        Speed expectedSpeed = new KilometerPerHour(22);
        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    void invalidMajorUnit() {
        speedForm.setDistanceMajorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> speedService.calculateSpeed(speedForm));
    }

    @Test
    void invalidMinorUnit() {
        speedForm.setDistanceMinorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> speedService.calculateSpeed(speedForm));
    }

    @Test
    void invalidResultUnit() {
        speedForm.setResultUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> speedService.calculateSpeed(speedForm));
    }
}