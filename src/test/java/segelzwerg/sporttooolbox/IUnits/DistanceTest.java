package segelzwerg.sporttooolbox.IUnits;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DistanceTest {
    @Test
    public void overflow_test() {
        Distance thirtyKM_twoThousandTwoMeter = new Distance(30, 2002);
        Distance expectedDistance = new Distance(32, 2);

        assertThat(thirtyKM_twoThousandTwoMeter, equalTo(expectedDistance));
    }
}
