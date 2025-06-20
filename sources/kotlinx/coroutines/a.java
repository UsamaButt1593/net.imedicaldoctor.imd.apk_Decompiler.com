package kotlinx.coroutines;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class a implements ThreadFactory {
    public final /* synthetic */ String X;
    public final /* synthetic */ AtomicInteger Y;
    public final /* synthetic */ int s;

    public /* synthetic */ a(int i2, String str, AtomicInteger atomicInteger) {
        this.s = i2;
        this.X = str;
        this.Y = atomicInteger;
    }

    public final Thread newThread(Runnable runnable) {
        return ThreadPoolDispatcherKt.c(this.s, this.X, this.Y, runnable);
    }
}
