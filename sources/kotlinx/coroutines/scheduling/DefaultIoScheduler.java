package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchersKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00060\u0005j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0012\u001a\u00060\u0005j\u0002`\u0011H\u0017¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultIoScheduler;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "Ljava/lang/Runnable;", "command", "", "execute", "(Ljava/lang/Runnable;)V", "", "parallelism", "Lkotlinx/coroutines/CoroutineDispatcher;", "W", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/Runnable;", "block", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "S", "close", "", "toString", "()Ljava/lang/String;", "X2", "Lkotlinx/coroutines/CoroutineDispatcher;", "default", "i0", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {
    @NotNull
    private static final CoroutineDispatcher X2 = UnlimitedIoScheduler.Y.W(SystemPropsKt__SystemProps_commonKt.d(DispatchersKt.f29190a, RangesKt.u(64, SystemPropsKt.a()), 0, 0, 12, (Object) null));
    @NotNull
    public static final DefaultIoScheduler Z = new DefaultIoScheduler();

    private DefaultIoScheduler() {
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        X2.R(coroutineContext, runnable);
    }

    @InternalCoroutinesApi
    public void S(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        X2.S(coroutineContext, runnable);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public CoroutineDispatcher W(int i2) {
        return UnlimitedIoScheduler.Y.W(i2);
    }

    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    public void execute(@NotNull Runnable runnable) {
        R(EmptyCoroutineContext.s, runnable);
    }

    @NotNull
    public Executor i0() {
        return this;
    }

    @NotNull
    public String toString() {
        return "Dispatchers.IO";
    }
}
