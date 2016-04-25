package fr.isonet.timecode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Paul Biester
 * TP3
 */
public class ClipTest {

    @Test
    public void testGetStartingPoint() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        assertEquals(new TimecodeImpl(200), clip.getStartingPoint());
    }

    @Test
    public void testGetName() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        assertEquals("testClip1", clip.getName());
    }

    @Test
    public void testGetLength() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        assertEquals(new TimecodeImpl(300), clip.getLength());
    }

    @Test
    public void testGetRush() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        assertEquals(rush, clip.getRush());
    }

    @Test
    public void testCopieRush() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        assertTrue(rush == clip.getRush());
    }

    @Test
    public void testEquals() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip1 = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        Clip clip2 = new Clip(rush, new TimecodeImpl(200), "testClip2", new TimecodeImpl(300));
        Clip clip3 = clip1;
        assertEquals(clip1, clip3);
        assertNotEquals(clip1, clip2);
    }

    @Test
    public void testClone() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip1 = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        assertFalse(clip1 == clip1.clone());
        assertEquals(clip1, clip1.clone());
    }

    @Test
    public void testHashCode() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Clip clip1 = new Clip(rush, new TimecodeImpl(200), "testClip1", new TimecodeImpl(300));
        assertEquals("testClip1".hashCode(), clip1.hashCode());
    }
}