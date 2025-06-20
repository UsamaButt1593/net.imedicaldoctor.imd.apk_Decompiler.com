package com.itextpdf.text.pdf.codec;

import androidx.fragment.app.FragmentTransaction;
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
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GifImage {
    protected static final int I = 4096;
    protected int A;
    protected byte[] B;
    protected byte[] C;
    protected byte[] D;
    protected int E;
    protected byte[] F;
    protected URL G;
    protected ArrayList<GifFrame> H;

    /* renamed from: a  reason: collision with root package name */
    protected DataInputStream f26569a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26570b;

    /* renamed from: c  reason: collision with root package name */
    protected int f26571c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f26572d;

    /* renamed from: e  reason: collision with root package name */
    protected int f26573e;

    /* renamed from: f  reason: collision with root package name */
    protected int f26574f;

    /* renamed from: g  reason: collision with root package name */
    protected int f26575g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f26576h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f26577i;

    /* renamed from: j  reason: collision with root package name */
    protected int f26578j;

    /* renamed from: k  reason: collision with root package name */
    protected int f26579k;

    /* renamed from: l  reason: collision with root package name */
    protected int f26580l;

    /* renamed from: m  reason: collision with root package name */
    protected int f26581m;

    /* renamed from: n  reason: collision with root package name */
    protected int f26582n;
    protected byte[] o;
    protected int p;
    protected int q;
    protected boolean r;
    protected int s;
    protected int t;
    protected short[] u;
    protected byte[] v;
    protected byte[] w;
    protected byte[] x;
    protected byte[] y;
    protected int z;

    static class GifFrame {

        /* renamed from: a  reason: collision with root package name */
        Image f26583a;

        /* renamed from: b  reason: collision with root package name */
        int f26584b;

        /* renamed from: c  reason: collision with root package name */
        int f26585c;

        GifFrame() {
        }
    }

    public GifImage(InputStream inputStream) throws IOException {
        this.o = new byte[256];
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = 0;
        this.H = new ArrayList<>();
        g(inputStream);
    }

    protected static int f(int i2) {
        if (!(i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                return 4;
            }
            if (i2 != 4) {
                return 8;
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public boolean a() throws IOException {
        int i2;
        int i3;
        int i4;
        byte b2;
        int i5;
        byte b3;
        short s2;
        int i6 = this.f26581m;
        int i7 = this.f26582n;
        int i8 = i6 * i7;
        if (this.u == null) {
            this.u = new short[4096];
        }
        if (this.v == null) {
            this.v = new byte[4096];
        }
        if (this.w == null) {
            this.w = new byte[FragmentTransaction.I];
        }
        int i9 = 8;
        int i10 = ((i6 * this.z) + 7) / 8;
        this.E = i10;
        this.y = new byte[(i10 * i7)];
        boolean z2 = true;
        if (!this.f26577i) {
            i9 = 1;
        }
        int read = this.f26569a.read();
        int i11 = 1 << read;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = read + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.u[i16] = 0;
            this.v[i16] = (byte) i16;
        }
        int i17 = i14;
        int i18 = i13;
        int i19 = i15;
        byte b4 = -1;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        byte b5 = 0;
        int i26 = 1;
        int i27 = 0;
        int i28 = 0;
        while (i20 < i8) {
            if (i21 == 0) {
                if (i22 >= i17) {
                    byte b6 = i23 & i19;
                    i23 >>= i17;
                    i22 -= i17;
                    if (b6 > i18 || b6 == i12) {
                        break;
                    } else if (b6 == i11) {
                        i17 = i14;
                        i18 = i13;
                        i19 = i15;
                        z2 = true;
                        b4 = -1;
                    } else if (b4 == -1) {
                        this.w[i21] = this.v[b6];
                        b4 = b6;
                        b5 = b4;
                        i21++;
                        i14 = i14;
                        z2 = true;
                    } else {
                        i2 = i14;
                        if (b6 == i18) {
                            b3 = b6;
                            this.w[i21] = (byte) b5;
                            s2 = b4;
                            i21++;
                        } else {
                            b3 = b6;
                            s2 = b3;
                        }
                        while (s2 > i11) {
                            this.w[i21] = this.v[s2];
                            s2 = this.u[s2];
                            i21++;
                            i8 = i8;
                        }
                        i4 = i8;
                        byte[] bArr = this.v;
                        b2 = bArr[s2] & 255;
                        if (i18 >= 4096) {
                            break;
                        }
                        int i29 = i21 + 1;
                        i3 = i11;
                        byte b7 = (byte) b2;
                        this.w[i21] = b7;
                        this.u[i18] = (short) b4;
                        bArr[i18] = b7;
                        i18++;
                        if ((i18 & i19) == 0 && i18 < 4096) {
                            i17++;
                            i19 += i18;
                        }
                        i21 = i29;
                        b4 = b3;
                    }
                } else {
                    if (i24 == 0) {
                        i24 = h();
                        if (i24 <= 0) {
                            return z2;
                        }
                        i25 = 0;
                    }
                    i23 += (this.o[i25] & 255) << i22;
                    i22 += 8;
                    i25++;
                    i24--;
                }
            } else {
                i2 = i14;
                i3 = i11;
                byte b8 = b5;
                i4 = i8;
                b2 = b8;
            }
            i21--;
            i20++;
            int i30 = i27;
            int i31 = i28;
            q(i31, i30, this.w[i21]);
            int i32 = i31 + 1;
            if (i32 >= this.f26581m) {
                int i33 = i30 + i9;
                int i34 = this.f26582n;
                if (i33 < i34) {
                    i27 = i33;
                } else if (this.f26577i) {
                    do {
                        int i35 = i26 + 1;
                        i5 = 4;
                        if (i35 != 2) {
                            if (i35 == 3) {
                                i9 = 4;
                                i5 = 2;
                            } else if (i35 != 4) {
                                i5 = this.f26582n - 1;
                                i9 = 0;
                            } else {
                                i9 = 2;
                                i5 = 1;
                            }
                        }
                        i26 = i35;
                    } while (i5 >= this.f26582n);
                    i27 = i5;
                } else {
                    i27 = i34 - 1;
                    i8 = i4;
                    i11 = i3;
                    z2 = true;
                    i9 = 0;
                    i28 = 0;
                }
                i8 = i4;
                i11 = i3;
                z2 = true;
                i28 = 0;
            } else {
                i28 = i32;
                i27 = i30;
                i8 = i4;
                i11 = i3;
                z2 = true;
            }
            b5 = b2;
            i14 = i2;
        }
        return false;
    }

    public int b() {
        return this.H.size();
    }

    public int[] c(int i2) {
        GifFrame gifFrame = this.H.get(i2 - 1);
        return new int[]{gifFrame.f26584b, gifFrame.f26585c};
    }

    public Image d(int i2) {
        return this.H.get(i2 - 1).f26583a;
    }

    public int[] e() {
        return new int[]{this.f26570b, this.f26571c};
    }

    /* access modifiers changed from: package-private */
    public void g(InputStream inputStream) throws IOException {
        this.f26569a = new DataInputStream(new BufferedInputStream(inputStream));
        l();
        j();
        if (this.H.isEmpty()) {
            throw new IOException(MessageLocalization.b("the.file.does.not.contain.any.valid.image", new Object[0]));
        }
    }

    /* access modifiers changed from: protected */
    public int h() throws IOException {
        int read = this.f26569a.read();
        this.p = read;
        if (read <= 0) {
            this.p = 0;
            return 0;
        }
        int read2 = this.f26569a.read(this.o, 0, read);
        this.p = read2;
        return read2;
    }

    /* access modifiers changed from: protected */
    public byte[] i(int i2) throws IOException {
        byte[] bArr = new byte[((1 << f(i2)) * 3)];
        this.f26569a.readFully(bArr, 0, (1 << i2) * 3);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void j() throws IOException {
        boolean z2 = false;
        while (!z2) {
            int read = this.f26569a.read();
            if (read == 33) {
                int read2 = this.f26569a.read();
                if (read2 != 249) {
                    if (read2 == 255) {
                        h();
                    }
                    r();
                } else {
                    k();
                }
            } else if (read != 44) {
                z2 = true;
            } else {
                m();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k() throws IOException {
        this.f26569a.read();
        int read = this.f26569a.read();
        int i2 = (read & 28) >> 2;
        this.q = i2;
        boolean z2 = true;
        if (i2 == 0) {
            this.q = 1;
        }
        if ((read & 1) == 0) {
            z2 = false;
        }
        this.r = z2;
        this.s = o() * 10;
        this.t = this.f26569a.read();
        this.f26569a.read();
    }

    /* access modifiers changed from: protected */
    public void l() throws IOException {
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) this.f26569a.read());
        }
        if (sb.toString().startsWith("GIF8")) {
            n();
            if (this.f26572d) {
                this.B = i(this.A);
                return;
            }
            return;
        }
        throw new IOException(MessageLocalization.b("gif.signature.nor.found", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public void m() throws IOException {
        this.f26579k = o();
        this.f26580l = o();
        this.f26581m = o();
        this.f26582n = o();
        int read = this.f26569a.read();
        this.f26576h = (read & 128) != 0;
        this.f26577i = (read & 64) != 0;
        int i2 = read & 7;
        this.f26578j = 2 << i2;
        this.z = f(this.A);
        if (this.f26576h) {
            int i3 = i2 + 1;
            this.D = i(i3);
            this.z = f(i3);
        } else {
            this.D = this.B;
        }
        if (this.r && this.t >= this.D.length / 3) {
            this.r = false;
        }
        if (this.r && this.z == 1) {
            byte[] bArr = new byte[12];
            System.arraycopy(this.D, 0, bArr, 0, 6);
            this.D = bArr;
            this.z = 2;
        }
        if (!a()) {
            r();
        }
        try {
            ImgRaw imgRaw = new ImgRaw(this.f26581m, this.f26582n, 1, this.z, this.y);
            PdfArray pdfArray = new PdfArray();
            pdfArray.a0(PdfName.N9);
            pdfArray.a0(PdfName.B6);
            pdfArray.a0(new PdfNumber((this.D.length / 3) - 1));
            pdfArray.a0(new PdfString(this.D));
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.V0(PdfName.w5, pdfArray);
            imgRaw.W1(pdfDictionary);
            if (this.r) {
                int i4 = this.t;
                imgRaw.r2(new int[]{i4, i4});
            }
            imgRaw.k2(3);
            imgRaw.j2(this.F);
            imgRaw.s2(this.G);
            GifFrame gifFrame = new GifFrame();
            gifFrame.f26583a = imgRaw;
            gifFrame.f26584b = this.f26579k;
            gifFrame.f26585c = this.f26580l;
            this.H.add(gifFrame);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void n() throws IOException {
        this.f26570b = o();
        this.f26571c = o();
        int read = this.f26569a.read();
        this.f26572d = (read & 128) != 0;
        this.A = (read & 7) + 1;
        this.f26573e = this.f26569a.read();
        this.f26575g = this.f26569a.read();
    }

    /* access modifiers changed from: protected */
    public int o() throws IOException {
        return this.f26569a.read() | (this.f26569a.read() << 8);
    }

    /* access modifiers changed from: protected */
    public void p() {
    }

    /* access modifiers changed from: protected */
    public void q(int i2, int i3, int i4) {
        int i5 = this.z;
        if (i5 == 8) {
            this.y[i2 + (this.f26581m * i3)] = (byte) i4;
            return;
        }
        int i6 = (this.E * i3) + (i2 / (8 / i5));
        byte[] bArr = this.y;
        bArr[i6] = (byte) ((i4 << ((8 - ((i2 % (8 / i5)) * i5)) - i5)) | bArr[i6]);
    }

    /* access modifiers changed from: protected */
    public void r() throws IOException {
        do {
            h();
        } while (this.p > 0);
    }

    public GifImage(String str) throws IOException {
        this(Utilities.w(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifImage(java.net.URL r7) throws java.io.IOException {
        /*
            r6 = this;
            r6.<init>()
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r6.o = r0
            r0 = 0
            r6.p = r0
            r6.q = r0
            r6.r = r0
            r6.s = r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r6.H = r1
            r6.G = r7
            java.io.InputStream r7 = r7.openStream()     // Catch:{ all -> 0x0053 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0033 }
            r1.<init>()     // Catch:{ all -> 0x0033 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x0033 }
        L_0x0028:
            int r3 = r7.read(r2)     // Catch:{ all -> 0x0033 }
            r4 = -1
            if (r3 == r4) goto L_0x0035
            r1.write(r2, r0, r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0028
        L_0x0033:
            r0 = move-exception
            goto L_0x0055
        L_0x0035:
            r7.close()     // Catch:{ all -> 0x0033 }
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0033 }
            byte[] r2 = r1.toByteArray()     // Catch:{ all -> 0x0033 }
            r0.<init>(r2)     // Catch:{ all -> 0x0033 }
            r1.flush()     // Catch:{ all -> 0x004e }
            r1.close()     // Catch:{ all -> 0x004e }
            r6.g(r0)     // Catch:{ all -> 0x004e }
            r0.close()
            return
        L_0x004e:
            r7 = move-exception
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x0055
        L_0x0053:
            r0 = move-exception
            r7 = 0
        L_0x0055:
            if (r7 == 0) goto L_0x005a
            r7.close()
        L_0x005a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.GifImage.<init>(java.net.URL):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifImage(byte[] r3) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r2.o = r0
            r0 = 0
            r2.p = r0
            r2.q = r0
            r2.r = r0
            r2.s = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.H = r0
            r2.F = r3
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x002b }
            r1.<init>(r3)     // Catch:{ all -> 0x002b }
            r2.g(r1)     // Catch:{ all -> 0x0028 }
            r1.close()
            return
        L_0x0028:
            r3 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r3 = move-exception
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.codec.GifImage.<init>(byte[]):void");
    }
}
