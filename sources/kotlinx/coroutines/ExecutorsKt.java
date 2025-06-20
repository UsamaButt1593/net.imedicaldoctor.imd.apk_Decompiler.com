package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0005¢\u0006\u0004\b\b\u0010\t*\u0010\b\u0007\u0010\u000b\"\u00020\u00012\u00020\u0001B\u0002\b\n¨\u0006\f"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "d", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "c", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", "b", "(Lkotlinx/coroutines/CoroutineDispatcher;)Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/ExperimentalCoroutinesApi;", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ExecutorsKt {
    @ExperimentalCoroutinesApi
    public static /* synthetic */ void a() {
    }

    @NotNull
    public static final Executor b(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Executor i0;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = coroutineDispatcher instanceof ExecutorCoroutineDispatcher ? (ExecutorCoroutineDispatcher) coroutineDispatcher : null;
        return (executorCoroutineDispatcher == null || (i0 = executorCoroutineDispatcher.i0()) == null) ? new DispatcherExecutor(coroutineDispatcher) : i0;
    }

    @NotNull
    @JvmName(name = "from")
    public static final CoroutineDispatcher c(@NotNull Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        DispatcherExecutor dispatcherExecutor = executor instanceof DispatcherExecutor ? (DispatcherExecutor) executor : null;
        return (dispatcherExecutor == null || (coroutineDispatcher = dispatcherExecutor.s) == null) ? new ExecutorCoroutineDispatcherImpl(executor) : coroutineDispatcher;
    }

    @NotNull
    @JvmName(name = "from")
    public static final ExecutorCoroutineDispatcher d(@NotNull ExecutorService executorService) {
        return new ExecutorCoroutineDispatcherImpl(executorService);
    }
}
