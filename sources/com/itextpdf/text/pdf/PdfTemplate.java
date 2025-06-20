package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.io.IOException;
import java.util.HashMap;

public class PdfTemplate extends PdfContentByte implements IAccessibleElement {
    public static final int L3 = 1;
    public static final int M3 = 2;
    public static final int N3 = 3;
    protected PageResources A3;
    protected Rectangle B3 = new Rectangle(0.0f, 0.0f);
    protected PdfArray C3;
    protected PdfTransparencyGroup D3;
    protected PdfOCG E3;
    protected PdfIndirectReference F3;
    protected boolean G3 = false;
    private PdfDictionary H3 = null;
    protected PdfName I3 = PdfName.Q7;
    protected HashMap<PdfName, PdfObject> J3 = null;
    private AccessibleElementId K3 = null;
    protected int y3 = 1;
    protected PdfIndirectReference z3;

    protected PdfTemplate() {
        super((PdfWriter) null);
    }

    public static PdfTemplate B3(PdfWriter pdfWriter, float f2, float f3) {
        return C3(pdfWriter, f2, f3, (PdfName) null);
    }

    static PdfTemplate C3(PdfWriter pdfWriter, float f2, float f3, PdfName pdfName) {
        PdfTemplate pdfTemplate = new PdfTemplate(pdfWriter);
        pdfTemplate.Z3(f2);
        pdfTemplate.V3(f3);
        pdfWriter.X(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public void A3() {
        this.s.k("/Tx BMC ");
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.K3 = accessibleElementId;
    }

    public void D3() {
        this.s.k("EMC ");
    }

    public PdfDictionary E3() {
        return this.H3;
    }

    public Rectangle F3() {
        return this.B3;
    }

    public PdfStream G3(int i2) throws IOException {
        return new PdfFormXObject(this, i2);
    }

    public PdfTransparencyGroup H3() {
        return this.D3;
    }

    public float I3() {
        return this.B3.N();
    }

    public PdfIndirectReference J3() {
        if (this.z3 == null) {
            this.z3 = this.Y.D1();
        }
        return this.z3;
    }

    public PdfOCG K3() {
        return this.E3;
    }

    public PdfName L() {
        return this.I3;
    }

    /* access modifiers changed from: package-private */
    public PdfArray L3() {
        return this.C3;
    }

    public PdfIndirectReference M3() {
        return this.F3;
    }

    /* access modifiers changed from: package-private */
    public PdfObject N3() {
        return f1().k();
    }

    public int O3() {
        return this.y3;
    }

    public float P3() {
        return this.B3.a0();
    }

    public boolean Q3() {
        return this.G3;
    }

    public void R3(PdfDictionary pdfDictionary) {
        this.H3 = pdfDictionary;
    }

    public void S3(Rectangle rectangle) {
        this.B3 = rectangle;
    }

    public PdfIndirectReference T0() {
        PdfIndirectReference pdfIndirectReference = this.F3;
        return pdfIndirectReference == null ? this.Y.d1() : pdfIndirectReference;
    }

    public void T3(boolean z) {
        this.G3 = z;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.J3 == null) {
            this.J3 = new HashMap<>();
        }
        this.J3.put(pdfName, pdfObject);
    }

    public PdfContentByte U0() {
        PdfTemplate pdfTemplate = new PdfTemplate();
        pdfTemplate.Y = this.Y;
        pdfTemplate.Z = this.Z;
        pdfTemplate.z3 = this.z3;
        pdfTemplate.A3 = this.A3;
        pdfTemplate.B3 = new Rectangle(this.B3);
        pdfTemplate.D3 = this.D3;
        pdfTemplate.E3 = this.E3;
        PdfArray pdfArray = this.C3;
        if (pdfArray != null) {
            pdfTemplate.C3 = new PdfArray(pdfArray);
        }
        pdfTemplate.a3 = this.a3;
        pdfTemplate.H3 = this.H3;
        pdfTemplate.G3 = this.G3;
        pdfTemplate.e3 = this;
        return pdfTemplate;
    }

    public void U3(PdfTransparencyGroup pdfTransparencyGroup) {
        this.D3 = pdfTransparencyGroup;
    }

    public void V3(float f2) {
        this.B3.u0(0.0f);
        this.B3.z0(f2);
    }

    public void W3(PdfOCG pdfOCG) {
        this.E3 = pdfOCG;
    }

    public void X3(float f2, float f3, float f4, float f5, float f6, float f7) {
        PdfArray pdfArray = new PdfArray();
        this.C3 = pdfArray;
        pdfArray.a0(new PdfNumber(f2));
        this.C3.a0(new PdfNumber(f3));
        this.C3.a0(new PdfNumber(f4));
        this.C3.a0(new PdfNumber(f5));
        this.C3.a0(new PdfNumber(f6));
        this.C3.a0(new PdfNumber(f7));
    }

    public void Y3(PdfIndirectReference pdfIndirectReference) {
        this.F3 = pdfIndirectReference;
    }

    public void Z3(float f2) {
        this.B3.w0(0.0f);
        this.B3.x0(f2);
    }

    /* access modifiers changed from: package-private */
    public PageResources f1() {
        return this.A3;
    }

    public AccessibleElementId getId() {
        if (this.K3 == null) {
            this.K3 = new AccessibleElementId();
        }
        return this.K3;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.J3;
    }

    public boolean n() {
        return true;
    }

    public void o(PdfName pdfName) {
        this.I3 = pdfName;
    }

    public boolean o1() {
        return super.o1() && this.G3;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.J3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    PdfTemplate(PdfWriter pdfWriter) {
        super(pdfWriter);
        PageResources pageResources = new PageResources();
        this.A3 = pageResources;
        pageResources.b(pdfWriter.f1());
        this.z3 = this.Y.D1();
    }
}
