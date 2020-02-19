package segelzwerg.sporttooolbox.iunits.distance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KilometerTest {
    @Test
    void constructorTest() {
        Kilometer kilometer = new Kilometer(1);

        Kilometer expectedKilometer = new Kilometer(1, 0);

        assertThat(kilometer).isEqualToComparingFieldByField(expectedKilometer);
    }
}
