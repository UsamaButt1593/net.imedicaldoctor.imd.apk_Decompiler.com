package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgRaw;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfString;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class BmpImage {
    private static final int A = 7;
    private static final int B = 8;
    private static final int C = 9;
    private static final int D = 10;
    private static final int E = 11;
    private static final int F = 12;
    private static final int G = 13;
    private static final int H = 14;
    private static final int I = 15;
    private static final int J = 0;
    private static final int K = 1;
    private static final int L = 2;
    private static final int M = 0;
    private static final int N = 1;
    private static final int O = 2;
    private static final int P = 3;
    private static final int t = 0;
    private static final int u = 1;
    private static final int v = 2;
    private static final int w = 3;
    private static final int x = 4;
    private static final int y = 5;
    private static final int z = 6;

    /* renamed from: a  reason: collision with root package name */
    private InputStream f26541a;

    /* renamed from: b  reason: collision with root package name */
    private long f26542b;

    /* renamed from: c  reason: collision with root package name */
    private long f26543c;

    /* renamed from: d  reason: collision with root package name */
    private long f26544d;

    /* renamed from: e  reason: collision with root package name */
    private long f26545e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f26546f;

    /* renamed from: g  reason: collision with root package name */
    private int f26547g;

    /* renamed from: h  reason: collision with root package name */
    private int f26548h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f26549i;

    /* renamed from: j  reason: collision with root package name */
    private int f26550j;

    /* renamed from: k  reason: collision with root package name */
    private int f26551k;

    /* renamed from: l  reason: collision with root package name */
    private int f26552l;

    /* renamed from: m  reason: collision with root package name */
    private int f26553m;

    /* renamed from: n  reason: collision with root package name */
    private int f26554n;
    public HashMap<String, Object> o = new HashMap<>();
    private long p;
    private long q;
    int r;
    int s;

    BmpImage(InputStream inputStream, boolean z2, int i2) throws IOException {
        this.f26542b = (long) i2;
        this.f26543c = 0;
        l(inputStream, z2);
    }

    private int A(InputStream inputStream) throws IOException {
        return ((y(inputStream) << 8) | y(inputStream)) & 65535;
    }

    private int B(InputStream inputStream) throws IOException {
        return A(inputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009c, code lost:
        if ((r8 & 1) == 1) goto L_0x009e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(boolean r18, byte[] r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            int r2 = r0.r
            int r3 = r0.s
            int r2 = r2 * r3
            byte[] r2 = new byte[r2]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0011:
            int r8 = r0.s     // Catch:{ RuntimeException -> 0x00ca }
            if (r4 >= r8) goto L_0x00ca
            int r8 = r1.length     // Catch:{ RuntimeException -> 0x00ca }
            if (r5 >= r8) goto L_0x00ca
            int r8 = r5 + 1
            byte r9 = r1[r5]     // Catch:{ RuntimeException -> 0x00ca }
            r9 = r9 & 255(0xff, float:3.57E-43)
            r10 = 1
            if (r9 == 0) goto L_0x004e
            int r5 = r5 + 2
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00ca }
            r11 = r8 & 255(0xff, float:3.57E-43)
            if (r18 == 0) goto L_0x0035
            r8 = r9
        L_0x002a:
            if (r8 == 0) goto L_0x004c
            int r10 = r7 + 1
            byte r12 = (byte) r11     // Catch:{ RuntimeException -> 0x00ca }
            r2[r7] = r12     // Catch:{ RuntimeException -> 0x00ca }
            int r8 = r8 + -1
            r7 = r10
            goto L_0x002a
        L_0x0035:
            r12 = 0
        L_0x0036:
            if (r12 >= r9) goto L_0x004c
            int r13 = r7 + 1
            r14 = r12 & 1
            if (r14 != r10) goto L_0x0041
            r14 = r8 & 15
            goto L_0x0045
        L_0x0041:
            int r14 = r11 >>> 4
            r14 = r14 & 15
        L_0x0045:
            byte r14 = (byte) r14     // Catch:{ RuntimeException -> 0x00ca }
            r2[r7] = r14     // Catch:{ RuntimeException -> 0x00ca }
            int r12 = r12 + 1
            r7 = r13
            goto L_0x0036
        L_0x004c:
            int r6 = r6 + r9
            goto L_0x0011
        L_0x004e:
            int r9 = r5 + 2
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00ca }
            r11 = r8 & 255(0xff, float:3.57E-43)
            if (r11 != r10) goto L_0x0058
            goto L_0x00ca
        L_0x0058:
            if (r11 == 0) goto L_0x00bf
            r12 = 2
            if (r11 == r12) goto L_0x00aa
            if (r18 == 0) goto L_0x0072
            r5 = r11
        L_0x0060:
            if (r5 == 0) goto L_0x0097
            int r13 = r7 + 1
            int r14 = r9 + 1
            byte r9 = r1[r9]     // Catch:{ RuntimeException -> 0x00ca }
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9     // Catch:{ RuntimeException -> 0x00ca }
            r2[r7] = r9     // Catch:{ RuntimeException -> 0x00ca }
            int r5 = r5 + -1
            r7 = r13
            r9 = r14
            goto L_0x0060
        L_0x0072:
            r5 = 0
            r13 = 0
        L_0x0074:
            if (r5 >= r11) goto L_0x0097
            r14 = r5 & 1
            if (r14 != 0) goto L_0x0085
            int r13 = r9 + 1
            byte r9 = r1[r9]     // Catch:{ RuntimeException -> 0x00ca }
            r9 = r9 & 255(0xff, float:3.57E-43)
            r16 = r13
            r13 = r9
            r9 = r16
        L_0x0085:
            int r15 = r7 + 1
            if (r14 != r10) goto L_0x008c
            r14 = r13 & 15
            goto L_0x0090
        L_0x008c:
            int r14 = r13 >>> 4
            r14 = r14 & 15
        L_0x0090:
            byte r14 = (byte) r14     // Catch:{ RuntimeException -> 0x00ca }
            r2[r7] = r14     // Catch:{ RuntimeException -> 0x00ca }
            int r5 = r5 + 1
            r7 = r15
            goto L_0x0074
        L_0x0097:
            int r6 = r6 + r11
            if (r18 == 0) goto L_0x00a3
            r5 = r8 & 1
            if (r5 != r10) goto L_0x00a0
        L_0x009e:
            int r9 = r9 + 1
        L_0x00a0:
            r5 = r9
            goto L_0x0011
        L_0x00a3:
            r5 = r8 & 3
            if (r5 == r10) goto L_0x009e
            if (r5 != r12) goto L_0x00a0
            goto L_0x009e
        L_0x00aa:
            int r7 = r5 + 3
            byte r8 = r1[r9]     // Catch:{ RuntimeException -> 0x00ca }
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r6 = r6 + r8
            int r5 = r5 + 4
            byte r7 = r1[r7]     // Catch:{ RuntimeException -> 0x00ca }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r7
            int r7 = r0.r     // Catch:{ RuntimeException -> 0x00ca }
            int r7 = r7 * r4
            int r7 = r7 + r6
            goto L_0x0011
        L_0x00bf:
            int r4 = r4 + 1
            int r5 = r0.r     // Catch:{ RuntimeException -> 0x00ca }
            int r5 = r5 * r4
            r7 = r5
            r5 = r9
            r6 = 0
            goto L_0x0011
        L_0x00ca:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.a(boolean, byte[]):byte[]");
    }

    private int b(int i2) {
        for (int i3 = 0; i3 < 32 && (i2 & 1) != 1; i3++) {
            i2 >>>= 1;
        }
        return i2;
    }

    private int c(int i2) {
        int i3 = 0;
        while (i3 < 32 && (i2 & 1) != 1) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    private Image d() throws IOException, BadElementException {
        switch (this.f26547g) {
            case 0:
                return n(3);
            case 1:
                return p(3);
            case 2:
                return q(3);
            case 3:
                byte[] bArr = new byte[(this.r * this.s * 3)];
                o(bArr);
                return new ImgRaw(this.r, this.s, 3, 8, bArr);
            case 4:
                return n(4);
            case 5:
                int i2 = (int) this.f26544d;
                if (i2 == 0) {
                    return p(4);
                }
                if (i2 == 2) {
                    return v();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 6:
                int i3 = (int) this.f26544d;
                if (i3 == 0) {
                    return q(4);
                }
                if (i3 == 1) {
                    return w();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 7:
                byte[] bArr2 = new byte[(this.r * this.s * 3)];
                o(bArr2);
                return new ImgRaw(this.r, this.s, 3, 8, bArr2);
            case 8:
                return m(false);
            case 9:
                return m(true);
            case 10:
                return n(4);
            case 11:
                int i4 = (int) this.f26544d;
                if (i4 == 0) {
                    return p(4);
                }
                if (i4 == 2) {
                    return v();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 12:
                int i5 = (int) this.f26544d;
                if (i5 == 0) {
                    return q(4);
                }
                if (i5 == 1) {
                    return w();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 13:
                return m(false);
            case 14:
                byte[] bArr3 = new byte[(this.r * this.s * 3)];
                o(bArr3);
                return new ImgRaw(this.r, this.s, 3, 8, bArr3);
            case 15:
                return m(true);
            default:
                return null;
        }
    }

    public static Image e(InputStream inputStream) throws IOException {
        return f(inputStream, false, 0);
    }

    public static Image f(InputStream inputStream, boolean z2, int i2) throws IOException {
        BmpImage bmpImage = new BmpImage(inputStream, z2, i2);
        try {
            Image d2 = bmpImage.d();
            d2.d2((int) ((((double) bmpImage.p) * 0.0254d) + 0.5d), (int) ((((double) bmpImage.q) * 0.0254d) + 0.5d));
            d2.k2(4);
            return d2;
        } catch (BadElementException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static Image g(String str) throws IOException {
        return h(Utilities.w(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image h(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = r2.openStream()     // Catch:{ all -> 0x0013 }
            com.itextpdf.text.Image r1 = e(r0)     // Catch:{ all -> 0x0011 }
            r1.s2(r2)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0010
            r0.close()
        L_0x0010:
            return r1
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.h(java.net.URL):com.itextpdf.text.Image");
    }

    public static Image i(byte[] bArr) throws IOException {
        Image e2 = e(new ByteArrayInputStream(bArr));
        e2.j2(bArr);
        return e2;
    }

    private byte[] j(int i2) {
        byte[] bArr = this.f26546f;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[((bArr.length / i2) * 3)];
        int length = bArr.length / i2;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * i2;
            int i5 = i3 * 3;
            byte[] bArr3 = this.f26546f;
            bArr2[i5 + 2] = bArr3[i4];
            bArr2[i5 + 1] = bArr3[i4 + 1];
            bArr2[i5] = bArr3[i4 + 2];
        }
        return bArr2;
    }

    private Image k(byte[] bArr, int i2, int i3) throws BadElementException {
        ImgRaw imgRaw = new ImgRaw(this.r, this.s, 1, i2, bArr);
        PdfArray pdfArray = new PdfArray();
        pdfArray.a0(PdfName.N9);
        pdfArray.a0(PdfName.B6);
        byte[] j2 = j(i3);
        pdfArray.a0(new PdfNumber((j2.length / 3) - 1));
        pdfArray.a0(new PdfString(j2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.w5, pdfArray);
        imgRaw.W1(pdfDictionary);
        return imgRaw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.itextpdf.text.Image m(boolean r22) throws java.io.IOException, com.itextpdf.text.BadElementException {
        /*
            r21 = this;
            r0 = r21
            int r1 = r0.f26551k
            int r1 = r0.b(r1)
            int r2 = r0.f26551k
            int r2 = r0.c(r2)
            int r3 = r1 + 1
            int r4 = r0.f26552l
            int r4 = r0.b(r4)
            int r5 = r0.f26552l
            int r5 = r0.c(r5)
            int r6 = r4 + 1
            int r7 = r0.f26553m
            int r7 = r0.b(r7)
            int r8 = r0.f26553m
            int r8 = r0.c(r8)
            int r9 = r7 + 1
            int r10 = r0.r
            int r11 = r0.s
            int r11 = r11 * r10
            int r11 = r11 * 3
            byte[] r11 = new byte[r11]
            if (r22 != 0) goto L_0x004f
            int r10 = r10 * 16
            int r13 = r10 % 32
            if (r13 == 0) goto L_0x004f
            int r13 = r10 / 32
            int r13 = r13 + 1
            int r13 = r13 * 32
            int r13 = r13 - r10
            double r13 = (double) r13
            r15 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r13 = r13 / r15
            double r13 = java.lang.Math.ceil(r13)
            int r10 = (int) r13
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            boolean r13 = r0.f26549i
            if (r13 == 0) goto L_0x00c1
            int r13 = r0.s
            int r13 = r13 + -1
        L_0x0058:
            if (r13 < 0) goto L_0x0119
            int r14 = r0.r
            int r14 = r14 * 3
            int r14 = r14 * r13
            r15 = 0
        L_0x0061:
            int r12 = r0.r
            if (r15 >= r12) goto L_0x00a9
            if (r22 == 0) goto L_0x0071
            java.io.InputStream r12 = r0.f26541a
            r17 = r13
            long r12 = r0.r(r12)
            int r13 = (int) r12
            goto L_0x0079
        L_0x0071:
            r17 = r13
            java.io.InputStream r12 = r0.f26541a
            int r13 = r0.B(r12)
        L_0x0079:
            int r12 = r14 + 1
            int r18 = r13 >>> r2
            r19 = r2
            r2 = r18 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r14] = r2
            int r2 = r14 + 2
            int r18 = r13 >>> r5
            r20 = r5
            r5 = r18 & r4
            int r5 = r5 * 256
            int r5 = r5 / r6
            byte r5 = (byte) r5
            r11[r12] = r5
            int r14 = r14 + 3
            int r5 = r13 >>> r8
            r5 = r5 & r7
            int r5 = r5 * 256
            int r5 = r5 / r9
            byte r5 = (byte) r5
            r11[r2] = r5
            int r15 = r15 + 1
            r13 = r17
            r2 = r19
            r5 = r20
            goto L_0x0061
        L_0x00a9:
            r19 = r2
            r20 = r5
            r17 = r13
            r2 = 0
        L_0x00b0:
            if (r2 >= r10) goto L_0x00ba
            java.io.InputStream r5 = r0.f26541a
            r5.read()
            int r2 = r2 + 1
            goto L_0x00b0
        L_0x00ba:
            int r13 = r17 + -1
            r2 = r19
            r5 = r20
            goto L_0x0058
        L_0x00c1:
            r19 = r2
            r20 = r5
            r2 = 0
            r5 = 0
        L_0x00c7:
            int r12 = r0.s
            if (r2 >= r12) goto L_0x0119
            r12 = 0
        L_0x00cc:
            int r13 = r0.r
            if (r12 >= r13) goto L_0x0107
            java.io.InputStream r13 = r0.f26541a
            if (r22 == 0) goto L_0x00da
            long r13 = r0.r(r13)
            int r14 = (int) r13
            goto L_0x00de
        L_0x00da:
            int r14 = r0.B(r13)
        L_0x00de:
            int r13 = r5 + 1
            int r15 = r14 >>> r19
            r15 = r15 & r1
            int r15 = r15 * 256
            int r15 = r15 / r3
            byte r15 = (byte) r15
            r11[r5] = r15
            int r15 = r5 + 2
            int r17 = r14 >>> r20
            r18 = r1
            r1 = r17 & r4
            int r1 = r1 * 256
            int r1 = r1 / r6
            byte r1 = (byte) r1
            r11[r13] = r1
            int r5 = r5 + 3
            int r1 = r14 >>> r8
            r1 = r1 & r7
            int r1 = r1 * 256
            int r1 = r1 / r9
            byte r1 = (byte) r1
            r11[r15] = r1
            int r12 = r12 + 1
            r1 = r18
            goto L_0x00cc
        L_0x0107:
            r18 = r1
            r1 = 0
        L_0x010a:
            if (r1 >= r10) goto L_0x0114
            java.io.InputStream r12 = r0.f26541a
            r12.read()
            int r1 = r1 + 1
            goto L_0x010a
        L_0x0114:
            int r2 = r2 + 1
            r1 = r18
            goto L_0x00c7
        L_0x0119:
            com.itextpdf.text.ImgRaw r1 = new com.itextpdf.text.ImgRaw
            int r13 = r0.r
            int r14 = r0.s
            r15 = 3
            r16 = 8
            r12 = r1
            r17 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.m(boolean):com.itextpdf.text.Image");
    }

    private Image n(int i2) throws IOException, BadElementException {
        int i3 = this.r;
        byte[] bArr = new byte[(((i3 + 7) / 8) * this.s)];
        int ceil = (int) Math.ceil(((double) i3) / 8.0d);
        int i4 = ceil % 4;
        int i5 = 0;
        int i6 = (i4 != 0 ? 4 - i4 : 0) + ceil;
        int i7 = this.s * i6;
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            i8 += this.f26541a.read(bArr2, i8, i7 - i8);
        }
        if (this.f26549i) {
            while (i5 < this.s) {
                int i9 = i5 + 1;
                System.arraycopy(bArr2, i7 - (i9 * i6), bArr, i5 * ceil, ceil);
                i5 = i9;
            }
        } else {
            while (i5 < this.s) {
                System.arraycopy(bArr2, i5 * i6, bArr, i5 * ceil, ceil);
                i5++;
            }
        }
        return k(bArr, 1, i2);
    }

    private void o(byte[] bArr) {
        int i2 = this.r * 24;
        int ceil = i2 % 32 != 0 ? (int) Math.ceil(((double) ((((i2 / 32) + 1) * 32) - i2)) / 8.0d) : 0;
        int i3 = (((this.r * 3) + 3) / 4) * 4 * this.s;
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            try {
                int read = this.f26541a.read(bArr2, i4, i3 - i4);
                if (read < 0) {
                    break;
                }
                i4 += read;
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        }
        if (this.f26549i) {
            int i5 = ((this.r * this.s) * 3) - 1;
            int i6 = -ceil;
            int i7 = 0;
            while (i7 < this.s) {
                i7++;
                int i8 = (i5 - ((this.r * i7) * 3)) + 1;
                i6 += ceil;
                for (int i9 = 0; i9 < this.r; i9++) {
                    bArr[i8 + 2] = bArr2[i6];
                    int i10 = i6 + 2;
                    bArr[i8 + 1] = bArr2[i6 + 1];
                    i6 += 3;
                    bArr[i8] = bArr2[i10];
                    i8 += 3;
                }
            }
            return;
        }
        int i11 = -ceil;
        int i12 = 0;
        for (int i13 = 0; i13 < this.s; i13++) {
            i11 += ceil;
            for (int i14 = 0; i14 < this.r; i14++) {
                bArr[i12 + 2] = bArr2[i11];
                int i15 = i11 + 2;
                bArr[i12 + 1] = bArr2[i11 + 1];
                i11 += 3;
                bArr[i12] = bArr2[i15];
                i12 += 3;
            }
        }
    }

    private Image p(int i2) throws IOException, BadElementException {
        int i3 = this.r;
        byte[] bArr = new byte[(((i3 + 1) / 2) * this.s)];
        int ceil = (int) Math.ceil(((double) i3) / 2.0d);
        int i4 = ceil % 4;
        int i5 = 0;
        int i6 = (i4 != 0 ? 4 - i4 : 0) + ceil;
        int i7 = this.s * i6;
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        while (i8 < i7) {
            i8 += this.f26541a.read(bArr2, i8, i7 - i8);
        }
        if (this.f26549i) {
            while (i5 < this.s) {
                int i9 = i5 + 1;
                System.arraycopy(bArr2, i7 - (i9 * i6), bArr, i5 * ceil, ceil);
                i5 = i9;
            }
        } else {
            while (i5 < this.s) {
                System.arraycopy(bArr2, i5 * i6, bArr, i5 * ceil, ceil);
                i5++;
            }
        }
        return k(bArr, 4, i2);
    }

    private Image q(int i2) throws IOException, BadElementException {
        int i3 = this.r;
        byte[] bArr = new byte[(this.s * i3)];
        int i4 = i3 * 8;
        int i5 = 0;
        int ceil = i4 % 32 != 0 ? (int) Math.ceil(((double) ((((i4 / 32) + 1) * 32) - i4)) / 8.0d) : 0;
        int i6 = (this.r + ceil) * this.s;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.f26541a.read(bArr2, i7, i6 - i7);
        }
        if (this.f26549i) {
            while (i5 < this.s) {
                int i8 = i5 + 1;
                int i9 = this.r;
                System.arraycopy(bArr2, i6 - ((i9 + ceil) * i8), bArr, i5 * i9, i9);
                i5 = i8;
            }
        } else {
            while (i5 < this.s) {
                int i10 = this.r;
                System.arraycopy(bArr2, (i10 + ceil) * i5, bArr, i5 * i10, i10);
                i5++;
            }
        }
        return k(bArr, 8, i2);
    }

    private long r(InputStream inputStream) throws IOException {
        return z(inputStream);
    }

    private int s(InputStream inputStream) throws IOException {
        int y2 = y(inputStream);
        int y3 = y(inputStream);
        return (y(inputStream) << 24) | (y(inputStream) << 16) | (y3 << 8) | y2;
    }

    private int t(InputStream inputStream) throws IOException {
        return s(inputStream);
    }

    private void u(int i2) throws IOException {
        if (i2 != 0) {
            this.f26546f = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int read = this.f26541a.read(this.f26546f, i3, i2 - i3);
                if (read >= 0) {
                    i3 += read;
                } else {
                    throw new RuntimeException(MessageLocalization.b("incomplete.palette", new Object[0]));
                }
            }
            this.o.put("palette", this.f26546f);
        }
    }

    private Image v() throws IOException, BadElementException {
        int i2 = (int) this.f26545e;
        if (i2 == 0) {
            i2 = (int) (this.f26542b - this.f26543c);
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            i3 += this.f26541a.read(bArr, i3, i2 - i3);
        }
        byte[] a2 = a(false, bArr);
        if (this.f26549i) {
            int i4 = this.r;
            int i5 = this.s;
            byte[] bArr2 = new byte[(i4 * i5)];
            int i6 = 0;
            for (int i7 = i5 - 1; i7 >= 0; i7--) {
                int i8 = this.r;
                int i9 = i7 * i8;
                int i10 = i8 + i6;
                while (i6 != i10) {
                    bArr2[i6] = a2[i9];
                    i6++;
                    i9++;
                }
            }
            a2 = bArr2;
        }
        int i11 = (this.r + 1) / 2;
        byte[] bArr3 = new byte[(this.s * i11)];
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < this.s; i14++) {
            for (int i15 = 0; i15 < this.r; i15++) {
                if ((i15 & 1) == 0) {
                    bArr3[(i15 / 2) + i13] = (byte) (a2[i12] << 4);
                    i12++;
                } else {
                    int i16 = (i15 / 2) + i13;
                    bArr3[i16] = (byte) (((byte) (a2[i12] & 15)) | bArr3[i16]);
                    i12++;
                }
            }
            i13 += i11;
        }
        return k(bArr3, 4, 4);
    }

    private Image w() throws IOException, BadElementException {
        int i2 = (int) this.f26545e;
        if (i2 == 0) {
            i2 = (int) (this.f26542b - this.f26543c);
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            i4 += this.f26541a.read(bArr, i4, i2 - i4);
        }
        byte[] a2 = a(true, bArr);
        int i5 = this.r;
        int i6 = this.s * i5;
        if (this.f26549i) {
            byte[] bArr2 = new byte[a2.length];
            while (i3 < this.s) {
                int i7 = i3 + 1;
                System.arraycopy(a2, i6 - (i7 * i5), bArr2, i3 * i5, i5);
                i3 = i7;
            }
            a2 = bArr2;
        }
        return k(a2, 8, 4);
    }

    private int x(InputStream inputStream) throws IOException {
        return (y(inputStream) << 8) | y(inputStream);
    }

    private int y(InputStream inputStream) throws IOException {
        return inputStream.read() & 255;
    }

    private long z(InputStream inputStream) throws IOException {
        int y2 = y(inputStream);
        int y3 = y(inputStream);
        return (long) ((y(inputStream) << 24) | (y(inputStream) << 16) | (y3 << 8) | y2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02d9, code lost:
        r1 = r1 * 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02e5, code lost:
        r1 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02f1, code lost:
        r0.f26543c = r2 + ((long) r1);
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void l(java.io.InputStream r33, boolean r34) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            if (r34 != 0) goto L_0x0013
            boolean r2 = r1 instanceof java.io.BufferedInputStream
            if (r2 == 0) goto L_0x000b
            goto L_0x0013
        L_0x000b:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream
            r2.<init>(r1)
            r0.f26541a = r2
            goto L_0x0015
        L_0x0013:
            r0.f26541a = r1
        L_0x0015:
            r1 = 0
            if (r34 != 0) goto L_0x0055
            java.io.InputStream r2 = r0.f26541a
            int r2 = r0.y(r2)
            r3 = 66
            if (r2 != r3) goto L_0x0047
            java.io.InputStream r2 = r0.f26541a
            int r2 = r0.y(r2)
            r3 = 77
            if (r2 != r3) goto L_0x0047
            java.io.InputStream r2 = r0.f26541a
            long r2 = r0.r(r2)
            r0.f26542b = r2
            java.io.InputStream r2 = r0.f26541a
            r0.B(r2)
            java.io.InputStream r2 = r0.f26541a
            r0.B(r2)
            java.io.InputStream r2 = r0.f26541a
            long r2 = r0.r(r2)
            r0.f26543c = r2
            goto L_0x0055
        L_0x0047:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "invalid.magic.value.for.bmp.file"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r1)
            r2.<init>(r1)
            throw r2
        L_0x0055:
            java.io.InputStream r2 = r0.f26541a
            long r2 = r0.r(r2)
            r4 = 12
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            java.io.InputStream r4 = r0.f26541a
            if (r6 != 0) goto L_0x0072
            int r4 = r0.B(r4)
            r0.r = r4
            java.io.InputStream r4 = r0.f26541a
            int r4 = r0.B(r4)
        L_0x006f:
            r0.s = r4
            goto L_0x007f
        L_0x0072:
            int r4 = r0.t(r4)
            r0.r = r4
            java.io.InputStream r4 = r0.f26541a
            int r4 = r0.t(r4)
            goto L_0x006f
        L_0x007f:
            java.io.InputStream r4 = r0.f26541a
            int r4 = r0.B(r4)
            java.io.InputStream r5 = r0.f26541a
            int r5 = r0.B(r5)
            r0.f26550j = r5
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.o
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "color_planes"
            r5.put(r7, r4)
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.o
            int r5 = r0.f26550j
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r7 = "bits_per_pixel"
            r4.put(r7, r5)
            r4 = 3
            r0.f26548h = r4
            long r7 = r0.f26543c
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x00b2
            r0.f26543c = r2
        L_0x00b2:
            r7 = 14
            r11 = 24
            java.lang.String r14 = "bmp_version"
            r15 = 8
            r5 = 2
            r9 = 1
            r10 = 4
            if (r6 != 0) goto L_0x010a
            java.util.HashMap<java.lang.String, java.lang.Object> r6 = r0.o
            java.lang.String r12 = "BMP v. 2.x"
            r6.put(r14, r12)
            int r6 = r0.f26550j
            if (r6 != r9) goto L_0x00cd
            r0.f26547g = r1
            goto L_0x00db
        L_0x00cd:
            if (r6 != r10) goto L_0x00d2
            r0.f26547g = r9
            goto L_0x00db
        L_0x00d2:
            if (r6 != r15) goto L_0x00d7
            r0.f26547g = r5
            goto L_0x00db
        L_0x00d7:
            if (r6 != r11) goto L_0x00db
            r0.f26547g = r4
        L_0x00db:
            long r11 = r0.f26543c
            long r6 = r11 - r7
            long r6 = r6 - r2
            r16 = 3
            long r6 = r6 / r16
            int r7 = (int) r6
            int r7 = r7 * 3
            int r6 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0105
            int r6 = r0.f26547g
            if (r6 == 0) goto L_0x00ff
            if (r6 == r9) goto L_0x00fc
            if (r6 == r5) goto L_0x00f9
            if (r6 == r4) goto L_0x00f7
            r6 = r7
            goto L_0x0100
        L_0x00f7:
            r6 = 0
            goto L_0x0100
        L_0x00f9:
            r6 = 768(0x300, float:1.076E-42)
            goto L_0x0100
        L_0x00fc:
            r6 = 48
            goto L_0x0100
        L_0x00ff:
            r6 = 6
        L_0x0100:
            long r7 = (long) r6
            long r2 = r2 + r7
            r0.f26543c = r2
            r7 = r6
        L_0x0105:
            r0.u(r7)
            goto L_0x0553
        L_0x010a:
            java.io.InputStream r6 = r0.f26541a
            long r7 = r0.r(r6)
            r0.f26544d = r7
            java.io.InputStream r6 = r0.f26541a
            long r6 = r0.r(r6)
            r0.f26545e = r6
            java.io.InputStream r6 = r0.f26541a
            int r6 = r0.t(r6)
            long r6 = (long) r6
            r0.p = r6
            java.io.InputStream r6 = r0.f26541a
            int r6 = r0.t(r6)
            long r6 = (long) r6
            r0.q = r6
            java.io.InputStream r6 = r0.f26541a
            long r6 = r0.r(r6)
            java.io.InputStream r8 = r0.f26541a
            long r20 = r0.r(r8)
            long r11 = r0.f26544d
            int r12 = (int) r11
            java.lang.String r11 = "compression"
            if (r12 == 0) goto L_0x015b
            if (r12 == r9) goto L_0x0156
            if (r12 == r5) goto L_0x014e
            if (r12 == r4) goto L_0x0146
            goto L_0x0160
        L_0x0146:
            java.util.HashMap<java.lang.String, java.lang.Object> r12 = r0.o
            java.lang.String r8 = "BI_BITFIELDS"
            r12.put(r11, r8)
            goto L_0x0160
        L_0x014e:
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            java.lang.String r12 = "BI_RLE4"
        L_0x0152:
            r8.put(r11, r12)
            goto L_0x0160
        L_0x0156:
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            java.lang.String r12 = "BI_RLE8"
            goto L_0x0152
        L_0x015b:
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            java.lang.String r12 = "BI_RGB"
            goto L_0x0152
        L_0x0160:
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            long r11 = r0.p
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            java.lang.String r12 = "x_pixels_per_meter"
            r8.put(r12, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            long r11 = r0.q
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            java.lang.String r12 = "y_pixels_per_meter"
            r8.put(r12, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            java.lang.Long r11 = java.lang.Long.valueOf(r6)
            java.lang.String r12 = "colors_used"
            r8.put(r12, r11)
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            java.lang.Long r11 = java.lang.Long.valueOf(r20)
            java.lang.String r12 = "colors_important"
            r8.put(r12, r11)
            r11 = 40
            r20 = 52
            java.lang.String r8 = "alpha_mask"
            r22 = 56
            java.lang.String r1 = "blue_mask"
            java.lang.String r4 = "green_mask"
            java.lang.String r5 = "red_mask"
            int r24 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r24 == 0) goto L_0x01aa
            int r11 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r11 == 0) goto L_0x01aa
            int r11 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r11 != 0) goto L_0x01ad
        L_0x01aa:
            r9 = r8
            goto L_0x03bf
        L_0x01ad:
            r11 = 108(0x6c, double:5.34E-322)
            int r20 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r20 != 0) goto L_0x03b0
            java.util.HashMap<java.lang.String, java.lang.Object> r11 = r0.o
            java.lang.String r12 = "BMP v. 4.x"
            r11.put(r14, r12)
            java.io.InputStream r11 = r0.f26541a
            long r11 = r0.r(r11)
            int r12 = (int) r11
            r0.f26551k = r12
            java.io.InputStream r11 = r0.f26541a
            long r11 = r0.r(r11)
            int r12 = (int) r11
            r0.f26552l = r12
            java.io.InputStream r11 = r0.f26541a
            long r11 = r0.r(r11)
            int r12 = (int) r11
            r0.f26553m = r12
            java.io.InputStream r11 = r0.f26541a
            long r11 = r0.r(r11)
            int r12 = (int) r11
            r0.f26554n = r12
            java.io.InputStream r11 = r0.f26541a
            long r11 = r0.r(r11)
            java.io.InputStream r14 = r0.f26541a
            int r14 = r0.t(r14)
            java.io.InputStream r13 = r0.f26541a
            int r13 = r0.t(r13)
            java.io.InputStream r15 = r0.f26541a
            int r15 = r0.t(r15)
            java.io.InputStream r10 = r0.f26541a
            int r10 = r0.t(r10)
            java.io.InputStream r9 = r0.f26541a
            int r9 = r0.t(r9)
            r33 = r9
            java.io.InputStream r9 = r0.f26541a
            int r9 = r0.t(r9)
            r20 = r9
            java.io.InputStream r9 = r0.f26541a
            int r9 = r0.t(r9)
            r21 = r9
            java.io.InputStream r9 = r0.f26541a
            int r9 = r0.t(r9)
            r22 = r9
            java.io.InputStream r9 = r0.f26541a
            int r9 = r0.t(r9)
            r23 = r9
            java.io.InputStream r9 = r0.f26541a
            long r25 = r0.r(r9)
            java.io.InputStream r9 = r0.f26541a
            long r27 = r0.r(r9)
            java.io.InputStream r9 = r0.f26541a
            long r29 = r0.r(r9)
            int r9 = r0.f26550j
            r31 = r10
            r10 = 1
            if (r9 != r10) goto L_0x0242
            r9 = 10
        L_0x023f:
            r0.f26547g = r9
            goto L_0x0289
        L_0x0242:
            r10 = 4
            if (r9 != r10) goto L_0x0248
            r9 = 11
            goto L_0x023f
        L_0x0248:
            r10 = 8
            if (r9 != r10) goto L_0x024f
            r9 = 12
            goto L_0x023f
        L_0x024f:
            r10 = 16
            if (r9 != r10) goto L_0x0269
            r9 = 13
            r0.f26547g = r9
            long r9 = r0.f26544d
            int r10 = (int) r9
            if (r10 != 0) goto L_0x0289
            r9 = 31744(0x7c00, float:4.4483E-41)
            r0.f26551k = r9
            r9 = 992(0x3e0, float:1.39E-42)
            r0.f26552l = r9
            r9 = 31
        L_0x0266:
            r0.f26553m = r9
            goto L_0x0289
        L_0x0269:
            r10 = 24
            if (r9 != r10) goto L_0x0270
            r9 = 14
            goto L_0x023f
        L_0x0270:
            r10 = 32
            if (r9 != r10) goto L_0x0289
            r9 = 15
            r0.f26547g = r9
            long r9 = r0.f26544d
            int r10 = (int) r9
            if (r10 != 0) goto L_0x0289
            r9 = 16711680(0xff0000, float:2.3418052E-38)
            r0.f26551k = r9
            r9 = 65280(0xff00, float:9.1477E-41)
            r0.f26552l = r9
            r9 = 255(0xff, float:3.57E-43)
            goto L_0x0266
        L_0x0289:
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r0.o
            int r10 = r0.f26551k
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r9.put(r5, r10)
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.o
            int r9 = r0.f26552l
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r5.put(r4, r9)
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.o
            int r5 = r0.f26553m
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r1, r5)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            int r4 = r0.f26554n
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.put(r8, r4)
            long r4 = r0.f26543c
            r8 = 14
            long r8 = r4 - r8
            long r8 = r8 - r2
            r18 = 4
            long r8 = r8 / r18
            int r1 = (int) r8
            r8 = 4
            int r1 = r1 * 4
            int r8 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r8 != 0) goto L_0x02f5
            int r1 = r0.f26547g
            switch(r1) {
                case 10: goto L_0x02e7;
                case 11: goto L_0x02dc;
                case 12: goto L_0x02cf;
                default: goto L_0x02cd;
            }
        L_0x02cd:
            r1 = 0
            goto L_0x02f1
        L_0x02cf:
            r4 = 0
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x02d7
            r6 = 256(0x100, double:1.265E-321)
        L_0x02d7:
            int r1 = (int) r6
            r8 = 4
        L_0x02d9:
            int r1 = r1 * 4
            goto L_0x02f1
        L_0x02dc:
            r4 = 0
            r8 = 4
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x02e5
            r6 = 16
        L_0x02e5:
            int r1 = (int) r6
            goto L_0x02d9
        L_0x02e7:
            r4 = 0
            r8 = 4
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x02e5
            r6 = 2
            goto L_0x02e5
        L_0x02f1:
            long r4 = (long) r1
            long r2 = r2 + r4
            r0.f26543c = r2
        L_0x02f5:
            r0.u(r1)
            int r1 = (int) r11
            java.lang.String r2 = "color_space"
            if (r1 == 0) goto L_0x031d
            r3 = 1
            if (r1 == r3) goto L_0x0314
            r3 = 2
            if (r1 == r3) goto L_0x0305
            goto L_0x0553
        L_0x0305:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.String r3 = "LCS_CMYK"
            r1.put(r2, r3)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x0314:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.String r3 = "LCS_sRGB"
            r1.put(r2, r3)
            goto L_0x0553
        L_0x031d:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.String r3 = "LCS_CALIBRATED_RGB"
            r1.put(r2, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            java.lang.String r3 = "redX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            java.lang.String r3 = "redY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            java.lang.String r3 = "redZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r31)
            java.lang.String r3 = "greenX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r33)
            java.lang.String r3 = "greenY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            java.lang.String r3 = "greenZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r21)
            java.lang.String r3 = "blueX"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r22)
            java.lang.String r3 = "blueY"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Integer r2 = java.lang.Integer.valueOf(r23)
            java.lang.String r3 = "blueZ"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Long r2 = java.lang.Long.valueOf(r25)
            java.lang.String r3 = "gamma_red"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Long r2 = java.lang.Long.valueOf(r27)
            java.lang.String r3 = "gamma_green"
            r1.put(r3, r2)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.Long r2 = java.lang.Long.valueOf(r29)
            java.lang.String r3 = "gamma_blue"
            r1.put(r3, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x03b0:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.String r2 = "BMP v. 5.x"
            r1.put(r14, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "BMP version 5 not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x03bf:
            long r10 = r0.f26544d
            int r11 = (int) r10
            if (r11 == 0) goto L_0x0450
            r10 = 1
            if (r11 == r10) goto L_0x0450
            r10 = 2
            if (r11 == r10) goto L_0x0450
            r10 = 3
            if (r11 != r10) goto L_0x0448
            int r8 = r0.f26550j
            r10 = 16
            if (r8 != r10) goto L_0x03d8
            r10 = 8
            r0.f26547g = r10
            goto L_0x03e0
        L_0x03d8:
            r10 = 32
            if (r8 != r10) goto L_0x03e0
            r8 = 9
            r0.f26547g = r8
        L_0x03e0:
            java.io.InputStream r8 = r0.f26541a
            long r10 = r0.r(r8)
            int r8 = (int) r10
            r0.f26551k = r8
            java.io.InputStream r8 = r0.f26541a
            long r10 = r0.r(r8)
            int r8 = (int) r10
            r0.f26552l = r8
            java.io.InputStream r8 = r0.f26541a
            long r10 = r0.r(r8)
            int r8 = (int) r10
            r0.f26553m = r8
            int r8 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r8 != 0) goto L_0x0411
            java.io.InputStream r2 = r0.f26541a
            long r2 = r0.r(r2)
            int r3 = (int) r2
            r0.f26554n = r3
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.o
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r9, r3)
        L_0x0411:
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.o
            int r3 = r0.f26551k
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r5, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.o
            int r3 = r0.f26552l
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r3)
            java.util.HashMap<java.lang.String, java.lang.Object> r2 = r0.o
            int r3 = r0.f26553m
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.put(r1, r3)
            r1 = 0
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x043f
            int r1 = (int) r6
            r2 = 4
            int r1 = r1 * 4
            r0.u(r1)
        L_0x043f:
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.String r2 = "BMP v. 3.x NT"
        L_0x0443:
            r1.put(r14, r2)
            goto L_0x0553
        L_0x0448:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Invalid compression specified in BMP file."
            r1.<init>(r2)
            throw r1
        L_0x0450:
            int r10 = r0.f26550j
            r11 = 1
            if (r10 != r11) goto L_0x0459
            r11 = 4
            r0.f26547g = r11
            goto L_0x04b4
        L_0x0459:
            r11 = 4
            if (r10 != r11) goto L_0x0460
            r8 = 5
        L_0x045d:
            r0.f26547g = r8
            goto L_0x04b4
        L_0x0460:
            r11 = 8
            if (r10 != r11) goto L_0x0468
            r12 = 6
            r0.f26547g = r12
            goto L_0x04b4
        L_0x0468:
            r8 = 24
            if (r10 != r8) goto L_0x046e
            r8 = 7
            goto L_0x045d
        L_0x046e:
            r8 = 16
            if (r10 != r8) goto L_0x04a0
            r0.f26547g = r11
            r8 = 31744(0x7c00, float:4.4483E-41)
            r0.f26551k = r8
            r10 = 992(0x3e0, float:1.39E-42)
            r0.f26552l = r10
            r10 = 31
        L_0x047e:
            r0.f26553m = r10
            java.util.HashMap<java.lang.String, java.lang.Object> r10 = r0.o
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10.put(r5, r8)
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            int r10 = r0.f26552l
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r8.put(r4, r10)
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            int r10 = r0.f26553m
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r8.put(r1, r10)
            goto L_0x04b4
        L_0x04a0:
            r8 = 32
            if (r10 != r8) goto L_0x04b4
            r8 = 9
            r0.f26547g = r8
            r8 = 16711680(0xff0000, float:2.3418052E-38)
            r0.f26551k = r8
            r10 = 65280(0xff00, float:9.1477E-41)
            r0.f26552l = r10
            r10 = 255(0xff, float:3.57E-43)
            goto L_0x047e
        L_0x04b4:
            int r8 = (r2 > r20 ? 1 : (r2 == r20 ? 0 : -1))
            if (r8 < 0) goto L_0x04f4
            java.io.InputStream r8 = r0.f26541a
            long r10 = r0.r(r8)
            int r8 = (int) r10
            r0.f26551k = r8
            java.io.InputStream r8 = r0.f26541a
            long r10 = r0.r(r8)
            int r8 = (int) r10
            r0.f26552l = r8
            java.io.InputStream r8 = r0.f26541a
            long r10 = r0.r(r8)
            int r8 = (int) r10
            r0.f26553m = r8
            java.util.HashMap<java.lang.String, java.lang.Object> r8 = r0.o
            int r10 = r0.f26551k
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r8.put(r5, r10)
            java.util.HashMap<java.lang.String, java.lang.Object> r5 = r0.o
            int r8 = r0.f26552l
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r5.put(r4, r8)
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.o
            int r5 = r0.f26553m
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r1, r5)
        L_0x04f4:
            int r1 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r1 != 0) goto L_0x050a
            java.io.InputStream r1 = r0.f26541a
            long r4 = r0.r(r1)
            int r1 = (int) r4
            r0.f26554n = r1
            java.util.HashMap<java.lang.String, java.lang.Object> r4 = r0.o
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4.put(r9, r1)
        L_0x050a:
            long r4 = r0.f26543c
            r8 = 14
            long r8 = r4 - r8
            long r8 = r8 - r2
            r10 = 4
            long r8 = r8 / r10
            int r1 = (int) r8
            r8 = 4
            int r1 = r1 * 4
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L_0x054a
            int r1 = r0.f26547g
            if (r1 == r8) goto L_0x053d
            r4 = 5
            if (r1 == r4) goto L_0x0534
            r4 = 6
            if (r1 == r4) goto L_0x0528
            r1 = 0
            goto L_0x0546
        L_0x0528:
            r4 = 0
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0530
            r6 = 256(0x100, double:1.265E-321)
        L_0x0530:
            int r1 = (int) r6
            int r1 = r1 * 4
            goto L_0x0546
        L_0x0534:
            r4 = 0
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0530
            r6 = 16
            goto L_0x0530
        L_0x053d:
            r4 = 0
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0530
            r6 = 2
            goto L_0x0530
        L_0x0546:
            long r4 = (long) r1
            long r2 = r2 + r4
            r0.f26543c = r2
        L_0x054a:
            r0.u(r1)
            java.util.HashMap<java.lang.String, java.lang.Object> r1 = r0.o
            java.lang.String r2 = "BMP v. 3.x"
            goto L_0x0443
        L_0x0553:
            int r1 = r0.s
            r2 = 1
            if (r1 <= 0) goto L_0x055c
            r0.f26549i = r2
            r3 = 0
            goto L_0x0565
        L_0x055c:
            r3 = 0
            r0.f26549i = r3
            int r1 = java.lang.Math.abs(r1)
            r0.s = r1
        L_0x0565:
            int r1 = r0.f26550j
            if (r1 == r2) goto L_0x0570
            r2 = 4
            if (r1 == r2) goto L_0x0570
            r2 = 8
            if (r1 != r2) goto L_0x0572
        L_0x0570:
            r1 = 1
            goto L_0x058a
        L_0x0572:
            r2 = 16
            if (r1 != r2) goto L_0x057b
            r2 = 3
        L_0x0577:
            r0.f26548h = r2
            goto L_0x05e8
        L_0x057b:
            r2 = 3
            r3 = 32
            if (r1 != r3) goto L_0x0577
            int r1 = r0.f26554n
            if (r1 != 0) goto L_0x0586
            r4 = 3
            goto L_0x0587
        L_0x0586:
            r4 = 4
        L_0x0587:
            r0.f26548h = r4
            goto L_0x05e8
        L_0x058a:
            r0.f26548h = r1
            int r2 = r0.f26547g
            r4 = 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x05c0
            if (r2 == r1) goto L_0x05c0
            r1 = 2
            if (r2 != r1) goto L_0x0598
            goto L_0x05c0
        L_0x0598:
            byte[] r1 = r0.f26546f
            int r1 = r1.length
            r2 = 4
            int r1 = r1 / r2
            if (r1 <= r4) goto L_0x05a0
            goto L_0x05a1
        L_0x05a0:
            r4 = r1
        L_0x05a1:
            byte[] r1 = new byte[r4]
            byte[] r2 = new byte[r4]
            byte[] r5 = new byte[r4]
        L_0x05a7:
            if (r3 >= r4) goto L_0x05e8
            int r6 = r3 * 4
            byte[] r7 = r0.f26546f
            byte r8 = r7[r6]
            r5[r3] = r8
            int r8 = r6 + 1
            byte r8 = r7[r8]
            r2[r3] = r8
            r8 = 2
            int r6 = r6 + r8
            byte r6 = r7[r6]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x05a7
        L_0x05c0:
            byte[] r1 = r0.f26546f
            int r1 = r1.length
            r2 = 3
            int r1 = r1 / r2
            if (r1 <= r4) goto L_0x05c8
            goto L_0x05c9
        L_0x05c8:
            r4 = r1
        L_0x05c9:
            byte[] r1 = new byte[r4]
            byte[] r2 = new byte[r4]
            byte[] r5 = new byte[r4]
        L_0x05cf:
            if (r3 >= r4) goto L_0x05e8
            int r6 = r3 * 3
            byte[] r7 = r0.f26546f
            byte r8 = r7[r6]
            r5[r3] = r8
            int r8 = r6 + 1
            byte r8 = r7[r8]
            r2[r3] = r8
            r8 = 2
            int r6 = r6 + r8
            byte r6 = r7[r6]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x05cf
        L_0x05e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.BmpImage.l(java.io.InputStream, boolean):void");
    }
}
