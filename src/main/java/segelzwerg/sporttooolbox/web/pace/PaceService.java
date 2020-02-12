package segelzwerg.sporttooolbox.web.pace;

import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.calculators.SpeedCalculator;
import segelzwerg.sporttooolbox.calculators.SpeedCalculatorFactory;
import segelzwerg.sporttooolbox.calculators.TimeCalculator;
import segelzwerg.sporttooolbox.calculators.TimeCalculatorFactory;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.pace.Pace;
import segelzwerg.sporttooolbox.web.speed.SpeedForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Pace calculating service
 */
@Component
public class PaceService {

    List<String> validPaceUnits = new ArrayList<>(Arrays.asList("minutesPerKilometer", "minutesPerHundredMeters"));

    /**
     * calulates pace
     *
     * @param form
     * @return calculated pace
     */
    public Pace calculatePace(SpeedForm form) {
        UnitParser unitParser = new UnitParser(form).invoke();

        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(form, unitParser.getMajorUnit(), unitParser.getMinorUnit());

        return speedCalculator.computePace();
    }

    /**
     * calculates the time given a distance and speed
     *
     * @param paceForm contains distance and speed and their units
     * @return a Time object containing hours, minutes and seconds
     */
    public Time calculateTime(SpeedForm paceForm) {
        UnitParser unitParser = new UnitParser(paceForm).invoke();

        TimeCalculator timeCalculator = TimeCalculatorFactory.buildFromPace(paceForm, unitParser.getMajorUnit(), unitParser.getMinorUnit());
        return timeCalculator.computeTime();
    }

    private void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }

    private class UnitParser {
        private SpeedForm paceForm;
        private String majorUnit;
        private String minorUnit;

        public UnitParser(SpeedForm paceForm) {
            this.paceForm = paceForm;
        }

        public String getMajorUnit() {
            return majorUnit;
        }

        public String getMinorUnit() {
            return minorUnit;
        }

        public UnitParser invoke() {
            majorUnit = ((majorUnit = paceForm.getDistanceMajorUnit()) == null) ? "kilometer" : majorUnit;
            minorUnit = ((minorUnit = paceForm.getDistanceMinorUnit()) == null) ? "meter" : minorUnit;
            String paceUnit = ((paceUnit = paceForm.getPaceUnit()) == null) ? "minutesPerKilometer" : paceUnit;

            checkValidUnit(validPaceUnits, paceUnit);
            return this;
        }
    }
}
