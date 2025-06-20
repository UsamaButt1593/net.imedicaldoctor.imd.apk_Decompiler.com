package com.google.common.cache;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.common.annotations.GwtIncompatible;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
abstract class Striped64 extends Number {
    static final Random X2 = new Random();
    static final int Y2 = Runtime.getRuntime().availableProcessors();
    static final ThreadLocal<int[]> Z = new ThreadLocal<>();
    private static final Unsafe Z2;
    private static final long a3;
    private static final long b3;
    volatile transient long X;
    volatile transient int Y;
    @CheckForNull
    volatile transient Cell[] s;

    static final class Cell {
        private static final Unsafe p;
        private static final long q;

        /* renamed from: a  reason: collision with root package name */
        volatile long f22348a;

        /* renamed from: b  reason: collision with root package name */
        volatile long f22349b;

        /* renamed from: c  reason: collision with root package name */
        volatile long f22350c;

        /* renamed from: d  reason: collision with root package name */
        volatile long f22351d;

        /* renamed from: e  reason: collision with root package name */
        volatile long f22352e;

        /* renamed from: f  reason: collision with root package name */
        volatile long f22353f;

        /* renamed from: g  reason: collision with root package name */
        volatile long f22354g;

        /* renamed from: h  reason: collision with root package name */
        volatile long f22355h;

        /* renamed from: i  reason: collision with root package name */
        volatile long f22356i;

        /* renamed from: j  reason: collision with root package name */
        volatile long f22357j;

        /* renamed from: k  reason: collision with root package name */
        volatile long f22358k;

        /* renamed from: l  reason: collision with root package name */
        volatile long f22359l;

        /* renamed from: m  reason: collision with root package name */
        volatile long f22360m;

        /* renamed from: n  reason: collision with root package name */
        volatile long f22361n;
        volatile long o;

        static {
            try {
                Unsafe d2 = Striped64.h();
                p = d2;
                q = d2.objectFieldOffset(Cell.class.getDeclaredField(CmcdData.Factory.f12510n));
            } catch (Exception e2) {
                throw new Error(e2);
            }
        }

        Cell(long j2) {
            this.f22355h = j2;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(long j2, long j3) {
            return p.compareAndSwapLong(this, q, j2, j3);
        }
    }

    static {
        try {
            Unsafe h2 = h();
            Z2 = h2;
            Class<Striped64> cls = Striped64.class;
            a3 = h2.objectFieldOffset(cls.getDeclaredField("X"));
            b3 = h2.objectFieldOffset(cls.getDeclaredField("Y"));
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    Striped64() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.cache.Striped64.AnonymousClass1());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static sun.misc.Unsafe h() {
        /*
            sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
            return r0
        L_0x0005:
            com.google.common.cache.Striped64$1 r0 = new com.google.common.cache.Striped64$1     // Catch:{ PrivilegedActionException -> 0x0011 }
            r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
            sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
            return r0
        L_0x0011:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Could not initialize intrinsics"
            java.lang.Throwable r0 = r0.getCause()
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.h():sun.misc.Unsafe");
    }

    /* access modifiers changed from: package-private */
    public final boolean e(long j2, long j3) {
        return Z2.compareAndSwapLong(this, a3, j2, j3);
    }

    /* access modifiers changed from: package-private */
    public final boolean f() {
        return Z2.compareAndSwapInt(this, b3, 0, 1);
    }

    /* access modifiers changed from: package-private */
    public abstract long g(long j2, long j3);

    /* access modifiers changed from: package-private */
    public final void i(long j2) {
        Cell[] cellArr = this.s;
        this.X = j2;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.f22355h = j2;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00f1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0023 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(long r17, @javax.annotation.CheckForNull int[] r19, boolean r20) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r0 = 1
            r4 = 0
            if (r19 != 0) goto L_0x001b
            java.lang.ThreadLocal<int[]> r5 = Z
            int[] r6 = new int[r0]
            r5.set(r6)
            java.util.Random r5 = X2
            int r5 = r5.nextInt()
            if (r5 != 0) goto L_0x0018
            r5 = 1
        L_0x0018:
            r6[r4] = r5
            goto L_0x001f
        L_0x001b:
            r5 = r19[r4]
            r6 = r19
        L_0x001f:
            r7 = r5
            r8 = 0
            r5 = r20
        L_0x0023:
            com.google.common.cache.Striped64$Cell[] r9 = r1.s
            if (r9 == 0) goto L_0x00b8
            int r10 = r9.length
            if (r10 <= 0) goto L_0x00b8
            int r11 = r10 + -1
            r11 = r11 & r7
            r11 = r9[r11]
            if (r11 != 0) goto L_0x0064
            int r9 = r1.Y
            if (r9 != 0) goto L_0x0062
            com.google.common.cache.Striped64$Cell r9 = new com.google.common.cache.Striped64$Cell
            r9.<init>(r2)
            int r10 = r1.Y
            if (r10 != 0) goto L_0x0062
            boolean r10 = r16.f()
            if (r10 == 0) goto L_0x0062
            com.google.common.cache.Striped64$Cell[] r10 = r1.s     // Catch:{ all -> 0x0056 }
            if (r10 == 0) goto L_0x0058
            int r11 = r10.length     // Catch:{ all -> 0x0056 }
            if (r11 <= 0) goto L_0x0058
            int r11 = r11 + -1
            r11 = r11 & r7
            r12 = r10[r11]     // Catch:{ all -> 0x0056 }
            if (r12 != 0) goto L_0x0058
            r10[r11] = r9     // Catch:{ all -> 0x0056 }
            r9 = 1
            goto L_0x0059
        L_0x0056:
            r0 = move-exception
            goto L_0x005f
        L_0x0058:
            r9 = 0
        L_0x0059:
            r1.Y = r4
            if (r9 == 0) goto L_0x0023
            goto L_0x00f1
        L_0x005f:
            r1.Y = r4
            throw r0
        L_0x0062:
            r8 = 0
            goto L_0x00ab
        L_0x0064:
            if (r5 != 0) goto L_0x0068
            r5 = 1
            goto L_0x00ab
        L_0x0068:
            long r12 = r11.f22355h
            long r14 = r1.g(r12, r2)
            boolean r11 = r11.a(r12, r14)
            if (r11 == 0) goto L_0x0076
            goto L_0x00f1
        L_0x0076:
            int r11 = Y2
            if (r10 >= r11) goto L_0x0062
            com.google.common.cache.Striped64$Cell[] r11 = r1.s
            if (r11 == r9) goto L_0x007f
            goto L_0x0062
        L_0x007f:
            if (r8 != 0) goto L_0x0083
            r8 = 1
            goto L_0x00ab
        L_0x0083:
            int r11 = r1.Y
            if (r11 != 0) goto L_0x00ab
            boolean r11 = r16.f()
            if (r11 == 0) goto L_0x00ab
            com.google.common.cache.Striped64$Cell[] r8 = r1.s     // Catch:{ all -> 0x009f }
            if (r8 != r9) goto L_0x00a3
            int r8 = r10 << 1
            com.google.common.cache.Striped64$Cell[] r8 = new com.google.common.cache.Striped64.Cell[r8]     // Catch:{ all -> 0x009f }
            r11 = 0
        L_0x0096:
            if (r11 >= r10) goto L_0x00a1
            r12 = r9[r11]     // Catch:{ all -> 0x009f }
            r8[r11] = r12     // Catch:{ all -> 0x009f }
            int r11 = r11 + 1
            goto L_0x0096
        L_0x009f:
            r0 = move-exception
            goto L_0x00a8
        L_0x00a1:
            r1.s = r8     // Catch:{ all -> 0x009f }
        L_0x00a3:
            r1.Y = r4
            r8 = 0
            goto L_0x0023
        L_0x00a8:
            r1.Y = r4
            throw r0
        L_0x00ab:
            int r9 = r7 << 13
            r7 = r7 ^ r9
            int r9 = r7 >>> 17
            r7 = r7 ^ r9
            int r9 = r7 << 5
            r7 = r7 ^ r9
            r6[r4] = r7
            goto L_0x0023
        L_0x00b8:
            int r10 = r1.Y
            if (r10 != 0) goto L_0x00e5
            com.google.common.cache.Striped64$Cell[] r10 = r1.s
            if (r10 != r9) goto L_0x00e5
            boolean r10 = r16.f()
            if (r10 == 0) goto L_0x00e5
            com.google.common.cache.Striped64$Cell[] r10 = r1.s     // Catch:{ all -> 0x00da }
            if (r10 != r9) goto L_0x00dc
            r9 = 2
            com.google.common.cache.Striped64$Cell[] r9 = new com.google.common.cache.Striped64.Cell[r9]     // Catch:{ all -> 0x00da }
            r10 = r7 & 1
            com.google.common.cache.Striped64$Cell r11 = new com.google.common.cache.Striped64$Cell     // Catch:{ all -> 0x00da }
            r11.<init>(r2)     // Catch:{ all -> 0x00da }
            r9[r10] = r11     // Catch:{ all -> 0x00da }
            r1.s = r9     // Catch:{ all -> 0x00da }
            r9 = 1
            goto L_0x00dd
        L_0x00da:
            r0 = move-exception
            goto L_0x00e2
        L_0x00dc:
            r9 = 0
        L_0x00dd:
            r1.Y = r4
            if (r9 == 0) goto L_0x0023
            goto L_0x00f1
        L_0x00e2:
            r1.Y = r4
            throw r0
        L_0x00e5:
            long r9 = r1.X
            long r11 = r1.g(r9, r2)
            boolean r9 = r1.e(r9, r11)
            if (r9 == 0) goto L_0x0023
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.j(long, int[], boolean):void");
    }
}
