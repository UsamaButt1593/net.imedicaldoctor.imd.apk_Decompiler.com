package io.reactivex.rxjava3.internal.observers;

public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th) {
        if (this.s == null) {
            this.X = th;
        }
        countDown();
    }

    public void onNext(T t) {
        if (this.s == null) {
            this.s = t;
            this.Y.m();
            countDown();
        }
    }
}
