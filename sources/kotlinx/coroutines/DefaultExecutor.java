package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0015\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00062\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0005J+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010\u001a\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0004\b!\u0010\u0005J\u0015\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0012¢\u0006\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0006XT¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u001e\u0010.\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b.\u0010/\u0012\u0004\b0\u0010\u0005R\u0014\u00104\u001a\u0002018\u0002XT¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00106\u001a\u0002018\u0002XT¢\u0006\u0006\n\u0004\b5\u00103R\u0014\u00108\u001a\u0002018\u0002XT¢\u0006\u0006\n\u0004\b7\u00103R\u0014\u0010:\u001a\u0002018\u0002XT¢\u0006\u0006\n\u0004\b9\u00103R\u0014\u0010<\u001a\u0002018\u0002XT¢\u0006\u0006\n\u0004\b;\u00103R\u0016\u0010=\u001a\u0002018\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u00103R\u0014\u0010?\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\rR\u0014\u0010A\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\rR\u0014\u0010C\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\nR\u0014\u0010E\u001a\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\r¨\u0006F"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "<init>", "()V", "", "o1", "Ljava/lang/Thread;", "h1", "()Ljava/lang/Thread;", "", "n1", "()Z", "f1", "task", "U0", "(Ljava/lang/Runnable;)V", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "P0", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "shutdown", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "N", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "run", "i1", "timeout", "p1", "(J)V", "", "b3", "Ljava/lang/String;", "THREAD_NAME", "c3", "J", "DEFAULT_KEEP_ALIVE_MS", "d3", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "j1", "", "e3", "I", "FRESH", "f3", "ACTIVE", "g3", "SHUTDOWN_REQ", "h3", "SHUTDOWN_ACK", "i3", "SHUTDOWN", "debugStatus", "k1", "isShutDown", "l1", "isShutdownRequested", "N0", "thread", "m1", "isThreadPresent", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    @Nullable
    private static volatile Thread _thread = null;
    @NotNull
    public static final DefaultExecutor a3;
    @NotNull
    public static final String b3 = "kotlinx.coroutines.DefaultExecutor";
    private static final long c3 = 1000;
    private static final long d3;
    private static volatile int debugStatus = 0;
    private static final int e3 = 0;
    private static final int f3 = 1;
    private static final int g3 = 2;
    private static final int h3 = 3;
    private static final int i3 = 4;

    static {
        Long l2;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        a3 = defaultExecutor;
        EventLoop.C0(defaultExecutor, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        d3 = timeUnit.toNanos(l2.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized void f1() {
        if (l1()) {
            debugStatus = 3;
            Y0();
            notifyAll();
        }
    }

    private final synchronized Thread h1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, b3);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private static /* synthetic */ void j1() {
    }

    private final boolean k1() {
        return debugStatus == 4;
    }

    private final boolean l1() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean n1() {
        if (l1()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void o1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @NotNull
    public DisposableHandle N(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return c1(j2, runnable);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Thread N0() {
        Thread thread = _thread;
        return thread == null ? h1() : thread;
    }

    /* access modifiers changed from: protected */
    public void P0(long j2, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        o1();
    }

    public void U0(@NotNull Runnable runnable) {
        if (k1()) {
            o1();
        }
        super.U0(runnable);
    }

    public final synchronized void i1() {
        debugStatus = 0;
        h1();
        while (debugStatus == 0) {
            wait();
        }
    }

    public final boolean m1() {
        return _thread != null;
    }

    public final synchronized void p1(long j2) {
        Unit unit;
        try {
            long currentTimeMillis = System.currentTimeMillis() + j2;
            if (!l1()) {
                debugStatus = 2;
            }
            while (debugStatus != 3 && _thread != null) {
                Thread thread = _thread;
                if (thread != null) {
                    AbstractTimeSource b2 = AbstractTimeSourceKt.b();
                    if (b2 != null) {
                        b2.g(thread);
                        unit = Unit.f28779a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.unpark(thread);
                    }
                }
                if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                    break;
                }
                wait(j2);
            }
            debugStatus = 0;
        } finally {
            while (true) {
            }
        }
    }

    public void run() {
        Unit unit;
        ThreadLocalEventLoop.f29217a.d(this);
        AbstractTimeSource b2 = AbstractTimeSourceKt.b();
        if (b2 != null) {
            b2.d();
        }
        try {
            if (!n1()) {
                _thread = null;
                f1();
                AbstractTimeSource b4 = AbstractTimeSourceKt.b();
                if (b4 != null) {
                    b4.h();
                }
                if (!D0()) {
                    N0();
                    return;
                }
                return;
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long J0 = J0();
                if (J0 == Long.MAX_VALUE) {
                    AbstractTimeSource b5 = AbstractTimeSourceKt.b();
                    long b6 = b5 != null ? b5.b() : System.nanoTime();
                    if (j2 == Long.MAX_VALUE) {
                        j2 = d3 + b6;
                    }
                    long j3 = j2 - b6;
                    if (j3 <= 0) {
                        _thread = null;
                        f1();
                        AbstractTimeSource b7 = AbstractTimeSourceKt.b();
                        if (b7 != null) {
                            b7.h();
                        }
                        if (!D0()) {
                            N0();
                            return;
                        }
                        return;
                    }
                    J0 = RangesKt.C(J0, j3);
                } else {
                    j2 = Long.MAX_VALUE;
                }
                if (J0 > 0) {
                    if (l1()) {
                        _thread = null;
                        f1();
                        AbstractTimeSource b8 = AbstractTimeSourceKt.b();
                        if (b8 != null) {
                            b8.h();
                        }
                        if (!D0()) {
                            N0();
                            return;
                        }
                        return;
                    }
                    AbstractTimeSource b9 = AbstractTimeSourceKt.b();
                    if (b9 != null) {
                        b9.c(this, J0);
                        unit = Unit.f28779a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, J0);
                    }
                }
            }
        } catch (Throwable th) {
            _thread = null;
            f1();
            AbstractTimeSource b10 = AbstractTimeSourceKt.b();
            if (b10 != null) {
                b10.h();
            }
            if (!D0()) {
                N0();
            }
            throw th;
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
