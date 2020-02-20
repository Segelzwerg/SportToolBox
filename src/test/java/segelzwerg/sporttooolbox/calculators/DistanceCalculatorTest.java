package segelzwerg.sporttooolbox.calculators;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.distance.Distance;
import segelzwerg.sporttooolbox.iunits.distance.Kilometer;
import segelzwerg.sporttooolbox.iunits.speed.KilometerPerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceCalculatorTest {
    @Test
    public void thirtyKilometer() {
        Speed speed = new KilometerPerHour(30f);
        Time oneHour = new Time(1, 0, 0);
        DistanceCalculator distanceCalculator = new DistanceCalculator(speed, oneHour);
        Distance expectedDistance = new Kilometer(30);

        Distance kilometer = distanceCalculator.computeDistance();

        assertThat(kilometer).isEqualToComparingFieldByField(expectedDistance);
    }
}
