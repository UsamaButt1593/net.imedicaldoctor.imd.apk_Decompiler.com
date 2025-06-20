package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;

public class PdfAcroForm extends PdfDictionary {
    private PdfWriter p3;
    private HashSet<PdfTemplate> q3 = new HashSet<>();
    private PdfArray r3 = new PdfArray();
    private PdfArray s3 = new PdfArray();
    private int t3 = 0;

    public PdfAcroForm(PdfWriter pdfWriter) {
        this.p3 = pdfWriter;
    }

    public PdfFormField B1(PdfFormField pdfFormField, String str, float f2, float f3, float f4, float f5) {
        PdfFormField S2 = PdfFormField.S2(this.p3);
        S2.r3(new Rectangle(f2, f3, f4, f5), PdfAnnotation.D3);
        if (((PdfName) pdfFormField.d0(PdfName.kh)).toString().substring(1).equals(str)) {
            S2.i2(str);
        } else {
            S2.i2("Off");
        }
        V1(S2, str, f2, f3, f4, f5);
        pdfFormField.L2(S2);
        return S2;
    }

    public void E1(PdfFormField pdfFormField) {
        q1(pdfFormField);
    }

    public PdfFormField G1(String str, String str2, String str3, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        PdfFormField pdfFormField = new PdfFormField(this.p3, f3, f4, f5, f6, PdfAction.s1((Object[]) null, 0));
        String str4 = str;
        String str5 = str3;
        c2(pdfFormField, 65536, str, str3);
        N1(pdfFormField, str2, baseFont, f2, f3, f4, f5, f6);
        q1(pdfFormField);
        return pdfFormField;
    }

    public PdfFormField I1(String str, String[] strArr, String str2, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        PdfFormField T2 = PdfFormField.T2(this.p3, strArr, 0);
        i2(T2, str, str2, f3, f4, f5, f6);
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : strArr) {
            stringBuffer.append(append);
            stringBuffer.append(10);
        }
        Q1(T2, stringBuffer.toString(), baseFont, f2, f3, f4, f5, f6);
        q1(T2);
        return T2;
    }

    public PdfFormField J1(String str, String[][] strArr, String str2, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        PdfFormField U2 = PdfFormField.U2(this.p3, strArr, 0);
        i2(U2, str, str2, f3, f4, f5, f6);
        StringBuffer stringBuffer = new StringBuffer();
        for (String[] strArr2 : strArr) {
            stringBuffer.append(strArr2[1]);
            stringBuffer.append(10);
        }
        Q1(U2, stringBuffer.toString(), baseFont, f2, f3, f4, f5, f6);
        q1(U2);
        return U2;
    }

    public PdfFormField K1(String str, float f2, float f3, float f4, float f5) {
        PdfFormField X2 = PdfFormField.X2(this.p3);
        PdfFormField pdfFormField = X2;
        l2(pdfFormField, str, f2, f3, f4, f5);
        W1(pdfFormField, f2, f3, f4, f5);
        q1(X2);
        return X2;
    }

    public PdfFormField L1(String str, String str2, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        PdfFormField Y2 = PdfFormField.Y2(this.p3, false, true, 0);
        PdfFormField pdfFormField = Y2;
        String str3 = str2;
        m2(pdfFormField, str3, str, f3, f4, f5, f6);
        X1(pdfFormField, str3, baseFont, f2, f3, f4, f5, f6);
        q1(Y2);
        return Y2;
    }

    public PdfFormField M1(String str, String str2, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        PdfFormField Y2 = PdfFormField.Y2(this.p3, false, false, 0);
        PdfFormField pdfFormField = Y2;
        String str3 = str2;
        m2(pdfFormField, str3, str, f3, f4, f5, f6);
        X1(pdfFormField, str3, baseFont, f2, f3, f4, f5, f6);
        q1(Y2);
        return Y2;
    }

    public void N1(PdfFormField pdfFormField, String str, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        PdfAppearance a4 = PdfAppearance.a4(this.p3, f7, f8);
        a4.C0(0.0f, 0.0f, f7, f8, str, baseFont, f2);
        PdfFormField pdfFormField2 = pdfFormField;
        pdfFormField.c2(PdfAnnotation.O3, a4);
    }

    public void P1(PdfFormField pdfFormField, String str, float f2, float f3, float f4, float f5) {
        try {
            BaseFont j2 = BaseFont.j("ZapfDingbats", "Cp1252", false);
            float f6 = f5 - f3;
            float f7 = f4 - f2;
            PdfAppearance a4 = PdfAppearance.a4(this.p3, f7, f6);
            PdfAppearance pdfAppearance = (PdfAppearance) a4.U0();
            pdfAppearance.s2(j2, f6);
            pdfAppearance.R1();
            pdfFormField.m2(pdfAppearance);
            a4.G0(0.0f, 0.0f, f7, f6);
            a4.a2();
            a4.R1();
            a4.R();
            a4.s2(j2, f6);
            PdfAppearance pdfAppearance2 = a4;
            pdfAppearance2.o3(1, "4", f7 / 2.0f, (f6 / 2.0f) - (0.3f * f6), 0.0f);
            a4.L0();
            a4.U1();
            PdfName pdfName = PdfAnnotation.O3;
            pdfFormField.h2(pdfName, str, a4);
            PdfAppearance a42 = PdfAppearance.a4(this.p3, f7, f6);
            a42.G0(0.0f, 0.0f, f7, f6);
            pdfFormField.h2(pdfName, "Off", a42);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void Q1(PdfFormField pdfFormField, String str, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        PdfAppearance a4 = PdfAppearance.a4(this.p3, f7, f8);
        PdfAppearance pdfAppearance = (PdfAppearance) a4.U0();
        pdfAppearance.s2(baseFont, f2);
        pdfAppearance.R1();
        pdfFormField.m2(pdfAppearance);
        a4.G0(0.0f, 0.0f, f7, f8);
        a4.A3();
        a4.a2();
        a4.H1(3.0f, 3.0f, f7 - 6.0f, f8 - 6.0f);
        a4.b0();
        a4.x1();
        a4.R();
        a4.s2(baseFont, f2);
        a4.R1();
        a4.e3(4.0f, 5.0f);
        StringTokenizer stringTokenizer = new StringTokenizer(str, StringUtils.LF);
        while (stringTokenizer.hasMoreTokens()) {
            f8 -= 1.2f * f2;
            a4.o3(0, stringTokenizer.nextToken(), 3.0f, f8, 0.0f);
        }
        a4.L0();
        a4.U1();
        a4.D3();
        pdfFormField.c2(PdfAnnotation.O3, a4);
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 15, this);
        super.T(pdfWriter, outputStream);
    }

    public void V1(PdfFormField pdfFormField, String str, float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        PdfAppearance a4 = PdfAppearance.a4(this.p3, f6, f7);
        float f8 = f6;
        float f9 = f7;
        a4.E0(0.0f, 0.0f, f8, f9, true);
        PdfName pdfName = PdfAnnotation.O3;
        pdfFormField.h2(pdfName, str, a4);
        PdfAppearance a42 = PdfAppearance.a4(this.p3, f6, f7);
        a42.E0(0.0f, 0.0f, f8, f9, false);
        pdfFormField.h2(pdfName, "Off", a42);
    }

    public void W1(PdfFormField pdfFormField, float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        PdfAppearance a4 = PdfAppearance.a4(this.p3, f6, f7);
        a4.u2(1.0f);
        a4.H1(0.0f, 0.0f, f6, f7);
        a4.Q0();
        a4.v2(0.0f);
        a4.J2(1.0f);
        a4.H1(0.5f, 0.5f, f6 - 0.5f, f7 - 0.5f);
        a4.h0();
        a4.a2();
        a4.H1(1.0f, 1.0f, f6 - 2.0f, f7 - 2.0f);
        a4.b0();
        a4.x1();
        a4.U1();
        pdfFormField.c2(PdfAnnotation.O3, a4);
    }

    public void X1(PdfFormField pdfFormField, String str, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        PdfAppearance a4 = PdfAppearance.a4(this.p3, f7, f8);
        PdfAppearance pdfAppearance = (PdfAppearance) a4.U0();
        pdfAppearance.s2(baseFont, f2);
        pdfAppearance.R1();
        pdfFormField.m2(pdfAppearance);
        a4.G0(0.0f, 0.0f, f7, f8);
        a4.A3();
        a4.a2();
        a4.H1(3.0f, 3.0f, f7 - 6.0f, f8 - 6.0f);
        a4.b0();
        a4.x1();
        a4.R();
        a4.s2(baseFont, f2);
        a4.R1();
        a4.e3(4.0f, (f8 / 2.0f) - (f2 * 0.3f));
        a4.m3(str);
        a4.L0();
        a4.U1();
        a4.D3();
        pdfFormField.c2(PdfAnnotation.O3, a4);
    }

    public PdfFormField Y1(String str, String str2, boolean z) {
        PdfFormField W2 = PdfFormField.W2(this.p3, z);
        W2.j3(str);
        W2.p3(str2);
        return W2;
    }

    public boolean Z1() {
        if (this.r3.size() == 0) {
            return false;
        }
        V0(PdfName.P7, this.r3);
        int i2 = this.t3;
        if (i2 != 0) {
            V0(PdfName.Re, new PdfNumber(i2));
        }
        if (this.s3.size() > 0) {
            V0(PdfName.r5, this.s3);
        }
        if (this.q3.isEmpty()) {
            return true;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        Iterator<PdfTemplate> it2 = this.q3.iterator();
        while (it2.hasNext()) {
            PdfFormField.b3(pdfDictionary, (PdfDictionary) it2.next().N3());
        }
        V0(PdfName.T6, pdfDictionary);
        V0(PdfName.g6, new PdfString("/Helv 0 Tf 0 g "));
        PdfDictionary pdfDictionary2 = (PdfDictionary) pdfDictionary.d0(PdfName.l8);
        if (pdfDictionary2 != null) {
            this.p3.Q0(pdfDictionary2);
        }
        return true;
    }

    public void c2(PdfFormField pdfFormField, int i2, String str, String str2) {
        pdfFormField.f3(i2);
        pdfFormField.n2(4);
        pdfFormField.D2();
        pdfFormField.j3(str);
        if (str2 != null) {
            pdfFormField.q3(str2);
        }
    }

    public void f1(PdfFormField pdfFormField) {
        this.s3.a0(pdfFormField.L1());
    }

    public void h2(PdfFormField pdfFormField, String str, String str2, boolean z, float f2, float f3, float f4, float f5) {
        pdfFormField.r3(new Rectangle(f2, f3, f4, f5), PdfAnnotation.D3);
        pdfFormField.j3(str);
        if (z) {
            pdfFormField.p3(str2);
            pdfFormField.i2(str2);
        } else {
            pdfFormField.p3("Off");
            pdfFormField.i2("Off");
        }
        pdfFormField.n2(4);
        pdfFormField.D2();
        pdfFormField.k2(new PdfBorderDictionary(1.0f, 0));
    }

    public PdfFormField i1(String str, String str2, boolean z, float f2, float f3, float f4, float f5) {
        PdfFormField N2 = PdfFormField.N2(this.p3);
        PdfFormField pdfFormField = N2;
        h2(pdfFormField, str, str2, z, f2, f3, f4, f5);
        P1(pdfFormField, str2, f2, f3, f4, f5);
        q1(N2);
        return N2;
    }

    public void i2(PdfFormField pdfFormField, String str, String str2, float f2, float f3, float f4, float f5) {
        pdfFormField.r3(new Rectangle(f2, f3, f4, f5), PdfAnnotation.A3);
        if (str2 != null) {
            pdfFormField.q3(str2);
            pdfFormField.h3(str2);
        }
        pdfFormField.j3(str);
        pdfFormField.n2(4);
        pdfFormField.D2();
        pdfFormField.k2(new PdfBorderDictionary(2.0f, 0));
    }

    public void j2(boolean z) {
        V0(PdfName.xb, new PdfBoolean(z));
    }

    public void k2(int i2) {
        this.t3 = i2 | this.t3;
    }

    public void l2(PdfFormField pdfFormField, String str, float f2, float f3, float f4, float f5) {
        pdfFormField.r3(new Rectangle(f2, f3, f4, f5), PdfAnnotation.A3);
        pdfFormField.j3(str);
        pdfFormField.n2(4);
        pdfFormField.D2();
        pdfFormField.t2(BaseColor.f25677f);
        pdfFormField.s2(BaseColor.f25673b);
    }

    public PdfFormField m1(String str, String[] strArr, String str2, boolean z, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        String[] strArr2 = strArr;
        PdfFormField Q2 = PdfFormField.Q2(this.p3, z, strArr, 0);
        i2(Q2, str, str2, f3, f4, f5, f6);
        X1(Q2, str2 == null ? strArr2[0] : str2, baseFont, f2, f3, f4, f5, f6);
        q1(Q2);
        return Q2;
    }

    public void m2(PdfFormField pdfFormField, String str, String str2, float f2, float f3, float f4, float f5) {
        pdfFormField.r3(new Rectangle(f2, f3, f4, f5), PdfAnnotation.A3);
        pdfFormField.q3(str);
        pdfFormField.h3(str);
        pdfFormField.j3(str2);
        pdfFormField.n2(4);
        pdfFormField.D2();
    }

    public PdfFormField n1(String str, String[][] strArr, String str2, boolean z, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        String str3;
        String[][] strArr2 = strArr;
        PdfFormField R2 = PdfFormField.R2(this.p3, z, strArr, 0);
        i2(R2, str, str2, f3, f4, f5, f6);
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str3 = null;
                break;
            }
            String[] strArr3 = strArr2[i2];
            String str4 = str2;
            if (strArr3[0].equals(str2)) {
                str3 = strArr3[1];
                break;
            }
            i2++;
        }
        if (str3 == null) {
            str3 = strArr2[0][1];
        }
        X1(R2, str3, baseFont, f2, f3, f4, f5, f6);
        q1(R2);
        return R2;
    }

    public void o1(PdfIndirectReference pdfIndirectReference) {
        this.r3.a0(pdfIndirectReference);
    }

    public void p1(HashSet<PdfTemplate> hashSet) {
        this.q3.addAll(hashSet);
    }

    public void q1(PdfFormField pdfFormField) {
        this.p3.u(pdfFormField);
    }

    public PdfFormField s1(String str, String str2) {
        PdfFormField S2 = PdfFormField.S2(this.p3);
        S2.j3(str);
        S2.p3(str2);
        q1(S2);
        return S2;
    }

    public PdfFormField v1(String str, String str2, String str3, String str4, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        String str5 = str4;
        PdfFormField pdfFormField = new PdfFormField(this.p3, f3, f4, f5, f6, PdfAction.v1(str4, (Object[]) null, 4));
        String str6 = str;
        String str7 = str3;
        c2(pdfFormField, 65536, str, str3);
        N1(pdfFormField, str2, baseFont, f2, f3, f4, f5, f6);
        q1(pdfFormField);
        return pdfFormField;
    }

    public PdfFormField w1(String str, String str2, String str3, PdfContentByte pdfContentByte, float f2, float f3, float f4, float f5) {
        String str4 = str3;
        PdfFormField pdfFormField = new PdfFormField(this.p3, f2, f3, f4, f5, PdfAction.v1(str3, (Object[]) null, 20));
        String str5 = str;
        c2(pdfFormField, 65536, str, (String) null);
        PdfAppearance a4 = PdfAppearance.a4(this.p3, f4 - f2, f5 - f3);
        PdfContentByte pdfContentByte2 = pdfContentByte;
        a4.c(pdfContentByte);
        pdfFormField.c2(PdfAnnotation.O3, a4);
        q1(pdfFormField);
        return pdfFormField;
    }

    public PdfFormField x1(String str, String str2, BaseFont baseFont, float f2, float f3, float f4, float f5, float f6) {
        PdfFormField Y2 = PdfFormField.Y2(this.p3, true, false, 0);
        PdfFormField pdfFormField = Y2;
        String str3 = str2;
        m2(pdfFormField, str3, str, f3, f4, f5, f6);
        Q1(pdfFormField, str3, baseFont, f2, f3, f4, f5, f6);
        q1(Y2);
        return Y2;
    }
}
