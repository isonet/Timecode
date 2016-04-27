package fr.isonet.timecode;

/**
 * Paul Biester
 * TP3
 */
public class TimecodeImpl implements Timecode, Cloneable {

    /**
     * The timecode is calculated with the amount of images it has
     */
    private int images;

    /**
     * Creates a new Timecode with the given images
     * @param images The images of the new timecode
     */
    public TimecodeImpl(int images) {
        this.images = images;
    }

    /**
     * Create a new Timecode with hours, minutes, seconds and images
     * @param heures from which we create the timecode
     * @param minutes from which we create the timecode
     * @param secondes from which we create the timecode
     * @param images from which we create the timecode
     */
    public TimecodeImpl(int heures, int minutes, int secondes, int images) {
        this.images = images + 25 * secondes + 60 * 25 * minutes + 25 * 60 * 60 * heures;
    }

    /**
     * Compare deux timecode
     * @param t le timecode à comparer
     * @return la difference entre les deux timecodes, peut être positif, zéro ou négatif
     */
    @Override
    public int compare(Timecode t) {
        return this.images - t.getImages();
    }

    /**
     * Ajoute le timecode donné
     * @param t Timecode à ajouter
     */
    @Override
    public void add(Timecode t) {
        this.images += t.getImages();
    }

    /**
     * Soustrait le timecode donné
     * @param t Timecode à soustraire
     */
    @Override
    public void subtract(Timecode t) throws IllegalStateException {
        if(this.images - t.getImages() < 0) {
            throw new IllegalStateException("Le timecode donné doit être plus grand ou égal");
        }
        this.images -= t.getImages();
    }

    /**
     * @return toutes les images du timecode
     */
    @Override
    public int getImages() {
        return this.images;
    }

    /**
     * @return a string representation of the Timecode
     */
    @Override
    public String toString() {
        return String.format("%02d", this.getHeures()) + ":" +
                String.format("%02d", this.getMinutes()) + ":" +
                String.format("%02d", this.getSeconds()) + ":" +
                String.format("%02d", this.getRealImages());
    }

    private int getHeures() {
        return this.images / (60 * 60 * 25);
    }

    private int getMinutes() {
        return (this.images - this.getHeures() * 60 * 60 * 25) / (60 * 25);
    }

    private int getSeconds() {
        return (this.images - this.getHeures() * 60 * 60 * 25 - this.getMinutes() * 60 * 25) / (25);
    }

    private int getRealImages() {
        return (this.images - this.getHeures() * 60 * 60 * 25 - this.getMinutes() * 60 * 25 - this.getSeconds() * 25);
    }

    /**
     * Checks if two objects (TimecodeImpl) are the same.
     * We decided that they are the same if they have the same name
     * @param o the object to comapre
     * @return true if the objects are the same and false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimecodeImpl timecode = (TimecodeImpl) o;

        return images == timecode.images;

    }

    /**
     * @return the hashcode of the object, calculated with the number of images
     */
    @Override
    public int hashCode() {
        return images;
    }

    /**
     * Create a clone of the object
     * @return the clone
     * @throws CloneNotSupportedException if a class does not correctly implement clone()
     */
    @Override
    public Timecode clone() throws CloneNotSupportedException {
        final TimecodeImpl clone;
        clone = (TimecodeImpl) super.clone();
        clone.images = this.images;
        return clone;
    }
}
