package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

public class LookupTranslator extends CharSequenceTranslator {
    private final int longest;
    private final HashMap<String, CharSequence> lookupMap = new HashMap<>();
    private final int shortest;

    public LookupTranslator(CharSequence[]... charSequenceArr) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        if (charSequenceArr != null) {
            int i4 = 0;
            for (CharSequence[] charSequenceArr2 : charSequenceArr) {
                this.lookupMap.put(charSequenceArr2[0].toString(), charSequenceArr2[1]);
                int length = charSequenceArr2[0].length();
                i2 = length < i2 ? length : i2;
                if (length > i4) {
                    i4 = length;
                }
            }
            i3 = i4;
        }
        this.shortest = i2;
        this.longest = i3;
    }

    public int translate(CharSequence charSequence, int i2, Writer writer) throws IOException {
        int i3 = this.longest;
        if (i2 + i3 > charSequence.length()) {
            i3 = charSequence.length() - i2;
        }
        while (i3 >= this.shortest) {
            CharSequence charSequence2 = this.lookupMap.get(charSequence.subSequence(i2, i2 + i3).toString());
            if (charSequence2 != null) {
                writer.write(charSequence2.toString());
                return i3;
            }
            i3--;
        }
        return 0;
    }
}
