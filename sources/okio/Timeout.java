package okio;

import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u0015\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010%R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010%\u0002\u0007\n\u0005\b20\u0001¨\u0006("}, d2 = {"Lokio/Timeout;", "", "<init>", "()V", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "i", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", "j", "()J", "", "f", "()Z", "d", "deadlineNanoTime", "e", "(J)Lokio/Timeout;", "duration", "c", "b", "()Lokio/Timeout;", "a", "", "h", "monitor", "k", "(Ljava/lang/Object;)V", "T", "other", "Lkotlin/Function0;", "block", "g", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Z", "hasDeadline", "J", "timeoutNanos", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public class Timeout {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f31399d = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final Timeout f31400e = new Timeout$Companion$NONE$1();

    /* renamed from: a  reason: collision with root package name */
    private boolean f31401a;

    /* renamed from: b  reason: collision with root package name */
    private long f31402b;

    /* renamed from: c  reason: collision with root package name */
    private long f31403c;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lokio/Timeout$Companion;", "", "<init>", "()V", "", "aNanos", "bNanos", "a", "(JJ)J", "Lokio/Timeout;", "NONE", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public final long a(long j2, long j3) {
            return (j2 != 0 && (j3 == 0 || j2 < j3)) ? j2 : j3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @NotNull
    public Timeout a() {
        this.f31401a = false;
        return this;
    }

    @NotNull
    public Timeout b() {
        this.f31403c = 0;
        return this;
    }

    @NotNull
    public final Timeout c(long j2, @NotNull TimeUnit timeUnit) {
        Intrinsics.p(timeUnit, "unit");
        if (j2 > 0) {
            return e(System.nanoTime() + timeUnit.toNanos(j2));
        }
        throw new IllegalArgumentException(Intrinsics.C("duration <= 0: ", Long.valueOf(j2)).toString());
    }

    public long d() {
        if (this.f31401a) {
            return this.f31402b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    @NotNull
    public Timeout e(long j2) {
        this.f31401a = true;
        this.f31402b = j2;
        return this;
    }

    public boolean f() {
        return this.f31401a;
    }

    public final <T> T g(@NotNull Timeout timeout, @NotNull Function0<? extends T> function0) {
        Intrinsics.p(timeout, "other");
        Intrinsics.p(function0, CSS.Value.v0);
        long j2 = j();
        long a2 = f31399d.a(timeout.j(), j());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        i(a2, timeUnit);
        if (f()) {
            long d2 = d();
            if (timeout.f()) {
                e(Math.min(d(), timeout.d()));
            }
            try {
                T o = function0.o();
                InlineMarker.d(1);
                i(j2, timeUnit);
                if (timeout.f()) {
                    e(d2);
                }
                InlineMarker.c(1);
                return o;
            } catch (Throwable th) {
                InlineMarker.d(1);
                i(j2, TimeUnit.NANOSECONDS);
                if (timeout.f()) {
                    e(d2);
                }
                InlineMarker.c(1);
                throw th;
            }
        } else {
            if (timeout.f()) {
                e(timeout.d());
            }
            try {
                T o2 = function0.o();
                InlineMarker.d(1);
                i(j2, timeUnit);
                if (timeout.f()) {
                    a();
                }
                InlineMarker.c(1);
                return o2;
            } catch (Throwable th2) {
                InlineMarker.d(1);
                i(j2, TimeUnit.NANOSECONDS);
                if (timeout.f()) {
                    a();
                }
                InlineMarker.c(1);
                throw th2;
            }
        }
    }

    public void h() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.f31401a && this.f31402b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @NotNull
    public Timeout i(long j2, @NotNull TimeUnit timeUnit) {
        Intrinsics.p(timeUnit, "unit");
        if (j2 >= 0) {
            this.f31403c = timeUnit.toNanos(j2);
            return this;
        }
        throw new IllegalArgumentException(Intrinsics.C("timeout < 0: ", Long.valueOf(j2)).toString());
    }

    public long j() {
        return this.f31403c;
    }

    public final void k(@NotNull Object obj) throws InterruptedIOException {
        Intrinsics.p(obj, "monitor");
        try {
            boolean f2 = f();
            long j2 = j();
            long j3 = 0;
            if (f2 || j2 != 0) {
                long nanoTime = System.nanoTime();
                if (f2 && j2 != 0) {
                    j2 = Math.min(j2, d() - nanoTime);
                } else if (f2) {
                    j2 = d() - nanoTime;
                }
                if (j2 > 0) {
                    long j4 = j2 / 1000000;
                    Long.signum(j4);
                    obj.wait(j4, (int) (j2 - (1000000 * j4)));
                    j3 = System.nanoTime() - nanoTime;
                }
                if (j3 >= j2) {
                    throw new InterruptedIOException("timeout");
                }
                return;
            }
            obj.wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
