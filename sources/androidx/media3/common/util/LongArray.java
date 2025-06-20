package androidx.media3.common.util;

import java.util.Arrays;

@UnstableApi
public final class LongArray {

    /* renamed from: c  reason: collision with root package name */
    private static final int f9581c = 32;

    /* renamed from: a  reason: collision with root package name */
    private int f9582a;

    /* renamed from: b  reason: collision with root package name */
    private long[] f9583b;

    public LongArray() {
        this(32);
    }

    public void a(long j2) {
        int i2 = this.f9582a;
        long[] jArr = this.f9583b;
        if (i2 == jArr.length) {
            this.f9583b = Arrays.copyOf(jArr, i2 * 2);
        }
        long[] jArr2 = this.f9583b;
        int i3 = this.f9582a;
        this.f9582a = i3 + 1;
        jArr2[i3] = j2;
    }

    public long b(int i2) {
        if (i2 >= 0 && i2 < this.f9582a) {
            return this.f9583b[i2];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i2 + ", size is " + this.f9582a);
    }

    public int c() {
        return this.f9582a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f9583b, this.f9582a);
    }

    public LongArray(int i2) {
        this.f9583b = new long[i2];
    }
}
