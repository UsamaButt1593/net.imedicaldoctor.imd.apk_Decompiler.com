package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class PdfStream extends PdfDictionary {
    public static final int A3 = 9;
    static final byte[] B3;
    static final byte[] C3;
    static final int D3;
    public static final int x3 = -1;
    public static final int y3 = 0;
    public static final int z3 = 1;
    protected boolean p3 = false;
    protected int q3 = 0;
    protected ByteArrayOutputStream r3 = null;
    protected InputStream s3;
    protected PdfIndirectReference t3;
    protected int u3 = -1;
    protected PdfWriter v3;
    protected int w3;

    static {
        byte[] E = DocWriter.E("stream\n");
        B3 = E;
        byte[] E2 = DocWriter.E("\nendstream");
        C3 = E2;
        D3 = E.length + E2.length;
    }

    protected PdfStream() {
        this.X = 7;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.itextpdf.text.pdf.OutputStreamEncryption} */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r4.equals(r3.T0(0)) != false) goto L_0x002b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void T(com.itextpdf.text.pdf.PdfWriter r9, java.io.OutputStream r10) throws java.io.IOException {
        /*
            r8 = this;
            java.io.InputStream r0 = r8.s3
            if (r0 == 0) goto L_0x000f
            boolean r0 = r8.p3
            if (r0 == 0) goto L_0x000f
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.T7
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.j8
            r8.V0(r0, r1)
        L_0x000f:
            r0 = 0
            if (r9 == 0) goto L_0x0017
            com.itextpdf.text.pdf.PdfEncryption r1 = r9.i1()
            goto L_0x0018
        L_0x0017:
            r1 = r0
        L_0x0018:
            r2 = 0
            if (r1 == 0) goto L_0x0046
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.T7
            com.itextpdf.text.pdf.PdfObject r3 = r8.d0(r3)
            if (r3 == 0) goto L_0x0046
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.a6
            boolean r5 = r4.equals(r3)
            if (r5 == 0) goto L_0x002d
        L_0x002b:
            r1 = r0
            goto L_0x0046
        L_0x002d:
            boolean r5 = r3.q()
            if (r5 == 0) goto L_0x0046
            com.itextpdf.text.pdf.PdfArray r3 = (com.itextpdf.text.pdf.PdfArray) r3
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0046
            com.itextpdf.text.pdf.PdfObject r3 = r3.T0(r2)
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0046
            goto L_0x002b
        L_0x0046:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfObject r4 = r8.d0(r3)
            if (r1 == 0) goto L_0x0070
            if (r4 == 0) goto L_0x0070
            boolean r5 = r4.I()
            if (r5 == 0) goto L_0x0070
            r5 = r4
            com.itextpdf.text.pdf.PdfNumber r5 = (com.itextpdf.text.pdf.PdfNumber) r5
            int r5 = r5.e0()
            com.itextpdf.text.pdf.PdfNumber r6 = new com.itextpdf.text.pdf.PdfNumber
            int r5 = r1.b(r5)
            r6.<init>((int) r5)
            r8.V0(r3, r6)
            r8.n1(r9, r10)
            r8.V0(r3, r4)
            goto L_0x0073
        L_0x0070:
            r8.n1(r9, r10)
        L_0x0073:
            r3 = 9
            com.itextpdf.text.pdf.PdfWriter.G0(r9, r3, r8)
            byte[] r9 = B3
            r10.write(r9)
            java.io.InputStream r9 = r8.s3
            if (r9 == 0) goto L_0x00db
            r8.w3 = r2
            com.itextpdf.text.pdf.OutputStreamCounter r9 = new com.itextpdf.text.pdf.OutputStreamCounter
            r9.<init>(r10)
            if (r1 == 0) goto L_0x0096
            boolean r3 = r1.p()
            if (r3 != 0) goto L_0x0096
            com.itextpdf.text.pdf.OutputStreamEncryption r1 = r1.m(r9)
            r3 = r1
            goto L_0x0098
        L_0x0096:
            r1 = r9
            r3 = r0
        L_0x0098:
            boolean r4 = r8.p3
            if (r4 == 0) goto L_0x00af
            java.util.zip.Deflater r0 = new java.util.zip.Deflater
            int r4 = r8.q3
            r0.<init>(r4)
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream
            r5 = 32768(0x8000, float:4.5918E-41)
            r4.<init>(r1, r0, r5)
            r5 = r4
            r4 = r0
            r0 = r5
            goto L_0x00b1
        L_0x00af:
            r4 = r0
            r5 = r1
        L_0x00b1:
            r1 = 4192(0x1060, float:5.874E-42)
            byte[] r6 = new byte[r1]
        L_0x00b5:
            java.io.InputStream r1 = r8.s3
            int r1 = r1.read(r6)
            if (r1 > 0) goto L_0x00d2
            if (r0 == 0) goto L_0x00c5
            r0.finish()
            r4.end()
        L_0x00c5:
            if (r3 == 0) goto L_0x00ca
            r3.b()
        L_0x00ca:
            long r0 = r9.b()
            int r9 = (int) r0
            r8.u3 = r9
            goto L_0x0107
        L_0x00d2:
            r5.write(r6, r2, r1)
            int r7 = r8.w3
            int r7 = r7 + r1
            r8.w3 = r7
            goto L_0x00b5
        L_0x00db:
            if (r1 == 0) goto L_0x00fa
            boolean r9 = r1.p()
            if (r9 != 0) goto L_0x00fa
            java.io.ByteArrayOutputStream r9 = r8.r3
            if (r9 == 0) goto L_0x00f0
            byte[] r9 = r9.toByteArray()
            byte[] r9 = r1.i(r9)
            goto L_0x00f6
        L_0x00f0:
            byte[] r9 = r8.s
            byte[] r9 = r1.i(r9)
        L_0x00f6:
            r10.write(r9)
            goto L_0x0107
        L_0x00fa:
            java.io.ByteArrayOutputStream r9 = r8.r3
            if (r9 == 0) goto L_0x0102
            r9.writeTo(r10)
            goto L_0x0107
        L_0x0102:
            byte[] r9 = r8.s
            r10.write(r9)
        L_0x0107:
            byte[] r9 = C3
            r10.write(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStream.T(com.itextpdf.text.pdf.PdfWriter, java.io.OutputStream):void");
    }

    public void f1() {
        i1(-1);
    }

    public void i1(int i2) {
        PdfObject pdfObject;
        if (Document.l3 && !this.p3) {
            this.q3 = i2;
            if (this.s3 != null) {
                this.p3 = true;
                return;
            }
            PdfName pdfName = PdfName.T7;
            PdfObject t0 = PdfReader.t0(d0(pdfName));
            if (t0 != null) {
                if (t0.E()) {
                    if (PdfName.j8.equals(t0)) {
                        return;
                    }
                } else if (!t0.q()) {
                    throw new RuntimeException(MessageLocalization.b("stream.could.not.be.compressed.filter.is.not.a.name.or.array", new Object[0]));
                } else if (((PdfArray) t0).p0(PdfName.j8)) {
                    return;
                }
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Deflater deflater = new Deflater(i2);
                DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                ByteArrayOutputStream byteArrayOutputStream2 = this.r3;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.writeTo(deflaterOutputStream);
                } else {
                    deflaterOutputStream.write(this.s);
                }
                deflaterOutputStream.close();
                deflater.end();
                this.r3 = byteArrayOutputStream;
                this.s = null;
                V0(PdfName.va, new PdfNumber(byteArrayOutputStream.size()));
                if (t0 == null) {
                    pdfObject = PdfName.j8;
                } else {
                    PdfArray pdfArray = new PdfArray(t0);
                    pdfArray.Z(0, PdfName.j8);
                    pdfObject = pdfArray;
                }
                V0(pdfName, pdfObject);
                this.p3 = true;
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    public int m1() {
        return this.w3;
    }

    /* access modifiers changed from: protected */
    public void n1(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        super.T(pdfWriter, outputStream);
    }

    public void o1(OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.r3;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.writeTo(outputStream);
            return;
        }
        byte[] bArr = this.s;
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }

    public void p1() throws IOException {
        if (this.s3 != null) {
            int i2 = this.u3;
            if (i2 != -1) {
                this.v3.z0(new PdfNumber(i2), this.t3, false);
                return;
            }
            throw new IOException(MessageLocalization.b("writelength.can.only.be.called.after.output.of.the.stream.body", new Object[0]));
        }
        throw new UnsupportedOperationException(MessageLocalization.b("writelength.can.only.be.called.in.a.contructed.pdfstream.inputstream.pdfwriter", new Object[0]));
    }

    public String toString() {
        PdfName pdfName = PdfName.Kg;
        if (d0(pdfName) == null) {
            return "Stream";
        }
        return "Stream of type: " + d0(pdfName);
    }

    public PdfStream(InputStream inputStream, PdfWriter pdfWriter) {
        this.X = 7;
        this.s3 = inputStream;
        this.v3 = pdfWriter;
        PdfIndirectReference D1 = pdfWriter.D1();
        this.t3 = D1;
        V0(PdfName.va, D1);
    }

    public PdfStream(byte[] bArr) {
        this.X = 7;
        this.s = bArr;
        this.w3 = bArr.length;
        V0(PdfName.va, new PdfNumber(bArr.length));
    }
}
