package segelzwerg.sporttooolbox.web;

import segelzwerg.sporttooolbox.web.speed.SpeedForm;

public class DistanceAutoFillFactory {
    public static SpeedForm autoDistance(int major, int minor, String majorDistanceUnit, String minorDistanceUnit) {
        SpeedForm speedForm = new SpeedForm();
        speedForm.setMajor(major);
        speedForm.setMinor(minor);
        speedForm.setDistanceMajorUnit(majorDistanceUnit);
        speedForm.setDistanceMinorUnit(minorDistanceUnit);
        return speedForm;
    }
}
