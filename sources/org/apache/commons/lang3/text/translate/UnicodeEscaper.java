package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

public class UnicodeEscaper extends CodePointTranslator {
    private final int above;
    private final int below;
    private final boolean between;

    public UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    public static UnicodeEscaper above(int i2) {
        return outsideOf(0, i2);
    }

    public static UnicodeEscaper below(int i2) {
        return outsideOf(i2, Integer.MAX_VALUE);
    }

    public static UnicodeEscaper between(int i2, int i3) {
        return new UnicodeEscaper(i2, i3, true);
    }

    public static UnicodeEscaper outsideOf(int i2, int i3) {
        return new UnicodeEscaper(i2, i3, false);
    }

    /* access modifiers changed from: protected */
    public String toUtf16Escape(int i2) {
        return "\\u" + CharSequenceTranslator.hex(i2);
    }

    public boolean translate(int i2, Writer writer) throws IOException {
        StringBuilder sb;
        String str;
        String sb2;
        if (this.between) {
            if (i2 < this.below || i2 > this.above) {
                return false;
            }
        } else if (i2 >= this.below && i2 <= this.above) {
            return false;
        }
        if (i2 > 65535) {
            sb2 = toUtf16Escape(i2);
        } else {
            if (i2 > 4095) {
                sb = new StringBuilder();
                str = "\\u";
            } else if (i2 > 255) {
                sb = new StringBuilder();
                str = "\\u0";
            } else if (i2 > 15) {
                sb = new StringBuilder();
                str = "\\u00";
            } else {
                sb = new StringBuilder();
                str = "\\u000";
            }
            sb.append(str);
            sb.append(CharSequenceTranslator.hex(i2));
            sb2 = sb.toString();
        }
        writer.write(sb2);
        return true;
    }

    protected UnicodeEscaper(int i2, int i3, boolean z) {
        this.below = i2;
        this.above = i3;
        this.between = z;
    }
}
