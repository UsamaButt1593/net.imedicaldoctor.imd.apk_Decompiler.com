package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onError(Throwable th) {
        if (this.s == null) {
            this.X = th;
        } else {
            RxJavaPlugins.Y(th);
        }
        countDown();
    }

    public void onNext(T t) {
        if (this.s == null) {
            this.s = t;
            this.Y.cancel();
            countDown();
        }
    }
}
