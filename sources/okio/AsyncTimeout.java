package okio;

import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 )2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0014¢\u0006\u0004\b\r\u0010\u0003J\u0015\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0004\b\u001f\u0010\u001eR\u0016\u0010\"\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'\u0002\u0007\n\u0005\b20\u0001¨\u0006,"}, d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "<init>", "()V", "", "now", "z", "(J)J", "", "w", "", "x", "()Z", "C", "Lokio/Sink;", "sink", "A", "(Lokio/Sink;)Lokio/Sink;", "Lokio/Source;", "source", "B", "(Lokio/Source;)Lokio/Source;", "T", "Lkotlin/Function0;", "block", "D", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ljava/io/IOException;", "cause", "q", "(Ljava/io/IOException;)Ljava/io/IOException;", "y", "f", "Z", "inQueue", "g", "Lokio/AsyncTimeout;", "next", "h", "J", "timeoutAt", "i", "Companion", "Watchdog", "okio"}, k = 1, mv = {1, 5, 1})
public class AsyncTimeout extends Timeout {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f31348i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: j  reason: collision with root package name */
    private static final int f31349j = 65536;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final long f31350k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final long f31351l;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public static AsyncTimeout f31352m;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f31353f;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public AsyncTimeout f31354g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public long f31355h;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lokio/AsyncTimeout$Companion;", "", "<init>", "()V", "Lokio/AsyncTimeout;", "node", "", "timeoutNanos", "", "hasDeadline", "", "e", "(Lokio/AsyncTimeout;JZ)V", "d", "(Lokio/AsyncTimeout;)Z", "c", "()Lokio/AsyncTimeout;", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", "I", "head", "Lokio/AsyncTimeout;", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean d(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                if (!asyncTimeout.f31353f) {
                    return false;
                }
                asyncTimeout.f31353f = false;
                for (AsyncTimeout l2 = AsyncTimeout.f31352m; l2 != null; l2 = l2.f31354g) {
                    if (l2.f31354g == asyncTimeout) {
                        l2.f31354g = asyncTimeout.f31354g;
                        asyncTimeout.f31354g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0061 A[Catch:{ all -> 0x0027 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0086 A[Catch:{ all -> 0x0027 }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0076 A[EDGE_INSN: B:40:0x0076->B:26:0x0076 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void e(okio.AsyncTimeout r7, long r8, boolean r10) {
            /*
                r6 = this;
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)
                boolean r1 = r7.f31353f     // Catch:{ all -> 0x0027 }
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L_0x0095
                r7.f31353f = r2     // Catch:{ all -> 0x0027 }
                okio.AsyncTimeout r1 = okio.AsyncTimeout.f31352m     // Catch:{ all -> 0x0027 }
                if (r1 != 0) goto L_0x002a
                okio.AsyncTimeout$Companion r1 = okio.AsyncTimeout.f31348i     // Catch:{ all -> 0x0027 }
                okio.AsyncTimeout r1 = new okio.AsyncTimeout     // Catch:{ all -> 0x0027 }
                r1.<init>()     // Catch:{ all -> 0x0027 }
                okio.AsyncTimeout.f31352m = r1     // Catch:{ all -> 0x0027 }
                okio.AsyncTimeout$Watchdog r1 = new okio.AsyncTimeout$Watchdog     // Catch:{ all -> 0x0027 }
                r1.<init>()     // Catch:{ all -> 0x0027 }
                r1.start()     // Catch:{ all -> 0x0027 }
                goto L_0x002a
            L_0x0027:
                r7 = move-exception
                goto L_0x00a1
            L_0x002a:
                long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0027 }
                r3 = 0
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0044
                if (r10 == 0) goto L_0x0044
                long r3 = r7.d()     // Catch:{ all -> 0x0027 }
                long r3 = r3 - r1
                long r8 = java.lang.Math.min(r8, r3)     // Catch:{ all -> 0x0027 }
            L_0x003f:
                long r8 = r8 + r1
                r7.f31355h = r8     // Catch:{ all -> 0x0027 }
                goto L_0x0050
            L_0x0044:
                if (r5 == 0) goto L_0x0047
                goto L_0x003f
            L_0x0047:
                if (r10 == 0) goto L_0x008f
                long r8 = r7.d()     // Catch:{ all -> 0x0027 }
                r7.f31355h = r8     // Catch:{ all -> 0x0027 }
            L_0x0050:
                long r8 = r7.z(r1)     // Catch:{ all -> 0x0027 }
                okio.AsyncTimeout r10 = okio.AsyncTimeout.f31352m     // Catch:{ all -> 0x0027 }
            L_0x0058:
                kotlin.jvm.internal.Intrinsics.m(r10)     // Catch:{ all -> 0x0027 }
                okio.AsyncTimeout r3 = r10.f31354g     // Catch:{ all -> 0x0027 }
                if (r3 == 0) goto L_0x0076
                okio.AsyncTimeout r3 = r10.f31354g     // Catch:{ all -> 0x0027 }
                kotlin.jvm.internal.Intrinsics.m(r3)     // Catch:{ all -> 0x0027 }
                long r3 = r3.z(r1)     // Catch:{ all -> 0x0027 }
                int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r5 >= 0) goto L_0x0071
                goto L_0x0076
            L_0x0071:
                okio.AsyncTimeout r10 = r10.f31354g     // Catch:{ all -> 0x0027 }
                goto L_0x0058
            L_0x0076:
                okio.AsyncTimeout r8 = r10.f31354g     // Catch:{ all -> 0x0027 }
                r7.f31354g = r8     // Catch:{ all -> 0x0027 }
                r10.f31354g = r7     // Catch:{ all -> 0x0027 }
                okio.AsyncTimeout r7 = okio.AsyncTimeout.f31352m     // Catch:{ all -> 0x0027 }
                if (r10 != r7) goto L_0x008b
                java.lang.Class<okio.AsyncTimeout> r7 = okio.AsyncTimeout.class
                r7.notify()     // Catch:{ all -> 0x0027 }
            L_0x008b:
                kotlin.Unit r7 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0027 }
                monitor-exit(r0)
                return
            L_0x008f:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x0027 }
                r7.<init>()     // Catch:{ all -> 0x0027 }
                throw r7     // Catch:{ all -> 0x0027 }
            L_0x0095:
                java.lang.String r7 = "Unbalanced enter/exit"
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0027 }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0027 }
                r8.<init>(r7)     // Catch:{ all -> 0x0027 }
                throw r8     // Catch:{ all -> 0x0027 }
            L_0x00a1:
                monitor-exit(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Companion.e(okio.AsyncTimeout, long, boolean):void");
        }

        @Nullable
        public final AsyncTimeout c() throws InterruptedException {
            AsyncTimeout l2 = AsyncTimeout.f31352m;
            Intrinsics.m(l2);
            AsyncTimeout p = l2.f31354g;
            Class<AsyncTimeout> cls = AsyncTimeout.class;
            long nanoTime = System.nanoTime();
            if (p == null) {
                cls.wait(AsyncTimeout.f31350k);
                AsyncTimeout l3 = AsyncTimeout.f31352m;
                Intrinsics.m(l3);
                if (l3.f31354g != null || System.nanoTime() - nanoTime < AsyncTimeout.f31351l) {
                    return null;
                }
                return AsyncTimeout.f31352m;
            }
            long r = p.z(nanoTime);
            if (r > 0) {
                long j2 = r / 1000000;
                cls.wait(j2, (int) (r - (1000000 * j2)));
                return null;
            }
            AsyncTimeout l4 = AsyncTimeout.f31352m;
            Intrinsics.m(l4);
            l4.f31354g = p.f31354g;
            p.f31354g = null;
            return p;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
            if (r1 != null) goto L_0x001d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x001d, code lost:
            r1.C();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                java.lang.Class<okio.AsyncTimeout> r0 = okio.AsyncTimeout.class
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout$Companion r1 = okio.AsyncTimeout.f31348i     // Catch:{ all -> 0x0015 }
                okio.AsyncTimeout r1 = r1.c()     // Catch:{ all -> 0x0015 }
                okio.AsyncTimeout r2 = okio.AsyncTimeout.f31352m     // Catch:{ all -> 0x0015 }
                if (r1 != r2) goto L_0x0017
                r1 = 0
                okio.AsyncTimeout.f31352m = r1     // Catch:{ all -> 0x0015 }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x0015:
                r1 = move-exception
                goto L_0x0021
            L_0x0017:
                kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0015 }
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                if (r1 != 0) goto L_0x001d
                goto L_0x0000
            L_0x001d:
                r1.C()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0021:
                monitor-exit(r0)     // Catch:{ InterruptedException -> 0x0000 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60);
        f31350k = millis;
        f31351l = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* access modifiers changed from: private */
    public final long z(long j2) {
        return this.f31355h - j2;
    }

    @NotNull
    public final Sink A(@NotNull Sink sink) {
        Intrinsics.p(sink, "sink");
        return new AsyncTimeout$sink$1(this, sink);
    }

    @NotNull
    public final Source B(@NotNull Source source) {
        Intrinsics.p(source, "source");
        return new AsyncTimeout$source$1(this, source);
    }

    /* access modifiers changed from: protected */
    public void C() {
    }

    public final <T> T D(@NotNull Function0<? extends T> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        w();
        try {
            T o = function0.o();
            InlineMarker.d(1);
            if (!x()) {
                InlineMarker.c(1);
                return o;
            }
            throw q((IOException) null);
        } catch (IOException e2) {
            e = e2;
            if (x()) {
                e = q(e);
            }
            throw e;
        } catch (Throwable th) {
            InlineMarker.d(1);
            x();
            InlineMarker.c(1);
            throw th;
        }
    }

    @NotNull
    @PublishedApi
    public final IOException q(@Nullable IOException iOException) {
        return y(iOException);
    }

    public final void w() {
        long j2 = j();
        boolean f2 = f();
        if (j2 != 0 || f2) {
            f31348i.e(this, j2, f2);
        }
    }

    public final boolean x() {
        return f31348i.d(this);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public IOException y(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }
}
