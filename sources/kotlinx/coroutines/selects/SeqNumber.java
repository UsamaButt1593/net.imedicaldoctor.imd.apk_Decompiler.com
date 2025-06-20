package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SeqNumber;", "", "<init>", "()V", "", "a", "()J", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class SeqNumber {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f29442a = AtomicLongFieldUpdater.newUpdater(SeqNumber.class, "number");
    @NotNull
    private volatile /* synthetic */ long number = 1;

    public final long a() {
        return f29442a.incrementAndGet(this);
    }
}
