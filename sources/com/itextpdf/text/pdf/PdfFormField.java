package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfFormField extends PdfAnnotation {
    public static final int A4 = 2;
    public static final int B4 = 0;
    public static final int C4 = 1;
    public static final int D4 = 2;
    public static final int E4 = 3;
    public static final int F4 = 4;
    public static final int G4 = 5;
    public static final int H4 = 6;
    public static final PdfName I4;
    public static final PdfName J4 = PdfName.h4;
    public static final PdfName K4 = PdfName.Ce;
    public static final PdfName L4 = PdfName.kb;
    public static final PdfName M4;
    public static final PdfName N4 = PdfName.tc;
    public static final boolean O4 = true;
    public static final boolean P4 = false;
    public static final boolean Q4 = false;
    public static final boolean R4 = true;
    static PdfName[] S4 = {PdfName.l8, PdfName.ai, PdfName.w5, PdfName.Ic};
    public static final int h4 = 1;
    public static final int i4 = 2;
    public static final int j4 = 4;
    public static final int k4 = 16384;
    public static final int l4 = 32768;
    public static final int m4 = 65536;
    public static final int n4 = 4096;
    public static final int o4 = 8192;
    public static final int p4 = 131072;
    public static final int q4 = 262144;
    public static final int r4 = 1048576;
    public static final int s4 = 2097152;
    public static final int t4 = 4194304;
    public static final int u4 = 8388608;
    public static final int v4 = 16777216;
    public static final int w4 = 33554432;
    public static final int x4 = 33554432;
    public static final int y4 = 0;
    public static final int z4 = 1;
    protected PdfFormField f4;
    protected ArrayList<PdfFormField> g4;

    static {
        PdfName pdfName = PdfName.k3;
        I4 = pdfName;
        M4 = pdfName;
    }

    protected PdfFormField(PdfWriter pdfWriter) {
        super(pdfWriter, (Rectangle) null);
        this.s3 = true;
        this.t3 = false;
        this.w3 = PdfName.w8;
    }

    protected static PdfFormField M2(PdfWriter pdfWriter, int i2) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.f3(i2);
        return pdfFormField;
    }

    public static PdfFormField N2(PdfWriter pdfWriter) {
        return M2(pdfWriter, 0);
    }

    protected static PdfFormField O2(PdfWriter pdfWriter, int i2, PdfArray pdfArray, int i3) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.V0(PdfName.C8, PdfName.e5);
        pdfFormField.V0(PdfName.L7, new PdfNumber(i2));
        pdfFormField.V0(PdfName.hc, pdfArray);
        if (i3 > 0) {
            pdfFormField.V0(PdfName.bg, new PdfNumber(i3));
        }
        return pdfFormField;
    }

    public static PdfFormField Q2(PdfWriter pdfWriter, boolean z, String[] strArr, int i2) {
        return O2(pdfWriter, (z ? 262144 : 0) + 131072, d3(strArr), i2);
    }

    public static PdfFormField R2(PdfWriter pdfWriter, boolean z, String[][] strArr, int i2) {
        return O2(pdfWriter, (z ? 262144 : 0) + 131072, e3(strArr), i2);
    }

    public static PdfFormField S2(PdfWriter pdfWriter) {
        return new PdfFormField(pdfWriter);
    }

    public static PdfFormField T2(PdfWriter pdfWriter, String[] strArr, int i2) {
        return O2(pdfWriter, 0, d3(strArr), i2);
    }

    public static PdfFormField U2(PdfWriter pdfWriter, String[][] strArr, int i2) {
        return O2(pdfWriter, 0, e3(strArr), i2);
    }

    public static PdfFormField V2(PdfWriter pdfWriter) {
        return M2(pdfWriter, 65536);
    }

    public static PdfFormField W2(PdfWriter pdfWriter, boolean z) {
        return M2(pdfWriter, (z ? 16384 : 0) + 32768);
    }

    public static PdfFormField X2(PdfWriter pdfWriter) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.V0(PdfName.C8, PdfName.Pe);
        return pdfFormField;
    }

    public static PdfFormField Y2(PdfWriter pdfWriter, boolean z, boolean z2, int i2) {
        PdfFormField pdfFormField = new PdfFormField(pdfWriter);
        pdfFormField.V0(PdfName.C8, PdfName.Jg);
        int i3 = 0;
        int i5 = z ? 4096 : 0;
        if (z2) {
            i3 = 8192;
        }
        pdfFormField.V0(PdfName.L7, new PdfNumber(i5 + i3));
        if (i2 > 0) {
            pdfFormField.V0(PdfName.Ya, new PdfNumber(i2));
        }
        return pdfFormField;
    }

    static void b3(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        c3(pdfDictionary, pdfDictionary2, (PdfStamperImp) null);
    }

    static void c3(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfStamperImp pdfStamperImp) {
        int i2 = 0;
        while (true) {
            PdfName[] pdfNameArr = S4;
            if (i2 < pdfNameArr.length) {
                PdfName pdfName = pdfNameArr[i2];
                PdfDictionary j0 = pdfDictionary2.j0(pdfName);
                if (j0 != null) {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.u0(pdfDictionary.d0(pdfName), pdfDictionary);
                    if (pdfDictionary3 == null) {
                        pdfDictionary3 = new PdfDictionary();
                    }
                    pdfDictionary3.U0(j0);
                    pdfDictionary.V0(pdfName, pdfDictionary3);
                    if (pdfStamperImp != null) {
                        pdfStamperImp.z3(pdfDictionary3);
                    }
                }
                i2++;
            } else {
                return;
            }
        }
    }

    protected static PdfArray d3(String[] strArr) {
        PdfArray pdfArray = new PdfArray();
        for (String pdfString : strArr) {
            pdfArray.a0(new PdfString(pdfString, PdfObject.h3));
        }
        return pdfArray;
    }

    protected static PdfArray e3(String[][] strArr) {
        PdfArray pdfArray = new PdfArray();
        for (String[] strArr2 : strArr) {
            PdfArray pdfArray2 = new PdfArray((PdfObject) new PdfString(strArr2[0], PdfObject.h3));
            pdfArray2.a0(new PdfString(strArr2[1], PdfObject.h3));
            pdfArray.a0(pdfArray2);
        }
        return pdfArray;
    }

    public static PdfAnnotation s3(PdfAnnotation pdfAnnotation) {
        PdfFormField pdfFormField;
        if (pdfAnnotation.W1()) {
            PdfFormField pdfFormField2 = new PdfFormField(pdfAnnotation.p3);
            PdfFormField pdfFormField3 = (PdfFormField) pdfAnnotation;
            pdfFormField2.f4 = pdfFormField3.f4;
            pdfFormField2.g4 = pdfFormField3.g4;
            pdfFormField = pdfFormField2;
        } else {
            pdfFormField = pdfAnnotation.p3.M0((Rectangle) null, (PdfName) pdfAnnotation.d0(PdfName.Cf));
        }
        pdfFormField.T0(pdfAnnotation);
        pdfFormField.s3 = pdfAnnotation.s3;
        pdfFormField.t3 = pdfAnnotation.t3;
        pdfFormField.r3 = pdfAnnotation.r3;
        return pdfFormField;
    }

    public void K2() {
        this.u3 = true;
        PdfFormField pdfFormField = this.f4;
        if (pdfFormField != null) {
            V0(PdfName.Dc, pdfFormField.L1());
        }
        if (this.g4 != null) {
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < this.g4.size(); i2++) {
                pdfArray.a0(this.g4.get(i2).L1());
            }
            V0(PdfName.ia, pdfArray);
        }
        if (this.r3 != null) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            Iterator<PdfTemplate> it2 = this.r3.iterator();
            while (it2.hasNext()) {
                b3(pdfDictionary, (PdfDictionary) it2.next().N3());
            }
            V0(PdfName.T6, pdfDictionary);
        }
    }

    public void L2(PdfFormField pdfFormField) {
        pdfFormField.f4 = this;
        if (this.g4 == null) {
            this.g4 = new ArrayList<>();
        }
        this.g4.add(pdfFormField);
    }

    public ArrayList<PdfFormField> Z2() {
        return this.g4;
    }

    public PdfFormField a3() {
        return this.f4;
    }

    public void f3(int i2) {
        V0(PdfName.C8, PdfName.I4);
        if (i2 != 0) {
            V0(PdfName.L7, new PdfNumber(i2));
        }
    }

    public void g3(String str) {
        V0(PdfName.a7, new PdfName(str));
    }

    public void h3(String str) {
        V0(PdfName.a7, new PdfString(str, PdfObject.h3));
    }

    public int i3(int i2) {
        PdfName pdfName = PdfName.L7;
        PdfNumber pdfNumber = (PdfNumber) d0(pdfName);
        int e0 = pdfNumber == null ? 0 : pdfNumber.e0();
        V0(pdfName, new PdfNumber(i2 | e0));
        return e0;
    }

    public void j3(String str) {
        if (str != null) {
            V0(PdfName.If, new PdfString(str, PdfObject.h3));
        }
    }

    public void k3(String str) {
        V0(PdfName.kg, new PdfString(str, PdfObject.h3));
    }

    public void l3(int i2) {
        V0(PdfName.Ad, new PdfNumber(i2));
    }

    public void m3(String str) {
        V0(PdfName.Be, new PdfString(str));
    }

    public void n3(String str) {
        V0(PdfName.Dg, new PdfString(str, PdfObject.h3));
    }

    public void o3(PdfSignature pdfSignature) {
        V0(PdfName.kh, pdfSignature);
    }

    public void p3(String str) {
        V0(PdfName.kh, new PdfName(str));
    }

    public void q3(String str) {
        V0(PdfName.kh, new PdfString(str, PdfObject.h3));
    }

    public void r3(Rectangle rectangle, PdfName pdfName) {
        V0(PdfName.Kg, PdfName.P3);
        V0(PdfName.Cf, PdfName.Ih);
        V0(PdfName.Nd, new PdfRectangle(rectangle));
        this.t3 = true;
        if (pdfName != null && !pdfName.equals(PdfAnnotation.A3)) {
            V0(PdfName.W8, pdfName);
        }
    }

    public PdfFormField(PdfWriter pdfWriter, float f2, float f3, float f5, float f6, PdfAction pdfAction) {
        super(pdfWriter, f2, f3, f5, f6, pdfAction);
        V0(PdfName.Kg, PdfName.P3);
        V0(PdfName.Cf, PdfName.Ih);
        this.t3 = true;
    }
}
