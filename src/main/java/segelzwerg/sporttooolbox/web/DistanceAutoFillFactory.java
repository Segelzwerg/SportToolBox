package segelzwerg.sporttooolbox.web;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

@Component
public class DistanceAutoFillFactory {
    public static SpeedForm autoDistance(String distance) {
        SpeedForm speedForm = new SpeedForm();

        int major = getMajor(distance);
        int minor = getMinor(distance);
        String majorDistanceUnit = getMajorDistance(distance);
        String minorDistanceUnit = getMinorUnit(distance);

        String resultUnit = getResultUnit(majorDistanceUnit);

        speedForm.setMajor(major);
        speedForm.setMinor(minor);
        speedForm.setDistanceMajorUnit(majorDistanceUnit);
        speedForm.setDistanceMinorUnit(minorDistanceUnit);
        speedForm.setResultUnit(resultUnit);

        return speedForm;
    }

    private static String getResultUnit(String majorDistanceUnit) {
        if (majorDistanceUnit.compareTo("miles") == 0) {
            return "MilesPerHour";
        }
        return "KilometerPerHour";
    }

    private static int getMajor(String distance) {
        if (distance.compareTo("Marathon") == 0) {
            return 42;
        } else if (distance.compareTo("Halfmarathon") == 0) {
            return 21;
        } else {
            return (int) Math.floor(getDistanceWithoutUnit(distance));
        }
    }

    private static int getMinor(String distance) {
        if (distance.compareTo("Marathon") == 0) {
            return 195;
        } else if (distance.compareTo("Halfmarathon") == 0) {
            return (int) 97.5; //the type casting makes it incorrect
        } else {
            return 0;
        }
    }

    private static String getMajorDistance(String distance) {
        if (distance.compareTo("Marathon") != 0 && distance.compareTo("Halfmarathon") != 0) {
            return getUnit(distance);
        }
        return "Kilometer";
    }

    private static String getMinorUnit(String distance) {
        if (distance.compareTo("Marathon") == 0 || distance.compareTo("Halfmarathon") == 0) {
            return "Meter";
        }
        return "";
    }

    private static int getDistanceWithoutUnit(String distance) {
        String distanceWithoutUnit = distance.replaceAll("[a-z]", "");
        return Integer.parseInt(distanceWithoutUnit);
    }

    private static String getUnit(String distance) {
        String unit = distance.replaceAll("[0-9]", "");
        if (unit.compareTo("km") == 0) {
            return "Kilometer";
        } else if (unit.compareTo("mi") == 0) {
            return "miles";
        }
        return "";
    }
}
