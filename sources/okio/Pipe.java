package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000b\u001a\u00020\b*\u00020\u00062\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\u001a8\u0000X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u001f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\"\u0010+\u001a\u00020\u001f8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R$\u0010/\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010,\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u000fR\u0017\u0010\r\u001a\u00020\u00068G¢\u0006\f\n\u0004\b!\u0010,\u001a\u0004\b0\u0010\u0011R\u0017\u00103\u001a\u00020\u00128G¢\u0006\f\n\u0004\b-\u00101\u001a\u0004\b2\u0010\u0014¨\u00064"}, d2 = {"Lokio/Pipe;", "", "", "maxBufferSize", "<init>", "(J)V", "Lokio/Sink;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "e", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "sink", "d", "(Lokio/Sink;)V", "a", "()Lokio/Sink;", "Lokio/Source;", "b", "()Lokio/Source;", "c", "()V", "J", "i", "()J", "Lokio/Buffer;", "Lokio/Buffer;", "f", "()Lokio/Buffer;", "buffer", "", "Z", "g", "()Z", "l", "(Z)V", "canceled", "j", "n", "sinkClosed", "k", "o", "sourceClosed", "Lokio/Sink;", "h", "m", "foldedSink", "p", "Lokio/Source;", "q", "source", "okio"}, k = 1, mv = {1, 5, 1})
public final class Pipe {

    /* renamed from: a  reason: collision with root package name */
    private final long f31371a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Buffer f31372b = new Buffer();

    /* renamed from: c  reason: collision with root package name */
    private boolean f31373c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31374d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31375e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Sink f31376f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Sink f31377g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final Source f31378h;

    public Pipe(long j2) {
        this.f31371a = j2;
        if (j2 >= 1) {
            this.f31377g = new Pipe$sink$1(this);
            this.f31378h = new Pipe$source$1(this);
            return;
        }
        throw new IllegalArgumentException(Intrinsics.C("maxBufferSize < 1: ", Long.valueOf(i())).toString());
    }

    private final void e(Sink sink, Function1<? super Sink, Unit> function1) {
        Timeout j2 = sink.j();
        Timeout j3 = p().j();
        long j4 = j2.j();
        long a2 = Timeout.f31399d.a(j3.j(), j2.j());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        j2.i(a2, timeUnit);
        if (j2.f()) {
            long d2 = j2.d();
            if (j3.f()) {
                j2.e(Math.min(j2.d(), j3.d()));
            }
            try {
                function1.f(sink);
                Unit unit = Unit.f28779a;
                InlineMarker.d(1);
                j2.i(j4, timeUnit);
                if (j3.f()) {
                    j2.e(d2);
                }
            } catch (Throwable th) {
                InlineMarker.d(1);
                j2.i(j4, TimeUnit.NANOSECONDS);
                if (j3.f()) {
                    j2.e(d2);
                }
                InlineMarker.c(1);
                throw th;
            }
        } else {
            if (j3.f()) {
                j2.e(j3.d());
            }
            try {
                function1.f(sink);
                Unit unit2 = Unit.f28779a;
                InlineMarker.d(1);
                j2.i(j4, timeUnit);
                if (j3.f()) {
                    j2.a();
                }
            } catch (Throwable th2) {
                InlineMarker.d(1);
                j2.i(j4, TimeUnit.NANOSECONDS);
                if (j3.f()) {
                    j2.a();
                }
                InlineMarker.c(1);
                throw th2;
            }
        }
        InlineMarker.c(1);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    public final Sink a() {
        return this.f31377g;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "source", imports = {}))
    @JvmName(name = "-deprecated_source")
    public final Source b() {
        return this.f31378h;
    }

    public final void c() {
        synchronized (this.f31372b) {
            l(true);
            f().d();
            f().notifyAll();
            Unit unit = Unit.f28779a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r8.u1(r3, r3.L0());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (r1 == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005f, code lost:
        r8.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        monitor-enter(r7.f31372b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        o(true);
        f().notifyAll();
        r1 = kotlin.Unit.f28779a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
        throw r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(@org.jetbrains.annotations.NotNull okio.Sink r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.p(r8, r0)
        L_0x0005:
            okio.Buffer r0 = r7.f31372b
            monitor-enter(r0)
            okio.Sink r1 = r7.h()     // Catch:{ all -> 0x002c }
            r2 = 1
            if (r1 != 0) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0082
            boolean r1 = r7.g()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0077
            okio.Buffer r1 = r7.f()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.o0()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002e
            r7.o(r2)     // Catch:{ all -> 0x002c }
            r7.m(r8)     // Catch:{ all -> 0x002c }
            monitor-exit(r0)
            return
        L_0x002c:
            r8 = move-exception
            goto L_0x008e
        L_0x002e:
            boolean r1 = r7.j()     // Catch:{ all -> 0x002c }
            okio.Buffer r3 = new okio.Buffer     // Catch:{ all -> 0x002c }
            r3.<init>()     // Catch:{ all -> 0x002c }
            okio.Buffer r4 = r7.f()     // Catch:{ all -> 0x002c }
            okio.Buffer r5 = r7.f()     // Catch:{ all -> 0x002c }
            long r5 = r5.L0()     // Catch:{ all -> 0x002c }
            r3.u1(r4, r5)     // Catch:{ all -> 0x002c }
            okio.Buffer r4 = r7.f()     // Catch:{ all -> 0x002c }
            r4.notifyAll()     // Catch:{ all -> 0x002c }
            kotlin.Unit r4 = kotlin.Unit.f28779a     // Catch:{ all -> 0x002c }
            monitor-exit(r0)
            long r4 = r3.L0()     // Catch:{ all -> 0x005d }
            r8.u1(r3, r4)     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x005f
            r8.close()     // Catch:{ all -> 0x005d }
            goto L_0x0005
        L_0x005d:
            r8 = move-exception
            goto L_0x0063
        L_0x005f:
            r8.flush()     // Catch:{ all -> 0x005d }
            goto L_0x0005
        L_0x0063:
            okio.Buffer r0 = r7.f31372b
            monitor-enter(r0)
            r7.o(r2)     // Catch:{ all -> 0x0074 }
            okio.Buffer r1 = r7.f()     // Catch:{ all -> 0x0074 }
            r1.notifyAll()     // Catch:{ all -> 0x0074 }
            kotlin.Unit r1 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0074 }
            monitor-exit(r0)
            throw r8
        L_0x0074:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        L_0x0077:
            r7.m(r8)     // Catch:{ all -> 0x002c }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x002c }
            java.lang.String r1 = "canceled"
            r8.<init>(r1)     // Catch:{ all -> 0x002c }
            throw r8     // Catch:{ all -> 0x002c }
        L_0x0082:
            java.lang.String r8 = "sink already folded"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002c }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x002c }
            r1.<init>(r8)     // Catch:{ all -> 0x002c }
            throw r1     // Catch:{ all -> 0x002c }
        L_0x008e:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe.d(okio.Sink):void");
    }

    @NotNull
    public final Buffer f() {
        return this.f31372b;
    }

    public final boolean g() {
        return this.f31373c;
    }

    @Nullable
    public final Sink h() {
        return this.f31376f;
    }

    public final long i() {
        return this.f31371a;
    }

    public final boolean j() {
        return this.f31374d;
    }

    public final boolean k() {
        return this.f31375e;
    }

    public final void l(boolean z) {
        this.f31373c = z;
    }

    public final void m(@Nullable Sink sink) {
        this.f31376f = sink;
    }

    public final void n(boolean z) {
        this.f31374d = z;
    }

    public final void o(boolean z) {
        this.f31375e = z;
    }

    @NotNull
    @JvmName(name = "sink")
    public final Sink p() {
        return this.f31377g;
    }

    @NotNull
    @JvmName(name = "source")
    public final Source q() {
        return this.f31378h;
    }
}
