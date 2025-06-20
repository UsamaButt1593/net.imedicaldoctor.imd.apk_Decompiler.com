package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.HashMap;

public class Type3Font extends BaseFont {
    private float A4;
    private float B4;
    private float C4;
    private float D4;
    private PageResources E4;
    private boolean F4;
    private boolean[] w4;
    private IntHashtable x4;
    private HashMap<Integer, Type3Glyph> y4;
    private PdfWriter z4;

    public Type3Font(PdfWriter pdfWriter, boolean z) {
        this.x4 = new IntHashtable();
        this.y4 = new HashMap<>();
        this.A4 = Float.NaN;
        this.E4 = new PageResources();
        this.z4 = pdfWriter;
        this.F4 = z;
        this.X = 5;
        this.w4 = new boolean[256];
    }

    public String[][] H() {
        return L();
    }

    public float I(int i2, float f2) {
        return 0.0f;
    }

    public String[][] L() {
        return new String[][]{new String[]{"", "", "", ""}};
    }

    public PdfStream N() {
        return null;
    }

    public int O(int i2, int i3) {
        return 0;
    }

    public String P() {
        return "";
    }

    /* access modifiers changed from: protected */
    public int[] Q(int i2, String str) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int R(int i2, String str) {
        return 0;
    }

    public int W(int i2) {
        if (this.x4.c(i2)) {
            return this.x4.e(i2);
        }
        throw new IllegalArgumentException(MessageLocalization.a("the.char.1.is.not.defined.in.a.type3.font", i2));
    }

    public int X(String str) {
        char[] charArray = str.toCharArray();
        int i2 = 0;
        for (char W : charArray) {
            i2 += W(W);
        }
        return i2;
    }

    public boolean c(int i2) {
        if (i2 <= 0 || i2 >= 256) {
            return false;
        }
        return this.w4[i2];
    }

    public boolean c0() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public byte[] d(int i2) {
        if (!c(i2)) {
            return new byte[0];
        }
        return new byte[]{(byte) i2};
    }

    public byte[] e(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        int i2 = 0;
        for (char c2 : charArray) {
            if (c(c2)) {
                bArr[i2] = (byte) c2;
                i2++;
            }
        }
        if (length == i2) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    public boolean l0(int i2, int i3) {
        return false;
    }

    public boolean q0(int i2, int i3, int i4) {
        return false;
    }

    public void r0(String str) {
    }

    public String[][] s() {
        return new String[][]{new String[]{"4", "", "", "", ""}};
    }

    /* access modifiers changed from: package-private */
    public void t0(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        boolean[] zArr;
        PdfWriter pdfWriter2 = pdfWriter;
        int i2 = -1;
        if (this.z4 == pdfWriter2) {
            int i3 = 0;
            while (true) {
                zArr = this.w4;
                if (i3 < zArr.length && !zArr[i3]) {
                    i3++;
                }
            }
            if (i3 != zArr.length) {
                int length = zArr.length - 1;
                while (length >= i3 && !this.w4[length]) {
                    length--;
                }
                int i4 = (length - i3) + 1;
                int[] iArr = new int[i4];
                int[] iArr2 = new int[i4];
                int i5 = i3;
                int i6 = 0;
                int i7 = 0;
                while (i5 <= length) {
                    if (this.w4[i5]) {
                        iArr2[i6] = i5;
                        iArr[i7] = this.x4.e(i5);
                        i6++;
                    }
                    i5++;
                    i7++;
                }
                PdfArray pdfArray = new PdfArray();
                PdfDictionary pdfDictionary = new PdfDictionary();
                for (int i8 = 0; i8 < i6; i8++) {
                    int i9 = iArr2[i8];
                    if (i9 > i2) {
                        pdfArray.a0(new PdfNumber(i9));
                        i2 = i9;
                    }
                    i2++;
                    int i10 = iArr2[i8];
                    String b2 = GlyphList.b(i10);
                    if (b2 == null) {
                        b2 = "a" + i10;
                    }
                    PdfName pdfName = new PdfName(b2);
                    pdfArray.a0(pdfName);
                    PdfStream pdfStream = new PdfStream(this.y4.get(Integer.valueOf(i10)).w3((PdfWriter) null));
                    pdfStream.i1(this.b3);
                    pdfDictionary.V0(pdfName, pdfWriter2.v0(pdfStream).a());
                }
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.l8);
                pdfDictionary2.V0(PdfName.Cf, PdfName.Ng);
                if (this.F4) {
                    pdfDictionary2.V0(PdfName.m8, new PdfRectangle(0.0f, 0.0f, 0.0f, 0.0f));
                } else {
                    pdfDictionary2.V0(PdfName.m8, new PdfRectangle(this.A4, this.B4, this.C4, this.D4));
                }
                pdfDictionary2.V0(PdfName.s8, new PdfArray(new float[]{0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f}));
                pdfDictionary2.V0(PdfName.f5, pdfWriter2.v0(pdfDictionary).a());
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                pdfDictionary3.V0(PdfName.F6, pdfArray);
                pdfDictionary2.V0(PdfName.m7, pdfWriter2.v0(pdfDictionary3).a());
                pdfDictionary2.V0(PdfName.V7, new PdfNumber(i3));
                pdfDictionary2.V0(PdfName.pa, new PdfNumber(length));
                pdfDictionary2.V0(PdfName.Kh, pdfWriter2.v0(new PdfArray(iArr)).a());
                if (this.E4.l()) {
                    pdfDictionary2.V0(PdfName.Wd, pdfWriter2.v0(this.E4.k()).a());
                }
                pdfWriter2.y0(pdfDictionary2, pdfIndirectReference);
                return;
            }
            throw new DocumentException(MessageLocalization.b("no.glyphs.defined.for.type3.font", new Object[0]));
        }
        throw new IllegalArgumentException(MessageLocalization.b("type3.font.used.with.the.wrong.pdfwriter", new Object[0]));
    }

    public PdfContentByte u0(char c2, float f2, float f3, float f4, float f5, float f6) {
        char c3 = c2;
        float f7 = f3;
        float f8 = f4;
        float f9 = f5;
        float f10 = f6;
        if (c3 == 0 || c3 > 255) {
            throw new IllegalArgumentException(MessageLocalization.a("the.char.1.doesn.t.belong.in.this.type3.font", c2));
        }
        this.w4[c3] = true;
        Integer valueOf = Integer.valueOf(c2);
        Type3Glyph type3Glyph = this.y4.get(valueOf);
        if (type3Glyph != null) {
            return type3Glyph;
        }
        this.x4.l(c2, (int) f2);
        if (!this.F4) {
            if (Float.isNaN(this.A4)) {
                this.A4 = f7;
                this.B4 = f8;
                this.C4 = f9;
                this.D4 = f10;
            } else {
                this.A4 = Math.min(this.A4, f3);
                this.B4 = Math.min(this.B4, f8);
                this.C4 = Math.max(this.C4, f9);
                this.D4 = Math.max(this.D4, f10);
            }
        }
        Type3Glyph type3Glyph2 = new Type3Glyph(this.z4, this.E4, f2, f3, f4, f5, f6, this.F4);
        this.y4.put(valueOf, type3Glyph2);
        return type3Glyph2;
    }

    public int[] x(int i2) {
        return null;
    }

    public Type3Font(PdfWriter pdfWriter, char[] cArr, boolean z) {
        this(pdfWriter, z);
    }
}
