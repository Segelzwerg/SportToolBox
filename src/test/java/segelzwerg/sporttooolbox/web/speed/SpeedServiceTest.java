package segelzwerg.sporttooolbox.web.speed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SpeedServiceTest {

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
    public void onlyKilometerTestSpeed() {
        speedForm.setDistanceMajorUnit("kilometer");

        Speed speed = speedService.calculateSpeed(speedForm);

        Speed expectedSpeed = new KilometerPerHour(22);
        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void metersAndKilosTestSpeed() {
        speedForm.setMinor(500);
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setDistanceMinorUnit("meter");

        Speed speed = speedService.calculateSpeed(speedForm);

        Speed expectedSpeed = new KilometerPerHour((float) 22.5);
        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void distanceSpeedTestTime() {
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
    public void invalidMajorUnit() {
        speedForm.setDistanceMajorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> speedService.calculateSpeed(speedForm));
    }

    @Test
    public void invalidMinorUnit() {
        speedForm.setDistanceMinorUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> speedService.calculateSpeed(speedForm));
    }

    @Test
    public void invalidResultUnit() {
        speedForm.setSpeedUnit("abc");

        assertThrows(IllegalArgumentException.class, () -> speedService.calculateSpeed(speedForm));
    }
}