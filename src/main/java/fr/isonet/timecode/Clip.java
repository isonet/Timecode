package fr.isonet.timecode;

/**
 * Paul Biester
 * TP3
 */
public class Clip implements Cloneable {

    /**
     * The starting point of the clip inside of the given rush.
     */
    private Timecode startingPoint;
    /**
     * The name of the clip which is also its identifier
     */
    private String name;
    /**
     * The length of the clip
     */
    private Timecode length;
    /**
     * The rush wich contains the clip
     */
    private Rush rush;

	/**
	 *
	 * @param rush from which to create the clip (PARTAGE)
	 * @param startingPoint of the clip inside the rush
	 * @param name of the clip which is also its identifier
	 * @param length of the clip, must not be longer than the rush
	 */
	public Clip(Rush rush, Timecode startingPoint, String name, Timecode length) {
		this.rush = rush;
		this.startingPoint = startingPoint;
		this.name = name;
		this.length = length;
	}

    /**
     * @return the starting point of the clip
     */
    public Timecode getStartingPoint() {
		return this.startingPoint;
	}


    /**
     * @return the name of the clip
     */
    public String getName() {
		return this.name;
	}


    /**
     * @return the length of the clip
     */
    public Timecode getLength() {
		return this.length;
	}


    /**
     * Checks if two objects (clips) are the same.
     * We decided that they are the same if they have the same name
     * @param o the object to comapre
     * @return true if the objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clip clip = (Clip) o;

        return name.equals(clip.name);
    }

    /**
     * @return the hashcode of the object, since the name is unique, we use its hashcode
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * @return the rush which contains this clip
     */
    public Rush getRush() {
        return rush;
    }

    /**
     * Create a clone of the object
     * @return the clone
     * @throws CloneNotSupportedException if a class does not correctly implement clone()
     */
    @Override
    public Clip clone() throws CloneNotSupportedException {
        final Clip clone;
        clone = (Clip) super.clone();
        clone.startingPoint = this.startingPoint.clone();
        clone.length = this.length.clone();
        clone.rush = this.rush.clone();
        clone.name = this.name;
        return clone;
    }
}