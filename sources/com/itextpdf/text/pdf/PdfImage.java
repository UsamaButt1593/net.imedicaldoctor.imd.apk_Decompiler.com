package com.itextpdf.text.pdf;

import com.itextpdf.text.Image;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PdfImage extends PdfStream {
    static final int G3 = 4096;
    protected PdfName E3 = null;
    protected Image F3;

    /* JADX WARNING: Removed duplicated region for block: B:151:0x0356 A[Catch:{ IOException -> 0x00cd, all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x036d A[SYNTHETIC, Splitter:B:156:0x036d] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01d9 A[Catch:{ IOException -> 0x00cd, all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0207 A[Catch:{ IOException -> 0x00cd, all -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x020f A[Catch:{ IOException -> 0x00cd, all -> 0x00ca }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PdfImage(com.itextpdf.text.Image r11, java.lang.String r12, com.itextpdf.text.pdf.PdfIndirectReference r13) throws com.itextpdf.text.pdf.BadPdfFormatException {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            r10.<init>()
            r2 = 0
            r10.E3 = r2
            r10.F3 = r11
            if (r12 != 0) goto L_0x0010
            r10.q1(r11)
            goto L_0x0017
        L_0x0010:
            com.itextpdf.text.pdf.PdfName r3 = new com.itextpdf.text.pdf.PdfName
            r3.<init>((java.lang.String) r12)
            r10.E3 = r3
        L_0x0017:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.Kg
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.ai
            r10.V0(r12, r3)
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.F9
            r10.V0(r12, r3)
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.Jh
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r11.a0()
            r3.<init>((float) r4)
            r10.V0(r12, r3)
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.h9
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r11.N()
            r3.<init>((float) r4)
            r10.V0(r12, r3)
            com.itextpdf.text.pdf.PdfOCG r12 = r11.h1()
            if (r12 == 0) goto L_0x0054
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.Pb
            com.itextpdf.text.pdf.PdfOCG r3 = r11.h1()
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r3.g()
            r10.V0(r12, r3)
        L_0x0054:
            boolean r12 = r11.F1()
            r3 = 255(0xff, float:3.57E-43)
            if (r12 == 0) goto L_0x006f
            int r12 = r11.I0()
            if (r12 == r1) goto L_0x0068
            int r12 = r11.I0()
            if (r12 <= r3) goto L_0x006f
        L_0x0068:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.J9
            com.itextpdf.text.pdf.PdfBoolean r4 = com.itextpdf.text.pdf.PdfBoolean.j3
            r10.V0(r12, r4)
        L_0x006f:
            if (r13 == 0) goto L_0x0080
            boolean r12 = r11.J1()
            if (r12 == 0) goto L_0x007d
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.We
        L_0x0079:
            r10.V0(r12, r13)
            goto L_0x0080
        L_0x007d:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.Va
            goto L_0x0079
        L_0x0080:
            boolean r12 = r11.F1()
            java.lang.String r4 = "[1 0]"
            if (r12 == 0) goto L_0x0098
            boolean r12 = r11.D1()
            if (r12 == 0) goto L_0x0098
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.n6
            com.itextpdf.text.pdf.PdfLiteral r5 = new com.itextpdf.text.pdf.PdfLiteral
            r5.<init>((java.lang.String) r4)
            r10.V0(r12, r5)
        L_0x0098:
            boolean r12 = r11.C1()
            if (r12 == 0) goto L_0x00a5
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.U9
            com.itextpdf.text.pdf.PdfBoolean r5 = com.itextpdf.text.pdf.PdfBoolean.j3
            r10.V0(r12, r5)
        L_0x00a5:
            int[] r12 = r11.s1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x00e3
            boolean r5 = r11.F1()     // Catch:{ IOException -> 0x00cd }
            if (r5 != 0) goto L_0x00e3
            if (r13 != 0) goto L_0x00e3
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00cd }
            java.lang.String r5 = "["
            r13.<init>(r5)     // Catch:{ IOException -> 0x00cd }
            r5 = 0
        L_0x00bb:
            int r6 = r12.length     // Catch:{ IOException -> 0x00cd }
            if (r5 >= r6) goto L_0x00d0
            r6 = r12[r5]     // Catch:{ IOException -> 0x00cd }
            r13.append(r6)     // Catch:{ IOException -> 0x00cd }
            java.lang.String r6 = " "
            r13.append(r6)     // Catch:{ IOException -> 0x00cd }
            int r5 = r5 + r1
            goto L_0x00bb
        L_0x00ca:
            r11 = move-exception
            goto L_0x03a8
        L_0x00cd:
            r11 = move-exception
            goto L_0x039e
        L_0x00d0:
            java.lang.String r12 = "]"
            r13.append(r12)     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.Va     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfLiteral r5 = new com.itextpdf.text.pdf.PdfLiteral     // Catch:{ IOException -> 0x00cd }
            java.lang.String r13 = r13.toString()     // Catch:{ IOException -> 0x00cd }
            r5.<init>((java.lang.String) r13)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r5)     // Catch:{ IOException -> 0x00cd }
        L_0x00e3:
            boolean r12 = r11.A1()     // Catch:{ IOException -> 0x00cd }
            java.lang.String r13 = "[1 0 1 0 1 0 1 0]"
            r5 = 3
            r6 = 8
            if (r12 == 0) goto L_0x0217
            int r12 = r11.K0()     // Catch:{ IOException -> 0x00cd }
            byte[] r0 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            r10.s = r0     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.va     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r8 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            int r0 = r0.length     // Catch:{ IOException -> 0x00cd }
            r8.<init>((int) r0)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r7, r8)     // Catch:{ IOException -> 0x00cd }
            int r0 = r11.I0()     // Catch:{ IOException -> 0x00cd }
            if (r0 <= r3) goto L_0x0188
            boolean r13 = r11.F1()     // Catch:{ IOException -> 0x00cd }
            if (r13 != 0) goto L_0x0116
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.A6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r13, r3)     // Catch:{ IOException -> 0x00cd }
        L_0x0116:
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.u4     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            r3.<init>((int) r1)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r13, r3)     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.T7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.X4     // Catch:{ IOException -> 0x00cd }
            r10.V0(r13, r3)     // Catch:{ IOException -> 0x00cd }
            int r0 = r0 + -257
            com.itextpdf.text.pdf.PdfDictionary r13 = new com.itextpdf.text.pdf.PdfDictionary     // Catch:{ IOException -> 0x00cd }
            r13.<init>()     // Catch:{ IOException -> 0x00cd }
            if (r0 == 0) goto L_0x013a
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.ga     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r4 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            r4.<init>((int) r0)     // Catch:{ IOException -> 0x00cd }
            r13.V0(r3, r4)     // Catch:{ IOException -> 0x00cd }
        L_0x013a:
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0145
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.x4     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfBoolean r1 = com.itextpdf.text.pdf.PdfBoolean.j3     // Catch:{ IOException -> 0x00cd }
            r13.V0(r0, r1)     // Catch:{ IOException -> 0x00cd }
        L_0x0145:
            r0 = r12 & 2
            if (r0 == 0) goto L_0x0150
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.l7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfBoolean r1 = com.itextpdf.text.pdf.PdfBoolean.j3     // Catch:{ IOException -> 0x00cd }
            r13.V0(r0, r1)     // Catch:{ IOException -> 0x00cd }
        L_0x0150:
            r0 = r12 & 4
            if (r0 == 0) goto L_0x015b
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.s7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfBoolean r1 = com.itextpdf.text.pdf.PdfBoolean.j3     // Catch:{ IOException -> 0x00cd }
            r13.V0(r0, r1)     // Catch:{ IOException -> 0x00cd }
        L_0x015b:
            r12 = r12 & r6
            if (r12 == 0) goto L_0x0165
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.r7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfBoolean r0 = com.itextpdf.text.pdf.PdfBoolean.k3     // Catch:{ IOException -> 0x00cd }
            r13.V0(r12, r0)     // Catch:{ IOException -> 0x00cd }
        L_0x0165:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.G5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            float r1 = r11.a0()     // Catch:{ IOException -> 0x00cd }
            r0.<init>((float) r1)     // Catch:{ IOException -> 0x00cd }
            r13.V0(r12, r0)     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.ve     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            float r11 = r11.N()     // Catch:{ IOException -> 0x00cd }
            r0.<init>((float) r11)     // Catch:{ IOException -> 0x00cd }
            r13.V0(r12, r0)     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.o6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r11, r13)     // Catch:{ IOException -> 0x00cd }
            goto L_0x0216
        L_0x0188:
            if (r12 == r1) goto L_0x01be
            if (r12 == r5) goto L_0x01a4
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.C6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r0)     // Catch:{ IOException -> 0x00cd }
            boolean r12 = r11.D1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x01d3
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.n6     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfLiteral r0 = new com.itextpdf.text.pdf.PdfLiteral     // Catch:{ IOException -> 0x00cd }
            r0.<init>((java.lang.String) r13)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r0)     // Catch:{ IOException -> 0x00cd }
            goto L_0x01d3
        L_0x01a4:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.B6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            boolean r12 = r11.D1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x01d3
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.n6     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfLiteral r13 = new com.itextpdf.text.pdf.PdfLiteral     // Catch:{ IOException -> 0x00cd }
            java.lang.String r0 = "[1 0 1 0 1 0]"
            r13.<init>((java.lang.String) r0)     // Catch:{ IOException -> 0x00cd }
        L_0x01ba:
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            goto L_0x01d3
        L_0x01be:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.A6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            boolean r12 = r11.D1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x01d3
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.n6     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfLiteral r13 = new com.itextpdf.text.pdf.PdfLiteral     // Catch:{ IOException -> 0x00cd }
            r13.<init>((java.lang.String) r4)     // Catch:{ IOException -> 0x00cd }
            goto L_0x01ba
        L_0x01d3:
            com.itextpdf.text.pdf.PdfDictionary r12 = r11.F0()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x01dc
            r10.X0(r12)     // Catch:{ IOException -> 0x00cd }
        L_0x01dc:
            boolean r12 = r11.F1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x01f3
            int r12 = r11.I0()     // Catch:{ IOException -> 0x00cd }
            if (r12 == r1) goto L_0x01ee
            int r12 = r11.I0()     // Catch:{ IOException -> 0x00cd }
            if (r12 <= r6) goto L_0x01f3
        L_0x01ee:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            r10.a1(r12)     // Catch:{ IOException -> 0x00cd }
        L_0x01f3:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.u4     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r13 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            int r0 = r11.I0()     // Catch:{ IOException -> 0x00cd }
            r13.<init>((int) r0)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            boolean r12 = r11.z1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x020f
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.T7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.j8     // Catch:{ IOException -> 0x00cd }
            r10.V0(r11, r12)     // Catch:{ IOException -> 0x00cd }
            goto L_0x0216
        L_0x020f:
            int r11 = r11.L0()     // Catch:{ IOException -> 0x00cd }
            r10.i1(r11)     // Catch:{ IOException -> 0x00cd }
        L_0x0216:
            return
        L_0x0217:
            byte[] r12 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            if (r12 != 0) goto L_0x022e
            java.net.URL r12 = r11.t1()     // Catch:{ IOException -> 0x00cd }
            java.io.InputStream r2 = r12.openStream()     // Catch:{ IOException -> 0x00cd }
            java.net.URL r12 = r11.t1()     // Catch:{ IOException -> 0x00cd }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x00cd }
            goto L_0x023c
        L_0x022e:
            java.io.ByteArrayInputStream r12 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x00cd }
            byte[] r3 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            r12.<init>(r3)     // Catch:{ IOException -> 0x00cd }
            java.lang.String r2 = "Byte array"
            r9 = r2
            r2 = r12
            r12 = r9
        L_0x023c:
            int r3 = r11.type()     // Catch:{ IOException -> 0x00cd }
            r4 = 32
            r7 = -1
            if (r3 == r4) goto L_0x02f8
            r13 = 33
            if (r3 == r13) goto L_0x029e
            r13 = 36
            if (r3 != r13) goto L_0x028e
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.T7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.ba     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.A6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.u4     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r13 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            r13.<init>((int) r1)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            byte[] r12 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x0282
            byte[] r11 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            r10.s = r11     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.va     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r13 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            int r11 = r11.length     // Catch:{ IOException -> 0x00cd }
            r13.<init>((int) r11)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            if (r2 == 0) goto L_0x0281
            r2.close()     // Catch:{ Exception -> 0x0281 }
        L_0x0281:
            return
        L_0x0282:
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00cd }
            r12.<init>()     // Catch:{ IOException -> 0x00cd }
            r10.r3 = r12     // Catch:{ IOException -> 0x00cd }
        L_0x0289:
            x1(r2, r12, r7)     // Catch:{ IOException -> 0x00cd }
            goto L_0x0376
        L_0x028e:
            com.itextpdf.text.pdf.BadPdfFormatException r11 = new com.itextpdf.text.pdf.BadPdfFormatException     // Catch:{ IOException -> 0x00cd }
            java.lang.String r13 = "1.is.an.unknown.image.format"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ IOException -> 0x00cd }
            r1[r0] = r12     // Catch:{ IOException -> 0x00cd }
            java.lang.String r12 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r1)     // Catch:{ IOException -> 0x00cd }
            r11.<init>(r12)     // Catch:{ IOException -> 0x00cd }
            throw r11     // Catch:{ IOException -> 0x00cd }
        L_0x029e:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.T7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.da     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            int r12 = r11.K0()     // Catch:{ IOException -> 0x00cd }
            if (r12 <= 0) goto L_0x02d3
            int r12 = r11.K0()     // Catch:{ IOException -> 0x00cd }
            if (r12 == r1) goto L_0x02c0
            if (r12 == r5) goto L_0x02bb
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.C6     // Catch:{ IOException -> 0x00cd }
        L_0x02b7:
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            goto L_0x02c5
        L_0x02bb:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.B6     // Catch:{ IOException -> 0x00cd }
            goto L_0x02b7
        L_0x02c0:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.A6     // Catch:{ IOException -> 0x00cd }
            goto L_0x02b7
        L_0x02c5:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.u4     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r13 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            int r0 = r11.I0()     // Catch:{ IOException -> 0x00cd }
            r13.<init>((int) r0)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
        L_0x02d3:
            byte[] r12 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x02f0
            byte[] r11 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            r10.s = r11     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.va     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r13 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            int r11 = r11.length     // Catch:{ IOException -> 0x00cd }
            r13.<init>((int) r11)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            if (r2 == 0) goto L_0x02ef
            r2.close()     // Catch:{ Exception -> 0x02ef }
        L_0x02ef:
            return
        L_0x02f0:
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00cd }
            r12.<init>()     // Catch:{ IOException -> 0x00cd }
            r10.r3 = r12     // Catch:{ IOException -> 0x00cd }
            goto L_0x0289
        L_0x02f8:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.T7     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.k6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r3)     // Catch:{ IOException -> 0x00cd }
            int r12 = r11.J0()     // Catch:{ IOException -> 0x00cd }
            if (r12 != 0) goto L_0x0319
            com.itextpdf.text.pdf.PdfDictionary r12 = new com.itextpdf.text.pdf.PdfDictionary     // Catch:{ IOException -> 0x00cd }
            r12.<init>()     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.x5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r4 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            r4.<init>((int) r0)     // Catch:{ IOException -> 0x00cd }
            r12.V0(r3, r4)     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.o6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r0, r12)     // Catch:{ IOException -> 0x00cd }
        L_0x0319:
            int r12 = r11.K0()     // Catch:{ IOException -> 0x00cd }
            if (r12 == r1) goto L_0x0341
            if (r12 == r5) goto L_0x0339
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.C6     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r0)     // Catch:{ IOException -> 0x00cd }
            boolean r12 = r11.D1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x0346
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.n6     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfLiteral r0 = new com.itextpdf.text.pdf.PdfLiteral     // Catch:{ IOException -> 0x00cd }
            r0.<init>((java.lang.String) r13)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r0)     // Catch:{ IOException -> 0x00cd }
            goto L_0x0346
        L_0x0339:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.B6     // Catch:{ IOException -> 0x00cd }
        L_0x033d:
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            goto L_0x0346
        L_0x0341:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.A6     // Catch:{ IOException -> 0x00cd }
            goto L_0x033d
        L_0x0346:
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.u4     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r13 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            r13.<init>((int) r6)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            byte[] r12 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            if (r12 == 0) goto L_0x036d
            byte[] r11 = r11.n1()     // Catch:{ IOException -> 0x00cd }
            r10.s = r11     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.va     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r13 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            int r11 = r11.length     // Catch:{ IOException -> 0x00cd }
            r13.<init>((int) r11)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r12, r13)     // Catch:{ IOException -> 0x00cd }
            if (r2 == 0) goto L_0x036c
            r2.close()     // Catch:{ Exception -> 0x036c }
        L_0x036c:
            return
        L_0x036d:
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00cd }
            r12.<init>()     // Catch:{ IOException -> 0x00cd }
            r10.r3 = r12     // Catch:{ IOException -> 0x00cd }
            goto L_0x0289
        L_0x0376:
            int r12 = r11.L0()     // Catch:{ IOException -> 0x00cd }
            if (r12 <= 0) goto L_0x0383
            int r11 = r11.L0()     // Catch:{ IOException -> 0x00cd }
            r10.i1(r11)     // Catch:{ IOException -> 0x00cd }
        L_0x0383:
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.va     // Catch:{ IOException -> 0x00cd }
            com.itextpdf.text.pdf.PdfNumber r12 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ IOException -> 0x00cd }
            java.io.ByteArrayOutputStream r13 = r10.r3     // Catch:{ IOException -> 0x00cd }
            int r13 = r13.size()     // Catch:{ IOException -> 0x00cd }
            r12.<init>((int) r13)     // Catch:{ IOException -> 0x00cd }
            r10.V0(r11, r12)     // Catch:{ IOException -> 0x00cd }
            if (r2 == 0) goto L_0x0398
            r2.close()     // Catch:{ Exception -> 0x0398 }
        L_0x0398:
            return
        L_0x0399:
            r11 = move-exception
            r2 = r12
            goto L_0x03a8
        L_0x039c:
            r11 = move-exception
            r2 = r12
        L_0x039e:
            com.itextpdf.text.pdf.BadPdfFormatException r12 = new com.itextpdf.text.pdf.BadPdfFormatException     // Catch:{ all -> 0x00ca }
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x00ca }
            r12.<init>(r11)     // Catch:{ all -> 0x00ca }
            throw r12     // Catch:{ all -> 0x00ca }
        L_0x03a8:
            if (r2 == 0) goto L_0x03ad
            r2.close()     // Catch:{ Exception -> 0x03ad }
        L_0x03ad:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfImage.<init>(com.itextpdf.text.Image, java.lang.String, com.itextpdf.text.pdf.PdfIndirectReference):void");
    }

    private void q1(Image image) {
        this.E3 = new PdfName("img" + Long.toHexString(image.i1().longValue()));
    }

    static void x1(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        byte[] bArr = new byte[4096];
        if (i2 < 0) {
            i2 = 2147418112;
        }
        while (i2 != 0) {
            int read = inputStream.read(bArr, 0, Math.min(i2, 4096));
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
                i2 -= read;
            } else {
                return;
            }
        }
    }

    public Image s1() {
        return this.F3;
    }

    /* access modifiers changed from: protected */
    public void v1(PdfImage pdfImage) {
        this.E3 = pdfImage.E3;
        this.p3 = pdfImage.p3;
        this.q3 = pdfImage.q3;
        this.r3 = pdfImage.r3;
        this.s = pdfImage.s;
        this.j3 = pdfImage.j3;
    }

    public PdfName w1() {
        return this.E3;
    }
}
