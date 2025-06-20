package com.itextpdf.text.pdf.fonts.otf;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GlyphPositioningTableReader extends OpenTypeFontTableReader {

    static class MarkRecord {

        /* renamed from: a  reason: collision with root package name */
        final int f26831a;

        /* renamed from: b  reason: collision with root package name */
        final int f26832b;

        public MarkRecord(int i2, int i3) {
            this.f26831a = i2;
            this.f26832b = i3;
        }
    }

    static class PosLookupRecord {

        /* renamed from: a  reason: collision with root package name */
        final int f26833a;

        /* renamed from: b  reason: collision with root package name */
        final int f26834b;

        public PosLookupRecord(int i2, int i3) {
            this.f26833a = i2;
            this.f26834b = i3;
        }
    }

    public GlyphPositioningTableReader(RandomAccessFileOrArray randomAccessFileOrArray, int i2) throws IOException {
        super(randomAccessFileOrArray, i2);
    }

    private void q(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        if (readShort != 1) {
            PrintStream printStream = System.err;
            printStream.println("The extra features of the AnchorFormat " + readShort + " will not be used");
        }
        this.f26839a.readShort();
        this.f26839a.readShort();
    }

    private void r(int i2, int i3) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i4 = 0; i4 < readShort; i4++) {
            for (int i5 = 0; i5 < i3; i5++) {
                hashSet.add(Integer.valueOf(this.f26839a.readShort()));
            }
        }
        for (Integer intValue : hashSet) {
            q(intValue.intValue() + i2);
        }
    }

    private void s(int i2) throws IOException {
        short readShort = this.f26839a.readShort();
        Logger logger = OpenTypeFontTableReader.f26838d;
        logger.a("backtrackGlyphCount=" + readShort);
        ArrayList<Integer> arrayList = new ArrayList<>(readShort);
        for (int i3 = 0; i3 < readShort; i3++) {
            arrayList.add(Integer.valueOf(this.f26839a.readShort()));
        }
        short readShort2 = this.f26839a.readShort();
        Logger logger2 = OpenTypeFontTableReader.f26838d;
        logger2.a("inputGlyphCount=" + readShort2);
        ArrayList<Integer> arrayList2 = new ArrayList<>(readShort2);
        for (int i4 = 0; i4 < readShort2; i4++) {
            arrayList2.add(Integer.valueOf(this.f26839a.readShort()));
        }
        short readShort3 = this.f26839a.readShort();
        Logger logger3 = OpenTypeFontTableReader.f26838d;
        logger3.a("lookaheadGlyphCount=" + readShort3);
        ArrayList<Integer> arrayList3 = new ArrayList<>(readShort3);
        for (int i5 = 0; i5 < readShort3; i5++) {
            arrayList3.add(Integer.valueOf(this.f26839a.readShort()));
        }
        short readShort4 = this.f26839a.readShort();
        Logger logger4 = OpenTypeFontTableReader.f26838d;
        logger4.a("posCount=" + readShort4);
        ArrayList arrayList4 = new ArrayList(readShort4);
        for (int i6 = 0; i6 < readShort4; i6++) {
            short readShort5 = this.f26839a.readShort();
            short readShort6 = this.f26839a.readShort();
            Logger logger5 = OpenTypeFontTableReader.f26838d;
            logger5.a("sequenceIndex=" + readShort5 + ", lookupListIndex=" + readShort6);
            arrayList4.add(new PosLookupRecord(readShort5, readShort6));
        }
        for (Integer intValue : arrayList) {
            List<Integer> b2 = b(intValue.intValue() + i2);
            Logger logger6 = OpenTypeFontTableReader.f26838d;
            logger6.a("backtrackGlyphs=" + b2);
        }
        for (Integer intValue2 : arrayList2) {
            List<Integer> b3 = b(intValue2.intValue() + i2);
            Logger logger7 = OpenTypeFontTableReader.f26838d;
            logger7.a("inputGlyphs=" + b3);
        }
        for (Integer intValue3 : arrayList3) {
            List<Integer> b4 = b(intValue3.intValue() + i2);
            Logger logger8 = OpenTypeFontTableReader.f26838d;
            logger8.a("lookaheadGlyphs=" + b4);
        }
    }

    private void t(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        if (readShort == 1) {
            Logger logger = OpenTypeFontTableReader.f26838d;
            logger.a("Reading `Look Up Type 1, Format 1` ....");
            short readShort2 = this.f26839a.readShort();
            short readShort3 = this.f26839a.readShort();
            if ((readShort3 & 1) == 1) {
                short readShort4 = this.f26839a.readShort();
                logger.a("xPlacement=" + readShort4);
            }
            if ((readShort3 & 2) == 2) {
                short readShort5 = this.f26839a.readShort();
                logger.a("yPlacement=" + readShort5);
            }
            List<Integer> b2 = b(i2 + readShort2);
            logger.a("glyphCodes=" + b2);
            return;
        }
        PrintStream printStream = System.err;
        printStream.println("The PosFormat " + readShort + " for `LookupType 1` is not yet supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }

    private void u(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        if (readShort == 1) {
            Logger logger = OpenTypeFontTableReader.f26838d;
            logger.a("Reading `Look Up Type 4, Format 1` ....");
            short readShort2 = this.f26839a.readShort();
            short readShort3 = this.f26839a.readShort();
            short readShort4 = this.f26839a.readShort();
            short readShort5 = this.f26839a.readShort();
            short readShort6 = this.f26839a.readShort();
            List<Integer> b2 = b(readShort2 + i2);
            logger.a("markCoverages=" + b2);
            List<Integer> b3 = b(readShort3 + i2);
            logger.a("baseCoverages=" + b3);
            w(readShort5 + i2);
            r(i2 + readShort6, readShort4);
            return;
        }
        PrintStream printStream = System.err;
        printStream.println("The posFormat " + readShort + " is not supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }

    private void v(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        if (readShort == 3) {
            OpenTypeFontTableReader.f26838d.a("Reading `Look Up Type 8, Format 3` ....");
            s(i2);
            return;
        }
        PrintStream printStream = System.err;
        printStream.println("The posFormat " + readShort + " for `Look Up Type 8` is not supported by " + GlyphPositioningTableReader.class.getSimpleName());
    }

    private void w(int i2) throws IOException {
        this.f26839a.r((long) i2);
        short readShort = this.f26839a.readShort();
        ArrayList<MarkRecord> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < readShort; i3++) {
            arrayList.add(x());
        }
        for (MarkRecord markRecord : arrayList) {
            q(markRecord.f26832b + i2);
        }
    }

    private MarkRecord x() throws IOException {
        return new MarkRecord(this.f26839a.readShort(), this.f26839a.readShort());
    }

    /* access modifiers changed from: protected */
    public void n(int i2, int i3) throws IOException {
        if (i2 == 1) {
            t(i3);
        } else if (i2 == 4) {
            u(i3);
        } else if (i2 == 8) {
            v(i3);
        } else {
            PrintStream printStream = System.err;
            printStream.println("The lookupType " + i2 + " is not yet supported by " + GlyphPositioningTableReader.class.getSimpleName());
        }
    }

    public void p() throws FontReadingException {
        o();
    }
}
