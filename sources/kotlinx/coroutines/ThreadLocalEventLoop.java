package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "<init>", "()V", "Lkotlinx/coroutines/EventLoop;", "a", "()Lkotlinx/coroutines/EventLoop;", "", "c", "eventLoop", "d", "(Lkotlinx/coroutines/EventLoop;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "b", "Ljava/lang/ThreadLocal;", "ref", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ThreadLocalEventLoop {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocalEventLoop f29217a = new ThreadLocalEventLoop();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<EventLoop> f29218b = new ThreadLocal<>();

    private ThreadLocalEventLoop() {
    }

    @Nullable
    public final EventLoop a() {
        return f29218b.get();
    }

    @NotNull
    public final EventLoop b() {
        ThreadLocal<EventLoop> threadLocal = f29218b;
        EventLoop eventLoop = threadLocal.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        EventLoop a2 = EventLoopKt.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void c() {
        f29218b.set((Object) null);
    }

    public final void d(@NotNull EventLoop eventLoop) {
        f29218b.set(eventLoop);
    }
}
