package androidx.media3.decoder;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.DecoderOutputBuffer;
import java.util.ArrayDeque;

@UnstableApi
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f10063a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10064b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<I> f10065c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<O> f10066d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final I[] f10067e;

    /* renamed from: f  reason: collision with root package name */
    private final O[] f10068f;

    /* renamed from: g  reason: collision with root package name */
    private int f10069g;

    /* renamed from: h  reason: collision with root package name */
    private int f10070h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private I f10071i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private E f10072j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10073k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10074l;

    /* renamed from: m  reason: collision with root package name */
    private int f10075m;

    /* renamed from: n  reason: collision with root package name */
    private long f10076n = C.f9084b;

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.f10067e = iArr;
        this.f10069g = iArr.length;
        for (int i2 = 0; i2 < this.f10069g; i2++) {
            this.f10067e[i2] = j();
        }
        this.f10068f = oArr;
        this.f10070h = oArr.length;
        for (int i3 = 0; i3 < this.f10070h; i3++) {
            this.f10068f[i3] = k();
        }
        AnonymousClass1 r4 = new Thread("ExoPlayer:SimpleDecoder") {
            public void run() {
                SimpleDecoder.this.w();
            }
        };
        this.f10063a = r4;
        r4.start();
    }

    private boolean i() {
        return !this.f10065c.isEmpty() && this.f10070h > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        if (r1.l() == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        r3.f(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
        r6 = r1.Y2;
        r3.X = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (q(r6) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r1.k() == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r3.f(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
        if (r1.m() == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        r3.f(androidx.media3.common.C.S0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0 = m(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        r0 = l(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean n() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f10064b
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r8.f10074l     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0016
            boolean r1 = r8.i()     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x0016
            java.lang.Object r1 = r8.f10064b     // Catch:{ all -> 0x0013 }
            r1.wait()     // Catch:{ all -> 0x0013 }
            goto L_0x0003
        L_0x0013:
            r1 = move-exception
            goto L_0x00b7
        L_0x0016:
            boolean r1 = r8.f10074l     // Catch:{ all -> 0x0013 }
            r2 = 0
            if (r1 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            return r2
        L_0x001d:
            java.util.ArrayDeque<I> r1 = r8.f10065c     // Catch:{ all -> 0x0013 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0013 }
            androidx.media3.decoder.DecoderInputBuffer r1 = (androidx.media3.decoder.DecoderInputBuffer) r1     // Catch:{ all -> 0x0013 }
            O[] r3 = r8.f10068f     // Catch:{ all -> 0x0013 }
            int r4 = r8.f10070h     // Catch:{ all -> 0x0013 }
            r5 = 1
            int r4 = r4 - r5
            r8.f10070h = r4     // Catch:{ all -> 0x0013 }
            r3 = r3[r4]     // Catch:{ all -> 0x0013 }
            boolean r4 = r8.f10073k     // Catch:{ all -> 0x0013 }
            r8.f10073k = r2     // Catch:{ all -> 0x0013 }
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            boolean r0 = r1.l()
            if (r0 == 0) goto L_0x003f
            r0 = 4
            r3.f(r0)
            goto L_0x0078
        L_0x003f:
            long r6 = r1.Y2
            r3.X = r6
            boolean r0 = r8.q(r6)
            if (r0 == 0) goto L_0x004f
            boolean r0 = r1.k()
            if (r0 == 0) goto L_0x0054
        L_0x004f:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.f(r0)
        L_0x0054:
            boolean r0 = r1.m()
            if (r0 == 0) goto L_0x005f
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r3.f(r0)
        L_0x005f:
            androidx.media3.decoder.DecoderException r0 = r8.m(r1, r3, r4)     // Catch:{ RuntimeException -> 0x006a, OutOfMemoryError -> 0x0064 }
            goto L_0x006c
        L_0x0064:
            r0 = move-exception
        L_0x0065:
            androidx.media3.decoder.DecoderException r0 = r8.l(r0)
            goto L_0x006c
        L_0x006a:
            r0 = move-exception
            goto L_0x0065
        L_0x006c:
            if (r0 == 0) goto L_0x0078
            java.lang.Object r4 = r8.f10064b
            monitor-enter(r4)
            r8.f10072j = r0     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)     // Catch:{ all -> 0x0075 }
            return r2
        L_0x0075:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0075 }
            throw r0
        L_0x0078:
            java.lang.Object r4 = r8.f10064b
            monitor-enter(r4)
            boolean r0 = r8.f10073k     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x0085
        L_0x007f:
            r3.q()     // Catch:{ all -> 0x0083 }
            goto L_0x00b0
        L_0x0083:
            r0 = move-exception
            goto L_0x00b5
        L_0x0085:
            boolean r0 = r3.l()     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x0093
            long r6 = r3.X     // Catch:{ all -> 0x0083 }
            boolean r0 = r8.q(r6)     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x00aa
        L_0x0093:
            boolean r0 = r3.k()     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x00aa
            boolean r0 = r3.Z     // Catch:{ all -> 0x0083 }
            if (r0 == 0) goto L_0x009e
            goto L_0x00aa
        L_0x009e:
            int r0 = r8.f10075m     // Catch:{ all -> 0x0083 }
            r3.Y = r0     // Catch:{ all -> 0x0083 }
            r8.f10075m = r2     // Catch:{ all -> 0x0083 }
            java.util.ArrayDeque<O> r0 = r8.f10066d     // Catch:{ all -> 0x0083 }
            r0.addLast(r3)     // Catch:{ all -> 0x0083 }
            goto L_0x00b0
        L_0x00aa:
            int r0 = r8.f10075m     // Catch:{ all -> 0x0083 }
            int r0 = r0 + r5
            r8.f10075m = r0     // Catch:{ all -> 0x0083 }
            goto L_0x007f
        L_0x00b0:
            r8.t(r1)     // Catch:{ all -> 0x0083 }
            monitor-exit(r4)     // Catch:{ all -> 0x0083 }
            return r5
        L_0x00b5:
            monitor-exit(r4)     // Catch:{ all -> 0x0083 }
            throw r0
        L_0x00b7:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.decoder.SimpleDecoder.n():boolean");
    }

    private void r() {
        if (i()) {
            this.f10064b.notify();
        }
    }

    private void s() throws DecoderException {
        E e2 = this.f10072j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void t(I i2) {
        i2.g();
        I[] iArr = this.f10067e;
        int i3 = this.f10069g;
        this.f10069g = i3 + 1;
        iArr[i3] = i2;
    }

    private void v(O o) {
        o.g();
        O[] oArr = this.f10068f;
        int i2 = this.f10070h;
        this.f10070h = i2 + 1;
        oArr[i2] = o;
    }

    /* access modifiers changed from: private */
    public void w() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (n());
    }

    @CallSuper
    public void a() {
        synchronized (this.f10064b) {
            this.f10074l = true;
            this.f10064b.notify();
        }
        try {
            this.f10063a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public final void d(long j2) {
        boolean z;
        synchronized (this.f10064b) {
            try {
                if (this.f10069g != this.f10067e.length) {
                    if (!this.f10073k) {
                        z = false;
                        Assertions.i(z);
                        this.f10076n = j2;
                    }
                }
                z = true;
                Assertions.i(z);
                this.f10076n = j2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void flush() {
        synchronized (this.f10064b) {
            try {
                this.f10073k = true;
                this.f10075m = 0;
                I i2 = this.f10071i;
                if (i2 != null) {
                    t(i2);
                    this.f10071i = null;
                }
                while (!this.f10065c.isEmpty()) {
                    t((DecoderInputBuffer) this.f10065c.removeFirst());
                }
                while (!this.f10066d.isEmpty()) {
                    ((DecoderOutputBuffer) this.f10066d.removeFirst()).q();
                }
            } finally {
            }
        }
    }

    /* renamed from: g */
    public final void c(I i2) throws DecoderException {
        synchronized (this.f10064b) {
            s();
            Assertions.a(i2 == this.f10071i);
            this.f10065c.addLast(i2);
            r();
            this.f10071i = null;
        }
    }

    /* access modifiers changed from: protected */
    public abstract I j();

    /* access modifiers changed from: protected */
    public abstract O k();

    /* access modifiers changed from: protected */
    public abstract E l(Throwable th);

    /* access modifiers changed from: protected */
    @Nullable
    public abstract E m(I i2, O o, boolean z);

    @Nullable
    /* renamed from: o */
    public final I f() throws DecoderException {
        I i2;
        synchronized (this.f10064b) {
            s();
            Assertions.i(this.f10071i == null);
            int i3 = this.f10069g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f10067e;
                int i4 = i3 - 1;
                this.f10069g = i4;
                i2 = iArr[i4];
            }
            this.f10071i = i2;
        }
        return i2;
    }

    @Nullable
    /* renamed from: p */
    public final O b() throws DecoderException {
        synchronized (this.f10064b) {
            try {
                s();
                if (this.f10066d.isEmpty()) {
                    return null;
                }
                O o = (DecoderOutputBuffer) this.f10066d.removeFirst();
                return o;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean q(long j2) {
        boolean z;
        synchronized (this.f10064b) {
            long j3 = this.f10076n;
            if (j3 != C.f9084b) {
                if (j2 < j3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void u(O o) {
        synchronized (this.f10064b) {
            v(o);
            r();
        }
    }

    /* access modifiers changed from: protected */
    public final void x(int i2) {
        Assertions.i(this.f10069g == this.f10067e.length);
        for (I r : this.f10067e) {
            r.r(i2);
        }
    }
}
