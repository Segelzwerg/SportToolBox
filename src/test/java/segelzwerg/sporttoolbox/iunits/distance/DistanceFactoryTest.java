package segelzwerg.sporttoolbox.iunits.distance;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceFactoryTest {
    @Test
    public void createKilometer() {
        Distance kilometer = DistanceFactory.createWithOtherThanSIUnits(10, 200, "kilometer", "meter");

        Kilometer expectedDistance = new Kilometer(10, 200);

        assertThat(kilometer).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void createMiles() {
        Distance miles = DistanceFactory.createWithOtherThanSIUnits(30, 42, "miles", "yards");

        Miles expectedDistance = new Miles(30, 42);

        assertThat(miles).isEqualToComparingFieldByField(expectedDistance);
    }

    @Test
    public void createNautical() {
        Distance nautical = DistanceFactory.createWithOtherThanSIUnits(52, 134, "nautical", "fathoms");

        Nautical expectedDistance = new Nautical(52, 134);

        assertThat(nautical).isEqualToComparingFieldByField(expectedDistance);
    }
}