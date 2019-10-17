package segelzwerg.sporttooolbox.IUnits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTest {

    @Test
    public void zero() {
        assertEquals(0, new Time(0, 0, 0).toSeconds());
    }

    @Test
    public void oneHour() {
        assertEquals(3_600, new Time(1, 0, 0).toSeconds());
    }

    @Test
    public void sixtyMinutes() {
        assertEquals(3_600, new Time(0, 60, 0).toSeconds());
    }

    @Test
    public void manySeconds() {
        assertEquals(1_800, new Time(0, 0, 1800).toSeconds());
    }

    @Test
    public void ninetyMinutes() {
        assertEquals(5_400, new Time(0, 90, 0).toSeconds());
    }

    @Test
    public void oddNumber() {
        assertEquals(4_530, new Time(1, 15, 30).toSeconds());
    }

    @Test
    public void overflow() {
        assertEquals(56_133, new Time(13, 150, 333).toSeconds());
    }

    @Test
    public void equals() {
        assertEquals(new Time(15, 35, 33), new Time(13, 150, 333));
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