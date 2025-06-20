package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableLastStageObserver<T> extends ObservableStageObserver<T> {
    final boolean Y;
    final T Z;

    public ObservableLastStageObserver(boolean z, T t) {
        this.Y = z;
        this.Z = t;
    }

    public void onComplete() {
        if (!isDone()) {
            T t = this.X;
            a();
            if (t == null) {
                if (this.Y) {
                    t = this.Z;
                } else {
                    completeExceptionally(new NoSuchElementException());
                    return;
                }
            }
            complete(t);
        }
    }

    public void onNext(T t) {
        this.X = t;
    }
}
