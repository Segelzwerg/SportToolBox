package segelzwerg.sporttooolbox.iunits.distance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NauticalTest {
    @Test
    public void constructorTest() {
        Nautical nautical = new Nautical(1);

        Nautical expectedNautical = new Nautical(1, 0);

        assertThat(nautical).isEqualToComparingFieldByField(expectedNautical);
    }

    @Test
    public void overflowTest() {
        Nautical nautical = new Nautical(0, 1013);

        Distance expectedDistance = new Nautical(1, 1);

        assertThat(nautical).isEqualToComparingFieldByField(expectedDistance);

    }
}