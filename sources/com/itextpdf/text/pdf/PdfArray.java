package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PdfArray extends PdfObject implements Iterable<PdfObject> {
    protected ArrayList<PdfObject> i3;

    public PdfArray() {
        super(5);
        this.i3 = new ArrayList<>();
    }

    public PdfBoolean A0(int i2) {
        PdfObject Q0 = Q0(i2);
        if (Q0 == null || !Q0.x()) {
            return null;
        }
        return (PdfBoolean) Q0;
    }

    public PdfDictionary B0(int i2) {
        PdfObject Q0 = Q0(i2);
        if (Q0 == null || !Q0.z()) {
            return null;
        }
        return (PdfDictionary) Q0;
    }

    public PdfIndirectReference G0(int i2) {
        PdfObject T0 = T0(i2);
        if (T0 instanceof PdfIndirectReference) {
            return (PdfIndirectReference) T0;
        }
        return null;
    }

    public PdfName I0(int i2) {
        PdfObject Q0 = Q0(i2);
        if (Q0 == null || !Q0.E()) {
            return null;
        }
        return (PdfName) Q0;
    }

    public PdfNumber J0(int i2) {
        PdfObject Q0 = Q0(i2);
        if (Q0 == null || !Q0.I()) {
            return null;
        }
        return (PdfNumber) Q0;
    }

    public PdfStream N0(int i2) {
        PdfObject Q0 = Q0(i2);
        if (Q0 == null || !Q0.K()) {
            return null;
        }
        return (PdfStream) Q0;
    }

    public PdfString P0(int i2) {
        PdfObject Q0 = Q0(i2);
        if (Q0 == null || !Q0.N()) {
            return null;
        }
        return (PdfString) Q0;
    }

    public PdfObject Q0(int i2) {
        return PdfReader.t0(T0(i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void T(com.itextpdf.text.pdf.PdfWriter r5, java.io.OutputStream r6) throws java.io.IOException {
        /*
            r4 = this;
            r0 = 11
            com.itextpdf.text.pdf.PdfWriter.G0(r5, r0, r4)
            r0 = 91
            r6.write(r0)
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r0 = r4.i3
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0023
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.PdfObject r1 = (com.itextpdf.text.pdf.PdfObject) r1
            if (r1 != 0) goto L_0x0020
            com.itextpdf.text.pdf.PdfNull r1 = com.itextpdf.text.pdf.PdfNull.i3
        L_0x0020:
            r1.T(r5, r6)
        L_0x0023:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0049
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.PdfObject r1 = (com.itextpdf.text.pdf.PdfObject) r1
            if (r1 != 0) goto L_0x0033
            com.itextpdf.text.pdf.PdfNull r1 = com.itextpdf.text.pdf.PdfNull.i3
        L_0x0033:
            int r2 = r1.W()
            r3 = 5
            if (r2 == r3) goto L_0x0020
            r3 = 6
            if (r2 == r3) goto L_0x0020
            r3 = 4
            if (r2 == r3) goto L_0x0020
            r3 = 3
            if (r2 == r3) goto L_0x0020
            r2 = 32
            r6.write(r2)
            goto L_0x0020
        L_0x0049:
            r5 = 93
            r6.write(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfArray.T(com.itextpdf.text.pdf.PdfWriter, java.io.OutputStream):void");
    }

    public PdfObject T0(int i2) {
        return this.i3.get(i2);
    }

    public PdfObject U0(int i2) {
        return this.i3.remove(i2);
    }

    public PdfObject V0(int i2, PdfObject pdfObject) {
        return this.i3.set(i2, pdfObject);
    }

    public void Z(int i2, PdfObject pdfObject) {
        this.i3.add(i2, pdfObject);
    }

    public boolean a0(PdfObject pdfObject) {
        return this.i3.add(pdfObject);
    }

    public boolean d0(float[] fArr) {
        for (float pdfNumber : fArr) {
            this.i3.add(new PdfNumber(pdfNumber));
        }
        return true;
    }

    public boolean e0(int[] iArr) {
        for (int pdfNumber : iArr) {
            this.i3.add(new PdfNumber(pdfNumber));
        }
        return true;
    }

    public void i0(PdfObject pdfObject) {
        this.i3.add(0, pdfObject);
    }

    public boolean isEmpty() {
        return this.i3.isEmpty();
    }

    public Iterator<PdfObject> iterator() {
        return this.i3.iterator();
    }

    public double[] j0() {
        int size = size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = J0(i2).Z();
        }
        return dArr;
    }

    public ListIterator<PdfObject> listIterator() {
        return this.i3.listIterator();
    }

    public long[] m0() {
        int size = size();
        long[] jArr = new long[size];
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = J0(i2).i0();
        }
        return jArr;
    }

    public boolean p0(PdfObject pdfObject) {
        return this.i3.contains(pdfObject);
    }

    @Deprecated
    public ArrayList<PdfObject> q0() {
        return this.i3;
    }

    public int size() {
        return this.i3.size();
    }

    public String toString() {
        return this.i3.toString();
    }

    public PdfArray x0(int i2) {
        PdfObject Q0 = Q0(i2);
        if (Q0 == null || !Q0.q()) {
            return null;
        }
        return (PdfArray) Q0;
    }

    public PdfArray(int i2) {
        super(5);
        this.i3 = new ArrayList<>(i2);
    }

    public PdfArray(PdfArray pdfArray) {
        super(5);
        this.i3 = new ArrayList<>(pdfArray.i3);
    }

    public PdfArray(PdfObject pdfObject) {
        super(5);
        ArrayList<PdfObject> arrayList = new ArrayList<>();
        this.i3 = arrayList;
        arrayList.add(pdfObject);
    }

    public PdfArray(List<PdfObject> list) {
        this();
        for (PdfObject a0 : list) {
            a0(a0);
        }
    }

    public PdfArray(float[] fArr) {
        super(5);
        this.i3 = new ArrayList<>();
        d0(fArr);
    }

    public PdfArray(int[] iArr) {
        super(5);
        this.i3 = new ArrayList<>();
        e0(iArr);
    }
}
