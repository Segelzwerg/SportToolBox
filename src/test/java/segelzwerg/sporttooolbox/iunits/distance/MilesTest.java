package segelzwerg.sporttooolbox.iunits.distance;

import org.junit.jupiter.api.Test;
import segelzwerg.sporttooolbox.iunits.Time;
import segelzwerg.sporttooolbox.iunits.speed.MilePerHour;
import segelzwerg.sporttooolbox.iunits.speed.Speed;

import static org.assertj.core.api.Assertions.assertThat;

class MilesTest {
    @Test
    void constructorTest() {
        Miles miles = new Miles(1);

        Miles expectedMile = new Miles(1, 0);

        assertThat(miles).isEqualToComparingFieldByField(expectedMile);
    }


    @Test
    void overflowTest() {
        Miles miles = new Miles(0, 1761);
        Miles expectedMiles = new Miles(1, 1);

        assertThat(miles).isEqualToComparingFieldByField(expectedMiles);
    }

    @Test
    void addMilesTest() {
        Miles miles = new Miles(0, 1759);
        Miles oneYard = new Miles(0, 1);

        Distance distance = miles.addDistance(oneYard);

        Miles expectedDistance = new Miles(1, 0);

        assertThat(distance).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    void sixtyMilesTestSpeed() {
        Miles miles = new Miles(60, 0);
        Time time = new Time(2, 0, 0);
        MilePerHour expectedSpeed = new MilePerHour(30f);

        Speed speed = miles.computeSpeed(time);

        assertThat(speed).isEqualToComparingFieldByField(expectedSpeed);
    }

    @Test
    void speedWithYards() {
        Miles yards = new Miles(0, 1250);
        Time time = new Time(2, 0, 0);
        Speed speed = yards.computeSpeed(time);

        MilePerHour expectedSpeed = new MilePerHour(0.3551f);

        assertThat(speed).isEqualToComparingFieldByField(expectedSpeed);
    }
}