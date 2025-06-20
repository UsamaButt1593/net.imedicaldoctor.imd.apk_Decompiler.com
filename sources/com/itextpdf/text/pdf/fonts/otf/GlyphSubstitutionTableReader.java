package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.Glyph;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GlyphSubstitutionTableReader extends OpenTypeFontTableReader {

    /* renamed from: e  reason: collision with root package name */
    private final int[] f26835e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, Character> f26836f;

    /* renamed from: g  reason: collision with root package name */
    private Map<Integer, List<Integer>> f26837g;

    public GlyphSubstitutionTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i2, Map<Integer, Character> map, int[] iArr) throws IOException {
        super(randomAccessFileOrArray, i2);
        this.f26835e = iArr;
        this.f26836f = map;
    }

    private String q(int i2, Map<Integer, Character> map) throws FontReadingException {
        StringBuilder sb = new StringBuilder(1);
        Character ch = map.get(Integer.valueOf(i2));
        if (ch == null) {
            List<Integer> list = this.f26837g.get(Integer.valueOf(i2));
            if (list == null || list.isEmpty()) {
                throw new FontReadingException("No corresponding character or simple glyphs found for GlyphID=" + i2);
            }
            for (Integer intValue : list) {
                sb.append(q(intValue.intValue(), map));
            }
        } else {
            sb.append(ch.charValue());
        }
        return sb.toString();
    }

    private void s(int i2, int i3) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        Logger logger = OpenTypeFontTableReader.f26838d;
        logger.a("ligatureCount=" + readShort);
        ArrayList<Integer> arrayList = new ArrayList<>(readShort);
        for (int i4 = 0; i4 < readShort; i4++) {
            arrayList.add(Integer.valueOf(this.f26839a.readShort()));
        }
        for (Integer intValue : arrayList) {
            u(intValue.intValue() + i2, i3);
        }
    }

    private void t(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        Logger logger = OpenTypeFontTableReader.f26838d;
        logger.a("substFormat=" + readShort);
        if (readShort == 1) {
            short readShort2 = this.f26839a.readShort();
            logger.a("coverage=" + readShort2);
            short readShort3 = this.f26839a.readShort();
            ArrayList arrayList = new ArrayList(readShort3);
            for (int i3 = 0; i3 < readShort3; i3++) {
                arrayList.add(Integer.valueOf(this.f26839a.readShort()));
            }
            List<Integer> b2 = b(readShort2 + i2);
            if (readShort3 == b2.size()) {
                for (int i4 = 0; i4 < readShort3; i4++) {
                    int intValue = b2.get(i4).intValue();
                    int intValue2 = ((Integer) arrayList.get(i4)).intValue();
                    Logger logger2 = OpenTypeFontTableReader.f26838d;
                    logger2.a("ligatureOffset=" + intValue2);
                    s(intValue2 + i2, intValue);
                }
                return;
            }
            throw new IllegalArgumentException("According to the OpenTypeFont specifications, the coverage count should be equal to the no. of LigatureSetTables");
        }
        throw new IllegalArgumentException("The expected SubstFormat is 1");
    }

    private void u(int i2, int i3) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        Logger logger = OpenTypeFontTableReader.f26838d;
        logger.a("ligGlyph=" + readShort);
        short readShort2 = this.f26839a.readShort();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i3));
        for (int i4 = 0; i4 < readShort2 - 1; i4++) {
            arrayList.add(Integer.valueOf(this.f26839a.readShort()));
        }
        Logger logger2 = OpenTypeFontTableReader.f26838d;
        logger2.a("glyphIdList=" + arrayList);
        List put = this.f26837g.put(Integer.valueOf(readShort), arrayList);
        if (put != null) {
            logger2.g("!!!!!!!!!!glyphId=" + readShort + ",\npreviousValue=" + put + ",\ncurrentVal=" + arrayList);
        }
    }

    private void v(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        Logger logger = OpenTypeFontTableReader.f26838d;
        logger.a("substFormat=" + readShort);
        if (readShort == 1) {
            short readShort2 = this.f26839a.readShort();
            logger.a("coverage=" + readShort2);
            short readShort3 = this.f26839a.readShort();
            logger.a("deltaGlyphID=" + readShort3);
            for (Integer next : b(i2 + readShort2)) {
                this.f26837g.put(Integer.valueOf(next.intValue() + readShort3), Arrays.asList(new Integer[]{next}));
            }
        } else if (readShort == 2) {
            short readShort4 = this.f26839a.readShort();
            logger.a("coverage=" + readShort4);
            int readUnsignedShort = this.f26839a.readUnsignedShort();
            int[] iArr = new int[readUnsignedShort];
            for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                iArr[i3] = this.f26839a.readUnsignedShort();
            }
            List<Integer> b2 = b(i2 + readShort4);
            for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                this.f26837g.put(Integer.valueOf(iArr[i4]), Arrays.asList(new Integer[]{b2.get(i4)}));
            }
        } else {
            throw new IllegalArgumentException("Bad substFormat: " + readShort);
        }
    }

    /* access modifiers changed from: protected */
    public void n(int i2, int i3) throws IOException {
        if (i2 == 1) {
            v(i3);
        } else if (i2 == 4) {
            t(i3);
        } else {
            PrintStream printStream = System.err;
            printStream.println("LookupType " + i2 + " is not yet handled for " + GlyphSubstitutionTableReader.class.getSimpleName());
        }
    }

    public Map<String, Glyph> p() throws FontReadingException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer next : this.f26837g.keySet()) {
            List<Integer> list = this.f26837g.get(next);
            StringBuilder sb = new StringBuilder(list.size());
            for (Integer intValue : list) {
                sb.append(q(intValue.intValue(), this.f26836f));
            }
            Glyph glyph = new Glyph(next.intValue(), this.f26835e[next.intValue()], sb.toString());
            linkedHashMap.put(glyph.f26066c, glyph);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public void r() throws FontReadingException {
        this.f26837g = new LinkedHashMap();
        o();
    }
}
