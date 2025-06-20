package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "name", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "d", "(Ljava/lang/String;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "nThreads", "b", "(ILjava/lang/String;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ThreadPoolDispatcherKt {
    @NotNull
    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher b(int i2, @NotNull String str) {
        if (i2 >= 1) {
            return ExecutorsKt.d(Executors.newScheduledThreadPool(i2, new a(i2, str, new AtomicInteger())));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i2 + " specified").toString());
    }

    /* access modifiers changed from: private */
    public static final Thread c(int i2, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i2 != 1) {
            str = str + '-' + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    @NotNull
    @DelicateCoroutinesApi
    public static final ExecutorCoroutineDispatcher d(@NotNull String str) {
        return b(1, str);
    }
}
