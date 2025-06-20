package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.ConcurrentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f*\u00020\u00072\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u001a\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "Ljava/util/concurrent/Executor;", "executor", "<init>", "(Ljava/util/concurrent/Executor;)V", "Ljava/util/concurrent/ScheduledExecutorService;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "", "timeMillis", "Ljava/util/concurrent/ScheduledFuture;", "r0", "(Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;J)Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/RejectedExecutionException;", "exception", "", "q0", "(Lkotlin/coroutines/CoroutineContext;Ljava/util/concurrent/RejectedExecutionException;)V", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "r", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "N", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "close", "()V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Z", "Ljava/util/concurrent/Executor;", "i0", "()Ljava/util/concurrent/Executor;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {
    @NotNull
    private final Executor Z;

    public ExecutorCoroutineDispatcherImpl(@NotNull Executor executor) {
        this.Z = executor;
        ConcurrentKt.c(i0());
    }

    private final void q0(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        JobKt.f(coroutineContext, ExceptionsKt.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> r0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j2) {
        try {
            return scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            q0(coroutineContext, e2);
            return null;
        }
    }

    @NotNull
    public DisposableHandle N(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        Executor i0 = i0();
        ScheduledFuture<?> scheduledFuture = null;
        ScheduledExecutorService scheduledExecutorService = i0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) i0 : null;
        if (scheduledExecutorService != null) {
            scheduledFuture = r0(scheduledExecutorService, runnable, coroutineContext, j2);
        }
        return scheduledFuture != null ? new DisposableFutureHandle(scheduledFuture) : DefaultExecutor.a3.N(j2, runnable, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object Q(long j2, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.a(this, j2, continuation);
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Runnable runnable2;
        try {
            Executor i0 = i0();
            AbstractTimeSource b2 = AbstractTimeSourceKt.b();
            if (b2 != null) {
                runnable2 = b2.i(runnable);
                if (runnable2 == null) {
                }
                i0.execute(runnable2);
            }
            runnable2 = runnable;
            i0.execute(runnable2);
        } catch (RejectedExecutionException e2) {
            AbstractTimeSource b3 = AbstractTimeSourceKt.b();
            if (b3 != null) {
                b3.f();
            }
            q0(coroutineContext, e2);
            Dispatchers.c().R(coroutineContext, runnable);
        }
    }

    public void close() {
        Executor i0 = i0();
        ExecutorService executorService = i0 instanceof ExecutorService ? (ExecutorService) i0 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) obj).i0() == i0();
    }

    public int hashCode() {
        return System.identityHashCode(i0());
    }

    @NotNull
    public Executor i0() {
        return this.Z;
    }

    public void r(long j2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        Executor i0 = i0();
        ScheduledFuture<?> scheduledFuture = null;
        ScheduledExecutorService scheduledExecutorService = i0 instanceof ScheduledExecutorService ? (ScheduledExecutorService) i0 : null;
        if (scheduledExecutorService != null) {
            scheduledFuture = r0(scheduledExecutorService, new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.g(), j2);
        }
        if (scheduledFuture != null) {
            JobKt.w(cancellableContinuation, scheduledFuture);
        } else {
            DefaultExecutor.a3.r(j2, cancellableContinuation);
        }
    }

    @NotNull
    public String toString() {
        return i0().toString();
    }
}
