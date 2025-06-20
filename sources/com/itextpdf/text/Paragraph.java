package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;

public class Paragraph extends Phrase implements Indentable, Spaceable, IAccessibleElement {
    private static final long l3 = 7852314969733375514L;
    protected int Z2 = -1;
    protected float a3;
    protected float b3;
    private float c3 = 0.0f;
    protected float d3;
    protected float e3;
    private float f3 = 0.0f;
    protected boolean g3 = false;
    protected float h3;
    protected PdfName i3 = PdfName.tc;
    protected HashMap<PdfName, PdfObject> j3 = null;
    protected AccessibleElementId k3 = null;

    public Paragraph() {
    }

    public float A1() {
        return this.c3;
    }

    public void B(float f2) {
        this.b3 = f2;
    }

    public boolean C1() {
        return this.g3;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.k3 = accessibleElementId;
    }

    public float E() {
        return this.d3;
    }

    /* access modifiers changed from: protected */
    public void H1(Paragraph paragraph, boolean z) {
        paragraph.M0(q0());
        paragraph.O1(y1());
        paragraph.b1(z0(), this.X);
        paragraph.g(m());
        paragraph.B(q());
        paragraph.S1(A1());
        paragraph.c(K());
        if (z) {
            paragraph.h(E());
        }
        paragraph.R1(z1());
        paragraph.o(this.i3);
        paragraph.k3 = getId();
        if (this.j3 != null) {
            paragraph.j3 = new HashMap<>(this.j3);
        }
        paragraph.r1(F0());
        paragraph.U1(C1());
    }

    public float K() {
        return this.e3;
    }

    public PdfName L() {
        return this.i3;
    }

    public void M(float f2) {
        this.h3 = f2;
    }

    public void O1(int i2) {
        this.Z2 = i2;
    }

    public void R1(float f2) {
        this.f3 = f2;
    }

    public void S1(float f2) {
        this.c3 = f2;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.j3 == null) {
            this.j3 = new HashMap<>();
        }
        this.j3.put(pdfName, pdfObject);
    }

    public void U1(boolean z) {
        this.g3 = z;
    }

    public float X() {
        return this.h3;
    }

    @Deprecated
    public float a2() {
        return this.e3;
    }

    /* renamed from: b */
    public boolean add(Element element) {
        if (element instanceof List) {
            List list = (List) element;
            list.g(list.m() + this.a3);
            list.B(this.b3);
            return super.add(list);
        } else if (element instanceof Image) {
            super.n0(element);
            return true;
        } else if (!(element instanceof Paragraph)) {
            return super.add(element);
        } else {
            super.n0(element);
            return true;
        }
    }

    @Deprecated
    public float b2() {
        return E();
    }

    public void c(float f2) {
        this.e3 = f2;
    }

    public void g(float f2) {
        this.a3 = f2;
    }

    public AccessibleElementId getId() {
        if (this.k3 == null) {
            this.k3 = new AccessibleElementId();
        }
        return this.k3;
    }

    public void h(float f2) {
        this.d3 = f2;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.j3;
    }

    public float m() {
        return this.a3;
    }

    public boolean n() {
        return false;
    }

    public void o(PdfName pdfName) {
        this.i3 = pdfName;
    }

    public float q() {
        return this.b3;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.j3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public int type() {
        return 12;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0079, code lost:
        if (r4 != null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c3, code lost:
        if (r1 != null) goto L_0x00c5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.itextpdf.text.Element> u1() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r1 = r10.iterator()
            r2 = 0
        L_0x000a:
            boolean r3 = r1.hasNext()
            r4 = 1
            r5 = 12
            r6 = 23
            r7 = 14
            if (r3 == 0) goto L_0x008c
            java.lang.Object r3 = r1.next()
            com.itextpdf.text.Element r3 = (com.itextpdf.text.Element) r3
            int r8 = r3.type()
            r9 = 0
            if (r8 == r7) goto L_0x0043
            int r8 = r3.type()
            if (r8 == r6) goto L_0x0043
            int r8 = r3.type()
            if (r8 != r5) goto L_0x0031
            goto L_0x0043
        L_0x0031:
            if (r2 != 0) goto L_0x003f
            int r2 = r0.size()
            if (r2 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r4 = 0
        L_0x003b:
            com.itextpdf.text.Paragraph r2 = r10.w1(r4)
        L_0x003f:
            r2.add(r3)
            goto L_0x000a
        L_0x0043:
            if (r2 == 0) goto L_0x0056
            int r4 = r2.size()
            if (r4 <= 0) goto L_0x0056
            r4 = 0
            r2.c(r4)
            r0.add(r2)
            com.itextpdf.text.Paragraph r2 = r10.w1(r9)
        L_0x0056:
            int r4 = r0.size()
            if (r4 != 0) goto L_0x0087
            int r4 = r3.type()
            if (r4 == r5) goto L_0x0083
            if (r4 == r7) goto L_0x0072
            if (r4 == r6) goto L_0x0067
            goto L_0x0087
        L_0x0067:
            r4 = r3
            com.itextpdf.text.pdf.PdfPTable r4 = (com.itextpdf.text.pdf.PdfPTable) r4
            float r5 = r10.E()
            r4.h(r5)
            goto L_0x0087
        L_0x0072:
            r4 = r3
            com.itextpdf.text.List r4 = (com.itextpdf.text.List) r4
            com.itextpdf.text.ListItem r4 = r4.f()
            if (r4 == 0) goto L_0x0087
        L_0x007b:
            float r5 = r10.E()
            r4.h(r5)
            goto L_0x0087
        L_0x0083:
            r4 = r3
            com.itextpdf.text.Paragraph r4 = (com.itextpdf.text.Paragraph) r4
            goto L_0x007b
        L_0x0087:
            r0.add(r3)
            goto L_0x000a
        L_0x008c:
            if (r2 == 0) goto L_0x0097
            int r1 = r2.size()
            if (r1 <= 0) goto L_0x0097
            r0.add(r2)
        L_0x0097:
            int r1 = r0.size()
            if (r1 == 0) goto L_0x00d0
            int r1 = r0.size()
            int r1 = r1 - r4
            java.lang.Object r1 = r0.get(r1)
            com.itextpdf.text.Element r1 = (com.itextpdf.text.Element) r1
            int r2 = r1.type()
            if (r2 == r5) goto L_0x00cd
            if (r2 == r7) goto L_0x00bd
            if (r2 == r6) goto L_0x00b3
            goto L_0x00d0
        L_0x00b3:
            com.itextpdf.text.pdf.PdfPTable r1 = (com.itextpdf.text.pdf.PdfPTable) r1
            float r2 = r10.K()
            r1.c(r2)
            goto L_0x00d0
        L_0x00bd:
            com.itextpdf.text.List r1 = (com.itextpdf.text.List) r1
            com.itextpdf.text.ListItem r1 = r1.i()
            if (r1 == 0) goto L_0x00d0
        L_0x00c5:
            float r2 = r10.K()
            r1.c(r2)
            goto L_0x00d0
        L_0x00cd:
            com.itextpdf.text.Paragraph r1 = (com.itextpdf.text.Paragraph) r1
            goto L_0x00c5
        L_0x00d0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Paragraph.u1():java.util.List");
    }

    public Paragraph w1(boolean z) {
        Paragraph paragraph = new Paragraph();
        H1(paragraph, z);
        return paragraph;
    }

    public int y1() {
        return this.Z2;
    }

    public float z1() {
        return this.f3;
    }

    public Paragraph(float f2) {
        super(f2);
    }

    public Paragraph(float f2, Chunk chunk) {
        super(f2, chunk);
    }

    public Paragraph(float f2, String str) {
        super(f2, str);
    }

    public Paragraph(float f2, String str, Font font) {
        super(f2, str, font);
    }

    public Paragraph(Chunk chunk) {
        super(chunk);
    }

    public Paragraph(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            O1(paragraph.Z2);
            g(paragraph.m());
            B(paragraph.q());
            S1(paragraph.A1());
            c(paragraph.K());
            h(paragraph.E());
            R1(paragraph.z1());
            o(paragraph.i3);
            this.k3 = paragraph.getId();
            if (paragraph.j3 != null) {
                this.j3 = new HashMap<>(paragraph.j3);
            }
        }
    }

    public Paragraph(String str) {
        super(str);
    }

    public Paragraph(String str, Font font) {
        super(str, font);
    }
}
