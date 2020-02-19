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
        Miles miles = new Miles(1759, 1);
        Miles expectedMiles = new Miles(1760, 0);

        assertThat(miles).isEqualToComparingFieldByField(expectedMiles);
    }
}