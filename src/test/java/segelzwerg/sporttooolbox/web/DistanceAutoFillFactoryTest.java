package segelzwerg.sporttooolbox.web;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DistanceAutoFillFactoryTest {

    @Test
    public void oneHundredMiles() {
        SpeedForm expectedSpeedForm = hundredMiles();

        SpeedForm form = DistanceAutoFillFactory.autoDistance("100mi");

        assertThat(form, equalTo(expectedSpeedForm));

    }

    @Test
    public void oneHundredKilometer() {
        SpeedForm expectedSpeedForm = hundredKilometer();

        SpeedForm form = DistanceAutoFillFactory.autoDistance("100km");

        assertThat(form, equalTo(expectedSpeedForm));

    }

    @Test
    public void testMarathon() {
        SpeedForm expectedSpeedForm = marathon();

        SpeedForm form = DistanceAutoFillFactory.autoDistance("Marathon");

        assertThat(form, equalTo(expectedSpeedForm));

    }

    @Test
    public void halfMarathon() {
        SpeedForm expectedSpeedForm = halfmarathon();

        SpeedForm form = DistanceAutoFillFactory.autoDistance("Halfmarathon");

        assertThat(form, equalTo(expectedSpeedForm));

    }

    @Test
    public void InvalidUnitTest() {
        assertThrows(IllegalArgumentException.class, () -> DistanceAutoFillFactory.autoDistance("1000Lichtjahre"));
    }

    private SpeedForm hundredMiles() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(100);
        speedForm.setDistanceMajorUnit("miles");
        speedForm.setDistanceMinorUnit("yards");
        speedForm.setSpeedUnit("MilesPerHour");
        return speedForm;
    }

    private SpeedForm hundredKilometer() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(100);
        speedForm.setDistanceMajorUnit("Kilometer");
        speedForm.setDistanceMinorUnit("Meter");
        speedForm.setSpeedUnit("KilometerPerHour");
        return speedForm;
    }

    private SpeedForm marathon() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(42);
        speedForm.setMinor(195);
        speedForm.setDistanceMajorUnit("Kilometer");
        speedForm.setDistanceMinorUnit("Meter");
        speedForm.setSpeedUnit("KilometerPerHour");
        return speedForm;
    }

    private SpeedForm halfmarathon() {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(21);
        speedForm.setMinor((int) 97.5);
        speedForm.setDistanceMajorUnit("Kilometer");
        speedForm.setDistanceMinorUnit("Meter");
        speedForm.setSpeedUnit("KilometerPerHour");
        return speedForm;
    }


}