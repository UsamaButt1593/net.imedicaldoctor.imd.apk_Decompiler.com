package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import java.io.IOException;
import java.io.OutputStream;

public class PdfIndirectObject {

    /* renamed from: e  reason: collision with root package name */
    static final byte[] f26227e;

    /* renamed from: f  reason: collision with root package name */
    static final byte[] f26228f;

    /* renamed from: g  reason: collision with root package name */
    static final int f26229g;

    /* renamed from: a  reason: collision with root package name */
    protected int f26230a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26231b;

    /* renamed from: c  reason: collision with root package name */
    protected PdfObject f26232c;

    /* renamed from: d  reason: collision with root package name */
    protected PdfWriter f26233d;

    static {
        byte[] E = DocWriter.E(" obj\n");
        f26227e = E;
        byte[] E2 = DocWriter.E("\nendobj\n");
        f26228f = E2;
        f26229g = E.length + E2.length;
    }

    PdfIndirectObject(int i2, int i3, PdfObject pdfObject, PdfWriter pdfWriter) {
        this.f26233d = pdfWriter;
        this.f26230a = i2;
        this.f26231b = i3;
        this.f26232c = pdfObject;
        PdfEncryption i1 = pdfWriter != null ? pdfWriter.i1() : null;
        if (i1 != null) {
            i1.u(i2, i3);
        }
    }

    public PdfIndirectReference a() {
        return new PdfIndirectReference(this.f26232c.W(), this.f26230a, this.f26231b);
    }

    /* access modifiers changed from: protected */
    public void b(OutputStream outputStream) throws IOException {
        outputStream.write(DocWriter.E(String.valueOf(this.f26230a)));
        outputStream.write(32);
        outputStream.write(DocWriter.E(String.valueOf(this.f26231b)));
        outputStream.write(f26227e);
        this.f26232c.T(this.f26233d, outputStream);
        outputStream.write(f26228f);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f26230a);
        stringBuffer.append(' ');
        stringBuffer.append(this.f26231b);
        stringBuffer.append(" R: ");
        PdfObject pdfObject = this.f26232c;
        stringBuffer.append(pdfObject != null ? pdfObject.toString() : "null");
        return stringBuffer.toString();
    }

    protected PdfIndirectObject(int i2, PdfObject pdfObject, PdfWriter pdfWriter) {
        this(i2, 0, pdfObject, pdfWriter);
    }

    PdfIndirectObject(PdfIndirectReference pdfIndirectReference, PdfObject pdfObject, PdfWriter pdfWriter) {
        this(pdfIndirectReference.d(), pdfIndirectReference.Z(), pdfObject, pdfWriter);
    }
}
