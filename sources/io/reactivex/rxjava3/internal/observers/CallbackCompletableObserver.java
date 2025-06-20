package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Consumer<Throwable>, LambdaConsumerIntrospection {
    private static final long Y = -4361286194466301354L;
    final Action X;
    final Consumer<? super Throwable> s;

    public CallbackCompletableObserver(Action action) {
        this.s = this;
        this.X = action;
    }

    /* renamed from: a */
    public void accept(Throwable th) {
        RxJavaPlugins.Y(new OnErrorNotImplementedException(th));
    }

    public void b(Disposable disposable) {
        DisposableHelper.h(this, disposable);
    }

    public boolean c() {
        return this.s != this;
    }

    public boolean g() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void m() {
        DisposableHelper.a(this);
    }

    public void onComplete() {
        try {
            this.X.run();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public void onError(Throwable th) {
        try {
            this.s.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> consumer, Action action) {
        this.s = consumer;
        this.X = action;
    }
}
