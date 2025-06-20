package com.itextpdf.text.pdf;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import java.io.IOException;

public class RadioCheckField extends BaseField {
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;
    public static final int P = 5;
    public static final int Q = 6;
    protected static String[] R = {"4", CmcdData.Factory.q, "8", "u", "n", "H"};
    protected int I;
    private String J;
    private boolean K;

    public RadioCheckField(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2) {
        super(pdfWriter, rectangle, str);
        a0(str2);
        Y(2);
    }

    public PdfAppearance P(boolean z, boolean z2) throws IOException, DocumentException {
        float f2;
        if (z && this.I == 2) {
            return Q(z2);
        }
        PdfAppearance f3 = f();
        if (!z2) {
            return f3;
        }
        BaseFont q = q();
        int i2 = this.f25925b;
        boolean z3 = i2 == 2 || i2 == 3;
        float N2 = this.f25934k.N();
        float f4 = this.f25924a;
        float f5 = N2 - (f4 * 2.0f);
        if (z3) {
            f5 -= f4 * 2.0f;
            f2 = f4 * 2.0f;
        } else {
            f2 = f4;
        }
        if (z3) {
            f4 *= 2.0f;
        }
        float min = Math.min(f2, Math.max(f4, 1.0f));
        float f6 = min * 2.0f;
        float a0 = this.f25934k.a0() - f6;
        float N3 = this.f25934k.N() - f6;
        float f7 = this.f25930g;
        if (f7 == 0.0f) {
            float Z = q.Z(this.f25933j, 1.0f);
            f7 = Math.min(Z == 0.0f ? 12.0f : a0 / Z, f5 / q.I(1, 1.0f));
        }
        f3.a2();
        f3.H1(min, min, a0, N3);
        f3.b0();
        f3.x1();
        BaseColor baseColor = this.f25928e;
        if (baseColor == null) {
            f3.P1();
        } else {
            f3.h2(baseColor);
        }
        f3.R();
        f3.s2(q, f7);
        f3.e3((this.f25934k.a0() - q.Z(this.f25933j, f7)) / 2.0f, (this.f25934k.N() - q.v(this.f25933j, f7)) / 2.0f);
        f3.m3(this.f25933j);
        f3.L0();
        f3.U1();
        return f3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfAppearance Q(boolean r11) {
        /*
            r10 = this;
            com.itextpdf.text.pdf.PdfWriter r0 = r10.f25932i
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r1 = r1.a0()
            com.itextpdf.text.Rectangle r2 = r10.f25934k
            float r2 = r2.N()
            com.itextpdf.text.pdf.PdfAppearance r0 = com.itextpdf.text.pdf.PdfAppearance.a4(r0, r1, r2)
            int r1 = r10.f25935l
            r2 = 90
            if (r1 == r2) goto L_0x0046
            r2 = 180(0xb4, float:2.52E-43)
            if (r1 == r2) goto L_0x0033
            r2 = 270(0x10e, float:3.78E-43)
            if (r1 == r2) goto L_0x0021
            goto L_0x0054
        L_0x0021:
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r9 = r1.a0()
            r4 = 0
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 0
        L_0x002e:
            r3 = r0
            r3.X3(r4, r5, r6, r7, r8, r9)
            goto L_0x0054
        L_0x0033:
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r8 = r1.a0()
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r9 = r1.N()
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 0
            r6 = 0
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x002e
        L_0x0046:
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r8 = r1.N()
            r9 = 0
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = 0
            goto L_0x002e
        L_0x0054:
            com.itextpdf.text.Rectangle r1 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r2 = r0.F3()
            r1.<init>((com.itextpdf.text.Rectangle) r2)
            float r2 = r1.a0()
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            float r4 = r1.N()
            float r4 = r4 / r3
            float r5 = r1.a0()
            float r1 = r1.N()
            float r1 = java.lang.Math.min(r5, r1)
            float r5 = r10.f25924a
            float r1 = r1 - r5
            float r1 = r1 / r3
            r5 = 0
            int r6 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r6 > 0) goto L_0x007f
            return r0
        L_0x007f:
            com.itextpdf.text.BaseColor r6 = r10.f25927d
            if (r6 == 0) goto L_0x0090
            r0.h2(r6)
            float r6 = r10.f25924a
            float r6 = r6 / r3
            float r6 = r6 + r1
            r0.a0(r2, r4, r6)
            r0.Q0()
        L_0x0090:
            float r6 = r10.f25924a
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a8
            com.itextpdf.text.BaseColor r5 = r10.f25926c
            if (r5 == 0) goto L_0x00a8
            r0.J2(r6)
            com.itextpdf.text.BaseColor r5 = r10.f25926c
            r0.l2(r5)
            r0.a0(r2, r4, r1)
            r0.v3()
        L_0x00a8:
            if (r11 == 0) goto L_0x00bc
            com.itextpdf.text.BaseColor r11 = r10.f25928e
            if (r11 != 0) goto L_0x00b2
            r0.P1()
            goto L_0x00b5
        L_0x00b2:
            r0.h2(r11)
        L_0x00b5:
            float r1 = r1 / r3
            r0.a0(r2, r4, r1)
            r0.Q0()
        L_0x00bc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.RadioCheckField.Q(boolean):com.itextpdf.text.pdf.PdfAppearance");
    }

    public PdfFormField R() throws IOException, DocumentException {
        return T(false);
    }

    public int S() {
        return this.I;
    }

    /* access modifiers changed from: protected */
    public PdfFormField T(boolean z) throws IOException, DocumentException {
        int i2;
        PdfWriter pdfWriter = this.f25932i;
        PdfFormField S2 = z ? PdfFormField.S2(pdfWriter) : PdfFormField.N2(pdfWriter);
        S2.r3(this.f25934k, PdfAnnotation.A3);
        String str = "Off";
        if (!z) {
            S2.j3(this.f25937n);
            if ((this.o & 1) != 0) {
                S2.i3(1);
            }
            if ((this.o & 2) != 0) {
                S2.i3(2);
            }
            S2.p3(this.K ? this.J : str);
            Y(this.I);
        }
        String str2 = this.f25933j;
        if (str2 != null) {
            S2.v2(str2);
        }
        int i3 = this.f25935l;
        if (i3 != 0) {
            S2.A2(i3);
        }
        S2.k2(new PdfBorderDictionary(this.f25924a, this.f25925b, new PdfDashPattern(3.0f)));
        PdfAppearance P2 = P(z, true);
        PdfAppearance P3 = P(z, false);
        PdfName pdfName = PdfAnnotation.O3;
        S2.h2(pdfName, this.J, P2);
        S2.h2(pdfName, str, P3);
        if (this.K) {
            str = this.J;
        }
        S2.i2(str);
        PdfAppearance pdfAppearance = (PdfAppearance) P2.U0();
        if (q() != null) {
            pdfAppearance.s2(q(), this.f25930g);
        }
        BaseColor baseColor = this.f25928e;
        if (baseColor == null) {
            pdfAppearance.u2(0.0f);
        } else {
            pdfAppearance.h2(baseColor);
        }
        S2.m2(pdfAppearance);
        BaseColor baseColor2 = this.f25926c;
        if (baseColor2 != null) {
            S2.t2(baseColor2);
        }
        BaseColor baseColor3 = this.f25927d;
        if (baseColor3 != null) {
            S2.s2(baseColor3);
        }
        int i4 = this.f25936m;
        if (i4 != 1) {
            if (i4 != 2) {
                i2 = i4 != 3 ? 4 : 36;
            }
            return S2;
        }
        i2 = 6;
        S2.n2(i2);
        return S2;
    }

    public String U() {
        return this.J;
    }

    public PdfFormField V() throws IOException, DocumentException {
        return T(true);
    }

    public PdfFormField W(boolean z, boolean z2) {
        PdfFormField W2 = PdfFormField.W2(this.f25932i, z);
        if (z2) {
            W2.i3(33554432);
        }
        W2.j3(this.f25937n);
        if ((this.o & 1) != 0) {
            W2.i3(1);
        }
        if ((this.o & 2) != 0) {
            W2.i3(2);
        }
        W2.p3(this.K ? this.J : "Off");
        return W2;
    }

    public boolean X() {
        return this.K;
    }

    public void Y(int i2) {
        if (i2 < 1 || i2 > 6) {
            i2 = 2;
        }
        this.I = i2;
        K(R[i2 - 1]);
        try {
            E(BaseFont.j("ZapfDingbats", "Cp1252", false));
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void Z(boolean z) {
        this.K = z;
    }

    public void a0(String str) {
        this.J = str;
    }
}
