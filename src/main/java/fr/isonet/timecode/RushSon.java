package fr.isonet.timecode;

/**
 * Paul Biester
 * TP3
 */
public class RushSon extends Rush {

    /**
     * Enum which contains the different sound codecs
     */
    public enum Codec {
        PCM,
        MP2,
        MP3,
        M4a
    }

    /**
     * The sound codec
     */
    private Codec codec;

    /**
     * Creates a new sound rush with a name, length and codec
     * @param name of the sound rush
     * @param length of the sound rush
     * @param codec of the sound rush
     */
    public RushSon(String name, Timecode length, Codec codec) {
        super(name, length);
        this.codec = codec;
    }

    /**
     * @return the codec of the rush
     */
    public Codec getCodec() {
        return codec;
    }
}
