package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.util.ObservableQueueDrain;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;

public abstract class QueueDrainObserver<T, U, V> extends QueueDrainSubscriberPad2 implements Observer<T>, ObservableQueueDrain<U, V> {
    protected volatile boolean A3;
    protected volatile boolean B3;
    protected Throwable C3;
    protected final Observer<? super V> y3;
    protected final SimplePlainQueue<U> z3;

    public QueueDrainObserver(Observer<? super V> observer, SimplePlainQueue<U> simplePlainQueue) {
        this.y3 = observer;
        this.z3 = simplePlainQueue;
    }

    public final boolean a() {
        return this.i3.getAndIncrement() == 0;
    }

    public final boolean c() {
        return this.B3;
    }

    public final boolean d() {
        return this.A3;
    }

    /* access modifiers changed from: protected */
    public final void e(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.y3;
        SimplePlainQueue<U> simplePlainQueue = this.z3;
        if (this.i3.get() != 0 || !this.i3.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u);
            if (!a()) {
                return;
            }
        } else {
            j(observer, u);
            if (i(-1) == 0) {
                return;
            }
        }
        QueueDrainHelper.d(simplePlainQueue, observer, z, disposable, this);
    }

    public final Throwable f() {
        return this.C3;
    }

    /* access modifiers changed from: protected */
    public final void h(U u, boolean z, Disposable disposable) {
        Observer<? super V> observer = this.y3;
        SimplePlainQueue<U> simplePlainQueue = this.z3;
        if (this.i3.get() != 0 || !this.i3.compareAndSet(0, 1)) {
            simplePlainQueue.offer(u);
            if (!a()) {
                return;
            }
        } else if (simplePlainQueue.isEmpty()) {
            j(observer, u);
            if (i(-1) == 0) {
                return;
            }
        } else {
            simplePlainQueue.offer(u);
        }
        QueueDrainHelper.d(simplePlainQueue, observer, z, disposable, this);
    }

    public final int i(int i2) {
        return this.i3.addAndGet(i2);
    }

    public void j(Observer<? super V> observer, U u) {
    }
}
