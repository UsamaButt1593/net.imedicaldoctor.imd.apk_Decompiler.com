package androidx.media3.extractor;

import androidx.media3.common.DataReader;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

@UnstableApi
public final class DefaultExtractorInput implements ExtractorInput {

    /* renamed from: i  reason: collision with root package name */
    private static final int f12986i = 65536;

    /* renamed from: j  reason: collision with root package name */
    private static final int f12987j = 524288;

    /* renamed from: k  reason: collision with root package name */
    private static final int f12988k = 4096;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f12989b = new byte[4096];

    /* renamed from: c  reason: collision with root package name */
    private final DataReader f12990c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12991d;

    /* renamed from: e  reason: collision with root package name */
    private long f12992e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f12993f = new byte[65536];

    /* renamed from: g  reason: collision with root package name */
    private int f12994g;

    /* renamed from: h  reason: collision with root package name */
    private int f12995h;

    static {
        MediaLibraryInfo.a("media3.extractor");
    }

    public DefaultExtractorInput(DataReader dataReader, long j2, long j3) {
        this.f12990c = dataReader;
        this.f12992e = j2;
        this.f12991d = j3;
    }

    private void t(int i2) {
        if (i2 != -1) {
            this.f12992e += (long) i2;
        }
    }

    private void u(int i2) {
        int i3 = this.f12994g + i2;
        byte[] bArr = this.f12993f;
        if (i3 > bArr.length) {
            this.f12993f = Arrays.copyOf(this.f12993f, Util.w(bArr.length * 2, 65536 + i3, i3 + 524288));
        }
    }

    private int v(byte[] bArr, int i2, int i3) {
        int i4 = this.f12995h;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.f12993f, 0, bArr, i2, min);
        y(min);
        return min;
    }

    private int w(byte[] bArr, int i2, int i3, int i4, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.f12990c.read(bArr, i2 + i4, i3 - i4);
            if (read != -1) {
                return i4 + read;
            }
            if (i4 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private int x(int i2) {
        int min = Math.min(this.f12995h, i2);
        y(min);
        return min;
    }

    private void y(int i2) {
        int i3 = this.f12995h - i2;
        this.f12995h = i3;
        this.f12994g = 0;
        byte[] bArr = this.f12993f;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[(65536 + i3)] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.f12993f = bArr2;
    }

    public int b(int i2) throws IOException {
        int x = x(i2);
        if (x == 0) {
            byte[] bArr = this.f12989b;
            x = w(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        t(x);
        return x;
    }

    public boolean d(byte[] bArr, int i2, int i3, boolean z) throws IOException {
        int v = v(bArr, i2, i3);
        while (v < i3 && v != -1) {
            v = w(bArr, i2, i3, v, z);
        }
        t(v);
        return v != -1;
    }

    public boolean g(int i2, boolean z) throws IOException {
        int x = x(i2);
        while (x < i2 && x != -1) {
            x = w(this.f12989b, -x, Math.min(i2, this.f12989b.length + x), x, z);
        }
        t(x);
        return x != -1;
    }

    public long getLength() {
        return this.f12991d;
    }

    public long getPosition() {
        return this.f12992e;
    }

    public boolean h(byte[] bArr, int i2, int i3, boolean z) throws IOException {
        if (!q(i3, z)) {
            return false;
        }
        System.arraycopy(this.f12993f, this.f12994g - i3, bArr, i2, i3);
        return true;
    }

    public long i() {
        return this.f12992e + ((long) this.f12994g);
    }

    public void j(int i2) throws IOException {
        q(i2, false);
    }

    public <E extends Throwable> void l(long j2, E e2) throws Throwable {
        Assertions.a(j2 >= 0);
        this.f12992e = j2;
        throw e2;
    }

    public int m(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        u(i3);
        int i5 = this.f12995h;
        int i6 = this.f12994g;
        int i7 = i5 - i6;
        if (i7 == 0) {
            i4 = w(this.f12993f, i6, i3, 0, true);
            if (i4 == -1) {
                return -1;
            }
            this.f12995h += i4;
        } else {
            i4 = Math.min(i3, i7);
        }
        System.arraycopy(this.f12993f, this.f12994g, bArr, i2, i4);
        this.f12994g += i4;
        return i4;
    }

    public void n() {
        this.f12994g = 0;
    }

    public void o(int i2) throws IOException {
        g(i2, false);
    }

    public boolean q(int i2, boolean z) throws IOException {
        u(i2);
        int i3 = this.f12995h - this.f12994g;
        while (i3 < i2) {
            i3 = w(this.f12993f, this.f12994g, i2, i3, z);
            if (i3 == -1) {
                return false;
            }
            this.f12995h = this.f12994g + i3;
        }
        this.f12994g += i2;
        return true;
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int v = v(bArr, i2, i3);
        if (v == 0) {
            v = w(bArr, i2, i3, 0, true);
        }
        t(v);
        return v;
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        d(bArr, i2, i3, false);
    }

    public void s(byte[] bArr, int i2, int i3) throws IOException {
        h(bArr, i2, i3, false);
    }
}
