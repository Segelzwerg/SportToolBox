package segelzwerg.sporttooolbox.web.speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.IUnits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.speed.Speed;

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
    void meters_and_kilos_test_speed() {
        speedForm.setMinor(500);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setDistanceMinorUnit("meter");

        Speed speed = speedService.calculateSpeed(speedForm);

        Speed expectedSpeed = new KilometerPerHour((float) 22.5);
        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    void distance_speed_test_time() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(34);
        speedForm.setMinor(300);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setDistanceMinorUnit("meter");
        speedForm.setSpeed(12);
        speedForm.setSpeedUnit("kilometerPerHour");

        Time time = speedService.calculateTime(speedForm);

        Time expectedTime = new Time(2, 51, 30);
        assertThat(time, equalTo(expectedTime));
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
        speedForm.setSpeedUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> speedService.calculateSpeed(speedForm));
    }
}