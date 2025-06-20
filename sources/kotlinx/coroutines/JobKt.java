package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class JobKt {
    public static final void A(@NotNull Job job) {
        JobKt__JobKt.y(job);
    }

    @NotNull
    public static final Job B(@NotNull CoroutineContext coroutineContext) {
        return JobKt__JobKt.z(coroutineContext);
    }

    public static final boolean C(@NotNull CoroutineContext coroutineContext) {
        return JobKt__JobKt.A(coroutineContext);
    }

    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return JobKt__JobKt.a(job);
    }

    public static final void f(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        JobKt__JobKt.f(coroutineContext, cancellationException);
    }

    public static final void g(@NotNull Job job, @NotNull String str, @Nullable Throwable th) {
        JobKt__JobKt.g(job, str, th);
    }

    @Nullable
    public static final Object l(@NotNull Job job, @NotNull Continuation<? super Unit> continuation) {
        return JobKt__JobKt.l(job, continuation);
    }

    public static final void o(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        JobKt__JobKt.o(coroutineContext, cancellationException);
    }

    public static final void r(@NotNull Job job, @Nullable CancellationException cancellationException) {
        JobKt__JobKt.r(job, cancellationException);
    }

    public static final void w(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Future<?> future) {
        JobKt__FutureKt.a(cancellableContinuation, future);
    }

    @NotNull
    @InternalCoroutinesApi
    public static final DisposableHandle x(@NotNull Job job, @NotNull Future<?> future) {
        return JobKt__FutureKt.b(job, future);
    }

    @NotNull
    public static final DisposableHandle y(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return JobKt__JobKt.w(job, disposableHandle);
    }

    public static final void z(@NotNull CoroutineContext coroutineContext) {
        JobKt__JobKt.x(coroutineContext);
    }
}
