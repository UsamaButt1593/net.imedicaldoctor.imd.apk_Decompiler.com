package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;

public class PdfPTableBody implements IAccessibleElement {
    protected ArrayList<PdfPRow> X = null;
    protected PdfName Y = PdfName.Mf;
    protected HashMap<PdfName, PdfObject> Z = null;
    protected AccessibleElementId s = new AccessibleElementId();

    public void D(AccessibleElementId accessibleElementId) {
        this.s = accessibleElementId;
    }

    public PdfName L() {
        return this.Y;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.Z == null) {
            this.Z = new HashMap<>();
        }
        this.Z.put(pdfName, pdfObject);
    }

    public AccessibleElementId getId() {
        return this.s;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.Z;
    }

    public boolean n() {
        return false;
    }

    public void o(PdfName pdfName) {
        this.Y = pdfName;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.Z;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }
}
