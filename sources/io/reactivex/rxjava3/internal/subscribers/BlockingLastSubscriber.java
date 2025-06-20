package io.reactivex.rxjava3.internal.subscribers;

public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onError(Throwable th) {
        this.s = null;
        this.X = th;
        countDown();
    }

    public void onNext(T t) {
        this.s = t;
    }
}
