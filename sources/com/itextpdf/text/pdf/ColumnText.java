package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColumnText {
    public static final int T = 1;
    public static final int U = 4;
    public static final int V = 8;
    public static final int W = 32;
    public static final int X = 64;
    public static final int Y = 96;
    public static final int Z = 128;
    public static final int a0 = 0;
    public static final int b0 = 256;
    public static final float c0 = 0.0f;
    public static final int d0 = 0;
    public static final int e0 = 1;
    public static final int f0 = 2;
    protected static final int g0 = 0;
    protected static final int h0 = 1;
    protected static final int i0 = 2;
    private boolean A = true;
    private boolean B = true;
    private int C;
    private float D;
    private boolean E = false;
    private int F = 0;
    protected float G;
    protected boolean H = false;
    protected ColumnText I;
    protected LinkedList<Element> J;
    protected int K = 0;
    protected int L = 0;
    private int M = -2;
    protected Phrase N;
    private boolean O = false;
    private float P;
    private boolean Q = true;
    private boolean R = false;
    private boolean S = true;

    /* renamed from: a  reason: collision with root package name */
    private final Logger f26016a = LoggerFactory.b(ColumnText.class);

    /* renamed from: b  reason: collision with root package name */
    protected int f26017b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected float f26018c;

    /* renamed from: d  reason: collision with root package name */
    protected float f26019d;

    /* renamed from: e  reason: collision with root package name */
    protected float f26020e;

    /* renamed from: f  reason: collision with root package name */
    protected float f26021f;

    /* renamed from: g  reason: collision with root package name */
    protected int f26022g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<float[]> f26023h;

    /* renamed from: i  reason: collision with root package name */
    protected ArrayList<float[]> f26024i;

    /* renamed from: j  reason: collision with root package name */
    protected BidiLine f26025j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f26026k;

    /* renamed from: l  reason: collision with root package name */
    protected float f26027l;

    /* renamed from: m  reason: collision with root package name */
    protected float f26028m;

    /* renamed from: n  reason: collision with root package name */
    protected float f26029n = 16.0f;
    protected float o = 16.0f;
    protected float p = 0.0f;
    protected PdfContentByte q;
    protected PdfContentByte[] r;
    protected int s;
    protected float t = 0.0f;
    protected float u = 0.0f;
    protected float v = 0.0f;
    protected float w = 0.0f;
    protected float x = -1.0f;
    protected boolean y = false;
    private float z = 0.0f;

    public ColumnText(PdfContentByte pdfContentByte) {
        this.q = pdfContentByte;
    }

    public static float F(Phrase phrase) {
        return G(phrase, 1, 0);
    }

    public static float G(Phrase phrase, int i2, int i3) {
        ColumnText columnText = new ColumnText((PdfContentByte) null);
        columnText.c(phrase);
        columnText.d();
        PdfLine r2 = columnText.f26025j.r(0.0f, 20000.0f, 0, i2, i3, 0.0f, 0.0f, 0.0f);
        if (r2 == null) {
            return 0.0f;
        }
        return 20000.0f - r2.B();
    }

    public static boolean M(int i2) {
        return (i2 & 1) == 0;
    }

    public static boolean O(Element element) {
        int type = element.type();
        return type == 10 || type == 11 || type == 37 || type == 12 || type == 14 || type == 55 || type == 23 || (element instanceof Image);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r1 = r1.Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean Q(com.itextpdf.text.pdf.PdfContentByte r1) {
        /*
            if (r1 == 0) goto L_0x0012
            com.itextpdf.text.pdf.PdfDocument r0 = r1.Z
            if (r0 == 0) goto L_0x0012
            com.itextpdf.text.pdf.PdfWriter r1 = r1.Y
            if (r1 == 0) goto L_0x0012
            boolean r1 = r1.X1()
            if (r1 == 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = 0
        L_0x0013:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.Q(com.itextpdf.text.pdf.PdfContentByte):boolean");
    }

    private void d() {
        if (this.f26025j == null && this.N != null) {
            this.f26025j = new BidiLine();
            for (Chunk pdfChunk : this.N.Y()) {
                this.f26025j.a(new PdfChunk(pdfChunk, (PdfAction) null, this.N.F0()));
            }
            this.N = null;
        }
    }

    public static ColumnText g(ColumnText columnText) {
        ColumnText columnText2 = new ColumnText((PdfContentByte) null);
        columnText2.T(columnText);
        return columnText2;
    }

    public static float k(Font font, String str, Rectangle rectangle, float f2, int i2) {
        float f3;
        Font font2 = font;
        String str2 = str;
        int i3 = i2;
        if (f2 <= 0.0f) {
            try {
                char[] charArray = str.toCharArray();
                int i4 = 0;
                int i5 = 0;
                for (char c2 : charArray) {
                    if (c2 == 10) {
                        i5++;
                    } else if (c2 == 13) {
                        i4++;
                    }
                }
                f3 = (Math.abs(rectangle.N()) / ((float) (Math.max(i4, i5) + 1))) - 0.001f;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            f3 = f2;
        }
        font2.y(f3);
        Phrase phrase = new Phrase(str2, font2);
        ColumnText columnText = new ColumnText((PdfContentByte) null);
        columnText.n0(phrase, rectangle.O(), rectangle.H(), rectangle.Q(), rectangle.T(), f3, 0);
        columnText.k0(i3);
        if ((columnText.J(true) & 1) != 0) {
            return f3;
        }
        float f4 = f3;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < 50; i6++) {
            f3 = (f5 + f4) / 2.0f;
            ColumnText columnText2 = new ColumnText((PdfContentByte) null);
            font2.y(f3);
            columnText2.n0(new Phrase(str2, font2), rectangle.O(), rectangle.H(), rectangle.Q(), rectangle.T(), f3, 0);
            columnText2.k0(i3);
            if ((columnText2.J(true) & 1) == 0) {
                f4 = f3;
            } else if (f4 - f5 < 0.1f * f3) {
                return f3;
            } else {
                f5 = f3;
            }
        }
        return f3;
    }

    public static void u0(PdfContentByte pdfContentByte, int i2, Phrase phrase, float f2, float f3, float f4) {
        v0(pdfContentByte, i2, phrase, f2, f3, f4, 1, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0089, code lost:
        if (r1 == 2) goto L_0x008d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void v0(com.itextpdf.text.pdf.PdfContentByte r18, int r19, com.itextpdf.text.Phrase r20, float r21, float r22, float r23, int r24, int r25) {
        /*
            r0 = r19
            r1 = r23
            r7 = r24
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L_0x0011
            r2 = 1
            if (r0 == r2) goto L_0x0011
            if (r0 == r9) goto L_0x0011
            r15 = 0
            goto L_0x0012
        L_0x0011:
            r15 = r0
        L_0x0012:
            r18.a2()
            com.itextpdf.text.pdf.ColumnText r14 = new com.itextpdf.text.pdf.ColumnText
            r13 = r18
            r14.<init>(r13)
            r0 = 1184645120(0x469c4000, float:20000.0)
            r2 = 0
            if (r15 == 0) goto L_0x0030
            r3 = -962838528(0xffffffffc69c4000, float:-20000.0)
            if (r15 == r9) goto L_0x002e
            r10 = 1184645120(0x469c4000, float:20000.0)
        L_0x002a:
            r11 = -962838528(0xffffffffc69c4000, float:-20000.0)
            goto L_0x0034
        L_0x002e:
            r10 = 0
            goto L_0x002a
        L_0x0030:
            r10 = 1184645120(0x469c4000, float:20000.0)
            r11 = 0
        L_0x0034:
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
            r16 = 1073741824(0x40000000, float:2.0)
            int r0 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0049
            float r11 = r11 + r21
            float r0 = r22 + r12
            float r10 = r10 + r21
            float r1 = r22 + r16
            r16 = r1
            r1 = r10
            r12 = r11
            goto L_0x0070
        L_0x0049:
            double r0 = (double) r1
            r2 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r0 = r0 * r2
            r2 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r0 = r0 / r2
            double r2 = java.lang.Math.cos(r0)
            float r4 = (float) r2
            double r0 = java.lang.Math.sin(r0)
            float r2 = (float) r0
            float r3 = -r2
            r0 = r18
            r1 = r4
            r5 = r21
            r6 = r22
            r0.l0(r1, r2, r3, r4, r5, r6)
            r1 = r10
            r12 = r11
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0070:
            r2 = 1073741824(0x40000000, float:2.0)
            r10 = r14
            r11 = r20
            r13 = r0
            r0 = r14
            r14 = r1
            r1 = r15
            r15 = r16
            r16 = r2
            r17 = r1
            r10.n0(r11, r12, r13, r14, r15, r16, r17)
            r2 = 3
            if (r7 != r2) goto L_0x008c
            if (r1 != 0) goto L_0x0089
            r8 = 2
            goto L_0x008d
        L_0x0089:
            if (r1 != r9) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r8 = r1
        L_0x008d:
            r0.V(r8)
            r1 = r25
            r0.W(r1)
            r0.k0(r7)
            r0.I()     // Catch:{ DocumentException -> 0x009f }
            r18.U1()
            return
        L_0x009f:
            r0 = move-exception
            r1 = r0
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.v0(com.itextpdf.text.pdf.PdfContentByte, int, com.itextpdf.text.Phrase, float, float, float, int, int):void");
    }

    public float A() {
        return this.p;
    }

    public float B() {
        return this.v;
    }

    public int C() {
        return this.L;
    }

    public int D() {
        return this.f26017b;
    }

    public float E() {
        return this.z;
    }

    public float H() {
        return this.f26027l;
    }

    public int I() throws DocumentException {
        return J(false);
    }

    public int J(boolean z2) throws DocumentException {
        return K(z2, (IAccessibleElement) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r6 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0125, code lost:
        r10 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0127, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ab, code lost:
        r0.f26025j.t();
        r10 = r28;
     */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0321  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int K(boolean r31, com.itextpdf.text.pdf.interfaces.IAccessibleElement r32) throws com.itextpdf.text.DocumentException {
        /*
            r30 = this;
            r0 = r30
            r1 = r32
            r2 = 0
            r0.f26026k = r2
            boolean r3 = r0.H
            if (r3 == 0) goto L_0x0010
            int r1 = r30.L(r31)
            return r1
        L_0x0010:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.q
            boolean r3 = Q(r3)
            if (r3 == 0) goto L_0x0024
            boolean r3 = r1 instanceof com.itextpdf.text.ListItem
            if (r3 == 0) goto L_0x0024
            r3 = r1
            com.itextpdf.text.ListItem r3 = (com.itextpdf.text.ListItem) r3
            com.itextpdf.text.ListBody r3 = r3.g2()
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            r30.d()
            com.itextpdf.text.pdf.BidiLine r5 = r0.f26025j
            r6 = 1
            if (r5 != 0) goto L_0x002e
            return r6
        L_0x002e:
            r5 = 0
            r0.G = r5
            r0.C = r2
            r0.f26028m = r5
            float r7 = r0.z
            r8 = 2
            java.lang.Object[] r15 = new java.lang.Object[r8]
            java.lang.Float r9 = new java.lang.Float
            r9.<init>(r5)
            r15[r6] = r9
            r9 = 2143289344(0x7fc00000, float:NaN)
            r0.D = r9
            int r9 = r0.f26017b
            if (r9 == 0) goto L_0x004c
            r25 = r9
            goto L_0x004e
        L_0x004c:
            r25 = 1
        L_0x004e:
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.q
            if (r9 == 0) goto L_0x006f
            com.itextpdf.text.pdf.PdfDocument r10 = r9.h1()
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.q
            boolean r11 = Q(r11)
            if (r11 != 0) goto L_0x006c
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.q
            boolean r12 = r0.R
            com.itextpdf.text.pdf.PdfContentByte r11 = r11.V0(r12)
        L_0x0066:
            r26 = r9
            r27 = r10
            r14 = r11
            goto L_0x0076
        L_0x006c:
            com.itextpdf.text.pdf.PdfContentByte r11 = r0.q
            goto L_0x0066
        L_0x006f:
            if (r31 == 0) goto L_0x0336
            r14 = 0
            r26 = 0
            r27 = 0
        L_0x0076:
            if (r31 != 0) goto L_0x008f
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L_0x0085
            com.itextpdf.text.pdf.PdfWriter r7 = r14.i1()
            float r7 = r7.J1()
            goto L_0x008f
        L_0x0085:
            r9 = 981668463(0x3a83126f, float:0.001)
            int r10 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r10 >= 0) goto L_0x008f
            r7 = 981668463(0x3a83126f, float:0.001)
        L_0x008f:
            boolean r9 = r0.y
            if (r9 != 0) goto L_0x00ba
            com.itextpdf.text.pdf.BidiLine r9 = r0.f26025j
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r9 = r9.f25945h
            java.util.Iterator r9 = r9.iterator()
            r10 = 0
        L_0x009c:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00b1
            java.lang.Object r11 = r9.next()
            com.itextpdf.text.pdf.PdfChunk r11 = (com.itextpdf.text.pdf.PdfChunk) r11
            float r11 = r11.u()
            float r10 = java.lang.Math.max(r10, r11)
            goto L_0x009c
        L_0x00b1:
            float r9 = r0.o
            float r11 = r0.p
            float r10 = r10 * r11
            float r9 = r9 + r10
            r0.f26029n = r9
        L_0x00ba:
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x00bd:
            boolean r12 = r0.A
            if (r12 == 0) goto L_0x00c4
            float r12 = r0.t
            goto L_0x00c6
        L_0x00c4:
            float r12 = r0.u
        L_0x00c6:
            boolean r13 = r0.y
            r16 = 3
            if (r13 == 0) goto L_0x01b4
            float r13 = r0.x
            float r5 = r0.v
            float r5 = r5 + r12
            int r5 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x00e3
            com.itextpdf.text.pdf.BidiLine r1 = r0.f26025j
            boolean r1 = r1.m()
            if (r1 == 0) goto L_0x00e0
            r6 = 3
            goto L_0x024f
        L_0x00e0:
            r6 = 2
            goto L_0x024f
        L_0x00e3:
            com.itextpdf.text.pdf.BidiLine r5 = r0.f26025j
            boolean r5 = r5.m()
            if (r5 == 0) goto L_0x00ed
            goto L_0x024f
        L_0x00ed:
            com.itextpdf.text.pdf.BidiLine r5 = r0.f26025j
            float r13 = r0.f26020e
            float r4 = r0.x
            float r4 = r4 - r12
            float r8 = r0.v
            float r18 = r4 - r8
            int r4 = r0.f26022g
            int r8 = r0.F
            float r6 = r0.f26019d
            float r2 = r0.f26027l
            r28 = r10
            float r10 = r0.G
            r16 = r5
            r17 = r13
            r19 = r4
            r20 = r25
            r21 = r8
            r22 = r6
            r23 = r2
            r24 = r10
            com.itextpdf.text.pdf.PdfLine r2 = r16.r(r17, r18, r19, r20, r21, r22, r23, r24)
            boolean r4 = r0.f26026k
            com.itextpdf.text.pdf.BidiLine r5 = r0.f26025j
            boolean r5 = r5.o()
            r4 = r4 | r5
            r0.f26026k = r4
            if (r2 != 0) goto L_0x012a
        L_0x0125:
            r10 = r28
        L_0x0127:
            r6 = 1
            goto L_0x024f
        L_0x012a:
            float r4 = r0.o
            float r5 = r0.p
            float[] r4 = r2.j(r4, r5)
            boolean r5 = r30.R()
            if (r5 == 0) goto L_0x0147
            float r5 = r0.D
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 == 0) goto L_0x0147
            float r4 = r2.e()
        L_0x0144:
            r0.f26029n = r4
            goto L_0x0155
        L_0x0147:
            r5 = 0
            r6 = r4[r5]
            r5 = 1
            r4 = r4[r5]
            float r5 = r0.G
            float r4 = r4 - r5
            float r4 = java.lang.Math.max(r6, r4)
            goto L_0x0144
        L_0x0155:
            float r4 = r0.f26027l
            float r5 = r0.f26018c
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x01ab
            float r5 = r0.f26029n
            float r6 = r4 - r5
            float r8 = r0.f26019d
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x0168
            goto L_0x01ab
        L_0x0168:
            float r4 = r4 - r5
            r0.f26027l = r4
            if (r31 != 0) goto L_0x018b
            if (r9 != 0) goto L_0x018b
            boolean r4 = r2.f26244h
            if (r4 == 0) goto L_0x0184
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.q
            boolean r4 = r4.o1()
            if (r4 == 0) goto L_0x0184
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.q
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Yd
            r4.N(r5)
            r10 = 1
            goto L_0x0186
        L_0x0184:
            r10 = r28
        L_0x0186:
            r14.R()
            r9 = 1
            goto L_0x018d
        L_0x018b:
            r10 = r28
        L_0x018d:
            float r4 = r0.D
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 == 0) goto L_0x0199
            float r4 = r0.f26027l
            r0.D = r4
        L_0x0199:
            float r4 = r0.x
            float r5 = r2.B()
            float r4 = r4 - r5
            r0.w0(r4)
            float r4 = r0.f26020e
            r5 = r9
            r6 = r10
            r29 = r12
            goto L_0x026f
        L_0x01ab:
            com.itextpdf.text.pdf.BidiLine r1 = r0.f26025j
            r1.t()
            r10 = r28
            goto L_0x00e0
        L_0x01b4:
            r28 = r10
            float r2 = r0.f26027l
            float r4 = r0.f26029n
            float r2 = r2 - r4
            float[] r4 = r30.j()
            if (r4 != 0) goto L_0x01d2
            com.itextpdf.text.pdf.BidiLine r1 = r0.f26025j
            boolean r1 = r1.m()
            if (r1 == 0) goto L_0x01cb
            r6 = 3
            goto L_0x01cc
        L_0x01cb:
            r6 = 2
        L_0x01cc:
            r0.f26027l = r2
            r10 = r28
            goto L_0x024f
        L_0x01d2:
            com.itextpdf.text.pdf.BidiLine r5 = r0.f26025j
            boolean r5 = r5.m()
            if (r5 == 0) goto L_0x01de
            r0.f26027l = r2
            goto L_0x0125
        L_0x01de:
            r5 = 0
            r6 = r4[r5]
            r5 = 2
            r8 = r4[r5]
            float r6 = java.lang.Math.max(r6, r8)
            r8 = 1
            r10 = r4[r8]
            r4 = r4[r16]
            float r4 = java.lang.Math.min(r10, r4)
            float r4 = r4 - r6
            float r8 = r0.v
            float r10 = r12 + r8
            int r10 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r10 > 0) goto L_0x0202
            r10 = r28
        L_0x01fc:
            r2 = 0
            r5 = 0
            r6 = 1
            r8 = 2
            goto L_0x00bd
        L_0x0202:
            com.itextpdf.text.pdf.BidiLine r10 = r0.f26025j
            float r4 = r4 - r12
            float r18 = r4 - r8
            int r4 = r0.f26022g
            int r8 = r0.F
            float r13 = r0.f26019d
            float r5 = r0.f26027l
            r29 = r12
            float r12 = r0.G
            r16 = r10
            r17 = r6
            r19 = r4
            r20 = r25
            r21 = r8
            r22 = r13
            r23 = r5
            r24 = r12
            com.itextpdf.text.pdf.PdfLine r4 = r16.r(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r31 != 0) goto L_0x0247
            if (r9 != 0) goto L_0x0247
            boolean r5 = r4.f26244h
            if (r5 == 0) goto L_0x0240
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.q
            boolean r5 = r5.o1()
            if (r5 == 0) goto L_0x0240
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.q
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.Yd
            r5.N(r8)
            r10 = 1
            goto L_0x0242
        L_0x0240:
            r10 = r28
        L_0x0242:
            r14.R()
            r9 = 1
            goto L_0x0249
        L_0x0247:
            r10 = r28
        L_0x0249:
            if (r4 != 0) goto L_0x026b
            r0.f26027l = r2
            goto L_0x0127
        L_0x024f:
            if (r9 == 0) goto L_0x026a
            r14.L0()
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.q
            if (r1 == r14) goto L_0x025b
            r1.c(r14)
        L_0x025b:
            if (r10 == 0) goto L_0x026a
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.q
            boolean r1 = r1.o1()
            if (r1 == 0) goto L_0x026a
            com.itextpdf.text.pdf.PdfContentByte r1 = r0.q
            r1.K0()
        L_0x026a:
            return r6
        L_0x026b:
            r2 = r4
            r4 = r6
            r5 = r9
            r6 = r10
        L_0x026f:
            com.itextpdf.text.pdf.PdfContentByte r8 = r0.q
            boolean r8 = Q(r8)
            if (r8 == 0) goto L_0x02cc
            boolean r8 = r1 instanceof com.itextpdf.text.ListItem
            if (r8 == 0) goto L_0x02cc
            float r8 = r0.D
            boolean r8 = java.lang.Float.isNaN(r8)
            if (r8 != 0) goto L_0x02cc
            boolean r8 = r0.E
            if (r8 != 0) goto L_0x02cc
            if (r31 != 0) goto L_0x02c7
            r8 = r1
            com.itextpdf.text.ListItem r8 = (com.itextpdf.text.ListItem) r8
            com.itextpdf.text.ListLabel r9 = r8.i2()
            com.itextpdf.text.pdf.PdfContentByte r10 = r0.q
            r10.B1(r9)
            com.itextpdf.text.Chunk r10 = new com.itextpdf.text.Chunk
            com.itextpdf.text.Chunk r8 = r8.j2()
            r10.<init>((com.itextpdf.text.Chunk) r8)
            r8 = 0
            r10.o(r8)
            com.itextpdf.text.pdf.PdfContentByte r12 = r0.q
            com.itextpdf.text.Phrase r13 = new com.itextpdf.text.Phrase
            r13.<init>((com.itextpdf.text.Chunk) r10)
            float r10 = r0.f26020e
            float r16 = r9.a()
            float r19 = r10 + r16
            float r10 = r0.D
            r21 = 0
            r17 = 0
            r16 = r12
            r18 = r13
            r20 = r10
            u0(r16, r17, r18, r19, r20, r21)
            com.itextpdf.text.pdf.PdfContentByte r10 = r0.q
            r10.c0(r9)
        L_0x02c5:
            r9 = 1
            goto L_0x02c9
        L_0x02c7:
            r8 = 0
            goto L_0x02c5
        L_0x02c9:
            r0.E = r9
            goto L_0x02cd
        L_0x02cc:
            r8 = 0
        L_0x02cd:
            if (r31 != 0) goto L_0x0306
            if (r3 == 0) goto L_0x02d7
            com.itextpdf.text.pdf.PdfContentByte r9 = r0.q
            r9.B1(r3)
            r3 = r8
        L_0x02d7:
            r9 = 0
            r15[r9] = r11
            boolean r9 = r2.r()
            if (r9 == 0) goto L_0x02e3
            float r12 = r0.v
            goto L_0x02e5
        L_0x02e3:
            r12 = r29
        L_0x02e5:
            float r4 = r4 + r12
            float r9 = r2.p()
            float r4 = r4 + r9
            float r9 = r0.f26027l
            r14.e3(r4, r9)
            r9 = r27
            r10 = r2
            r11 = r14
            r12 = r26
            r13 = r15
            r4 = r14
            r14 = r7
            float r9 = r9.B1(r10, r11, r12, r13, r14)
            r0.f26028m = r9
            r9 = 0
            r10 = r15[r9]
            com.itextpdf.text.pdf.PdfFont r10 = (com.itextpdf.text.pdf.PdfFont) r10
            r11 = r10
            goto L_0x0307
        L_0x0306:
            r4 = r14
        L_0x0307:
            boolean r9 = r0.B
            if (r9 == 0) goto L_0x0313
            boolean r9 = r2.q()
            if (r9 == 0) goto L_0x0313
            r9 = 1
            goto L_0x0314
        L_0x0313:
            r9 = 0
        L_0x0314:
            r0.A = r9
            float r9 = r0.f26027l
            boolean r10 = r2.q()
            if (r10 == 0) goto L_0x0321
            float r10 = r0.w
            goto L_0x0322
        L_0x0321:
            r10 = 0
        L_0x0322:
            float r9 = r9 - r10
            r0.f26027l = r9
            int r9 = r0.C
            r10 = 1
            int r9 = r9 + r10
            r0.C = r9
            float r2 = r2.g()
            r0.G = r2
            r14 = r4
            r9 = r5
            r10 = r6
            goto L_0x01fc
        L_0x0336:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "columntext.go.with.simulate.eq.eq.false.and.text.eq.eq.null"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.K(boolean, com.itextpdf.text.pdf.interfaces.IAccessibleElement):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v10, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v56, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r4v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r7v61 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x052a A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:334:0x06e1  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x06f6  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x06fc  */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0727  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x07c3  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x07d0  */
    /* JADX WARNING: Removed duplicated region for block: B:381:0x07de A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:387:0x07f6  */
    /* JADX WARNING: Removed duplicated region for block: B:389:0x07fb  */
    /* JADX WARNING: Removed duplicated region for block: B:432:0x08e1  */
    /* JADX WARNING: Removed duplicated region for block: B:433:0x08eb  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0208 A[LOOP:3: B:91:0x01fb->B:95:0x0208, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int L(boolean r33) throws com.itextpdf.text.DocumentException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r3 = 3
            r4 = 0
            r5 = 2
            r6 = 1
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            if (r7 == 0) goto L_0x000e
            com.itextpdf.text.pdf.PdfDocument r7 = r7.Z
        L_0x000e:
            boolean r7 = r0.y
            if (r7 == 0) goto L_0x0932
            r0.C = r4
            r7 = 0
            r0.G = r7
            int r8 = r0.f26017b
            if (r8 != r3) goto L_0x001d
            r8 = 1
            goto L_0x001e
        L_0x001d:
            r8 = 0
        L_0x001e:
            r9 = 1
        L_0x001f:
            java.util.LinkedList<com.itextpdf.text.Element> r10 = r0.J
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x0028
            return r6
        L_0x0028:
            java.util.LinkedList<com.itextpdf.text.Element> r10 = r0.J
            java.lang.Object r10 = r10.getFirst()
            com.itextpdf.text.Element r10 = (com.itextpdf.text.Element) r10
            int r11 = r10.type()
            r12 = 12
            r13 = 0
            if (r11 != r12) goto L_0x01a4
            com.itextpdf.text.Paragraph r10 = (com.itextpdf.text.Paragraph) r10
            r11 = 0
            r12 = 0
        L_0x003d:
            if (r11 >= r5) goto L_0x015c
            float r12 = r0.f26027l
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            if (r14 != 0) goto L_0x00b7
            com.itextpdf.text.pdf.ColumnText r14 = new com.itextpdf.text.pdf.ColumnText
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.q
            r14.<init>(r15)
            r0.I = r14
            int r15 = r10.y1()
            r14.V(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            float r15 = r10.m()
            float r16 = r10.A1()
            float r15 = r15 + r16
            r14.f0(r15, r4)
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            float r15 = r10.z1()
            r14.a0(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            float r15 = r10.m()
            r14.c0(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            float r15 = r10.q()
            r14.j0(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            float r15 = r10.z0()
            float r2 = r10.E0()
            r14.i0(r15, r2)
            com.itextpdf.text.pdf.ColumnText r2 = r0.I
            int r14 = r0.f26017b
            r2.k0(r14)
            com.itextpdf.text.pdf.ColumnText r2 = r0.I
            int r14 = r0.F
            r2.W(r14)
            com.itextpdf.text.pdf.ColumnText r2 = r0.I
            float r14 = r0.z
            r2.q0(r14)
            com.itextpdf.text.pdf.ColumnText r2 = r0.I
            r2.c(r10)
            if (r9 == 0) goto L_0x00ac
            boolean r2 = r0.Q
            if (r2 != 0) goto L_0x00b5
        L_0x00ac:
            float r2 = r0.f26027l
            float r14 = r10.E()
            float r2 = r2 - r14
            r0.f26027l = r2
        L_0x00b5:
            r2 = 1
            goto L_0x00b8
        L_0x00b7:
            r2 = 0
        L_0x00b8:
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            if (r9 != 0) goto L_0x00c2
            float r15 = r0.G
            int r15 = (r15 > r7 ? 1 : (r15 == r7 ? 0 : -1))
            if (r15 != 0) goto L_0x00c9
        L_0x00c2:
            boolean r15 = r0.Q
            if (r15 == 0) goto L_0x00c9
            boolean r15 = r0.O
            goto L_0x00ca
        L_0x00c9:
            r15 = 0
        L_0x00ca:
            r14.s0(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            boolean r15 = r0.R
            r14.g0(r15)
            com.itextpdf.text.pdf.ColumnText r14 = r0.I
            float r15 = r0.f26020e
            r14.f26020e = r15
            float r15 = r0.f26021f
            r14.f26021f = r15
            float r15 = r0.f26027l
            r14.f26027l = r15
            float r15 = r0.x
            r14.x = r15
            boolean r15 = r0.y
            r14.y = r15
            float r15 = r0.f26019d
            r14.f26019d = r15
            float r15 = r0.f26018c
            r14.f26018c = r15
            boolean r14 = r10.C1()
            if (r14 == 0) goto L_0x0102
            if (r2 == 0) goto L_0x0102
            if (r9 == 0) goto L_0x0100
            boolean r2 = r0.Q
            if (r2 != 0) goto L_0x0102
        L_0x0100:
            r2 = 1
            goto L_0x0103
        L_0x0102:
            r2 = 0
        L_0x0103:
            if (r1 != 0) goto L_0x010c
            if (r2 == 0) goto L_0x010a
            if (r11 != 0) goto L_0x010a
            goto L_0x010c
        L_0x010a:
            r14 = 0
            goto L_0x010d
        L_0x010c:
            r14 = 1
        L_0x010d:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.q
            boolean r15 = Q(r15)
            if (r15 == 0) goto L_0x011c
            if (r14 != 0) goto L_0x011c
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.q
            r15.B1(r10)
        L_0x011c:
            com.itextpdf.text.pdf.ColumnText r15 = r0.I
            int r15 = r15.J(r14)
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            boolean r7 = Q(r7)
            if (r7 == 0) goto L_0x0131
            if (r14 != 0) goto L_0x0131
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            r7.c0(r10)
        L_0x0131:
            com.itextpdf.text.pdf.ColumnText r7 = r0.I
            float r7 = r7.x()
            r0.f26028m = r7
            com.itextpdf.text.pdf.ColumnText r7 = r0.I
            float r7 = r7.P
            r0.w0(r7)
            r7 = r15 & 1
            if (r7 != 0) goto L_0x014b
            if (r2 == 0) goto L_0x014b
            r0.I = r13
            r0.f26027l = r12
            return r5
        L_0x014b:
            if (r1 != 0) goto L_0x015b
            if (r2 != 0) goto L_0x0150
            goto L_0x015b
        L_0x0150:
            if (r11 != 0) goto L_0x0156
            r0.I = r13
            r0.f26027l = r12
        L_0x0156:
            int r11 = r11 + r6
            r12 = r15
            r7 = 0
            goto L_0x003d
        L_0x015b:
            r12 = r15
        L_0x015c:
            com.itextpdf.text.pdf.ColumnText r2 = r0.I
            int r2 = r2.z()
            if (r2 <= 0) goto L_0x017e
            com.itextpdf.text.pdf.ColumnText r2 = r0.I
            float r7 = r2.f26027l
            r0.f26027l = r7
            int r7 = r0.C
            int r9 = r2.C
            int r7 = r7 + r9
            r0.C = r7
            float r7 = r2.G
            r0.G = r7
            boolean r7 = r0.f26026k
            boolean r2 = r2.S()
            r2 = r2 | r7
            r0.f26026k = r2
        L_0x017e:
            com.itextpdf.text.pdf.ColumnText r2 = r0.I
            float r2 = r2.f26029n
            r0.f26029n = r2
            r2 = r12 & 1
            if (r2 == 0) goto L_0x0198
            r0.I = r13
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.J
            r2.removeFirst()
            float r2 = r0.f26027l
            float r7 = r10.K()
            float r2 = r2 - r7
            r0.f26027l = r2
        L_0x0198:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x019d
            return r5
        L_0x019d:
            r2 = -1
        L_0x019e:
            r3 = 0
            r4 = 2
            r7 = 1
            r9 = 0
            goto L_0x05e1
        L_0x01a4:
            int r2 = r10.type()
            r7 = 14
            if (r2 != r7) goto L_0x0452
            com.itextpdf.text.List r10 = (com.itextpdf.text.List) r10
            java.util.ArrayList r2 = r10.h()
            float r7 = r10.m()
            java.util.Stack r11 = new java.util.Stack
            r11.<init>()
            r12 = 0
            r14 = 0
        L_0x01bd:
            int r15 = r2.size()
            if (r12 >= r15) goto L_0x0230
            java.lang.Object r15 = r2.get(r12)
            boolean r13 = r15 instanceof com.itextpdf.text.ListItem
            if (r13 == 0) goto L_0x01d5
            int r13 = r0.K
            if (r14 != r13) goto L_0x01d3
            r2 = r15
            com.itextpdf.text.ListItem r2 = (com.itextpdf.text.ListItem) r2
            goto L_0x0231
        L_0x01d3:
            int r14 = r14 + r6
            goto L_0x01fb
        L_0x01d5:
            boolean r13 = r15 instanceof com.itextpdf.text.List
            if (r13 == 0) goto L_0x01fb
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            java.lang.Float r12 = new java.lang.Float
            r12.<init>(r7)
            java.lang.Object[] r13 = new java.lang.Object[r3]
            r13[r4] = r10
            r13[r6] = r2
            r13[r5] = r12
            r11.push(r13)
            com.itextpdf.text.List r15 = (com.itextpdf.text.List) r15
            java.util.ArrayList r2 = r15.h()
            float r10 = r15.m()
            float r7 = r7 + r10
            r10 = r15
            r12 = -1
            goto L_0x022d
        L_0x01fb:
            int r13 = r2.size()
            int r13 = r13 - r6
            if (r12 != r13) goto L_0x022d
            boolean r13 = r11.isEmpty()
            if (r13 != 0) goto L_0x022d
            java.lang.Object r2 = r11.pop()
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r7 = r2[r4]
            r10 = r7
            com.itextpdf.text.List r10 = (com.itextpdf.text.List) r10
            java.util.ArrayList r7 = r10.h()
            r12 = r2[r6]
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r2 = r2[r5]
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            r31 = r7
            r7 = r2
            r2 = r31
            goto L_0x01fb
        L_0x022d:
            int r12 = r12 + r6
            r13 = 0
            goto L_0x01bd
        L_0x0230:
            r2 = 0
        L_0x0231:
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0234:
            if (r11 >= r5) goto L_0x0390
            float r14 = r0.f26027l
            com.itextpdf.text.pdf.ColumnText r15 = r0.I
            if (r15 != 0) goto L_0x02de
            if (r2 != 0) goto L_0x0247
            r0.K = r4
            java.util.LinkedList<com.itextpdf.text.Element> r11 = r0.J
            r11.removeFirst()
            goto L_0x0390
        L_0x0247:
            com.itextpdf.text.pdf.ColumnText r13 = new com.itextpdf.text.pdf.ColumnText
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.q
            r13.<init>(r15)
            r0.I = r13
            if (r9 != 0) goto L_0x025a
            float r15 = r0.G
            r17 = 0
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 != 0) goto L_0x0261
        L_0x025a:
            boolean r15 = r0.Q
            if (r15 == 0) goto L_0x0261
            boolean r15 = r0.O
            goto L_0x0262
        L_0x0261:
            r15 = 0
        L_0x0262:
            r13.s0(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            boolean r15 = r0.R
            r13.g0(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            int r15 = r2.y1()
            r13.V(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            float r15 = r2.m()
            float r15 = r15 + r7
            float r18 = r2.A1()
            float r15 = r15 + r18
            r13.f0(r15, r4)
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            float r15 = r2.z1()
            r13.a0(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            float r15 = r13.v()
            r13.c0(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            float r15 = r2.q()
            float r18 = r10.q()
            float r15 = r15 + r18
            r13.j0(r15)
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            float r15 = r2.z0()
            float r3 = r2.E0()
            r13.i0(r15, r3)
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            int r13 = r0.f26017b
            r3.k0(r13)
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            int r13 = r0.F
            r3.W(r13)
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            float r13 = r0.z
            r3.q0(r13)
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            r3.c(r2)
            if (r9 == 0) goto L_0x02d3
            boolean r3 = r0.Q
            if (r3 != 0) goto L_0x02dc
        L_0x02d3:
            float r3 = r0.f26027l
            float r13 = r2.E()
            float r3 = r3 - r13
            r0.f26027l = r3
        L_0x02dc:
            r3 = 1
            goto L_0x02df
        L_0x02de:
            r3 = 0
        L_0x02df:
            com.itextpdf.text.pdf.ColumnText r13 = r0.I
            float r15 = r0.f26020e
            r13.f26020e = r15
            float r15 = r0.f26021f
            r13.f26021f = r15
            float r15 = r0.f26027l
            r13.f26027l = r15
            float r15 = r0.x
            r13.x = r15
            boolean r15 = r0.y
            r13.y = r15
            float r15 = r0.f26019d
            r13.f26019d = r15
            float r15 = r0.f26018c
            r13.f26018c = r15
            boolean r13 = r2.C1()
            if (r13 == 0) goto L_0x030d
            if (r3 == 0) goto L_0x030d
            if (r9 == 0) goto L_0x030b
            boolean r3 = r0.Q
            if (r3 != 0) goto L_0x030d
        L_0x030b:
            r3 = 1
            goto L_0x030e
        L_0x030d:
            r3 = 0
        L_0x030e:
            if (r1 != 0) goto L_0x0317
            if (r3 == 0) goto L_0x0315
            if (r11 != 0) goto L_0x0315
            goto L_0x0317
        L_0x0315:
            r13 = 0
            goto L_0x0318
        L_0x0317:
            r13 = 1
        L_0x0318:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.q
            boolean r15 = Q(r15)
            if (r15 == 0) goto L_0x0341
            if (r13 != 0) goto L_0x0341
            com.itextpdf.text.ListLabel r15 = r2.i2()
            r15.c(r7)
            com.itextpdf.text.ListItem r15 = r10.f()
            if (r15 == r2) goto L_0x0337
            com.itextpdf.text.pdf.ColumnText r15 = r0.I
            if (r15 == 0) goto L_0x033c
            com.itextpdf.text.pdf.BidiLine r15 = r15.f26025j
            if (r15 == 0) goto L_0x033c
        L_0x0337:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.q
            r15.B1(r10)
        L_0x033c:
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.q
            r15.B1(r2)
        L_0x0341:
            com.itextpdf.text.pdf.ColumnText r15 = r0.I
            int r15 = r15.K(r13, r2)
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.q
            boolean r4 = Q(r4)
            if (r4 == 0) goto L_0x035f
            if (r13 != 0) goto L_0x035f
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.q
            com.itextpdf.text.ListBody r13 = r2.g2()
            r4.c0(r13)
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.q
            r4.c0(r2)
        L_0x035f:
            com.itextpdf.text.pdf.ColumnText r4 = r0.I
            float r4 = r4.x()
            r0.f26028m = r4
            com.itextpdf.text.pdf.ColumnText r4 = r0.I
            float r4 = r4.P
            r0.w0(r4)
            r4 = r15 & 1
            if (r4 != 0) goto L_0x037b
            if (r3 == 0) goto L_0x037b
            r4 = 0
            r0.I = r4
            r0.f26027l = r14
            r12 = 1
            goto L_0x037c
        L_0x037b:
            r4 = 0
        L_0x037c:
            if (r1 != 0) goto L_0x038f
            if (r3 == 0) goto L_0x038f
            if (r12 == 0) goto L_0x0383
            goto L_0x038f
        L_0x0383:
            if (r11 != 0) goto L_0x0389
            r0.I = r4
            r0.f26027l = r14
        L_0x0389:
            int r11 = r11 + r6
            r13 = r15
            r3 = 3
            r4 = 0
            goto L_0x0234
        L_0x038f:
            r13 = r15
        L_0x0390:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.q
            boolean r3 = Q(r3)
            if (r3 == 0) goto L_0x03af
            if (r1 != 0) goto L_0x03af
            if (r2 == 0) goto L_0x03aa
            com.itextpdf.text.ListItem r3 = r10.i()
            if (r3 != r2) goto L_0x03a6
            r3 = r13 & 1
            if (r3 != 0) goto L_0x03aa
        L_0x03a6:
            r3 = r13 & 2
            if (r3 == 0) goto L_0x03af
        L_0x03aa:
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.q
            r3.c0(r10)
        L_0x03af:
            if (r12 == 0) goto L_0x03b2
            return r5
        L_0x03b2:
            if (r2 != 0) goto L_0x03b8
        L_0x03b4:
            r19 = r9
            goto L_0x05df
        L_0x03b8:
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            float r4 = r3.f26027l
            r0.f26027l = r4
            int r4 = r0.C
            int r9 = r3.C
            int r4 = r4 + r9
            r0.C = r4
            float r4 = r3.G
            r0.G = r4
            float r3 = r3.f26029n
            r0.f26029n = r3
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.q
            boolean r3 = Q(r3)
            if (r3 != 0) goto L_0x0438
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            float r3 = r3.D
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L_0x0438
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            boolean r3 = r3.E
            if (r3 != 0) goto L_0x0438
            if (r1 != 0) goto L_0x0434
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.q
            com.itextpdf.text.Phrase r4 = new com.itextpdf.text.Phrase
            if (r8 == 0) goto L_0x0418
            com.itextpdf.text.Chunk r7 = r2.j2()
            r4.<init>((com.itextpdf.text.Chunk) r7)
            com.itextpdf.text.pdf.ColumnText r7 = r0.I
            float r7 = r7.f26028m
            float r9 = r2.m()
            float r22 = r7 + r9
            com.itextpdf.text.pdf.ColumnText r7 = r0.I
            float r7 = r7.D
            int r9 = r0.f26017b
            int r10 = r0.F
            r20 = 2
            r24 = 0
            r19 = r3
            r21 = r4
            r23 = r7
            r25 = r9
            r26 = r10
            v0(r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0434
        L_0x0418:
            com.itextpdf.text.Chunk r9 = r2.j2()
            r4.<init>((com.itextpdf.text.Chunk) r9)
            com.itextpdf.text.pdf.ColumnText r9 = r0.I
            float r10 = r9.f26020e
            float r28 = r10 + r7
            float r7 = r9.D
            r30 = 0
            r26 = 0
            r25 = r3
            r27 = r4
            r29 = r7
            u0(r25, r26, r27, r28, r29, r30)
        L_0x0434:
            com.itextpdf.text.pdf.ColumnText r3 = r0.I
            r3.E = r6
        L_0x0438:
            r3 = r13 & 1
            if (r3 == 0) goto L_0x044d
            r3 = 0
            r0.I = r3
            int r3 = r0.K
            int r3 = r3 + r6
            r0.K = r3
            float r3 = r0.f26027l
            float r2 = r2.K()
            float r3 = r3 - r2
            r0.f26027l = r3
        L_0x044d:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x019d
            return r5
        L_0x0452:
            int r2 = r10.type()
            r3 = 23
            if (r2 != r3) goto L_0x088d
            com.itextpdf.text.pdf.PdfPTable r10 = (com.itextpdf.text.pdf.PdfPTable) r10
            int r2 = r10.e1()
            int r3 = r10.S()
            if (r2 > r3) goto L_0x046d
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.J
            r2.removeFirst()
            goto L_0x03b4
        L_0x046d:
            float r2 = r0.f26027l
            float r3 = r0.G
            float r2 = r2 + r3
            int r3 = r0.L
            if (r3 != 0) goto L_0x047f
            boolean r3 = r0.Q
            if (r3 == 0) goto L_0x047f
            float r3 = r10.h1()
            float r2 = r2 - r3
        L_0x047f:
            r25 = r2
            float r2 = r0.f26019d
            int r2 = (r25 > r2 ? 1 : (r25 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x048d
            float r2 = r0.f26018c
            int r2 = (r25 > r2 ? 1 : (r25 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0490
        L_0x048d:
            r4 = 2
            goto L_0x088c
        L_0x0490:
            float r2 = r0.f26020e
            r3 = 0
            r0.f26029n = r3
            boolean r3 = r10.t0()
            if (r3 == 0) goto L_0x04a3
            float r3 = r10.m0()
            r0.w0(r3)
            goto L_0x04b1
        L_0x04a3:
            float r3 = r0.x
            float r4 = r10.n0()
            float r3 = r3 * r4
            r4 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 / r4
            r10.X0(r3)
        L_0x04b1:
            r10.C0()
            int r4 = r10.S()
            int r7 = r10.P()
            int r11 = r4 - r7
            float r12 = r10.O()
            float r13 = r10.R()
            float r13 = r13 - r12
            boolean r14 = r10.v0()
            if (r14 == 0) goto L_0x04dd
            int r14 = r0.L
            if (r14 > r11) goto L_0x04dd
            boolean r14 = r10.isComplete()
            if (r14 != 0) goto L_0x04db
            int r14 = r0.L
            if (r14 == r11) goto L_0x04dd
        L_0x04db:
            r14 = 1
            goto L_0x04de
        L_0x04dd:
            r14 = 0
        L_0x04de:
            if (r14 != 0) goto L_0x04e3
            float r13 = r25 - r13
            goto L_0x04e5
        L_0x04e3:
            r13 = r25
        L_0x04e5:
            int r15 = r0.L
            if (r15 >= r4) goto L_0x04eb
            r0.L = r4
        L_0x04eb:
            boolean r15 = r10.w0()
            if (r15 == 0) goto L_0x04fc
            float r15 = r0.f26019d
            float r15 = r13 - r15
            int r5 = r0.L
            com.itextpdf.text.pdf.PdfPTable$FittingRows r5 = r10.J(r15, r5)
            goto L_0x04fd
        L_0x04fc:
            r5 = 0
        L_0x04fd:
            boolean r15 = r10.w0()
            if (r15 == 0) goto L_0x0513
            int r15 = r5.f26258b
            int r19 = r10.e1()
            r20 = r5
            int r5 = r19 + -1
            if (r15 >= r5) goto L_0x0510
            goto L_0x0513
        L_0x0510:
            r5 = r20
            goto L_0x051e
        L_0x0513:
            float r13 = r13 - r12
            float r5 = r0.f26019d
            float r5 = r13 - r5
            int r15 = r0.L
            com.itextpdf.text.pdf.PdfPTable$FittingRows r5 = r10.J(r5, r15)
        L_0x051e:
            float r15 = r0.f26019d
            int r15 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r15 < 0) goto L_0x052a
            float r15 = r0.f26018c
            int r15 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r15 <= 0) goto L_0x052d
        L_0x052a:
            r4 = 2
            goto L_0x088c
        L_0x052d:
            int r15 = r5.f26258b
            int r15 = r15 + r6
            float r6 = r5.f26259c
            float r13 = r13 - r6
            com.itextpdf.text.log.Logger r6 = r0.f26016a
            r19 = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r20 = r13
            java.lang.String r13 = "Want to split at row "
            r9.append(r13)
            r9.append(r15)
            java.lang.String r9 = r9.toString()
            r6.f(r9)
            r6 = r15
        L_0x054e:
            int r9 = r0.L
            if (r6 <= r9) goto L_0x0565
            int r9 = r10.e1()
            if (r6 >= r9) goto L_0x0565
            com.itextpdf.text.pdf.PdfPRow r9 = r10.b0(r6)
            boolean r9 = r9.k()
            if (r9 == 0) goto L_0x0565
            r9 = -1
            int r6 = r6 + r9
            goto L_0x054e
        L_0x0565:
            int r9 = r10.e1()
            r13 = 1
            int r9 = r9 - r13
            if (r6 >= r9) goto L_0x0578
            com.itextpdf.text.pdf.PdfPRow r9 = r10.b0(r6)
            boolean r9 = r9.k()
            if (r9 != 0) goto L_0x0578
            int r6 = r6 + r13
        L_0x0578:
            int r9 = r0.L
            if (r6 <= r9) goto L_0x057e
            if (r6 < r15) goto L_0x0590
        L_0x057e:
            if (r6 != r4) goto L_0x0598
            com.itextpdf.text.pdf.PdfPRow r9 = r10.b0(r4)
            boolean r9 = r9.k()
            if (r9 == 0) goto L_0x0598
            boolean r9 = r10.u0()
            if (r9 == 0) goto L_0x0598
        L_0x0590:
            float r13 = r0.f26019d
            r9 = 0
            r10.P0(r9)
            r15 = r6
            goto L_0x059a
        L_0x0598:
            r13 = r20
        L_0x059a:
            com.itextpdf.text.log.Logger r6 = r0.f26016a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r20 = r4
            java.lang.String r4 = "Will split at row "
            r9.append(r4)
            r9.append(r15)
            java.lang.String r4 = r9.toString()
            r6.f(r4)
            boolean r4 = r10.x0()
            if (r4 == 0) goto L_0x05c0
            if (r15 <= 0) goto L_0x05c0
            r4 = 1
            int r6 = r15 + -1
            r5.a(r10, r6)
        L_0x05c0:
            boolean r4 = r10.isComplete()
            if (r4 != 0) goto L_0x05c7
            float r13 = r13 + r12
        L_0x05c7:
            boolean r4 = r10.y0()
            if (r4 != 0) goto L_0x05fd
            r4 = -1
            r0.M = r4
            int r4 = r0.L
            if (r15 != r4) goto L_0x068e
            int r2 = r10.e1()
            if (r15 != r2) goto L_0x05e8
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.J
            r2.removeFirst()
        L_0x05df:
            r9 = r19
        L_0x05e1:
            r3 = 3
            r4 = 0
            r5 = 2
            r6 = 1
            r7 = 0
            goto L_0x001f
        L_0x05e8:
            boolean r1 = r10.isComplete()
            if (r1 != 0) goto L_0x05f4
            r1 = 1
            if (r15 == r1) goto L_0x05f2
            goto L_0x05f4
        L_0x05f2:
            r1 = 2
            goto L_0x05fc
        L_0x05f4:
            java.util.ArrayList r1 = r10.e0()
            r1.remove(r15)
            goto L_0x05f2
        L_0x05fc:
            return r1
        L_0x05fd:
            boolean r4 = r10.x0()
            if (r4 == 0) goto L_0x061d
            int r4 = r0.L
            if (r4 < r15) goto L_0x0618
            int r4 = r0.M
            r6 = -2
            if (r4 != r6) goto L_0x061d
            int r4 = r10.S()
            if (r4 == 0) goto L_0x0618
            boolean r4 = r10.v0()
            if (r4 == 0) goto L_0x061d
        L_0x0618:
            r4 = -1
            r0.M = r4
            goto L_0x068e
        L_0x061d:
            int r4 = r10.e1()
            if (r15 >= r4) goto L_0x068e
            float r4 = r5.f26260d
            float r5 = r5.f26259c
            float r4 = r4 - r5
            float r13 = r13 - r4
            float r4 = r0.f26019d
            float r4 = r13 - r4
            com.itextpdf.text.pdf.PdfPRow r5 = r10.b0(r15)
            com.itextpdf.text.pdf.PdfPRow r4 = r5.y(r10, r15, r4)
            if (r4 != 0) goto L_0x0647
            com.itextpdf.text.log.Logger r4 = r0.f26016a
            java.lang.String r5 = "Didn't split row!"
            r4.f(r5)
            r4 = -1
            r0.M = r4
            int r4 = r0.L
            if (r4 != r15) goto L_0x068e
            r4 = 2
            return r4
        L_0x0647:
            int r5 = r0.M
            if (r15 == r5) goto L_0x066d
            r5 = 1
            int r6 = r15 + 1
            r0.M = r6
            com.itextpdf.text.pdf.PdfPTable r6 = new com.itextpdf.text.pdf.PdfPTable
            r6.<init>((com.itextpdf.text.pdf.PdfPTable) r10)
            java.util.LinkedList<com.itextpdf.text.Element> r9 = r0.J
            r10 = 0
            r9.set(r10, r6)
            java.util.ArrayList r9 = r6.e0()
            r10 = r20
        L_0x0661:
            int r13 = r0.L
            if (r10 >= r13) goto L_0x066b
            r13 = 0
            r9.set(r10, r13)
            int r10 = r10 + r5
            goto L_0x0661
        L_0x066b:
            r10 = r6
            goto L_0x066e
        L_0x066d:
            r5 = 1
        L_0x066e:
            float r13 = r0.f26019d
            java.util.ArrayList r6 = r10.e0()
            int r15 = r15 + r5
            r6.add(r15, r4)
            com.itextpdf.text.log.Logger r4 = r0.f26016a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Inserting row at position "
            r5.append(r6)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            r4.f(r5)
        L_0x068e:
            if (r1 != 0) goto L_0x080d
            int r4 = r10.T()
            r5 = 1
            if (r4 == r5) goto L_0x06a6
            r5 = 2
            if (r4 == r5) goto L_0x06a3
            if (r8 == 0) goto L_0x06a0
        L_0x069c:
            float r4 = r0.x
            float r4 = r4 - r3
        L_0x069f:
            float r2 = r2 + r4
        L_0x06a0:
            r24 = r2
            goto L_0x06ad
        L_0x06a3:
            if (r8 != 0) goto L_0x06a0
            goto L_0x069c
        L_0x06a6:
            float r4 = r0.x
            float r4 = r4 - r3
            r3 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r3
            goto L_0x069f
        L_0x06ad:
            com.itextpdf.text.pdf.PdfPTable r2 = com.itextpdf.text.pdf.PdfPTable.d1(r10)
            java.util.ArrayList r3 = r2.e0()
            if (r14 != 0) goto L_0x06d0
            if (r11 <= 0) goto L_0x06d0
            r4 = 0
            java.util.ArrayList r5 = r10.f0(r4, r11)
            com.itextpdf.text.pdf.PdfContentByte r4 = r0.q
            boolean r4 = Q(r4)
            if (r4 == 0) goto L_0x06cc
            com.itextpdf.text.pdf.PdfPTableHeader r4 = r2.Q()
            r4.X = r5
        L_0x06cc:
            r3.addAll(r5)
            goto L_0x06d3
        L_0x06d0:
            r2.K0(r7)
        L_0x06d3:
            int r4 = r0.L
            java.util.ArrayList r4 = r10.f0(r4, r15)
            com.itextpdf.text.pdf.PdfContentByte r5 = r0.q
            boolean r5 = Q(r5)
            if (r5 == 0) goto L_0x06e7
            com.itextpdf.text.pdf.PdfPTableBody r5 = r2.F()
            r5.X = r4
        L_0x06e7:
            r3.addAll(r4)
            boolean r4 = r10.w0()
            r5 = 1
            r4 = r4 ^ r5
            int r6 = r10.e1()
            if (r15 >= r6) goto L_0x06fc
            r2.z(r5)
            r4 = 1
            r5 = 1
            goto L_0x06fe
        L_0x06fc:
            r5 = r4
            r4 = 0
        L_0x06fe:
            if (r7 <= 0) goto L_0x0720
            boolean r6 = r2.isComplete()
            if (r6 == 0) goto L_0x0720
            if (r5 == 0) goto L_0x0720
            int r5 = r11 + r7
            java.util.ArrayList r5 = r10.f0(r11, r5)
            com.itextpdf.text.pdf.PdfContentByte r6 = r0.q
            boolean r6 = Q(r6)
            if (r6 == 0) goto L_0x071c
            com.itextpdf.text.pdf.PdfPTableFooter r6 = r2.N()
            r6.X = r5
        L_0x071c:
            r3.addAll(r5)
            goto L_0x0721
        L_0x0720:
            r7 = 0
        L_0x0721:
            int r5 = r3.size()
            if (r5 <= 0) goto L_0x081c
            int r5 = r3.size()
            r6 = 1
            int r5 = r5 - r6
            int r5 = r5 - r7
            java.lang.Object r3 = r3.get(r5)
            com.itextpdf.text.pdf.PdfPRow r3 = (com.itextpdf.text.pdf.PdfPRow) r3
            boolean r6 = r10.r0(r4)
            if (r6 == 0) goto L_0x0748
            float r6 = r3.e()
            float r7 = r0.f26019d
            float r13 = r13 - r7
            float r13 = r13 + r6
            r3.v(r13)
            float r13 = r0.f26019d
            goto L_0x0749
        L_0x0748:
            r6 = 0
        L_0x0749:
            if (r4 == 0) goto L_0x0758
            com.itextpdf.text.pdf.PdfPTableEvent r7 = r10.j0()
            boolean r9 = r7 instanceof com.itextpdf.text.pdf.PdfPTableEventSplit
            if (r9 == 0) goto L_0x0758
            com.itextpdf.text.pdf.PdfPTableEventSplit r7 = (com.itextpdf.text.pdf.PdfPTableEventSplit) r7
            r7.c(r10)
        L_0x0758:
            com.itextpdf.text.pdf.PdfContentByte[] r7 = r0.r
            r9 = 3
            if (r7 == 0) goto L_0x0792
            r7 = r7[r9]
            boolean r7 = Q(r7)
            if (r7 == 0) goto L_0x076c
            com.itextpdf.text.pdf.PdfContentByte[] r7 = r0.r
            r7 = r7[r9]
            r7.B1(r10)
        L_0x076c:
            com.itextpdf.text.pdf.PdfContentByte[] r7 = r0.r
            r27 = 0
            r20 = 0
            r21 = -1
            r22 = 0
            r23 = -1
            r19 = r2
            r26 = r7
            r19.n1(r20, r21, r22, r23, r24, r25, r26, r27)
            com.itextpdf.text.pdf.PdfContentByte[] r7 = r0.r
            r9 = 3
            r7 = r7[r9]
            boolean r7 = Q(r7)
            if (r7 == 0) goto L_0x07bd
            com.itextpdf.text.pdf.PdfContentByte[] r7 = r0.r
            r7 = r7[r9]
        L_0x078e:
            r7.c0(r10)
            goto L_0x07bd
        L_0x0792:
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            boolean r7 = Q(r7)
            if (r7 == 0) goto L_0x079f
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            r7.B1(r10)
        L_0x079f:
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            r27 = 0
            r20 = 0
            r21 = -1
            r22 = 0
            r23 = -1
            r19 = r2
            r26 = r7
            r19.l1(r20, r21, r22, r23, r24, r25, r26, r27)
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            boolean r7 = Q(r7)
            if (r7 == 0) goto L_0x07bd
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.q
            goto L_0x078e
        L_0x07bd:
            boolean r7 = r10.isComplete()
            if (r7 != 0) goto L_0x07c6
            r10.j(r15)
        L_0x07c6:
            int r7 = r0.M
            if (r7 != r15) goto L_0x07de
            int r7 = r10.e1()
            if (r15 >= r7) goto L_0x07de
            java.util.ArrayList r7 = r10.e0()
            java.lang.Object r7 = r7.get(r15)
            com.itextpdf.text.pdf.PdfPRow r7 = (com.itextpdf.text.pdf.PdfPRow) r7
            r7.b(r2, r5)
            goto L_0x07f0
        L_0x07de:
            if (r15 <= 0) goto L_0x07f0
            int r7 = r10.e1()
            if (r15 >= r7) goto L_0x07f0
            com.itextpdf.text.pdf.PdfPRow r7 = r10.b0(r15)
            r11 = 1
            int r9 = r15 + -1
            r7.z(r10, r9, r2, r5)
        L_0x07f0:
            boolean r2 = r10.r0(r4)
            if (r2 == 0) goto L_0x07f9
            r3.v(r6)
        L_0x07f9:
            if (r4 == 0) goto L_0x081c
            com.itextpdf.text.pdf.PdfPTableEvent r2 = r10.j0()
            boolean r3 = r2 instanceof com.itextpdf.text.pdf.PdfPTableEventAfterSplit
            if (r3 == 0) goto L_0x081c
            com.itextpdf.text.pdf.PdfPRow r3 = r10.b0(r15)
            com.itextpdf.text.pdf.PdfPTableEventAfterSplit r2 = (com.itextpdf.text.pdf.PdfPTableEventAfterSplit) r2
            r2.a(r10, r3, r15)
            goto L_0x081c
        L_0x080d:
            boolean r2 = r10.q0()
            if (r2 == 0) goto L_0x081c
            float r2 = r0.f26019d
            r3 = -830472192(0xffffffffce800000, float:-1.07374182E9)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x081c
            r13 = r2
        L_0x081c:
            r0.f26027l = r13
            r2 = 0
            r0.G = r2
            r0.f26029n = r2
            if (r14 != 0) goto L_0x0830
            boolean r2 = r10.isComplete()
            if (r2 != 0) goto L_0x0830
            float r2 = r0.f26027l
            float r2 = r2 + r12
            r0.f26027l = r2
        L_0x0830:
            int r2 = r10.e1()
            if (r15 >= r2) goto L_0x0849
            float r2 = r10.c0(r15)
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0849
            boolean r2 = r10.o0(r15)
            if (r2 == 0) goto L_0x0846
            goto L_0x0849
        L_0x0846:
            r2 = 1
            int r15 = r15 + r2
            goto L_0x0830
        L_0x0849:
            int r2 = r10.e1()
            if (r15 < r2) goto L_0x0875
            float r2 = r0.f26027l
            float r3 = r10.g1()
            float r2 = r2 - r3
            float r3 = r0.f26019d
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x085f
            r0.f26027l = r3
            goto L_0x0868
        L_0x085f:
            float r2 = r0.f26027l
            float r3 = r10.g1()
            float r2 = r2 - r3
            r0.f26027l = r2
        L_0x0868:
            java.util.LinkedList<com.itextpdf.text.Element> r2 = r0.J
            r2.removeFirst()
            r2 = -1
            r0.M = r2
            r3 = 0
            r0.L = r3
            goto L_0x019e
        L_0x0875:
            r2 = -1
            int r1 = r0.M
            if (r1 <= r2) goto L_0x0889
            java.util.ArrayList r1 = r10.e0()
            int r2 = r0.L
        L_0x0880:
            if (r2 >= r15) goto L_0x0889
            r3 = 0
            r1.set(r2, r3)
            r4 = 1
            int r2 = r2 + r4
            goto L_0x0880
        L_0x0889:
            r0.L = r15
            r4 = 2
        L_0x088c:
            return r4
        L_0x088d:
            r19 = r9
            r2 = -1
            r3 = 0
            r4 = 2
            int r5 = r10.type()
            r6 = 55
            if (r5 != r6) goto L_0x08c4
            if (r1 != 0) goto L_0x08bb
            r20 = r10
            com.itextpdf.text.pdf.draw.DrawInterface r20 = (com.itextpdf.text.pdf.draw.DrawInterface) r20
            com.itextpdf.text.pdf.PdfContentByte r3 = r0.q
            float r5 = r0.f26020e
            float r6 = r0.f26019d
            float r7 = r0.f26021f
            float r9 = r0.f26018c
            float r10 = r0.f26027l
            r21 = r3
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r9
            r26 = r10
            r20.a(r21, r22, r23, r24, r25, r26)
        L_0x08bb:
            java.util.LinkedList<com.itextpdf.text.Element> r3 = r0.J
            r3.removeFirst()
            r3 = 0
            r7 = 1
            goto L_0x05df
        L_0x08c4:
            int r5 = r10.type()
            r6 = 37
            if (r5 != r6) goto L_0x0929
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
        L_0x08d1:
            r5.add(r10)
            java.util.LinkedList<com.itextpdf.text.Element> r7 = r0.J
            r7.removeFirst()
            java.util.LinkedList<com.itextpdf.text.Element> r7 = r0.J
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x08eb
            java.util.LinkedList<com.itextpdf.text.Element> r7 = r0.J
            java.lang.Object r7 = r7.getFirst()
            com.itextpdf.text.Element r7 = (com.itextpdf.text.Element) r7
            r10 = r7
            goto L_0x08ec
        L_0x08eb:
            r10 = r3
        L_0x08ec:
            if (r10 == 0) goto L_0x08f4
            int r7 = r10.type()
            if (r7 == r6) goto L_0x08d1
        L_0x08f4:
            com.itextpdf.text.pdf.FloatLayout r3 = new com.itextpdf.text.pdf.FloatLayout
            boolean r6 = r0.O
            r3.<init>(r5, r6)
            float r6 = r0.f26020e
            float r7 = r0.f26019d
            float r9 = r0.f26021f
            float r10 = r0.f26027l
            r3.h(r6, r7, r9, r10)
            com.itextpdf.text.pdf.ColumnText r6 = r3.f26047i
            boolean r7 = r32.P()
            r6.d0(r7)
            com.itextpdf.text.pdf.PdfContentByte r6 = r0.q
            int r6 = r3.e(r6, r1)
            float r3 = r3.d()
            r0.f26027l = r3
            r3 = 0
            r0.G = r3
            r7 = 1
            r9 = r6 & 1
            if (r9 != 0) goto L_0x05df
            java.util.LinkedList<com.itextpdf.text.Element> r1 = r0.J
            r1.addAll(r5)
            return r6
        L_0x0929:
            r3 = 0
            r7 = 1
            java.util.LinkedList<com.itextpdf.text.Element> r5 = r0.J
            r5.removeFirst()
            goto L_0x05df
        L_0x0932:
            com.itextpdf.text.DocumentException r1 = new com.itextpdf.text.DocumentException
            java.lang.String r2 = "irregular.columns.are.not.supported.in.composite.mode"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r1.<init>((java.lang.String) r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.L(boolean):int");
    }

    public boolean N() {
        return this.Q;
    }

    public boolean P() {
        return this.S;
    }

    public boolean R() {
        return this.O;
    }

    public boolean S() {
        return this.f26026k;
    }

    public ColumnText T(ColumnText columnText) {
        if (columnText != null) {
            p0(columnText);
            if (columnText.f26025j != null) {
                this.f26025j = new BidiLine(columnText.f26025j);
            }
        }
        return this;
    }

    public void U(boolean z2) {
        this.Q = z2;
    }

    public void V(int i2) {
        this.f26022g = i2;
    }

    public void W(int i2) {
        this.F = i2;
    }

    public void X(PdfContentByte pdfContentByte) {
        this.q = pdfContentByte;
        this.r = null;
        ColumnText columnText = this.I;
        if (columnText != null) {
            columnText.X(pdfContentByte);
        }
    }

    public void Y(PdfContentByte[] pdfContentByteArr) {
        this.r = pdfContentByteArr;
        this.q = pdfContentByteArr[3];
        ColumnText columnText = this.I;
        if (columnText != null) {
            columnText.Y(pdfContentByteArr);
        }
    }

    public void Z(float[] fArr, float[] fArr2) {
        this.f26018c = -1.0E21f;
        this.f26019d = 1.0E21f;
        t0(Math.max(fArr[1], fArr[fArr.length - 1]));
        this.f26024i = f(fArr2);
        this.f26023h = f(fArr);
        this.x = -1.0f;
        this.y = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.itextpdf.text.Paragraph r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = r7 instanceof com.itextpdf.text.Image
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0071
            com.itextpdf.text.Image r7 = (com.itextpdf.text.Image) r7
            com.itextpdf.text.pdf.PdfPTable r0 = new com.itextpdf.text.pdf.PdfPTable
            r0.<init>((int) r2)
            float r3 = r7.u1()
            r4 = 0
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x0024
            float r3 = r7.p1()
            r0.X0(r3)
            r0.O0(r2)
            goto L_0x0027
        L_0x0024:
            r0.Z0(r3)
        L_0x0027:
            float r3 = r7.K()
            r0.c(r3)
            float r3 = r7.E()
            r0.h(r3)
            int r3 = r7.G0()
            if (r3 == 0) goto L_0x0046
            r5 = 2
            if (r3 == r5) goto L_0x0042
            r0.M0(r2)
            goto L_0x0049
        L_0x0042:
            r0.M0(r5)
            goto L_0x0049
        L_0x0046:
            r0.M0(r1)
        L_0x0049:
            com.itextpdf.text.pdf.PdfPCell r3 = new com.itextpdf.text.pdf.PdfPCell
            r3.<init>((com.itextpdf.text.Image) r7, (boolean) r2)
            r3.H1(r4)
            int r4 = r7.l()
            r3.i0(r4)
            com.itextpdf.text.BaseColor r4 = r7.p()
            r3.j0(r4)
            float r4 = r7.y()
            r3.p0(r4)
            com.itextpdf.text.BaseColor r7 = r7.k()
            r3.h0(r7)
            r0.a(r3)
            r7 = r0
        L_0x0071:
            int r0 = r7.type()
            r3 = 10
            r4 = 23
            if (r0 != r3) goto L_0x0084
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            com.itextpdf.text.Chunk r7 = (com.itextpdf.text.Chunk) r7
            r0.<init>((com.itextpdf.text.Chunk) r7)
        L_0x0082:
            r7 = r0
            goto L_0x00a0
        L_0x0084:
            int r0 = r7.type()
            r3 = 11
            if (r0 != r3) goto L_0x0094
            com.itextpdf.text.Paragraph r0 = new com.itextpdf.text.Paragraph
            com.itextpdf.text.Phrase r7 = (com.itextpdf.text.Phrase) r7
            r0.<init>((com.itextpdf.text.Phrase) r7)
            goto L_0x0082
        L_0x0094:
            int r0 = r7.type()
            if (r0 != r4) goto L_0x00a0
            r0 = r7
            com.itextpdf.text.pdf.PdfPTable r0 = (com.itextpdf.text.pdf.PdfPTable) r0
            r0.p0()
        L_0x00a0:
            int r0 = r7.type()
            r3 = 12
            if (r0 == r3) goto L_0x00d5
            int r0 = r7.type()
            r5 = 14
            if (r0 == r5) goto L_0x00d5
            int r0 = r7.type()
            if (r0 == r4) goto L_0x00d5
            int r0 = r7.type()
            r4 = 55
            if (r0 == r4) goto L_0x00d5
            int r0 = r7.type()
            r4 = 37
            if (r0 != r4) goto L_0x00c7
            goto L_0x00d5
        L_0x00c7:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "element.not.allowed"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r7.<init>(r0)
            throw r7
        L_0x00d5:
            boolean r0 = r6.H
            if (r0 != 0) goto L_0x00e7
            r6.H = r2
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r6.J = r0
            r0 = 0
            r6.f26025j = r0
            r6.N = r0
        L_0x00e7:
            int r0 = r7.type()
            if (r0 != r3) goto L_0x00f9
            com.itextpdf.text.Paragraph r7 = (com.itextpdf.text.Paragraph) r7
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.J
            java.util.List r7 = r7.u1()
            r0.addAll(r7)
            return
        L_0x00f9:
            java.util.LinkedList<com.itextpdf.text.Element> r0 = r6.J
            r0.add(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.ColumnText.a(com.itextpdf.text.Element):void");
    }

    public void a0(float f2) {
        this.w = f2;
    }

    public void b(Chunk chunk) {
        if (chunk != null && !this.H) {
            c(new Phrase(chunk));
        }
    }

    public void b0(float f2) {
        this.P = f2;
    }

    public void c(Phrase phrase) {
        if (phrase != null && !this.H) {
            d();
            if (this.f26025j == null) {
                this.N = phrase;
                return;
            }
            for (Chunk pdfChunk : phrase.Y()) {
                this.f26025j.a(new PdfChunk(pdfChunk, (PdfAction) null, phrase.F0()));
            }
        }
    }

    public void c0(float f2) {
        this.u = f2;
        this.A = true;
    }

    public void d0(boolean z2) {
        this.S = z2;
    }

    public void e() {
        BidiLine bidiLine = this.f26025j;
        if (bidiLine != null) {
            bidiLine.d();
        }
    }

    public void e0(float f2) {
        f0(f2, true);
    }

    /* access modifiers changed from: protected */
    public ArrayList<float[]> f(float[] fArr) {
        if (fArr.length >= 4) {
            ArrayList<float[]> arrayList = new ArrayList<>();
            int i2 = 0;
            while (i2 < fArr.length - 2) {
                float f2 = fArr[i2];
                float f3 = fArr[i2 + 1];
                int i3 = i2 + 2;
                float f4 = fArr[i3];
                float f5 = fArr[i2 + 3];
                if (f3 != f5) {
                    float f6 = (f2 - f4) / (f3 - f5);
                    float min = Math.min(f3, f5);
                    float max = Math.max(f3, f5);
                    float[] fArr2 = {min, max, f6, f2 - (f6 * f3)};
                    arrayList.add(fArr2);
                    this.f26018c = Math.max(this.f26018c, fArr2[1]);
                    this.f26019d = Math.min(this.f26019d, fArr2[0]);
                }
                i2 = i3;
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new RuntimeException(MessageLocalization.b("no.valid.column.line.found", new Object[0]));
        }
        throw new RuntimeException(MessageLocalization.b("no.valid.column.line.found", new Object[0]));
    }

    public void f0(float f2, boolean z2) {
        this.t = f2;
        this.A = true;
        this.B = z2;
    }

    public void g0(boolean z2) {
        this.R = z2;
    }

    /* access modifiers changed from: protected */
    public float[] h() {
        float i2 = i(this.f26023h);
        int i3 = this.s;
        if (i3 == 1 || i3 == 2) {
            return null;
        }
        float i4 = i(this.f26024i);
        if (this.s == 2) {
            return null;
        }
        return new float[]{i2, i4};
    }

    public void h0(float f2) {
        this.o = f2;
        this.p = 0.0f;
    }

    /* access modifiers changed from: protected */
    public float i(ArrayList<float[]> arrayList) {
        this.s = 0;
        float f2 = this.f26027l;
        if (f2 < this.f26019d || f2 > this.f26018c) {
            this.s = 1;
            return 0.0f;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            float[] fArr = arrayList.get(i2);
            float f3 = this.f26027l;
            if (f3 >= fArr[0] && f3 <= fArr[1]) {
                return (fArr[2] * f3) + fArr[3];
            }
        }
        this.s = 2;
        return 0.0f;
    }

    public void i0(float f2, float f3) {
        this.o = f2;
        this.p = f3;
    }

    /* access modifiers changed from: protected */
    public float[] j() {
        do {
            float[] h2 = h();
            int i2 = this.s;
            if (i2 == 1) {
                return null;
            }
            this.f26027l -= this.f26029n;
            if (i2 != 2) {
                float[] h3 = h();
                int i3 = this.s;
                if (i3 == 1) {
                    return null;
                }
                if (i3 == 2) {
                    this.f26027l -= this.f26029n;
                } else {
                    float f2 = h2[0];
                    float f3 = h3[1];
                    if (f2 < f3) {
                        float f4 = h3[0];
                        float f5 = h2[1];
                        if (f4 < f5) {
                            return new float[]{f2, f5, f4, f3};
                        }
                    }
                }
            }
        } while (this.f26029n != 0.0f);
        return null;
    }

    public void j0(float f2) {
        this.v = f2;
        this.A = true;
    }

    public void k0(int i2) {
        if (i2 < 0 || i2 > 3) {
            throw new RuntimeException(MessageLocalization.a("invalid.run.direction.1", i2));
        }
        this.f26017b = i2;
    }

    public int l() {
        return this.f26022g;
    }

    public void l0(float f2, float f3, float f4, float f5) {
        this.f26020e = Math.min(f2, f4);
        this.f26018c = Math.max(f3, f5);
        this.f26019d = Math.min(f3, f5);
        float max = Math.max(f2, f4);
        this.f26021f = max;
        this.f26027l = this.f26018c;
        float f6 = max - this.f26020e;
        this.x = f6;
        if (f6 < 0.0f) {
            this.x = 0.0f;
        }
        this.y = true;
    }

    public int m() {
        return this.F;
    }

    public void m0(float f2, float f3, float f4, float f5, float f6, int i2) {
        h0(f6);
        this.f26022g = i2;
        l0(f2, f3, f4, f5);
    }

    public PdfContentByte n() {
        return this.q;
    }

    public void n0(Phrase phrase, float f2, float f3, float f4, float f5, float f6, int i2) {
        c(phrase);
        m0(f2, f3, f4, f5, f6, i2);
    }

    public PdfContentByte[] o() {
        return this.r;
    }

    public void o0(Rectangle rectangle) {
        l0(rectangle.O(), rectangle.H(), rectangle.Q(), rectangle.T());
    }

    public List<Element> p() {
        return this.J;
    }

    /* access modifiers changed from: protected */
    public void p0(ColumnText columnText) {
        this.f26018c = columnText.f26018c;
        this.f26019d = columnText.f26019d;
        this.f26022g = columnText.f26022g;
        this.f26023h = null;
        if (columnText.f26023h != null) {
            this.f26023h = new ArrayList<>(columnText.f26023h);
        }
        this.f26024i = null;
        if (columnText.f26024i != null) {
            this.f26024i = new ArrayList<>(columnText.f26024i);
        }
        this.f26027l = columnText.f26027l;
        this.f26029n = columnText.f26029n;
        this.o = columnText.o;
        this.p = columnText.p;
        this.q = columnText.q;
        this.r = columnText.r;
        this.s = columnText.s;
        this.t = columnText.t;
        this.u = columnText.u;
        this.v = columnText.v;
        this.w = columnText.w;
        this.x = columnText.x;
        this.y = columnText.y;
        this.z = columnText.z;
        this.A = columnText.A;
        this.B = columnText.B;
        this.C = columnText.C;
        this.F = columnText.F;
        this.f26017b = columnText.f26017b;
        this.G = columnText.G;
        this.H = columnText.H;
        this.M = columnText.M;
        if (columnText.H) {
            this.J = new LinkedList<>();
            Iterator<Element> it2 = columnText.J.iterator();
            while (it2.hasNext()) {
                Element next = it2.next();
                if (next instanceof PdfPTable) {
                    this.J.add(new PdfPTable((PdfPTable) next));
                } else {
                    this.J.add(next);
                }
            }
            ColumnText columnText2 = columnText.I;
            if (columnText2 != null) {
                this.I = g(columnText2);
            }
        }
        this.K = columnText.K;
        this.L = columnText.L;
        this.D = columnText.D;
        this.f26020e = columnText.f26020e;
        this.f26021f = columnText.f26021f;
        this.E = columnText.E;
        this.N = columnText.N;
        this.O = columnText.O;
        this.P = columnText.P;
        this.Q = columnText.Q;
        this.R = columnText.R;
        this.S = columnText.S;
    }

    public float q() {
        return this.f26029n;
    }

    public void q0(float f2) {
        this.z = f2;
    }

    public float r() {
        return this.G;
    }

    public void r0(Phrase phrase) {
        this.f26025j = null;
        this.H = false;
        this.I = null;
        this.J = null;
        this.K = 0;
        this.L = 0;
        this.M = -1;
        this.N = phrase;
    }

    public float s() {
        return this.w;
    }

    public void s0(boolean z2) {
        this.O = z2;
    }

    public float t() {
        return this.P;
    }

    public void t0(float f2) {
        this.f26027l = f2;
    }

    public float u() {
        return this.u;
    }

    public float v() {
        return this.t;
    }

    public boolean w() {
        return this.R;
    }

    public void w0(float f2) {
        if (f2 > this.P) {
            this.P = f2;
        }
    }

    public float x() {
        return this.f26028m;
    }

    public boolean x0() {
        return this.H && !this.J.isEmpty() && this.J.getFirst().type() == 55;
    }

    public float y() {
        return this.o;
    }

    public int z() {
        return this.C;
    }
}
