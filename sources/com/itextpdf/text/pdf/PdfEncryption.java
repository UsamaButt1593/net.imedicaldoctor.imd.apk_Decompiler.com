package com.itextpdf.text.pdf;

import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.pdf.crypto.AESCipherCBCnoPad;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;
import com.itextpdf.text.pdf.crypto.IVGenerator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public class PdfEncryption {
    static long A = System.currentTimeMillis();
    private static final int B = 32;
    private static final int C = 40;
    private static final int D = 8;
    private static final int E = 48;
    public static final int t = 2;
    public static final int u = 3;
    public static final int v = 4;
    public static final int w = 5;
    private static final byte[] x = {40, -65, 78, 94, 78, 117, -118, 65, 100, 0, 78, 86, -1, -6, 1, 8, 46, 46, 0, -74, -48, 104, DocWriter.f3, Byte.MIN_VALUE, DocWriter.g3, 12, -87, -2, 100, 83, 105, 122};
    private static final byte[] y = {115, 65, 108, 84};
    private static final byte[] z = {-1, -1, -1, -1};

    /* renamed from: a  reason: collision with root package name */
    byte[] f26210a;

    /* renamed from: b  reason: collision with root package name */
    int f26211b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f26212c;

    /* renamed from: d  reason: collision with root package name */
    byte[] f26213d;

    /* renamed from: e  reason: collision with root package name */
    byte[] f26214e;

    /* renamed from: f  reason: collision with root package name */
    byte[] f26215f;

    /* renamed from: g  reason: collision with root package name */
    byte[] f26216g;

    /* renamed from: h  reason: collision with root package name */
    byte[] f26217h;

    /* renamed from: i  reason: collision with root package name */
    long f26218i;

    /* renamed from: j  reason: collision with root package name */
    byte[] f26219j;

    /* renamed from: k  reason: collision with root package name */
    private int f26220k;

    /* renamed from: l  reason: collision with root package name */
    private int f26221l;

    /* renamed from: m  reason: collision with root package name */
    protected PdfPublicKeySecurityHandler f26222m;

    /* renamed from: n  reason: collision with root package name */
    byte[] f26223n;
    MessageDigest o;
    private ARCFOUREncryption p;
    private boolean q;
    private boolean r;
    private int s;

    public PdfEncryption() {
        this.f26212c = new byte[0];
        this.f26213d = new byte[32];
        this.f26214e = new byte[32];
        this.f26222m = null;
        this.f26223n = new byte[5];
        this.p = new ARCFOUREncryption();
        try {
            this.o = MessageDigest.getInstance("MD5");
            this.f26222m = new PdfPublicKeySecurityHandler();
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    private void A(byte[] bArr, byte[] bArr2, byte[] bArr3, long j2) {
        C(bArr, bArr2, bArr3, j2);
        D();
    }

    private void C(byte[] bArr, byte[] bArr2, byte[] bArr3, long j2) {
        this.f26219j = bArr;
        this.f26213d = bArr3;
        this.f26218i = j2;
        this.f26212c = new byte[(this.f26221l / 8)];
        this.o.reset();
        this.o.update(bArr2);
        this.o.update(bArr3);
        this.o.update(new byte[]{(byte) ((int) j2), (byte) ((int) (j2 >> 8)), (byte) ((int) (j2 >> 16)), (byte) ((int) (j2 >> 24))}, 0, 4);
        if (bArr != null) {
            this.o.update(bArr);
        }
        if (!this.q) {
            this.o.update(z);
        }
        byte[] bArr4 = new byte[this.f26212c.length];
        System.arraycopy(this.o.digest(), 0, bArr4, 0, this.f26212c.length);
        int i2 = this.f26220k;
        if (i2 == 3 || i2 == 4) {
            for (int i3 = 0; i3 < 50; i3++) {
                System.arraycopy(this.o.digest(bArr4), 0, bArr4, 0, this.f26212c.length);
            }
        }
        byte[] bArr5 = this.f26212c;
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
    }

    private void D() {
        byte[] bArr;
        int i2 = this.f26220k;
        if (i2 == 3 || i2 == 4) {
            this.o.update(x);
            byte[] digest = this.o.digest(this.f26219j);
            System.arraycopy(digest, 0, this.f26214e, 0, 16);
            for (int i3 = 16; i3 < 32; i3++) {
                this.f26214e[i3] = 0;
            }
            for (int i4 = 0; i4 < 20; i4++) {
                int i5 = 0;
                while (true) {
                    bArr = this.f26212c;
                    if (i5 >= bArr.length) {
                        break;
                    }
                    digest[i5] = (byte) (bArr[i5] ^ i4);
                    i5++;
                }
                this.p.f(digest, 0, bArr.length);
                this.p.b(this.f26214e, 0, 16);
            }
            return;
        }
        this.p.e(this.f26212c);
        this.p.d(x, this.f26214e);
    }

    private static boolean c(byte[] bArr, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[32];
        byte[] digest = this.o.digest(bArr2);
        int i2 = this.f26220k;
        if (i2 == 3 || i2 == 4) {
            int i3 = this.f26221l / 8;
            byte[] bArr4 = new byte[i3];
            for (int i4 = 0; i4 < 50; i4++) {
                this.o.update(digest, 0, i3);
                System.arraycopy(this.o.digest(), 0, digest, 0, i3);
            }
            System.arraycopy(bArr, 0, bArr3, 0, 32);
            for (int i5 = 0; i5 < 20; i5++) {
                for (int i6 = 0; i6 < i3; i6++) {
                    bArr4[i6] = (byte) (digest[i6] ^ i5);
                }
                this.p.e(bArr4);
                this.p.a(bArr3);
            }
        } else {
            this.p.f(digest, 0, 5);
            this.p.d(bArr, bArr3);
        }
        return bArr3;
    }

    public static byte[] f() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            long currentTimeMillis = System.currentTimeMillis();
            long freeMemory = Runtime.getRuntime().freeMemory();
            StringBuilder sb = new StringBuilder();
            sb.append(currentTimeMillis);
            sb.append("+");
            sb.append(freeMemory);
            sb.append("+");
            long j2 = A;
            A = 1 + j2;
            sb.append(j2);
            return instance.digest(sb.toString().getBytes());
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static PdfObject g(byte[] bArr, boolean z2) throws IOException {
        ByteBuffer byteBuffer = new ByteBuffer(90);
        if (bArr.length == 0) {
            bArr = f();
        }
        byteBuffer.c('[').c('<');
        for (byte q2 : bArr) {
            byteBuffer.q(q2);
        }
        byteBuffer.c('>').c('<');
        if (z2) {
            bArr = f();
        }
        for (byte q3 : bArr) {
            byteBuffer.q(q3);
        }
        byteBuffer.c('>').c(']');
        byteBuffer.close();
        return new PdfLiteral(byteBuffer.F());
    }

    private byte[] r(byte[] bArr) {
        byte[] bArr2 = new byte[32];
        if (bArr == null) {
            System.arraycopy(x, 0, bArr2, 0, 32);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 32));
            if (bArr.length < 32) {
                System.arraycopy(x, 0, bArr2, bArr.length, 32 - bArr.length);
            }
        }
        return bArr2;
    }

    private void y(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j2) {
        C(bArr, d(bArr4, bArr2), bArr4, j2);
        D();
    }

    public void B(byte[] bArr, byte[] bArr2, byte[] bArr3, long j2) {
        A(bArr, r(bArr2), bArr3, j2);
    }

    public void a(Certificate certificate, int i2) {
        this.f26219j = f();
        this.f26222m.a(new PdfPublicKeyRecipient(certificate, i2));
    }

    public int b(int i2) {
        int i3 = this.f26220k;
        return (i3 == 4 || i3 == 5) ? (i2 & 2147483632) + 32 : i2;
    }

    public byte[] e(byte[] bArr) {
        byte[] d2 = d(this.f26213d, r(bArr));
        int i2 = 0;
        while (i2 < d2.length) {
            int i3 = 0;
            while (i3 < d2.length - i2) {
                if (d2[i2 + i3] != x[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(d2, 0, bArr2, 0, i2);
            return bArr2;
        }
        return d2;
    }

    public byte[] h(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            StandardDecryption k2 = k();
            byte[] b2 = k2.b(bArr, 0, bArr.length);
            if (b2 != null) {
                byteArrayOutputStream.write(b2);
            }
            byte[] a2 = k2.a();
            if (a2 != null) {
                byteArrayOutputStream.write(a2);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public byte[] i(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamEncryption m2 = m(byteArrayOutputStream);
            m2.write(bArr);
            m2.b();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public int j() {
        return this.s;
    }

    public StandardDecryption k() {
        return new StandardDecryption(this.f26210a, 0, this.f26211b, this.f26220k);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0104 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010d A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0122 A[Catch:{ Exception -> 0x010b }, LOOP:0: B:41:0x011a->B:43:0x0122, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0131 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0145  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfDictionary l() {
        /*
            r12 = this;
            com.itextpdf.text.pdf.PdfDictionary r0 = new com.itextpdf.text.pdf.PdfDictionary
            r0.<init>()
            com.itextpdf.text.pdf.PdfPublicKeySecurityHandler r1 = r12.f26222m
            int r1 = r1.f()
            r2 = 256(0x100, float:3.59E-43)
            r3 = 3
            r4 = 1
            r5 = 128(0x80, float:1.794E-43)
            r6 = 2
            r7 = 4
            r8 = 5
            if (r1 <= 0) goto L_0x0159
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.T7
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.yd
            r0.V0(r1, r9)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Dd
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            int r10 = r12.f26220k
            r9.<init>((int) r10)
            r0.V0(r1, r9)
            com.itextpdf.text.pdf.PdfPublicKeySecurityHandler r9 = r12.f26222m     // Catch:{ Exception -> 0x0152 }
            com.itextpdf.text.pdf.PdfArray r9 = r9.e()     // Catch:{ Exception -> 0x0152 }
            int r10 = r12.f26220k
            if (r10 != r6) goto L_0x004b
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r4)
        L_0x003a:
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.zf
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.v3
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Md
            r0.V0(r1, r9)
            goto L_0x0100
        L_0x004b:
            if (r10 != r3) goto L_0x0063
            boolean r3 = r12.q
            if (r3 == 0) goto L_0x0063
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r6)
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r5)
            goto L_0x003a
        L_0x0063:
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            if (r10 != r8) goto L_0x0078
            r3.<init>((int) r8)
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            r3.<init>((int) r8)
        L_0x0074:
            r0.V0(r1, r3)
            goto L_0x0086
        L_0x0078:
            r3.<init>((int) r7)
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            r3.<init>((int) r7)
            goto L_0x0074
        L_0x0086:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.zf
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.w3
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfDictionary r1 = new com.itextpdf.text.pdf.PdfDictionary
            r1.<init>()
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Md
            r1.V0(r3, r9)
            boolean r3 = r12.q
            if (r3 != 0) goto L_0x00a2
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.o7
            com.itextpdf.text.pdf.PdfBoolean r6 = com.itextpdf.text.pdf.PdfBoolean.k3
            r1.V0(r3, r6)
        L_0x00a2:
            int r3 = r12.f26220k
            if (r3 != r7) goto L_0x00b8
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.B3
            r1.V0(r2, r3)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            r3.<init>((int) r5)
        L_0x00b4:
            r1.V0(r2, r3)
            goto L_0x00d1
        L_0x00b8:
            if (r3 != r8) goto L_0x00cc
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.C3
            r1.V0(r3, r5)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfNumber r5 = new com.itextpdf.text.pdf.PdfNumber
            r5.<init>((int) r2)
            r1.V0(r3, r5)
            goto L_0x00d1
        L_0x00cc:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.lh
            goto L_0x00b4
        L_0x00d1:
            com.itextpdf.text.pdf.PdfDictionary r2 = new com.itextpdf.text.pdf.PdfDictionary
            r2.<init>()
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.q6
            r2.V0(r3, r1)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.c5
            r0.V0(r1, r2)
            boolean r1 = r12.r
            if (r1 == 0) goto L_0x00f6
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f7
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.sf
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.B9
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.rf
            r0.V0(r1, r2)
            goto L_0x0100
        L_0x00f6:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.sf
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.rf
            r0.V0(r1, r3)
        L_0x0100:
            int r1 = r12.f26220k     // Catch:{ Exception -> 0x010b }
            if (r1 != r8) goto L_0x010d
            java.lang.String r1 = "SHA-256"
        L_0x0106:
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x010b }
            goto L_0x0110
        L_0x010b:
            r0 = move-exception
            goto L_0x014c
        L_0x010d:
            java.lang.String r1 = "SHA-1"
            goto L_0x0106
        L_0x0110:
            com.itextpdf.text.pdf.PdfPublicKeySecurityHandler r2 = r12.f26222m     // Catch:{ Exception -> 0x010b }
            byte[] r2 = r2.g()     // Catch:{ Exception -> 0x010b }
            r1.update(r2)     // Catch:{ Exception -> 0x010b }
            r2 = 0
        L_0x011a:
            com.itextpdf.text.pdf.PdfPublicKeySecurityHandler r3 = r12.f26222m     // Catch:{ Exception -> 0x010b }
            int r3 = r3.f()     // Catch:{ Exception -> 0x010b }
            if (r2 >= r3) goto L_0x012d
            com.itextpdf.text.pdf.PdfPublicKeySecurityHandler r3 = r12.f26222m     // Catch:{ Exception -> 0x010b }
            byte[] r3 = r3.d(r2)     // Catch:{ Exception -> 0x010b }
            r1.update(r3)     // Catch:{ Exception -> 0x010b }
            int r2 = r2 + r4
            goto L_0x011a
        L_0x012d:
            boolean r2 = r12.q     // Catch:{ Exception -> 0x010b }
            if (r2 != 0) goto L_0x0139
            byte[] r2 = new byte[r7]     // Catch:{ Exception -> 0x010b }
            r2 = {-1, -1, -1, -1} // fill-array     // Catch:{ Exception -> 0x010b }
            r1.update(r2)     // Catch:{ Exception -> 0x010b }
        L_0x0139:
            byte[] r1 = r1.digest()
            int r2 = r12.f26220k
            if (r2 != r8) goto L_0x0145
            r12.f26210a = r1
            goto L_0x02de
        L_0x0145:
            int r2 = r12.f26221l
            r12.x(r1, r2)
            goto L_0x02de
        L_0x014c:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x0152:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x0159:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.T7
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.lf
            r0.V0(r1, r9)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Lb
            com.itextpdf.text.pdf.PdfLiteral r9 = new com.itextpdf.text.pdf.PdfLiteral
            byte[] r10 = r12.f26213d
            byte[] r10 = com.itextpdf.text.pdf.StringUtils.c(r10)
            r9.<init>((byte[]) r10)
            r0.V0(r1, r9)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Og
            com.itextpdf.text.pdf.PdfLiteral r9 = new com.itextpdf.text.pdf.PdfLiteral
            byte[] r10 = r12.f26214e
            byte[] r10 = com.itextpdf.text.pdf.StringUtils.c(r10)
            r9.<init>((byte[]) r10)
            r0.V0(r1, r9)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.tc
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            long r10 = r12.f26218i
            r9.<init>((long) r10)
            r0.V0(r1, r9)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Dd
            com.itextpdf.text.pdf.PdfNumber r9 = new com.itextpdf.text.pdf.PdfNumber
            int r10 = r12.f26220k
            r9.<init>((int) r10)
            r0.V0(r1, r9)
            int r9 = r12.f26220k
            if (r9 != r6) goto L_0x01a8
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r4)
        L_0x01a3:
            r0.V0(r1, r2)
            goto L_0x02de
        L_0x01a8:
            if (r9 != r3) goto L_0x01c0
            boolean r3 = r12.q
            if (r3 == 0) goto L_0x01c0
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r6)
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r5)
            goto L_0x01a3
        L_0x01c0:
            if (r9 != r8) goto L_0x0265
            boolean r1 = r12.q
            if (r1 != 0) goto L_0x01cd
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.o7
            com.itextpdf.text.pdf.PdfBoolean r3 = com.itextpdf.text.pdf.PdfBoolean.k3
            r0.V0(r1, r3)
        L_0x01cd:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Wb
            com.itextpdf.text.pdf.PdfLiteral r3 = new com.itextpdf.text.pdf.PdfLiteral
            byte[] r4 = r12.f26215f
            byte[] r4 = com.itextpdf.text.pdf.StringUtils.c(r4)
            r3.<init>((byte[]) r4)
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Pg
            com.itextpdf.text.pdf.PdfLiteral r3 = new com.itextpdf.text.pdf.PdfLiteral
            byte[] r4 = r12.f26216g
            byte[] r4 = com.itextpdf.text.pdf.StringUtils.c(r4)
            r3.<init>((byte[]) r4)
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Qc
            com.itextpdf.text.pdf.PdfLiteral r3 = new com.itextpdf.text.pdf.PdfLiteral
            byte[] r4 = r12.f26217h
            byte[] r4 = com.itextpdf.text.pdf.StringUtils.c(r4)
            r3.<init>((byte[]) r4)
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            int r4 = r12.f26220k
            r3.<init>((int) r4)
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            r3.<init>((int) r2)
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfDictionary r2 = new com.itextpdf.text.pdf.PdfDictionary
            r2.<init>()
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            r4 = 32
            r3.<init>((int) r4)
            r2.V0(r1, r3)
            boolean r1 = r12.r
            if (r1 == 0) goto L_0x0241
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f4
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.g7
            r2.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f7
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.pf
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.sf
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.B9
        L_0x0238:
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.rf
            r0.V0(r1, r3)
            goto L_0x024d
        L_0x0241:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f4
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.N6
            r2.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.sf
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.pf
            goto L_0x0238
        L_0x024d:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.C3
            r2.V0(r1, r3)
            com.itextpdf.text.pdf.PdfDictionary r1 = new com.itextpdf.text.pdf.PdfDictionary
            r1.<init>()
        L_0x0259:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.pf
            r1.V0(r3, r2)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.c5
            r0.V0(r2, r1)
            goto L_0x02de
        L_0x0265:
            boolean r2 = r12.q
            if (r2 != 0) goto L_0x0270
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.o7
            com.itextpdf.text.pdf.PdfBoolean r3 = com.itextpdf.text.pdf.PdfBoolean.k3
            r0.V0(r2, r3)
        L_0x0270:
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r7)
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r7)
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            r2.<init>((int) r5)
            r0.V0(r1, r2)
            com.itextpdf.text.pdf.PdfDictionary r2 = new com.itextpdf.text.pdf.PdfDictionary
            r2.<init>()
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            r4 = 16
            r3.<init>((int) r4)
            r2.V0(r1, r3)
            boolean r1 = r12.r
            if (r1 == 0) goto L_0x02ba
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f4
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.g7
            r2.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f7
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.pf
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.sf
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.B9
        L_0x02b1:
            r0.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.rf
            r0.V0(r1, r3)
            goto L_0x02c6
        L_0x02ba:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f4
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.N6
            r2.V0(r1, r3)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.sf
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.pf
            goto L_0x02b1
        L_0x02c6:
            int r1 = r12.f26220k
            if (r1 != r7) goto L_0x02d2
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.B3
        L_0x02ce:
            r2.V0(r1, r3)
            goto L_0x02d7
        L_0x02d2:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.lh
            goto L_0x02ce
        L_0x02d7:
            com.itextpdf.text.pdf.PdfDictionary r1 = new com.itextpdf.text.pdf.PdfDictionary
            r1.<init>()
            goto L_0x0259
        L_0x02de:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfEncryption.l():com.itextpdf.text.pdf.PdfDictionary");
    }

    public OutputStreamEncryption m(OutputStream outputStream) {
        return new OutputStreamEncryption(outputStream, this.f26210a, 0, this.f26211b, this.f26220k);
    }

    public PdfObject n(boolean z2) throws IOException {
        return g(this.f26219j, z2);
    }

    public long o() {
        return this.f26218i;
    }

    public boolean p() {
        return this.r;
    }

    public boolean q() {
        return this.q;
    }

    public boolean s(PdfDictionary pdfDictionary, byte[] bArr) throws BadPasswordException {
        boolean z2 = false;
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (BadPasswordException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new ExceptionConverter(e3);
            }
        }
        byte[] E2 = DocWriter.E(pdfDictionary.d0(PdfName.Lb).toString());
        byte[] E3 = DocWriter.E(pdfDictionary.d0(PdfName.Og).toString());
        byte[] E4 = DocWriter.E(pdfDictionary.d0(PdfName.Wb).toString());
        byte[] E5 = DocWriter.E(pdfDictionary.d0(PdfName.Pg).toString());
        byte[] E6 = DocWriter.E(pdfDictionary.d0(PdfName.Qc).toString());
        this.f26215f = E4;
        this.f26216g = E5;
        this.f26217h = E6;
        this.f26213d = E2;
        this.f26214e = E3;
        this.f26218i = ((PdfNumber) pdfDictionary.d0(PdfName.tc)).i0();
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.update(bArr, 0, Math.min(bArr.length, WorkQueueKt.f29430c));
        instance.update(E2, 32, 8);
        instance.update(E3, 0, 48);
        boolean c2 = c(instance.digest(), E2, 32);
        if (c2) {
            instance.update(bArr, 0, Math.min(bArr.length, WorkQueueKt.f29430c));
            instance.update(E2, 40, 8);
            instance.update(E3, 0, 48);
            this.f26210a = new AESCipherCBCnoPad(false, instance.digest()).a(E4, 0, E4.length);
        } else {
            instance.update(bArr, 0, Math.min(bArr.length, WorkQueueKt.f29430c));
            instance.update(E3, 32, 8);
            if (c(instance.digest(), E3, 32)) {
                instance.update(bArr, 0, Math.min(bArr.length, WorkQueueKt.f29430c));
                instance.update(E3, 40, 8);
                this.f26210a = new AESCipherCBCnoPad(false, instance.digest()).a(E5, 0, E5.length);
            } else {
                throw new BadPasswordException(MessageLocalization.b("bad.user.password", new Object[0]));
            }
        }
        byte[] a2 = new AESCipherCBCnoPad(false, this.f26210a).a(E6, 0, E6.length);
        if (a2[9] == 97 && a2[10] == 100 && a2[11] == 98) {
            byte b2 = (a2[0] & 255) | ((a2[1] & 255) << 8);
            byte b3 = a2[2];
            this.f26218i = (long) (b2 | ((b3 & 255) << 16) | ((b3 & 255) << Ascii.B));
            if (a2[8] == 84) {
                z2 = true;
            }
            this.q = z2;
            return c2;
        }
        throw new BadPasswordException(MessageLocalization.b("bad.user.password", new Object[0]));
    }

    public void t(int i2, int i3) {
        int i4;
        this.s = i2;
        this.q = (i2 & 8) != 8;
        this.r = (i2 & 24) == 24;
        int i5 = i2 & 7;
        if (i5 == 0) {
            this.q = true;
            this.r = false;
            this.f26221l = 40;
            this.f26220k = 2;
        } else if (i5 != 1) {
            if (i5 == 2) {
                this.f26221l = 128;
                i4 = 4;
            } else if (i5 == 3) {
                this.f26221l = 256;
                this.f26211b = 32;
                i4 = 5;
            } else {
                throw new IllegalArgumentException(MessageLocalization.b("no.valid.encryption.mode", new Object[0]));
            }
            this.f26220k = i4;
        } else {
            this.r = false;
            if (i3 > 0) {
                this.f26221l = i3;
            } else {
                this.f26221l = 128;
            }
            this.f26220k = 3;
        }
    }

    public void u(int i2, int i3) {
        if (this.f26220k != 5) {
            this.o.reset();
            byte[] bArr = this.f26223n;
            bArr[0] = (byte) i2;
            bArr[1] = (byte) (i2 >> 8);
            bArr[2] = (byte) (i2 >> 16);
            bArr[3] = (byte) i3;
            bArr[4] = (byte) (i3 >> 8);
            this.o.update(this.f26212c);
            this.o.update(this.f26223n);
            if (this.f26220k == 4) {
                this.o.update(y);
            }
            this.f26210a = this.o.digest();
            int length = this.f26212c.length + 5;
            this.f26211b = length;
            if (length > 16) {
                this.f26211b = 16;
            }
        }
    }

    public void v(byte[] bArr) {
        this.f26210a = bArr;
    }

    public void w(byte[] bArr, byte[] bArr2, int i2) {
        byte[] bArr3;
        byte[] bArr4 = bArr2;
        if (bArr4 == null || bArr4.length == 0) {
            bArr4 = this.o.digest(f());
        }
        int i3 = this.f26220k;
        int i4 = (i2 | ((i3 == 3 || i3 == 4 || i3 == 5) ? -3904 : -64)) & -4;
        long j2 = (long) i4;
        this.f26218i = j2;
        if (i3 == 5) {
            if (bArr == null) {
                try {
                    bArr3 = new byte[0];
                } catch (Exception e2) {
                    throw new ExceptionConverter(e2);
                }
            } else {
                bArr3 = bArr;
            }
            this.f26219j = f();
            byte[] b2 = IVGenerator.b(8);
            byte[] b3 = IVGenerator.b(8);
            this.f26210a = IVGenerator.b(32);
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(bArr3, 0, Math.min(bArr3.length, WorkQueueKt.f29430c));
            instance.update(b2);
            byte[] bArr5 = new byte[48];
            this.f26214e = bArr5;
            instance.digest(bArr5, 0, 32);
            System.arraycopy(b2, 0, this.f26214e, 32, 8);
            System.arraycopy(b3, 0, this.f26214e, 40, 8);
            instance.update(bArr3, 0, Math.min(bArr3.length, WorkQueueKt.f29430c));
            instance.update(b3);
            AESCipherCBCnoPad aESCipherCBCnoPad = new AESCipherCBCnoPad(true, instance.digest());
            byte[] bArr6 = this.f26210a;
            this.f26216g = aESCipherCBCnoPad.a(bArr6, 0, bArr6.length);
            byte[] b4 = IVGenerator.b(8);
            byte[] b5 = IVGenerator.b(8);
            instance.update(bArr4, 0, Math.min(bArr4.length, WorkQueueKt.f29430c));
            instance.update(b4);
            instance.update(this.f26214e);
            byte[] bArr7 = new byte[48];
            this.f26213d = bArr7;
            instance.digest(bArr7, 0, 32);
            System.arraycopy(b4, 0, this.f26213d, 32, 8);
            System.arraycopy(b5, 0, this.f26213d, 40, 8);
            instance.update(bArr4, 0, Math.min(bArr4.length, WorkQueueKt.f29430c));
            instance.update(b5);
            instance.update(this.f26214e);
            AESCipherCBCnoPad aESCipherCBCnoPad2 = new AESCipherCBCnoPad(true, instance.digest());
            byte[] bArr8 = this.f26210a;
            this.f26215f = aESCipherCBCnoPad2.a(bArr8, 0, bArr8.length);
            byte[] b6 = IVGenerator.b(16);
            b6[0] = (byte) i4;
            b6[1] = (byte) (i4 >> 8);
            b6[2] = (byte) -1;
            b6[3] = (byte) -1;
            b6[4] = -1;
            b6[5] = -1;
            b6[6] = -1;
            b6[7] = -1;
            b6[8] = this.q ? (byte) 84 : 70;
            b6[9] = 97;
            b6[10] = 100;
            b6[11] = 98;
            this.f26217h = new AESCipherCBCnoPad(true, this.f26210a).a(b6, 0, b6.length);
            return;
        }
        byte[] r2 = r(bArr);
        this.f26213d = d(r2, r(bArr4));
        byte[] f2 = f();
        this.f26219j = f2;
        A(f2, r2, this.f26213d, j2);
    }

    public void x(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[(i2 / 8)];
        this.f26212c = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
    }

    public void z(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j2) {
        y(bArr, r(bArr2), bArr3, bArr4, j2);
    }

    public PdfEncryption(PdfEncryption pdfEncryption) {
        this();
        byte[] bArr = pdfEncryption.f26210a;
        if (bArr != null) {
            this.f26210a = (byte[]) bArr.clone();
        }
        this.f26211b = pdfEncryption.f26211b;
        this.f26212c = (byte[]) pdfEncryption.f26212c.clone();
        this.f26213d = (byte[]) pdfEncryption.f26213d.clone();
        this.f26214e = (byte[]) pdfEncryption.f26214e.clone();
        this.f26218i = pdfEncryption.f26218i;
        byte[] bArr2 = pdfEncryption.f26219j;
        if (bArr2 != null) {
            this.f26219j = (byte[]) bArr2.clone();
        }
        this.f26220k = pdfEncryption.f26220k;
        this.f26221l = pdfEncryption.f26221l;
        this.q = pdfEncryption.q;
        this.r = pdfEncryption.r;
        this.f26222m = pdfEncryption.f26222m;
        byte[] bArr3 = pdfEncryption.f26216g;
        if (bArr3 != null) {
            this.f26216g = (byte[]) bArr3.clone();
        }
        byte[] bArr4 = pdfEncryption.f26215f;
        if (bArr4 != null) {
            this.f26215f = (byte[]) bArr4.clone();
        }
        byte[] bArr5 = pdfEncryption.f26217h;
        if (bArr5 != null) {
            this.f26217h = (byte[]) bArr5.clone();
        }
    }
}
