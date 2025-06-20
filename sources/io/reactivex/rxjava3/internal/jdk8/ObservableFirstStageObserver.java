package io.reactivex.rxjava3.internal.jdk8;

import java.util.NoSuchElementException;

public final class ObservableFirstStageObserver<T> extends ObservableStageObserver<T> {
    final boolean Y;
    final T Z;

    public ObservableFirstStageObserver(boolean z, T t) {
        this.Y = z;
        this.Z = t;
    }

    public void onComplete() {
        if (!isDone()) {
            a();
            if (this.Y) {
                complete(this.Z);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    public void onNext(T t) {
        complete(t);
    }
}
