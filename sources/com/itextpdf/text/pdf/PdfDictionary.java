package com.itextpdf.text.pdf;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PdfDictionary extends PdfObject {
    public static final PdfName k3 = PdfName.l8;
    public static final PdfName l3 = PdfName.nc;
    public static final PdfName m3 = PdfName.uc;
    public static final PdfName n3 = PdfName.zc;
    public static final PdfName o3 = PdfName.U4;
    private PdfName i3;
    protected LinkedHashMap<PdfName, PdfObject> j3;

    public PdfDictionary() {
        super(6);
        this.i3 = null;
        this.j3 = new LinkedHashMap<>();
    }

    public PdfString A0(PdfName pdfName) {
        PdfObject B0 = B0(pdfName);
        if (B0 == null || !B0.N()) {
            return null;
        }
        return (PdfString) B0;
    }

    public PdfObject B0(PdfName pdfName) {
        return PdfReader.t0(d0(pdfName));
    }

    public Set<PdfName> G0() {
        return this.j3.keySet();
    }

    public boolean I0() {
        return Z(o3);
    }

    public boolean J0() {
        return Z(k3);
    }

    public boolean N0() {
        return Z(l3);
    }

    public boolean P0() {
        return Z(m3);
    }

    public boolean Q0() {
        return Z(n3);
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 11, this);
        outputStream.write(60);
        outputStream.write(60);
        for (Map.Entry next : this.j3.entrySet()) {
            ((PdfName) next.getKey()).T(pdfWriter, outputStream);
            PdfObject pdfObject = (PdfObject) next.getValue();
            int W = pdfObject.W();
            if (!(W == 5 || W == 6 || W == 4 || W == 3)) {
                outputStream.write(32);
            }
            pdfObject.T(pdfWriter, outputStream);
        }
        outputStream.write(62);
        outputStream.write(62);
    }

    public void T0(PdfDictionary pdfDictionary) {
        this.j3.putAll(pdfDictionary.j3);
    }

    public void U0(PdfDictionary pdfDictionary) {
        for (PdfName next : pdfDictionary.j3.keySet()) {
            if (!this.j3.containsKey(next)) {
                this.j3.put(next, pdfDictionary.j3.get(next));
            }
        }
    }

    public void V0(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.H()) {
            this.j3.remove(pdfName);
        } else {
            this.j3.put(pdfName, pdfObject);
        }
    }

    public void X0(PdfDictionary pdfDictionary) {
        this.j3.putAll(pdfDictionary.j3);
    }

    public boolean Z(PdfName pdfName) {
        if (pdfName == null) {
            return false;
        }
        if (this.i3 == null) {
            this.i3 = p0(PdfName.Kg);
        }
        return pdfName.equals(this.i3);
    }

    public void Z0(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject != null) {
            V0(pdfName, pdfObject);
        }
    }

    public boolean a0(PdfName pdfName) {
        return this.j3.containsKey(pdfName);
    }

    public void a1(PdfName pdfName) {
        this.j3.remove(pdfName);
    }

    public void clear() {
        this.j3.clear();
    }

    public PdfObject d0(PdfName pdfName) {
        return this.j3.get(pdfName);
    }

    public PdfArray e0(PdfName pdfName) {
        PdfObject B0 = B0(pdfName);
        if (B0 == null || !B0.q()) {
            return null;
        }
        return (PdfArray) B0;
    }

    public PdfBoolean i0(PdfName pdfName) {
        PdfObject B0 = B0(pdfName);
        if (B0 == null || !B0.x()) {
            return null;
        }
        return (PdfBoolean) B0;
    }

    public PdfDictionary j0(PdfName pdfName) {
        PdfObject B0 = B0(pdfName);
        if (B0 == null || !B0.z()) {
            return null;
        }
        return (PdfDictionary) B0;
    }

    public PdfIndirectReference m0(PdfName pdfName) {
        PdfObject d0 = d0(pdfName);
        if (d0 == null || !d0.C()) {
            return null;
        }
        return (PdfIndirectReference) d0;
    }

    public PdfName p0(PdfName pdfName) {
        PdfObject B0 = B0(pdfName);
        if (B0 == null || !B0.E()) {
            return null;
        }
        return (PdfName) B0;
    }

    public PdfNumber q0(PdfName pdfName) {
        PdfObject B0 = B0(pdfName);
        if (B0 == null || !B0.I()) {
            return null;
        }
        return (PdfNumber) B0;
    }

    public int size() {
        return this.j3.size();
    }

    public String toString() {
        PdfName pdfName = PdfName.Kg;
        if (d0(pdfName) == null) {
            return "Dictionary";
        }
        return "Dictionary of type: " + d0(pdfName);
    }

    public PdfStream x0(PdfName pdfName) {
        PdfObject B0 = B0(pdfName);
        if (B0 == null || !B0.K()) {
            return null;
        }
        return (PdfStream) B0;
    }

    public PdfDictionary(int i2) {
        super(6);
        this.i3 = null;
        this.j3 = new LinkedHashMap<>(i2);
    }

    public PdfDictionary(PdfName pdfName) {
        this();
        this.i3 = pdfName;
        V0(PdfName.Kg, pdfName);
    }
}
