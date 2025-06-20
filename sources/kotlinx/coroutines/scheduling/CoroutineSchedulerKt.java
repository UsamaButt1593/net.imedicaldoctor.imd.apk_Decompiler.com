package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.scheduling.CoroutineScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Ljava/lang/Thread;", "thread", "", "a", "(Ljava/lang/Thread;)Z", "b", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CoroutineSchedulerKt {
    @JvmName(name = "isSchedulerWorker")
    public static final boolean a(@NotNull Thread thread) {
        return thread instanceof CoroutineScheduler.Worker;
    }

    @JvmName(name = "mayNotBlock")
    public static final boolean b(@NotNull Thread thread) {
        return (thread instanceof CoroutineScheduler.Worker) && ((CoroutineScheduler.Worker) thread).X == CoroutineScheduler.WorkerState.CPU_ACQUIRED;
    }
}
