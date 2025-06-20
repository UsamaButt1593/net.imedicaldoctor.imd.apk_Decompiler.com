package androidx.media3.exoplayer.source;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.g;
import java.io.IOException;

@UnstableApi
public class SampleQueue implements TrackOutput {
    @VisibleForTesting
    static final int K = 1000;
    private static final String L = "SampleQueue";
    private boolean A = true;
    private boolean B = true;
    private boolean C;
    @Nullable
    private Format D;
    @Nullable
    private Format E;
    private long F;
    private boolean G = true;
    private boolean H;
    private long I;
    private boolean J;

    /* renamed from: d  reason: collision with root package name */
    private final SampleDataQueue f12214d;

    /* renamed from: e  reason: collision with root package name */
    private final SampleExtrasHolder f12215e = new SampleExtrasHolder();

    /* renamed from: f  reason: collision with root package name */
    private final SpannedData<SharedSampleMetadata> f12216f = new SpannedData<>(new D());
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final DrmSessionManager f12217g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f12218h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private UpstreamFormatChangedListener f12219i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Format f12220j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private DrmSession f12221k;

    /* renamed from: l  reason: collision with root package name */
    private int f12222l = 1000;

    /* renamed from: m  reason: collision with root package name */
    private long[] f12223m = new long[1000];

    /* renamed from: n  reason: collision with root package name */
    private long[] f12224n = new long[1000];
    private int[] o = new int[1000];
    private int[] p = new int[1000];
    private long[] q = new long[1000];
    private TrackOutput.CryptoData[] r = new TrackOutput.CryptoData[1000];
    private int s;
    private int t;
    private int u;
    private int v;
    private long w = Long.MIN_VALUE;
    private long x = Long.MIN_VALUE;
    private long y = Long.MIN_VALUE;
    private boolean z;

    static final class SampleExtrasHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f12225a;

        /* renamed from: b  reason: collision with root package name */
        public long f12226b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public TrackOutput.CryptoData f12227c;

        SampleExtrasHolder() {
        }
    }

    private static final class SharedSampleMetadata {

        /* renamed from: a  reason: collision with root package name */
        public final Format f12228a;

        /* renamed from: b  reason: collision with root package name */
        public final DrmSessionManager.DrmSessionReference f12229b;

        private SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.f12228a = format;
            this.f12229b = drmSessionReference;
        }
    }

    public interface UpstreamFormatChangedListener {
        void b(Format format);
    }

    protected SampleQueue(Allocator allocator, @Nullable DrmSessionManager drmSessionManager, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f12217g = drmSessionManager;
        this.f12218h = eventDispatcher;
        this.f12214d = new SampleDataQueue(allocator);
    }

    private long E(int i2) {
        long j2 = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int G2 = G(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = Math.max(j2, this.q[G2]);
            if ((this.p[G2] & 1) != 0) {
                break;
            }
            G2--;
            if (G2 == -1) {
                G2 = this.f12222l - 1;
            }
        }
        return j2;
    }

    private int G(int i2) {
        int i3 = this.u + i2;
        int i4 = this.f12222l;
        return i3 < i4 ? i3 : i3 - i4;
    }

    private boolean K() {
        return this.v != this.s;
    }

    private boolean P(int i2) {
        DrmSession drmSession = this.f12221k;
        return drmSession == null || drmSession.getState() == 4 || ((this.p[i2] & 1073741824) == 0 && this.f12221k.h());
    }

    private void R(Format format, FormatHolder formatHolder) {
        Format format2 = this.f12220j;
        boolean z2 = format2 == null;
        DrmInitData drmInitData = format2 == null ? null : format2.i3;
        this.f12220j = format;
        DrmInitData drmInitData2 = format.i3;
        DrmSessionManager drmSessionManager = this.f12217g;
        formatHolder.f10226b = drmSessionManager != null ? format.d(drmSessionManager.d(format)) : format;
        formatHolder.f10225a = this.f12221k;
        if (this.f12217g != null) {
            if (z2 || !Util.g(drmInitData, drmInitData2)) {
                DrmSession drmSession = this.f12221k;
                DrmSession c2 = this.f12217g.c(this.f12218h, format);
                this.f12221k = c2;
                formatHolder.f10225a = c2;
                if (drmSession != null) {
                    drmSession.j(this.f12218h);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int S(androidx.media3.exoplayer.FormatHolder r6, androidx.media3.decoder.DecoderInputBuffer r7, boolean r8, boolean r9, androidx.media3.exoplayer.source.SampleQueue.SampleExtrasHolder r10) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r7.X2 = r0     // Catch:{ all -> 0x001f }
            boolean r0 = r5.K()     // Catch:{ all -> 0x001f }
            r1 = -4
            r2 = -3
            r3 = -5
            if (r0 != 0) goto L_0x0039
            if (r9 != 0) goto L_0x002f
            boolean r9 = r5.z     // Catch:{ all -> 0x001f }
            if (r9 == 0) goto L_0x0014
            goto L_0x002f
        L_0x0014:
            androidx.media3.common.Format r7 = r5.E     // Catch:{ all -> 0x001f }
            if (r7 == 0) goto L_0x002d
            if (r8 != 0) goto L_0x0022
            androidx.media3.common.Format r8 = r5.f12220j     // Catch:{ all -> 0x001f }
            if (r7 == r8) goto L_0x002d
            goto L_0x0022
        L_0x001f:
            r6 = move-exception
            goto L_0x00a2
        L_0x0022:
            java.lang.Object r7 = androidx.media3.common.util.Assertions.g(r7)     // Catch:{ all -> 0x001f }
            androidx.media3.common.Format r7 = (androidx.media3.common.Format) r7     // Catch:{ all -> 0x001f }
            r5.R(r7, r6)     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r3
        L_0x002d:
            monitor-exit(r5)
            return r2
        L_0x002f:
            r6 = 4
            r7.p(r6)     // Catch:{ all -> 0x001f }
            r8 = -9223372036854775808
            r7.Y2 = r8     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r1
        L_0x0039:
            androidx.media3.exoplayer.source.SpannedData<androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata> r0 = r5.f12216f     // Catch:{ all -> 0x001f }
            int r4 = r5.F()     // Catch:{ all -> 0x001f }
            java.lang.Object r0 = r0.f(r4)     // Catch:{ all -> 0x001f }
            androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata r0 = (androidx.media3.exoplayer.source.SampleQueue.SharedSampleMetadata) r0     // Catch:{ all -> 0x001f }
            androidx.media3.common.Format r0 = r0.f12228a     // Catch:{ all -> 0x001f }
            if (r8 != 0) goto L_0x009d
            androidx.media3.common.Format r8 = r5.f12220j     // Catch:{ all -> 0x001f }
            if (r0 == r8) goto L_0x004e
            goto L_0x009d
        L_0x004e:
            int r6 = r5.v     // Catch:{ all -> 0x001f }
            int r6 = r5.G(r6)     // Catch:{ all -> 0x001f }
            boolean r8 = r5.P(r6)     // Catch:{ all -> 0x001f }
            r0 = 1
            if (r8 != 0) goto L_0x005f
            r7.X2 = r0     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r2
        L_0x005f:
            int[] r8 = r5.p     // Catch:{ all -> 0x001f }
            r8 = r8[r6]     // Catch:{ all -> 0x001f }
            r7.p(r8)     // Catch:{ all -> 0x001f }
            int r8 = r5.v     // Catch:{ all -> 0x001f }
            int r2 = r5.s     // Catch:{ all -> 0x001f }
            int r2 = r2 - r0
            if (r8 != r2) goto L_0x0078
            if (r9 != 0) goto L_0x0073
            boolean r8 = r5.z     // Catch:{ all -> 0x001f }
            if (r8 == 0) goto L_0x0078
        L_0x0073:
            r8 = 536870912(0x20000000, float:1.0842022E-19)
            r7.f(r8)     // Catch:{ all -> 0x001f }
        L_0x0078:
            long[] r8 = r5.q     // Catch:{ all -> 0x001f }
            r2 = r8[r6]     // Catch:{ all -> 0x001f }
            r7.Y2 = r2     // Catch:{ all -> 0x001f }
            long r8 = r5.w     // Catch:{ all -> 0x001f }
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0089
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7.f(r8)     // Catch:{ all -> 0x001f }
        L_0x0089:
            int[] r7 = r5.o     // Catch:{ all -> 0x001f }
            r7 = r7[r6]     // Catch:{ all -> 0x001f }
            r10.f12225a = r7     // Catch:{ all -> 0x001f }
            long[] r7 = r5.f12224n     // Catch:{ all -> 0x001f }
            r8 = r7[r6]     // Catch:{ all -> 0x001f }
            r10.f12226b = r8     // Catch:{ all -> 0x001f }
            androidx.media3.extractor.TrackOutput$CryptoData[] r7 = r5.r     // Catch:{ all -> 0x001f }
            r6 = r7[r6]     // Catch:{ all -> 0x001f }
            r10.f12227c = r6     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r1
        L_0x009d:
            r5.R(r0, r6)     // Catch:{ all -> 0x001f }
            monitor-exit(r5)
            return r3
        L_0x00a2:
            monitor-exit(r5)     // Catch:{ all -> 0x001f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.S(androidx.media3.exoplayer.FormatHolder, androidx.media3.decoder.DecoderInputBuffer, boolean, boolean, androidx.media3.exoplayer.source.SampleQueue$SampleExtrasHolder):int");
    }

    private void X() {
        DrmSession drmSession = this.f12221k;
        if (drmSession != null) {
            drmSession.j(this.f12218h);
            this.f12221k = null;
            this.f12220j = null;
        }
    }

    private synchronized void a0() {
        this.v = 0;
        this.f12214d.o();
    }

    private synchronized boolean f0(Format format) {
        try {
            this.B = false;
            if (Util.g(format, this.E)) {
                return false;
            }
            if (!this.f12216f.h() && this.f12216f.g().f12228a.equals(format)) {
                format = this.f12216f.g().f12228a;
            }
            this.E = format;
            boolean z2 = this.G;
            Format format2 = this.E;
            this.G = z2 & MimeTypes.a(format2.f3, format2.c3);
            this.H = false;
            return true;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean h(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.s     // Catch:{ all -> 0x0010 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0012
            long r3 = r5.x     // Catch:{ all -> 0x0010 }
            int r0 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x000e
            r1 = 1
        L_0x000e:
            monitor-exit(r5)
            return r1
        L_0x0010:
            r6 = move-exception
            goto L_0x0028
        L_0x0012:
            long r3 = r5.D()     // Catch:{ all -> 0x0010 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x001c
            monitor-exit(r5)
            return r1
        L_0x001c:
            int r6 = r5.j(r6)     // Catch:{ all -> 0x0010 }
            int r7 = r5.t     // Catch:{ all -> 0x0010 }
            int r7 = r7 + r6
            r5.v(r7)     // Catch:{ all -> 0x0010 }
            monitor-exit(r5)
            return r2
        L_0x0028:
            monitor-exit(r5)     // Catch:{ all -> 0x0010 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.h(long):boolean");
    }

    private synchronized void i(long j2, int i2, long j3, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
        try {
            int i4 = this.s;
            if (i4 > 0) {
                int G2 = G(i4 - 1);
                Assertions.a(this.f12224n[G2] + ((long) this.o[G2]) <= j3);
            }
            this.z = (536870912 & i2) != 0;
            this.y = Math.max(this.y, j2);
            int G3 = G(this.s);
            this.q[G3] = j2;
            this.f12224n[G3] = j3;
            this.o[G3] = i3;
            this.p[G3] = i2;
            this.r[G3] = cryptoData;
            this.f12223m[G3] = this.F;
            if (this.f12216f.h() || !this.f12216f.g().f12228a.equals(this.E)) {
                Format format = (Format) Assertions.g(this.E);
                DrmSessionManager drmSessionManager = this.f12217g;
                this.f12216f.b(J(), new SharedSampleMetadata(format, drmSessionManager != null ? drmSessionManager.e(this.f12218h, format) : DrmSessionManager.DrmSessionReference.f11301a));
            }
            int i5 = this.s + 1;
            this.s = i5;
            int i6 = this.f12222l;
            if (i5 == i6) {
                int i7 = i6 + 1000;
                long[] jArr = new long[i7];
                long[] jArr2 = new long[i7];
                long[] jArr3 = new long[i7];
                int[] iArr = new int[i7];
                int[] iArr2 = new int[i7];
                TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i7];
                int i8 = this.u;
                int i9 = i6 - i8;
                System.arraycopy(this.f12224n, i8, jArr2, 0, i9);
                System.arraycopy(this.q, this.u, jArr3, 0, i9);
                System.arraycopy(this.p, this.u, iArr, 0, i9);
                System.arraycopy(this.o, this.u, iArr2, 0, i9);
                System.arraycopy(this.r, this.u, cryptoDataArr, 0, i9);
                System.arraycopy(this.f12223m, this.u, jArr, 0, i9);
                int i10 = this.u;
                System.arraycopy(this.f12224n, 0, jArr2, i9, i10);
                System.arraycopy(this.q, 0, jArr3, i9, i10);
                System.arraycopy(this.p, 0, iArr, i9, i10);
                System.arraycopy(this.o, 0, iArr2, i9, i10);
                System.arraycopy(this.r, 0, cryptoDataArr, i9, i10);
                System.arraycopy(this.f12223m, 0, jArr, i9, i10);
                this.f12224n = jArr2;
                this.q = jArr3;
                this.p = iArr;
                this.o = iArr2;
                this.r = cryptoDataArr;
                this.f12223m = jArr;
                this.u = 0;
                this.f12222l = i7;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private int j(long j2) {
        int i2 = this.s;
        int G2 = G(i2 - 1);
        while (i2 > this.v && this.q[G2] >= j2) {
            i2--;
            G2--;
            if (G2 == -1) {
                G2 = this.f12222l - 1;
            }
        }
        return i2;
    }

    @Deprecated
    public static SampleQueue k(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSessionManager.b(looper, PlayerId.f10613b);
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.g(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.g(eventDispatcher));
    }

    public static SampleQueue l(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.g(drmSessionManager), (DrmSessionEventListener.EventDispatcher) Assertions.g(eventDispatcher));
    }

    public static SampleQueue m(Allocator allocator) {
        return new SampleQueue(allocator, (DrmSessionManager) null, (DrmSessionEventListener.EventDispatcher) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0031, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long n(long r11, boolean r13, boolean r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.s     // Catch:{ all -> 0x001c }
            r1 = -1
            if (r0 == 0) goto L_0x0030
            long[] r3 = r10.q     // Catch:{ all -> 0x001c }
            int r5 = r10.u     // Catch:{ all -> 0x001c }
            r6 = r3[r5]     // Catch:{ all -> 0x001c }
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0012
            goto L_0x0030
        L_0x0012:
            if (r14 == 0) goto L_0x001a
            int r14 = r10.v     // Catch:{ all -> 0x001c }
            if (r14 == r0) goto L_0x001a
            int r0 = r14 + 1
        L_0x001a:
            r6 = r0
            goto L_0x001e
        L_0x001c:
            r11 = move-exception
            goto L_0x0032
        L_0x001e:
            r4 = r10
            r7 = r11
            r9 = r13
            int r11 = r4.y(r5, r6, r7, r9)     // Catch:{ all -> 0x001c }
            r12 = -1
            if (r11 != r12) goto L_0x002a
            monitor-exit(r10)
            return r1
        L_0x002a:
            long r11 = r10.q(r11)     // Catch:{ all -> 0x001c }
            monitor-exit(r10)
            return r11
        L_0x0030:
            monitor-exit(r10)
            return r1
        L_0x0032:
            monitor-exit(r10)     // Catch:{ all -> 0x001c }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.n(long, boolean, boolean):long");
    }

    private synchronized long o() {
        int i2 = this.s;
        if (i2 == 0) {
            return -1;
        }
        return q(i2);
    }

    @GuardedBy("this")
    private long q(int i2) {
        this.x = Math.max(this.x, E(i2));
        this.s -= i2;
        int i3 = this.t + i2;
        this.t = i3;
        int i4 = this.u + i2;
        this.u = i4;
        int i5 = this.f12222l;
        if (i4 >= i5) {
            this.u = i4 - i5;
        }
        int i6 = this.v - i2;
        this.v = i6;
        if (i6 < 0) {
            this.v = 0;
        }
        this.f12216f.e(i3);
        if (this.s != 0) {
            return this.f12224n[this.u];
        }
        int i7 = this.u;
        if (i7 == 0) {
            i7 = this.f12222l;
        }
        int i8 = i7 - 1;
        return this.f12224n[i8] + ((long) this.o[i8]);
    }

    private long v(int i2) {
        int J2 = J() - i2;
        boolean z2 = false;
        Assertions.a(J2 >= 0 && J2 <= this.s - this.v);
        int i3 = this.s - J2;
        this.s = i3;
        this.y = Math.max(this.x, E(i3));
        if (J2 == 0 && this.z) {
            z2 = true;
        }
        this.z = z2;
        this.f12216f.d(i2);
        int i4 = this.s;
        if (i4 == 0) {
            return 0;
        }
        int G2 = G(i4 - 1);
        return this.f12224n[G2] + ((long) this.o[G2]);
    }

    private int x(int i2, int i3, long j2, boolean z2) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.q[i2] >= j2) {
                return i4;
            }
            i2++;
            if (i2 == this.f12222l) {
                i2 = 0;
            }
        }
        if (z2) {
            return i3;
        }
        return -1;
    }

    private int y(int i2, int i3, long j2, boolean z2) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            long j3 = this.q[i2];
            if (j3 > j2) {
                return i4;
            }
            if (!z2 || (this.p[i2] & 1) != 0) {
                if (j3 == j2) {
                    return i5;
                }
                i4 = i5;
            }
            i2++;
            if (i2 == this.f12222l) {
                i2 = 0;
            }
        }
        return i4;
    }

    public final int A() {
        return this.t;
    }

    public final synchronized long B() {
        return this.s == 0 ? Long.MIN_VALUE : this.q[this.u];
    }

    public final synchronized long C() {
        return this.y;
    }

    public final synchronized long D() {
        return Math.max(this.x, E(this.v));
    }

    public final int F() {
        return this.t + this.v;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        if (r9 != -1) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int H(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.v     // Catch:{ all -> 0x0026 }
            int r2 = r8.G(r0)     // Catch:{ all -> 0x0026 }
            boolean r0 = r8.K()     // Catch:{ all -> 0x0026 }
            r7 = 0
            if (r0 == 0) goto L_0x003b
            long[] r0 = r8.q     // Catch:{ all -> 0x0026 }
            r3 = r0[r2]     // Catch:{ all -> 0x0026 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003b
        L_0x0017:
            long r0 = r8.y     // Catch:{ all -> 0x0026 }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0028
            if (r11 == 0) goto L_0x0028
            int r9 = r8.s     // Catch:{ all -> 0x0026 }
            int r10 = r8.v     // Catch:{ all -> 0x0026 }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0026:
            r9 = move-exception
            goto L_0x003d
        L_0x0028:
            int r11 = r8.s     // Catch:{ all -> 0x0026 }
            int r0 = r8.v     // Catch:{ all -> 0x0026 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.y(r2, r3, r4, r6)     // Catch:{ all -> 0x0026 }
            r10 = -1
            monitor-exit(r8)
            if (r9 != r10) goto L_0x003a
            return r7
        L_0x003a:
            return r9
        L_0x003b:
            monitor-exit(r8)
            return r7
        L_0x003d:
            monitor-exit(r8)     // Catch:{ all -> 0x0026 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.H(long, boolean):int");
    }

    @Nullable
    public final synchronized Format I() {
        return this.B ? null : this.E;
    }

    public final int J() {
        return this.t + this.s;
    }

    /* access modifiers changed from: protected */
    public final void L() {
        this.C = true;
    }

    public final synchronized boolean M() {
        return this.z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        return r1;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean N(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.K()     // Catch:{ all -> 0x0017 }
            r1 = 1
            if (r0 != 0) goto L_0x001c
            if (r3 != 0) goto L_0x001a
            boolean r3 = r2.z     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x001a
            androidx.media3.common.Format r3 = r2.E     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0019
            androidx.media3.common.Format r0 = r2.f12220j     // Catch:{ all -> 0x0017 }
            if (r3 == r0) goto L_0x0019
            goto L_0x001a
        L_0x0017:
            r3 = move-exception
            goto L_0x003c
        L_0x0019:
            r1 = 0
        L_0x001a:
            monitor-exit(r2)
            return r1
        L_0x001c:
            androidx.media3.exoplayer.source.SpannedData<androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata> r3 = r2.f12216f     // Catch:{ all -> 0x0017 }
            int r0 = r2.F()     // Catch:{ all -> 0x0017 }
            java.lang.Object r3 = r3.f(r0)     // Catch:{ all -> 0x0017 }
            androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata r3 = (androidx.media3.exoplayer.source.SampleQueue.SharedSampleMetadata) r3     // Catch:{ all -> 0x0017 }
            androidx.media3.common.Format r3 = r3.f12228a     // Catch:{ all -> 0x0017 }
            androidx.media3.common.Format r0 = r2.f12220j     // Catch:{ all -> 0x0017 }
            if (r3 == r0) goto L_0x0030
            monitor-exit(r2)
            return r1
        L_0x0030:
            int r3 = r2.v     // Catch:{ all -> 0x0017 }
            int r3 = r2.G(r3)     // Catch:{ all -> 0x0017 }
            boolean r3 = r2.P(r3)     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            return r3
        L_0x003c:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.N(boolean):boolean");
    }

    @CallSuper
    public void Q() throws IOException {
        DrmSession drmSession = this.f12221k;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.g(this.f12221k.e()));
        }
    }

    public final synchronized long T() {
        try {
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return K() ? this.f12223m[G(this.v)] : this.F;
    }

    @CallSuper
    public void U() {
        s();
        X();
    }

    @CallSuper
    public int V(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2, boolean z2) {
        boolean z3 = false;
        int S = S(formatHolder, decoderInputBuffer, (i2 & 2) != 0, z2, this.f12215e);
        if (S == -4 && !decoderInputBuffer.l()) {
            if ((i2 & 1) != 0) {
                z3 = true;
            }
            if ((i2 & 4) == 0) {
                SampleDataQueue sampleDataQueue = this.f12214d;
                SampleExtrasHolder sampleExtrasHolder = this.f12215e;
                if (z3) {
                    sampleDataQueue.f(decoderInputBuffer, sampleExtrasHolder);
                } else {
                    sampleDataQueue.m(decoderInputBuffer, sampleExtrasHolder);
                }
            }
            if (!z3) {
                this.v++;
            }
        }
        return S;
    }

    @CallSuper
    public void W() {
        Z(true);
        X();
    }

    public final void Y() {
        Z(false);
    }

    @CallSuper
    public void Z(boolean z2) {
        this.f12214d.n();
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.A = true;
        this.w = Long.MIN_VALUE;
        this.x = Long.MIN_VALUE;
        this.y = Long.MIN_VALUE;
        this.z = false;
        this.f12216f.c();
        if (z2) {
            this.D = null;
            this.E = null;
            this.B = true;
            this.G = true;
        }
    }

    public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        this.f12214d.q(parsableByteArray, i2);
    }

    public /* synthetic */ int b(DataReader dataReader, int i2, boolean z2) {
        return g.a(this, dataReader, i2, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean b0(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.a0()     // Catch:{ all -> 0x0018 }
            int r0 = r3.t     // Catch:{ all -> 0x0018 }
            if (r4 < r0) goto L_0x001a
            int r1 = r3.s     // Catch:{ all -> 0x0018 }
            int r1 = r1 + r0
            if (r4 <= r1) goto L_0x000e
            goto L_0x001a
        L_0x000e:
            r1 = -9223372036854775808
            r3.w = r1     // Catch:{ all -> 0x0018 }
            int r4 = r4 - r0
            r3.v = r4     // Catch:{ all -> 0x0018 }
            monitor-exit(r3)
            r4 = 1
            return r4
        L_0x0018:
            r4 = move-exception
            goto L_0x001d
        L_0x001a:
            monitor-exit(r3)
            r4 = 0
            return r4
        L_0x001d:
            monitor-exit(r3)     // Catch:{ all -> 0x0018 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.b0(int):boolean");
    }

    public final int c(DataReader dataReader, int i2, boolean z2, int i3) throws IOException {
        return this.f12214d.p(dataReader, i2, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean c0(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.a0()     // Catch:{ all -> 0x0034 }
            int r0 = r8.v     // Catch:{ all -> 0x0034 }
            int r2 = r8.G(r0)     // Catch:{ all -> 0x0034 }
            boolean r0 = r8.K()     // Catch:{ all -> 0x0034 }
            r7 = 0
            if (r0 == 0) goto L_0x0052
            long[] r0 = r8.q     // Catch:{ all -> 0x0034 }
            r3 = r0[r2]     // Catch:{ all -> 0x0034 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0052
            long r0 = r8.y     // Catch:{ all -> 0x0034 }
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0022
            if (r11 != 0) goto L_0x0022
            goto L_0x0052
        L_0x0022:
            boolean r0 = r8.G     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0036
            int r0 = r8.s     // Catch:{ all -> 0x0034 }
            int r1 = r8.v     // Catch:{ all -> 0x0034 }
            int r3 = r0 - r1
            r1 = r8
            r4 = r9
            r6 = r11
            int r11 = r1.x(r2, r3, r4, r6)     // Catch:{ all -> 0x0034 }
            goto L_0x0043
        L_0x0034:
            r9 = move-exception
            goto L_0x0054
        L_0x0036:
            int r11 = r8.s     // Catch:{ all -> 0x0034 }
            int r0 = r8.v     // Catch:{ all -> 0x0034 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.y(r2, r3, r4, r6)     // Catch:{ all -> 0x0034 }
        L_0x0043:
            r0 = -1
            if (r11 != r0) goto L_0x0048
            monitor-exit(r8)
            return r7
        L_0x0048:
            r8.w = r9     // Catch:{ all -> 0x0034 }
            int r9 = r8.v     // Catch:{ all -> 0x0034 }
            int r9 = r9 + r11
            r8.v = r9     // Catch:{ all -> 0x0034 }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x0052:
            monitor-exit(r8)
            return r7
        L_0x0054:
            monitor-exit(r8)     // Catch:{ all -> 0x0034 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.c0(long, boolean):boolean");
    }

    public /* synthetic */ void d(ParsableByteArray parsableByteArray, int i2) {
        g.b(this, parsableByteArray, i2);
    }

    public final void d0(long j2) {
        if (this.I != j2) {
            this.I = j2;
            L();
        }
    }

    public final void e(Format format) {
        Format z2 = z(format);
        this.C = false;
        this.D = format;
        boolean f0 = f0(z2);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f12219i;
        if (upstreamFormatChangedListener != null && f0) {
            upstreamFormatChangedListener.b(z2);
        }
    }

    public final void e0(long j2) {
        this.w = j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(long r12, int r14, int r15, int r16, @androidx.annotation.Nullable androidx.media3.extractor.TrackOutput.CryptoData r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.C
            if (r0 == 0) goto L_0x0010
            androidx.media3.common.Format r0 = r8.D
            java.lang.Object r0 = androidx.media3.common.util.Assertions.k(r0)
            androidx.media3.common.Format r0 = (androidx.media3.common.Format) r0
            r11.e(r0)
        L_0x0010:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            r3 = 1
            goto L_0x0019
        L_0x0018:
            r3 = 0
        L_0x0019:
            boolean r4 = r8.A
            if (r4 == 0) goto L_0x0022
            if (r3 != 0) goto L_0x0020
            return
        L_0x0020:
            r8.A = r1
        L_0x0022:
            long r4 = r8.I
            long r4 = r4 + r12
            boolean r6 = r8.G
            if (r6 == 0) goto L_0x0054
            long r6 = r8.w
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x0030
            return
        L_0x0030:
            if (r0 != 0) goto L_0x0054
            boolean r0 = r8.H
            if (r0 != 0) goto L_0x0050
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            r0.append(r6)
            androidx.media3.common.Format r6 = r8.E
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            androidx.media3.common.util.Log.n(r6, r0)
            r8.H = r2
        L_0x0050:
            r0 = r14 | 1
            r6 = r0
            goto L_0x0055
        L_0x0054:
            r6 = r14
        L_0x0055:
            boolean r0 = r8.J
            if (r0 == 0) goto L_0x0066
            if (r3 == 0) goto L_0x0065
            boolean r0 = r11.h(r4)
            if (r0 != 0) goto L_0x0062
            goto L_0x0065
        L_0x0062:
            r8.J = r1
            goto L_0x0066
        L_0x0065:
            return
        L_0x0066:
            androidx.media3.exoplayer.source.SampleDataQueue r0 = r8.f12214d
            long r0 = r0.e()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.i(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.f(long, int, int, int, androidx.media3.extractor.TrackOutput$CryptoData):void");
    }

    public final void g0(@Nullable UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f12219i = upstreamFormatChangedListener;
    }

    public final synchronized void h0(int i2) {
        boolean z2;
        if (i2 >= 0) {
            try {
                if (this.v + i2 <= this.s) {
                    z2 = true;
                    Assertions.a(z2);
                    this.v += i2;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        z2 = false;
        Assertions.a(z2);
        this.v += i2;
    }

    public final void i0(long j2) {
        this.F = j2;
    }

    public final void j0() {
        this.J = true;
    }

    public synchronized long p() {
        int i2 = this.v;
        if (i2 == 0) {
            return -1;
        }
        return q(i2);
    }

    public final void r(long j2, boolean z2, boolean z3) {
        this.f12214d.b(n(j2, z2, z3));
    }

    public final void s() {
        this.f12214d.b(o());
    }

    public final void t() {
        this.f12214d.b(p());
    }

    public final void u(long j2) {
        if (this.s != 0) {
            Assertions.a(j2 > D());
            w(this.t + j(j2));
        }
    }

    public final void w(int i2) {
        this.f12214d.c(v(i2));
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public Format z(Format format) {
        return (this.I == 0 || format.j3 == Long.MAX_VALUE) ? format : format.c().o0(format.j3 + this.I).I();
    }
}
