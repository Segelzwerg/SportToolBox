package segelzwerg.sporttooolbox.IUnits;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TimeTest {

    @Test
    public void zero() {
        assertThat(new Time(0, 0, 0), equalTo(new Time(0, 0, 0)));
    }

    @Test
    public void oneHour() {
        assertThat(new Time(0, 0, 3_600), equalTo(new Time(1, 0, 0)));
    }

    @Test
    public void sixtyMinutes() {
        assertThat(new Time(0, 0, 3_600), equalTo(new Time(0, 60, 0)));
    }

    @Test
    public void manySeconds() {
        assertThat(new Time(0, 0, 1_800), equalTo(new Time(0, 0, 1800)));
    }

    @Test
    public void ninetyMinutes() {
        assertThat(new Time(0, 0, 5_400), equalTo(new Time(0, 90, 0)));
    }

    @Test
    public void oddNumber() {
        assertThat(new Time(0, 0, 4_530), equalTo(new Time(1, 15, 30)));
    }

    @Test
    public void overflow() {
        assertThat(new Time(0, 0, 56_133), equalTo(new Time(13, 150, 333)));
    }

    @Test
    public void equals() {
        assertThat(new Time(15, 35, 33), equalTo(new Time(13, 150, 333)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeHours() {
        new Time(-1, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeMinutes() {
        new Time(0, -1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeSeconds() {
        new Time(0, 0, -1);
    }
}