package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"okio/Pipe$sink$1", "Lokio/Sink;", "Lokio/Buffer;", "source", "", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "flush", "()V", "close", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "s", "Lokio/Timeout;", "timeout", "okio"}, k = 1, mv = {1, 5, 1})
public final class Pipe$sink$1 implements Sink {
    final /* synthetic */ Pipe X;
    @NotNull
    private final Timeout s = new Timeout();

    Pipe$sink$1(Pipe pipe) {
        this.X = pipe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        if (r2 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        r0 = r12.X;
        r1 = r2.j();
        r0 = r0.p().j();
        r3 = r1.j();
        r5 = okio.Timeout.f31399d.a(r0.j(), r1.j());
        r7 = java.util.concurrent.TimeUnit.NANOSECONDS;
        r1.i(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        if (r1.f() == false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        r5 = r1.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        if (r0.f() == false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007f, code lost:
        r1.e(java.lang.Math.min(r1.d(), r0.d()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0091, code lost:
        r1.i(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0098, code lost:
        if (r0.f() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009a, code lost:
        r1.e(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009f, code lost:
        r1.i(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a8, code lost:
        if (r0.f() != false) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        r1.e(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ad, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b2, code lost:
        if (r0.f() == false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b4, code lost:
        r1.e(r0.d());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00be, code lost:
        r1.i(r3, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c5, code lost:
        if (r0.f() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c7, code lost:
        r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cb, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        r1.i(r3, java.util.concurrent.TimeUnit.NANOSECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d5, code lost:
        if (r0.f() != false) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00da, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r12 = this;
            okio.Pipe r0 = r12.X
            okio.Buffer r0 = r0.f()
            okio.Pipe r1 = r12.X
            monitor-enter(r0)
            boolean r2 = r1.j()     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)
            return
        L_0x0011:
            okio.Sink r2 = r1.h()     // Catch:{ all -> 0x0034 }
            if (r2 != 0) goto L_0x0043
            boolean r2 = r1.k()     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0037
            okio.Buffer r2 = r1.f()     // Catch:{ all -> 0x0034 }
            long r2 = r2.L0()     // Catch:{ all -> 0x0034 }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x002c
            goto L_0x0037
        L_0x002c:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "source is closed"
            r1.<init>(r2)     // Catch:{ all -> 0x0034 }
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r1 = move-exception
            goto L_0x00db
        L_0x0037:
            r2 = 1
            r1.n(r2)     // Catch:{ all -> 0x0034 }
            okio.Buffer r1 = r1.f()     // Catch:{ all -> 0x0034 }
            r1.notifyAll()     // Catch:{ all -> 0x0034 }
            r2 = 0
        L_0x0043:
            kotlin.Unit r1 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0034 }
            monitor-exit(r0)
            if (r2 != 0) goto L_0x004a
            goto L_0x00ca
        L_0x004a:
            okio.Pipe r0 = r12.X
            okio.Timeout r1 = r2.j()
            okio.Sink r0 = r0.p()
            okio.Timeout r0 = r0.j()
            long r3 = r1.j()
            okio.Timeout$Companion r5 = okio.Timeout.f31399d
            long r6 = r0.j()
            long r8 = r1.j()
            long r5 = r5.a(r6, r8)
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.i(r5, r7)
            boolean r5 = r1.f()
            if (r5 == 0) goto L_0x00ae
            long r5 = r1.d()
            boolean r8 = r0.f()
            if (r8 == 0) goto L_0x008e
            long r8 = r1.d()
            long r10 = r0.d()
            long r8 = java.lang.Math.min(r8, r10)
            r1.e(r8)
        L_0x008e:
            r2.close()     // Catch:{ all -> 0x009e }
            r1.i(r3, r7)
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x00ca
            r1.e(r5)
            goto L_0x00ca
        L_0x009e:
            r2 = move-exception
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.i(r3, r7)
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x00ad
            r1.e(r5)
        L_0x00ad:
            throw r2
        L_0x00ae:
            boolean r5 = r0.f()
            if (r5 == 0) goto L_0x00bb
            long r5 = r0.d()
            r1.e(r5)
        L_0x00bb:
            r2.close()     // Catch:{ all -> 0x00cb }
            r1.i(r3, r7)
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x00ca
            r1.a()
        L_0x00ca:
            return
        L_0x00cb:
            r2 = move-exception
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1.i(r3, r5)
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x00da
            r1.a()
        L_0x00da:
            throw r2
        L_0x00db:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Pipe$sink$1.close():void");
    }

    public void flush() {
        Sink h2;
        Buffer f2 = this.X.f();
        Pipe pipe = this.X;
        synchronized (f2) {
            try {
                if (!(!pipe.j())) {
                    throw new IllegalStateException("closed".toString());
                } else if (!pipe.g()) {
                    h2 = pipe.h();
                    if (h2 == null) {
                        if (pipe.k()) {
                            if (pipe.f().L0() > 0) {
                                throw new IOException("source is closed");
                            }
                        }
                        h2 = null;
                    }
                    Unit unit = Unit.f28779a;
                } else {
                    throw new IOException("canceled");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (h2 != null) {
            Pipe pipe2 = this.X;
            Timeout j2 = h2.j();
            Timeout j3 = pipe2.p().j();
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
                    h2.flush();
                    j2.i(j4, timeUnit);
                    if (j3.f()) {
                        j2.e(d2);
                    }
                } catch (Throwable th2) {
                    j2.i(j4, TimeUnit.NANOSECONDS);
                    if (j3.f()) {
                        j2.e(d2);
                    }
                    throw th2;
                }
            } else {
                if (j3.f()) {
                    j2.e(j3.d());
                }
                try {
                    h2.flush();
                    j2.i(j4, timeUnit);
                    if (j3.f()) {
                        j2.a();
                    }
                } catch (Throwable th3) {
                    j2.i(j4, TimeUnit.NANOSECONDS);
                    if (j3.f()) {
                        j2.a();
                    }
                    throw th3;
                }
            }
        }
    }

    @NotNull
    public Timeout j() {
        return this.s;
    }

    public void u1(@NotNull Buffer buffer, long j2) {
        Sink sink;
        Intrinsics.p(buffer, "source");
        Buffer f2 = this.X.f();
        Pipe pipe = this.X;
        synchronized (f2) {
            try {
                if (!(!pipe.j())) {
                    throw new IllegalStateException("closed".toString());
                } else if (!pipe.g()) {
                    while (true) {
                        if (j2 <= 0) {
                            sink = null;
                            break;
                        }
                        sink = pipe.h();
                        if (sink != null) {
                            break;
                        } else if (!pipe.k()) {
                            long i2 = pipe.i() - pipe.f().L0();
                            if (i2 == 0) {
                                this.s.k(pipe.f());
                                if (pipe.g()) {
                                    throw new IOException("canceled");
                                }
                            } else {
                                long min = Math.min(i2, j2);
                                pipe.f().u1(buffer, min);
                                j2 -= min;
                                pipe.f().notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                    Unit unit = Unit.f28779a;
                } else {
                    throw new IOException("canceled");
                }
            } finally {
            }
        }
        if (sink != null) {
            Pipe pipe2 = this.X;
            Timeout j3 = sink.j();
            Timeout j4 = pipe2.p().j();
            long j5 = j3.j();
            long a2 = Timeout.f31399d.a(j4.j(), j3.j());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            j3.i(a2, timeUnit);
            if (j3.f()) {
                long d2 = j3.d();
                if (j4.f()) {
                    j3.e(Math.min(j3.d(), j4.d()));
                }
                try {
                    sink.u1(buffer, j2);
                    j3.i(j5, timeUnit);
                    if (j4.f()) {
                        j3.e(d2);
                    }
                } catch (Throwable th) {
                    j3.i(j5, TimeUnit.NANOSECONDS);
                    if (j4.f()) {
                        j3.e(d2);
                    }
                    throw th;
                }
            } else {
                if (j4.f()) {
                    j3.e(j4.d());
                }
                try {
                    sink.u1(buffer, j2);
                    j3.i(j5, timeUnit);
                    if (j4.f()) {
                        j3.a();
                    }
                } catch (Throwable th2) {
                    j3.i(j5, TimeUnit.NANOSECONDS);
                    if (j4.f()) {
                        j3.a();
                    }
                    throw th2;
                }
            }
        }
    }
}
