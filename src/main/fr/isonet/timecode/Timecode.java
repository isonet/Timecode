package fr.isonet.timecode;

/**
 * Paul Biester
 * TP3
 * How to name Interfaces http://stackoverflow.com/a/2814831
 */
public interface Timecode {

    /**
     * Compare deux timecode
     * @param t le timecode à comparer
     * @return la difference entre les deux timecodes, peut être positif, zéro ou négatif
     */
    int compare(Timecode t);

    /**
     * Ajoute le timecode donné
     * @param t Timecode à ajouter
     */
    void add(Timecode t);

    /**
     * Soustrait le timecode donné
     * @param t Timecode à soustraire
     */
    void subtract(Timecode t);

    /**
     * @return toutes les images du timecode
     */
    int getImages();

    /**
     * Create a clone of the object
     * @return the clone
     * @throws CloneNotSupportedException if a class does not correctly implement clone()
     */
    Timecode clone() throws CloneNotSupportedException;
}
