package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;

public class ListBody implements IAccessibleElement {
    private AccessibleElementId X = null;
    protected HashMap<PdfName, PdfObject> Y = null;
    protected ListItem Z;
    protected PdfName s = PdfName.ua;

    protected ListBody(ListItem listItem) {
        this.Z = listItem;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.X = accessibleElementId;
    }

    public PdfName L() {
        return this.s;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.Y == null) {
            this.Y = new HashMap<>();
        }
        this.Y.put(pdfName, pdfObject);
    }

    public AccessibleElementId getId() {
        if (this.X == null) {
            this.X = new AccessibleElementId();
        }
        return this.X;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.Y;
    }

    public boolean n() {
        return false;
    }

    public void o(PdfName pdfName) {
        this.s = pdfName;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.Y;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }
}
