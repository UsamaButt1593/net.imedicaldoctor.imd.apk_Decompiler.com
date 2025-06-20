package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class OctalUnescaper extends CharSequenceTranslator {
    private boolean isOctalDigit(char c2) {
        return c2 >= '0' && c2 <= '7';
    }

    private boolean isZeroToThree(char c2) {
        return c2 >= '0' && c2 <= '3';
    }

    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int length = (charSequence.length() - i2) - 1;
        StringBuilder sb = new StringBuilder();
        if (charSequence.charAt(i2) != '\\' || length <= 0) {
            return 0;
        }
        int i3 = i2 + 1;
        if (!isOctalDigit(charSequence.charAt(i3))) {
            return 0;
        }
        int i4 = i2 + 2;
        int i5 = i2 + 3;
        sb.append(charSequence.charAt(i3));
        if (length > 1 && isOctalDigit(charSequence.charAt(i4))) {
            sb.append(charSequence.charAt(i4));
            if (length > 2 && isZeroToThree(charSequence.charAt(i3)) && isOctalDigit(charSequence.charAt(i5))) {
                sb.append(charSequence.charAt(i5));
            }
        }
        writer.write(Integer.parseInt(sb.toString(), 8));
        return sb.length() + 1;
    }
}
