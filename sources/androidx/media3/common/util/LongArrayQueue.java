package androidx.media3.common.util;

import androidx.annotation.VisibleForTesting;
import java.util.NoSuchElementException;

@UnstableApi
public final class LongArrayQueue {

    /* renamed from: f  reason: collision with root package name */
    public static final int f9584f = 16;

    /* renamed from: a  reason: collision with root package name */
    private int f9585a;

    /* renamed from: b  reason: collision with root package name */
    private int f9586b;

    /* renamed from: c  reason: collision with root package name */
    private int f9587c;

    /* renamed from: d  reason: collision with root package name */
    private long[] f9588d;

    /* renamed from: e  reason: collision with root package name */
    private int f9589e;

    public LongArrayQueue() {
        this(16);
    }

    private void d() {
        long[] jArr = this.f9588d;
        int length = jArr.length << 1;
        if (length >= 0) {
            long[] jArr2 = new long[length];
            int length2 = jArr.length;
            int i2 = this.f9585a;
            int i3 = length2 - i2;
            System.arraycopy(jArr, i2, jArr2, 0, i3);
            System.arraycopy(this.f9588d, 0, jArr2, i3, i2);
            this.f9585a = 0;
            this.f9586b = this.f9587c - 1;
            this.f9588d = jArr2;
            this.f9589e = jArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }

    public void a(long j2) {
        if (this.f9587c == this.f9588d.length) {
            d();
        }
        int i2 = (this.f9586b + 1) & this.f9589e;
        this.f9586b = i2;
        this.f9588d[i2] = j2;
        this.f9587c++;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int b() {
        return this.f9588d.length;
    }

    public void c() {
        this.f9585a = 0;
        this.f9586b = -1;
        this.f9587c = 0;
    }

    public long e() {
        if (this.f9587c != 0) {
            return this.f9588d[this.f9585a];
        }
        throw new NoSuchElementException();
    }

    public boolean f() {
        return this.f9587c == 0;
    }

    public long g() {
        int i2 = this.f9587c;
        if (i2 != 0) {
            long[] jArr = this.f9588d;
            int i3 = this.f9585a;
            long j2 = jArr[i3];
            this.f9585a = this.f9589e & (i3 + 1);
            this.f9587c = i2 - 1;
            return j2;
        }
        throw new NoSuchElementException();
    }

    public int h() {
        return this.f9587c;
    }

    public LongArrayQueue(int i2) {
        Assertions.a(i2 >= 0 && i2 <= 1073741824);
        i2 = i2 == 0 ? 1 : i2;
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.f9585a = 0;
        this.f9586b = -1;
        this.f9587c = 0;
        long[] jArr = new long[i2];
        this.f9588d = jArr;
        this.f9589e = jArr.length - 1;
    }
}
