package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;

public class PushbuttonField extends BaseField {
    public static final int S = 1;
    public static final int T = 2;
    public static final int U = 3;
    public static final int V = 4;
    public static final int W = 5;
    public static final int X = 6;
    public static final int Y = 7;
    public static final int Z = 1;
    public static final int a0 = 2;
    public static final int b0 = 3;
    public static final int c0 = 4;
    private int I = 1;
    private Image J;
    private PdfTemplate K;
    private int L = 1;
    private boolean M = true;
    private float N = 0.5f;
    private float O = 0.5f;
    private boolean P;
    private PdfTemplate Q;
    private PRIndirectReference R;

    public PushbuttonField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        super(pdfWriter, rectangle, str);
    }

    private float P(float f2, float f3) throws IOException, DocumentException {
        BaseFont q = q();
        float f4 = this.f25930g;
        if (f4 != 0.0f) {
            return f4;
        }
        float Z2 = q.Z(this.f25933j, 1.0f);
        float min = Math.min(Z2 == 0.0f ? 12.0f : f2 / Z2, f3 / (1.0f - q.I(3, 1.0f)));
        if (min < 4.0f) {
            return 4.0f;
        }
        return min;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0245, code lost:
        if (r6 == 7) goto L_0x0250;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0248, code lost:
        if (r6 != 2) goto L_0x024b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x024b, code lost:
        r15 = r8;
        r9 = r20;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0250, code lost:
        r6 = new com.itextpdf.text.Rectangle(r11.O() + r4, r11.H() + r4, r11.Q() - r4, r11.T() - r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0090, code lost:
        if (r0.R == null) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d4, code lost:
        r8 = r0.f25930g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d6, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0475  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x047f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfAppearance Q() throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            r29 = this;
            r0 = r29
            com.itextpdf.text.pdf.PdfAppearance r10 = r29.f()
            com.itextpdf.text.Rectangle r11 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r1 = r10.F3()
            r11.<init>((com.itextpdf.text.Rectangle) r1)
            java.lang.String r1 = r0.f25933j
            r2 = 1
            if (r1 == 0) goto L_0x001a
            int r1 = r1.length()
            if (r1 != 0) goto L_0x002c
        L_0x001a:
            int r1 = r0.I
            if (r1 == r2) goto L_0x04b8
            com.itextpdf.text.Image r1 = r0.J
            if (r1 != 0) goto L_0x002c
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.K
            if (r1 != 0) goto L_0x002c
            com.itextpdf.text.pdf.PRIndirectReference r1 = r0.R
            if (r1 != 0) goto L_0x002c
            goto L_0x04b8
        L_0x002c:
            int r1 = r0.I
            r3 = 2
            if (r1 != r3) goto L_0x003e
            com.itextpdf.text.Image r1 = r0.J
            if (r1 != 0) goto L_0x003e
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.K
            if (r1 != 0) goto L_0x003e
            com.itextpdf.text.pdf.PRIndirectReference r1 = r0.R
            if (r1 != 0) goto L_0x003e
            return r10
        L_0x003e:
            com.itextpdf.text.pdf.BaseFont r12 = r29.q()
            int r1 = r0.f25925b
            r5 = 3
            if (r1 == r3) goto L_0x004c
            if (r1 != r5) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r1 = 0
            goto L_0x004d
        L_0x004c:
            r1 = 1
        L_0x004d:
            r11.N()
            float r6 = r0.f25924a
            r7 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x0059
            float r8 = r6 * r7
            goto L_0x005a
        L_0x0059:
            r8 = r6
        L_0x005a:
            if (r1 == 0) goto L_0x005e
            float r6 = r6 * r7
        L_0x005e:
            r1 = 1065353216(0x3f800000, float:1.0)
            float r6 = java.lang.Math.max(r6, r1)
            float r13 = java.lang.Math.min(r8, r6)
            r6 = 0
            r0.Q = r6
            float r8 = r0.f25930g
            float r9 = r11.a0()
            float r14 = r13 * r7
            float r9 = r9 - r14
            float r9 = r9 - r7
            float r15 = r11.N()
            float r15 = r15 - r14
            boolean r4 = r0.P
            r17 = 0
            if (r4 == 0) goto L_0x0082
            r4 = 0
            goto L_0x0084
        L_0x0082:
            float r4 = r13 + r1
        L_0x0084:
            int r6 = r0.I
            com.itextpdf.text.Image r3 = r0.J
            if (r3 != 0) goto L_0x0093
            com.itextpdf.text.pdf.PdfTemplate r3 = r0.K
            if (r3 != 0) goto L_0x0093
            com.itextpdf.text.pdf.PRIndirectReference r3 = r0.R
            if (r3 != 0) goto L_0x0093
            goto L_0x00d6
        L_0x0093:
            r3 = 1082130432(0x40800000, float:4.0)
            r19 = 1051931443(0x3eb33333, float:0.35)
            r20 = 2143289344(0x7fc00000, float:NaN)
            switch(r6) {
                case 1: goto L_0x0215;
                case 2: goto L_0x0243;
                case 3: goto L_0x01c2;
                case 4: goto L_0x0169;
                case 5: goto L_0x0108;
                case 6: goto L_0x00a4;
                case 7: goto L_0x0215;
                default: goto L_0x009d;
            }
        L_0x009d:
            r15 = r8
            r3 = 0
            r6 = 0
            r9 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x026c
        L_0x00a4:
            java.lang.String r6 = r0.f25933j
            if (r6 == 0) goto L_0x0106
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0106
            int r6 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r6 <= 0) goto L_0x0106
            int r6 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r6 > 0) goto L_0x00b7
            goto L_0x0106
        L_0x00b7:
            float r6 = r11.a0()
            float r6 = r6 * r19
            float r6 = r6 - r13
            int r8 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c8
            float r3 = r0.P(r9, r6)
            r8 = r3
            goto L_0x00ca
        L_0x00c8:
            r8 = 1082130432(0x40800000, float:4.0)
        L_0x00ca:
            java.lang.String r3 = r0.f25933j
            float r3 = r12.Z(r3, r8)
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 < 0) goto L_0x00d8
        L_0x00d4:
            float r8 = r0.f25930g
        L_0x00d6:
            r6 = 1
            goto L_0x0093
        L_0x00d8:
            float r20 = r13 + r1
            float r3 = r11.N()
            float r6 = r12.I(r2, r8)
            float r3 = r3 - r6
            float r3 = r3 / r7
            com.itextpdf.text.Rectangle r6 = new com.itextpdf.text.Rectangle
            java.lang.String r7 = r0.f25933j
            float r7 = r12.Z(r7, r8)
            float r7 = r20 + r7
            float r9 = r11.H()
            float r9 = r9 + r4
            float r15 = r11.Q()
            float r15 = r15 - r4
            float r19 = r11.T()
            float r4 = r19 - r4
            r6.<init>(r7, r9, r15, r4)
        L_0x0101:
            r15 = r8
            r9 = r20
            goto L_0x026c
        L_0x0106:
            r6 = 2
            goto L_0x0093
        L_0x0108:
            java.lang.String r6 = r0.f25933j
            if (r6 == 0) goto L_0x0106
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0106
            int r6 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r6 <= 0) goto L_0x0106
            int r6 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r6 > 0) goto L_0x011b
            goto L_0x0106
        L_0x011b:
            float r6 = r11.a0()
            float r6 = r6 * r19
            float r6 = r6 - r13
            int r8 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x012c
            float r3 = r0.P(r9, r6)
            r8 = r3
            goto L_0x012e
        L_0x012c:
            r8 = 1082130432(0x40800000, float:4.0)
        L_0x012e:
            java.lang.String r3 = r0.f25933j
            float r3 = r12.Z(r3, r8)
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 < 0) goto L_0x0139
            goto L_0x00d4
        L_0x0139:
            float r3 = r11.a0()
            java.lang.String r6 = r0.f25933j
            float r6 = r12.Z(r6, r8)
            float r3 = r3 - r6
            float r3 = r3 - r13
            float r20 = r3 - r1
            float r3 = r11.N()
            float r6 = r12.I(r2, r8)
            float r3 = r3 - r6
            float r3 = r3 / r7
            com.itextpdf.text.Rectangle r6 = new com.itextpdf.text.Rectangle
            float r7 = r11.O()
            float r7 = r7 + r4
            float r9 = r11.H()
            float r9 = r9 + r4
            float r15 = r20 - r1
            float r19 = r11.T()
            float r4 = r19 - r4
            r6.<init>(r7, r9, r15, r4)
            goto L_0x0101
        L_0x0169:
            java.lang.String r6 = r0.f25933j
            if (r6 == 0) goto L_0x0106
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0106
            int r6 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r6 <= 0) goto L_0x0106
            int r6 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r6 > 0) goto L_0x017c
            goto L_0x0106
        L_0x017c:
            float r6 = r11.N()
            float r6 = r6 * r19
            float r6 = r6 - r13
            int r8 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x018d
            float r3 = r0.P(r9, r6)
            r8 = r3
            goto L_0x018f
        L_0x018d:
            r8 = 1082130432(0x40800000, float:4.0)
        L_0x018f:
            float r3 = r11.a0()
            java.lang.String r6 = r0.f25933j
            float r6 = r12.Z(r6, r8)
            float r3 = r3 - r6
            float r20 = r3 / r7
            float r3 = r11.N()
            float r3 = r3 - r13
            float r3 = r3 - r8
            int r6 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r6 >= 0) goto L_0x01a7
            r3 = r13
        L_0x01a7:
            com.itextpdf.text.Rectangle r6 = new com.itextpdf.text.Rectangle
            float r7 = r11.O()
            float r7 = r7 + r4
            float r9 = r11.H()
            float r9 = r9 + r4
            float r15 = r11.Q()
            float r15 = r15 - r4
            float r4 = r12.I(r5, r8)
            float r4 = r4 + r3
            r6.<init>(r7, r9, r15, r4)
            goto L_0x0101
        L_0x01c2:
            java.lang.String r6 = r0.f25933j
            if (r6 == 0) goto L_0x0106
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0106
            int r6 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r6 <= 0) goto L_0x0106
            int r6 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r6 > 0) goto L_0x01d6
            goto L_0x0106
        L_0x01d6:
            float r6 = r11.N()
            float r6 = r6 * r19
            float r6 = r6 - r13
            int r8 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x01e7
            float r3 = r0.P(r9, r6)
            r8 = r3
            goto L_0x01e9
        L_0x01e7:
            r8 = 1082130432(0x40800000, float:4.0)
        L_0x01e9:
            float r3 = r11.a0()
            java.lang.String r6 = r0.f25933j
            float r6 = r12.Z(r6, r8)
            float r3 = r3 - r6
            float r20 = r3 / r7
            float r3 = r12.I(r5, r8)
            float r3 = r13 - r3
            com.itextpdf.text.Rectangle r6 = new com.itextpdf.text.Rectangle
            float r7 = r11.O()
            float r7 = r7 + r4
            float r9 = r3 + r8
            float r15 = r11.Q()
            float r15 = r15 - r4
            float r19 = r11.T()
            float r4 = r19 - r4
            r6.<init>(r7, r9, r15, r4)
            goto L_0x0101
        L_0x0215:
            java.lang.String r3 = r0.f25933j
            if (r3 == 0) goto L_0x0243
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0243
            int r3 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0243
            int r3 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x0243
            float r8 = r0.P(r9, r15)
            float r3 = r11.a0()
            java.lang.String r9 = r0.f25933j
            float r9 = r12.Z(r9, r8)
            float r3 = r3 - r9
            float r20 = r3 / r7
            float r3 = r11.N()
            float r9 = r12.I(r2, r8)
            float r3 = r3 - r9
            float r3 = r3 / r7
            goto L_0x0244
        L_0x0243:
            r3 = 0
        L_0x0244:
            r7 = 7
            if (r6 == r7) goto L_0x0250
            r7 = 2
            if (r6 != r7) goto L_0x024b
            goto L_0x0250
        L_0x024b:
            r15 = r8
            r9 = r20
            r6 = 0
            goto L_0x026c
        L_0x0250:
            com.itextpdf.text.Rectangle r6 = new com.itextpdf.text.Rectangle
            float r7 = r11.O()
            float r7 = r7 + r4
            float r9 = r11.H()
            float r9 = r9 + r4
            float r15 = r11.Q()
            float r15 = r15 - r4
            float r19 = r11.T()
            float r4 = r19 - r4
            r6.<init>(r7, r9, r15, r4)
            goto L_0x0101
        L_0x026c:
            float r4 = r11.H()
            float r4 = r4 + r13
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x027a
            float r3 = r11.H()
            float r3 = r3 + r13
        L_0x027a:
            r8 = r3
            if (r6 == 0) goto L_0x028e
            float r3 = r6.a0()
            int r3 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r3 <= 0) goto L_0x028d
            float r3 = r6.N()
            int r3 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r3 > 0) goto L_0x028e
        L_0x028d:
            r6 = 0
        L_0x028e:
            if (r6 == 0) goto L_0x0369
            com.itextpdf.text.Image r3 = r0.J
            if (r3 == 0) goto L_0x02e4
            com.itextpdf.text.pdf.PdfTemplate r3 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfWriter r4 = r0.f25932i
            r3.<init>(r4)
            r0.Q = r3
            com.itextpdf.text.Rectangle r4 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Image r7 = r0.J
            r4.<init>((com.itextpdf.text.Rectangle) r7)
            r3.S3(r4)
            com.itextpdf.text.pdf.PdfWriter r3 = r0.f25932i
            com.itextpdf.text.pdf.PdfTemplate r4 = r0.Q
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.A8
            r3.X(r4, r7)
            com.itextpdf.text.pdf.PdfTemplate r3 = r0.Q
            com.itextpdf.text.Image r4 = r0.J
            float r21 = r4.a0()
            com.itextpdf.text.Image r7 = r0.J
            float r24 = r7.N()
            r25 = 0
            r26 = 0
            r22 = 0
            r23 = 0
            r19 = r3
            r20 = r4
            r19.l(r20, r21, r22, r23, r24, r25, r26)
            com.itextpdf.text.pdf.PdfTemplate r3 = r0.Q
            com.itextpdf.text.Rectangle r3 = r3.F3()
            float r3 = r3.a0()
            com.itextpdf.text.pdf.PdfTemplate r4 = r0.Q
            com.itextpdf.text.Rectangle r4 = r4.F3()
            float r4 = r4.N()
        L_0x02e1:
            r7 = 0
            goto L_0x036e
        L_0x02e4:
            com.itextpdf.text.pdf.PdfTemplate r3 = r0.K
            if (r3 == 0) goto L_0x033d
            com.itextpdf.text.pdf.PdfTemplate r3 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfWriter r4 = r0.f25932i
            r3.<init>(r4)
            r0.Q = r3
            com.itextpdf.text.Rectangle r4 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.pdf.PdfTemplate r7 = r0.K
            float r7 = r7.P3()
            com.itextpdf.text.pdf.PdfTemplate r2 = r0.K
            float r2 = r2.I3()
            r4.<init>(r7, r2)
            r3.S3(r4)
            com.itextpdf.text.pdf.PdfWriter r2 = r0.f25932i
            com.itextpdf.text.pdf.PdfTemplate r3 = r0.Q
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.A8
            r2.X(r3, r4)
            com.itextpdf.text.pdf.PdfTemplate r2 = r0.Q
            com.itextpdf.text.pdf.PdfTemplate r3 = r0.K
            com.itextpdf.text.Rectangle r4 = r3.F3()
            float r4 = r4.O()
            com.itextpdf.text.pdf.PdfTemplate r7 = r0.K
            com.itextpdf.text.Rectangle r7 = r7.F3()
            float r7 = r7.H()
            r2.z(r3, r4, r7)
            com.itextpdf.text.pdf.PdfTemplate r2 = r0.Q
            com.itextpdf.text.Rectangle r2 = r2.F3()
            float r3 = r2.a0()
            com.itextpdf.text.pdf.PdfTemplate r2 = r0.Q
            com.itextpdf.text.Rectangle r2 = r2.F3()
            float r4 = r2.N()
            r2 = 1
            goto L_0x02e1
        L_0x033d:
            com.itextpdf.text.pdf.PRIndirectReference r2 = r0.R
            if (r2 == 0) goto L_0x0369
            com.itextpdf.text.pdf.PdfObject r2 = com.itextpdf.text.pdf.PdfReader.t0(r2)
            com.itextpdf.text.pdf.PdfDictionary r2 = (com.itextpdf.text.pdf.PdfDictionary) r2
            if (r2 == 0) goto L_0x0369
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.n4
            com.itextpdf.text.pdf.PdfArray r3 = r2.e0(r3)
            com.itextpdf.text.Rectangle r3 = com.itextpdf.text.pdf.PdfReader.b0(r3)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Qa
            com.itextpdf.text.pdf.PdfArray r2 = r2.e0(r4)
            float r4 = r3.a0()
            float r3 = r3.N()
            r7 = r2
            r2 = 1
            r28 = r4
            r4 = r3
            r3 = r28
            goto L_0x036e
        L_0x0369:
            r2 = 0
            r3 = 0
            r4 = 0
            goto L_0x02e1
        L_0x036e:
            if (r2 == 0) goto L_0x0475
            float r2 = r6.a0()
            float r2 = r2 / r3
            float r16 = r6.N()
            float r1 = r16 / r4
            boolean r5 = r0.M
            r19 = r8
            if (r5 == 0) goto L_0x03aa
            int r5 = r0.L
            r8 = 2
            if (r5 == r8) goto L_0x03a3
            r8 = 3
            if (r5 == r8) goto L_0x0398
            r8 = 4
            float r1 = java.lang.Math.min(r2, r1)
            if (r5 == r8) goto L_0x0391
            goto L_0x03a7
        L_0x0391:
            r5 = 1065353216(0x3f800000, float:1.0)
            float r1 = java.lang.Math.max(r1, r5)
            goto L_0x03a7
        L_0x0398:
            r5 = 1065353216(0x3f800000, float:1.0)
            float r1 = java.lang.Math.min(r2, r1)
            float r1 = java.lang.Math.min(r1, r5)
            goto L_0x03a7
        L_0x03a3:
            r5 = 1065353216(0x3f800000, float:1.0)
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x03a7:
            r5 = r1
            r8 = r5
            goto L_0x03d4
        L_0x03aa:
            r5 = 1065353216(0x3f800000, float:1.0)
            int r8 = r0.L
            r5 = 2
            if (r8 == r5) goto L_0x03d0
            r5 = 3
            if (r8 == r5) goto L_0x03c5
            r5 = 4
            if (r8 == r5) goto L_0x03ba
        L_0x03b7:
            r8 = r1
            r5 = r2
            goto L_0x03d4
        L_0x03ba:
            r5 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.max(r2, r5)
            float r1 = java.lang.Math.max(r1, r5)
            goto L_0x03b7
        L_0x03c5:
            r5 = 1065353216(0x3f800000, float:1.0)
            float r2 = java.lang.Math.min(r2, r5)
            float r1 = java.lang.Math.min(r1, r5)
            goto L_0x03b7
        L_0x03d0:
            r5 = 1065353216(0x3f800000, float:1.0)
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x03d4:
            float r1 = r6.O()
            float r2 = r6.a0()
            float r3 = r3 * r5
            float r2 = r2 - r3
            float r3 = r0.O
            float r2 = r2 * r3
            float r16 = r1 + r2
            float r1 = r6.H()
            float r2 = r6.N()
            float r4 = r4 * r8
            float r2 = r2 - r4
            float r3 = r0.N
            float r2 = r2 * r3
            float r18 = r1 + r2
            r10.a2()
            float r1 = r6.O()
            float r2 = r6.H()
            float r3 = r6.a0()
            float r4 = r6.N()
            r10.H1(r1, r2, r3, r4)
            r10.b0()
            r10.x1()
            com.itextpdf.text.pdf.PdfTemplate r2 = r0.Q
            if (r2 == 0) goto L_0x0428
            r4 = 0
            r6 = 0
            r1 = r10
            r3 = r5
            r5 = r6
            r6 = r8
            r7 = r16
            r27 = r19
            r8 = r18
            r1.A(r2, r3, r4, r5, r6, r7, r8)
            r16 = r9
            goto L_0x0471
        L_0x0428:
            r27 = r19
            if (r7 == 0) goto L_0x0454
            int r1 = r7.size()
            r2 = 6
            if (r1 != r2) goto L_0x0454
            r1 = 4
            com.itextpdf.text.pdf.PdfNumber r1 = r7.J0(r1)
            if (r1 == 0) goto L_0x043f
            float r1 = r1.a0()
            goto L_0x0440
        L_0x043f:
            r1 = 0
        L_0x0440:
            r2 = 5
            com.itextpdf.text.pdf.PdfNumber r2 = r7.J0(r2)
            if (r2 == 0) goto L_0x0452
            float r17 = r2.a0()
            r28 = r17
            r17 = r1
            r1 = r28
            goto L_0x0455
        L_0x0452:
            r17 = r1
        L_0x0454:
            r1 = 0
        L_0x0455:
            com.itextpdf.text.pdf.PRIndirectReference r2 = r0.R
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.A8
            float r17 = r17 * r5
            float r16 = r16 - r17
            float r1 = r1 * r8
            float r17 = r18 - r1
            r6 = 0
            r7 = 0
            r1 = r10
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r16
            r16 = r9
            r9 = r17
            r1.H(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x0471:
            r10.U1()
            goto L_0x0479
        L_0x0475:
            r27 = r8
            r16 = r9
        L_0x0479:
            boolean r1 = java.lang.Float.isNaN(r16)
            if (r1 != 0) goto L_0x04b8
            r10.a2()
            float r1 = r11.a0()
            float r1 = r1 - r14
            float r2 = r11.N()
            float r2 = r2 - r14
            r10.H1(r13, r13, r1, r2)
            r10.b0()
            r10.x1()
            com.itextpdf.text.BaseColor r1 = r0.f25928e
            if (r1 != 0) goto L_0x049d
            r10.P1()
            goto L_0x04a0
        L_0x049d:
            r10.h2(r1)
        L_0x04a0:
            r10.R()
            r10.s2(r12, r15)
            r1 = r16
            r3 = r27
            r10.e3(r1, r3)
            java.lang.String r1 = r0.f25933j
            r10.m3(r1)
            r10.L0()
            r10.U1()
        L_0x04b8:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PushbuttonField.Q():com.itextpdf.text.pdf.PdfAppearance");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfFormField R() throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            r8 = this;
            com.itextpdf.text.pdf.PdfWriter r0 = r8.f25932i
            com.itextpdf.text.pdf.PdfFormField r0 = com.itextpdf.text.pdf.PdfFormField.V2(r0)
            com.itextpdf.text.Rectangle r1 = r8.f25934k
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfAnnotation.A3
            r0.r3(r1, r2)
            java.lang.String r1 = r8.f25937n
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0026
            r0.j3(r1)
            int r1 = r8.o
            r1 = r1 & r3
            if (r1 == 0) goto L_0x001e
            r0.i3(r3)
        L_0x001e:
            int r1 = r8.o
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0026
            r0.i3(r2)
        L_0x0026:
            java.lang.String r1 = r8.f25933j
            if (r1 == 0) goto L_0x002d
            r0.v2(r1)
        L_0x002d:
            int r1 = r8.f25935l
            if (r1 == 0) goto L_0x0034
            r0.A2(r1)
        L_0x0034:
            com.itextpdf.text.pdf.PdfBorderDictionary r1 = new com.itextpdf.text.pdf.PdfBorderDictionary
            float r4 = r8.f25924a
            int r5 = r8.f25925b
            com.itextpdf.text.pdf.PdfDashPattern r6 = new com.itextpdf.text.pdf.PdfDashPattern
            r7 = 1077936128(0x40400000, float:3.0)
            r6.<init>(r7)
            r1.<init>(r4, r5, r6)
            r0.k2(r1)
            com.itextpdf.text.pdf.PdfAppearance r1 = r8.Q()
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfAnnotation.O3
            r0.c2(r4, r1)
            com.itextpdf.text.pdf.PdfContentByte r1 = r1.U0()
            com.itextpdf.text.pdf.PdfAppearance r1 = (com.itextpdf.text.pdf.PdfAppearance) r1
            com.itextpdf.text.pdf.BaseFont r4 = r8.q()
            float r5 = r8.f25930g
            r1.s2(r4, r5)
            com.itextpdf.text.BaseColor r4 = r8.f25928e
            if (r4 != 0) goto L_0x0068
            r4 = 0
            r1.u2(r4)
            goto L_0x006b
        L_0x0068:
            r1.h2(r4)
        L_0x006b:
            r0.m2(r1)
            com.itextpdf.text.BaseColor r1 = r8.f25926c
            if (r1 == 0) goto L_0x0075
            r0.t2(r1)
        L_0x0075:
            com.itextpdf.text.BaseColor r1 = r8.f25927d
            if (r1 == 0) goto L_0x007c
            r0.s2(r1)
        L_0x007c:
            int r1 = r8.f25936m
            r4 = 4
            r5 = 3
            if (r1 == r3) goto L_0x0090
            if (r1 == r2) goto L_0x0092
            if (r1 == r5) goto L_0x008a
            r0.n2(r4)
            goto L_0x0092
        L_0x008a:
            r1 = 36
        L_0x008c:
            r0.n2(r1)
            goto L_0x0092
        L_0x0090:
            r1 = 6
            goto L_0x008c
        L_0x0092:
            com.itextpdf.text.pdf.PdfTemplate r1 = r8.Q
            if (r1 == 0) goto L_0x0099
            r0.x2(r1)
        L_0x0099:
            int r1 = r8.I
            int r1 = r1 - r3
            r0.B2(r1)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.k3
            int r3 = r8.L
            if (r3 != r5) goto L_0x00a8
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.h4
            goto L_0x00b3
        L_0x00a8:
            if (r3 != r4) goto L_0x00ad
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Ce
            goto L_0x00b3
        L_0x00ad:
            if (r3 != r2) goto L_0x00b2
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.kb
            goto L_0x00b3
        L_0x00b2:
            r2 = r1
        L_0x00b3:
            boolean r3 = r8.M
            if (r3 == 0) goto L_0x00b9
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.tc
        L_0x00b9:
            r3 = r1
            float r4 = r8.O
            float r5 = r8.N
            boolean r6 = r8.P
            r1 = r0
            r1.u2(r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PushbuttonField.R():com.itextpdf.text.pdf.PdfFormField");
    }

    public float S() {
        return this.O;
    }

    public PRIndirectReference T() {
        return this.R;
    }

    public float U() {
        return this.N;
    }

    public Image V() {
        return this.J;
    }

    public int W() {
        return this.I;
    }

    public int X() {
        return this.L;
    }

    public PdfTemplate Y() {
        return this.K;
    }

    public boolean Z() {
        return this.P;
    }

    public boolean a0() {
        return this.M;
    }

    public void b0(boolean z) {
        this.P = z;
    }

    public void c0(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.O = f2;
    }

    public void d0(PRIndirectReference pRIndirectReference) {
        this.R = pRIndirectReference;
    }

    public void e0(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.N = f2;
    }

    public void f0(Image image) {
        this.J = image;
        this.K = null;
    }

    public void g0(int i2) {
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException(MessageLocalization.b("layout.out.of.bounds", new Object[0]));
        }
        this.I = i2;
    }

    public void h0(boolean z) {
        this.M = z;
    }

    public void i0(int i2) {
        if (i2 < 1 || i2 > 4) {
            i2 = 1;
        }
        this.L = i2;
    }

    public void j0(PdfTemplate pdfTemplate) {
        this.K = pdfTemplate;
        this.J = null;
    }
}
