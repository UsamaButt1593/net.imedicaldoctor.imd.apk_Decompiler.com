package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.Glyph;
import java.util.List;

abstract class IndicGlyphRepositioner implements GlyphRepositioner {
    IndicGlyphRepositioner() {
    }

    private Glyph c(List<Glyph> list, int i2) {
        int i3 = i2 + 1;
        if (i3 < list.size()) {
            return list.get(i3);
        }
        return null;
    }

    public void a(List<Glyph> list) {
        int i2 = 0;
        while (i2 < list.size()) {
            Glyph glyph = list.get(i2);
            Glyph c2 = c(list, i2);
            if (c2 != null && b().contains(c2.f26066c)) {
                list.set(i2, c2);
                i2++;
                list.set(i2, glyph);
            }
            i2++;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract List<String> b();
}
