package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public final class PlayerMessage {

    /* renamed from: a  reason: collision with root package name */
    private final Target f10318a;

    /* renamed from: b  reason: collision with root package name */
    private final Sender f10319b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f10320c;

    /* renamed from: d  reason: collision with root package name */
    private final Timeline f10321d;

    /* renamed from: e  reason: collision with root package name */
    private int f10322e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Object f10323f;

    /* renamed from: g  reason: collision with root package name */
    private Looper f10324g;

    /* renamed from: h  reason: collision with root package name */
    private int f10325h;

    /* renamed from: i  reason: collision with root package name */
    private long f10326i = C.f9084b;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10327j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10328k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10329l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10330m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10331n;

    public interface Sender {
        void e(PlayerMessage playerMessage);
    }

    public interface Target {
        void z(int i2, @Nullable Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i2, Clock clock, Looper looper) {
        this.f10319b = sender;
        this.f10318a = target;
        this.f10321d = timeline;
        this.f10324g = looper;
        this.f10320c = clock;
        this.f10325h = i2;
    }

    public synchronized boolean a() throws InterruptedException {
        try {
            Assertions.i(this.f10328k);
            Assertions.i(this.f10324g.getThread() != Thread.currentThread());
            while (!this.f10330m) {
                wait();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f10329l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e A[Catch:{ all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[SYNTHETIC, Splitter:B:18:0x0042] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean b(long r7) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f10328k     // Catch:{ all -> 0x003a }
            androidx.media3.common.util.Assertions.i(r0)     // Catch:{ all -> 0x003a }
            android.os.Looper r0 = r6.f10324g     // Catch:{ all -> 0x003a }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x003a }
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003a }
            if (r0 == r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            androidx.media3.common.util.Assertions.i(r0)     // Catch:{ all -> 0x003a }
            androidx.media3.common.util.Clock r0 = r6.f10320c     // Catch:{ all -> 0x003a }
            long r0 = r0.b()     // Catch:{ all -> 0x003a }
            long r0 = r0 + r7
        L_0x001f:
            boolean r2 = r6.f10330m     // Catch:{ all -> 0x003a }
            if (r2 != 0) goto L_0x003c
            r3 = 0
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x003c
            androidx.media3.common.util.Clock r2 = r6.f10320c     // Catch:{ all -> 0x003a }
            r2.f()     // Catch:{ all -> 0x003a }
            r6.wait(r7)     // Catch:{ all -> 0x003a }
            androidx.media3.common.util.Clock r7 = r6.f10320c     // Catch:{ all -> 0x003a }
            long r7 = r7.b()     // Catch:{ all -> 0x003a }
            long r7 = r0 - r7
            goto L_0x001f
        L_0x003a:
            r7 = move-exception
            goto L_0x004a
        L_0x003c:
            if (r2 == 0) goto L_0x0042
            boolean r7 = r6.f10329l     // Catch:{ all -> 0x003a }
            monitor-exit(r6)
            return r7
        L_0x0042:
            java.util.concurrent.TimeoutException r7 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x003a }
            java.lang.String r8 = "Message delivery timed out."
            r7.<init>(r8)     // Catch:{ all -> 0x003a }
            throw r7     // Catch:{ all -> 0x003a }
        L_0x004a:
            monitor-exit(r6)     // Catch:{ all -> 0x003a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.PlayerMessage.b(long):boolean");
    }

    @CanIgnoreReturnValue
    public synchronized PlayerMessage c() {
        Assertions.i(this.f10328k);
        this.f10331n = true;
        m(false);
        return this;
    }

    public boolean d() {
        return this.f10327j;
    }

    public Looper e() {
        return this.f10324g;
    }

    public int f() {
        return this.f10325h;
    }

    @Nullable
    public Object g() {
        return this.f10323f;
    }

    public long h() {
        return this.f10326i;
    }

    public Target i() {
        return this.f10318a;
    }

    public Timeline j() {
        return this.f10321d;
    }

    public int k() {
        return this.f10322e;
    }

    public synchronized boolean l() {
        return this.f10331n;
    }

    public synchronized void m(boolean z) {
        this.f10329l = z | this.f10329l;
        this.f10330m = true;
        notifyAll();
    }

    @CanIgnoreReturnValue
    public PlayerMessage n() {
        Assertions.i(!this.f10328k);
        if (this.f10326i == C.f9084b) {
            Assertions.a(this.f10327j);
        }
        this.f10328k = true;
        this.f10319b.e(this);
        return this;
    }

    @CanIgnoreReturnValue
    public PlayerMessage o(boolean z) {
        Assertions.i(!this.f10328k);
        this.f10327j = z;
        return this;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public PlayerMessage p(Handler handler) {
        return q(handler.getLooper());
    }

    @CanIgnoreReturnValue
    public PlayerMessage q(Looper looper) {
        Assertions.i(!this.f10328k);
        this.f10324g = looper;
        return this;
    }

    @CanIgnoreReturnValue
    public PlayerMessage r(@Nullable Object obj) {
        Assertions.i(!this.f10328k);
        this.f10323f = obj;
        return this;
    }

    @CanIgnoreReturnValue
    public PlayerMessage s(int i2, long j2) {
        boolean z = true;
        Assertions.i(!this.f10328k);
        if (j2 == C.f9084b) {
            z = false;
        }
        Assertions.a(z);
        if (i2 < 0 || (!this.f10321d.x() && i2 >= this.f10321d.w())) {
            throw new IllegalSeekPositionException(this.f10321d, i2, j2);
        }
        this.f10325h = i2;
        this.f10326i = j2;
        return this;
    }

    @CanIgnoreReturnValue
    public PlayerMessage t(long j2) {
        Assertions.i(!this.f10328k);
        this.f10326i = j2;
        return this;
    }

    @CanIgnoreReturnValue
    public PlayerMessage u(int i2) {
        Assertions.i(!this.f10328k);
        this.f10322e = i2;
        return this;
    }
}
