package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {

    /* renamed from: e  reason: collision with root package name */
    private static final String f17796e = "GifHeaderParser";

    /* renamed from: f  reason: collision with root package name */
    private static final int f17797f = 255;

    /* renamed from: g  reason: collision with root package name */
    private static final int f17798g = 44;

    /* renamed from: h  reason: collision with root package name */
    private static final int f17799h = 33;

    /* renamed from: i  reason: collision with root package name */
    private static final int f17800i = 59;

    /* renamed from: j  reason: collision with root package name */
    private static final int f17801j = 249;

    /* renamed from: k  reason: collision with root package name */
    private static final int f17802k = 255;

    /* renamed from: l  reason: collision with root package name */
    private static final int f17803l = 254;

    /* renamed from: m  reason: collision with root package name */
    private static final int f17804m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f17805n = 28;
    private static final int o = 2;
    private static final int p = 1;
    private static final int q = 128;
    private static final int r = 64;
    private static final int s = 7;
    private static final int t = 128;
    private static final int u = 7;
    static final int v = 2;
    static final int w = 10;
    private static final int x = 256;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f17806a = new byte[256];

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f17807b;

    /* renamed from: c  reason: collision with root package name */
    private GifHeader f17808c;

    /* renamed from: d  reason: collision with root package name */
    private int f17809d = 0;

    private boolean b() {
        return this.f17808c.f17784b != 0;
    }

    private int e() {
        try {
            return this.f17807b.get() & 255;
        } catch (Exception unused) {
            this.f17808c.f17784b = 1;
            return 0;
        }
    }

    private void f() {
        this.f17808c.f17786d.f17771a = o();
        this.f17808c.f17786d.f17772b = o();
        this.f17808c.f17786d.f17773c = o();
        this.f17808c.f17786d.f17774d = o();
        int e2 = e();
        boolean z = false;
        boolean z2 = (e2 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((e2 & 7) + 1));
        GifFrame gifFrame = this.f17808c.f17786d;
        if ((e2 & 64) != 0) {
            z = true;
        }
        gifFrame.f17775e = z;
        if (z2) {
            gifFrame.f17781k = h(pow);
        } else {
            gifFrame.f17781k = null;
        }
        this.f17808c.f17786d.f17780j = this.f17807b.position();
        t();
        if (!b()) {
            GifHeader gifHeader = this.f17808c;
            gifHeader.f17785c++;
            gifHeader.f17787e.add(gifHeader.f17786d);
        }
    }

    private void g() {
        int e2 = e();
        this.f17809d = e2;
        if (e2 > 0) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    int i4 = this.f17809d;
                    if (i2 < i4) {
                        i3 = i4 - i2;
                        this.f17807b.get(this.f17806a, i2, i3);
                        i2 += i3;
                    } else {
                        return;
                    }
                } catch (Exception e3) {
                    if (Log.isLoggable(f17796e, 3)) {
                        Log.d(f17796e, "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f17809d, e3);
                    }
                    this.f17808c.f17784b = 1;
                    return;
                }
            }
        }
    }

    @Nullable
    private int[] h(int i2) {
        byte[] bArr = new byte[(i2 * 3)];
        int[] iArr = null;
        try {
            this.f17807b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 2;
                i4 += 3;
                int i6 = i3 + 1;
                iArr[i3] = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16) | -16777216 | (bArr[i5] & 255);
                i3 = i6;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable(f17796e, 3)) {
                Log.d(f17796e, "Format Error Reading Color Table", e2);
            }
            this.f17808c.f17784b = 1;
        }
        return iArr;
    }

    private void i() {
        j(Integer.MAX_VALUE);
    }

    private void j(int i2) {
        boolean z = false;
        while (!z && !b() && this.f17808c.f17785c <= i2) {
            int e2 = e();
            if (e2 == 33) {
                int e3 = e();
                if (e3 != 1) {
                    if (e3 == f17801j) {
                        this.f17808c.f17786d = new GifFrame();
                        k();
                    } else if (e3 != 254 && e3 == 255) {
                        g();
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < 11; i3++) {
                            sb.append((char) this.f17806a[i3]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            n();
                        }
                    }
                }
                s();
            } else if (e2 == 44) {
                GifHeader gifHeader = this.f17808c;
                if (gifHeader.f17786d == null) {
                    gifHeader.f17786d = new GifFrame();
                }
                f();
            } else if (e2 != 59) {
                this.f17808c.f17784b = 1;
            } else {
                z = true;
            }
        }
    }

    private void k() {
        e();
        int e2 = e();
        GifFrame gifFrame = this.f17808c.f17786d;
        int i2 = (e2 & 28) >> 2;
        gifFrame.f17777g = i2;
        boolean z = true;
        if (i2 == 0) {
            gifFrame.f17777g = 1;
        }
        if ((e2 & 1) == 0) {
            z = false;
        }
        gifFrame.f17776f = z;
        int o2 = o();
        if (o2 < 2) {
            o2 = 10;
        }
        GifFrame gifFrame2 = this.f17808c.f17786d;
        gifFrame2.f17779i = o2 * 10;
        gifFrame2.f17778h = e();
        e();
    }

    private void l() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f17808c.f17784b = 1;
            return;
        }
        m();
        if (this.f17808c.f17790h && !b()) {
            GifHeader gifHeader = this.f17808c;
            gifHeader.f17783a = h(gifHeader.f17791i);
            GifHeader gifHeader2 = this.f17808c;
            gifHeader2.f17794l = gifHeader2.f17783a[gifHeader2.f17792j];
        }
    }

    private void m() {
        this.f17808c.f17788f = o();
        this.f17808c.f17789g = o();
        int e2 = e();
        GifHeader gifHeader = this.f17808c;
        gifHeader.f17790h = (e2 & 128) != 0;
        gifHeader.f17791i = (int) Math.pow(2.0d, (double) ((e2 & 7) + 1));
        this.f17808c.f17792j = e();
        this.f17808c.f17793k = e();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void n() {
        /*
            r3 = this;
        L_0x0000:
            r3.g()
            byte[] r0 = r3.f17806a
            r1 = 0
            byte r1 = r0[r1]
            r2 = 1
            if (r1 != r2) goto L_0x001b
            byte r1 = r0[r2]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 2
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            com.bumptech.glide.gifdecoder.GifHeader r2 = r3.f17808c
            int r0 = r0 << 8
            r0 = r0 | r1
            r2.f17795m = r0
        L_0x001b:
            int r0 = r3.f17809d
            if (r0 <= 0) goto L_0x0025
            boolean r0 = r3.b()
            if (r0 == 0) goto L_0x0000
        L_0x0025:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.n():void");
    }

    private int o() {
        return this.f17807b.getShort();
    }

    private void p() {
        this.f17807b = null;
        Arrays.fill(this.f17806a, (byte) 0);
        this.f17808c = new GifHeader();
        this.f17809d = 0;
    }

    private void s() {
        int e2;
        do {
            e2 = e();
            this.f17807b.position(Math.min(this.f17807b.position() + e2, this.f17807b.limit()));
        } while (e2 > 0);
    }

    private void t() {
        e();
        s();
    }

    public void a() {
        this.f17807b = null;
        this.f17808c = null;
    }

    public boolean c() {
        l();
        if (!b()) {
            j(2);
        }
        return this.f17808c.f17785c > 1;
    }

    @NonNull
    public GifHeader d() {
        if (this.f17807b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f17808c;
        } else {
            l();
            if (!b()) {
                i();
                GifHeader gifHeader = this.f17808c;
                if (gifHeader.f17785c < 0) {
                    gifHeader.f17784b = 1;
                }
            }
            return this.f17808c;
        }
    }

    public GifHeaderParser q(@NonNull ByteBuffer byteBuffer) {
        p();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f17807b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f17807b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser r(@Nullable byte[] bArr) {
        if (bArr != null) {
            q(ByteBuffer.wrap(bArr));
        } else {
            this.f17807b = null;
            this.f17808c.f17784b = 2;
        }
        return this;
    }
}
