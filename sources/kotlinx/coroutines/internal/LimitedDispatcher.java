package kotlinx.coroutines.internal;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ*\u0010\u000e\u001a\u00020\f2\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015HAø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ&\u0010!\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010&J#\u0010'\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b'\u0010(J#\u0010)\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003H\u0017¢\u0006\u0004\b)\u0010(R\u0014\u0010\u0005\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u001e\u00102\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030/8\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00107\u001a\u000603j\u0002`48\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/Delay;", "dispatcher", "", "parallelism", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "block", "Lkotlin/Function0;", "", "dispatch", "q0", "(Ljava/lang/Runnable;Lkotlin/jvm/functions/Function0;)V", "", "r0", "()Z", "i0", "(Ljava/lang/Runnable;)Z", "", "time", "Q", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/DisposableHandle;", "N", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "r", "(JLkotlinx/coroutines/CancellableContinuation;)V", "W", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "run", "()V", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "S", "Y", "Lkotlinx/coroutines/CoroutineDispatcher;", "Z", "I", "runningWorkers", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "Y2", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "queue", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Z2", "Ljava/lang/Object;", "workerAllocationLock", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class LimitedDispatcher extends CoroutineDispatcher implements Runnable, Delay {
    private final /* synthetic */ Delay X2;
    @NotNull
    private final CoroutineDispatcher Y;
    @NotNull
    private final LockFreeTaskQueue<Runnable> Y2;
    private final int Z;
    @NotNull
    private final Object Z2;
    private volatile int runningWorkers;

    public LimitedDispatcher(@NotNull CoroutineDispatcher coroutineDispatcher, int i2) {
        this.Y = coroutineDispatcher;
        this.Z = i2;
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.X2 = delay == null ? DefaultExecutorKt.a() : delay;
        this.Y2 = new LockFreeTaskQueue<>(false);
        this.Z2 = new Object();
    }

    private final boolean i0(Runnable runnable) {
        this.Y2.a(runnable);
        return this.runningWorkers >= this.Z;
    }

    private final void q0(Runnable runnable, Function0<Unit> function0) {
        if (!i0(runnable) && r0()) {
            function0.o();
        }
    }

    private final boolean r0() {
        synchronized (this.Z2) {
            if (this.runningWorkers >= this.Z) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @NotNull
    public DisposableHandle N(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return this.X2.N(j2, runnable, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object Q(long j2, @NotNull Continuation<? super Unit> continuation) {
        return this.X2.Q(j2, continuation);
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (!i0(runnable) && r0()) {
            this.Y.R(this, this);
        }
    }

    @InternalCoroutinesApi
    public void S(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        if (!i0(runnable) && r0()) {
            this.Y.S(this, this);
        }
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public CoroutineDispatcher W(int i2) {
        LimitedDispatcherKt.a(i2);
        return i2 >= this.Z ? this : super.W(i2);
    }

    public void r(long j2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        this.X2.r(j2, cancellableContinuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r1 = r4.Z2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r4.runningWorkers--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r4.Y2.c() != 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.runningWorkers++;
        r2 = kotlin.Unit.f28779a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L_0x0001:
            r1 = 0
        L_0x0002:
            kotlinx.coroutines.internal.LockFreeTaskQueue<java.lang.Runnable> r2 = r4.Y2
            java.lang.Object r2 = r2.g()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L_0x002a
            r2.run()     // Catch:{ all -> 0x0010 }
            goto L_0x0016
        L_0x0010:
            r2 = move-exception
            kotlin.coroutines.EmptyCoroutineContext r3 = kotlin.coroutines.EmptyCoroutineContext.s
            kotlinx.coroutines.CoroutineExceptionHandlerKt.b(r3, r2)
        L_0x0016:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L_0x0002
            kotlinx.coroutines.CoroutineDispatcher r2 = r4.Y
            boolean r2 = r2.T(r4)
            if (r2 == 0) goto L_0x0002
            kotlinx.coroutines.CoroutineDispatcher r0 = r4.Y
            r0.R(r4, r4)
            return
        L_0x002a:
            java.lang.Object r1 = r4.Z2
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + -1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            kotlinx.coroutines.internal.LockFreeTaskQueue<java.lang.Runnable> r2 = r4.Y2     // Catch:{ all -> 0x0047 }
            int r2 = r2.c()     // Catch:{ all -> 0x0047 }
            if (r2 != 0) goto L_0x003d
            monitor-exit(r1)
            return
        L_0x003d:
            int r2 = r4.runningWorkers     // Catch:{ all -> 0x0047 }
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch:{ all -> 0x0047 }
            kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            goto L_0x0001
        L_0x0047:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LimitedDispatcher.run():void");
    }
}
