package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.HashMap;

public class PdfPRow implements IAccessibleElement {
    public static final float f3 = -1.07374182E9f;
    public static final float g3 = 20000.0f;
    static final /* synthetic */ boolean h3 = false;
    public boolean X;
    protected float[] X2;
    protected PdfPCell[] Y;
    protected float Y2;
    protected float[] Z;
    protected boolean Z2;
    protected boolean a3;
    private int[] b3;
    protected PdfName c3;
    protected HashMap<PdfName, PdfObject> d3;
    protected AccessibleElementId e3;
    private final Logger s;

    public PdfPRow(PdfPRow pdfPRow) {
        PdfPCell[] pdfPCellArr;
        this.s = LoggerFactory.b(PdfPRow.class);
        this.X = false;
        this.Y2 = 0.0f;
        this.Z2 = false;
        this.a3 = false;
        this.c3 = PdfName.Of;
        this.d3 = null;
        this.e3 = new AccessibleElementId();
        this.X = pdfPRow.X;
        this.Y2 = pdfPRow.Y2;
        this.Z2 = pdfPRow.Z2;
        this.Y = new PdfPCell[pdfPRow.Y.length];
        int i2 = 0;
        while (true) {
            pdfPCellArr = this.Y;
            if (i2 >= pdfPCellArr.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPRow.Y[i2];
            if (pdfPCell != null) {
                if (pdfPCell instanceof PdfPHeaderCell) {
                    pdfPCellArr[i2] = new PdfPHeaderCell((PdfPHeaderCell) pdfPCell);
                } else {
                    pdfPCellArr[i2] = new PdfPCell(pdfPCell);
                }
            }
            i2++;
        }
        float[] fArr = new float[pdfPCellArr.length];
        this.Z = fArr;
        System.arraycopy(pdfPRow.Z, 0, fArr, 0, pdfPCellArr.length);
        h();
        this.e3 = pdfPRow.e3;
        this.c3 = pdfPRow.c3;
        if (pdfPRow.d3 != null) {
            this.d3 = new HashMap<>(pdfPRow.d3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean l(com.itextpdf.text.pdf.PdfContentByte r0) {
        /*
            if (r0 == 0) goto L_0x000e
            com.itextpdf.text.pdf.PdfWriter r0 = r0.Y
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.X1()
            if (r0 == 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfPRow.l(com.itextpdf.text.pdf.PdfContentByte):boolean");
    }

    public static float s(ColumnText columnText, float f2, float f4, float f5, float f6) {
        if (f2 > f5) {
            f5 = f2;
        }
        if (f4 > f6) {
            f6 = f4;
        }
        columnText.l0(f2, f4, f5, f6);
        return f6;
    }

    public void A(float f2, float f4, float f5, PdfPCell pdfPCell, PdfContentByte[] pdfContentByteArr) {
        BaseColor k2 = pdfPCell.k();
        if (k2 != null || pdfPCell.c0()) {
            float Q = pdfPCell.Q() + f2;
            float T = pdfPCell.T() + f4;
            float O = pdfPCell.O() + f2;
            float f6 = T - f5;
            if (k2 != null) {
                PdfContentByte pdfContentByte = pdfContentByteArr[1];
                pdfContentByte.h2(k2);
                pdfContentByte.H1(O, f6, Q - O, T - f6);
                pdfContentByte.Q0();
            }
            if (pdfPCell.c0()) {
                Rectangle rectangle = new Rectangle(O, f6, Q, T);
                rectangle.f(pdfPCell);
                rectangle.h0((BaseColor) null);
                pdfContentByteArr[2].I1(rectangle);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x027d, code lost:
        if (r15.S() == 180) goto L_0x027f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void B(int r20, int r21, float r22, float r23, com.itextpdf.text.pdf.PdfContentByte[] r24, boolean r25) {
        /*
            r19 = this;
            r9 = r19
            r0 = r21
            r10 = r24
            boolean r1 = r9.Z2
            if (r1 != 0) goto L_0x000d
            r19.a()
        L_0x000d:
            if (r0 >= 0) goto L_0x0013
            com.itextpdf.text.pdf.PdfPCell[] r0 = r9.Y
            int r0 = r0.length
            goto L_0x001a
        L_0x0013:
            com.itextpdf.text.pdf.PdfPCell[] r1 = r9.Y
            int r1 = r1.length
            int r0 = java.lang.Math.min(r0, r1)
        L_0x001a:
            if (r20 >= 0) goto L_0x001e
            r1 = 0
            goto L_0x0020
        L_0x001e:
            r1 = r20
        L_0x0020:
            if (r1 < r0) goto L_0x0023
            return
        L_0x0023:
            r2 = r1
            r1 = r22
        L_0x0026:
            if (r2 < 0) goto L_0x003b
            com.itextpdf.text.pdf.PdfPCell[] r3 = r9.Y
            r3 = r3[r2]
            if (r3 == 0) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            if (r2 <= 0) goto L_0x0038
            float[] r3 = r9.Z
            int r4 = r2 + -1
            r3 = r3[r4]
            float r1 = r1 - r3
        L_0x0038:
            int r2 = r2 + -1
            goto L_0x0026
        L_0x003b:
            if (r2 >= 0) goto L_0x003e
            r2 = 0
        L_0x003e:
            com.itextpdf.text.pdf.PdfPCell[] r3 = r9.Y
            r3 = r3[r2]
            if (r3 == 0) goto L_0x0049
            float r3 = r3.O()
            float r1 = r1 - r3
        L_0x0049:
            r12 = r1
            r13 = 3
            r1 = r10[r13]
            boolean r1 = l(r1)
            if (r1 == 0) goto L_0x0058
            r1 = r10[r13]
            r1.B1(r9)
        L_0x0058:
            r14 = r2
        L_0x0059:
            if (r14 >= r0) goto L_0x0402
            com.itextpdf.text.pdf.PdfPCell[] r1 = r9.Y
            r15 = r1[r14]
            if (r15 != 0) goto L_0x0065
            r21 = r14
            goto L_0x03f5
        L_0x0065:
            r1 = r10[r13]
            boolean r1 = l(r1)
            if (r1 == 0) goto L_0x0072
            r1 = r10[r13]
            r1.B1(r15)
        L_0x0072:
            float r1 = r9.Y2
            float[] r2 = r9.X2
            r2 = r2[r14]
            float r16 = r1 + r2
            r1 = r19
            r2 = r12
            r3 = r23
            r4 = r16
            r5 = r15
            r6 = r24
            r1.A(r2, r3, r4, r5, r6)
            com.itextpdf.text.Image r1 = r15.V0()
            float r2 = r15.T()
            float r2 = r2 + r23
            float r3 = r15.P0()
            float r2 = r2 - r3
            float r3 = r15.N()
            r4 = 6
            r5 = 5
            r6 = 1073741824(0x40000000, float:2.0)
            int r3 = (r3 > r16 ? 1 : (r3 == r16 ? 0 : -1))
            if (r3 > 0) goto L_0x00cc
            int r3 = r15.k1()
            if (r3 == r5) goto L_0x00be
            if (r3 == r4) goto L_0x00ab
            goto L_0x00cc
        L_0x00ab:
            float r2 = r15.T()
            float r2 = r2 + r23
            float r2 = r2 - r16
            float r3 = r15.N()
        L_0x00b7:
            float r2 = r2 + r3
            float r3 = r15.P0()
            float r2 = r2 - r3
            goto L_0x00cc
        L_0x00be:
            float r2 = r15.T()
            float r2 = r2 + r23
            float r3 = r15.N()
            float r3 = r3 - r16
            float r3 = r3 / r6
            goto L_0x00b7
        L_0x00cc:
            r3 = 2
            r7 = 1
            if (r1 == 0) goto L_0x01a7
            int r4 = r15.S()
            if (r4 == 0) goto L_0x00f9
            com.itextpdf.text.Image r1 = com.itextpdf.text.Image.Y0(r1)
            float r4 = r1.R0()
            int r5 = r15.S()
            r21 = r14
            double r13 = (double) r5
            r17 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r13 = r13 * r17
            r17 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r13 = r13 / r17
            float r5 = (float) r13
            float r4 = r4 + r5
            r1.l2(r4)
            goto L_0x00fb
        L_0x00f9:
            r21 = r14
        L_0x00fb:
            float r4 = r15.N()
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 <= 0) goto L_0x0127
            boolean r4 = r1.H1()
            if (r4 != 0) goto L_0x010b
            goto L_0x03f5
        L_0x010b:
            r4 = 1120403456(0x42c80000, float:100.0)
            r1.R1(r4)
            float r5 = r15.P0()
            float r5 = r16 - r5
            float r8 = r15.M0()
            float r5 = r5 - r8
            float r8 = r1.o1()
            float r5 = r5 / r8
            float r5 = r5 * r4
            r1.R1(r5)
            r4 = 1
            goto L_0x0128
        L_0x0127:
            r4 = 0
        L_0x0128:
            float r5 = r15.O()
            float r5 = r5 + r12
            float r8 = r15.N0()
            float r5 = r5 + r8
            if (r4 == 0) goto L_0x0174
            int r2 = r15.U0()
            if (r2 == r7) goto L_0x014e
            if (r2 == r3) goto L_0x013d
            goto L_0x0169
        L_0x013d:
            float r2 = r15.Q()
            float r2 = r2 + r12
            float r3 = r15.O0()
            float r2 = r2 - r3
            float r3 = r1.p1()
            float r5 = r2 - r3
            goto L_0x0169
        L_0x014e:
            float r2 = r15.O()
            float r3 = r15.N0()
            float r2 = r2 + r3
            float r3 = r15.Q()
            float r2 = r2 + r3
            float r3 = r15.O0()
            float r2 = r2 - r3
            float r3 = r1.p1()
            float r2 = r2 - r3
            float r2 = r2 / r6
            float r5 = r12 + r2
        L_0x0169:
            float r2 = r15.T()
            float r2 = r2 + r23
            float r3 = r15.P0()
            float r2 = r2 - r3
        L_0x0174:
            float r3 = r1.o1()
            float r2 = r2 - r3
            r1.V1(r5, r2)
            r2 = 3
            r3 = r10[r2]     // Catch:{ DocumentException -> 0x018b }
            boolean r3 = l(r3)     // Catch:{ DocumentException -> 0x018b }
            if (r3 == 0) goto L_0x018d
            r3 = r10[r2]     // Catch:{ DocumentException -> 0x018b }
            r3.B1(r1)     // Catch:{ DocumentException -> 0x018b }
            goto L_0x018d
        L_0x018b:
            r0 = move-exception
            goto L_0x01a1
        L_0x018d:
            r3 = r10[r2]     // Catch:{ DocumentException -> 0x018b }
            r3.h(r1)     // Catch:{ DocumentException -> 0x018b }
            r3 = r10[r2]     // Catch:{ DocumentException -> 0x018b }
            boolean r3 = l(r3)     // Catch:{ DocumentException -> 0x018b }
            if (r3 == 0) goto L_0x03c1
            r3 = r10[r2]     // Catch:{ DocumentException -> 0x018b }
            r3.c0(r1)     // Catch:{ DocumentException -> 0x018b }
            goto L_0x03c1
        L_0x01a1:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x01a7:
            r21 = r14
            int r1 = r15.S()
            r8 = 981668463(0x3a83126f, float:0.001)
            r13 = 90
            r14 = 0
            if (r1 == r13) goto L_0x0298
            int r1 = r15.S()
            r11 = 270(0x10e, float:3.78E-43)
            if (r1 != r11) goto L_0x01bf
            goto L_0x0298
        L_0x01bf:
            float r1 = r15.R0()
            float r4 = r15.Q()
            float r4 = r4 + r12
            float r5 = r15.O0()
            float r4 = r4 - r5
            float r5 = r15.O()
            float r5 = r5 + r12
            float r6 = r15.N0()
            float r5 = r5 + r6
            boolean r6 = r15.p1()
            r11 = 180(0xb4, float:2.52E-43)
            if (r6 == 0) goto L_0x0200
            int r6 = r15.U0()
            if (r6 == r7) goto L_0x01fb
            r7 = 1184645120(0x469c4000, float:20000.0)
            if (r6 == r3) goto L_0x01f4
            int r3 = r15.S()
            if (r3 != r11) goto L_0x01f2
        L_0x01f0:
            float r5 = r5 - r7
            goto L_0x0200
        L_0x01f2:
            float r4 = r4 + r7
            goto L_0x0200
        L_0x01f4:
            int r3 = r15.S()
            if (r3 != r11) goto L_0x01f0
            goto L_0x01f2
        L_0x01fb:
            r3 = 1176256512(0x461c4000, float:10000.0)
            float r4 = r4 + r3
            float r5 = r5 - r3
        L_0x0200:
            com.itextpdf.text.pdf.ColumnText r3 = r15.K0()
            if (r25 == 0) goto L_0x020a
            com.itextpdf.text.pdf.ColumnText r3 = com.itextpdf.text.pdf.ColumnText.g(r3)
        L_0x020a:
            r13 = r3
            r13.Y(r10)
            float r3 = r15.P0()
            float r3 = r16 - r3
            float r6 = r15.M0()
            float r3 = r3 - r6
            float r3 = r2 - r3
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 <= 0) goto L_0x0240
            float r1 = r15.N()
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x0240
            float r1 = r15.T()
            float r1 = r1 + r23
            float r2 = r15.P0()
            float r2 = r1 - r2
            float r1 = r15.T()
            float r1 = r1 + r23
            float r1 = r1 - r16
            float r3 = r15.M0()
            float r3 = r3 + r1
        L_0x0240:
            int r1 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x024a
            boolean r1 = r13.x0()
            if (r1 == 0) goto L_0x03c1
        L_0x024a:
            int r1 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x03c1
            float r3 = r3 - r8
            r13.l0(r5, r3, r4, r2)
            int r1 = r15.S()
            if (r1 != r11) goto L_0x0276
            float r7 = r5 + r4
            float r1 = r23 + r23
            float r1 = r1 - r16
            float r2 = r15.M0()
            float r1 = r1 + r2
            float r2 = r15.P0()
            float r8 = r1 - r2
            r5 = 0
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 0
            r1 = r19
            r2 = r24
            r1.p(r2, r3, r4, r5, r6, r7, r8)
        L_0x0276:
            r13.I()     // Catch:{ DocumentException -> 0x0286 }
            int r1 = r15.S()
            if (r1 != r11) goto L_0x03c1
        L_0x027f:
            r9.m(r10)
            goto L_0x03c1
        L_0x0284:
            r0 = move-exception
            goto L_0x028e
        L_0x0286:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter     // Catch:{ all -> 0x0284 }
            r0.<init>(r1)     // Catch:{ all -> 0x0284 }
            throw r0     // Catch:{ all -> 0x0284 }
        L_0x028e:
            int r1 = r15.S()
            if (r1 != r11) goto L_0x0297
            r9.m(r10)
        L_0x0297:
            throw r0
        L_0x0298:
            float r1 = r15.P0()
            float r1 = r16 - r1
            float r2 = r15.M0()
            float r1 = r1 - r2
            float r2 = r15.a0()
            float r3 = r15.N0()
            float r2 = r2 - r3
            float r3 = r15.O0()
            float r2 = r2 - r3
            com.itextpdf.text.pdf.ColumnText r3 = r15.K0()
            com.itextpdf.text.pdf.ColumnText r3 = com.itextpdf.text.pdf.ColumnText.g(r3)
            r3.Y(r10)
            float r8 = r8 + r1
            float r11 = -r2
            r3.l0(r14, r14, r8, r11)
            r3.J(r7)     // Catch:{ DocumentException -> 0x03fa }
            float r7 = r3.H()
            float r7 = -r7
            int r8 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x02d1
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 > 0) goto L_0x02d2
        L_0x02d1:
            r7 = 0
        L_0x02d2:
            int r2 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x03c1
            boolean r2 = r15.s1()
            if (r2 == 0) goto L_0x02e1
            float r2 = r3.r()
            float r7 = r7 - r2
        L_0x02e1:
            com.itextpdf.text.pdf.ColumnText r2 = r15.K0()
            if (r25 == 0) goto L_0x02eb
            com.itextpdf.text.pdf.ColumnText r2 = com.itextpdf.text.pdf.ColumnText.g(r2)
        L_0x02eb:
            r11 = r2
            r11.Y(r10)
            r2 = 994352038(0x3b449ba6, float:0.003)
            float r1 = r1 + r2
            r2 = -1153131610(0xffffffffbb449ba6, float:-0.003)
            r3 = -1165815185(0xffffffffba83126f, float:-0.001)
            r11.l0(r2, r3, r1, r7)
            int r1 = r15.S()
            if (r1 != r13) goto L_0x035a
            float r1 = r15.T()
            float r1 = r1 + r23
            float r1 = r1 - r16
            float r2 = r15.M0()
            float r8 = r1 + r2
            int r1 = r15.k1()
            if (r1 == r5) goto L_0x0335
            if (r1 == r4) goto L_0x0325
            float r1 = r15.O()
            float r1 = r1 + r12
            float r2 = r15.N0()
            float r1 = r1 + r2
            float r1 = r1 + r7
        L_0x0323:
            r7 = r1
            goto L_0x034c
        L_0x0325:
            float r1 = r15.O()
            float r1 = r1 + r12
            float r2 = r15.a0()
            float r1 = r1 + r2
            float r2 = r15.O0()
            float r1 = r1 - r2
            goto L_0x0323
        L_0x0335:
            float r1 = r15.O()
            float r1 = r1 + r12
            float r2 = r15.a0()
            float r3 = r15.N0()
            float r2 = r2 + r3
            float r3 = r15.O0()
            float r2 = r2 - r3
            float r2 = r2 + r7
            float r2 = r2 / r6
            float r1 = r1 + r2
            goto L_0x0323
        L_0x034c:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 0
            r3 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r1 = r19
            r2 = r24
            r1.p(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x03ae
        L_0x035a:
            float r1 = r15.T()
            float r1 = r1 + r23
            float r2 = r15.P0()
            float r8 = r1 - r2
            int r1 = r15.k1()
            if (r1 == r5) goto L_0x038b
            if (r1 == r4) goto L_0x0380
            float r1 = r15.O()
            float r1 = r1 + r12
            float r2 = r15.a0()
            float r1 = r1 + r2
            float r2 = r15.O0()
            float r1 = r1 - r2
            float r1 = r1 - r7
        L_0x037e:
            r7 = r1
            goto L_0x03a1
        L_0x0380:
            float r1 = r15.O()
            float r1 = r1 + r12
            float r2 = r15.N0()
        L_0x0389:
            float r1 = r1 + r2
            goto L_0x037e
        L_0x038b:
            float r1 = r15.O()
            float r1 = r1 + r12
            float r2 = r15.a0()
            float r3 = r15.N0()
            float r2 = r2 + r3
            float r3 = r15.O0()
            float r2 = r2 - r3
            float r2 = r2 - r7
            float r2 = r2 / r6
            goto L_0x0389
        L_0x03a1:
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r3 = 0
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = r19
            r2 = r24
            r1.p(r2, r3, r4, r5, r6, r7, r8)
        L_0x03ae:
            r11.I()     // Catch:{ DocumentException -> 0x03b5 }
            goto L_0x027f
        L_0x03b3:
            r0 = move-exception
            goto L_0x03bd
        L_0x03b5:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter     // Catch:{ all -> 0x03b3 }
            r0.<init>(r1)     // Catch:{ all -> 0x03b3 }
            throw r0     // Catch:{ all -> 0x03b3 }
        L_0x03bd:
            r9.m(r10)
            throw r0
        L_0x03c1:
            com.itextpdf.text.pdf.PdfPCellEvent r1 = r15.I0()
            if (r1 == 0) goto L_0x03e7
            com.itextpdf.text.Rectangle r2 = new com.itextpdf.text.Rectangle
            float r3 = r15.O()
            float r3 = r3 + r12
            float r4 = r15.T()
            float r4 = r4 + r23
            float r4 = r4 - r16
            float r5 = r15.Q()
            float r5 = r5 + r12
            float r6 = r15.T()
            float r6 = r6 + r23
            r2.<init>(r3, r4, r5, r6)
            r1.a(r15, r2, r10)
        L_0x03e7:
            r1 = 3
            r2 = r10[r1]
            boolean r2 = l(r2)
            if (r2 == 0) goto L_0x03f5
            r2 = r10[r1]
            r2.c0(r15)
        L_0x03f5:
            int r14 = r21 + 1
            r13 = 3
            goto L_0x0059
        L_0x03fa:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r1)
            throw r0
        L_0x0402:
            r0 = 3
            r1 = r10[r0]
            boolean r1 = l(r1)
            if (r1 == 0) goto L_0x0410
            r0 = r10[r0]
            r0.c0(r9)
        L_0x0410:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfPRow.B(int, int, float, float, com.itextpdf.text.pdf.PdfContentByte[], boolean):void");
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.e3 = accessibleElementId;
    }

    public PdfName L() {
        return this.c3;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.d3 == null) {
            this.d3 = new HashMap<>();
        }
        this.d3.put(pdfName, pdfObject);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.Y2 = 0.0f;
        this.s.f("calculateHeights");
        int i2 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.Y;
            if (i2 < pdfPCellArr.length) {
                PdfPCell pdfPCell = pdfPCellArr[i2];
                if (pdfPCell != null) {
                    float H0 = pdfPCell.m1() ? pdfPCell.H0() : pdfPCell.Y0();
                    if (H0 > this.Y2 && pdfPCell.g1() == 1) {
                        this.Y2 = H0;
                    }
                }
                i2++;
            } else {
                this.Z2 = true;
                return;
            }
        }
    }

    public void b(PdfPTable pdfPTable, int i2) {
        if (pdfPTable != null) {
            for (int i3 = 0; i3 < this.Y.length; i3++) {
                PdfPCell pdfPCell = pdfPTable.b0(i2).c()[i3];
                int i4 = i2;
                while (pdfPCell == null && i4 > 0) {
                    i4--;
                    pdfPCell = pdfPTable.b0(i4).c()[i3];
                }
                PdfPCell pdfPCell2 = this.Y[i3];
                if (!(pdfPCell2 == null || pdfPCell == null)) {
                    pdfPCell2.x1(pdfPCell.K0());
                    this.Z2 = false;
                }
            }
        }
    }

    public PdfPCell[] c() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public float[] d(float f2, float[] fArr) {
        int i2 = 1;
        int i3 = 0;
        int i4 = 1;
        while (true) {
            PdfPCell[] pdfPCellArr = this.Y;
            if (i3 >= pdfPCellArr.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPCellArr[i3];
            if (pdfPCell == null) {
                while (true) {
                    PdfPCell[] pdfPCellArr2 = this.Y;
                    if (i3 >= pdfPCellArr2.length || pdfPCellArr2[i3] != null) {
                        break;
                    }
                    i4++;
                    i3++;
                }
            } else {
                i4++;
                i3 += pdfPCell.J0();
            }
        }
        float[] fArr2 = new float[i4];
        fArr2[0] = f2;
        int i5 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr3 = this.Y;
            if (i5 >= pdfPCellArr3.length || i2 >= i4) {
                return fArr2;
            }
            PdfPCell pdfPCell2 = pdfPCellArr3[i5];
            if (pdfPCell2 == null) {
                fArr2[i2] = fArr2[i2 - 1];
                while (true) {
                    PdfPCell[] pdfPCellArr4 = this.Y;
                    if (i5 >= pdfPCellArr4.length || pdfPCellArr4[i5] != null) {
                        break;
                    }
                    fArr2[i2] = fArr2[i2] + fArr[i5];
                    i5++;
                }
            } else {
                int J0 = pdfPCell2.J0();
                fArr2[i2] = fArr2[i2 - 1];
                int i6 = 0;
                while (i6 < J0 && i5 < fArr.length) {
                    fArr2[i2] = fArr2[i2] + fArr[i5];
                    i6++;
                    i5++;
                }
            }
            i2++;
        }
        return fArr2;
    }

    public float e() {
        if (!this.Z2) {
            a();
        }
        return this.Y2;
    }

    public float f() {
        return this.Y2;
    }

    public boolean g() {
        int i2 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.Y;
            if (i2 >= pdfPCellArr.length) {
                return false;
            }
            PdfPCell pdfPCell = pdfPCellArr[i2];
            if (pdfPCell != null && pdfPCell.g1() > 1) {
                return true;
            }
            i2++;
        }
    }

    public AccessibleElementId getId() {
        return this.e3;
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.X2 = new float[this.Y.length];
        int i2 = 0;
        while (true) {
            float[] fArr = this.X2;
            if (i2 < fArr.length) {
                fArr[i2] = 0.0f;
                i2++;
            } else {
                return;
            }
        }
    }

    public boolean i() {
        return this.a3;
    }

    public boolean j() {
        return this.Z2;
    }

    public boolean k() {
        return this.X;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.d3;
    }

    /* access modifiers changed from: protected */
    public void m(PdfContentByte[] pdfContentByteArr) {
        for (int i2 = 0; i2 < 4; i2++) {
            ByteBuffer a1 = pdfContentByteArr[i2].a1();
            int C = a1.C();
            pdfContentByteArr[i2].U1();
            int[] iArr = this.b3;
            int i3 = i2 * 2;
            if (C == iArr[i3 + 1]) {
                a1.A(iArr[i3]);
            }
        }
    }

    public boolean n() {
        return false;
    }

    public void o(PdfName pdfName) {
        this.c3 = pdfName;
    }

    /* access modifiers changed from: protected */
    public void p(PdfContentByte[] pdfContentByteArr, float f2, float f4, float f5, float f6, float f7, float f8) {
        if (this.b3 == null) {
            this.b3 = new int[8];
        }
        for (int i2 = 0; i2 < 4; i2++) {
            ByteBuffer a1 = pdfContentByteArr[i2].a1();
            int i3 = i2 * 2;
            this.b3[i3] = a1.C();
            pdfContentByteArr[i2].a2();
            pdfContentByteArr[i2].l0(f2, f4, f5, f6, f7, f8);
            this.b3[i3 + 1] = a1.C();
        }
    }

    public void q(boolean z) {
        this.a3 = z;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.d3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public void t(int i2, float f2) {
        if (i2 >= 0 && i2 < this.Y.length) {
            this.X2[i2] = f2;
        }
    }

    public void u(float f2) {
        v(f2);
        this.Z2 = true;
    }

    public void v(float f2) {
        this.Y2 = f2;
    }

    public void w(boolean z) {
        this.X = z;
    }

    public boolean x(float[] fArr) {
        int length = fArr.length;
        PdfPCell[] pdfPCellArr = this.Y;
        int i2 = 0;
        if (length != pdfPCellArr.length) {
            return false;
        }
        System.arraycopy(fArr, 0, this.Z, 0, pdfPCellArr.length);
        this.Z2 = false;
        float f2 = 0.0f;
        while (i2 < fArr.length) {
            PdfPCell pdfPCell = this.Y[i2];
            if (pdfPCell == null) {
                f2 += fArr[i2];
            } else {
                pdfPCell.w0(f2);
                int J0 = pdfPCell.J0() + i2;
                while (i2 < J0) {
                    f2 += fArr[i2];
                    i2++;
                }
                i2--;
                pdfPCell.x0(f2);
                pdfPCell.z0(0.0f);
            }
            i2++;
        }
        return true;
    }

    public PdfPRow y(PdfPTable pdfPTable, int i2, float f2) {
        int i3;
        float[] fArr;
        float s2;
        float f4;
        PdfPTable pdfPTable2 = pdfPTable;
        int i4 = i2;
        float f5 = f2;
        this.s.f(String.format("Splitting row %s available height: %s", new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}));
        PdfPCell[] pdfPCellArr = this.Y;
        PdfPCell[] pdfPCellArr2 = new PdfPCell[pdfPCellArr.length];
        float[] fArr2 = new float[pdfPCellArr.length];
        float[] fArr3 = new float[pdfPCellArr.length];
        float[] fArr4 = new float[pdfPCellArr.length];
        int i5 = 0;
        boolean z = true;
        while (true) {
            PdfPCell[] pdfPCellArr3 = this.Y;
            if (i5 >= pdfPCellArr3.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPCellArr3[i5];
            if (pdfPCell == null) {
                if (pdfPTable2.F0(i4, i5)) {
                    int i6 = i4;
                    while (true) {
                        i6--;
                        if (!pdfPTable2.F0(i6, i5)) {
                            break;
                        }
                        pdfPTable2.b0(i6).e();
                    }
                    PdfPRow b0 = pdfPTable2.b0(i6);
                    if (!(b0 == null || b0.c()[i5] == null)) {
                        PdfPCell pdfPCell2 = new PdfPCell(b0.c()[i5]);
                        pdfPCellArr2[i5] = pdfPCell2;
                        pdfPCell2.x1((ColumnText) null);
                        pdfPCellArr2[i5].N1((b0.c()[i5].g1() - i4) + i6);
                        z = false;
                    }
                }
                fArr = fArr4;
            } else {
                fArr2[i5] = pdfPCell.H0();
                fArr3[i5] = pdfPCell.R0();
                fArr4[i5] = pdfPCell.Z0();
                Image V0 = pdfPCell.V0();
                PdfPCell pdfPCell3 = new PdfPCell(pdfPCell);
                if (V0 != null) {
                    float M0 = pdfPCell.M0() + pdfPCell.P0() + 2.0f;
                    if ((V0.H1() || V0.o1() + M0 < f5) && f5 > M0) {
                        pdfPCell3.L1((Phrase) null);
                        z = false;
                    }
                    fArr = fArr4;
                } else {
                    ColumnText g2 = ColumnText.g(pdfPCell.K0());
                    float O = pdfPCell.O() + pdfPCell.N0();
                    float T = (pdfPCell.T() + pdfPCell.M0()) - f5;
                    float Q = pdfPCell.Q() - pdfPCell.O0();
                    float T2 = pdfPCell.T() - pdfPCell.P0();
                    int S = pdfPCell.S();
                    fArr = fArr4;
                    if (S == 90 || S == 270) {
                        s2 = s(g2, T, O, T2, Q);
                    } else {
                        float f6 = T + 1.0E-5f;
                        if (pdfPCell.p1()) {
                            Q = 20000.0f;
                        }
                        s2 = s(g2, O, f6, Q, T2);
                    }
                    try {
                        int J = g2.J(true);
                        boolean z2 = g2.H() == s2;
                        if (z2) {
                            pdfPCell3.x1(ColumnText.g(pdfPCell.K0()));
                            f4 = 0.0f;
                        } else {
                            f4 = 0.0f;
                            if ((J & 1) == 0) {
                                pdfPCell3.x1(g2);
                            } else {
                                pdfPCell3.L1((Phrase) null);
                                z = !z && z2;
                            }
                        }
                        g2.b0(f4);
                        z = !z && z2;
                    } catch (DocumentException e2) {
                        throw new ExceptionConverter(e2);
                    }
                }
                pdfPCellArr2[i5] = pdfPCell3;
                pdfPCell.u1(f5);
            }
            i5++;
            pdfPTable2 = pdfPTable;
            i4 = i2;
            fArr4 = fArr;
        }
        float[] fArr5 = fArr4;
        if (z) {
            int i7 = 0;
            while (true) {
                PdfPCell[] pdfPCellArr4 = this.Y;
                if (i7 >= pdfPCellArr4.length) {
                    return null;
                }
                PdfPCell pdfPCell4 = pdfPCellArr4[i7];
                if (pdfPCell4 == null) {
                    i3 = 1;
                } else {
                    pdfPCell4.u1(fArr2[i7]);
                    float f7 = fArr3[i7];
                    if (f7 > 0.0f) {
                        pdfPCell4.z1(f7);
                    } else {
                        pdfPCell4.F1(fArr5[i7]);
                    }
                    i3 = 1;
                }
                i7 += i3;
            }
        } else {
            a();
            PdfPRow pdfPRow = new PdfPRow(pdfPCellArr2, this);
            pdfPRow.Z = (float[]) this.Z.clone();
            return pdfPRow;
        }
    }

    public void z(PdfPTable pdfPTable, int i2, PdfPTable pdfPTable2, int i3) {
        if (pdfPTable != null && pdfPTable2 != null) {
            int i4 = 0;
            while (true) {
                PdfPCell[] pdfPCellArr = this.Y;
                if (i4 < pdfPCellArr.length) {
                    PdfPCell pdfPCell = pdfPCellArr[i4];
                    if (pdfPCell == null) {
                        int G = pdfPTable.G(i2, i4);
                        int G2 = pdfPTable2.G(i3, i4);
                        PdfPCell pdfPCell2 = pdfPTable.b0(G).c()[i4];
                        PdfPCell pdfPCell3 = pdfPTable2.b0(G2).c()[i4];
                        if (pdfPCell2 != null) {
                            this.Y[i4] = new PdfPCell(pdfPCell3);
                            int i5 = (i3 - G2) + 1;
                            this.Y[i4].N1(pdfPCell3.g1() - i5);
                            pdfPCell2.N1(i5);
                            this.Z2 = false;
                        }
                        i4++;
                    } else {
                        i4 += pdfPCell.J0();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public PdfPRow(PdfPCell[] pdfPCellArr) {
        this(pdfPCellArr, (PdfPRow) null);
    }

    public PdfPRow(PdfPCell[] pdfPCellArr, PdfPRow pdfPRow) {
        this.s = LoggerFactory.b(PdfPRow.class);
        this.X = false;
        this.Y2 = 0.0f;
        this.Z2 = false;
        this.a3 = false;
        this.c3 = PdfName.Of;
        this.d3 = null;
        this.e3 = new AccessibleElementId();
        this.Y = pdfPCellArr;
        this.Z = new float[pdfPCellArr.length];
        h();
        if (pdfPRow != null) {
            this.e3 = pdfPRow.e3;
            this.c3 = pdfPRow.c3;
            if (pdfPRow.d3 != null) {
                this.d3 = new HashMap<>(pdfPRow.d3);
            }
        }
    }
}
