package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

public final class BlockingObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long X = -4875965440900746268L;
    public static final Object Y = new Object();
    final Queue<Object> s;

    public BlockingObserver(Queue<Object> queue) {
        this.s = queue;
    }

    public void b(Disposable disposable) {
        DisposableHelper.h(this, disposable);
    }

    public boolean g() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void m() {
        if (DisposableHelper.a(this)) {
            this.s.offer(Y);
        }
    }

    public void onComplete() {
        this.s.offer(NotificationLite.f());
    }

    public void onError(Throwable th) {
        this.s.offer(NotificationLite.h(th));
    }

    public void onNext(T t) {
        this.s.offer(NotificationLite.q(t));
    }
}
