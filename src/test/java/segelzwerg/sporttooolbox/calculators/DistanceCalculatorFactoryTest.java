package segelzwerg.sporttooolbox.calculators;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.Knot;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DistanceCalculatorFactoryTest {

    @Test
    public void buildFromSpeed() {
        Time time = new Time(1, 56, 34);
        float speed = 15.7f;
        String speedUnit = "knots";

        Knot knot = new Knot(speed);

        DistanceCalculator distanceCalculator = DistanceCalculatorFactory.buildFromSpeed(time, speed, speedUnit);

        DistanceCalculator expectedDistanceCalculator = new DistanceCalculator(knot, time);

        assertThat(distanceCalculator, equalTo(expectedDistanceCalculator));
    }
}