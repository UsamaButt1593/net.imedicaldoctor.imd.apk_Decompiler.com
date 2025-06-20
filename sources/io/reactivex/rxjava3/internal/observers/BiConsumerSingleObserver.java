package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class BiConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long X = 4943102778943297569L;
    final BiConsumer<? super T, ? super Throwable> s;

    public BiConsumerSingleObserver(BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.s = biConsumer;
    }

    public void a(T t) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.s.accept(t, null);
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
    }

    public void b(Disposable disposable) {
        DisposableHelper.h(this, disposable);
    }

    public boolean g() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void m() {
        DisposableHelper.a(this);
    }

    public void onError(Throwable th) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            this.s.accept(null, th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(th, th2));
        }
    }
}
