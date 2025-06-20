package com.itextpdf.text.pdf;

public class RefKey {

    /* renamed from: a  reason: collision with root package name */
    int f26388a;

    /* renamed from: b  reason: collision with root package name */
    int f26389b;

    RefKey(int i2, int i3) {
        this.f26388a = i2;
        this.f26389b = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof RefKey)) {
            return false;
        }
        RefKey refKey = (RefKey) obj;
        return this.f26389b == refKey.f26389b && this.f26388a == refKey.f26388a;
    }

    public int hashCode() {
        return (this.f26389b << 16) + this.f26388a;
    }

    public String toString() {
        return Integer.toString(this.f26388a) + ' ' + this.f26389b;
    }

    RefKey(PRIndirectReference pRIndirectReference) {
        this.f26388a = pRIndirectReference.d();
        this.f26389b = pRIndirectReference.Z();
    }

    public RefKey(PdfIndirectReference pdfIndirectReference) {
        this.f26388a = pdfIndirectReference.d();
        this.f26389b = pdfIndirectReference.Z();
    }
}
