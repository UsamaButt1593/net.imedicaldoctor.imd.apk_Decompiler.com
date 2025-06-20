package com.itextpdf.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCache;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidByte;
import com.itextpdf.text.pdf.fonts.cmaps.CMapCidUni;
import com.itextpdf.text.pdf.fonts.cmaps.CMapUniCid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

class CJKFont extends BaseFont {
    static final String H4 = "UnicodeBigUnmarked";
    private static final int I4 = 0;
    private static final int J4 = 1;
    private static final int K4 = 2;
    private static final int L4 = 880;
    static Properties M4 = new Properties();
    static Properties N4 = new Properties();
    private static final HashMap<String, HashMap<String, Object>> O4 = new HashMap<>();
    private static boolean P4 = false;
    public static final String Q4 = "com/itextpdf/text/pdf/fonts/cmaps/";
    private static final HashMap<String, Set<String>> R4 = new HashMap<>();
    private String A4;
    private String B4 = "";
    private String C4;
    private boolean D4 = false;
    private IntHashtable E4;
    private IntHashtable F4;
    private HashMap<String, Object> G4;
    private CMapCidByte w4;
    private CMapUniCid x4;
    private CMapCidUni y4;
    private String z4;

    CJKFont(String str, String str2, boolean z) throws DocumentException {
        H0();
        this.X = 2;
        String w = BaseFont.w(str);
        if (E0(w, str2)) {
            if (w.length() < str.length()) {
                this.B4 = str.substring(w.length());
                str = w;
            }
            this.A4 = str;
            this.Z2 = H4;
            this.i3 = str2.endsWith(ExifInterface.X4);
            this.C4 = str2;
            if (str2.equals(BaseFont.a4) || str2.equals(BaseFont.b4)) {
                this.D4 = true;
            }
            G0();
            return;
        }
        throw new DocumentException(MessageLocalization.b("font.1.with.2.encoding.is.not.a.cjk.font", str, str2));
    }

    private float A0(String str) {
        return (float) Integer.parseInt((String) this.G4.get(str));
    }

    private PdfDictionary B0(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.l8);
        pdfDictionary.V0(PdfName.Cf, PdfName.Lg);
        String str = this.A4;
        if (this.B4.length() > 0) {
            str = str + "-" + this.B4.substring(1);
        }
        pdfDictionary.V0(PdfName.l4, new PdfName(str + "-" + this.C4));
        pdfDictionary.V0(PdfName.m7, new PdfName(this.C4));
        pdfDictionary.V0(PdfName.v6, new PdfArray((PdfObject) pdfIndirectReference));
        return pdfDictionary;
    }

    private PdfDictionary C0() {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.n8);
        pdfDictionary.V0(PdfName.Y3, new PdfLiteral((String) this.G4.get("Ascent")));
        pdfDictionary.V0(PdfName.R4, new PdfLiteral((String) this.G4.get("CapHeight")));
        pdfDictionary.V0(PdfName.w6, new PdfLiteral((String) this.G4.get("Descent")));
        pdfDictionary.V0(PdfName.g8, new PdfLiteral((String) this.G4.get("Flags")));
        pdfDictionary.V0(PdfName.m8, new PdfLiteral((String) this.G4.get("FontBBox")));
        PdfName pdfName = PdfName.t8;
        pdfDictionary.V0(pdfName, new PdfName(this.A4 + this.B4));
        pdfDictionary.V0(PdfName.X9, new PdfLiteral((String) this.G4.get("ItalicAngle")));
        pdfDictionary.V0(PdfName.qf, new PdfLiteral((String) this.G4.get("StemV")));
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.V0(PdfName.Bc, new PdfString((String) this.G4.get("Panose"), (String) null));
        pdfDictionary.V0(PdfName.yf, pdfDictionary2);
        return pdfDictionary;
    }

    public static boolean E0(String str, String str2) {
        H0();
        HashMap<String, Set<String>> hashMap = R4;
        if (!hashMap.containsKey("fonts") || !hashMap.get("fonts").contains(str)) {
            return false;
        }
        if (str2.equals(BaseFont.a4) || str2.equals(BaseFont.b4)) {
            return true;
        }
        Set set = hashMap.get((String) O4.get(str).get("Registry"));
        return set != null && set.contains(str2);
    }

    private void G0() throws DocumentException {
        try {
            HashMap<String, Object> hashMap = O4.get(this.A4);
            this.G4 = hashMap;
            this.F4 = (IntHashtable) hashMap.get(ExifInterface.T4);
            this.E4 = (IntHashtable) this.G4.get("W2");
            this.z4 = "";
            HashMap<String, Set<String>> hashMap2 = R4;
            Iterator it2 = hashMap2.get(((String) this.G4.get("Registry")) + "_Uni").iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String str = (String) it2.next();
                this.z4 = str;
                if (!str.endsWith(ExifInterface.X4) || !this.i3) {
                    if (!str.endsWith(ExifInterface.X4) && !this.i3) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (this.D4) {
                this.y4 = CMapCache.c(this.z4);
                return;
            }
            this.x4 = CMapCache.d(this.z4);
            this.w4 = CMapCache.b(this.C4);
        } catch (Exception e2) {
            throw new DocumentException(e2);
        }
    }

    private static void H0() {
        if (!P4) {
            synchronized (O4) {
                if (!P4) {
                    try {
                        I0();
                        for (String str : R4.get("fonts")) {
                            O4.put(str, J0(str));
                        }
                    } catch (Exception unused) {
                    }
                    P4 = true;
                }
            }
        }
    }

    private static void I0() throws IOException {
        InputStream b2 = StreamUtil.b("com/itextpdf/text/pdf/fonts/cmaps/cjk_registry.properties");
        Properties properties = new Properties();
        properties.load(b2);
        b2.close();
        for (String str : properties.keySet()) {
            String[] split = properties.getProperty(str).split(StringUtils.SPACE);
            HashSet hashSet = new HashSet();
            for (String str2 : split) {
                if (str2.length() > 0) {
                    hashSet.add(str2);
                }
            }
            R4.put(str, hashSet);
        }
    }

    private static HashMap<String, Object> J0(String str) throws IOException {
        InputStream b2 = StreamUtil.b(Q4 + (str + ".properties"));
        Properties properties = new Properties();
        properties.load(b2);
        b2.close();
        IntHashtable x0 = x0(properties.getProperty(ExifInterface.T4));
        properties.remove(ExifInterface.T4);
        IntHashtable x02 = x0(properties.getProperty("W2"));
        properties.remove("W2");
        HashMap<String, Object> hashMap = new HashMap<>();
        Enumeration keys = properties.keys();
        while (keys.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            hashMap.put(str2, properties.getProperty(str2));
        }
        hashMap.put(ExifInterface.T4, x0);
        hashMap.put("W2", x02);
        return hashMap;
    }

    public static String u0(String str) {
        H0();
        for (Map.Entry next : R4.entrySet()) {
            if (((Set) next.getValue()).contains(str)) {
                String str2 = (String) next.getKey();
                for (Map.Entry next2 : O4.entrySet()) {
                    if (str2.equals(((HashMap) next2.getValue()).get("Registry"))) {
                        return (String) next2.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    static String v0(int[] iArr, IntHashtable intHashtable) {
        if (iArr.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < iArr.length) {
            i3 = iArr[i2];
            i4 = intHashtable.e(i3);
            i2++;
            if (i4 != 0) {
                break;
            }
        }
        if (i4 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i3);
        char c2 = 0;
        while (i2 < iArr.length) {
            int i5 = iArr[i2];
            int e2 = intHashtable.e(i5);
            if (e2 != 0) {
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 == 2 && !(i5 == i3 + 1 && e2 == i4)) {
                            sb.append(' ');
                            sb.append(i3);
                            sb.append(' ');
                            sb.append(i4);
                            sb.append(' ');
                        }
                        i3 = i5;
                        i4 = e2;
                    } else {
                        int i6 = i3 + 1;
                        if (i5 == i6 && e2 == i4) {
                            sb.append(']');
                            sb.append(i3);
                        } else {
                            sb.append(' ');
                            sb.append(i4);
                            if (i5 != i6) {
                                sb.append(']');
                            }
                            i3 = i5;
                            i4 = e2;
                        }
                    }
                    sb.append(i5);
                    c2 = 0;
                    i3 = i5;
                    i4 = e2;
                } else {
                    int i7 = i3 + 1;
                    if (!(i5 == i7 && e2 == i4)) {
                        sb.append('[');
                        sb.append(i4);
                        if (i5 == i7) {
                            c2 = 1;
                        } else {
                            sb.append(']');
                            sb.append(i5);
                        }
                        i3 = i5;
                        i4 = e2;
                    }
                }
                c2 = 2;
                i3 = i5;
                i4 = e2;
            }
            i2++;
        }
        if (c2 == 0) {
            sb.append('[');
        } else if (c2 != 1) {
            if (c2 == 2) {
                sb.append(' ');
                sb.append(i3);
                sb.append(' ');
                sb.append(i4);
                sb.append(']');
            }
            return sb.toString();
        } else {
            sb.append(' ');
        }
        sb.append(i4);
        sb.append("]]");
        return sb.toString();
    }

    static String w0(int[] iArr, IntHashtable intHashtable, IntHashtable intHashtable2) {
        int[] iArr2 = iArr;
        IntHashtable intHashtable3 = intHashtable;
        IntHashtable intHashtable4 = intHashtable2;
        if (iArr2.length == 0) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i2 >= iArr2.length) {
                break;
            }
            i5 = iArr2[i2];
            i3 = intHashtable3.e(i5);
            if (i3 != 0) {
                i2++;
                break;
            }
            i4 = intHashtable4.e(i5);
            i2++;
        }
        if (i3 == 0) {
            return null;
        }
        if (i4 == 0) {
            i4 = 1000;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(i5);
        char c2 = 0;
        while (i2 < iArr2.length) {
            int i6 = iArr2[i2];
            int e2 = intHashtable3.e(i6);
            if (e2 != 0) {
                int e3 = intHashtable4.e(i5);
                int i7 = e3 == 0 ? 1000 : e3;
                if (c2 != 0) {
                    if (c2 == 2 && !(i6 == i5 + 1 && e2 == i3 && i7 == i4)) {
                        sb.append(' ');
                        sb.append(i5);
                        sb.append(' ');
                        sb.append(-i3);
                        sb.append(' ');
                        sb.append(i4 / 2);
                        sb.append(' ');
                        sb.append(L4);
                        sb.append(' ');
                        sb.append(i6);
                        c2 = 0;
                    }
                } else if (i6 == i5 + 1 && e2 == i3 && i7 == i4) {
                    c2 = 2;
                } else {
                    sb.append(' ');
                    sb.append(i5);
                    sb.append(' ');
                    sb.append(-i3);
                    sb.append(' ');
                    sb.append(i4 / 2);
                    sb.append(' ');
                    sb.append(L4);
                    sb.append(' ');
                    sb.append(i6);
                }
                i4 = i7;
                i5 = i6;
                i3 = e2;
            }
            i2++;
        }
        sb.append(' ');
        sb.append(i5);
        sb.append(' ');
        sb.append(-i3);
        sb.append(' ');
        sb.append(i4 / 2);
        sb.append(' ');
        sb.append(L4);
        sb.append(" ]");
        return sb.toString();
    }

    static IntHashtable x0(String str) {
        IntHashtable intHashtable = new IntHashtable();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while (stringTokenizer.hasMoreTokens()) {
            intHashtable.l(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
        }
        return intHashtable;
    }

    private float y0(int i2) {
        StringTokenizer stringTokenizer = new StringTokenizer((String) this.G4.get("FontBBox"), " []\r\n\t\f");
        String nextToken = stringTokenizer.nextToken();
        for (int i3 = 0; i3 < i2; i3++) {
            nextToken = stringTokenizer.nextToken();
        }
        return (float) Integer.parseInt(nextToken);
    }

    private PdfDictionary z0(PdfIndirectReference pdfIndirectReference, IntHashtable intHashtable) {
        PdfName pdfName;
        PdfNumber pdfNumber;
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.l8);
        pdfDictionary.V0(PdfName.Cf, PdfName.i5);
        PdfName pdfName2 = PdfName.l4;
        pdfDictionary.V0(pdfName2, new PdfName(this.A4 + this.B4));
        pdfDictionary.V0(PdfName.n8, pdfIndirectReference);
        int[] p = intHashtable.p();
        String v0 = v0(p, this.F4);
        if (v0 != null) {
            pdfDictionary.V0(PdfName.Dh, new PdfLiteral(v0));
        }
        if (this.i3) {
            String w0 = w0(p, this.E4, this.F4);
            if (w0 != null) {
                pdfDictionary.V0(PdfName.Eh, new PdfLiteral(w0));
            }
        } else {
            pdfDictionary.V0(PdfName.b7, new PdfNumber(1000));
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        if (this.D4) {
            pdfDictionary2.V0(PdfName.Qd, new PdfString(this.y4.h(), (String) null));
            pdfDictionary2.V0(PdfName.kc, new PdfString(this.y4.g(), (String) null));
            pdfName = PdfName.Ef;
            pdfNumber = new PdfNumber(this.y4.i());
        } else {
            pdfDictionary2.V0(PdfName.Qd, new PdfString(this.w4.h(), (String) null));
            pdfDictionary2.V0(PdfName.kc, new PdfString(this.w4.g(), (String) null));
            pdfName = PdfName.Ef;
            pdfNumber = new PdfNumber(this.w4.i());
        }
        pdfDictionary2.V0(pdfName, pdfNumber);
        pdfDictionary.V0(PdfName.l5, pdfDictionary2);
        return pdfDictionary;
    }

    /* access modifiers changed from: package-private */
    public String D0() {
        return this.z4;
    }

    public boolean F0() {
        return this.D4;
    }

    public String[][] H() {
        return L();
    }

    public float I(int i2, float f2) {
        float y0;
        int i3;
        switch (i2) {
            case 1:
            case 9:
                return (A0("Ascent") * f2) / 1000.0f;
            case 2:
                return (A0("CapHeight") * f2) / 1000.0f;
            case 3:
            case 10:
                return (A0("Descent") * f2) / 1000.0f;
            case 4:
                return A0("ItalicAngle");
            case 5:
                y0 = y0(0);
                break;
            case 6:
                i3 = 1;
                break;
            case 7:
                y0 = y0(2);
                break;
            case 8:
                i3 = 3;
                break;
            case 12:
                y0 = y0(2) - y0(0);
                break;
            default:
                return 0.0f;
        }
        y0 = y0(i3);
        return (f2 * y0) / 1000.0f;
    }

    public String[][] L() {
        return new String[][]{new String[]{"", "", "", this.A4}};
    }

    public PdfStream N() {
        return null;
    }

    public int O(int i2, int i3) {
        return 0;
    }

    public String P() {
        return this.A4;
    }

    /* access modifiers changed from: protected */
    public int[] Q(int i2, String str) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int R(int i2, String str) {
        return 0;
    }

    public int V(int i2) {
        if (!this.D4) {
            return i2;
        }
        if (i2 == 32767) {
            return 10;
        }
        return this.y4.o(i2);
    }

    public int W(int i2) {
        if (!this.D4) {
            i2 = this.x4.p(i2);
        }
        int e2 = (this.i3 ? this.E4 : this.F4).e(i2);
        if (e2 > 0) {
            return e2;
        }
        return 1000;
    }

    public int X(String str) {
        int i2;
        int i3;
        int i4 = 0;
        if (this.D4) {
            i2 = 0;
            while (i4 < str.length()) {
                i2 += W(str.charAt(i4));
                i4++;
            }
        } else {
            int i5 = 0;
            while (i4 < str.length()) {
                if (Utilities.n(str, i4)) {
                    i3 = Utilities.f(str, i4);
                    i4++;
                } else {
                    i3 = str.charAt(i4);
                }
                i5 = i2 + W(i3);
                i4++;
            }
        }
        return i2;
    }

    public boolean c(int i2) {
        return this.D4 || this.w4.o(this.x4.p(i2)).length > 0;
    }

    public boolean c0() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public byte[] d(int i2) {
        return this.D4 ? super.d(i2) : this.w4.o(this.x4.p(i2));
    }

    public byte[] e(String str) {
        int i2;
        if (this.D4) {
            return super.e(str);
        }
        try {
            int i3 = 0;
            if (str.length() == 1) {
                return d(str.charAt(0));
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (i3 < str.length()) {
                if (Utilities.n(str, i3)) {
                    i2 = Utilities.f(str, i3);
                    i3++;
                } else {
                    i2 = str.charAt(i3);
                }
                byteArrayOutputStream.write(d(i2));
                i3++;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public boolean l0(int i2, int i3) {
        return false;
    }

    public boolean q0(int i2, int i3, int i4) {
        return false;
    }

    public void r0(String str) {
        this.A4 = str;
    }

    public String[][] s() {
        return new String[][]{new String[]{"4", "", "", "", this.A4}};
    }

    /* access modifiers changed from: package-private */
    public void t0(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        IntHashtable intHashtable = objArr[0];
        PdfDictionary C0 = C0();
        PdfIndirectReference a2 = C0 != null ? pdfWriter.v0(C0).a() : null;
        PdfDictionary z0 = z0(a2, intHashtable);
        if (z0 != null) {
            a2 = pdfWriter.v0(z0).a();
        }
        pdfWriter.y0(B0(a2), pdfIndirectReference);
    }

    public int[] x(int i2) {
        return null;
    }

    public int y(int i2) {
        return this.D4 ? i2 : this.x4.p(i2);
    }
}
