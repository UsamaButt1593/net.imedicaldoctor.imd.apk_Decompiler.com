package io.reactivex.rxjava3.internal.observers;

public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th) {
        this.s = null;
        this.X = th;
        countDown();
    }

    public void onNext(T t) {
        this.s = t;
    }
}
