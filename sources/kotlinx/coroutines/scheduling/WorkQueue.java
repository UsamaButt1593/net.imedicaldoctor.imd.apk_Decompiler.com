package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.a;
import com.google.common.util.concurrent.I;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u0014*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0013J!\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\"R\u0014\u0010'\u001a\u00020$8@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020$8@X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&¨\u0006*"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "c", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "victim", "", "blockingOnly", "", "m", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "queue", "j", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "i", "()Lkotlinx/coroutines/scheduling/Task;", "", "d", "(Lkotlinx/coroutines/scheduling/Task;)V", "h", "fair", "a", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "l", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "k", "globalQueue", "g", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "e", "()I", "bufferSize", "f", "size", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class WorkQueue {

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29423b;

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f29424c;

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f29425d;

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f29426e;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReferenceArray<Task> f29427a = new AtomicReferenceArray<>(128);
    @NotNull
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;
    @NotNull
    private volatile /* synthetic */ int consumerIndex = 0;
    @NotNull
    private volatile /* synthetic */ Object lastScheduledTask = null;
    @NotNull
    private volatile /* synthetic */ int producerIndex = 0;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        f29423b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f29424c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f29425d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f29426e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public static /* synthetic */ Task b(WorkQueue workQueue, Task task, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return workQueue.a(task, z);
    }

    private final Task c(Task task) {
        if (task.X.G() == 1) {
            f29426e.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int i2 = this.producerIndex & WorkQueueKt.f29430c;
        while (this.f29427a.get(i2) != null) {
            Thread.yield();
        }
        this.f29427a.lazySet(i2, task);
        f29424c.incrementAndGet(this);
        return null;
    }

    private final void d(Task task) {
        if (task != null && task.X.G() == 1) {
            f29426e.decrementAndGet(this);
        }
    }

    private final Task i() {
        Task andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & WorkQueueKt.f29430c;
            if (f29425d.compareAndSet(this, i2, i2 + 1) && (andSet = this.f29427a.getAndSet(i3, (Object) null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(GlobalQueue globalQueue) {
        Task i2 = i();
        if (i2 == null) {
            return false;
        }
        globalQueue.a(i2);
        return true;
    }

    private final long m(WorkQueue workQueue, boolean z) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2;
            }
            if (z && task.X.G() != 1) {
                return -2;
            }
            long a2 = TasksKt.f29418f.a() - task.s;
            long j2 = TasksKt.f29414b;
            if (a2 < j2) {
                return j2 - a2;
            }
        } while (!a.a(f29423b, workQueue, task, (Object) null));
        b(this, task, false, 2, (Object) null);
        return -1;
    }

    @Nullable
    public final Task a(@NotNull Task task, boolean z) {
        if (z) {
            return c(task);
        }
        Task task2 = (Task) f29423b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return c(task2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(@NotNull GlobalQueue globalQueue) {
        Task task = (Task) f29423b.getAndSet(this, (Object) null);
        if (task != null) {
            globalQueue.a(task);
        }
        do {
        } while (j(globalQueue));
    }

    @Nullable
    public final Task h() {
        Task task = (Task) f29423b.getAndSet(this, (Object) null);
        return task == null ? i() : task;
    }

    public final long k(@NotNull WorkQueue workQueue) {
        int i2 = workQueue.consumerIndex;
        int i3 = workQueue.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = workQueue.f29427a;
        while (i2 != i3) {
            int i4 = i2 & WorkQueueKt.f29430c;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i4);
            if (task == null || task.X.G() != 1 || !I.a(atomicReferenceArray, i4, task, (Object) null)) {
                i2++;
            } else {
                f29426e.decrementAndGet(workQueue);
                b(this, task, false, 2, (Object) null);
                return -1;
            }
        }
        return m(workQueue, true);
    }

    public final long l(@NotNull WorkQueue workQueue) {
        Task i2 = workQueue.i();
        if (i2 == null) {
            return m(workQueue, false);
        }
        b(this, i2, false, 2, (Object) null);
        return -1;
    }
}
