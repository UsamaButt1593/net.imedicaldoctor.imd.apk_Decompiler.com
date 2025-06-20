package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long s = 2746389416410565408L;

    public ArrayCompositeDisposable(int i2) {
        super(i2);
    }

    public Disposable a(int i2, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) get(i2);
            if (disposable2 == DisposableHelper.DISPOSED) {
                disposable.m();
                return null;
            }
        } while (!compareAndSet(i2, disposable2, disposable));
        return disposable2;
    }

    public boolean b(int i2, Disposable disposable) {
        Disposable disposable2;
        do {
            disposable2 = (Disposable) get(i2);
            if (disposable2 == DisposableHelper.DISPOSED) {
                disposable.m();
                return false;
            }
        } while (!compareAndSet(i2, disposable2, disposable));
        if (disposable2 == null) {
            return true;
        }
        disposable2.m();
        return true;
    }

    public boolean g() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public void m() {
        Disposable disposable;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                Disposable disposable2 = (Disposable) get(i2);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (!(disposable2 == disposableHelper || (disposable = (Disposable) getAndSet(i2, disposableHelper)) == disposableHelper || disposable == null)) {
                    disposable.m();
                }
            }
        }
    }
}
