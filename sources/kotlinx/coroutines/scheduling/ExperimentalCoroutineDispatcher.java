package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB'\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u000bB\u001d\b\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b!\u0010 J+\u0010%\u001a\u00020\u00152\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0011\u001a\u00020\"2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018VX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "(IILjava/lang/String;)V", "(II)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "s0", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "S", "close", "()V", "toString", "()Ljava/lang/String;", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "q0", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "B0", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "tailDispatch", "x0", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "Z", "I", "X2", "Y2", "J", "Z2", "Ljava/lang/String;", "a3", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "Ljava/util/concurrent/Executor;", "i0", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int X2;
    private final long Y2;
    private final int Z;
    @NotNull
    private final String Z2;
    @NotNull
    private CoroutineScheduler a3;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility for Ktor 1.0-beta")
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3) {
        this(i2, i3, TasksKt.f29417e, (String) null, 8, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CoroutineDispatcher r0(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i2 = 16;
            }
            return experimentalCoroutineDispatcher.q0(i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    private final CoroutineScheduler s0() {
        return new CoroutineScheduler(this.Z, this.X2, this.Y2, this.Z2);
    }

    @NotNull
    public final CoroutineDispatcher B0(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i2).toString());
        } else if (i2 <= this.Z) {
            return new LimitingDispatcher(this, i2, (String) null, 0);
        } else {
            throw new IllegalArgumentException(("Expected parallelism level lesser than core pool size (" + this.Z + "), but have " + i2).toString());
        }
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.r(this.a3, runnable, (TaskContext) null, false, 6, (Object) null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.a3.R(coroutineContext, runnable);
        }
    }

    public void S(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        try {
            CoroutineScheduler.r(this.a3, runnable, (TaskContext) null, true, 2, (Object) null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.a3.S(coroutineContext, runnable);
        }
    }

    public void close() {
        this.a3.close();
    }

    @NotNull
    public Executor i0() {
        return this.a3;
    }

    @NotNull
    public final CoroutineDispatcher q0(int i2) {
        if (i2 > 0) {
            return new LimitingDispatcher(this, i2, (String) null, 1);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i2).toString());
    }

    @NotNull
    public String toString() {
        return super.toString() + "[scheduler = " + this.a3 + ']';
    }

    public final void x0(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        try {
            this.a3.q(runnable, taskContext, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.a3.U0(this.a3.f(runnable, taskContext));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? TasksKt.f29415c : i2, (i4 & 2) != 0 ? TasksKt.f29416d : i3);
    }

    public ExperimentalCoroutineDispatcher(int i2, int i3, long j2, @NotNull String str) {
        this.Z = i2;
        this.X2 = i3;
        this.Y2 = j2;
        this.Z2 = str;
        this.a3 = s0();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3, long j2, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, j2, (i4 & 8) != 0 ? "CoroutineScheduler" : str);
    }

    public ExperimentalCoroutineDispatcher(int i2, int i3, @NotNull String str) {
        this(i2, i3, TasksKt.f29417e, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExperimentalCoroutineDispatcher(int i2, int i3, String str, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? TasksKt.f29415c : i2, (i4 & 2) != 0 ? TasksKt.f29416d : i3, (i4 & 4) != 0 ? TasksKt.f29413a : str);
    }
}
