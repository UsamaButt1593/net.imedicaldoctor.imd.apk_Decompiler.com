package com.itextpdf.text.pdf;

import androidx.core.app.FrameMetricsAggregator;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.io.OutputStream;

public class LZWDecoder {

    /* renamed from: a  reason: collision with root package name */
    byte[][] f26078a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f26079b = null;

    /* renamed from: c  reason: collision with root package name */
    OutputStream f26080c;

    /* renamed from: d  reason: collision with root package name */
    int f26081d;

    /* renamed from: e  reason: collision with root package name */
    int f26082e = 9;

    /* renamed from: f  reason: collision with root package name */
    int f26083f;

    /* renamed from: g  reason: collision with root package name */
    int f26084g;

    /* renamed from: h  reason: collision with root package name */
    int f26085h = 0;

    /* renamed from: i  reason: collision with root package name */
    int f26086i = 0;

    /* renamed from: j  reason: collision with root package name */
    int[] f26087j = {FrameMetricsAggregator.u, AnalyticsListener.c0, 2047, 4095};

    public void a(byte[] bArr) {
        int i2;
        byte[][] bArr2 = this.f26078a;
        int i3 = this.f26081d;
        int i4 = i3 + 1;
        this.f26081d = i4;
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
        this.f26082e = i2;
    }

    public void b(byte[] bArr, byte b2) {
        int i2;
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b2;
        byte[][] bArr3 = this.f26078a;
        int i3 = this.f26081d;
        int i4 = i3 + 1;
        this.f26081d = i4;
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
        this.f26082e = i2;
    }

    public byte[] c(byte[] bArr, byte b2) {
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b2;
        return bArr2;
    }

    public void d(byte[] bArr, OutputStream outputStream) {
        if (bArr[0] == 0 && bArr[1] == 1) {
            throw new RuntimeException(MessageLocalization.b("lzw.flavour.not.supported", new Object[0]));
        }
        f();
        this.f26079b = bArr;
        this.f26080c = outputStream;
        this.f26083f = 0;
        this.f26084g = 0;
        this.f26085h = 0;
        this.f26086i = 0;
        int i2 = 0;
        while (true) {
            int e2 = e();
            if (e2 == 257) {
                return;
            }
            if (e2 == 256) {
                f();
                i2 = e();
                if (i2 != 257) {
                    g(this.f26078a[i2]);
                } else {
                    return;
                }
            } else {
                if (e2 < this.f26081d) {
                    byte[] bArr2 = this.f26078a[e2];
                    g(bArr2);
                    b(this.f26078a[i2], bArr2[0]);
                } else {
                    byte[] bArr3 = this.f26078a[i2];
                    byte[] c2 = c(bArr3, bArr3[0]);
                    g(c2);
                    a(c2);
                }
                i2 = e2;
            }
        }
    }

    public int e() {
        try {
            byte[] bArr = this.f26079b;
            int i2 = this.f26083f;
            int i3 = i2 + 1;
            this.f26083f = i3;
            byte b2 = (this.f26085h << 8) | (bArr[i2] & 255);
            this.f26085h = b2;
            int i4 = this.f26086i;
            int i5 = i4 + 8;
            this.f26086i = i5;
            int i6 = this.f26082e;
            if (i5 < i6) {
                this.f26083f = i2 + 2;
                this.f26085h = (b2 << 8) | (bArr[i3] & 255);
                this.f26086i = i4 + 16;
            }
            int i7 = this.f26085h;
            int i8 = this.f26086i;
            int i9 = (i7 >> (i8 - i6)) & this.f26087j[i6 - 9];
            this.f26086i = i8 - i6;
            return i9;
        } catch (ArrayIndexOutOfBoundsException unused) {
            return 257;
        }
    }

    public void f() {
        this.f26078a = new byte[8192][];
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr = new byte[1];
            this.f26078a[i2] = bArr;
            bArr[0] = (byte) i2;
        }
        this.f26081d = 258;
        this.f26082e = 9;
    }

    public void g(byte[] bArr) {
        try {
            this.f26080c.write(bArr);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
