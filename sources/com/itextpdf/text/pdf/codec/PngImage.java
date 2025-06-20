package com.itextpdf.text.pdf.codec;

import com.itextpdf.text.Image;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfLiteral;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.lang3.StringUtils;

public class PngImage {
    public static final int[] L = {137, 80, 78, 71, 13, 10, 26, 10};
    public static final String M = "IHDR";
    public static final String N = "PLTE";
    public static final String O = "IDAT";
    public static final String P = "IEND";
    public static final String Q = "tRNS";
    public static final String R = "pHYs";
    public static final String S = "gAMA";
    public static final String T = "cHRM";
    public static final String U = "sRGB";
    public static final String V = "iCCP";
    private static final int W = 4096;
    private static final int X = 0;
    private static final int Y = 1;
    private static final int Z = 2;
    private static final int a0 = 3;
    private static final int b0 = 4;
    private static final PdfName[] c0 = {PdfName.Pc, PdfName.Sd, PdfName.De, PdfName.n3};
    boolean A = false;
    float B;
    float C;
    float D;
    float E;
    float F;
    float G;
    float H;
    float I;
    PdfName J;
    ICC_Profile K;

    /* renamed from: a  reason: collision with root package name */
    InputStream f26626a;

    /* renamed from: b  reason: collision with root package name */
    DataInputStream f26627b;

    /* renamed from: c  reason: collision with root package name */
    int f26628c;

    /* renamed from: d  reason: collision with root package name */
    int f26629d;

    /* renamed from: e  reason: collision with root package name */
    int f26630e;

    /* renamed from: f  reason: collision with root package name */
    int f26631f;

    /* renamed from: g  reason: collision with root package name */
    int f26632g;

    /* renamed from: h  reason: collision with root package name */
    int f26633h;

    /* renamed from: i  reason: collision with root package name */
    int f26634i;

    /* renamed from: j  reason: collision with root package name */
    PdfDictionary f26635j = new PdfDictionary();

    /* renamed from: k  reason: collision with root package name */
    byte[] f26636k;

    /* renamed from: l  reason: collision with root package name */
    byte[] f26637l;

    /* renamed from: m  reason: collision with root package name */
    byte[] f26638m;

    /* renamed from: n  reason: collision with root package name */
    NewByteArrayOutputStream f26639n = new NewByteArrayOutputStream();
    int o;
    int p;
    float q;
    boolean r;
    boolean s;
    int t = -1;
    int u = -1;
    int v = -1;
    int w;
    int x;
    byte[] y;
    float z = 1.0f;

    static class NewByteArrayOutputStream extends ByteArrayOutputStream {
        NewByteArrayOutputStream() {
        }

        public byte[] b() {
            return this.buf;
        }
    }

    PngImage(InputStream inputStream) {
        this.f26626a = inputStream;
    }

    private static void b(byte[] bArr, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + ((bArr2[i4] & 255) / 2));
        }
        for (int i5 = i3; i5 < i2; i5++) {
            bArr[i5] = (byte) ((bArr[i5] & 255) + (((bArr[i5 - i3] & 255) + (bArr2[i5] & 255)) / 2));
        }
    }

    private static void d(byte[] bArr, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + (bArr2[i4] & 255));
        }
        for (int i5 = i3; i5 < i2; i5++) {
            int i6 = i5 - i3;
            bArr[i5] = (byte) ((bArr[i5] & 255) + s(bArr[i6] & 255, bArr2[i5] & 255, bArr2[i6] & 255));
        }
    }

    private static void f(byte[] bArr, int i2, int i3) {
        for (int i4 = i3; i4 < i2; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + (bArr[i4 - i3] & 255));
        }
    }

    private static void g(byte[] bArr, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + (bArr2[i3] & 255));
        }
    }

    public static Image j(InputStream inputStream) throws IOException {
        return new PngImage(inputStream).i();
    }

    public static Image k(String str) throws IOException {
        return l(Utilities.w(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image l(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = r2.openStream()     // Catch:{ all -> 0x0013 }
            com.itextpdf.text.Image r1 = j(r0)     // Catch:{ all -> 0x0011 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.l(java.net.URL):com.itextpdf.text.Image");
    }

    public static Image m(byte[] bArr) throws IOException {
        Image j2 = j(new ByteArrayInputStream(bArr));
        j2.j2(bArr);
        return j2;
    }

    public static final int n(InputStream inputStream) throws IOException {
        return (inputStream.read() << 24) + (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
    }

    static int o(byte[] bArr, int i2, int i3, int i4, int i5) {
        int i6 = i5 * i3;
        if (i4 == 8) {
            return bArr[i6 + i2] & 255;
        }
        int i7 = 8 / i4;
        return (bArr[i6 + (i2 / i7)] >> ((8 - ((i2 % i7) * i4)) - i4)) & ((1 << i4) - 1);
    }

    public static final String q(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 4; i2++) {
            stringBuffer.append((char) inputStream.read());
        }
        return stringBuffer.toString();
    }

    public static final int r(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    private static int s(int i2, int i3, int i4) {
        int i5 = (i2 + i3) - i4;
        int abs = Math.abs(i5 - i2);
        int abs2 = Math.abs(i5 - i3);
        int abs3 = Math.abs(i5 - i4);
        if (abs > abs2 || abs > abs3) {
            return abs2 <= abs3 ? i3 : i4;
        }
        return i2;
    }

    static void v(byte[] bArr, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 0;
        if (i6 == 8) {
            int i9 = (i7 * i5) + (i4 * i3);
            while (i8 < i3) {
                bArr[i9 + i8] = (byte) iArr[i8 + i2];
                i8++;
            }
            return;
        }
        int i10 = i7 * i5;
        if (i6 == 16) {
            int i11 = i10 + (i4 * i3);
            while (i8 < i3) {
                bArr[i11 + i8] = (byte) (iArr[i8 + i2] >>> 8);
                i8++;
            }
            return;
        }
        int i12 = 8 / i6;
        int i13 = i10 + (i4 / i12);
        bArr[i13] = (byte) ((iArr[i2] << ((8 - ((i4 % i12) * i6)) - i6)) | bArr[i13]);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        if (str.length() != 4) {
            return false;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = this.f26630e;
        int i11 = i10 == 16 ? 8 : i10;
        int i12 = i10 == 16 ? 2 : 1;
        this.x = i12;
        int i13 = this.f26631f;
        if (i13 != 0) {
            if (i13 == 6) {
                i2 = this.f26628c * 3 * this.f26629d;
                i9 = i12 * 4;
            } else if (i13 != 2) {
                i2 = -1;
                if (i13 == 3) {
                    if (this.f26634i == 1) {
                        i2 = (((i11 * this.f26628c) + 7) / 8) * this.f26629d;
                    }
                    this.x = 1;
                } else if (i13 == 4) {
                    i2 = this.f26628c * this.f26629d;
                    i9 = i12 * 2;
                }
            } else {
                i2 = this.f26628c * 3 * this.f26629d;
                i9 = i12 * 3;
            }
            this.x = i9;
        } else {
            i2 = (((i11 * this.f26628c) + 7) / 8) * this.f26629d;
        }
        if (i2 >= 0) {
            this.f26636k = new byte[i2];
        }
        if (this.s) {
            this.f26637l = new byte[(this.f26628c * this.f26629d)];
        } else if (this.r) {
            this.f26637l = new byte[(((this.f26628c + 7) / 8) * this.f26629d)];
        }
        this.f26627b = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(this.f26639n.b(), 0, this.f26639n.size()), new Inflater()));
        if (this.f26634i != 1) {
            i4 = this.f26628c;
            i5 = this.f26629d;
            i6 = 0;
            i7 = 0;
            i8 = 1;
            i3 = 1;
        } else {
            e(0, 0, 8, 8, (this.f26628c + 7) / 8, (this.f26629d + 7) / 8);
            e(4, 0, 8, 8, (this.f26628c + 3) / 8, (this.f26629d + 7) / 8);
            e(0, 4, 4, 8, (this.f26628c + 3) / 4, (this.f26629d + 3) / 8);
            e(2, 0, 4, 4, (this.f26628c + 1) / 4, (this.f26629d + 3) / 4);
            e(0, 2, 2, 4, (this.f26628c + 1) / 2, (this.f26629d + 1) / 4);
            i3 = 2;
            e(1, 0, 2, 2, this.f26628c / 2, (this.f26629d + 1) / 2);
            i4 = this.f26628c;
            i5 = this.f26629d / 2;
            i6 = 0;
            i7 = 1;
            i8 = 1;
        }
        e(i6, i7, i8, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8;
        int i9 = i7;
        if (i6 != 0 && i9 != 0) {
            int i10 = (((this.w * i6) * this.f26630e) + 7) / 8;
            int i11 = i3;
            byte[] bArr = new byte[i10];
            byte[] bArr2 = new byte[i10];
            int i12 = 0;
            while (i12 < i9) {
                try {
                    i8 = this.f26627b.read();
                    try {
                        this.f26627b.readFully(bArr, 0, i10);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i8 = 0;
                }
                if (i8 != 0) {
                    if (i8 == 1) {
                        f(bArr, i10, this.x);
                    } else if (i8 == 2) {
                        g(bArr, bArr2, i10);
                    } else if (i8 == 3) {
                        b(bArr, bArr2, i10, this.x);
                    } else if (i8 == 4) {
                        d(bArr, bArr2, i10, this.x);
                    } else {
                        throw new RuntimeException(MessageLocalization.b("png.filter.unknown", new Object[0]));
                    }
                }
                t(bArr, i2, i4, i11, i6);
                i12++;
                i11 += i5;
                byte[] bArr3 = bArr2;
                bArr2 = bArr;
                bArr = bArr3;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.itextpdf.text.pdf.PdfLiteral} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.itextpdf.text.pdf.PdfLiteral} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.itextpdf.text.pdf.PdfArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.itextpdf.text.pdf.PdfLiteral} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfObject h() {
        /*
            r19 = this;
            r0 = r19
            com.itextpdf.text.pdf.ICC_Profile r1 = r0.K
            if (r1 == 0) goto L_0x0012
            int r1 = r0.f26631f
            r1 = r1 & 2
            if (r1 != 0) goto L_0x000f
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.A6
            return r1
        L_0x000f:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.B6
            return r1
        L_0x0012:
            float r1 = r0.z
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x002a
            boolean r1 = r0.A
            if (r1 != 0) goto L_0x002a
            int r1 = r0.f26631f
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0027
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.A6
            return r1
        L_0x0027:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.B6
            return r1
        L_0x002a:
            com.itextpdf.text.pdf.PdfArray r1 = new com.itextpdf.text.pdf.PdfArray
            r1.<init>()
            com.itextpdf.text.pdf.PdfDictionary r3 = new com.itextpdf.text.pdf.PdfDictionary
            r3.<init>()
            int r4 = r0.f26631f
            r4 = r4 & 2
            java.lang.String r5 = "[1 1 1]"
            if (r4 != 0) goto L_0x0065
            float r4 = r0.z
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0045
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.A6
            return r1
        L_0x0045:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.P4
            r1.a0(r2)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.H8
            com.itextpdf.text.pdf.PdfNumber r4 = new com.itextpdf.text.pdf.PdfNumber
            float r6 = r0.z
            r4.<init>((float) r6)
            r3.V0(r2, r4)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Qh
            com.itextpdf.text.pdf.PdfLiteral r4 = new com.itextpdf.text.pdf.PdfLiteral
            r4.<init>((java.lang.String) r5)
            r3.V0(r2, r4)
        L_0x0060:
            r1.a0(r3)
            goto L_0x018b
        L_0x0065:
            com.itextpdf.text.pdf.PdfLiteral r4 = new com.itextpdf.text.pdf.PdfLiteral
            r4.<init>((java.lang.String) r5)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Q4
            r1.a0(r5)
            float r5 = r0.z
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x008f
            com.itextpdf.text.pdf.PdfArray r5 = new com.itextpdf.text.pdf.PdfArray
            r5.<init>()
            com.itextpdf.text.pdf.PdfNumber r6 = new com.itextpdf.text.pdf.PdfNumber
            float r7 = r0.z
            r6.<init>((float) r7)
            r5.a0(r6)
            r5.a0(r6)
            r5.a0(r6)
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.H8
            r3.V0(r6, r5)
        L_0x008f:
            boolean r5 = r0.A
            if (r5 == 0) goto L_0x0184
            float r4 = r0.C
            float r5 = r0.F
            float r6 = r0.H
            float r7 = r5 - r6
            float r8 = r0.E
            float r7 = r7 * r8
            float r9 = r0.D
            float r10 = r9 - r6
            float r11 = r0.G
            float r10 = r10 * r11
            float r7 = r7 - r10
            float r10 = r9 - r5
            float r12 = r0.I
            float r10 = r10 * r12
            float r7 = r7 + r10
            float r7 = r7 * r4
            float r10 = r5 - r6
            float r10 = r10 * r4
            float r13 = r0.B
            float r14 = r13 - r6
            float r14 = r14 * r11
            float r10 = r10 - r14
            float r14 = r13 - r5
            float r14 = r14 * r12
            float r10 = r10 + r14
            float r10 = r10 * r8
            float r10 = r10 / r7
            float r14 = r10 * r9
            float r14 = r14 / r8
            float r15 = r2 - r9
            float r15 = r15 / r8
            float r15 = r15 - r2
            float r15 = r15 * r10
            float r2 = -r11
            float r17 = r9 - r6
            float r17 = r17 * r4
            float r18 = r13 - r6
            float r18 = r18 * r8
            float r17 = r17 - r18
            float r8 = r13 - r9
            float r8 = r8 * r12
            float r17 = r17 + r8
            float r2 = r2 * r17
            float r2 = r2 / r7
            float r8 = r2 * r5
            float r8 = r8 / r11
            r16 = 1065353216(0x3f800000, float:1.0)
            float r17 = r16 - r5
            float r17 = r17 / r11
            float r17 = r17 - r16
            float r0 = r2 * r17
            float r17 = r9 - r5
            float r17 = r17 * r4
            float r5 = r13 - r5
            float r5 = r5 * r4
            float r17 = r17 - r5
            float r13 = r13 - r9
            float r13 = r13 * r11
            float r17 = r17 + r13
            float r17 = r17 * r12
            float r4 = r17 / r7
            float r5 = r4 * r6
            float r5 = r5 / r12
            r7 = 1065353216(0x3f800000, float:1.0)
            float r6 = r7 - r6
            float r6 = r6 / r12
            float r6 = r6 - r7
            float r6 = r6 * r4
            float r7 = r14 + r8
            float r7 = r7 + r5
            float r9 = r15 + r0
            float r9 = r9 + r6
            com.itextpdf.text.pdf.PdfArray r11 = new com.itextpdf.text.pdf.PdfArray
            r11.<init>()
            com.itextpdf.text.pdf.PdfNumber r12 = new com.itextpdf.text.pdf.PdfNumber
            r12.<init>((float) r7)
            r11.a0(r12)
            com.itextpdf.text.pdf.PdfNumber r7 = new com.itextpdf.text.pdf.PdfNumber
            r12 = 1065353216(0x3f800000, float:1.0)
            r7.<init>((float) r12)
            r11.a0(r7)
            com.itextpdf.text.pdf.PdfNumber r7 = new com.itextpdf.text.pdf.PdfNumber
            r7.<init>((float) r9)
            r11.a0(r7)
            com.itextpdf.text.pdf.PdfArray r7 = new com.itextpdf.text.pdf.PdfArray
            r7.<init>()
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            r9.<init>((float) r14)
            r7.a0(r9)
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            r9.<init>((float) r10)
            r7.a0(r9)
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            r9.<init>((float) r15)
            r7.a0(r9)
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            r9.<init>((float) r8)
            r7.a0(r9)
            com.itextpdf.text.pdf.PdfNumber r8 = new com.itextpdf.text.pdf.PdfNumber
            r8.<init>((float) r2)
            r7.a0(r8)
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((float) r0)
            r7.a0(r2)
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            r0.<init>((float) r5)
            r7.a0(r0)
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            r0.<init>((float) r4)
            r7.a0(r0)
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            r0.<init>((float) r6)
            r7.a0(r0)
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Qa
            r3.V0(r0, r7)
            r4 = r11
        L_0x0184:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Qh
            r3.V0(r0, r4)
            goto L_0x0060
        L_0x018b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.h():com.itextpdf.text.pdf.PdfObject");
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [com.itextpdf.text.Image] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00b3 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00bc A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bf A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c4 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00dc A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x013b A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0148 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0157 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0160 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0167 A[Catch:{ Exception -> 0x0024 }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x017b A[Catch:{ Exception -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Image i() throws java.io.IOException {
        /*
            r13 = this;
            r13.u()
            r0 = 0
            r13.s = r0     // Catch:{ Exception -> 0x0024 }
            byte[] r1 = r13.f26638m     // Catch:{ Exception -> 0x0024 }
            r2 = 1
            if (r1 == 0) goto L_0x002a
            r1 = 0
            r3 = 0
            r4 = 0
        L_0x000e:
            byte[] r5 = r13.f26638m     // Catch:{ Exception -> 0x0024 }
            int r6 = r5.length     // Catch:{ Exception -> 0x0024 }
            if (r1 >= r6) goto L_0x002c
            byte r5 = r5[r1]     // Catch:{ Exception -> 0x0024 }
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x001d
            int r3 = r3 + 1
            r4 = r1
        L_0x001d:
            if (r5 == 0) goto L_0x0027
            if (r5 == r6) goto L_0x0027
            r13.s = r2     // Catch:{ Exception -> 0x0024 }
            goto L_0x002c
        L_0x0024:
            r0 = move-exception
            goto L_0x019b
        L_0x0027:
            int r1 = r1 + 1
            goto L_0x000e
        L_0x002a:
            r3 = 0
            r4 = 0
        L_0x002c:
            int r1 = r13.f26631f     // Catch:{ Exception -> 0x0024 }
            r5 = 4
            r1 = r1 & r5
            if (r1 == 0) goto L_0x0034
            r13.s = r2     // Catch:{ Exception -> 0x0024 }
        L_0x0034:
            boolean r1 = r13.s     // Catch:{ Exception -> 0x0024 }
            if (r1 != 0) goto L_0x0040
            if (r3 > r2) goto L_0x003e
            int r6 = r13.t     // Catch:{ Exception -> 0x0024 }
            if (r6 < 0) goto L_0x0040
        L_0x003e:
            r6 = 1
            goto L_0x0041
        L_0x0040:
            r6 = 0
        L_0x0041:
            r13.r = r6     // Catch:{ Exception -> 0x0024 }
            if (r1 != 0) goto L_0x0073
            if (r6 != 0) goto L_0x0073
            if (r3 != r2) goto L_0x0073
            com.itextpdf.text.pdf.PdfDictionary r1 = r13.f26635j     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Va     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfLiteral r6 = new com.itextpdf.text.pdf.PdfLiteral     // Catch:{ Exception -> 0x0024 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0024 }
            r7.<init>()     // Catch:{ Exception -> 0x0024 }
            java.lang.String r8 = "["
            r7.append(r8)     // Catch:{ Exception -> 0x0024 }
            r7.append(r4)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r8 = " "
            r7.append(r8)     // Catch:{ Exception -> 0x0024 }
            r7.append(r4)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r4 = "]"
            r7.append(r4)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x0024 }
            r6.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x0024 }
            r1.V0(r3, r6)     // Catch:{ Exception -> 0x0024 }
        L_0x0073:
            int r1 = r13.f26634i     // Catch:{ Exception -> 0x0024 }
            r3 = 16
            if (r1 == r2) goto L_0x008a
            int r1 = r13.f26630e     // Catch:{ Exception -> 0x0024 }
            if (r1 == r3) goto L_0x008a
            int r1 = r13.f26631f     // Catch:{ Exception -> 0x0024 }
            r1 = r1 & r5
            if (r1 != 0) goto L_0x008a
            boolean r1 = r13.s     // Catch:{ Exception -> 0x0024 }
            if (r1 != 0) goto L_0x008a
            boolean r1 = r13.r     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x008b
        L_0x008a:
            r0 = 1
        L_0x008b:
            int r1 = r13.f26631f     // Catch:{ Exception -> 0x0024 }
            r4 = 2
            r6 = 3
            if (r1 == 0) goto L_0x009e
            r7 = 6
            if (r1 == r7) goto L_0x00a4
            if (r1 == r4) goto L_0x00a1
            if (r1 == r6) goto L_0x009e
            if (r1 == r5) goto L_0x009b
            goto L_0x00a6
        L_0x009b:
            r13.w = r4     // Catch:{ Exception -> 0x0024 }
            goto L_0x00a6
        L_0x009e:
            r13.w = r2     // Catch:{ Exception -> 0x0024 }
            goto L_0x00a6
        L_0x00a1:
            r13.w = r6     // Catch:{ Exception -> 0x0024 }
            goto L_0x00a6
        L_0x00a4:
            r13.w = r5     // Catch:{ Exception -> 0x0024 }
        L_0x00a6:
            if (r0 == 0) goto L_0x00ab
            r13.c()     // Catch:{ Exception -> 0x0024 }
        L_0x00ab:
            int r0 = r13.w     // Catch:{ Exception -> 0x0024 }
            int r1 = r13.f26631f     // Catch:{ Exception -> 0x0024 }
            r5 = r1 & 4
            if (r5 == 0) goto L_0x00b5
            int r0 = r0 + -1
        L_0x00b5:
            r10 = r0
            int r0 = r13.f26630e     // Catch:{ Exception -> 0x0024 }
            r5 = 8
            if (r0 != r3) goto L_0x00bf
            r11 = 8
            goto L_0x00c0
        L_0x00bf:
            r11 = r0
        L_0x00c0:
            byte[] r0 = r13.f26636k     // Catch:{ Exception -> 0x0024 }
            if (r0 == 0) goto L_0x00dc
            if (r1 != r6) goto L_0x00d3
            com.itextpdf.text.ImgRaw r0 = new com.itextpdf.text.ImgRaw     // Catch:{ Exception -> 0x0024 }
            int r8 = r13.f26628c     // Catch:{ Exception -> 0x0024 }
            int r9 = r13.f26629d     // Catch:{ Exception -> 0x0024 }
            byte[] r12 = r13.f26636k     // Catch:{ Exception -> 0x0024 }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0131
        L_0x00d3:
            int r1 = r13.f26628c     // Catch:{ Exception -> 0x0024 }
            int r3 = r13.f26629d     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.Image r0 = com.itextpdf.text.Image.T0(r1, r3, r10, r11, r0)     // Catch:{ Exception -> 0x0024 }
            goto L_0x0131
        L_0x00dc:
            com.itextpdf.text.ImgRaw r0 = new com.itextpdf.text.ImgRaw     // Catch:{ Exception -> 0x0024 }
            int r8 = r13.f26628c     // Catch:{ Exception -> 0x0024 }
            int r9 = r13.f26629d     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.codec.PngImage$NewByteArrayOutputStream r1 = r13.f26639n     // Catch:{ Exception -> 0x0024 }
            byte[] r12 = r1.toByteArray()     // Catch:{ Exception -> 0x0024 }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0024 }
            r0.b2(r2)     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfDictionary r1 = new com.itextpdf.text.pdf.PdfDictionary     // Catch:{ Exception -> 0x0024 }
            r1.<init>()     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.u4     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfNumber r7 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ Exception -> 0x0024 }
            int r8 = r13.f26630e     // Catch:{ Exception -> 0x0024 }
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x0024 }
            r1.V0(r3, r7)     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.bd     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfNumber r7 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ Exception -> 0x0024 }
            r8 = 15
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x0024 }
            r1.V0(r3, r7)     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.G5     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfNumber r7 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ Exception -> 0x0024 }
            int r8 = r13.f26628c     // Catch:{ Exception -> 0x0024 }
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x0024 }
            r1.V0(r3, r7)     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.v5     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfNumber r7 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ Exception -> 0x0024 }
            int r8 = r13.f26631f     // Catch:{ Exception -> 0x0024 }
            if (r8 == r6) goto L_0x0123
            r8 = r8 & r4
            if (r8 != 0) goto L_0x0124
        L_0x0123:
            r6 = 1
        L_0x0124:
            r7.<init>((int) r6)     // Catch:{ Exception -> 0x0024 }
            r1.V0(r3, r7)     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfDictionary r3 = r13.f26635j     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.o6     // Catch:{ Exception -> 0x0024 }
            r3.V0(r6, r1)     // Catch:{ Exception -> 0x0024 }
        L_0x0131:
            com.itextpdf.text.pdf.PdfDictionary r1 = r13.f26635j     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfObject r1 = r1.d0(r3)     // Catch:{ Exception -> 0x0024 }
            if (r1 != 0) goto L_0x0144
            com.itextpdf.text.pdf.PdfDictionary r1 = r13.f26635j     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfObject r6 = r13.h()     // Catch:{ Exception -> 0x0024 }
            r1.V0(r3, r6)     // Catch:{ Exception -> 0x0024 }
        L_0x0144:
            com.itextpdf.text.pdf.PdfName r1 = r13.J     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x014f
            com.itextpdf.text.pdf.PdfDictionary r3 = r13.f26635j     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.T9     // Catch:{ Exception -> 0x0024 }
            r3.V0(r6, r1)     // Catch:{ Exception -> 0x0024 }
        L_0x014f:
            com.itextpdf.text.pdf.PdfDictionary r1 = r13.f26635j     // Catch:{ Exception -> 0x0024 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0024 }
            if (r1 <= 0) goto L_0x015c
            com.itextpdf.text.pdf.PdfDictionary r1 = r13.f26635j     // Catch:{ Exception -> 0x0024 }
            r0.W1(r1)     // Catch:{ Exception -> 0x0024 }
        L_0x015c:
            com.itextpdf.text.pdf.ICC_Profile r1 = r13.K     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x0163
            r0.x2(r1)     // Catch:{ Exception -> 0x0024 }
        L_0x0163:
            boolean r1 = r13.s     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x0177
            int r1 = r13.f26628c     // Catch:{ Exception -> 0x0024 }
            int r3 = r13.f26629d     // Catch:{ Exception -> 0x0024 }
            byte[] r6 = r13.f26637l     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.Image r1 = com.itextpdf.text.Image.T0(r1, r3, r2, r5, r6)     // Catch:{ Exception -> 0x0024 }
            r1.K1()     // Catch:{ Exception -> 0x0024 }
            r0.e2(r1)     // Catch:{ Exception -> 0x0024 }
        L_0x0177:
            boolean r1 = r13.r     // Catch:{ Exception -> 0x0024 }
            if (r1 == 0) goto L_0x018b
            int r1 = r13.f26628c     // Catch:{ Exception -> 0x0024 }
            int r3 = r13.f26629d     // Catch:{ Exception -> 0x0024 }
            byte[] r5 = r13.f26637l     // Catch:{ Exception -> 0x0024 }
            com.itextpdf.text.Image r1 = com.itextpdf.text.Image.T0(r1, r3, r2, r2, r5)     // Catch:{ Exception -> 0x0024 }
            r1.K1()     // Catch:{ Exception -> 0x0024 }
            r0.e2(r1)     // Catch:{ Exception -> 0x0024 }
        L_0x018b:
            int r1 = r13.o     // Catch:{ Exception -> 0x0024 }
            int r2 = r13.p     // Catch:{ Exception -> 0x0024 }
            r0.d2(r1, r2)     // Catch:{ Exception -> 0x0024 }
            float r1 = r13.q     // Catch:{ Exception -> 0x0024 }
            r0.u2(r1)     // Catch:{ Exception -> 0x0024 }
            r0.k2(r4)     // Catch:{ Exception -> 0x0024 }
            return r0
        L_0x019b:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.i():com.itextpdf.text.Image");
    }

    /* access modifiers changed from: package-private */
    public int[] p(byte[] bArr) {
        int i2 = this.f26630e;
        int i3 = 0;
        if (i2 == 8) {
            int length = bArr.length;
            int[] iArr = new int[length];
            while (i3 < length) {
                iArr[i3] = bArr[i3] & 255;
                i3++;
            }
            return iArr;
        } else if (i2 != 16) {
            int[] iArr2 = new int[((bArr.length * 8) / i2)];
            int i4 = 8 / i2;
            int i5 = (1 << i2) - 1;
            int i6 = 0;
            while (i3 < bArr.length) {
                int i7 = i4 - 1;
                while (i7 >= 0) {
                    iArr2[i6] = (bArr[i3] >>> (this.f26630e * i7)) & i5;
                    i7--;
                    i6++;
                }
                i3++;
            }
            return iArr2;
        } else {
            int length2 = bArr.length / 2;
            int[] iArr3 = new int[length2];
            while (i3 < length2) {
                int i8 = i3 * 2;
                iArr3[i3] = ((bArr[i8] & 255) << 8) + (bArr[i8 + 1] & 255);
                i3++;
            }
            return iArr3;
        }
    }

    /* JADX WARNING: type inference failed for: r3v10, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v19, types: [byte] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ce  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t(byte[] r27, int r28, int r29, int r30, int r31) {
        /*
            r26 = this;
            r0 = r26
            r1 = r31
            int[] r10 = r26.p(r27)
            int r2 = r0.f26631f
            r11 = 4
            r12 = 3
            r13 = 2
            r14 = 1
            r15 = 0
            if (r2 == 0) goto L_0x0020
            r3 = 6
            if (r2 == r3) goto L_0x001d
            if (r2 == r13) goto L_0x001d
            if (r2 == r12) goto L_0x0020
            if (r2 == r11) goto L_0x0020
            r16 = 0
            goto L_0x0022
        L_0x001d:
            r16 = 3
            goto L_0x0022
        L_0x0020:
            r16 = 1
        L_0x0022:
            byte[] r2 = r0.f26636k
            r9 = 16
            r17 = 8
            if (r2 == 0) goto L_0x0063
            int r2 = r0.f26628c
            int r2 = r2 * r16
            int r3 = r0.f26630e
            if (r3 != r9) goto L_0x0034
            r3 = 8
        L_0x0034:
            int r2 = r2 * r3
            int r2 = r2 + 7
            int r18 = r2 / 8
            r19 = r28
            r8 = 0
        L_0x003d:
            if (r8 >= r1) goto L_0x0063
            byte[] r2 = r0.f26636k
            int r3 = r0.w
            int r4 = r3 * r8
            int r7 = r0.f26630e
            r3 = r10
            r5 = r16
            r6 = r19
            r20 = r7
            r7 = r30
            r21 = r8
            r8 = r20
            r12 = 16
            r9 = r18
            v(r2, r3, r4, r5, r6, r7, r8, r9)
            int r19 = r19 + r29
            int r8 = r21 + 1
            r9 = 16
            r12 = 3
            goto L_0x003d
        L_0x0063:
            r12 = 16
            boolean r2 = r0.s
            if (r2 == 0) goto L_0x00ce
            int r2 = r0.f26631f
            r2 = r2 & r11
            if (r2 == 0) goto L_0x00a2
            int r2 = r0.f26630e
            if (r2 != r12) goto L_0x0084
            r2 = 0
        L_0x0073:
            if (r2 >= r1) goto L_0x0084
            int r3 = r0.w
            int r3 = r3 * r2
            int r3 = r3 + r16
            r4 = r10[r3]
            int r4 = r4 >>> 8
            r10[r3] = r4
            int r2 = r2 + 1
            goto L_0x0073
        L_0x0084:
            int r11 = r0.f26628c
            r12 = r28
        L_0x0088:
            if (r15 >= r1) goto L_0x0186
            byte[] r2 = r0.f26637l
            int r3 = r0.w
            int r3 = r3 * r15
            int r4 = r3 + r16
            r5 = 1
            r8 = 8
            r3 = r10
            r6 = r12
            r7 = r30
            r9 = r11
            v(r2, r3, r4, r5, r6, r7, r8, r9)
            int r12 = r12 + r29
            int r15 = r15 + 1
            goto L_0x0088
        L_0x00a2:
            int r11 = r0.f26628c
            int[] r12 = new int[r14]
            r13 = r28
            r14 = 0
        L_0x00a9:
            if (r14 >= r1) goto L_0x0186
            r2 = r10[r14]
            byte[] r3 = r0.f26638m
            int r4 = r3.length
            if (r2 >= r4) goto L_0x00b7
            byte r2 = r3[r2]
            r12[r15] = r2
            goto L_0x00bb
        L_0x00b7:
            r2 = 255(0xff, float:3.57E-43)
            r12[r15] = r2
        L_0x00bb:
            byte[] r2 = r0.f26637l
            r5 = 1
            r8 = 8
            r4 = 0
            r3 = r12
            r6 = r13
            r7 = r30
            r9 = r11
            v(r2, r3, r4, r5, r6, r7, r8, r9)
            int r13 = r13 + r29
            int r14 = r14 + 1
            goto L_0x00a9
        L_0x00ce:
            boolean r2 = r0.r
            if (r2 == 0) goto L_0x0186
            int r2 = r0.f26631f
            if (r2 == 0) goto L_0x0156
            if (r2 == r13) goto L_0x0112
            r3 = 3
            if (r2 == r3) goto L_0x00dd
            goto L_0x0186
        L_0x00dd:
            int r2 = r0.f26628c
            int r2 = r2 + 7
            int r2 = r2 / 8
            r3 = r28
            r4 = 0
        L_0x00e6:
            if (r4 >= r1) goto L_0x0186
            r5 = r10[r4]
            byte[] r6 = r0.f26638m
            int r7 = r6.length
            if (r5 >= r7) goto L_0x00f5
            byte r5 = r6[r5]
            if (r5 != 0) goto L_0x00f5
            r5 = 1
            goto L_0x00f6
        L_0x00f5:
            r5 = 0
        L_0x00f6:
            int[] r19 = new int[]{r5}
            byte[] r5 = r0.f26637l
            r21 = 1
            r24 = 1
            r20 = 0
            r18 = r5
            r22 = r3
            r23 = r30
            r25 = r2
            v(r18, r19, r20, r21, r22, r23, r24, r25)
            int r3 = r3 + r29
            int r4 = r4 + 1
            goto L_0x00e6
        L_0x0112:
            int r2 = r0.f26628c
            int r2 = r2 + 7
            int r2 = r2 / 8
            r3 = r28
            r4 = 0
        L_0x011b:
            if (r4 >= r1) goto L_0x0186
            int r5 = r0.w
            int r5 = r5 * r4
            r6 = r10[r5]
            int r7 = r0.t
            if (r6 != r7) goto L_0x0139
            int r6 = r5 + 1
            r6 = r10[r6]
            int r7 = r0.u
            if (r6 != r7) goto L_0x0139
            int r5 = r5 + 2
            r5 = r10[r5]
            int r6 = r0.v
            if (r5 != r6) goto L_0x0139
            r5 = 1
            goto L_0x013a
        L_0x0139:
            r5 = 0
        L_0x013a:
            int[] r19 = new int[]{r5}
            byte[] r5 = r0.f26637l
            r21 = 1
            r24 = 1
            r20 = 0
            r18 = r5
            r22 = r3
            r23 = r30
            r25 = r2
            v(r18, r19, r20, r21, r22, r23, r24, r25)
            int r3 = r3 + r29
            int r4 = r4 + 1
            goto L_0x011b
        L_0x0156:
            int r2 = r0.f26628c
            int r2 = r2 + 7
            int r2 = r2 / 8
            r3 = r28
            r4 = 0
        L_0x015f:
            if (r4 >= r1) goto L_0x0186
            r5 = r10[r4]
            int r6 = r0.t
            if (r5 != r6) goto L_0x0169
            r5 = 1
            goto L_0x016a
        L_0x0169:
            r5 = 0
        L_0x016a:
            int[] r19 = new int[]{r5}
            byte[] r5 = r0.f26637l
            r21 = 1
            r24 = 1
            r20 = 0
            r18 = r5
            r22 = r3
            r23 = r30
            r25 = r2
            v(r18, r19, r20, r21, r22, r23, r24, r25)
            int r3 = r3 + r29
            int r4 = r4 + 1
            goto L_0x015f
        L_0x0186:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.PngImage.t(byte[], int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void u() throws IOException {
        int i2 = 0;
        while (true) {
            int[] iArr = L;
            if (i2 >= iArr.length) {
                byte[] bArr = new byte[4096];
                while (true) {
                    int n2 = n(this.f26626a);
                    String q2 = q(this.f26626a);
                    if (n2 >= 0 && a(q2)) {
                        if (O.equals(q2)) {
                            while (n2 != 0) {
                                int read = this.f26626a.read(bArr, 0, Math.min(n2, 4096));
                                if (read >= 0) {
                                    this.f26639n.write(bArr, 0, read);
                                    n2 -= read;
                                } else {
                                    return;
                                }
                            }
                            continue;
                        } else {
                            if (Q.equals(q2)) {
                                int i3 = this.f26631f;
                                if (i3 != 0) {
                                    if (i3 != 2) {
                                        if (i3 == 3 && n2 > 0) {
                                            this.f26638m = new byte[n2];
                                            for (int i4 = 0; i4 < n2; i4++) {
                                                this.f26638m[i4] = (byte) this.f26626a.read();
                                            }
                                            n2 = 0;
                                        }
                                    } else if (n2 >= 6) {
                                        n2 -= 6;
                                        int r2 = r(this.f26626a);
                                        int r3 = r(this.f26626a);
                                        int r4 = r(this.f26626a);
                                        if (this.f26630e == 16) {
                                            this.t = r2;
                                            this.u = r3;
                                            this.v = r4;
                                        } else {
                                            this.f26635j.V0(PdfName.Va, new PdfLiteral("[" + r2 + StringUtils.SPACE + r2 + StringUtils.SPACE + r3 + StringUtils.SPACE + r3 + StringUtils.SPACE + r4 + StringUtils.SPACE + r4 + "]"));
                                        }
                                    }
                                } else if (n2 >= 2) {
                                    n2 -= 2;
                                    int r5 = r(this.f26626a);
                                    if (this.f26630e == 16) {
                                        this.t = r5;
                                    } else {
                                        this.f26635j.V0(PdfName.Va, new PdfLiteral("[" + r5 + StringUtils.SPACE + r5 + "]"));
                                    }
                                }
                            } else if (M.equals(q2)) {
                                this.f26628c = n(this.f26626a);
                                this.f26629d = n(this.f26626a);
                                this.f26630e = this.f26626a.read();
                                this.f26631f = this.f26626a.read();
                                this.f26632g = this.f26626a.read();
                                this.f26633h = this.f26626a.read();
                                this.f26634i = this.f26626a.read();
                            } else {
                                boolean z2 = true;
                                if (N.equals(q2)) {
                                    if (this.f26631f == 3) {
                                        PdfArray pdfArray = new PdfArray();
                                        pdfArray.a0(PdfName.N9);
                                        pdfArray.a0(h());
                                        pdfArray.a0(new PdfNumber((n2 / 3) - 1));
                                        ByteBuffer byteBuffer = new ByteBuffer();
                                        while (true) {
                                            int i5 = n2 - 1;
                                            if (n2 <= 0) {
                                                break;
                                            }
                                            byteBuffer.r(this.f26626a.read());
                                            n2 = i5;
                                        }
                                        byte[] F2 = byteBuffer.F();
                                        this.y = F2;
                                        pdfArray.a0(new PdfString(F2));
                                        this.f26635j.V0(PdfName.w5, pdfArray);
                                    }
                                } else if (R.equals(q2)) {
                                    int n3 = n(this.f26626a);
                                    int n4 = n(this.f26626a);
                                    if (this.f26626a.read() == 1) {
                                        this.o = (int) ((((float) n3) * 0.0254f) + 0.5f);
                                        this.p = (int) ((((float) n4) * 0.0254f) + 0.5f);
                                    } else if (n4 != 0) {
                                        this.q = ((float) n3) / ((float) n4);
                                    }
                                } else {
                                    if (T.equals(q2)) {
                                        this.B = ((float) n(this.f26626a)) / 100000.0f;
                                        this.C = ((float) n(this.f26626a)) / 100000.0f;
                                        this.D = ((float) n(this.f26626a)) / 100000.0f;
                                        this.E = ((float) n(this.f26626a)) / 100000.0f;
                                        this.F = ((float) n(this.f26626a)) / 100000.0f;
                                        this.G = ((float) n(this.f26626a)) / 100000.0f;
                                        this.H = ((float) n(this.f26626a)) / 100000.0f;
                                        this.I = ((float) n(this.f26626a)) / 100000.0f;
                                        if (Math.abs(this.B) < 1.0E-4f || Math.abs(this.C) < 1.0E-4f || Math.abs(this.D) < 1.0E-4f || Math.abs(this.E) < 1.0E-4f || Math.abs(this.F) < 1.0E-4f || Math.abs(this.G) < 1.0E-4f || Math.abs(this.H) < 1.0E-4f || Math.abs(this.I) < 1.0E-4f) {
                                            z2 = false;
                                        }
                                    } else {
                                        if (U.equals(q2)) {
                                            this.J = c0[this.f26626a.read()];
                                            this.z = 2.2f;
                                        } else if (S.equals(q2)) {
                                            int n5 = n(this.f26626a);
                                            if (n5 != 0) {
                                                this.z = 100000.0f / ((float) n5);
                                                if (this.A) {
                                                }
                                            }
                                        } else if (V.equals(q2)) {
                                            while (true) {
                                                int i6 = n2 - 1;
                                                if (this.f26626a.read() == 0) {
                                                    break;
                                                }
                                                n2 = i6;
                                            }
                                            this.f26626a.read();
                                            int i7 = n2 - 2;
                                            byte[] bArr2 = new byte[i7];
                                            int i8 = 0;
                                            while (i7 > 0) {
                                                int read2 = this.f26626a.read(bArr2, i8, i7);
                                                if (read2 >= 0) {
                                                    i8 += read2;
                                                    i7 -= read2;
                                                } else {
                                                    throw new IOException(MessageLocalization.b("premature.end.of.file", new Object[0]));
                                                }
                                            }
                                            try {
                                                this.K = ICC_Profile.d(PdfReader.e(bArr2, true));
                                            } catch (RuntimeException unused) {
                                                this.K = null;
                                            }
                                        } else if (P.equals(q2)) {
                                            return;
                                        }
                                        this.B = 0.3127f;
                                        this.C = 0.329f;
                                        this.D = 0.64f;
                                        this.E = 0.33f;
                                        this.F = 0.3f;
                                        this.G = 0.6f;
                                        this.H = 0.15f;
                                        this.I = 0.06f;
                                    }
                                    this.A = z2;
                                }
                            }
                            Utilities.v(this.f26626a, n2);
                        }
                        Utilities.v(this.f26626a, 4);
                    }
                }
                throw new IOException(MessageLocalization.b("corrupted.png.file", new Object[0]));
            } else if (iArr[i2] == this.f26626a.read()) {
                i2++;
            } else {
                throw new IOException(MessageLocalization.b("file.is.not.a.valid.png", new Object[0]));
            }
        }
    }
}
