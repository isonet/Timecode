package fr.isonet.timecode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Paul Biester
 * TP3
 */
public class RushVideoTest {

    @Test
    public void testGetStandard() throws Exception {
        RushVideo rushVideo = new RushVideo("testRushVideo1", new TimecodeImpl(123), RushVideo.Standard.NTSC);
        assertEquals(RushVideo.Standard.NTSC, rushVideo.getStandard());
    }
}