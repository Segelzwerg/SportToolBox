package segelzwerg.sporttooolbox.iunits.distance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceFactoryTest {
    @Test
    public void createKilometer() {
        Distance kilometer = DistanceFactory.createWithOtherThanSIUnits(10, 200, "kilometer", "meter");

        Kilometer expectedDistance = new Kilometer(10, 200);

        assertThat(kilometer).isEqualToComparingFieldByField(expectedDistance);
    }
}