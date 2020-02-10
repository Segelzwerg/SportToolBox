package segelzwerg.sporttooolbox.web;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

class DistanceAutoFillFactoryTest {

    @Test
    void OneHundredMiles() {
        SpeedForm expectedSpeedForm = hundredMiles();

        SpeedForm form = DistanceAutoFillFactory.autoDistance("100mi");

        assertThat(form, equalTo(expectedSpeedForm));

    }

    private SpeedForm hundredMiles() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(100);
        speedForm.setDistanceMajorUnit("miles");
        speedForm.setDistanceMinorUnit("");
        speedForm.setResultUnit("MilesPerHour");
        return speedForm;
    }


}