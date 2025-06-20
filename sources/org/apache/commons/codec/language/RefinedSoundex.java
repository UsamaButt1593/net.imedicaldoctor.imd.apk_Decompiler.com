package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class RefinedSoundex implements StringEncoder {
    public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
    private static final char[] US_ENGLISH_MAPPING = US_ENGLISH_MAPPING_STRING.toCharArray();
    public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
    private final char[] soundexMapping;

    public RefinedSoundex() {
        this.soundexMapping = US_ENGLISH_MAPPING;
    }

    public int difference(String str, String str2) throws EncoderException {
        return SoundexUtils.difference(this, str, str2);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return soundex((String) obj);
        }
        throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public char getMappingCode(char c2) {
        if (!Character.isLetter(c2)) {
            return 0;
        }
        return this.soundexMapping[Character.toUpperCase(c2) - 'A'];
    }

    public String soundex(String str) {
        if (str == null) {
            return null;
        }
        String clean = SoundexUtils.clean(str);
        if (clean.length() == 0) {
            return clean;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(clean.charAt(0));
        char c2 = '*';
        for (int i2 = 0; i2 < clean.length(); i2++) {
            char mappingCode = getMappingCode(clean.charAt(i2));
            if (mappingCode != c2) {
                if (mappingCode != 0) {
                    sb.append(mappingCode);
                }
                c2 = mappingCode;
            }
        }
        return sb.toString();
    }

    public RefinedSoundex(String str) {
        this.soundexMapping = str.toCharArray();
    }

    public String encode(String str) {
        return soundex(str);
    }

    public RefinedSoundex(char[] cArr) {
        char[] cArr2 = new char[cArr.length];
        this.soundexMapping = cArr2;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }
}
