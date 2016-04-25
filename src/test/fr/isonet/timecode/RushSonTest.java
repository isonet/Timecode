package fr.isonet.timecode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Paul Biester
 * TP3
 */
public class RushSonTest {

    @Test
    public void testGetCodec() throws Exception {
        RushSon rushSon = new RushSon("testRushSon1", new TimecodeImpl(123), RushSon.Codec.M4a);
        assertEquals(RushSon.Codec.M4a, rushSon.getCodec());
    }
}