package segelzwerg.sporttooolbox;

import org.junit.Test;
import segelzwerg.sporttooolbox.IUnits.Distance;
import segelzwerg.sporttooolbox.IUnits.Speed;
import segelzwerg.sporttooolbox.IUnits.Time;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SpeedCalculatorTest {
    @Test
    public void thirty_kilometer_one_hour_test_speed() {
        Distance thirtyKilometer = new Distance(30);
        Time oneHour = new Time(1);
        SpeedCalculator speedCalculator = new SpeedCalculator(thirtyKilometer, oneHour);
        Speed expectedSpeed = new Speed(30);

        Speed speed = speedCalculator.computeSpeed();

        assertThat(speed, equalTo(expectedSpeed));
    }

    @Test
    public void add_distance_test() {
        Distance thirtyKilometer = new Distance(30,999);
        Distance thirtyonekilometer= thirtyKilometer.addDistance(new Distance(0,1));

        Distance expected=new Distance(31,0);

        assertThat(thirtyonekilometer, equalTo(expected));
    }
}