package com.itextpdf.text.pdf.languages;

import com.itextpdf.text.pdf.Glyph;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BanglaGlyphRepositioner extends IndicGlyphRepositioner {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f26898c = {"ি", "ে", "ৈ"};

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, int[]> f26899a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Glyph> f26900b;

    public BanglaGlyphRepositioner(Map<Integer, int[]> map, Map<String, Glyph> map2) {
        this.f26899a = map;
        this.f26900b = map2;
    }

    private Glyph d(char c2) {
        Glyph glyph = this.f26900b.get(String.valueOf(c2));
        if (glyph != null) {
            return glyph;
        }
        int[] iArr = this.f26899a.get(Integer.valueOf(c2));
        return new Glyph(iArr[0], iArr[1], String.valueOf(c2));
    }

    private void e(int i2, List<Glyph> list, char c2, char c3) {
        Glyph d2 = d(c2);
        Glyph d3 = d(c3);
        list.set(i2, d2);
        list.add(i2 + 1, d3);
    }

    public void a(List<Glyph> list) {
        char c2;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Glyph glyph = list.get(i2);
            if (glyph.f26066c.equals("ো")) {
                c2 = 2494;
            } else if (glyph.f26066c.equals("ৌ")) {
                c2 = 2519;
            }
            e(i2, list, 2503, c2);
        }
        super.a(list);
    }

    public List<String> b() {
        return Arrays.asList(f26898c);
    }
}
