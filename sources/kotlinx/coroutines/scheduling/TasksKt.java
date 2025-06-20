package kotlinx.coroutines.scheduling;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u000b\u001a\u00020\b8\u0000X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\r\u001a\u00020\b8\u0000X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\n\"\u0014\u0010\u000f\u001a\u00020\u00048\u0000X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u0013\u001a\u00020\u00108\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\b8\u0000XT¢\u0006\u0006\n\u0004\b\u0014\u0010\n\"\u0014\u0010\u0017\u001a\u00020\b8\u0000XT¢\u0006\u0006\n\u0004\b\u0016\u0010\n\"\u0014\u0010\u001b\u001a\u00020\u00188\u0000X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\"\u0014\u0010\u001d\u001a\u00020\u00188\u0000X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a\"\u0019\u0010!\u001a\u00020\u001f*\u00020\u001e8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0001\u0010 ¨\u0006\""}, d2 = {"", "a", "Ljava/lang/String;", "DEFAULT_SCHEDULER_NAME", "", "b", "J", "WORK_STEALING_TIME_RESOLUTION_NS", "", "c", "I", "CORE_POOL_SIZE", "d", "MAX_POOL_SIZE", "e", "IDLE_WORKER_KEEP_ALIVE_NS", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "f", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "schedulerTimeSource", "g", "TASK_NON_BLOCKING", "h", "TASK_PROBABLY_BLOCKING", "Lkotlinx/coroutines/scheduling/TaskContext;", "i", "Lkotlinx/coroutines/scheduling/TaskContext;", "NonBlockingContext", "j", "BlockingContext", "Lkotlinx/coroutines/scheduling/Task;", "", "(Lkotlinx/coroutines/scheduling/Task;)Z", "isBlocking", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class TasksKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f29413a = "DefaultDispatcher";
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final long f29414b = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.resolution.ns", SilenceSkippingAudioProcessor.A, 0, 0, 12, (Object) null);
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final int f29415c = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.u(SystemPropsKt.a(), 2), 1, 0, 8, (Object) null);
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final int f29416d = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.scheduler.max.pool.size", CoroutineScheduler.o3, 0, CoroutineScheduler.o3, 4, (Object) null);
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final long f29417e = TimeUnit.SECONDS.toNanos(SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, (Object) null));
    @NotNull
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static SchedulerTimeSource f29418f = NanoTimeSource.f29412a;

    /* renamed from: g  reason: collision with root package name */
    public static final int f29419g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f29420h = 1;
    @NotNull
    @JvmField

    /* renamed from: i  reason: collision with root package name */
    public static final TaskContext f29421i = new TaskContextImpl(0);
    @NotNull
    @JvmField

    /* renamed from: j  reason: collision with root package name */
    public static final TaskContext f29422j = new TaskContextImpl(1);

    public static final boolean a(@NotNull Task task) {
        return task.X.G() == 1;
    }
}
