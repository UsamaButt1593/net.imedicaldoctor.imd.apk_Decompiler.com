package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.events.PdfPCellEventForwarder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PdfPCell extends Rectangle implements IAccessibleElement {
    private float A3;
    private float B3;
    private boolean C3;
    private PdfPTable D3;
    private int E3;
    private int F3;
    private Image G3;
    private PdfPCellEvent H3;
    private boolean I3;
    private boolean J3;
    protected Phrase K3;
    private int L3;
    protected PdfName M3;
    protected HashMap<PdfName, PdfObject> N3;
    protected AccessibleElementId O3;
    protected ArrayList<PdfPHeaderCell> P3;
    private ColumnText s3;
    private int t3;
    private float u3;
    private float v3;
    private float w3;
    private float x3;
    private float y3;
    private float z3;

    public PdfPCell() {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.s3 = new ColumnText((PdfContentByte) null);
        this.t3 = 4;
        this.u3 = 2.0f;
        this.v3 = 2.0f;
        this.w3 = 2.0f;
        this.x3 = 2.0f;
        this.y3 = 0.0f;
        this.z3 = 0.0f;
        this.C3 = false;
        this.E3 = 1;
        this.F3 = 1;
        this.I3 = false;
        this.J3 = false;
        this.M3 = PdfName.Nf;
        this.N3 = null;
        this.O3 = new AccessibleElementId();
        this.P3 = null;
        this.b3 = 0.5f;
        this.Z2 = 15;
        this.s3.i0(0.0f, 1.0f);
    }

    public void A1(float f2) {
        this.s3.c0(f2);
    }

    public void B1(int i2) {
        this.s3.V(i2);
    }

    public void C1(Image image) {
        this.s3.r0((Phrase) null);
        this.D3 = null;
        this.G3 = image;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.O3 = accessibleElementId;
    }

    public void D0(Element element) {
        if (this.D3 != null) {
            this.D3 = null;
            this.s3.r0((Phrase) null);
        }
        if (element instanceof PdfPTable) {
            ((PdfPTable) element).T0(false);
        } else if (element instanceof PdfDiv) {
            Iterator<Element> it2 = ((PdfDiv) element).k().iterator();
            while (it2.hasNext()) {
                Element next = it2.next();
                if (next instanceof PdfPTable) {
                    ((PdfPTable) next).T0(false);
                }
            }
        }
        this.s3.a(element);
    }

    public void D1(float f2) {
        this.s3.e0(f2);
    }

    public void E0(PdfPHeaderCell pdfPHeaderCell) {
        if (this.P3 == null) {
            this.P3 = new ArrayList<>();
        }
        this.P3.add(pdfPHeaderCell);
    }

    public void E1(float f2, float f3) {
        this.s3.i0(f2, f3);
    }

    public int F0() {
        return this.s3.m();
    }

    public void F1(float f2) {
        this.A3 = f2;
        this.y3 = 0.0f;
    }

    public float G0() {
        return this.B3;
    }

    public void G1(boolean z) {
        this.C3 = z;
    }

    public float H0() {
        return this.z3;
    }

    public void H1(float f2) {
        this.x3 = f2;
        this.w3 = f2;
        this.u3 = f2;
        this.v3 = f2;
    }

    public PdfPCellEvent I0() {
        return this.H3;
    }

    public void I1(float f2) {
        this.x3 = f2;
    }

    public int J0() {
        return this.E3;
    }

    public void J1(float f2) {
        this.u3 = f2;
    }

    public ColumnText K0() {
        return this.s3;
    }

    public void K1(float f2) {
        this.v3 = f2;
    }

    public PdfName L() {
        return this.M3;
    }

    public List<Element> L0() {
        return K0().J;
    }

    public void L1(Phrase phrase) {
        this.D3 = null;
        this.G3 = null;
        ColumnText columnText = this.s3;
        this.K3 = phrase;
        columnText.r0(phrase);
    }

    public void M(float f2) {
        this.w3 = f2;
    }

    public float M0() {
        if (!r1()) {
            return this.x3;
        }
        return this.x3 + (A() / (d0() ? 1.0f : 2.0f));
    }

    public void M1(float f2) {
        this.s3.j0(f2);
    }

    public float N0() {
        if (!r1()) {
            return this.u3;
        }
        return this.u3 + (C() / (d0() ? 1.0f : 2.0f));
    }

    public void N1(int i2) {
        this.F3 = i2;
    }

    public float O0() {
        if (!r1()) {
            return this.v3;
        }
        return this.v3 + (F() / (d0() ? 1.0f : 2.0f));
    }

    public void O1(int i2) {
        this.s3.k0(i2);
    }

    public float P0() {
        if (!r1()) {
            return this.w3;
        }
        return this.w3 + (G() / (d0() ? 1.0f : 2.0f));
    }

    public void P1(float f2) {
        this.s3.q0(f2);
    }

    public float Q0() {
        return this.s3.s();
    }

    /* access modifiers changed from: package-private */
    public void Q1(PdfPTable pdfPTable) {
        this.D3 = pdfPTable;
        this.s3.r0((Phrase) null);
        this.G3 = null;
        if (pdfPTable != null) {
            pdfPTable.H0(this.t3 == 4);
            this.s3.a(pdfPTable);
            pdfPTable.Z0(100.0f);
        }
    }

    public float R0() {
        return this.y3;
    }

    public void R1(boolean z) {
        this.s3.s0(z);
    }

    public int S() {
        return this.L3;
    }

    public float S0() {
        return this.s3.u();
    }

    public void S1(boolean z) {
        this.J3 = z;
    }

    public ArrayList<PdfPHeaderCell> T0() {
        return this.P3;
    }

    public void T1(boolean z) {
        this.I3 = z;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.N3 == null) {
            this.N3 = new HashMap<>();
        }
        this.N3.put(pdfName, pdfObject);
    }

    public int U0() {
        return this.s3.l();
    }

    public void U1(int i2) {
        PdfPTable pdfPTable = this.D3;
        if (pdfPTable != null) {
            pdfPTable.H0(i2 == 4);
        }
        this.t3 = i2;
    }

    public Image V0() {
        return this.G3;
    }

    public float W0() {
        return this.s3.v();
    }

    public float X() {
        return this.w3;
    }

    public float X0() {
        return this.s3.y();
    }

    public float Y0() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        boolean z = S() == 90 || S() == 270;
        Image V0 = V0();
        float f7 = 0.0f;
        if (V0 != null) {
            V0.R1(100.0f);
            V0.R1(((((Q() - O0()) - N0()) - O()) / (z ? V0.o1() : V0.p1())) * 100.0f);
            u0(((T() - P0()) - M0()) - (z ? V0.p1() : V0.o1()));
        } else {
            if ((!z || !n1()) && K0() != null) {
                ColumnText g2 = ColumnText.g(K0());
                float f8 = 20000.0f;
                if (z) {
                    f6 = Q() - O0();
                    f4 = O() + N0();
                    f5 = 0.0f;
                } else {
                    if (!p1()) {
                        f8 = Q() - O0();
                    }
                    f6 = T() - P0();
                    f5 = O() + N0();
                    f4 = m1() ? (T() + M0()) - H0() : -1.07374182E9f;
                }
                PdfPRow.s(g2, f5, f4, f8, f6);
                try {
                    g2.J(true);
                    if (z) {
                        f3 = (T() - P0()) - M0();
                        f2 = g2.t();
                    } else {
                        f3 = g2.H();
                        if (s1()) {
                            f3 += g2.r();
                        }
                        f2 = M0();
                    }
                } catch (DocumentException e2) {
                    throw new ExceptionConverter(e2);
                }
            } else {
                f3 = T();
                f2 = R0();
            }
            u0(f3 - f2);
        }
        float N = N();
        if (N != P0() + M0()) {
            f7 = N;
        }
        if (n1()) {
            f7 = R0();
        } else if (o1() && f7 < Z0()) {
            f7 = Z0();
        }
        this.B3 = f7;
        return f7;
    }

    public float Z0() {
        return this.A3;
    }

    public float a1() {
        return this.s3.A();
    }

    public float b1() {
        return this.x3;
    }

    public float c1() {
        return this.u3;
    }

    public float d1() {
        return this.v3;
    }

    public Phrase e1() {
        return this.K3;
    }

    public float f1() {
        return this.s3.B();
    }

    public int g1() {
        return this.F3;
    }

    public AccessibleElementId getId() {
        return this.O3;
    }

    public int h1() {
        return this.s3.D();
    }

    public float i1() {
        return this.s3.E();
    }

    public PdfPTable j1() {
        return this.D3;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.N3;
    }

    public int k1() {
        return this.t3;
    }

    public boolean l1() {
        return this.B3 > 0.0f;
    }

    public boolean m1() {
        return H0() > 0.0f;
    }

    public boolean n() {
        return false;
    }

    public boolean n1() {
        return R0() > 0.0f;
    }

    public void o(PdfName pdfName) {
        this.M3 = pdfName;
    }

    public boolean o1() {
        return Z0() > 0.0f;
    }

    public boolean p1() {
        return this.C3;
    }

    public boolean q1() {
        return this.s3.R();
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.N3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public boolean r1() {
        return this.J3;
    }

    public boolean s1() {
        return this.I3;
    }

    public void t1(int i2) {
        this.s3.W(i2);
    }

    public void u1(float f2) {
        this.z3 = f2;
    }

    public void v1(PdfPCellEvent pdfPCellEvent) {
        if (pdfPCellEvent == null) {
            pdfPCellEvent = null;
        } else {
            PdfPCellEvent pdfPCellEvent2 = this.H3;
            if (pdfPCellEvent2 != null) {
                if (pdfPCellEvent2 instanceof PdfPCellEventForwarder) {
                    ((PdfPCellEventForwarder) pdfPCellEvent2).b(pdfPCellEvent);
                    return;
                }
                PdfPCellEventForwarder pdfPCellEventForwarder = new PdfPCellEventForwarder();
                pdfPCellEventForwarder.b(this.H3);
                pdfPCellEventForwarder.b(pdfPCellEvent);
                this.H3 = pdfPCellEventForwarder;
                return;
            }
        }
        this.H3 = pdfPCellEvent;
    }

    public void w1(int i2) {
        this.E3 = i2;
    }

    public void x1(ColumnText columnText) {
        this.s3 = columnText;
    }

    public void y0(int i2) {
        int i3 = i2 % 360;
        if (i3 < 0) {
            i3 += 360;
        }
        if (i3 % 90 == 0) {
            this.L3 = i3;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("rotation.must.be.a.multiple.of.90", new Object[0]));
    }

    public void y1(float f2) {
        this.s3.a0(f2);
    }

    public void z1(float f2) {
        this.y3 = f2;
        this.A3 = 0.0f;
    }

    public PdfPCell(Image image) {
        this(image, false);
    }

    public PdfPCell(Image image, boolean z) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.s3 = new ColumnText((PdfContentByte) null);
        this.t3 = 4;
        this.u3 = 2.0f;
        this.v3 = 2.0f;
        this.w3 = 2.0f;
        this.x3 = 2.0f;
        this.y3 = 0.0f;
        this.z3 = 0.0f;
        this.C3 = false;
        this.E3 = 1;
        this.F3 = 1;
        this.I3 = false;
        this.J3 = false;
        this.M3 = PdfName.Nf;
        this.N3 = null;
        this.O3 = new AccessibleElementId();
        this.P3 = null;
        this.b3 = 0.5f;
        this.Z2 = 15;
        this.s3.i0(0.0f, 1.0f);
        if (z) {
            this.G3 = image;
            H1(this.b3 / 2.0f);
            return;
        }
        image.o2(false);
        ColumnText columnText = this.s3;
        Phrase phrase = new Phrase(new Chunk(image, 0.0f, 0.0f, true));
        this.K3 = phrase;
        columnText.c(phrase);
        H1(0.0f);
    }

    public PdfPCell(Phrase phrase) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.s3 = new ColumnText((PdfContentByte) null);
        this.t3 = 4;
        this.u3 = 2.0f;
        this.v3 = 2.0f;
        this.w3 = 2.0f;
        this.x3 = 2.0f;
        this.y3 = 0.0f;
        this.z3 = 0.0f;
        this.C3 = false;
        this.E3 = 1;
        this.F3 = 1;
        this.I3 = false;
        this.J3 = false;
        this.M3 = PdfName.Nf;
        this.N3 = null;
        this.O3 = new AccessibleElementId();
        this.P3 = null;
        this.b3 = 0.5f;
        this.Z2 = 15;
        ColumnText columnText = this.s3;
        this.K3 = phrase;
        columnText.c(phrase);
        this.s3.i0(0.0f, 1.0f);
    }

    public PdfPCell(PdfPCell pdfPCell) {
        super(pdfPCell.s, pdfPCell.X, pdfPCell.Y, pdfPCell.Z);
        this.s3 = new ColumnText((PdfContentByte) null);
        this.t3 = 4;
        this.u3 = 2.0f;
        this.v3 = 2.0f;
        this.w3 = 2.0f;
        this.x3 = 2.0f;
        this.y3 = 0.0f;
        this.z3 = 0.0f;
        this.C3 = false;
        this.E3 = 1;
        this.F3 = 1;
        this.I3 = false;
        this.J3 = false;
        this.M3 = PdfName.Nf;
        this.N3 = null;
        this.O3 = new AccessibleElementId();
        this.P3 = null;
        f(pdfPCell);
        this.t3 = pdfPCell.t3;
        this.u3 = pdfPCell.u3;
        this.v3 = pdfPCell.v3;
        this.w3 = pdfPCell.w3;
        this.x3 = pdfPCell.x3;
        this.K3 = pdfPCell.K3;
        this.y3 = pdfPCell.y3;
        this.A3 = pdfPCell.A3;
        this.C3 = pdfPCell.C3;
        this.E3 = pdfPCell.E3;
        this.F3 = pdfPCell.F3;
        if (pdfPCell.D3 != null) {
            this.D3 = new PdfPTable(pdfPCell.D3);
        }
        this.G3 = Image.Y0(pdfPCell.G3);
        this.H3 = pdfPCell.H3;
        this.I3 = pdfPCell.I3;
        this.s3 = ColumnText.g(pdfPCell.s3);
        this.J3 = pdfPCell.J3;
        this.L3 = pdfPCell.L3;
        this.O3 = pdfPCell.O3;
        this.M3 = pdfPCell.M3;
        if (pdfPCell.N3 != null) {
            this.N3 = new HashMap<>(pdfPCell.N3);
        }
        this.P3 = pdfPCell.P3;
    }

    public PdfPCell(PdfPTable pdfPTable) {
        this(pdfPTable, (PdfPCell) null);
    }

    public PdfPCell(PdfPTable pdfPTable, PdfPCell pdfPCell) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.s3 = new ColumnText((PdfContentByte) null);
        this.t3 = 4;
        this.u3 = 2.0f;
        this.v3 = 2.0f;
        this.w3 = 2.0f;
        this.x3 = 2.0f;
        this.y3 = 0.0f;
        this.z3 = 0.0f;
        this.C3 = false;
        this.E3 = 1;
        this.F3 = 1;
        this.I3 = false;
        this.J3 = false;
        this.M3 = PdfName.Nf;
        this.N3 = null;
        this.O3 = new AccessibleElementId();
        this.P3 = null;
        this.b3 = 0.5f;
        this.Z2 = 15;
        this.s3.i0(0.0f, 1.0f);
        this.D3 = pdfPTable;
        pdfPTable.Z0(100.0f);
        pdfPTable.H0(true);
        this.s3.a(pdfPTable);
        if (pdfPCell != null) {
            f(pdfPCell);
            this.t3 = pdfPCell.t3;
            this.u3 = pdfPCell.u3;
            this.v3 = pdfPCell.v3;
            this.w3 = pdfPCell.w3;
            this.x3 = pdfPCell.x3;
            this.E3 = pdfPCell.E3;
            this.F3 = pdfPCell.F3;
            this.H3 = pdfPCell.H3;
            this.I3 = pdfPCell.I3;
            this.J3 = pdfPCell.J3;
            this.L3 = pdfPCell.L3;
            return;
        }
        H1(0.0f);
    }
}
