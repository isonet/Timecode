package fr.isonet.timecode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Paul Biester
 * TP3
 */
public class RushImageTest {

    @Test
    public void testGetFormat() throws Exception {
        RushImage rushImage = new RushImage("testRushImage1", new TimecodeImpl(123), RushImage.Format.BMP);
        assertEquals(RushImage.Format.BMP, rushImage.getFormat());
    }
}