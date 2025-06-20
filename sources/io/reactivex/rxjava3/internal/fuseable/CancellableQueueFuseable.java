package io.reactivex.rxjava3.internal.fuseable;

public final class CancellableQueueFuseable<T> extends AbstractEmptyQueueFuseable<T> {
    volatile boolean s;

    public void cancel() {
        this.s = true;
    }

    public boolean g() {
        return this.s;
    }

    public void m() {
        this.s = true;
    }
}
