package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;

class PdfContents extends PdfStream {
    static final byte[] E3 = DocWriter.E("q\n");
    static final byte[] F3 = DocWriter.E("Q\n");
    static final byte[] G3 = DocWriter.E("0 1 -1 0 ");
    static final byte[] H3 = DocWriter.E("-1 0 0 -1 ");
    static final byte[] I3 = DocWriter.E("0 -1 1 0 ");
    static final byte[] J3 = DocWriter.E(" cm\n");

    /* JADX WARNING: type inference failed for: r1v4, types: [java.util.zip.DeflaterOutputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PdfContents(com.itextpdf.text.pdf.PdfContentByte r8, com.itextpdf.text.pdf.PdfContentByte r9, com.itextpdf.text.pdf.PdfContentByte r10, com.itextpdf.text.pdf.PdfContentByte r11, com.itextpdf.text.Rectangle r12) throws com.itextpdf.text.pdf.BadPdfFormatException {
        /*
            r7 = this;
            r7.<init>()
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x001e }
            r0.<init>()     // Catch:{ Exception -> 0x001e }
            r7.r3 = r0     // Catch:{ Exception -> 0x001e }
            boolean r1 = com.itextpdf.text.Document.l3     // Catch:{ Exception -> 0x001e }
            if (r1 == 0) goto L_0x003e
            r0 = 1
            r7.p3 = r0     // Catch:{ Exception -> 0x001e }
            if (r10 == 0) goto L_0x0021
            com.itextpdf.text.pdf.PdfWriter r0 = r10.i1()     // Catch:{ Exception -> 0x001e }
            int r0 = r0.a1()     // Catch:{ Exception -> 0x001e }
        L_0x001b:
            r7.q3 = r0     // Catch:{ Exception -> 0x001e }
            goto L_0x002c
        L_0x001e:
            r8 = move-exception
            goto L_0x0135
        L_0x0021:
            if (r9 == 0) goto L_0x002c
            com.itextpdf.text.pdf.PdfWriter r0 = r9.i1()     // Catch:{ Exception -> 0x001e }
            int r0 = r0.a1()     // Catch:{ Exception -> 0x001e }
            goto L_0x001b
        L_0x002c:
            java.util.zip.Deflater r0 = new java.util.zip.Deflater     // Catch:{ Exception -> 0x001e }
            int r1 = r7.q3     // Catch:{ Exception -> 0x001e }
            r0.<init>(r1)     // Catch:{ Exception -> 0x001e }
            java.util.zip.DeflaterOutputStream r1 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x001e }
            java.io.ByteArrayOutputStream r2 = r7.r3     // Catch:{ Exception -> 0x001e }
            r1.<init>(r2, r0)     // Catch:{ Exception -> 0x001e }
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x003f
        L_0x003e:
            r1 = 0
        L_0x003f:
            int r2 = r12.S()     // Catch:{ Exception -> 0x001e }
            r3 = 90
            r4 = 48
            r5 = 32
            if (r2 == r3) goto L_0x00a3
            r3 = 180(0xb4, float:2.52E-43)
            if (r2 == r3) goto L_0x0075
            r3 = 270(0x10e, float:3.78E-43)
            if (r2 == r3) goto L_0x0054
            goto L_0x00c3
        L_0x0054:
            byte[] r2 = I3     // Catch:{ Exception -> 0x001e }
            r0.write(r2)     // Catch:{ Exception -> 0x001e }
            r0.write(r4)     // Catch:{ Exception -> 0x001e }
            r0.write(r5)     // Catch:{ Exception -> 0x001e }
            float r12 = r12.Q()     // Catch:{ Exception -> 0x001e }
            double r2 = (double) r12     // Catch:{ Exception -> 0x001e }
            java.lang.String r12 = com.itextpdf.text.pdf.ByteBuffer.u(r2)     // Catch:{ Exception -> 0x001e }
            byte[] r12 = com.itextpdf.text.DocWriter.E(r12)     // Catch:{ Exception -> 0x001e }
            r0.write(r12)     // Catch:{ Exception -> 0x001e }
            byte[] r12 = J3     // Catch:{ Exception -> 0x001e }
            r0.write(r12)     // Catch:{ Exception -> 0x001e }
            goto L_0x00c3
        L_0x0075:
            byte[] r2 = H3     // Catch:{ Exception -> 0x001e }
            r0.write(r2)     // Catch:{ Exception -> 0x001e }
            float r2 = r12.Q()     // Catch:{ Exception -> 0x001e }
            double r2 = (double) r2     // Catch:{ Exception -> 0x001e }
            java.lang.String r2 = com.itextpdf.text.pdf.ByteBuffer.u(r2)     // Catch:{ Exception -> 0x001e }
            byte[] r2 = com.itextpdf.text.DocWriter.E(r2)     // Catch:{ Exception -> 0x001e }
            r0.write(r2)     // Catch:{ Exception -> 0x001e }
            r0.write(r5)     // Catch:{ Exception -> 0x001e }
            float r12 = r12.T()     // Catch:{ Exception -> 0x001e }
            double r2 = (double) r12     // Catch:{ Exception -> 0x001e }
            java.lang.String r12 = com.itextpdf.text.pdf.ByteBuffer.u(r2)     // Catch:{ Exception -> 0x001e }
            byte[] r12 = com.itextpdf.text.DocWriter.E(r12)     // Catch:{ Exception -> 0x001e }
            r0.write(r12)     // Catch:{ Exception -> 0x001e }
            byte[] r12 = J3     // Catch:{ Exception -> 0x001e }
            r0.write(r12)     // Catch:{ Exception -> 0x001e }
            goto L_0x00c3
        L_0x00a3:
            byte[] r2 = G3     // Catch:{ Exception -> 0x001e }
            r0.write(r2)     // Catch:{ Exception -> 0x001e }
            float r12 = r12.T()     // Catch:{ Exception -> 0x001e }
            double r2 = (double) r12     // Catch:{ Exception -> 0x001e }
            java.lang.String r12 = com.itextpdf.text.pdf.ByteBuffer.u(r2)     // Catch:{ Exception -> 0x001e }
            byte[] r12 = com.itextpdf.text.DocWriter.E(r12)     // Catch:{ Exception -> 0x001e }
            r0.write(r12)     // Catch:{ Exception -> 0x001e }
            r0.write(r5)     // Catch:{ Exception -> 0x001e }
            r0.write(r4)     // Catch:{ Exception -> 0x001e }
            byte[] r12 = J3     // Catch:{ Exception -> 0x001e }
            r0.write(r12)     // Catch:{ Exception -> 0x001e }
        L_0x00c3:
            int r12 = r8.t3()     // Catch:{ Exception -> 0x001e }
            if (r12 <= 0) goto L_0x00da
            byte[] r12 = E3     // Catch:{ Exception -> 0x001e }
            r0.write(r12)     // Catch:{ Exception -> 0x001e }
            com.itextpdf.text.pdf.ByteBuffer r8 = r8.a1()     // Catch:{ Exception -> 0x001e }
            r8.H(r0)     // Catch:{ Exception -> 0x001e }
            byte[] r8 = F3     // Catch:{ Exception -> 0x001e }
            r0.write(r8)     // Catch:{ Exception -> 0x001e }
        L_0x00da:
            int r8 = r9.t3()     // Catch:{ Exception -> 0x001e }
            if (r8 <= 0) goto L_0x00f1
            byte[] r8 = E3     // Catch:{ Exception -> 0x001e }
            r0.write(r8)     // Catch:{ Exception -> 0x001e }
            com.itextpdf.text.pdf.ByteBuffer r8 = r9.a1()     // Catch:{ Exception -> 0x001e }
            r8.H(r0)     // Catch:{ Exception -> 0x001e }
            byte[] r8 = F3     // Catch:{ Exception -> 0x001e }
            r0.write(r8)     // Catch:{ Exception -> 0x001e }
        L_0x00f1:
            if (r10 == 0) goto L_0x0104
            byte[] r8 = E3     // Catch:{ Exception -> 0x001e }
            r0.write(r8)     // Catch:{ Exception -> 0x001e }
            com.itextpdf.text.pdf.ByteBuffer r8 = r10.a1()     // Catch:{ Exception -> 0x001e }
            r8.H(r0)     // Catch:{ Exception -> 0x001e }
            byte[] r8 = F3     // Catch:{ Exception -> 0x001e }
            r0.write(r8)     // Catch:{ Exception -> 0x001e }
        L_0x0104:
            int r8 = r11.t3()     // Catch:{ Exception -> 0x001e }
            if (r8 <= 0) goto L_0x0111
            com.itextpdf.text.pdf.ByteBuffer r8 = r11.a1()     // Catch:{ Exception -> 0x001e }
            r8.H(r0)     // Catch:{ Exception -> 0x001e }
        L_0x0111:
            r0.close()     // Catch:{ Exception -> 0x001e }
            if (r1 == 0) goto L_0x0119
            r1.end()     // Catch:{ Exception -> 0x001e }
        L_0x0119:
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            java.io.ByteArrayOutputStream r10 = r7.r3
            int r10 = r10.size()
            r9.<init>((int) r10)
            r7.V0(r8, r9)
            boolean r8 = r7.p3
            if (r8 == 0) goto L_0x0134
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.T7
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.j8
            r7.V0(r8, r9)
        L_0x0134:
            return
        L_0x0135:
            com.itextpdf.text.pdf.BadPdfFormatException r9 = new com.itextpdf.text.pdf.BadPdfFormatException
            java.lang.String r8 = r8.getMessage()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContents.<init>(com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.pdf.PdfContentByte, com.itextpdf.text.Rectangle):void");
    }
}
