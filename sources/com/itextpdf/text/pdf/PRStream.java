package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class PRStream extends PdfStream {
    protected PdfReader E3;
    protected long F3;
    protected int G3;
    protected int H3;
    protected int I3;

    public PRStream(PRStream pRStream, PdfDictionary pdfDictionary) {
        this.H3 = 0;
        this.I3 = 0;
        this.E3 = pRStream.E3;
        this.F3 = pRStream.F3;
        this.G3 = pRStream.G3;
        this.p3 = pRStream.p3;
        this.q3 = pRStream.q3;
        this.r3 = pRStream.r3;
        this.s = pRStream.s;
        this.H3 = pRStream.H3;
        this.I3 = pRStream.I3;
        if (pdfDictionary != null) {
            X0(pdfDictionary);
        } else {
            this.j3.putAll(pRStream.j3);
        }
    }

    public void B1(byte[] bArr) {
        E1(bArr, true);
    }

    public void E1(byte[] bArr, boolean z) {
        G1(bArr, z, -1);
    }

    public void G1(byte[] bArr, boolean z, int i2) {
        PdfName pdfName = PdfName.T7;
        a1(pdfName);
        this.F3 = -1;
        if (!Document.l3 || !z) {
            this.s = bArr;
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i2);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                this.s = byteArrayOutputStream.toByteArray();
                this.q3 = i2;
                V0(pdfName, PdfName.j8);
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        }
        J1(this.s.length);
    }

    public void I1(byte[] bArr) {
        this.F3 = -1;
        this.s = bArr;
        J1(bArr.length);
    }

    public void J1(int i2) {
        this.G3 = i2;
        V0(PdfName.va, new PdfNumber(i2));
    }

    public void K1(int i2, int i3) {
        this.H3 = i2;
        this.I3 = i3;
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        byte[] F0 = PdfReader.F0(this);
        PdfEncryption i1 = pdfWriter != null ? pdfWriter.i1() : null;
        PdfName pdfName = PdfName.va;
        PdfObject d0 = d0(pdfName);
        int length = F0.length;
        if (i1 != null) {
            length = i1.b(length);
        }
        V0(pdfName, new PdfNumber(length));
        n1(pdfWriter, outputStream);
        V0(pdfName, d0);
        outputStream.write(PdfStream.B3);
        if (this.G3 > 0) {
            if (i1 != null && !i1.p()) {
                F0 = i1.i(F0);
            }
            outputStream.write(F0);
        }
        outputStream.write(PdfStream.C3);
    }

    public byte[] k() {
        return this.s;
    }

    public int q1() {
        return this.G3;
    }

    /* access modifiers changed from: package-private */
    public int s1() {
        return this.I3;
    }

    /* access modifiers changed from: package-private */
    public int v1() {
        return this.H3;
    }

    public long w1() {
        return this.F3;
    }

    public PdfReader x1() {
        return this.E3;
    }

    public PRStream(PRStream pRStream, PdfDictionary pdfDictionary, PdfReader pdfReader) {
        this(pRStream, pdfDictionary);
        this.E3 = pdfReader;
    }

    public PRStream(PdfReader pdfReader, long j2) {
        this.H3 = 0;
        this.I3 = 0;
        this.E3 = pdfReader;
        this.F3 = j2;
    }

    public PRStream(PdfReader pdfReader, byte[] bArr) {
        this(pdfReader, bArr, -1);
    }

    public PRStream(PdfReader pdfReader, byte[] bArr, int i2) {
        this.H3 = 0;
        this.I3 = 0;
        this.E3 = pdfReader;
        this.F3 = -1;
        if (Document.l3) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i2);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                this.s = byteArrayOutputStream.toByteArray();
                V0(PdfName.T7, PdfName.j8);
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            this.s = bArr;
        }
        J1(this.s.length);
    }
}
