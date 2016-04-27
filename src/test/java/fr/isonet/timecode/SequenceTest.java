package fr.isonet.timecode;

import fr.isonet.timecode.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Paul Biester
 * TP3
 */
@SuppressWarnings("Duplicates")
public class SequenceTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testGetName() throws Exception {
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        assertEquals("testSequence", sequence.getName());
    }

    @Test
    public void testSetName() throws Exception {
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        assertEquals("testSequence", sequence.getName());
    }


    @Test
    public void testSetLength() throws Exception {
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        sequence.setLength(new TimecodeImpl(2000));
        assertEquals(new TimecodeImpl(2000), sequence.getLength());
    }

    @Test
    public void testGetLength() throws Exception {
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        sequence.setLength(new TimecodeImpl(2000));
        assertEquals(new TimecodeImpl(2000), sequence.getLength());
    }

    @Test
    public void testAddClip() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        Clip clip1 = new Clip(rush, new TimecodeImpl(0), "testClip1", new TimecodeImpl(20000));

        sequence.addClip(clip1, new TimecodeImpl(0));
        assertEquals(clip1, sequence.getClip("testClip1"));

    }

    @Test
    public void testGetClip() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        Clip clip1 = new Clip(rush, new TimecodeImpl(0), "testClip1", new TimecodeImpl(20000));

        sequence.addClip(clip1, new TimecodeImpl(0));
        assertEquals(clip1, sequence.getClip("testClip1"));

    }

    @Test
    public void testPartageClip() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        Clip clip1 = new Clip(rush, new TimecodeImpl(0), "testClip1", new TimecodeImpl(20000));

        sequence.addClip(clip1, new TimecodeImpl(0));

        assertFalse(clip1 == sequence.getClip("testClip1"));
    }


    @Test
    public void testDeleteClip() throws Exception {
        Rush rush = new Rush("testRush", new TimecodeImpl(200000));
        Sequence sequence = new Sequence("testSequence", new TimecodeImpl(90000));
        Clip clip1 = new Clip(rush, new TimecodeImpl(0), "testClip1", new TimecodeImpl(20000));

        sequence.addClip(clip1, new TimecodeImpl(0));
        assertEquals(clip1, sequence.getClip("testClip1"));
        sequence.deleteClip("testClip1");

        exception.expect(NotFoundException.class);
        sequence.getClip("testClip1");
    }

    @Test
    public void testEquals() throws Exception {
        Sequence sequence1 = new Sequence("testSequence", new TimecodeImpl(90000));
        Sequence sequence2 = new Sequence("testSequence", new TimecodeImpl(90000));
        assertEquals(sequence1, sequence2);
        assertFalse(sequence1 == sequence2);
    }

    @Test
    public void testHashCode() throws Exception {
        Sequence sequence1 = new Sequence("testSequence", new TimecodeImpl(90000));
        assertEquals("testSequence".hashCode(), sequence1.hashCode());
    }
}