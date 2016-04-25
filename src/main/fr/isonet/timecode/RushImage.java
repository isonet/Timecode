package fr.isonet.timecode;

/**
 * Paul Biester
 * TP3
 */
public class RushImage extends Rush {

    /**
     * Enum which contains the different image formats
     */
    public enum Format {
        BMP,
        JPEG,
        GIF,
        PNG
    }

    /**
     * The image format
     */
    private Format format;

    /**
     * Creates a new image rush with a name, length and format
     * @param name of the image rush
     * @param length of the image rush
     * @param format of the image rush
     */
    public RushImage(String name, Timecode length, Format format) {
        super(name, length);
        this.format = format;
    }

    /**
     * @return the format of the rush
     */
    public Format getFormat() {
        return format;
    }
}
