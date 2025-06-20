package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;

public class PdfLayer extends PdfDictionary implements PdfOCG {
    protected PdfIndirectReference p3;
    protected ArrayList<PdfLayer> q3;
    protected PdfLayer r3;
    protected String s3;
    private boolean t3 = true;
    private boolean u3 = true;

    PdfLayer(String str) {
        this.s3 = str;
    }

    public static PdfLayer i1(String str, PdfWriter pdfWriter) {
        if (str != null) {
            PdfLayer pdfLayer = new PdfLayer(str);
            pdfWriter.c2(pdfLayer);
            return pdfLayer;
        }
        throw new NullPointerException(MessageLocalization.b("title.cannot.be.null", new Object[0]));
    }

    private PdfDictionary p1() {
        PdfName pdfName = PdfName.ah;
        PdfDictionary j0 = j0(pdfName);
        if (j0 != null) {
            return j0;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        V0(pdfName, pdfDictionary);
        return pdfDictionary;
    }

    public void B1(String str) {
        V0(PdfName.qb, new PdfString(str, PdfObject.h3));
    }

    public void E1(boolean z) {
        this.t3 = z;
    }

    public void G1(boolean z) {
        this.u3 = z;
    }

    public void I1(String str) {
        PdfDictionary p1 = p1();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.Cf, new PdfName(str));
        p1.V0(PdfName.vc, pdfDictionary);
    }

    public void J1(String str, boolean z) {
        PdfDictionary p1 = p1();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.Cf, new PdfName(str));
        pdfDictionary.V0(PdfName.pd, z ? PdfName.Zb : PdfName.Yb);
        p1.V0(PdfName.id, pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public void K1(PdfIndirectReference pdfIndirectReference) {
        this.p3 = pdfIndirectReference;
    }

    public void L1(String str, String... strArr) {
        PdfDictionary p1 = p1();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.Kg, new PdfName(str));
        PdfArray pdfArray = new PdfArray();
        for (String pdfString : strArr) {
            pdfArray.a0(new PdfString(pdfString, PdfObject.h3));
        }
        p1.V0(PdfName.qb, pdfArray);
        p1.V0(PdfName.fh, pdfDictionary);
    }

    public void M1(boolean z) {
        PdfDictionary p1 = p1();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.yh, z ? PdfName.Zb : PdfName.Yb);
        p1.V0(PdfName.sh, pdfDictionary);
    }

    public void N1(float f2, float f3) {
        if (f2 > 0.0f || f3 >= 0.0f) {
            PdfDictionary p1 = p1();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (f2 > 0.0f) {
                pdfDictionary.V0(PdfName.eb, new PdfNumber(f2));
            }
            if (f3 >= 0.0f) {
                pdfDictionary.V0(PdfName.Wa, new PdfNumber(f3));
            }
            p1.V0(PdfName.ji, pdfDictionary);
        }
    }

    public PdfObject c() {
        return this;
    }

    public void f1(PdfLayer pdfLayer) {
        if (pdfLayer.r3 == null) {
            pdfLayer.r3 = this;
            if (this.q3 == null) {
                this.q3 = new ArrayList<>();
            }
            this.q3.add(pdfLayer);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("the.layer.1.already.has.a.parent", pdfLayer.A0(PdfName.qb).m0()));
    }

    public PdfIndirectReference g() {
        return this.p3;
    }

    public ArrayList<PdfLayer> m1() {
        return this.q3;
    }

    public PdfLayer n1() {
        return this.r3;
    }

    /* access modifiers changed from: package-private */
    public String o1() {
        return this.s3;
    }

    public boolean q1() {
        return this.t3;
    }

    public boolean s1() {
        return this.u3;
    }

    public void v1(String str, String str2) {
        PdfDictionary p1 = p1();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.V5, new PdfString(str, PdfObject.h3));
        pdfDictionary.V0(PdfName.Cf, new PdfName(str2));
        p1.V0(PdfName.W5, pdfDictionary);
    }

    public void w1(boolean z) {
        PdfDictionary p1 = p1();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.D7, z ? PdfName.Zb : PdfName.Yb);
        p1.V0(PdfName.C7, pdfDictionary);
    }

    public void x1(String str, boolean z) {
        PdfDictionary p1 = p1();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.ma, new PdfString(str, PdfObject.h3));
        if (z) {
            pdfDictionary.V0(PdfName.cd, PdfName.Zb);
        }
        p1.V0(PdfName.na, pdfDictionary);
    }

    public PdfLayer(String str, PdfWriter pdfWriter) throws IOException {
        super(PdfName.Qb);
        B1(str);
        this.p3 = pdfWriter instanceof PdfStamperImp ? pdfWriter.v0(this).a() : pdfWriter.D1();
        pdfWriter.c2(this);
    }
}
