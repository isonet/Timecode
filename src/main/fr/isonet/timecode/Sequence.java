package fr.isonet.timecode;

import javafx.util.Pair;
import java.util.HashMap;
import java.util.Map;

/**
 * Paul Biester
 * TP3
 */
public class Sequence {

    /**
     * The name of the sequence which is unique and also its identifier
     */
    private String name;
    /**
     * The length of sequence
     */
    private Timecode length;
    /**
     * The clips contained in the sequence
     */
    private Map<String, Pair<Timecode, Clip>> clips;

	/**
	 * Create a new sequence with a name and length
	 * @param name of the sequence which is also its identifier
	 * @param length of the sequence
	 */
	public Sequence(String name, Timecode length) {
        this.clips = new HashMap<>();
		this.name = name;
        this.length = length;
	}

    /**
     * @return the name of the sequence
     */
    public String getName() {
		return this.name;
	}

    /**
     * @return the length of the sequence
     */
    public Timecode getLength() {
		return this.length;
	}

	/**
	 * 
	 * @param length new length for sequence
	 */
	public void setLength(Timecode length) {
		this.length = length;
	}

	/**
	 * 
	 * @param clip to add to the sequence (COPIE)
	 * @param start position of the clip in the sequence
	 */
	public void addClip(Clip clip, Timecode start) {
		try {
			this.clips.put(clip.getName(), new Pair<>(start, clip.clone()));
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("Error while doing a deep copy.", e);
		}
	}

	/**
	 * 
	 * @param name of the clip to retrieve which is also its identifier
	 */
	public Clip getClip(String name) throws NotFoundException {
        Pair<Timecode, Clip> p = this.clips.get(name);
        if(p == null) {
            throw new NotFoundException("Clip not found");
        }
		return p.getValue();
	}

	/**
	 * 
	 * @param name of the clip to delete which is also its identifier
	 */
	public void deleteClip(String name) {
		this.clips.remove(name);
	}

    /**
     * Checks if two objects (sequence) are the same.
     * We decided that they are the same if they have the same name
     * @param o the object to comapre
     * @return true if the objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sequence sequence = (Sequence) o;

        return name.equals(sequence.name);

    }

    /**
     * @return the hashcode of the object, since the name is unique, we use its hashcode
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}