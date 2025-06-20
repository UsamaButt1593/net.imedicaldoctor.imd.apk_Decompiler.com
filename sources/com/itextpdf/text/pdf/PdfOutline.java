package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Paragraph;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class PdfOutline extends PdfDictionary {
    private PdfIndirectReference p3;
    private int q3;
    private PdfOutline r3;
    private PdfDestination s3;
    private PdfAction t3;
    protected ArrayList<PdfOutline> u3;
    protected PdfWriter v3;
    private String w3;
    private boolean x3;
    private BaseColor y3;
    private int z3;

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, Paragraph paragraph) {
        this(pdfOutline, pdfAction, paragraph, true);
    }

    public PdfOutline B1() {
        return this.r3;
    }

    public void E1(BaseColor baseColor) {
        this.y3 = baseColor;
    }

    /* access modifiers changed from: package-private */
    public void G1(int i2) {
        this.q3 = i2;
    }

    public boolean I1(PdfIndirectReference pdfIndirectReference) {
        PdfDestination pdfDestination = this.s3;
        if (pdfDestination == null) {
            return false;
        }
        return pdfDestination.X0(pdfIndirectReference);
    }

    public void J1(PdfIndirectReference pdfIndirectReference) {
        this.p3 = pdfIndirectReference;
    }

    public void K1(ArrayList<PdfOutline> arrayList) {
        this.u3 = arrayList;
    }

    public void L1(boolean z) {
        this.x3 = z;
    }

    public void M1(int i2) {
        this.z3 = i2;
    }

    public void N1(String str) {
        this.w3 = str;
    }

    public void P1(String str) {
        V0(PdfName.ig, new PdfString(str, PdfObject.h3));
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        int i2 = 0;
        BaseColor baseColor = this.y3;
        if (baseColor != null && !baseColor.equals(BaseColor.f25677f)) {
            V0(PdfName.K4, new PdfArray(new float[]{((float) this.y3.g()) / 255.0f, ((float) this.y3.e()) / 255.0f, ((float) this.y3.d()) / 255.0f}));
        }
        int i3 = this.z3;
        if ((i3 & 1) != 0) {
            i2 = 2;
        }
        if ((2 & i3) != 0) {
            i2 |= 1;
        }
        if (i2 != 0) {
            V0(PdfName.F7, new PdfNumber(i2));
        }
        PdfOutline pdfOutline = this.r3;
        if (pdfOutline != null) {
            V0(PdfName.Dc, pdfOutline.s1());
        }
        PdfDestination pdfDestination = this.s3;
        if (pdfDestination != null && pdfDestination.Z0()) {
            V0(PdfName.x6, this.s3);
        }
        PdfAction pdfAction = this.t3;
        if (pdfAction != null) {
            V0(PdfName.k3, pdfAction);
        }
        int i4 = this.q3;
        if (i4 != 0) {
            V0(PdfName.P5, new PdfNumber(i4));
        }
        super.T(pdfWriter, outputStream);
    }

    public void f1(PdfOutline pdfOutline) {
        this.u3.add(pdfOutline);
    }

    /* access modifiers changed from: package-private */
    public int getCount() {
        return this.q3;
    }

    public BaseColor i1() {
        return this.y3;
    }

    public ArrayList<PdfOutline> m1() {
        return this.u3;
    }

    public PdfDestination n1() {
        return this.s3;
    }

    public int o1() {
        return this.z3;
    }

    public String p1() {
        return this.w3;
    }

    public String q1() {
        return ((PdfString) d0(PdfName.ig)).toString();
    }

    public PdfIndirectReference s1() {
        return this.p3;
    }

    /* access modifiers changed from: package-private */
    public void v1(PdfOutline pdfOutline, String str, boolean z) {
        this.x3 = z;
        this.r3 = pdfOutline;
        this.v3 = pdfOutline.v3;
        V0(PdfName.ig, new PdfString(str, PdfObject.h3));
        pdfOutline.f1(this);
        PdfDestination pdfDestination = this.s3;
        if (pdfDestination != null && !pdfDestination.Z0()) {
            I1(this.v3.d1());
        }
    }

    public boolean w1() {
        return this.x3;
    }

    public int x1() {
        PdfOutline pdfOutline = this.r3;
        if (pdfOutline == null) {
            return 0;
        }
        return pdfOutline.x1() + 1;
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, Paragraph paragraph, boolean z) {
        this.q3 = 0;
        this.u3 = new ArrayList<>();
        this.z3 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (Chunk j2 : paragraph.Y()) {
            stringBuffer.append(j2.j());
        }
        this.t3 = pdfAction;
        v1(pdfOutline, stringBuffer.toString(), z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, PdfString pdfString) {
        this(pdfOutline, pdfAction, pdfString, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, PdfString pdfString, boolean z) {
        this(pdfOutline, pdfAction, pdfString.toString(), z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, String str) {
        this(pdfOutline, pdfAction, str, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, String str, boolean z) {
        this.q3 = 0;
        this.u3 = new ArrayList<>();
        this.z3 = 0;
        this.t3 = pdfAction;
        v1(pdfOutline, str, z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, Paragraph paragraph) {
        this(pdfOutline, pdfDestination, paragraph, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, Paragraph paragraph, boolean z) {
        this.q3 = 0;
        this.u3 = new ArrayList<>();
        this.z3 = 0;
        StringBuffer stringBuffer = new StringBuffer();
        for (Chunk j2 : paragraph.Y()) {
            stringBuffer.append(j2.j());
        }
        this.s3 = pdfDestination;
        v1(pdfOutline, stringBuffer.toString(), z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, PdfString pdfString) {
        this(pdfOutline, pdfDestination, pdfString, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, PdfString pdfString, boolean z) {
        this(pdfOutline, pdfDestination, pdfString.toString(), true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, String str) {
        this(pdfOutline, pdfDestination, str, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, String str, boolean z) {
        this.q3 = 0;
        this.u3 = new ArrayList<>();
        this.z3 = 0;
        this.s3 = pdfDestination;
        v1(pdfOutline, str, z);
    }

    PdfOutline(PdfWriter pdfWriter) {
        super(PdfDictionary.l3);
        this.q3 = 0;
        this.u3 = new ArrayList<>();
        this.z3 = 0;
        this.x3 = true;
        this.r3 = null;
        this.v3 = pdfWriter;
    }
}
