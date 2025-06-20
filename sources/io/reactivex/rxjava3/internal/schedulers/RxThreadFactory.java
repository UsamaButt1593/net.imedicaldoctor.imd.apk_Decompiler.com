package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long Z = -7789753024099756196L;
    final int X;
    final boolean Y;
    final String s;

    static final class RxCustomThread extends Thread implements NonBlockingThread {
        RxCustomThread(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public Thread newThread(@NonNull Runnable runnable) {
        String str = this.s + '-' + incrementAndGet();
        Thread rxCustomThread = this.Y ? new RxCustomThread(runnable, str) : new Thread(runnable, str);
        rxCustomThread.setPriority(this.X);
        rxCustomThread.setDaemon(true);
        return rxCustomThread;
    }

    public String toString() {
        return "RxThreadFactory[" + this.s + "]";
    }

    public RxThreadFactory(String str, int i2) {
        this(str, i2, false);
    }

    public RxThreadFactory(String str, int i2, boolean z) {
        this.s = str;
        this.X = i2;
        this.Y = z;
    }
}
