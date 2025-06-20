package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TextField extends BaseField {
    private String I;
    private String[] J;
    private String[] K;
    private ArrayList<Integer> L = new ArrayList<>();
    private int M;
    private int N = -1;
    private float O;
    private float P;
    private ArrayList<BaseFont> Q;
    private BaseFont R;

    public TextField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
    }

    private static void Q(Phrase phrase, float f2) {
        for (int i2 = 0; i2 < phrase.size(); i2++) {
            ((Chunk) phrase.get(i2)).k().y(f2);
        }
    }

    private static boolean R(String str) {
        if (!(str == null || str.length() == 0)) {
            char[] charArray = str.toCharArray();
            for (char c2 : charArray) {
                if (c2 >= 1424 && c2 < 1920) {
                    return true;
                }
            }
        }
        return false;
    }

    private Phrase S(String str, BaseFont baseFont, BaseColor baseColor, float f2) {
        ArrayList<BaseFont> arrayList;
        if (this.R == null && ((arrayList = this.Q) == null || arrayList.isEmpty())) {
            return new Phrase(new Chunk(str, new Font(baseFont, f2, 0, baseColor)));
        }
        FontSelector fontSelector = new FontSelector();
        fontSelector.a(new Font(baseFont, f2, 0, baseColor));
        BaseFont baseFont2 = this.R;
        if (baseFont2 != null) {
            fontSelector.a(new Font(baseFont2, f2, 0, baseColor));
        }
        if (this.Q != null) {
            for (int i2 = 0; i2 < this.Q.size(); i2++) {
                fontSelector.a(new Font(this.Q.get(i2), f2, 0, baseColor));
            }
        }
        return fontSelector.b(str);
    }

    private int g0() {
        Integer num;
        ArrayList<Integer> arrayList = this.L;
        if (arrayList == null || arrayList.size() == 0 || (num = this.L.get(0)) == null || this.J == null) {
            return 0;
        }
        int i2 = this.N;
        return i2 != -1 ? i2 : Math.max(0, Math.min(num.intValue(), this.J.length));
    }

    public static String j0(String str) {
        char[] cArr = new char[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            cArr[i2] = '*';
        }
        return new String(cArr);
    }

    public static String k0(String str) {
        if (str.indexOf(10) < 0 && str.indexOf(13) < 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(charArray.length);
        int i2 = 0;
        while (i2 < charArray.length) {
            char c2 = charArray[i2];
            if (c2 == 10) {
                stringBuffer.append(' ');
            } else if (c2 == 13) {
                stringBuffer.append(' ');
                if (i2 < charArray.length - 1) {
                    int i3 = i2 + 1;
                    if (charArray[i3] == 10) {
                        i2 = i3;
                    }
                }
            } else {
                stringBuffer.append(c2);
            }
            i2++;
        }
        return stringBuffer.toString();
    }

    private void u0(PdfFormField pdfFormField, String[][] strArr) {
        PdfArray pdfArray = new PdfArray();
        PdfArray pdfArray2 = new PdfArray();
        for (int i2 = 0; i2 < this.L.size(); i2++) {
            int intValue = this.L.get(i2).intValue();
            pdfArray.a0(new PdfNumber(intValue));
            if (strArr != null) {
                pdfArray2.a0(new PdfString(strArr[intValue][0]));
            } else {
                String[] strArr2 = this.J;
                if (strArr2 != null) {
                    pdfArray2.a0(new PdfString(strArr2[intValue]));
                }
            }
        }
        pdfFormField.V0(PdfName.kh, pdfArray2);
        pdfFormField.V0(PdfName.x9, pdfArray);
    }

    public void P(int i2) {
        if ((this.o & 2097152) != 0) {
            this.L.add(Integer.valueOf(i2));
        }
    }

    public PdfAppearance T() throws IOException, DocumentException {
        int i2;
        PdfAppearance f2 = f();
        f2.A3();
        String str = this.f25933j;
        if (str == null || str.length() == 0) {
            f2.D3();
            return f2;
        }
        int i3 = this.f25925b;
        boolean z = i3 == 2 || i3 == 3;
        float N2 = this.f25934k.N();
        float f3 = this.f25924a;
        float f4 = (N2 - (f3 * 2.0f)) - this.P;
        if (z) {
            f4 -= f3 * 2.0f;
            f3 *= 2.0f;
        }
        float max = Math.max(f3, 1.0f);
        float min = Math.min(f3, max);
        f2.a2();
        float f5 = min * 2.0f;
        f2.H1(min, min, this.f25934k.a0() - f5, this.f25934k.N() - f5);
        f2.b0();
        f2.x1();
        int i4 = this.o;
        String j0 = (i4 & 8192) != 0 ? j0(this.f25933j) : (i4 & 4096) == 0 ? k0(this.f25933j) : this.f25933j;
        BaseFont q = q();
        BaseColor baseColor = this.f25928e;
        if (baseColor == null) {
            baseColor = GrayColor.B;
        }
        int i5 = R(j0) ? 2 : 1;
        float f6 = this.f25930g;
        Phrase S = S(j0, q, baseColor, f6);
        if ((this.o & 4096) != 0) {
            float a0 = (this.f25934k.a0() - (max * 4.0f)) - this.O;
            float I2 = q.I(8, 1.0f) - q.I(6, 1.0f);
            ColumnText columnText = new ColumnText((PdfContentByte) null);
            if (f6 == 0.0f) {
                f6 = f4 / I2;
                if (f6 > 4.0f) {
                    if (f6 > 12.0f) {
                        f6 = 12.0f;
                    }
                    float max2 = Math.max((f6 - 4.0f) / 10.0f, 0.2f);
                    columnText.l0(0.0f, -f4, a0, 0.0f);
                    columnText.V(this.f25931h);
                    columnText.k0(i5);
                    while (f6 > 4.0f) {
                        columnText.t0(0.0f);
                        Q(S, f6);
                        columnText.r0(S);
                        columnText.h0(I2 * f6);
                        if ((columnText.J(true) & 2) == 0) {
                            break;
                        }
                        f6 -= max2;
                    }
                }
                if (f6 < 4.0f) {
                    f6 = 4.0f;
                }
            }
            Q(S, f6);
            columnText.X(f2);
            float f7 = I2 * f6;
            float I3 = (f4 + max) - q.I(8, f6);
            float f8 = max * 2.0f;
            columnText.l0(this.O + f8, -20000.0f, this.f25934k.a0() - f8, I3 + f7);
            columnText.h0(f7);
            columnText.V(this.f25931h);
            columnText.k0(i5);
            columnText.r0(S);
            columnText.I();
        } else {
            if (f6 == 0.0f) {
                float I4 = f4 / (q.I(7, 1.0f) - q.I(6, 1.0f));
                Q(S, 1.0f);
                float G = ColumnText.G(S, i5, 0);
                f6 = G == 0.0f ? I4 : Math.min(I4, ((this.f25934k.a0() - this.O) - (max * 4.0f)) / G);
                if (f6 < 4.0f) {
                    f6 = 4.0f;
                }
            }
            Q(S, f6);
            float N3 = (((this.f25934k.N() - f5) - q.I(1, f6)) / 2.0f) + min;
            if (N3 < min) {
                N3 = min;
            }
            if (N3 - min < (-q.I(3, f6))) {
                N3 = Math.min((-q.I(3, f6)) + min, Math.max(N3, (this.f25934k.N() - min) - q.I(1, f6)));
            }
            if ((this.o & 16777216) == 0 || (i2 = this.p) <= 0) {
                int i6 = this.f25931h;
                ColumnText.v0(f2, this.f25931h, S, i6 != 1 ? i6 != 2 ? this.O + (max * 2.0f) : (this.O + this.f25934k.a0()) - (max * 2.0f) : this.O + (this.f25934k.a0() / 2.0f), N3 - this.P, 0.0f, i5, 0);
            } else {
                int min2 = Math.min(i2, j0.length());
                int i7 = this.f25931h;
                int i8 = i7 == 2 ? this.p - min2 : i7 == 1 ? (this.p - min2) / 2 : 0;
                float a02 = (this.f25934k.a0() - this.O) / ((float) this.p);
                float f9 = (a02 / 2.0f) + (((float) i8) * a02);
                BaseColor baseColor2 = this.f25928e;
                if (baseColor2 == null) {
                    f2.u2(0.0f);
                } else {
                    f2.h2(baseColor2);
                }
                f2.R();
                for (int i9 = 0; i9 < S.size(); i9++) {
                    Chunk chunk = (Chunk) S.get(i9);
                    BaseFont c2 = chunk.k().c();
                    f2.s2(c2, f6);
                    StringBuffer a2 = chunk.a("");
                    int i10 = 0;
                    while (i10 < a2.length()) {
                        int i11 = i10 + 1;
                        String substring = a2.substring(i10, i11);
                        f2.e3((this.O + f9) - (c2.Z(substring, f6) / 2.0f), N3 - this.P);
                        f2.m3(substring);
                        f9 += a02;
                        i10 = i11;
                    }
                }
                f2.L0();
            }
        }
        f2.U1();
        f2.D3();
        return f2;
    }

    public String[] U() {
        return this.K;
    }

    /* access modifiers changed from: protected */
    public PdfFormField V(boolean z) throws IOException, DocumentException {
        String[][] strArr;
        PdfFormField pdfFormField;
        PdfAppearance pdfAppearance;
        int i2;
        String str;
        PdfFormField R2;
        this.o &= -16781313;
        String[] strArr2 = this.J;
        if (strArr2 == null) {
            strArr2 = new String[0];
        }
        int g0 = g0();
        if (strArr2.length > 0 && g0 >= 0) {
            this.f25933j = strArr2[g0];
        }
        if (this.f25933j == null) {
            this.f25933j = "";
        }
        if (this.K == null) {
            PdfWriter pdfWriter = this.f25932i;
            if (z) {
                pdfFormField = PdfFormField.T2(pdfWriter, strArr2, g0);
            } else {
                pdfFormField = PdfFormField.Q2(pdfWriter, (262144 & this.o) != 0, strArr2, g0);
            }
            strArr = null;
        } else {
            int length = strArr2.length;
            int[] iArr = new int[2];
            iArr[1] = 2;
            iArr[0] = length;
            String[][] strArr3 = (String[][]) Array.newInstance(String.class, iArr);
            for (int i3 = 0; i3 < strArr3.length; i3++) {
                String[] strArr4 = strArr3[i3];
                String str2 = strArr2[i3];
                strArr4[1] = str2;
                strArr4[0] = str2;
            }
            int min = Math.min(strArr2.length, this.K.length);
            for (int i4 = 0; i4 < min; i4++) {
                String str3 = this.K[i4];
                if (str3 != null) {
                    strArr3[i4][0] = str3;
                }
            }
            if (z) {
                R2 = PdfFormField.U2(this.f25932i, strArr3, g0);
            } else {
                R2 = PdfFormField.R2(this.f25932i, (262144 & this.o) != 0, strArr3, g0);
            }
            PdfFormField pdfFormField2 = R2;
            strArr = strArr3;
            pdfFormField = pdfFormField2;
        }
        pdfFormField.r3(this.f25934k, PdfAnnotation.A3);
        int i5 = this.f25935l;
        if (i5 != 0) {
            pdfFormField.A2(i5);
        }
        String str4 = this.f25937n;
        if (str4 != null) {
            pdfFormField.j3(str4);
            if (strArr2.length > 0) {
                int size = this.L.size();
                if (strArr != null) {
                    if (size < 2) {
                        pdfFormField.q3(strArr[g0][0]);
                        str = strArr[g0][0];
                    } else {
                        u0(pdfFormField, strArr);
                    }
                } else if (size < 2) {
                    pdfFormField.q3(this.f25933j);
                    str = this.f25933j;
                } else {
                    u0(pdfFormField, (String[][]) null);
                }
                pdfFormField.h3(str);
            }
            if ((this.o & 1) != 0) {
                pdfFormField.i3(1);
            }
            if ((this.o & 2) != 0) {
                pdfFormField.i3(2);
            }
            if ((this.o & 4194304) != 0) {
                pdfFormField.i3(4194304);
            }
            if ((this.o & 2097152) != 0) {
                pdfFormField.i3(2097152);
            }
        }
        pdfFormField.k2(new PdfBorderDictionary(this.f25924a, this.f25925b, new PdfDashPattern(3.0f)));
        if (z) {
            pdfAppearance = c0();
            int i6 = this.M;
            if (i6 > 0) {
                pdfFormField.V0(PdfName.bg, new PdfNumber(i6));
            }
        } else {
            pdfAppearance = T();
        }
        pdfFormField.c2(PdfAnnotation.O3, pdfAppearance);
        PdfAppearance pdfAppearance2 = (PdfAppearance) pdfAppearance.U0();
        pdfAppearance2.s2(q(), this.f25930g);
        BaseColor baseColor = this.f25928e;
        if (baseColor == null) {
            pdfAppearance2.u2(0.0f);
        } else {
            pdfAppearance2.h2(baseColor);
        }
        pdfFormField.m2(pdfAppearance2);
        BaseColor baseColor2 = this.f25926c;
        if (baseColor2 != null) {
            pdfFormField.t2(baseColor2);
        }
        BaseColor baseColor3 = this.f25927d;
        if (baseColor3 != null) {
            pdfFormField.s2(baseColor3);
        }
        int i7 = this.f25936m;
        if (i7 != 1) {
            if (i7 != 2) {
                i2 = i7 != 3 ? 4 : 36;
            }
            return pdfFormField;
        }
        i2 = 6;
        pdfFormField.n2(i2);
        return pdfFormField;
    }

    public int W() {
        return g0();
    }

    public ArrayList<Integer> X() {
        return this.L;
    }

    public String[] Y() {
        return this.J;
    }

    public PdfFormField Z() throws IOException, DocumentException {
        return V(false);
    }

    public String a0() {
        return this.I;
    }

    public BaseFont b0() {
        return this.R;
    }

    /* access modifiers changed from: package-private */
    public PdfAppearance c0() throws IOException, DocumentException {
        PdfAppearance f2 = f();
        String[] strArr = this.J;
        if (!(strArr == null || strArr.length == 0)) {
            f2.A3();
            int g0 = g0();
            BaseFont q = q();
            float f3 = this.f25930g;
            float f4 = f3 == 0.0f ? 12.0f : f3;
            int i2 = this.f25925b;
            boolean z = i2 == 2 || i2 == 3;
            float N2 = this.f25934k.N();
            float f5 = this.f25924a;
            float f6 = N2 - (f5 * 2.0f);
            if (z) {
                f6 -= f5 * 2.0f;
                f5 *= 2.0f;
            }
            float I2 = q.I(8, f4) - q.I(6, f4);
            int i3 = ((int) (f6 / I2)) + 1 + g0;
            String[] strArr2 = this.J;
            if (i3 > strArr2.length) {
                i3 = strArr2.length;
            }
            int i4 = i3;
            this.M = g0;
            f2.a2();
            float f7 = f5 * 2.0f;
            f2.H1(f5, f5, this.f25934k.a0() - f7, this.f25934k.N() - f7);
            f2.b0();
            f2.x1();
            BaseColor baseColor = this.f25928e;
            if (baseColor == null) {
                baseColor = GrayColor.B;
            }
            BaseColor baseColor2 = baseColor;
            f2.h2(new BaseColor(10, 36, 106));
            for (int i5 = 0; i5 < this.L.size(); i5++) {
                int intValue = this.L.get(i5).intValue();
                if (intValue >= g0 && intValue <= i4) {
                    f2.H1(f5, (f5 + f6) - (((float) ((intValue - g0) + 1)) * I2), this.f25934k.a0() - f7, I2);
                    f2.Q0();
                }
            }
            int i6 = g0;
            float I3 = (f5 + f6) - q.I(8, f4);
            while (i6 < i4) {
                String str = this.J[i6];
                ColumnText.v0(f2, 0, S(k0(str), q, this.L.contains(Integer.valueOf(i6)) ? GrayColor.C : baseColor2, f4), f7, I3, 0.0f, R(str) ? 2 : 1, 0);
                i6++;
                I3 -= I2;
            }
            f2.U1();
            f2.D3();
        }
        return f2;
    }

    public PdfFormField d0() throws IOException, DocumentException {
        return V(true);
    }

    public ArrayList<BaseFont> e0() {
        return this.Q;
    }

    public PdfFormField f0() throws IOException, DocumentException {
        int i2;
        int i3 = this.p;
        if (i3 <= 0) {
            this.o &= -16777217;
        }
        int i4 = this.o;
        if ((i4 & 16777216) != 0) {
            this.o = i4 & -4097;
        }
        PdfFormField Y2 = PdfFormField.Y2(this.f25932i, false, false, i3);
        Y2.r3(this.f25934k, PdfAnnotation.A3);
        int i5 = this.f25931h;
        if (i5 == 1) {
            Y2.l3(1);
        } else if (i5 == 2) {
            Y2.l3(2);
        }
        int i6 = this.f25935l;
        if (i6 != 0) {
            Y2.A2(i6);
        }
        String str = this.f25937n;
        if (str != null) {
            Y2.j3(str);
            if (!"".equals(this.f25933j)) {
                Y2.q3(this.f25933j);
            }
            String str2 = this.I;
            if (str2 != null) {
                Y2.h3(str2);
            }
            if ((this.o & 1) != 0) {
                Y2.i3(1);
            }
            if ((this.o & 2) != 0) {
                Y2.i3(2);
            }
            if ((this.o & 4096) != 0) {
                Y2.i3(4096);
            }
            if ((this.o & 8388608) != 0) {
                Y2.i3(8388608);
            }
            if ((this.o & 8192) != 0) {
                Y2.i3(8192);
            }
            if ((this.o & 1048576) != 0) {
                Y2.i3(1048576);
            }
            if ((this.o & 4194304) != 0) {
                Y2.i3(4194304);
            }
            if ((this.o & 16777216) != 0) {
                Y2.i3(16777216);
            }
        }
        Y2.k2(new PdfBorderDictionary(this.f25924a, this.f25925b, new PdfDashPattern(3.0f)));
        PdfAppearance T = T();
        Y2.c2(PdfAnnotation.O3, T);
        PdfAppearance pdfAppearance = (PdfAppearance) T.U0();
        pdfAppearance.s2(q(), this.f25930g);
        BaseColor baseColor = this.f25928e;
        if (baseColor == null) {
            pdfAppearance.u2(0.0f);
        } else {
            pdfAppearance.h2(baseColor);
        }
        Y2.m2(pdfAppearance);
        BaseColor baseColor2 = this.f25926c;
        if (baseColor2 != null) {
            Y2.t2(baseColor2);
        }
        BaseColor baseColor3 = this.f25927d;
        if (baseColor3 != null) {
            Y2.s2(baseColor3);
        }
        int i7 = this.f25936m;
        if (i7 != 1) {
            if (i7 != 2) {
                i2 = i7 != 3 ? 4 : 36;
            }
            return Y2;
        }
        i2 = 6;
        Y2.n2(i2);
        return Y2;
    }

    /* access modifiers changed from: package-private */
    public int h0() {
        return this.M;
    }

    public int i0() {
        return this.N;
    }

    public void l0(String[] strArr) {
        this.K = strArr;
    }

    public void m0(int i2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.L = arrayList;
        arrayList.add(Integer.valueOf(i2));
    }

    public void n0(ArrayList<Integer> arrayList) {
        if (arrayList != null) {
            ArrayList<Integer> arrayList2 = new ArrayList<>(arrayList);
            this.L = arrayList2;
            if (arrayList2.size() > 1 && (this.o & 2097152) == 0) {
                while (this.L.size() > 1) {
                    this.L.remove(1);
                }
                return;
            }
            return;
        }
        this.L.clear();
    }

    public void o0(String[] strArr) {
        this.J = strArr;
    }

    public void p0(String str) {
        this.I = str;
    }

    public void q0(BaseFont baseFont) {
        this.R = baseFont;
    }

    public void r0(float f2, float f3) {
        this.O = f2;
        this.P = f3;
    }

    public void s0(ArrayList<BaseFont> arrayList) {
        this.Q = arrayList;
    }

    public void t0(int i2) {
        String[] strArr;
        if (i2 >= 0 && (strArr = this.J) != null && i2 < strArr.length) {
            this.N = i2;
        }
    }
}
