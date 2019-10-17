package segelzwerg.sporttooolbox.IUnits;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeTest {

    @Test
    public void zero() {
        assertEquals(0.0, new Time(0, 0, 0).inHours(), 0.00001);
    }

    @Test
    public void one() {
        assertEquals(1.0, new Time(1, 0, 0).inHours(), 0.00001);
    }

    @Test
    public void sixtyMinutes() {
        assertEquals(1.0, new Time(0, 60, 0).inHours(), 0.00001);
    }

    @Test
    public void manySeconds() {
        assertEquals(0.5, new Time(0, 0, 1800).inHours(), 0.00001);
    }

    @Test
    public void ninetyMinutes() {
        assertEquals(1.5, new Time(0, 90, 0).inHours(), 0.00001);
    }

    @Test
    public void oddNumber() {
        assertEquals(1.2583, new Time(1, 15, 30).inHours(), 0.0001);
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