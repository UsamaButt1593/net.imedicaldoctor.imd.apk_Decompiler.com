package com.itextpdf.text.pdf.codec.wmf;

import com.google.android.material.internal.ViewUtils;
import com.itextpdf.text.Image;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MetaDo {
    public static final int A = 531;
    public static final int B = 532;
    public static final int C = 1045;
    public static final int D = 1046;
    public static final int E = 2071;
    public static final int F = 1048;
    public static final int G = 1049;
    public static final int H = 2074;
    public static final int I = 1051;
    public static final int J = 1564;
    public static final int K = 1565;
    public static final int L = 30;
    public static final int M = 1055;
    public static final int N = 544;
    public static final int O = 1313;
    public static final int P = 2338;
    public static final int Q = 2851;
    public static final int R = 804;
    public static final int S = 805;
    public static final int T = 1574;
    public static final int U = 295;
    public static final int V = 552;
    public static final int W = 1065;
    public static final int X = 298;
    public static final int Y = 299;
    public static final int Z = 300;
    public static final int a0 = 301;
    public static final int b0 = 302;
    public static final int c0 = 2096;
    public static final int d0 = 561;
    public static final int e0 = 2610;
    public static final int f0 = 3379;
    public static final int g0 = 564;
    public static final int h0 = 53;

    /* renamed from: i  reason: collision with root package name */
    public static final int f26721i = 513;
    public static final int i0 = 1078;

    /* renamed from: j  reason: collision with root package name */
    public static final int f26722j = 258;
    public static final int j0 = 55;

    /* renamed from: k  reason: collision with root package name */
    public static final int f26723k = 259;
    public static final int k0 = 1336;

    /* renamed from: l  reason: collision with root package name */
    public static final int f26724l = 260;
    public static final int l0 = 313;

    /* renamed from: m  reason: collision with root package name */
    public static final int f26725m = 261;
    public static final int m0 = 2368;

    /* renamed from: n  reason: collision with root package name */
    public static final int f26726n = 262;
    public static final int n0 = 2881;
    public static final int o = 263;
    public static final int o0 = 322;
    public static final int p = 264;
    public static final int p0 = 3907;
    public static final int q = 521;
    public static final int q0 = 1352;
    public static final int r = 522;
    public static final int r0 = 496;
    public static final int s = 523;
    public static final int s0 = 247;
    public static final int t = 524;
    public static final int t0 = 505;
    public static final int u = 525;
    public static final int u0 = 762;
    public static final int v = 526;
    public static final int v0 = 763;
    public static final int w = 527;
    public static final int w0 = 764;
    public static final int x = 1040;
    public static final int x0 = 1791;
    public static final int y = 529;
    public static final int z = 1042;

    /* renamed from: a  reason: collision with root package name */
    public PdfContentByte f26727a;

    /* renamed from: b  reason: collision with root package name */
    public InputMeta f26728b;

    /* renamed from: c  reason: collision with root package name */
    int f26729c;

    /* renamed from: d  reason: collision with root package name */
    int f26730d;

    /* renamed from: e  reason: collision with root package name */
    int f26731e;

    /* renamed from: f  reason: collision with root package name */
    int f26732f;

    /* renamed from: g  reason: collision with root package name */
    int f26733g;

    /* renamed from: h  reason: collision with root package name */
    MetaState f26734h = new MetaState();

    public MetaDo(InputStream inputStream, PdfContentByte pdfContentByte) {
        this.f26727a = pdfContentByte;
        this.f26728b = new InputMeta(inputStream);
    }

    static double a(double d2, double d3, double d4, double d5) {
        double atan2 = Math.atan2(d5 - d3, d4 - d2);
        if (atan2 < 0.0d) {
            atan2 += 6.283185307179586d;
        }
        return (double) ((float) ((atan2 / 3.141592653589793d) * 180.0d));
    }

    static float b(float f2, float f3, float f4, float f5) {
        return (float) a((double) f2, (double) f3, (double) f4, (double) f5);
    }

    public static byte[] g(Image image) throws IOException {
        byte[] bArr;
        if (image.k1() == 4) {
            if (image.j1() == null) {
                InputStream openStream = image.t1().openStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = openStream.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                openStream.close();
                bArr = byteArrayOutputStream.toByteArray();
            } else {
                bArr = image.j1();
            }
            int length = (bArr.length - 13) >>> 1;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            i(byteArrayOutputStream2, 1);
            i(byteArrayOutputStream2, 9);
            i(byteArrayOutputStream2, ViewUtils.f21582a);
            h(byteArrayOutputStream2, length + 39);
            i(byteArrayOutputStream2, 1);
            h(byteArrayOutputStream2, length + 14);
            i(byteArrayOutputStream2, 0);
            h(byteArrayOutputStream2, 4);
            i(byteArrayOutputStream2, 259);
            i(byteArrayOutputStream2, 8);
            h(byteArrayOutputStream2, 5);
            i(byteArrayOutputStream2, s);
            i(byteArrayOutputStream2, 0);
            i(byteArrayOutputStream2, 0);
            h(byteArrayOutputStream2, 5);
            i(byteArrayOutputStream2, t);
            i(byteArrayOutputStream2, (int) image.N());
            i(byteArrayOutputStream2, (int) image.a0());
            h(byteArrayOutputStream2, length + 13);
            i(byteArrayOutputStream2, n0);
            h(byteArrayOutputStream2, 13369376);
            i(byteArrayOutputStream2, (int) image.N());
            i(byteArrayOutputStream2, (int) image.a0());
            i(byteArrayOutputStream2, 0);
            i(byteArrayOutputStream2, 0);
            i(byteArrayOutputStream2, (int) image.N());
            i(byteArrayOutputStream2, (int) image.a0());
            i(byteArrayOutputStream2, 0);
            i(byteArrayOutputStream2, 0);
            byteArrayOutputStream2.write(bArr, 14, bArr.length - 14);
            if ((bArr.length & 1) == 1) {
                byteArrayOutputStream2.write(0);
            }
            h(byteArrayOutputStream2, 3);
            i(byteArrayOutputStream2, 0);
            byteArrayOutputStream2.close();
            return byteArrayOutputStream2.toByteArray();
        }
        throw new IOException(MessageLocalization.b("only.bmp.can.be.wrapped.in.wmf", new Object[0]));
    }

    public static void h(OutputStream outputStream, int i2) throws IOException {
        i(outputStream, i2 & 65535);
        i(outputStream, (i2 >>> 16) & 65535);
    }

    public static void i(OutputStream outputStream, int i2) throws IOException {
        outputStream.write(i2 & 255);
        outputStream.write((i2 >>> 8) & 255);
    }

    public boolean c(boolean z2) {
        MetaPen h2 = this.f26734h.h();
        MetaBrush f2 = this.f26734h.f();
        boolean z3 = false;
        boolean z4 = h2.d() == 5;
        int d2 = f2.d();
        boolean z5 = d2 == 0 || (d2 == 2 && this.f26734h.d() == 2);
        if (z4 && !z5) {
            z3 = true;
        }
        if (!z4) {
            if (z2) {
                this.f26734h.x(this.f26727a);
            } else {
                this.f26734h.w(this.f26727a);
            }
        }
        return z3;
    }

    public void d(int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str) {
        String str2 = str;
        MetaFont g2 = this.f26734h.g();
        float G2 = this.f26734h.G(i2);
        float H2 = this.f26734h.H(i3);
        double F2 = (double) this.f26734h.F(g2.b());
        float sin = (float) Math.sin(F2);
        float cos = (float) Math.cos(F2);
        float d2 = g2.d(this.f26734h);
        BaseFont c2 = g2.c();
        int m2 = this.f26734h.m();
        float Z2 = c2.Z(str2, d2);
        float I2 = c2.I(3, d2);
        float I3 = c2.I(8, d2);
        this.f26727a.a2();
        this.f26727a.l0(cos, sin, -sin, cos, G2, H2);
        float f2 = 0.0f;
        float f3 = (m2 & 6) == 6 ? (-Z2) / 2.0f : (m2 & 2) == 2 ? -Z2 : 0.0f;
        if ((m2 & 24) != 24) {
            f2 = (m2 & 8) == 8 ? -I2 : -I3;
        }
        if (this.f26734h.d() == 2) {
            this.f26727a.h2(this.f26734h.e());
            this.f26727a.H1(f3, f2 + I2, Z2, I3 - I2);
            this.f26727a.Q0();
        }
        this.f26727a.h2(this.f26734h.j());
        this.f26727a.R();
        this.f26727a.s2(c2, d2);
        this.f26727a.e3(f3, f2);
        this.f26727a.m3(str2);
        this.f26727a.L0();
        if (g2.g()) {
            this.f26727a.H1(f3, f2 - (d2 / 4.0f), Z2, d2 / 15.0f);
            this.f26727a.Q0();
        }
        if (g2.f()) {
            this.f26727a.H1(f3, f2 + (d2 / 3.0f), Z2, d2 / 15.0f);
            this.f26727a.Q0();
        }
        this.f26727a.U1();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v53, resolved type: com.itextpdf.text.pdf.codec.wmf.MetaFont} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: com.itextpdf.text.pdf.codec.wmf.MetaPen} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v55, resolved type: com.itextpdf.text.pdf.codec.wmf.MetaBrush} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v144, resolved type: com.itextpdf.text.pdf.codec.wmf.MetaPen} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v145, resolved type: com.itextpdf.text.pdf.codec.wmf.MetaPen} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v146, resolved type: com.itextpdf.text.pdf.codec.wmf.MetaPen} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0648, code lost:
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x07b0, code lost:
        r9.f26734h.a(r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            r41 = this;
            r9 = r41
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.d()
            r1 = -1698247209(0xffffffff9ac6cdd7, float:-8.222343E-23)
            r10 = 0
            if (r0 != r1) goto L_0x0939
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            r0.f()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            r9.f26729c = r0
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            r9.f26730d = r0
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            r9.f26731e = r0
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            r9.f26732f = r0
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            r9.f26733g = r0
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            int r2 = r9.f26731e
            int r3 = r9.f26729c
            int r2 = r2 - r3
            float r2 = (float) r2
            float r0 = (float) r0
            float r2 = r2 / r0
            r0 = 1116733440(0x42900000, float:72.0)
            float r2 = r2 * r0
            r1.C(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            int r2 = r9.f26732f
            int r3 = r9.f26730d
            int r2 = r2 - r3
            float r2 = (float) r2
            int r3 = r9.f26733g
            float r3 = (float) r3
            float r2 = r2 / r3
            float r2 = r2 * r0
            r1.D(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            int r1 = r9.f26729c
            r0.z(r1)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            int r1 = r9.f26730d
            r0.A(r1)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            int r1 = r9.f26731e
            int r2 = r9.f26729c
            int r1 = r1 - r2
            r0.u(r1)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            int r1 = r9.f26732f
            int r2 = r9.f26730d
            int r1 = r1 - r2
            r0.v(r1)
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            r0.d()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            r0.f()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            r1 = 18
            r0.g(r1)
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r11 = 1
            r0.y2(r11)
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.H2(r11)
        L_0x009b:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r12 = r0.a()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r13 = r0.d()
            r0 = 3
            if (r13 >= r0) goto L_0x00b2
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.PdfContentByte r1 = r9.f26727a
            r0.b(r1)
            return
        L_0x00b2:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r1 = r9.f26728b
            int r1 = r1.f()
            java.lang.String r14 = "Cp1252"
            r16 = 2
            r17 = 1073741824(0x40000000, float:2.0)
            switch(r1) {
                case 30: goto L_0x091b;
                case 247: goto L_0x090b;
                case 258: goto L_0x08fa;
                case 262: goto L_0x08e9;
                case 295: goto L_0x08d6;
                case 301: goto L_0x08c3;
                case 302: goto L_0x08b2;
                case 322: goto L_0x090b;
                case 496: goto L_0x08a0;
                case 513: goto L_0x088e;
                case 521: goto L_0x087c;
                case 523: goto L_0x085f;
                case 524: goto L_0x0842;
                case 531: goto L_0x07f4;
                case 532: goto L_0x07d7;
                case 762: goto L_0x07c7;
                case 763: goto L_0x07b7;
                case 764: goto L_0x07a1;
                case 804: goto L_0x073a;
                case 805: goto L_0x06e1;
                case 1046: goto L_0x0699;
                case 1048: goto L_0x064d;
                case 1051: goto L_0x0604;
                case 1055: goto L_0x05c4;
                case 1313: goto L_0x0573;
                case 1336: goto L_0x04f7;
                case 1564: goto L_0x0483;
                case 1791: goto L_0x090b;
                case 2071: goto L_0x03ea;
                case 2074: goto L_0x02f9;
                case 2096: goto L_0x01fa;
                case 2610: goto L_0x0197;
                case 2881: goto L_0x00c8;
                case 3907: goto L_0x00c8;
                default: goto L_0x00c1;
            }
        L_0x00c1:
            r26 = r12
            r27 = r13
        L_0x00c5:
            r1 = 1
            goto L_0x0927
        L_0x00c8:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            r0.d()
            r0 = 3907(0xf43, float:5.475E-42)
            if (r1 != r0) goto L_0x00d6
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            r0.f()
        L_0x00d6:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r1 = r9.f26728b
            int r1 = r1.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r4 = r4.H(r5)
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            float r5 = r5.H(r10)
            float r4 = r4 - r5
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r6 = r9.f26728b
            int r6 = r6.e()
            float r5 = r5.G(r6)
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            float r6 = r6.G(r10)
            float r5 = r5 - r6
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r7 = r9.f26728b
            int r7 = r7.e()
            float r6 = r6.H(r7)
            com.itextpdf.text.pdf.codec.wmf.MetaState r7 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r8 = r9.f26728b
            int r8 = r8.e()
            float r7 = r7.G(r8)
            int r8 = r13 * 2
            com.itextpdf.text.pdf.codec.wmf.InputMeta r14 = r9.f26728b
            int r14 = r14.a()
            int r14 = r14 - r12
            int r8 = r8 - r14
            byte[] r14 = new byte[r8]
            r15 = 0
        L_0x0139:
            if (r15 >= r8) goto L_0x0148
            com.itextpdf.text.pdf.codec.wmf.InputMeta r10 = r9.f26728b
            int r10 = r10.b()
            byte r10 = (byte) r10
            r14[r15] = r10
            int r15 = r15 + 1
            r10 = 0
            goto L_0x0139
        L_0x0148:
            java.io.ByteArrayInputStream r10 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x00c1 }
            r10.<init>(r14)     // Catch:{ Exception -> 0x00c1 }
            com.itextpdf.text.Image r8 = com.itextpdf.text.pdf.codec.BmpImage.f(r10, r11, r8)     // Catch:{ Exception -> 0x00c1 }
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a     // Catch:{ Exception -> 0x00c1 }
            r10.a2()     // Catch:{ Exception -> 0x00c1 }
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a     // Catch:{ Exception -> 0x00c1 }
            r10.H1(r7, r6, r5, r4)     // Catch:{ Exception -> 0x00c1 }
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a     // Catch:{ Exception -> 0x00c1 }
            r10.b0()     // Catch:{ Exception -> 0x00c1 }
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a     // Catch:{ Exception -> 0x00c1 }
            r10.x1()     // Catch:{ Exception -> 0x00c1 }
            float r10 = r8.a0()     // Catch:{ Exception -> 0x00c1 }
            float r10 = r10 * r5
            float r1 = (float) r1     // Catch:{ Exception -> 0x00c1 }
            float r10 = r10 / r1
            float r14 = -r4
            float r15 = r8.N()     // Catch:{ Exception -> 0x00c1 }
            float r14 = r14 * r15
            float r0 = (float) r0     // Catch:{ Exception -> 0x00c1 }
            float r14 = r14 / r0
            r8.N1(r10, r14)     // Catch:{ Exception -> 0x00c1 }
            float r3 = (float) r3     // Catch:{ Exception -> 0x00c1 }
            float r5 = r5 * r3
            float r5 = r5 / r1
            float r7 = r7 - r5
            float r1 = (float) r2     // Catch:{ Exception -> 0x00c1 }
            float r4 = r4 * r1
            float r4 = r4 / r0
            float r6 = r6 + r4
            float r0 = r8.o1()     // Catch:{ Exception -> 0x00c1 }
            float r6 = r6 - r0
            r8.V1(r7, r6)     // Catch:{ Exception -> 0x00c1 }
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a     // Catch:{ Exception -> 0x00c1 }
            r0.h(r8)     // Catch:{ Exception -> 0x00c1 }
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a     // Catch:{ Exception -> 0x00c1 }
            r0.U1()     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c1
        L_0x0197:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r2 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r1 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.f()
            r4 = r3 & 6
            if (r4 == 0) goto L_0x01cc
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r6 = r9.f26728b
            int r6 = r6.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r7 = r9.f26728b
            int r7 = r7.e()
            goto L_0x01d0
        L_0x01cc:
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x01d0:
            byte[] r8 = new byte[r0]
            r10 = 0
        L_0x01d3:
            if (r10 >= r0) goto L_0x01e4
            com.itextpdf.text.pdf.codec.wmf.InputMeta r15 = r9.f26728b
            int r15 = r15.b()
            byte r15 = (byte) r15
            if (r15 != 0) goto L_0x01df
            goto L_0x01e4
        L_0x01df:
            r8[r10] = r15
            int r10 = r10 + 1
            goto L_0x01d3
        L_0x01e4:
            java.lang.String r0 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x01ec }
            r15 = 0
            r0.<init>(r8, r15, r10, r14)     // Catch:{ UnsupportedEncodingException -> 0x01ed }
        L_0x01ea:
            r8 = r0
            goto L_0x01f3
        L_0x01ec:
            r15 = 0
        L_0x01ed:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r8, r15, r10)
            goto L_0x01ea
        L_0x01f3:
            r0 = r41
            r0.d(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00c1
        L_0x01fa:
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            boolean r1 = r1.k()
            boolean r1 = r9.c(r1)
            if (r1 == 0) goto L_0x0208
            goto L_0x00c1
        L_0x0208:
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r10 = r9.f26728b
            int r10 = r10.e()
            float r1 = r1.H(r10)
            com.itextpdf.text.pdf.codec.wmf.MetaState r10 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r14 = r9.f26728b
            int r14 = r14.e()
            float r10 = r10.G(r14)
            com.itextpdf.text.pdf.codec.wmf.MetaState r14 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            float r2 = r14.H(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r14 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r15 = r9.f26728b
            int r15 = r15.e()
            float r14 = r14.G(r15)
            com.itextpdf.text.pdf.codec.wmf.MetaState r15 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r3 = r15.H(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r15 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            float r4 = r15.G(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r15 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            float r0 = r15.H(r0)
            com.itextpdf.text.pdf.codec.wmf.MetaState r15 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r11 = r9.f26728b
            int r11 = r11.e()
            float r11 = r15.G(r11)
            float r15 = r4 + r11
            float r15 = r15 / r17
            double r5 = (double) r15
            float r15 = r0 + r3
            float r15 = r15 / r17
            double r7 = (double) r15
            double r14 = (double) r14
            r26 = r12
            r27 = r13
            double r12 = (double) r2
            r18 = r5
            r20 = r7
            r22 = r14
            r24 = r12
            double r36 = a(r18, r20, r22, r24)
            double r12 = (double) r10
            double r1 = (double) r1
            r22 = r12
            r24 = r1
            double r1 = a(r18, r20, r22, r24)
            double r1 = r1 - r36
            r5 = 0
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x029c
            r5 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r1 = r1 + r5
        L_0x029c:
            r38 = r1
            double r1 = (double) r11
            double r5 = (double) r3
            double r3 = (double) r4
            double r7 = (double) r0
            r28 = r1
            r30 = r5
            r32 = r3
            r34 = r7
            java.util.ArrayList r0 = com.itextpdf.text.pdf.PdfContentByte.T(r28, r30, r32, r34, r36, r38)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x02b6
        L_0x02b4:
            goto L_0x00c5
        L_0x02b6:
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            double[] r2 = (double[]) r2
            r3 = r2[r1]
            r1 = 1
            r5 = r2[r1]
            com.itextpdf.text.pdf.PdfContentByte r1 = r9.f26727a
            r1.v1(r3, r5)
            r1 = 0
        L_0x02c8:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x02ef
            java.lang.Object r2 = r0.get(r1)
            double[] r2 = (double[]) r2
            com.itextpdf.text.pdf.PdfContentByte r7 = r9.f26727a
            r29 = r2[r16]
            r8 = 3
            r31 = r2[r8]
            r8 = 4
            r33 = r2[r8]
            r8 = 5
            r35 = r2[r8]
            r8 = 6
            r37 = r2[r8]
            r8 = 7
            r39 = r2[r8]
            r28 = r7
            r28.y0(r29, r31, r33, r35, r37, r39)
            int r1 = r1 + 1
            goto L_0x02c8
        L_0x02ef:
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.p1(r3, r5)
        L_0x02f4:
            r41.f()
            goto L_0x00c5
        L_0x02f9:
            r26 = r12
            r27 = r13
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            boolean r0 = r0.k()
            boolean r0 = r9.c(r0)
            if (r0 == 0) goto L_0x030a
        L_0x0309:
            goto L_0x02b4
        L_0x030a:
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r1 = r9.f26728b
            int r1 = r1.e()
            float r0 = r0.H(r1)
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            float r1 = r1.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r2 = r2.H(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            float r3 = r3.G(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r4 = r4.H(r5)
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r6 = r9.f26728b
            int r6 = r6.e()
            float r5 = r5.G(r6)
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r7 = r9.f26728b
            int r7 = r7.e()
            float r6 = r6.H(r7)
            com.itextpdf.text.pdf.codec.wmf.MetaState r7 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r8 = r9.f26728b
            int r8 = r8.e()
            float r7 = r7.G(r8)
            float r8 = r5 + r7
            float r8 = r8 / r17
            float r10 = r6 + r4
            float r10 = r10 / r17
            float r2 = b(r8, r10, r3, r2)
            double r2 = (double) r2
            float r0 = b(r8, r10, r1, r0)
            double r0 = (double) r0
            double r0 = r0 - r2
            r11 = 0
            int r13 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r13 > 0) goto L_0x0389
            r11 = 4645040803167600640(0x4076800000000000, double:360.0)
            double r0 = r0 + r11
        L_0x0389:
            r38 = r0
            double r0 = (double) r7
            double r11 = (double) r4
            double r4 = (double) r5
            double r6 = (double) r6
            r28 = r0
            r30 = r11
            r32 = r4
            r34 = r6
            r36 = r2
            java.util.ArrayList r0 = com.itextpdf.text.pdf.PdfContentByte.T(r28, r30, r32, r34, r36, r38)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x03a5
            goto L_0x0309
        L_0x03a5:
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            double[] r2 = (double[]) r2
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r3.w1(r8, r10)
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r4 = r2[r1]
            r1 = 1
            r6 = r2[r1]
            r3.p1(r4, r6)
            r1 = 0
        L_0x03bc:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x03e3
            java.lang.Object r2 = r0.get(r1)
            double[] r2 = (double[]) r2
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r29 = r2[r16]
            r4 = 3
            r31 = r2[r4]
            r5 = 4
            r33 = r2[r5]
            r6 = 5
            r35 = r2[r6]
            r7 = 6
            r37 = r2[r7]
            r11 = 7
            r39 = r2[r11]
            r28 = r3
            r28.y0(r29, r31, r33, r35, r37, r39)
            int r1 = r1 + 1
            goto L_0x03bc
        L_0x03e3:
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.q1(r8, r10)
            goto L_0x02f4
        L_0x03ea:
            r26 = r12
            r27 = r13
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            boolean r0 = r0.k()
            boolean r0 = r9.c(r0)
            if (r0 == 0) goto L_0x03fc
            goto L_0x0309
        L_0x03fc:
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r1 = r9.f26728b
            int r1 = r1.e()
            float r0 = r0.H(r1)
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            float r1 = r1.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r2 = r2.H(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            float r3 = r3.G(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r12 = r4.H(r5)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r13 = r4.G(r5)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r14 = r4.H(r5)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r11 = r4.G(r5)
            float r4 = r13 + r11
            float r4 = r4 / r17
            float r5 = r14 + r12
            float r5 = r5 / r17
            float r15 = b(r4, r5, r3, r2)
            float r0 = b(r4, r5, r1, r0)
            float r0 = r0 - r15
            r1 = 0
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0475
            r1 = 1135869952(0x43b40000, float:360.0)
            float r0 = r0 + r1
        L_0x0475:
            r16 = r0
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a
            r10.J(r11, r12, r13, r14, r15, r16)
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.v3()
            goto L_0x00c5
        L_0x0483:
            r26 = r12
            r27 = r13
            r0 = 1
            boolean r1 = r9.c(r0)
            if (r1 == 0) goto L_0x0490
            goto L_0x0309
        L_0x0490:
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            r1 = 0
            float r0 = r0.H(r1)
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r2 = r2.H(r3)
            float r0 = r0 - r2
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r2 = r2.G(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            float r3 = r3.G(r1)
            float r2 = r2 - r3
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r12 = r1.H(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r1 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r1 = r1.G(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            float r3 = r3.H(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r11 = r4.G(r5)
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a
            float r13 = r1 - r11
            float r14 = r3 - r12
            float r0 = r0 + r2
            r1 = 1082130432(0x40800000, float:4.0)
            float r15 = r0 / r1
            r10.W1(r11, r12, r13, r14, r15)
            goto L_0x02f4
        L_0x04f7:
            r26 = r12
            r27 = r13
            r0 = 0
            boolean r1 = r9.c(r0)
            if (r1 == 0) goto L_0x0504
            goto L_0x0309
        L_0x0504:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            int[] r1 = new int[r0]
            r2 = 0
        L_0x050d:
            if (r2 >= r0) goto L_0x051a
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.f()
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x050d
        L_0x051a:
            r2 = 0
        L_0x051b:
            if (r2 >= r0) goto L_0x02f4
            r3 = r1[r2]
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            com.itextpdf.text.pdf.PdfContentByte r6 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r7 = r9.f26734h
            float r7 = r7.G(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r8 = r9.f26734h
            float r8 = r8.H(r5)
            r6.w1(r7, r8)
            r6 = 1
        L_0x053d:
            if (r6 >= r3) goto L_0x055f
            com.itextpdf.text.pdf.codec.wmf.InputMeta r7 = r9.f26728b
            int r7 = r7.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r8 = r9.f26728b
            int r8 = r8.e()
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r11 = r9.f26734h
            float r7 = r11.G(r7)
            com.itextpdf.text.pdf.codec.wmf.MetaState r11 = r9.f26734h
            float r8 = r11.H(r8)
            r10.q1(r7, r8)
            int r6 = r6 + 1
            goto L_0x053d
        L_0x055f:
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            float r4 = r6.G(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            float r5 = r6.H(r5)
            r3.q1(r4, r5)
            int r2 = r2 + 1
            goto L_0x051b
        L_0x0573:
            r26 = r12
            r27 = r13
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            byte[] r1 = new byte[r0]
            r2 = 0
        L_0x0580:
            if (r2 >= r0) goto L_0x0591
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.b()
            byte r3 = (byte) r3
            if (r3 != 0) goto L_0x058c
            goto L_0x0591
        L_0x058c:
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x0580
        L_0x0591:
            java.lang.String r3 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0599 }
            r4 = 0
            r3.<init>(r1, r4, r2, r14)     // Catch:{ UnsupportedEncodingException -> 0x059a }
        L_0x0597:
            r8 = r3
            goto L_0x05a0
        L_0x0599:
            r4 = 0
        L_0x059a:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r1, r4, r2)
            goto L_0x0597
        L_0x05a0:
            int r0 = r0 + 1
            r1 = 65534(0xfffe, float:9.1833E-41)
            r0 = r0 & r1
            com.itextpdf.text.pdf.codec.wmf.InputMeta r1 = r9.f26728b
            int r0 = r0 - r2
            r1.g(r0)
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r2 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r1 = r0.e()
            r6 = 0
            r7 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r41
            r0.d(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x00c5
        L_0x05c4:
            r26 = r12
            r27 = r13
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            com.itextpdf.text.BaseColor r0 = r0.c()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r1 = r9.f26728b
            int r1 = r1.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r3.a2()
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r3.h2(r0)
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            float r2 = r3.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            float r1 = r3.H(r1)
            r3 = 1045220557(0x3e4ccccd, float:0.2)
            r0.H1(r2, r1, r3, r3)
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.Q0()
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.U1()
            goto L_0x00c5
        L_0x0604:
            r26 = r12
            r27 = r13
            r1 = 1
            boolean r0 = r9.c(r1)
            if (r0 == 0) goto L_0x0611
            goto L_0x0927
        L_0x0611:
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            float r0 = r0.H(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r2 = r2.G(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            float r3 = r3.H(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r4 = r4.G(r5)
            com.itextpdf.text.pdf.PdfContentByte r5 = r9.f26727a
            float r2 = r2 - r4
            float r3 = r3 - r0
            r5.H1(r4, r0, r2, r3)
        L_0x0648:
            r41.f()
            goto L_0x0927
        L_0x064d:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            boolean r0 = r0.k()
            boolean r0 = r9.c(r0)
            if (r0 == 0) goto L_0x0660
            goto L_0x0927
        L_0x0660:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            com.itextpdf.text.pdf.PdfContentByte r10 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            float r11 = r5.G(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            float r12 = r4.H(r0)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            float r13 = r0.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            float r14 = r0.H(r3)
            r15 = 0
            r16 = 1135869952(0x43b40000, float:360.0)
            r10.J(r11, r12, r13, r14, r15, r16)
            goto L_0x0648
        L_0x0699:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            float r0 = r0.H(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            float r2 = r2.G(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            float r3 = r3.H(r4)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            float r4 = r4.G(r5)
            com.itextpdf.text.pdf.PdfContentByte r5 = r9.f26727a
            float r2 = r2 - r4
            float r3 = r3 - r0
            r5.H1(r4, r0, r2, r3)
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.N0()
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.x1()
            goto L_0x0927
        L_0x06e1:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.PdfContentByte r2 = r9.f26727a
            r0.w(r2)
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            com.itextpdf.text.pdf.PdfContentByte r4 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            float r2 = r5.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            float r3 = r5.H(r3)
            r4.w1(r2, r3)
            r2 = 1
        L_0x0711:
            if (r2 >= r0) goto L_0x0733
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r4 = r9.f26728b
            int r4 = r4.e()
            com.itextpdf.text.pdf.PdfContentByte r5 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            float r3 = r6.G(r3)
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            float r4 = r6.H(r4)
            r5.q1(r3, r4)
            int r2 = r2 + 1
            goto L_0x0711
        L_0x0733:
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            r0.v3()
            goto L_0x0927
        L_0x073a:
            r26 = r12
            r27 = r13
            r0 = 0
            r1 = 1
            boolean r2 = r9.c(r0)
            if (r2 == 0) goto L_0x0748
            goto L_0x0927
        L_0x0748:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            com.itextpdf.text.pdf.PdfContentByte r4 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            float r5 = r5.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            float r6 = r6.H(r3)
            r4.w1(r5, r6)
            r4 = 1
        L_0x076c:
            if (r4 >= r0) goto L_0x078e
            com.itextpdf.text.pdf.codec.wmf.InputMeta r5 = r9.f26728b
            int r5 = r5.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r6 = r9.f26728b
            int r6 = r6.e()
            com.itextpdf.text.pdf.PdfContentByte r7 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r8 = r9.f26734h
            float r5 = r8.G(r5)
            com.itextpdf.text.pdf.codec.wmf.MetaState r8 = r9.f26734h
            float r6 = r8.H(r6)
            r7.q1(r5, r6)
            int r4 = r4 + 1
            goto L_0x076c
        L_0x078e:
            com.itextpdf.text.pdf.PdfContentByte r0 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            float r2 = r4.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            float r3 = r4.H(r3)
            r0.q1(r2, r3)
            goto L_0x0648
        L_0x07a1:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaBrush r0 = new com.itextpdf.text.pdf.codec.wmf.MetaBrush
            r0.<init>()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            r0.e(r2)
        L_0x07b0:
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            r2.a(r0)
            goto L_0x0927
        L_0x07b7:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaFont r0 = new com.itextpdf.text.pdf.codec.wmf.MetaFont
            r0.<init>()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            r0.e(r2)
            goto L_0x07b0
        L_0x07c7:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaPen r0 = new com.itextpdf.text.pdf.codec.wmf.MetaPen
            r0.<init>()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            r0.e(r2)
            goto L_0x07b0
        L_0x07d7:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.Point r2 = new com.itextpdf.text.pdf.codec.wmf.Point
            com.itextpdf.text.pdf.codec.wmf.InputMeta r3 = r9.f26728b
            int r3 = r3.e()
            r2.<init>(r3, r0)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            r0.s(r2)
            goto L_0x0927
        L_0x07f4:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.Point r3 = r3.i()
            com.itextpdf.text.pdf.PdfContentByte r4 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            int r6 = r3.f26772a
            float r5 = r5.G(r6)
            com.itextpdf.text.pdf.codec.wmf.MetaState r6 = r9.f26734h
            int r3 = r3.f26773b
            float r3 = r6.H(r3)
            r4.w1(r5, r3)
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            com.itextpdf.text.pdf.codec.wmf.MetaState r4 = r9.f26734h
            float r4 = r4.G(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r5 = r9.f26734h
            float r5 = r5.H(r0)
            r3.q1(r4, r5)
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r3.v3()
            com.itextpdf.text.pdf.codec.wmf.MetaState r3 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.Point r4 = new com.itextpdf.text.pdf.codec.wmf.Point
            r4.<init>(r2, r0)
            r3.s(r4)
            goto L_0x0927
        L_0x0842:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            r0.v(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            r0.u(r2)
            goto L_0x0927
        L_0x085f:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            r0.A(r2)
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.e()
            r0.z(r2)
            goto L_0x0927
        L_0x087c:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            com.itextpdf.text.BaseColor r2 = r2.c()
            r0.t(r2)
            goto L_0x0927
        L_0x088e:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            com.itextpdf.text.BaseColor r2 = r2.c()
            r0.r(r2)
            goto L_0x0927
        L_0x08a0:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            r2.c(r0)
            goto L_0x0927
        L_0x08b2:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.f()
            r0.E(r2)
            goto L_0x0927
        L_0x08c3:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.f()
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r2.p(r0, r3)
            goto L_0x0927
        L_0x08d6:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r0 = r0.e()
            com.itextpdf.text.pdf.codec.wmf.MetaState r2 = r9.f26734h
            com.itextpdf.text.pdf.PdfContentByte r3 = r9.f26727a
            r2.n(r0, r3)
            goto L_0x0927
        L_0x08e9:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.f()
            r0.B(r2)
            goto L_0x0927
        L_0x08fa:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.InputMeta r2 = r9.f26728b
            int r2 = r2.f()
            r0.q(r2)
            goto L_0x0927
        L_0x090b:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.codec.wmf.MetaObject r2 = new com.itextpdf.text.pdf.codec.wmf.MetaObject
            r2.<init>()
            r0.a(r2)
            goto L_0x0927
        L_0x091b:
            r26 = r12
            r27 = r13
            r1 = 1
            com.itextpdf.text.pdf.codec.wmf.MetaState r0 = r9.f26734h
            com.itextpdf.text.pdf.PdfContentByte r2 = r9.f26727a
            r0.o(r2)
        L_0x0927:
            com.itextpdf.text.pdf.codec.wmf.InputMeta r0 = r9.f26728b
            int r13 = r27 * 2
            int r2 = r0.a()
            int r2 = r2 - r26
            int r13 = r13 - r2
            r0.g(r13)
            r10 = 0
            r11 = 1
            goto L_0x009b
        L_0x0939:
            com.itextpdf.text.DocumentException r0 = new com.itextpdf.text.DocumentException
            java.lang.String r1 = "not.a.placeable.windows.metafile"
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.wmf.MetaDo.e():void");
    }

    public void f() {
        MetaPen h2 = this.f26734h.h();
        MetaBrush f2 = this.f26734h.f();
        int d2 = h2.d();
        int d3 = f2.d();
        if (d2 == 5) {
            this.f26727a.e0();
            if (this.f26734h.l() == 1) {
                this.f26727a.O0();
            } else {
                this.f26727a.Q0();
            }
        } else if (d3 != 0 && (d3 != 2 || this.f26734h.d() != 2)) {
            this.f26727a.h0();
        } else if (this.f26734h.l() == 1) {
            this.f26727a.f0();
        } else {
            this.f26727a.g0();
        }
    }
}
