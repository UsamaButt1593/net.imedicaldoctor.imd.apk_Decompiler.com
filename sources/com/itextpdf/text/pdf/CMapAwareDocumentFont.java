package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.fonts.cmaps.CMapByteCid;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCache;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidUni;
import com.itextpdf.text.pdf.fonts.cmaps.CMapParserEx;
import com.itextpdf.text.pdf.fonts.cmaps.CMapSequence;
import com.itextpdf.text.pdf.fonts.cmaps.CMapToUnicode;
import com.itextpdf.text.pdf.fonts.cmaps.CidLocationFromByte;
import com.itextpdf.text.pdf.fonts.cmaps.IdentityToUnicode;
import java.io.IOException;
import java.util.Map;

public class CMapAwareDocumentFont extends DocumentFont {
    private PdfDictionary T4;
    private int U4;
    private CMapToUnicode V4;
    private CMapByteCid W4;
    private CMapCidUni X4;
    private char[] Y4;
    private Map<Integer, Integer> Z4;

    public CMapAwareDocumentFont(PRIndirectReference pRIndirectReference) {
        super(pRIndirectReference);
        this.T4 = (PdfDictionary) PdfReader.w0(pRIndirectReference);
        Q0();
    }

    private int M0() {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.Y;
            if (i2 >= iArr.length) {
                break;
            }
            int i5 = iArr[i2];
            if (i5 != 0) {
                i4 += i5;
                i3++;
            }
            i2++;
        }
        if (i3 != 0) {
            return i4 / i3;
        }
        return 0;
    }

    private String O0(byte[] bArr, int i2, int i3) {
        CMapToUnicode cMapToUnicode = this.V4;
        if (cMapToUnicode != null) {
            int i4 = i2 + i3;
            if (i4 <= bArr.length) {
                String w = cMapToUnicode.w(bArr, i2, i3);
                if (w != null) {
                    return w;
                }
                if (i3 != 1 || this.Y4 == null) {
                    return null;
                }
            } else {
                throw new ArrayIndexOutOfBoundsException(MessageLocalization.a("invalid.index.1", i4));
            }
        }
        if (i3 == 1) {
            char[] cArr = this.Y4;
            return cArr == null ? "" : new String(cArr, bArr[i2] & 255, 1);
        }
        throw new Error("Multi-byte glyphs not implemented yet");
    }

    private void Q0() {
        R0();
        try {
            S0();
            int W = super.W(32);
            this.U4 = W;
            if (W == 0) {
                this.U4 = M0();
            }
            String str = this.P4;
            if (str != null) {
                this.W4 = CMapCache.a(str);
                this.X4 = CMapCache.c(this.Q4);
            }
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    private void R0() {
        PdfDictionary j0;
        PdfString A0;
        CMapToUnicode a2;
        Map<Integer, Integer> r;
        PdfObject w0 = PdfReader.w0(this.T4.d0(PdfName.pg));
        if (w0 instanceof PRStream) {
            try {
                CidLocationFromByte cidLocationFromByte = new CidLocationFromByte(PdfReader.D0((PRStream) w0));
                CMapToUnicode cMapToUnicode = new CMapToUnicode();
                this.V4 = cMapToUnicode;
                CMapParserEx.b("", cMapToUnicode, cidLocationFromByte);
                r = this.V4.r();
            } catch (IOException unused) {
                this.V4 = null;
                this.Z4 = null;
                return;
            }
        } else if (this.M4) {
            PdfName p0 = this.T4.p0(PdfName.m7);
            if (p0 != null && PdfName.a0(p0.toString()).equals(BaseFont.a4) && (j0 = ((PdfDictionary) PdfReader.w0(((PdfArray) PdfReader.w0(this.T4.d0(PdfName.v6))).T0(0))).j0(PdfName.l5)) != null && (A0 = j0.A0(PdfName.kc)) != null && (a2 = IdentityToUnicode.a(A0.m0())) != null) {
                this.V4 = a2;
                r = a2.r();
            } else {
                return;
            }
        } else {
            return;
        }
        this.Z4 = r;
    }

    private void S0() throws IOException {
        IntHashtable C0 = C0();
        int[] p = C0.p();
        if (p.length != 0) {
            this.Y4 = new char[256];
            for (int i2 : p) {
                this.Y4[i2] = (char) C0.e(i2);
            }
            CMapToUnicode cMapToUnicode = this.V4;
            if (cMapToUnicode != null) {
                for (Map.Entry next : cMapToUnicode.q().entrySet()) {
                    if (((Integer) next.getKey()).intValue() < 256) {
                        this.Y4[((Integer) next.getKey()).intValue()] = (char) ((Integer) next.getValue()).intValue();
                    }
                }
            }
            IntHashtable D0 = D0();
            if (D0 != null) {
                int[] p2 = D0.p();
                for (int i3 = 0; i3 < p2.length; i3++) {
                    int e2 = D0.e(p2[i3]);
                    if (e2 < 256) {
                        this.Y4[e2] = (char) p2[i3];
                    }
                }
            }
        }
    }

    public String N0(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        if (this.V4 != null || this.W4 == null) {
            int i4 = i2;
            while (true) {
                int i5 = i2 + i3;
                if (i4 >= i5) {
                    break;
                }
                String O0 = O0(bArr, i4, 1);
                if (O0 == null && i4 < i5 - 1) {
                    O0 = O0(bArr, i4, 2);
                    i4++;
                }
                if (O0 != null) {
                    sb.append(O0);
                }
                i4++;
            }
        } else {
            String o = this.W4.o(new CMapSequence(bArr, i2, i3));
            for (int i6 = 0; i6 < o.length(); i6++) {
                int o2 = this.X4.o(o.charAt(i6));
                if (o2 > 0) {
                    sb.append(Utilities.c(o2));
                }
            }
        }
        return sb.toString();
    }

    public String P0(byte[] bArr, int i2, int i3) {
        return N0(bArr, i2, i3);
    }

    public int W(int i2) {
        if (i2 != 32) {
            return super.W(i2);
        }
        int i3 = this.U4;
        return i3 != 0 ? i3 : this.N4;
    }

    public CMapAwareDocumentFont(PdfDictionary pdfDictionary) {
        super(pdfDictionary);
        this.T4 = pdfDictionary;
        Q0();
    }
}
