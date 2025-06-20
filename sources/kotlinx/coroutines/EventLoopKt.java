package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u000f\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\t\u001a\u00020\u00072\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "a", "()Lkotlinx/coroutines/EventLoop;", "", "c", "()J", "Lkotlin/Function0;", "", "block", "b", "(Lkotlin/jvm/functions/Function0;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class EventLoopKt {
    @NotNull
    public static final EventLoop a() {
        return new BlockingEventLoop(Thread.currentThread());
    }

    public static final void b(@NotNull Function0<Unit> function0) {
        function0.o();
    }

    @InternalCoroutinesApi
    public static final long c() {
        EventLoop a2 = ThreadLocalEventLoop.f29217a.a();
        if (a2 != null) {
            return a2.J0();
        }
        return Long.MAX_VALUE;
    }
}
