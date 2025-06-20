package io.reactivex.rxjava3.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long X = 6545242830671168775L;
    private final boolean s;

    FutureDisposable(Future<?> future, boolean z) {
        super(future);
        this.s = z;
    }

    public boolean g() {
        Future future = (Future) get();
        return future == null || future.isDone();
    }

    public void m() {
        Future future = (Future) getAndSet((Object) null);
        if (future != null) {
            future.cancel(this.s);
        }
    }
}
