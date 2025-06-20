package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Thread;", "thread", "<init>", "(Ljava/lang/Thread;)V", "a3", "Ljava/lang/Thread;", "N0", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class BlockingEventLoop extends EventLoopImplBase {
    @NotNull
    private final Thread a3;

    public BlockingEventLoop(@NotNull Thread thread) {
        this.a3 = thread;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Thread N0() {
        return this.a3;
    }
}
