package com.itextpdf.text.pdf;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.primitives.SignedBytes;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.fonts.otf.GlyphSubstitutionTableReader;
import com.itextpdf.text.pdf.fonts.otf.Language;
import com.itextpdf.text.pdf.languages.ArabicLigaturizer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okio.Utf8;

class TrueTypeFontUnicode extends TrueTypeFont implements Comparator<int[]> {
    private static final List<Language> d5 = Arrays.asList(new Language[]{Language.BENGALI});
    private static final byte[] e5 = {Byte.MIN_VALUE, SignedBytes.f22967a, 32, 16, 8, 4, 2, 1};
    private Map<String, Glyph> b5;
    private Language c5;

    TrueTypeFontUnicode(String str, String str2, boolean z, byte[] bArr, boolean z2) throws DocumentException, IOException {
        String w = BaseFont.w(str);
        String I0 = TrueTypeFont.I0(w);
        if (w.length() < str.length()) {
            this.F4 = str.substring(w.length());
        }
        this.Z2 = str2;
        this.a3 = z;
        this.z4 = I0;
        this.E4 = "";
        if (I0.length() < w.length()) {
            this.E4 = w.substring(I0.length() + 1);
        }
        this.X = 3;
        if ((this.z4.toLowerCase().endsWith(".ttf") || this.z4.toLowerCase().endsWith(".otf") || this.z4.toLowerCase().endsWith(".ttc")) && ((str2.equals(BaseFont.a4) || str2.equals(BaseFont.b4)) && z)) {
            J0(bArr, z2);
            if (this.I4.f26438d != 2) {
                if ((this.M4 == null && !this.c3) || (this.L4 == null && this.c3)) {
                    this.e3 = true;
                }
                if (this.c3) {
                    this.c3 = false;
                    String str3 = this.Z2;
                    this.Z2 = "";
                    g();
                    this.Z2 = str3;
                    this.c3 = true;
                }
                this.i3 = str2.endsWith(ExifInterface.X4);
                return;
            }
            throw new DocumentException(MessageLocalization.b("1.cannot.be.embedded.due.to.licensing.restrictions", this.z4 + this.F4));
        }
        throw new DocumentException(MessageLocalization.b("1.2.is.not.a.ttf.font.file", this.z4, this.F4));
    }

    private void c1() throws IOException {
        if (this.x4.get("GSUB") != null) {
            HashMap hashMap = new HashMap(this.M4.size());
            for (Integer next : this.M4.keySet()) {
                hashMap.put(Integer.valueOf(this.M4.get(next)[0]), Character.valueOf((char) next.intValue()));
            }
            GlyphSubstitutionTableReader glyphSubstitutionTableReader = new GlyphSubstitutionTableReader(this.y4, this.x4.get("GSUB")[0], hashMap, this.J4);
            try {
                glyphSubstitutionTableReader.r();
                Language a2 = glyphSubstitutionTableReader.a();
                this.c5 = a2;
                if (d5.contains(a2)) {
                    this.b5 = glyphSubstitutionTableReader.p();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    static String d1(int i2) {
        if (i2 < 65536) {
            return "<" + e1(i2) + ">";
        }
        int i3 = i2 - 65536;
        int i4 = (i3 % 1024) + Utf8.f31408e;
        return "[<" + e1((i3 / 1024) + 55296) + e1(i4) + ">]";
    }

    private static String e1(int i2) {
        String str = "0000" + Integer.toHexString(i2);
        return str.substring(str.length() - 4);
    }

    public int[] F0(int i2) {
        Character h2;
        Object obj;
        HashMap hashMap = this.N4;
        if (hashMap != null) {
            obj = hashMap.get(Integer.valueOf(i2));
        } else {
            boolean z = this.c3;
            HashMap hashMap2 = z ? this.L4 : this.M4;
            if (hashMap2 == null) {
                return null;
            }
            if (z) {
                int i3 = i2 & InputDeviceCompat.u;
                if (i3 != 0 && i3 != 61440) {
                    return null;
                }
                obj = hashMap2.get(Integer.valueOf(i2 & 255));
            } else {
                int[] iArr = (int[]) hashMap2.get(Integer.valueOf(i2));
                return (iArr != null || (h2 = ArabicLigaturizer.h((char) i2)) == null) ? iArr : (int[]) hashMap2.get(Integer.valueOf(h2.charValue()));
            }
        }
        return (int[]) obj;
    }

    /* access modifiers changed from: package-private */
    public void J0(byte[] bArr, boolean z) throws DocumentException, IOException {
        super.J0(bArr, z);
    }

    public PdfStream N() throws IOException, DocumentException {
        return this.A4 ? new BaseFont.StreamFont(M0(), "CIDFontType0C", this.b3) : super.N();
    }

    public int V0(int i2) {
        if (this.O4 == null) {
            int[] iArr = new int[this.P4];
            HashMap<Integer, int[]> hashMap = this.N4;
            if (hashMap == null && (hashMap = this.M4) == null) {
                hashMap = null;
            }
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    iArr[((int[]) next.getValue())[0]] = ((Integer) next.getKey()).intValue();
                }
            }
            this.O4 = iArr;
        }
        return this.O4[i2];
    }

    public int W(int i2) {
        String str;
        if (this.i3) {
            return 1000;
        }
        if (this.c3) {
            int i3 = 65280 & i2;
            if (i3 != 0 && i3 != 61440) {
                return 0;
            }
            i2 &= 255;
            str = null;
        } else {
            str = this.Z2;
        }
        return R(i2, str);
    }

    /* renamed from: W0 */
    public int compare(int[] iArr, int[] iArr2) {
        int i2 = iArr[0];
        int i3 = iArr2[0];
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public int X(String str) {
        int i2;
        if (this.i3) {
            return str.length() * 1000;
        }
        int i3 = 0;
        if (this.c3) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            i2 = 0;
            while (i3 < length) {
                char c2 = charArray[i3];
                char c3 = 65280 & c2;
                if (c3 == 0 || c3 == 61440) {
                    i2 += R(c2 & 255, (String) null);
                }
                i3++;
            }
        } else {
            int length2 = str.length();
            i2 = 0;
            while (i3 < length2) {
                if (Utilities.n(str, i3)) {
                    i2 += R(Utilities.f(str, i3), this.Z2);
                    i3++;
                } else {
                    i2 += R(str.charAt(i3), this.Z2);
                }
                i3++;
            }
        }
        return i2;
    }

    public PdfDictionary X0(PdfIndirectReference pdfIndirectReference, String str, Object[] objArr) {
        PdfName pdfName;
        PdfName pdfName2;
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.l8);
        if (this.A4) {
            pdfDictionary.V0(PdfName.Cf, PdfName.i5);
            pdfName = PdfName.l4;
            pdfName2 = new PdfName(str + this.R4 + "-" + this.Z2);
        } else {
            pdfDictionary.V0(PdfName.Cf, PdfName.j5);
            pdfName = PdfName.l4;
            pdfName2 = new PdfName(str + this.R4);
        }
        pdfDictionary.V0(pdfName, pdfName2);
        pdfDictionary.V0(PdfName.n8, pdfIndirectReference);
        if (!this.A4) {
            pdfDictionary.V0(PdfName.m5, PdfName.B9);
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.V0(PdfName.Qd, new PdfString("Adobe"));
        pdfDictionary2.V0(PdfName.kc, new PdfString("Identity"));
        pdfDictionary2.V0(PdfName.Ef, new PdfNumber(0));
        pdfDictionary.V0(PdfName.l5, pdfDictionary2);
        if (!this.i3) {
            pdfDictionary.V0(PdfName.b7, new PdfNumber(1000));
            StringBuffer stringBuffer = new StringBuffer("[");
            int i2 = -10;
            boolean z = true;
            for (int[] iArr : objArr) {
                if (iArr[1] != 1000) {
                    int i3 = iArr[0];
                    if (i3 == i2 + 1) {
                        stringBuffer.append(' ');
                        stringBuffer.append(iArr[1]);
                    } else {
                        if (!z) {
                            stringBuffer.append(']');
                        }
                        stringBuffer.append(i3);
                        stringBuffer.append('[');
                        stringBuffer.append(iArr[1]);
                        z = false;
                    }
                    i2 = i3;
                }
            }
            if (stringBuffer.length() > 1) {
                stringBuffer.append("]]");
                pdfDictionary.V0(PdfName.Dh, new PdfLiteral(stringBuffer.toString()));
            }
        }
        return pdfDictionary;
    }

    public PdfDictionary Y0(PdfIndirectReference pdfIndirectReference, String str, PdfIndirectReference pdfIndirectReference2) {
        PdfName pdfName;
        PdfName pdfName2;
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.l8);
        pdfDictionary.V0(PdfName.Cf, PdfName.Lg);
        if (this.A4) {
            pdfName = PdfName.l4;
            pdfName2 = new PdfName(str + this.R4 + "-" + this.Z2);
        } else {
            pdfName = PdfName.l4;
            pdfName2 = new PdfName(str + this.R4);
        }
        pdfDictionary.V0(pdfName, pdfName2);
        pdfDictionary.V0(PdfName.m7, new PdfName(this.Z2));
        pdfDictionary.V0(PdfName.v6, new PdfArray((PdfObject) pdfIndirectReference));
        if (pdfIndirectReference2 != null) {
            pdfDictionary.V0(PdfName.pg, pdfIndirectReference2);
        }
        return pdfDictionary;
    }

    /* access modifiers changed from: protected */
    public Map<String, Glyph> Z0() {
        return this.b5;
    }

    /* access modifiers changed from: package-private */
    public Language a1() {
        return this.c5;
    }

    public PdfStream b1(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("/CIDInit /ProcSet findresource begin\n12 dict begin\nbegincmap\n/CIDSystemInfo\n<< /Registry (TTX+0)\n/Ordering (T42UV)\n/Supplement 0\n>> def\n/CMapName /TTX+0 def\n/CMapType 2 def\n1 begincodespacerange\n<0000><FFFF>\nendcodespacerange\n");
        int i2 = 0;
        for (int i3 = 0; i3 < objArr.length; i3++) {
            if (i2 == 0) {
                if (i3 != 0) {
                    stringBuffer.append("endbfrange\n");
                }
                i2 = Math.min(100, objArr.length - i3);
                stringBuffer.append(i2);
                stringBuffer.append(" beginbfrange\n");
            }
            i2--;
            int[] iArr = objArr[i3];
            String d1 = d1(iArr[0]);
            stringBuffer.append(d1);
            stringBuffer.append(d1);
            stringBuffer.append(d1(iArr[2]));
            stringBuffer.append(10);
        }
        stringBuffer.append("endbfrange\nendcmap\nCMapName currentdict /CMap defineresource pop\nend end\n");
        PdfStream pdfStream = new PdfStream(PdfEncodings.c(stringBuffer.toString(), (String) null));
        pdfStream.i1(this.b3);
        return pdfStream;
    }

    public boolean c(int i2) {
        return F0(i2) != null;
    }

    /* access modifiers changed from: package-private */
    public byte[] d(int i2) {
        return null;
    }

    public byte[] e(String str) {
        return null;
    }

    public boolean l0(int i2, int i3) {
        int[] F0 = F0(i2);
        if (F0 == null) {
            return false;
        }
        F0[1] = i3;
        return true;
    }

    /* access modifiers changed from: package-private */
    public void t0(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        pdfWriter.N1().a(this, pdfIndirectReference, objArr, e5);
    }

    public int[] x(int i2) {
        int[] F0;
        if (this.K4 == null || (F0 = F0(i2)) == null) {
            return null;
        }
        return this.K4[F0[0]];
    }
}
