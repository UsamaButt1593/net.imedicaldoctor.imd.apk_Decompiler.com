package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0017¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/scheduling/UnlimitedIoScheduler;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "S", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "R", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class UnlimitedIoScheduler extends CoroutineDispatcher {
    @NotNull
    public static final UnlimitedIoScheduler Y = new UnlimitedIoScheduler();

    private UnlimitedIoScheduler() {
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        DefaultScheduler.b3.r0(runnable, TasksKt.f29422j, false);
    }

    @InternalCoroutinesApi
    public void S(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        DefaultScheduler.b3.r0(runnable, TasksKt.f29422j, true);
    }
}
