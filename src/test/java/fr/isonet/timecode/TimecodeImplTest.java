package fr.isonet.timecode;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Paul Biester
 * TP3
 */
public class TimecodeImplTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @org.junit.Test
    public void testCompare() throws Exception {
        Timecode tc = new TimecodeImpl(1337);
        Timecode tc2 = new TimecodeImpl(1330);

        assertEquals(7, tc.compare(tc2));
        assertEquals(-7, tc2.compare(tc));
        assertEquals(0, tc.compare(tc));
    }

    @org.junit.Test
    public void testAdd() throws Exception {
        Timecode tc = new TimecodeImpl(1337);
        tc.add(new TimecodeImpl(10));
        assertEquals(1347, tc.getImages());
    }

    @org.junit.Test
    public void testSubtract() throws Exception {
        Timecode tc = new TimecodeImpl(1337);
        tc.subtract(new TimecodeImpl(10));
        assertEquals(1327, tc.getImages());
    }

    @org.junit.Test
    public void testSubtractIllegal() throws Exception {
        Timecode tc = new TimecodeImpl(1337);
        Timecode tc2 = new TimecodeImpl(1338);

        exception.expect(IllegalStateException.class);
        tc.subtract(tc2);
    }

    @org.junit.Test
    public void testGetImagesFromImages() throws Exception {
        Timecode tc = new TimecodeImpl(1337);
        assertEquals(1337, tc.getImages());
    }

    @org.junit.Test
    public void testGetImagesFromHoursMinutesSeconds() throws Exception {
        Timecode tc = new TimecodeImpl(1, 0, 0, 0);
        assertEquals(90000, tc.getImages());

        Timecode tc2 = new TimecodeImpl(1, 2, 3, 4);
        assertEquals(93079, tc2.getImages());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        // 25 * 60 * 1 * 60 *1 *1 = 1heure = 90 000
        Timecode tc = new TimecodeImpl(90001);
        assertEquals("01:00:00:01", tc.toString());
    }

    @Test
    public void testHashCode() throws Exception {
        Timecode tc = new TimecodeImpl(123);
        assertEquals(123, tc.hashCode());
    }
}