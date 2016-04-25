package fr.isonet.timecode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Paul Biester
 * TP3
 */
public class RushTest {

    @Test
    public void testGetName() throws Exception {
        Rush rush = new Rush("testRush1", new TimecodeImpl(123));
        assertEquals("testRush1", rush.getName());
    }

    @Test
    public void testGetLength() throws Exception {
        Timecode length = new TimecodeImpl(123);
        Rush rush = new Rush("testRush1", length);
        assertEquals(length, rush.getLength());
        assertTrue(length == rush.getLength());
    }

    @Test
    public void testEquals() throws Exception {
        Rush rush1 = new Rush("testRush1", new TimecodeImpl(123));
        Rush rush2 = new Rush("testRush1", new TimecodeImpl(123));
        assertEquals(rush1, rush2);
        assertFalse(rush1 == rush2);
    }

    @Test
    public void testHashCode() throws Exception {
        Rush rush = new Rush("testRush1", new TimecodeImpl(123));
        assertEquals("testRush1".hashCode(), rush.hashCode());
    }

    @Test
    public void testClone() throws Exception {
        Rush rush = new Rush("testRush1", new TimecodeImpl(123));
        assertEquals(rush, rush.clone());
        assertFalse(rush == rush.clone());
    }
}