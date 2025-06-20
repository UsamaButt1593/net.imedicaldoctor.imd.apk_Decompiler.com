package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.fonts.cmaps.CMapParserEx;
import com.itextpdf.text.pdf.fonts.cmaps.CMapToUnicode;
import com.itextpdf.text.pdf.fonts.cmaps.CidLocationFromByte;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.imedicaldoctor.imd.BuildConfig;

public class DocumentFont extends BaseFont {
    private static final int[] S4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 33, 34, 35, 36, 37, 38, 8217, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 8216, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 161, 162, 163, 8260, 165, 402, 167, 164, 39, 8220, 171, 8249, 8250, 64257, 64258, 0, 8211, 8224, 8225, 183, 0, 182, 8226, 8218, 8222, 8221, 187, 8230, 8240, 0, 191, 0, 96, BuildConfig.f29478d, 710, 732, 175, 728, 729, 168, 0, 730, 184, 0, 733, 731, 711, 8212, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 198, 0, 170, 0, 0, 0, 0, TIFFConstants.p1, 216, TIFFConstants.H1, 186, 0, 0, 0, 0, 0, 230, 0, 0, 0, 305, 0, 0, 322, 248, TIFFConstants.L1, 223, 0, 0, 0, 0};
    private IntHashtable A4;
    private IntHashtable B4;
    private IntHashtable C4;
    private float D4;
    private float E4;
    private float F4;
    private float G4;
    private float H4;
    private float I4;
    private float J4;
    private float K4;
    private float L4;
    protected boolean M4;
    protected int N4;
    private IntHashtable O4;
    protected String P4;
    protected String Q4;
    private BaseFont R4;
    private HashMap<Integer, int[]> w4;
    private String x4;
    private PRIndirectReference y4;
    private PdfDictionary z4;

    DocumentFont(PRIndirectReference pRIndirectReference) {
        this.w4 = new HashMap<>();
        this.A4 = new IntHashtable();
        this.B4 = new IntHashtable();
        this.D4 = 800.0f;
        this.E4 = 700.0f;
        this.F4 = -200.0f;
        this.G4 = 0.0f;
        this.H4 = 0.0f;
        this.I4 = -50.0f;
        this.J4 = -200.0f;
        this.K4 = 100.0f;
        this.L4 = 900.0f;
        this.M4 = false;
        this.N4 = 1000;
        this.y4 = pRIndirectReference;
        this.z4 = (PdfDictionary) PdfReader.t0(pRIndirectReference);
        H0();
    }

    private void A0(IntHashtable intHashtable, int i2) {
        for (int i3 = 0; i3 < 65536; i3++) {
            this.w4.put(Integer.valueOf(i3), new int[]{i3, intHashtable.c(i3) ? intHashtable.e(i3) : i2});
        }
    }

    private void B0() {
        PdfArray e0 = this.z4.e0(PdfName.Kh);
        PdfNumber q0 = this.z4.q0(PdfName.V7);
        PdfNumber q02 = this.z4.q0(PdfName.pa);
        if (q0 != null && q02 != null && e0 != null) {
            int e02 = q0.e0();
            int size = e0.size() + e02;
            int[] iArr = this.Y;
            if (iArr.length < size) {
                int[] iArr2 = new int[size];
                System.arraycopy(iArr, 0, iArr2, 0, e02);
                this.Y = iArr2;
            }
            for (int i2 = 0; i2 < e0.size(); i2++) {
                this.Y[e02 + i2] = e0.J0(i2).e0();
            }
        }
    }

    private void H0() {
        this.Z2 = "";
        this.c3 = false;
        this.X = 4;
        PdfName p0 = this.z4.p0(PdfName.l4);
        this.x4 = p0 != null ? PdfName.a0(p0.toString()) : "Unspecified Font Name";
        PdfName p02 = this.z4.p0(PdfName.Cf);
        if (PdfName.Mg.equals(p02) || PdfName.Ag.equals(p02)) {
            v0();
        } else if (PdfName.Ng.equals(p02)) {
            x0((PdfName) null);
            w0(this.z4.j0(PdfName.m7), (CMapToUnicode) null);
            B0();
        } else {
            PdfName p03 = this.z4.p0(PdfName.m7);
            if (p03 != null) {
                String a0 = PdfName.a0(p03.toString());
                String u0 = CJKFont.u0(a0);
                if (u0 != null) {
                    try {
                        BaseFont j2 = BaseFont.j(u0, a0, false);
                        this.R4 = j2;
                        this.P4 = a0;
                        this.Q4 = ((CJKFont) j2).D0();
                    } catch (Exception e2) {
                        throw new ExceptionConverter(e2);
                    }
                }
                if (PdfName.Lg.equals(p02)) {
                    this.M4 = true;
                    if (a0.equals(BaseFont.a4) || this.R4 == null) {
                        K0(this.z4);
                        return;
                    }
                    PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(((PdfArray) PdfReader.w0(this.z4.d0(PdfName.v6))).T0(0));
                    PdfNumber pdfNumber = (PdfNumber) PdfReader.w0(pdfDictionary.d0(PdfName.b7));
                    if (pdfNumber != null) {
                        this.N4 = pdfNumber.e0();
                    }
                    this.O4 = L0((PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.Dh)));
                    y0((PdfDictionary) PdfReader.w0(pdfDictionary.d0(PdfName.n8)));
                }
            }
        }
    }

    private CMapToUnicode J0() {
        PdfObject w0 = PdfReader.w0(this.z4.d0(PdfName.pg));
        if (!(w0 instanceof PRStream)) {
            return null;
        }
        try {
            CidLocationFromByte cidLocationFromByte = new CidLocationFromByte(PdfReader.D0((PRStream) w0));
            CMapToUnicode cMapToUnicode = new CMapToUnicode();
            CMapParserEx.b("", cMapToUnicode, cidLocationFromByte);
            return cMapToUnicode;
        } catch (Exception unused) {
            return null;
        }
    }

    private void K0(PdfDictionary pdfDictionary) {
        try {
            PdfObject w0 = PdfReader.w0(pdfDictionary.d0(PdfName.pg));
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.w0(((PdfArray) PdfReader.w0(pdfDictionary.d0(PdfName.v6))).T0(0));
            PdfNumber pdfNumber = (PdfNumber) PdfReader.w0(pdfDictionary2.d0(PdfName.b7));
            int e0 = pdfNumber != null ? pdfNumber.e0() : 1000;
            IntHashtable L0 = L0((PdfArray) PdfReader.w0(pdfDictionary2.d0(PdfName.Dh)));
            y0((PdfDictionary) PdfReader.w0(pdfDictionary2.d0(PdfName.n8)));
            if (w0 instanceof PRStream) {
                z0(PdfReader.D0((PRStream) w0), L0, e0);
            } else if (new PdfName(BaseFont.a4).equals(w0)) {
                A0(L0, e0);
            }
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    private IntHashtable L0(PdfArray pdfArray) {
        IntHashtable intHashtable = new IntHashtable();
        if (pdfArray == null) {
            return intHashtable;
        }
        int i2 = 0;
        while (i2 < pdfArray.size()) {
            int e0 = ((PdfNumber) PdfReader.w0(pdfArray.T0(i2))).e0();
            int i3 = i2 + 1;
            PdfObject w0 = PdfReader.w0(pdfArray.T0(i3));
            if (w0.q()) {
                PdfArray pdfArray2 = (PdfArray) w0;
                int i4 = 0;
                while (i4 < pdfArray2.size()) {
                    intHashtable.l(e0, ((PdfNumber) PdfReader.w0(pdfArray2.T0(i4))).e0());
                    i4++;
                    e0++;
                }
            } else {
                int e02 = ((PdfNumber) w0).e0();
                int i5 = i2 + 2;
                int e03 = ((PdfNumber) PdfReader.w0(pdfArray.T0(i5))).e0();
                while (e0 <= e02) {
                    intHashtable.l(e0, e03);
                    e0++;
                }
                i3 = i5;
            }
            i2 = i3 + 1;
        }
        return intHashtable;
    }

    private String u0(PdfString pdfString) {
        return pdfString.e0() ? PdfEncodings.d(pdfString.k(), "UnicodeBigUnmarked") : pdfString.m0();
    }

    private void v0() {
        PdfObject t0 = PdfReader.t0(this.z4.d0(PdfName.m7));
        if (t0 == null) {
            PdfName p0 = this.z4.p0(PdfName.l4);
            if (!BaseFont.v4.containsKey(this.x4) || (!PdfName.Hf.equals(p0) && !PdfName.ii.equals(p0))) {
                x0((PdfName) null);
            } else {
                x0(p0);
            }
            try {
                CMapToUnicode J0 = J0();
                if (J0 != null) {
                    for (Map.Entry next : J0.r().entrySet()) {
                        this.A4.l(((Integer) next.getKey()).intValue(), ((Integer) next.getValue()).intValue());
                        this.B4.l(((Integer) next.getValue()).intValue(), ((Integer) next.getKey()).intValue());
                    }
                }
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else if (t0.E()) {
            x0((PdfName) t0);
        } else if (t0.z()) {
            PdfDictionary pdfDictionary = (PdfDictionary) t0;
            PdfObject t02 = PdfReader.t0(pdfDictionary.d0(PdfName.k4));
            if (t02 == null) {
                x0((PdfName) null);
            } else {
                x0((PdfName) t02);
            }
            w0(pdfDictionary, (CMapToUnicode) null);
        }
        if (BaseFont.v4.containsKey(this.x4)) {
            try {
                BaseFont j2 = BaseFont.j(this.x4, "Cp1252", false);
                int[] p = this.A4.p();
                for (int i2 = 0; i2 < p.length; i2++) {
                    int e3 = this.A4.e(p[i2]);
                    this.Y[e3] = j2.R(e3, GlyphList.b(p[i2]));
                }
                IntHashtable intHashtable = this.C4;
                if (intHashtable != null) {
                    int[] p2 = intHashtable.p();
                    for (int i3 = 0; i3 < p2.length; i3++) {
                        int e4 = this.C4.e(p2[i3]);
                        this.Y[e4] = j2.R(e4, GlyphList.b(p2[i3]));
                    }
                    this.C4 = null;
                }
                this.D4 = j2.I(1, 1000.0f);
                this.E4 = j2.I(2, 1000.0f);
                this.F4 = j2.I(3, 1000.0f);
                this.G4 = j2.I(4, 1000.0f);
                this.H4 = j2.I(23, 1000.0f);
                this.I4 = j2.I(5, 1000.0f);
                this.J4 = j2.I(6, 1000.0f);
                this.K4 = j2.I(7, 1000.0f);
                this.L4 = j2.I(8, 1000.0f);
            } catch (Exception e5) {
                throw new ExceptionConverter(e5);
            }
        }
        B0();
        y0(this.z4.j0(PdfName.n8));
    }

    private void w0(PdfDictionary pdfDictionary, CMapToUnicode cMapToUnicode) {
        IntHashtable intHashtable;
        int charAt;
        PdfArray e0 = pdfDictionary.e0(PdfName.F6);
        if (e0 != null) {
            this.C4 = new IntHashtable();
            int i2 = 0;
            for (int i3 = 0; i3 < e0.size(); i3++) {
                PdfObject T0 = e0.T0(i3);
                if (T0.I()) {
                    i2 = ((PdfNumber) T0).e0();
                } else {
                    int[] a2 = GlyphList.a(PdfName.a0(((PdfName) T0).toString()));
                    if (a2 == null || a2.length <= 0) {
                        if (cMapToUnicode == null && (cMapToUnicode = J0()) == null) {
                            cMapToUnicode = new CMapToUnicode();
                        }
                        String w = cMapToUnicode.w(new byte[]{(byte) i2}, 0, 1);
                        if (w != null && w.length() == 1) {
                            this.A4.l(w.charAt(0), i2);
                            this.B4.l(i2, w.charAt(0));
                            intHashtable = this.C4;
                            charAt = w.charAt(0);
                        }
                        i2++;
                    } else {
                        this.A4.l(a2[0], i2);
                        this.B4.l(i2, a2[0]);
                        intHashtable = this.C4;
                        charAt = a2[0];
                    }
                    intHashtable.l(charAt, i2);
                    i2++;
                }
            }
        }
    }

    private void x0(PdfName pdfName) {
        int i2 = 0;
        if (pdfName == null && I0()) {
            while (i2 < 256) {
                this.A4.l(i2, i2);
                this.B4.l(i2, i2);
                i2++;
            }
        } else if (PdfName.Sa.equals(pdfName) || PdfName.Mh.equals(pdfName) || PdfName.Hf.equals(pdfName) || PdfName.ii.equals(pdfName)) {
            byte[] bArr = new byte[256];
            for (int i3 = 0; i3 < 256; i3++) {
                bArr[i3] = (byte) i3;
            }
            String str = PdfName.Sa.equals(pdfName) ? BaseFont.g4 : PdfName.Hf.equals(pdfName) ? "Symbol" : PdfName.ii.equals(pdfName) ? "ZapfDingbats" : "Cp1252";
            char[] charArray = PdfEncodings.d(bArr, str).toCharArray();
            while (i2 < 256) {
                this.A4.l(charArray[i2], i2);
                this.B4.l(i2, charArray[i2]);
                i2++;
            }
            this.Z2 = str;
        } else {
            while (i2 < 256) {
                IntHashtable intHashtable = this.A4;
                int[] iArr = S4;
                intHashtable.l(iArr[i2], i2);
                this.B4.l(i2, iArr[i2]);
                i2++;
            }
        }
    }

    private void y0(PdfDictionary pdfDictionary) {
        if (pdfDictionary != null) {
            PdfNumber q0 = pdfDictionary.q0(PdfName.Y3);
            if (q0 != null) {
                this.D4 = q0.a0();
            }
            PdfNumber q02 = pdfDictionary.q0(PdfName.R4);
            if (q02 != null) {
                this.E4 = q02.a0();
            }
            PdfNumber q03 = pdfDictionary.q0(PdfName.w6);
            if (q03 != null) {
                this.F4 = q03.a0();
            }
            PdfNumber q04 = pdfDictionary.q0(PdfName.X9);
            if (q04 != null) {
                this.G4 = q04.a0();
            }
            PdfNumber q05 = pdfDictionary.q0(PdfName.u8);
            if (q05 != null) {
                this.H4 = q05.a0();
            }
            PdfArray e0 = pdfDictionary.e0(PdfName.m8);
            if (e0 != null) {
                this.I4 = e0.J0(0).a0();
                this.J4 = e0.J0(1).a0();
                this.K4 = e0.J0(2).a0();
                float a0 = e0.J0(3).a0();
                this.L4 = a0;
                float f2 = this.I4;
                float f3 = this.K4;
                if (f2 > f3) {
                    this.I4 = f3;
                    this.K4 = f2;
                }
                float f4 = this.J4;
                if (f4 > a0) {
                    this.J4 = a0;
                    this.L4 = f4;
                }
            }
            float max = Math.max(this.L4, this.D4);
            float min = Math.min(this.J4, this.F4);
            float f5 = max * 1000.0f;
            float f6 = max - min;
            this.D4 = f5 / f6;
            this.F4 = (min * 1000.0f) / f6;
        }
    }

    private void z0(byte[] bArr, IntHashtable intHashtable, int i2) {
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().j(bArr))));
            int i3 = 50;
            boolean z = true;
            int i4 = 0;
            while (true) {
                if (z || i4 > 0) {
                    try {
                        PdfObject f2 = pdfContentParser.f();
                        if (f2 != null) {
                            if (f2.W() == 200) {
                                if (f2.toString().equals("begin")) {
                                    i4++;
                                    z = false;
                                } else if (f2.toString().equals(TtmlNode.p0)) {
                                    i4--;
                                } else if (f2.toString().equals("beginbfchar")) {
                                    while (true) {
                                        PdfObject f3 = pdfContentParser.f();
                                        if (f3.toString().equals("endbfchar")) {
                                            break;
                                        }
                                        String u0 = u0((PdfString) f3);
                                        String u02 = u0((PdfString) pdfContentParser.f());
                                        if (u02.length() == 1) {
                                            int charAt = u0.charAt(0);
                                            this.w4.put(Integer.valueOf(u02.charAt(u02.length() - 1)), new int[]{charAt, intHashtable.c(charAt) ? intHashtable.e(charAt) : i2});
                                        }
                                    }
                                } else if (f2.toString().equals("beginbfrange")) {
                                    while (true) {
                                        PdfObject f4 = pdfContentParser.f();
                                        if (f4.toString().equals("endbfrange")) {
                                            break;
                                        }
                                        String u03 = u0((PdfString) f4);
                                        String u04 = u0((PdfString) pdfContentParser.f());
                                        int charAt2 = u03.charAt(0);
                                        char charAt3 = u04.charAt(0);
                                        PdfObject f5 = pdfContentParser.f();
                                        if (f5.N()) {
                                            String u05 = u0((PdfString) f5);
                                            if (u05.length() == 1) {
                                                int charAt4 = u05.charAt(u05.length() - 1);
                                                while (charAt2 <= charAt3) {
                                                    this.w4.put(Integer.valueOf(charAt4), new int[]{charAt2, intHashtable.c(charAt2) ? intHashtable.e(charAt2) : i2});
                                                    charAt2++;
                                                    charAt4++;
                                                }
                                            }
                                        } else {
                                            PdfArray pdfArray = (PdfArray) f5;
                                            int i5 = 0;
                                            while (i5 < pdfArray.size()) {
                                                String u06 = u0(pdfArray.P0(i5));
                                                if (u06.length() == 1) {
                                                    this.w4.put(Integer.valueOf(u06.charAt(u06.length() - 1)), new int[]{charAt2, intHashtable.c(charAt2) ? intHashtable.e(charAt2) : i2});
                                                }
                                                i5++;
                                                charAt2++;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                    } catch (Exception unused) {
                        i3--;
                        if (i3 < 0) {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public IntHashtable C0() {
        return this.B4;
    }

    /* access modifiers changed from: package-private */
    public IntHashtable D0() {
        return this.C4;
    }

    public PdfDictionary E0() {
        return this.z4;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference F0() {
        PRIndirectReference pRIndirectReference = this.y4;
        if (pRIndirectReference != null) {
            return pRIndirectReference;
        }
        throw new IllegalArgumentException("Font reuse not allowed with direct font objects.");
    }

    /* access modifiers changed from: package-private */
    public IntHashtable G0() {
        return this.A4;
    }

    public String[][] H() {
        return L();
    }

    public float I(int i2, float f2) {
        float f3;
        BaseFont baseFont = this.R4;
        if (baseFont != null) {
            return baseFont.I(i2, f2);
        }
        if (i2 == 12) {
            f3 = this.K4 - this.I4;
        } else if (i2 != 23) {
            switch (i2) {
                case 1:
                case 9:
                    f3 = this.D4;
                    break;
                case 2:
                    f3 = this.E4;
                    break;
                case 3:
                case 10:
                    f3 = this.F4;
                    break;
                case 4:
                    return this.G4;
                case 5:
                    f3 = this.I4;
                    break;
                case 6:
                    f3 = this.J4;
                    break;
                case 7:
                    f3 = this.K4;
                    break;
                case 8:
                    f3 = this.L4;
                    break;
                default:
                    return 0.0f;
            }
        } else {
            f3 = this.H4;
        }
        return (f3 * f2) / 1000.0f;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = r0.q0(com.itextpdf.text.pdf.PdfName.g8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean I0() {
        /*
            r3 = this;
            com.itextpdf.text.pdf.PdfDictionary r0 = r3.z4
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.n8
            com.itextpdf.text.pdf.PdfDictionary r0 = r0.j0(r1)
            r1 = 0
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.g8
            com.itextpdf.text.pdf.PdfNumber r0 = r0.q0(r2)
            if (r0 != 0) goto L_0x0015
            return r1
        L_0x0015:
            int r0 = r0.e0()
            r0 = r0 & 4
            if (r0 == 0) goto L_0x001e
            r1 = 1
        L_0x001e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.DocumentFont.I0():boolean");
    }

    public double[] J() {
        PdfDictionary pdfDictionary = this.z4;
        PdfName pdfName = PdfName.s8;
        return pdfDictionary.e0(pdfName) != null ? this.z4.e0(pdfName).j0() : BaseFont.l4;
    }

    public String[][] L() {
        return new String[][]{new String[]{"", "", "", this.x4}};
    }

    public PdfStream N() {
        return null;
    }

    public int O(int i2, int i3) {
        return 0;
    }

    public String P() {
        return this.x4;
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
        BaseFont baseFont;
        if (!this.M4) {
            BaseFont baseFont2 = this.R4;
            return baseFont2 != null ? baseFont2.W(i2) : super.W(i2);
        } else if (this.O4 == null || (baseFont = this.R4) == null || baseFont.i0()) {
            int[] iArr = this.w4.get(Integer.valueOf(i2));
            if (iArr != null) {
                return iArr[1];
            }
            return 0;
        } else {
            int e2 = this.O4.e(this.R4.y(i2));
            return e2 > 0 ? e2 : this.N4;
        }
    }

    public int X(String str) {
        BaseFont baseFont;
        int i2;
        if (this.M4) {
            int i3 = 0;
            if (this.O4 == null || (baseFont = this.R4) == null || baseFont.i0()) {
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i4 = 0;
                while (i3 < length) {
                    int[] iArr = this.w4.get(Integer.valueOf(charArray[i3]));
                    if (iArr != null) {
                        i4 += iArr[1];
                    }
                    i3++;
                }
                return i4;
            } else if (((CJKFont) this.R4).F0()) {
                int i5 = 0;
                while (i3 < str.length()) {
                    i5 += W(str.charAt(i3));
                    i3++;
                }
                return i5;
            } else {
                int i6 = 0;
                while (i3 < str.length()) {
                    if (Utilities.n(str, i3)) {
                        i2 = Utilities.f(str, i3);
                        i3++;
                    } else {
                        i2 = str.charAt(i3);
                    }
                    i6 += W(i2);
                    i3++;
                }
                return i6;
            }
        } else {
            BaseFont baseFont2 = this.R4;
            return baseFont2 != null ? baseFont2.X(str) : super.X(str);
        }
    }

    public boolean c(int i2) {
        BaseFont baseFont = this.R4;
        if (baseFont != null) {
            return baseFont.c(i2);
        }
        return this.M4 ? this.w4.containsKey(Integer.valueOf(i2)) : super.c(i2);
    }

    public boolean c0() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public byte[] d(int i2) {
        BaseFont baseFont = this.R4;
        if (baseFont != null) {
            return baseFont.d(i2);
        }
        if (this.M4) {
            int[] iArr = this.w4.get(Integer.valueOf(i2));
            if (iArr == null) {
                return new byte[0];
            }
            int i3 = iArr[0];
            return new byte[]{(byte) (i3 / 256), (byte) i3};
        } else if (!this.A4.c(i2)) {
            return new byte[0];
        } else {
            return new byte[]{(byte) this.A4.e(i2)};
        }
    }

    public byte[] e(String str) {
        BaseFont baseFont = this.R4;
        if (baseFont != null) {
            return baseFont.e(str);
        }
        boolean z = this.M4;
        char[] charArray = str.toCharArray();
        if (z) {
            int i2 = r0 * 2;
            byte[] bArr = new byte[i2];
            int i3 = 0;
            for (char valueOf : charArray) {
                int[] iArr = this.w4.get(Integer.valueOf(valueOf));
                if (iArr != null) {
                    int i4 = iArr[0];
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) (i4 / 256);
                    i3 += 2;
                    bArr[i5] = (byte) i4;
                }
            }
            if (i3 == i2) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, 0, bArr2, 0, i3);
            return bArr2;
        }
        int length = charArray.length;
        byte[] bArr3 = new byte[length];
        int i6 = 0;
        for (int i7 = 0; i7 < charArray.length; i7++) {
            if (this.A4.c(charArray[i7])) {
                bArr3[i6] = (byte) this.A4.e(charArray[i7]);
                i6++;
            }
        }
        if (i6 == length) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i6];
        System.arraycopy(bArr3, 0, bArr4, 0, i6);
        return bArr4;
    }

    public boolean i0() {
        BaseFont baseFont = this.R4;
        return baseFont != null ? baseFont.i0() : super.i0();
    }

    public boolean q0(int i2, int i3, int i4) {
        return false;
    }

    public void r0(String str) {
    }

    public String[][] s() {
        return new String[][]{new String[]{"4", "", "", "", this.x4}};
    }

    /* access modifiers changed from: package-private */
    public void t0(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
    }

    public int[] x(int i2) {
        return null;
    }

    DocumentFont(PRIndirectReference pRIndirectReference, PdfDictionary pdfDictionary) {
        this.w4 = new HashMap<>();
        this.A4 = new IntHashtable();
        this.B4 = new IntHashtable();
        this.D4 = 800.0f;
        this.E4 = 700.0f;
        this.F4 = -200.0f;
        this.G4 = 0.0f;
        this.H4 = 0.0f;
        this.I4 = -50.0f;
        this.J4 = -200.0f;
        this.K4 = 100.0f;
        this.L4 = 900.0f;
        this.M4 = false;
        this.N4 = 1000;
        this.y4 = pRIndirectReference;
        PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.t0(pRIndirectReference);
        this.z4 = pdfDictionary2;
        if (pdfDictionary2.d0(PdfName.m7) == null && pdfDictionary != null) {
            for (PdfName d0 : pdfDictionary.G0()) {
                this.z4.V0(PdfName.m7, pdfDictionary.d0(d0));
            }
        }
        H0();
    }

    DocumentFont(PdfDictionary pdfDictionary) {
        this.w4 = new HashMap<>();
        this.A4 = new IntHashtable();
        this.B4 = new IntHashtable();
        this.D4 = 800.0f;
        this.E4 = 700.0f;
        this.F4 = -200.0f;
        this.G4 = 0.0f;
        this.H4 = 0.0f;
        this.I4 = -50.0f;
        this.J4 = -200.0f;
        this.K4 = 100.0f;
        this.L4 = 900.0f;
        this.M4 = false;
        this.N4 = 1000;
        this.y4 = null;
        this.z4 = pdfDictionary;
        H0();
    }
}
