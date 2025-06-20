package androidx.media3.common.util;

import androidx.annotation.GuardedBy;
import androidx.media3.common.C;

@UnstableApi
public final class TimestampAdjuster {

    /* renamed from: e  reason: collision with root package name */
    public static final long f9634e = Long.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public static final long f9635f = 9223372036854775806L;

    /* renamed from: g  reason: collision with root package name */
    private static final long f9636g = 8589934592L;
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private long f9637a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private long f9638b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private long f9639c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadLocal<Long> f9640d = new ThreadLocal<>();

    public TimestampAdjuster(long j2) {
        i(j2);
    }

    public static long h(long j2) {
        return (j2 * 1000000) / 90000;
    }

    public static long k(long j2) {
        return (j2 * 90000) / 1000000;
    }

    public static long l(long j2) {
        return k(j2) % f9636g;
    }

    public synchronized long a(long j2) {
        if (j2 == C.f9084b) {
            return C.f9084b;
        }
        try {
            if (!g()) {
                long j3 = this.f9637a;
                if (j3 == f9635f) {
                    j3 = ((Long) Assertions.g(this.f9640d.get())).longValue();
                }
                this.f9638b = j3 - j2;
                notifyAll();
            }
            this.f9639c = j2;
            return j2 + this.f9638b;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized long b(long j2) {
        if (j2 == C.f9084b) {
            return C.f9084b;
        }
        try {
            long j3 = this.f9639c;
            if (j3 != C.f9084b) {
                long k2 = k(j3);
                long j4 = (4294967296L + k2) / f9636g;
                long j5 = ((j4 - 1) * f9636g) + j2;
                j2 += j4 * f9636g;
                if (Math.abs(j5 - k2) < Math.abs(j2 - k2)) {
                    j2 = j5;
                }
            }
            return a(h(j2));
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized long c(long j2) {
        if (j2 == C.f9084b) {
            return C.f9084b;
        }
        long j3 = this.f9639c;
        if (j3 != C.f9084b) {
            long k2 = k(j3);
            long j4 = k2 / f9636g;
            Long.signum(j4);
            long j5 = (j4 * f9636g) + j2;
            j2 += (j4 + 1) * f9636g;
            if (j5 >= k2) {
                j2 = j5;
            }
        }
        return a(h(j2));
    }

    public synchronized long d() {
        long j2;
        j2 = this.f9637a;
        if (j2 == Long.MAX_VALUE || j2 == f9635f) {
            j2 = C.f9084b;
        }
        return j2;
    }

    public synchronized long e() {
        long j2;
        try {
            j2 = this.f9639c;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return j2 != C.f9084b ? j2 + this.f9638b : d();
    }

    public synchronized long f() {
        return this.f9638b;
    }

    public synchronized boolean g() {
        return this.f9638b != C.f9084b;
    }

    public synchronized void i(long j2) {
        this.f9637a = j2;
        this.f9638b = j2 == Long.MAX_VALUE ? 0 : -9223372036854775807L;
        this.f9639c = C.f9084b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void j(boolean r9, long r10, long r12) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r8 = this;
            monitor-enter(r8)
            long r0 = r8.f9637a     // Catch:{ all -> 0x0028 }
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            androidx.media3.common.util.Assertions.i(r0)     // Catch:{ all -> 0x0028 }
            boolean r0 = r8.g()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r8)
            return
        L_0x001c:
            if (r9 == 0) goto L_0x002a
            java.lang.ThreadLocal<java.lang.Long> r9 = r8.f9640d     // Catch:{ all -> 0x0028 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0028 }
            r9.set(r10)     // Catch:{ all -> 0x0028 }
            goto L_0x007d
        L_0x0028:
            r9 = move-exception
            goto L_0x007f
        L_0x002a:
            r9 = 0
            r2 = r9
            r0 = r12
        L_0x002e:
            boolean r11 = r8.g()     // Catch:{ all -> 0x0028 }
            if (r11 != 0) goto L_0x007d
            int r11 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x003c
            r8.wait()     // Catch:{ all -> 0x0028 }
            goto L_0x002e
        L_0x003c:
            int r11 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0042
            r11 = 1
            goto L_0x0043
        L_0x0042:
            r11 = 0
        L_0x0043:
            androidx.media3.common.util.Assertions.i(r11)     // Catch:{ all -> 0x0028 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0028 }
            r8.wait(r0)     // Catch:{ all -> 0x0028 }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0028 }
            long r0 = r0 - r6
            long r2 = r2 + r0
            int r11 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r11 < 0) goto L_0x007a
            boolean r11 = r8.g()     // Catch:{ all -> 0x0028 }
            if (r11 == 0) goto L_0x005e
            goto L_0x007a
        L_0x005e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r9.<init>()     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = "TimestampAdjuster failed to initialize in "
            r9.append(r10)     // Catch:{ all -> 0x0028 }
            r9.append(r12)     // Catch:{ all -> 0x0028 }
            java.lang.String r10 = " milliseconds"
            r9.append(r10)     // Catch:{ all -> 0x0028 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0028 }
            java.util.concurrent.TimeoutException r10 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0028 }
            r10.<init>(r9)     // Catch:{ all -> 0x0028 }
            throw r10     // Catch:{ all -> 0x0028 }
        L_0x007a:
            long r0 = r12 - r2
            goto L_0x002e
        L_0x007d:
            monitor-exit(r8)
            return
        L_0x007f:
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.TimestampAdjuster.j(boolean, long, long):void");
    }
}
