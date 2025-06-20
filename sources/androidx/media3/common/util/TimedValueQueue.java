package androidx.media3.common.util;

import androidx.annotation.Nullable;
import java.util.Arrays;

@UnstableApi
public final class TimedValueQueue<V> {

    /* renamed from: e  reason: collision with root package name */
    private static final int f9629e = 10;

    /* renamed from: a  reason: collision with root package name */
    private long[] f9630a;

    /* renamed from: b  reason: collision with root package name */
    private V[] f9631b;

    /* renamed from: c  reason: collision with root package name */
    private int f9632c;

    /* renamed from: d  reason: collision with root package name */
    private int f9633d;

    public TimedValueQueue() {
        this(10);
    }

    private void b(long j2, V v) {
        int i2 = this.f9632c;
        int i3 = this.f9633d;
        V[] vArr = this.f9631b;
        int length = (i2 + i3) % vArr.length;
        this.f9630a[length] = j2;
        vArr[length] = v;
        this.f9633d = i3 + 1;
    }

    private void d(long j2) {
        int i2 = this.f9633d;
        if (i2 > 0) {
            if (j2 <= this.f9630a[((this.f9632c + i2) - 1) % this.f9631b.length]) {
                c();
            }
        }
    }

    private void e() {
        int length = this.f9631b.length;
        if (this.f9633d >= length) {
            int i2 = length * 2;
            long[] jArr = new long[i2];
            V[] f2 = f(i2);
            int i3 = this.f9632c;
            int i4 = length - i3;
            System.arraycopy(this.f9630a, i3, jArr, 0, i4);
            System.arraycopy(this.f9631b, this.f9632c, f2, 0, i4);
            int i5 = this.f9632c;
            if (i5 > 0) {
                System.arraycopy(this.f9630a, 0, jArr, i4, i5);
                System.arraycopy(this.f9631b, 0, f2, i4, this.f9632c);
            }
            this.f9630a = jArr;
            this.f9631b = f2;
            this.f9632c = 0;
        }
    }

    private static <V> V[] f(int i2) {
        return new Object[i2];
    }

    @Nullable
    private V h(long j2, boolean z) {
        V v = null;
        long j3 = Long.MAX_VALUE;
        while (this.f9633d > 0) {
            long j4 = j2 - this.f9630a[this.f9632c];
            if (j4 < 0 && (z || (-j4) >= j3)) {
                break;
            }
            v = k();
            j3 = j4;
        }
        return v;
    }

    @Nullable
    private V k() {
        Assertions.i(this.f9633d > 0);
        V[] vArr = this.f9631b;
        int i2 = this.f9632c;
        V v = vArr[i2];
        vArr[i2] = null;
        this.f9632c = (i2 + 1) % vArr.length;
        this.f9633d--;
        return v;
    }

    public synchronized void a(long j2, V v) {
        d(j2);
        e();
        b(j2, v);
    }

    public synchronized void c() {
        this.f9632c = 0;
        this.f9633d = 0;
        Arrays.fill(this.f9631b, (Object) null);
    }

    @Nullable
    public synchronized V g(long j2) {
        return h(j2, false);
    }

    @Nullable
    public synchronized V i() {
        return this.f9633d == 0 ? null : k();
    }

    @Nullable
    public synchronized V j(long j2) {
        return h(j2, true);
    }

    public synchronized int l() {
        return this.f9633d;
    }

    public TimedValueQueue(int i2) {
        this.f9630a = new long[i2];
        this.f9631b = f(i2);
    }
}
