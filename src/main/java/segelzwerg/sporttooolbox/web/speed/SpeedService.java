package segelzwerg.sporttooolbox.web.speed;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Time;
import segelzwerg.sporttooolbox.calculators.SpeedCalculator;
import segelzwerg.sporttooolbox.calculators.SpeedCalculatorFactory;
import segelzwerg.sporttooolbox.calculators.TimeCalculator;
import segelzwerg.sporttooolbox.calculators.TimeCalculatorFactory;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Speed calculating service
 */
@Component
public class SpeedService {
    List<String> validSpeedUnits = new ArrayList<>(Arrays.asList("kilometerPerHour", "milesPerHour", "knots"));

    /**
     * Calculate speed
     *
     * @param form form with values
     * @return calculated speed
     */
    public Speed calculateSpeed(SpeedForm form) {

        UnitParser unitParser = new UnitParser(form).invoke();

        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(form, unitParser.getMajorUnit(), unitParser.getMinorUnit());

        return speedCalculator.computeSpeed();
    }

    /**
     * calculates the time given a distance and speed
     *
     * @param speedForm contains distance and speed and their units
     * @return a Time object containing hours, minutes and seconds
     */
    public Time calculateTime(SpeedForm speedForm) {
        UnitParser unitParser = new UnitParser(speedForm).invoke();
        TimeCalculator timeCalculator = TimeCalculatorFactory.build(speedForm, unitParser.getMajorUnit(), unitParser.getMinorUnit());
        return timeCalculator.computeTime();
    }

    /**
     * validates if the input units are acceptable
     *
     * @param validUnits given valid units
     * @param unit       the unit to check
     */
    private void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }

    @Getter
    @RequiredArgsConstructor
    private class UnitParser {
        @NonNull
        private final SpeedForm speedForm;
        private String majorUnit;
        private String minorUnit;

        public UnitParser invoke() {
            majorUnit = ((majorUnit = speedForm.getDistanceMajorUnit()) == null) ? "kilometer" : majorUnit;
            minorUnit = ((minorUnit = speedForm.getDistanceMinorUnit()) == null) ? "meter" : minorUnit;
            String speedUnit = ((speedUnit = speedForm.getSpeedUnit()) == null) ? "kilometerPerHour" : speedUnit;

            checkValidUnit(validSpeedUnits, speedUnit);
            return this;
        }
    }
}
