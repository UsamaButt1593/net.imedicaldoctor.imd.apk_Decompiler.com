package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/scheduling/NanoTimeSource;", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "<init>", "()V", "", "a", "()J", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class NanoTimeSource extends SchedulerTimeSource {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final NanoTimeSource f29412a = new NanoTimeSource();

    private NanoTimeSource() {
    }

    public long a() {
        return System.nanoTime();
    }
}
