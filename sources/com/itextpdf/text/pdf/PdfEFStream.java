package com.itextpdf.text.pdf;

import java.io.InputStream;

public class PdfEFStream extends PdfStream {
    public PdfEFStream(InputStream inputStream, PdfWriter pdfWriter) {
        super(inputStream, pdfWriter);
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
            if (r1 == 0) goto L_0x0087
            boolean r3 = r1.p()
            if (r3 == 0) goto L_0x0087
            com.itextpdf.text.pdf.PdfArray r3 = new com.itextpdf.text.pdf.PdfArray
            r3.<init>()
            com.itextpdf.text.pdf.PdfArray r4 = new com.itextpdf.text.pdf.PdfArray
            r4.<init>()
            com.itextpdf.text.pdf.PdfDictionary r5 = new com.itextpdf.text.pdf.PdfDictionary
            r5.<init>()
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.qb
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.pf
            r5.V0(r6, r7)
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.a6
            r3.a0(r6)
            r4.a0(r5)
            boolean r5 = r8.p3
            if (r5 == 0) goto L_0x007d
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.j8
            r3.a0(r5)
            com.itextpdf.text.pdf.PdfNull r5 = new com.itextpdf.text.pdf.PdfNull
            r5.<init>()
            r4.a0(r5)
        L_0x007d:
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.T7
            r8.V0(r5, r3)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.o6
            r8.V0(r3, r4)
        L_0x0087:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfObject r4 = r8.d0(r3)
            if (r1 == 0) goto L_0x00b1
            if (r4 == 0) goto L_0x00b1
            boolean r5 = r4.I()
            if (r5 == 0) goto L_0x00b1
            r5 = r4
            com.itextpdf.text.pdf.PdfNumber r5 = (com.itextpdf.text.pdf.PdfNumber) r5
            int r5 = r5.e0()
            com.itextpdf.text.pdf.PdfNumber r6 = new com.itextpdf.text.pdf.PdfNumber
            int r5 = r1.b(r5)
            r6.<init>((int) r5)
            r8.V0(r3, r6)
            r8.n1(r9, r10)
            r8.V0(r3, r4)
            goto L_0x00b4
        L_0x00b1:
            r8.n1(r9, r10)
        L_0x00b4:
            byte[] r9 = com.itextpdf.text.pdf.PdfStream.B3
            r10.write(r9)
            java.io.InputStream r9 = r8.s3
            if (r9 == 0) goto L_0x0111
            r8.w3 = r2
            com.itextpdf.text.pdf.OutputStreamCounter r9 = new com.itextpdf.text.pdf.OutputStreamCounter
            r9.<init>(r10)
            if (r1 == 0) goto L_0x00cc
            com.itextpdf.text.pdf.OutputStreamEncryption r1 = r1.m(r9)
            r3 = r1
            goto L_0x00ce
        L_0x00cc:
            r1 = r9
            r3 = r0
        L_0x00ce:
            boolean r4 = r8.p3
            if (r4 == 0) goto L_0x00e5
            java.util.zip.Deflater r0 = new java.util.zip.Deflater
            int r4 = r8.q3
            r0.<init>(r4)
            java.util.zip.DeflaterOutputStream r4 = new java.util.zip.DeflaterOutputStream
            r5 = 32768(0x8000, float:4.5918E-41)
            r4.<init>(r1, r0, r5)
            r5 = r4
            r4 = r0
            r0 = r5
            goto L_0x00e7
        L_0x00e5:
            r4 = r0
            r5 = r1
        L_0x00e7:
            r1 = 4192(0x1060, float:5.874E-42)
            byte[] r6 = new byte[r1]
        L_0x00eb:
            java.io.InputStream r1 = r8.s3
            int r1 = r1.read(r6)
            if (r1 > 0) goto L_0x0108
            if (r0 == 0) goto L_0x00fb
            r0.finish()
            r4.end()
        L_0x00fb:
            if (r3 == 0) goto L_0x0100
            r3.b()
        L_0x0100:
            long r0 = r9.b()
            int r9 = (int) r0
            r8.u3 = r9
            goto L_0x0135
        L_0x0108:
            r5.write(r6, r2, r1)
            int r7 = r8.w3
            int r7 = r7 + r1
            r8.w3 = r7
            goto L_0x00eb
        L_0x0111:
            java.io.ByteArrayOutputStream r9 = r8.r3
            if (r1 != 0) goto L_0x0121
            if (r9 == 0) goto L_0x011b
            r9.writeTo(r10)
            goto L_0x0135
        L_0x011b:
            byte[] r9 = r8.s
            r10.write(r9)
            goto L_0x0135
        L_0x0121:
            if (r9 == 0) goto L_0x012c
            byte[] r9 = r9.toByteArray()
            byte[] r9 = r1.i(r9)
            goto L_0x0132
        L_0x012c:
            byte[] r9 = r8.s
            byte[] r9 = r1.i(r9)
        L_0x0132:
            r10.write(r9)
        L_0x0135:
            byte[] r9 = com.itextpdf.text.pdf.PdfStream.C3
            r10.write(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfEFStream.T(com.itextpdf.text.pdf.PdfWriter, java.io.OutputStream):void");
    }

    public PdfEFStream(byte[] bArr) {
        super(bArr);
    }
}
