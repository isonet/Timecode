package fr.isonet.timecode;

/**
 * Paul Biester
 * TP3
 */
public class RushVideo extends Rush {

    /**
     * Enum which contains the different video standards
     */
    public enum Standard {
        PAL,
        NTSC,
        P720,
        P1080
    }

    /**
     * The video standard
     */
    private Standard standard;

    /**
     * Creates a new video rush with a name, length and standard
     * @param name of the video rush
     * @param length of the video rush
     * @param standard of the video rush
     */
    public RushVideo(String name, Timecode length, Standard standard) {
        super(name, length);
        this.standard = standard;
    }

    /**
     * @return the standard of the video rush
     */
    public Standard getStandard() {
        return standard;
    }
}
