package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

@Deprecated
public class Caverphone implements StringEncoder {
    private final Caverphone2 encoder = new Caverphone2();

    public String caverphone(String str) {
        return this.encoder.encode(str);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return caverphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    public boolean isCaverphoneEqual(String str, String str2) {
        return caverphone(str).equals(caverphone(str2));
    }

    public String encode(String str) {
        return caverphone(str);
    }
}
