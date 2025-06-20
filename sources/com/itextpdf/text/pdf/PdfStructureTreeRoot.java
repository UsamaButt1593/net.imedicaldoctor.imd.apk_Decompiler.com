package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.interfaces.IPdfStructureElement;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PdfStructureTreeRoot extends PdfDictionary implements IPdfStructureElement {
    private HashMap<Integer, PdfObject> p3 = new HashMap<>();
    private PdfIndirectReference q3;
    private PdfDictionary r3 = null;
    protected HashMap<PdfName, PdfObject> s3 = null;
    private HashMap<Integer, PdfIndirectReference> t3 = null;
    private HashMap<String, PdfObject> u3;
    private PdfWriter v3;

    PdfStructureTreeRoot(PdfWriter pdfWriter) {
        super(PdfName.xf);
        this.v3 = pdfWriter;
        this.q3 = pdfWriter.D1();
    }

    private void i1() throws IOException {
        HashMap<Integer, PdfIndirectReference> hashMap;
        PdfIndirectReference pdfIndirectReference;
        if (this.t3 == null) {
            this.t3 = new HashMap<>();
            for (Integer next : this.p3.keySet()) {
                PdfObject pdfObject = this.p3.get(next);
                if (pdfObject.q()) {
                    hashMap = this.t3;
                    pdfIndirectReference = this.v3.v0((PdfArray) pdfObject).a();
                } else if (pdfObject instanceof PdfIndirectReference) {
                    hashMap = this.t3;
                    pdfIndirectReference = (PdfIndirectReference) pdfObject;
                }
                hashMap.put(next, pdfIndirectReference);
            }
        }
    }

    public PdfObject b(PdfName pdfName) {
        PdfDictionary j0 = j0(PdfName.k3);
        if (j0 == null || !j0.a0(pdfName)) {
            return null;
        }
        return j0.d0(pdfName);
    }

    /* access modifiers changed from: package-private */
    public void f1() throws IOException {
        i1();
        PdfDictionary c2 = PdfNumberTree.c(this.t3, this.v3);
        if (c2 != null) {
            V0(PdfName.Ec, this.v3.v0(c2).a());
        }
        if (this.r3 != null && !this.s3.isEmpty()) {
            for (Map.Entry next : this.s3.entrySet()) {
                PdfObject pdfObject = (PdfObject) next.getValue();
                if (pdfObject.z()) {
                    this.r3.V0((PdfName) next.getKey(), this.v3.v0(pdfObject).a());
                } else if (pdfObject.q()) {
                    PdfArray pdfArray = new PdfArray();
                    PdfArray pdfArray2 = (PdfArray) pdfObject;
                    for (int i2 = 0; i2 < pdfArray2.size(); i2++) {
                        if (pdfArray2.T0(i2).z()) {
                            pdfArray.a0(this.v3.v0(pdfArray2.B0(i2)).a());
                        }
                    }
                    this.r3.V0((PdfName) next.getKey(), pdfArray);
                }
            }
            V0(PdfName.o5, this.v3.v0(this.r3).a());
        }
        HashMap<String, PdfObject> hashMap = this.u3;
        if (hashMap != null && !hashMap.isEmpty()) {
            V0(PdfName.C9, PdfNameTree.c(this.u3, this.v3));
        }
        this.v3.y0(this, this.q3);
    }

    public void h(PdfName pdfName, PdfObject pdfObject) {
        PdfName pdfName2 = PdfName.k3;
        PdfDictionary j0 = j0(pdfName2);
        if (j0 == null) {
            j0 = new PdfDictionary();
            V0(pdfName2, j0);
        }
        j0.V0(pdfName, pdfObject);
    }

    public PdfObject m1(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.s3;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(pdfName);
    }

    public HashMap<Integer, PdfIndirectReference> n1() throws IOException {
        if (this.t3 == null) {
            i1();
        }
        return this.t3;
    }

    public PdfIndirectReference o1() {
        return this.q3;
    }

    public PdfWriter p1() {
        return this.v3;
    }

    public void q1(PdfName pdfName, PdfObject pdfObject) {
        if (this.r3 == null) {
            this.r3 = new PdfDictionary();
            this.s3 = new HashMap<>();
        }
        this.s3.put(pdfName, pdfObject);
    }

    public void s1(PdfName pdfName, PdfName pdfName2) {
        PdfName pdfName3 = PdfName.re;
        PdfDictionary pdfDictionary = (PdfDictionary) d0(pdfName3);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            V0(pdfName3, pdfDictionary);
        }
        pdfDictionary.V0(pdfName, pdfName2);
    }

    /* access modifiers changed from: package-private */
    public void v1(String str, PdfObject pdfObject) {
        if (this.u3 == null) {
            this.u3 = new HashMap<>();
        }
        this.u3.put(str, pdfObject);
    }

    /* access modifiers changed from: package-private */
    public void w1(int i2, PdfIndirectReference pdfIndirectReference) {
        this.p3.put(Integer.valueOf(i2), pdfIndirectReference);
    }

    /* access modifiers changed from: package-private */
    public void x1(int i2, PdfIndirectReference pdfIndirectReference) {
        Integer valueOf = Integer.valueOf(i2);
        PdfArray pdfArray = (PdfArray) this.p3.get(valueOf);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            this.p3.put(valueOf, pdfArray);
        }
        pdfArray.a0(pdfIndirectReference);
    }
}
