package fr.isonet.timecode;

/**
 * Paul Biester
 * TP3
 */
public class Rush implements Cloneable {

    /**
     * The name of the rush which is also its identifier
     */
	private String name;
    /**
     * The length of the clip
     */
	private Timecode length;

    /**
     * Creates a new rush with given name and length
     * @param name of the rush, which is unique and also its identifier
     * @param length of the rush
     */
    public Rush(String name, Timecode length) {
        this.name = name;
        this.length = length;
    }

    /**
     * @return the name of the rush
     */
    public String getName() {
		return this.name;
	}

    /**
     * @return the length of the rush
     */
    public Timecode getLength() {
		return this.length;
	}

    /**
     * Checks if two objects (rush) are the same.
     * We decided that they are the same if they have the same name
     * @param o the object to comapre
     * @return true if the objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rush rush = (Rush) o;

        return name.equals(rush.name);
    }

    /**
     * @return the hashcode of the object, since the name is unique, we use its hashcode
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * Create a clone of the object
     * @return the clone
     * @throws CloneNotSupportedException if a class does not correctly implement clone()
     */
    @Override
    public Rush clone() throws CloneNotSupportedException {
        final Rush clone;
        clone = (Rush) super.clone();
        clone.name = this.name;
        clone.length = this.length.clone();
        return clone;
    }
}