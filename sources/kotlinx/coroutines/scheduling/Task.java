package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\b \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0011\u001a\u00020\u000e8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "submissionTime", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "<init>", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "()V", "s", "J", "X", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "a", "()I", "mode", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class Task implements Runnable {
    @NotNull
    @JvmField
    public TaskContext X;
    @JvmField
    public long s;

    public Task() {
        this(0, TasksKt.f29421i);
    }

    public final int a() {
        return this.X.G();
    }

    public Task(long j2, @NotNull TaskContext taskContext) {
        this.s = j2;
        this.X = taskContext;
    }
}
