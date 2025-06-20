package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observers.LambdaConsumerIntrospection;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, LambdaConsumerIntrospection {
    private static final long Z = -6076952298809384986L;
    final Consumer<? super Throwable> X;
    final Action Y;
    final Consumer<? super T> s;

    public MaybeCallbackObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        this.s = consumer;
        this.X = consumer2;
        this.Y = action;
    }

    public void a(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.s.accept(t);
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
    }

    public void b(Disposable disposable) {
        DisposableHelper.h(this, disposable);
    }

    public boolean c() {
        return this.X != Functions.f28377f;
    }

    public boolean g() {
        return DisposableHelper.b((Disposable) get());
    }

    public void m() {
        DisposableHelper.a(this);
    }

    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.Y.run();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
    }

    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.X.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(th, th2));
        }
    }
}
