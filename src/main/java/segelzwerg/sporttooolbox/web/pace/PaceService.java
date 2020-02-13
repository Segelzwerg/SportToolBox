package segelzwerg.sporttooolbox.web.pace;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.IUnits.Pace;
import segelzwerg.sporttooolbox.calculators.SpeedCalculator;
import segelzwerg.sporttooolbox.calculators.SpeedCalculatorFactory;
import segelzwerg.sporttooolbox.iunits.Time;
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
     * @param paceForm
     * @return calculated pace
     */
    public Pace calculatePace(SpeedForm paceForm) {
        UnitParser unitParser = new UnitParser(paceForm).invoke();
        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(paceForm, unitParser.getMajorUnit(), unitParser.getMinorUnit());

        return speedCalculator.computePace();
    }

    private void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }

    @Getter
    @RequiredArgsConstructor
    private class UnitParser {
        @NonNull
        private final SpeedForm paceForm;
        private String majorUnit;
        private String minorUnit;

        public UnitParser invoke() {
            majorUnit = ((majorUnit = paceForm.getDistanceMajorUnit()) == null) ? "kilometer" : majorUnit;
            minorUnit = ((minorUnit = paceForm.getDistanceMinorUnit()) == null) ? "meter" : minorUnit;
            String paceUnit = ((paceUnit = paceForm.getPaceUnit()) == null) ? "minutesPerKilometer" : paceUnit;

            checkValidUnit(validPaceUnits, paceUnit);
            return this;
        }
    }

}
