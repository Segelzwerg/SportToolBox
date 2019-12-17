package segelzwerg.sporttooolbox.web.speed;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.IUnits.KilometerPerHour;
import segelzwerg.sporttooolbox.IUnits.Speed;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SpeedServiceTest {

    @Test
    void only_kilometer() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setDistanceMajorUnit("kilometer");
        speedForm.setMajor(22);
        speedForm.setHour(1);

        SpeedService speedService = new SpeedService();
        Speed speed = speedService.calculateSpeed(speedForm);

        Speed expectedSpeed = new KilometerPerHour(22);
        assertThat(speed, equalTo(expectedSpeed));
    }
}