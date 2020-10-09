package segelzwerg.sporttooolbox.web.pace;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import segelzwerg.sporttooolbox.calculators.*;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Distance;
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

    private final List<String> validPaceUnits = new ArrayList<>(Arrays.asList("minutesPerKilometer", "minutesPerHundredMeters"));

    private static void checkValidUnit(List<String> validUnits, String unit) {
        if (!validUnits.contains(unit)) {
            throw new IllegalArgumentException("This is not a valid unit: " + unit);
        }
    }

    /**
     * calculates pace
     *
     * @param paceForm
     * @return calculated pace
     */
    Pace calculatePace(SpeedForm paceForm) {
        UnitParser unitParser = new UnitParser(paceForm).invoke();
        SpeedCalculator speedCalculator = SpeedCalculatorFactory.build(paceForm, unitParser.getMajorUnit(), unitParser.getMinorUnit());

        return speedCalculator.computePace();
    }

    Time calculateTime(SpeedForm paceForm) {
        UnitParser unitParser = new UnitParser(paceForm).invoke();
        TimeCalculator timeCalculator = TimeCalculatorFactory.buildFromPace(paceForm, unitParser.getMajorUnit(), unitParser.getMinorUnit());
        return timeCalculator.computeTime();
    }

    Distance calculateDistance(SpeedForm form) {
        UnitParser unitParser = new UnitParser(form).invoke();
        DistanceCalculator distanceCalculator = DistanceCalculatorFactory.buildFromPace(form,
                unitParser.getMajorUnit(),
                unitParser.getMinorUnit());
        return distanceCalculator.computeDistance();
    }

    @Getter
    @RequiredArgsConstructor
    private class UnitParser {
        @NonNull
        private final SpeedForm paceForm;
        private String majorUnit;
        private String minorUnit;

        UnitParser invoke() {
            majorUnit = ((majorUnit = paceForm.getDistanceMajorUnit()) == null) ? "kilometer" : majorUnit;
            minorUnit = ((minorUnit = paceForm.getDistanceMinorUnit()) == null) ? "meter" : minorUnit;
            String paceUnit = ((paceUnit = paceForm.getPaceUnit()) == null) ? "minutesPerKilometer" : paceUnit;

            checkValidUnit(validPaceUnits, paceUnit);
            return this;
        }
    }

}
