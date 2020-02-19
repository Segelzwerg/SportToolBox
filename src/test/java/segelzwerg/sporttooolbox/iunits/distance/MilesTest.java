package segelzwerg.sporttooolbox.iunits.distance;

import org.junit.jupiter.api.Test;

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
}