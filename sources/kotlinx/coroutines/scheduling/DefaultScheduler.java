package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "<init>", "()V", "", "C0", "close", "", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {
    @NotNull
    public static final DefaultScheduler b3 = new DefaultScheduler();

    private DefaultScheduler() {
        super(TasksKt.f29415c, TasksKt.f29416d, TasksKt.f29417e, TasksKt.f29413a);
    }

    public final void C0() {
        super.close();
    }

    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @NotNull
    public String toString() {
        return "Dispatchers.Default";
    }
}
