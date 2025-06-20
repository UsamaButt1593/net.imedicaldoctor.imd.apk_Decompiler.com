package com.itextpdf.text.pdf.codec;

import androidx.core.app.FrameMetricsAggregator;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.itextpdf.text.error_messages.MessageLocalization;

public class TIFFLZWDecoder {

    /* renamed from: a  reason: collision with root package name */
    byte[][] f26690a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f26691b = null;

    /* renamed from: c  reason: collision with root package name */
    byte[] f26692c;

    /* renamed from: d  reason: collision with root package name */
    int f26693d;

    /* renamed from: e  reason: collision with root package name */
    int f26694e = 9;

    /* renamed from: f  reason: collision with root package name */
    int f26695f;

    /* renamed from: g  reason: collision with root package name */
    int f26696g;

    /* renamed from: h  reason: collision with root package name */
    int f26697h;

    /* renamed from: i  reason: collision with root package name */
    int f26698i;

    /* renamed from: j  reason: collision with root package name */
    int f26699j;

    /* renamed from: k  reason: collision with root package name */
    int f26700k;

    /* renamed from: l  reason: collision with root package name */
    int f26701l;

    /* renamed from: m  reason: collision with root package name */
    int f26702m = 0;

    /* renamed from: n  reason: collision with root package name */
    int f26703n = 0;
    int[] o = {FrameMetricsAggregator.u, AnalyticsListener.c0, 2047, 4095};

    public TIFFLZWDecoder(int i2, int i3, int i4) {
        this.f26698i = i2;
        this.f26700k = i3;
        this.f26701l = i4;
    }

    public void a(byte[] bArr) {
        int i2;
        byte[][] bArr2 = this.f26690a;
        int i3 = this.f26693d;
        int i4 = i3 + 1;
        this.f26693d = i4;
        bArr2[i3] = bArr;
        if (i4 == 511) {
            i2 = 10;
        } else if (i4 == 1023) {
            i2 = 11;
        } else if (i4 == 2047) {
            i2 = 12;
        } else {
            return;
        }
        this.f26694e = i2;
    }

    public void b(byte[] bArr, byte b2) {
        int i2;
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b2;
        byte[][] bArr3 = this.f26690a;
        int i3 = this.f26693d;
        int i4 = i3 + 1;
        this.f26693d = i4;
        bArr3[i3] = bArr2;
        if (i4 == 511) {
            i2 = 10;
        } else if (i4 == 1023) {
            i2 = 11;
        } else if (i4 == 2047) {
            i2 = 12;
        } else {
            return;
        }
        this.f26694e = i2;
    }

    public byte[] c(byte[] bArr, byte b2) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b2;
        return bArr2;
    }

    public byte[] d(byte[] bArr, byte[] bArr2, int i2) {
        if (bArr[0] == 0 && bArr[1] == 1) {
            throw new UnsupportedOperationException(MessageLocalization.b("tiff.5.0.style.lzw.codes.are.not.supported", new Object[0]));
        }
        f();
        this.f26691b = bArr;
        this.f26699j = i2;
        this.f26692c = bArr2;
        this.f26695f = 0;
        this.f26696g = 0;
        this.f26697h = 0;
        this.f26702m = 0;
        this.f26703n = 0;
        int i3 = 0;
        while (true) {
            int e2 = e();
            if (e2 == 257 || this.f26697h >= bArr2.length) {
                break;
            } else if (e2 == 256) {
                f();
                i3 = e();
                if (i3 == 257) {
                    break;
                }
                g(this.f26690a[i3]);
            } else {
                if (e2 < this.f26693d) {
                    byte[] bArr3 = this.f26690a[e2];
                    g(bArr3);
                    b(this.f26690a[i3], bArr3[0]);
                } else {
                    byte[] bArr4 = this.f26690a[i3];
                    byte[] c2 = c(bArr4, bArr4[0]);
                    g(c2);
                    a(c2);
                }
                i3 = e2;
            }
        }
        if (this.f26700k == 2) {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.f26701l;
                int i6 = ((this.f26698i * i4) + 1) * i5;
                while (true) {
                    int i7 = this.f26698i;
                    int i8 = this.f26701l;
                    if (i5 >= i7 * i8) {
                        break;
                    }
                    bArr2[i6] = (byte) (bArr2[i6] + bArr2[i6 - i8]);
                    i6++;
                    i5++;
                }
            }
        }
        return bArr2;
    }

    public int e() {
        try {
            byte[] bArr = this.f26691b;
            int i2 = this.f26695f;
            int i3 = i2 + 1;
            this.f26695f = i3;
            byte b2 = (this.f26702m << 8) | (bArr[i2] & 255);
            this.f26702m = b2;
            int i4 = this.f26703n;
            int i5 = i4 + 8;
            this.f26703n = i5;
            int i6 = this.f26694e;
            if (i5 < i6) {
                this.f26695f = i2 + 2;
                this.f26702m = (b2 << 8) | (bArr[i3] & 255);
                this.f26703n = i4 + 16;
            }
            int i7 = this.f26702m;
            int i8 = this.f26703n;
            int i9 = (i7 >> (i8 - i6)) & this.o[i6 - 9];
            this.f26703n = i8 - i6;
            return i9;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return 257;
        }
    }

    public void f() {
        this.f26690a = new byte[4096][];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr = new byte[1];
            this.f26690a[i2] = bArr;
            bArr[0] = (byte) i2;
        }
        this.f26693d = 258;
        this.f26694e = 9;
    }

    public void g(byte[] bArr) {
        byte[] bArr2 = this.f26692c;
        int length = bArr2.length;
        int i2 = this.f26697h;
        int i3 = length - i2;
        if (bArr.length < i3) {
            i3 = bArr.length;
        }
        System.arraycopy(bArr, 0, bArr2, i2, i3);
        this.f26697h += i3;
    }
}
