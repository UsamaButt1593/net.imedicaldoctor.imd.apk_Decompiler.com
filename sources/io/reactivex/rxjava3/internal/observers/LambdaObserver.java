package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.Observer;
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

public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, LambdaConsumerIntrospection {
    private static final long X2 = -7251123623727029452L;
    final Consumer<? super Throwable> X;
    final Action Y;
    final Consumer<? super Disposable> Z;
    final Consumer<? super T> s;

    public LambdaObserver(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        this.s = consumer;
        this.X = consumer2;
        this.Y = action;
        this.Z = consumer3;
    }

    public void b(Disposable disposable) {
        if (DisposableHelper.h(this, disposable)) {
            try {
                this.Z.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                disposable.m();
                onError(th);
            }
        }
    }

    public boolean c() {
        return this.X != Functions.f28377f;
    }

    public boolean g() {
        return get() == DisposableHelper.DISPOSED;
    }

    public void m() {
        DisposableHelper.a(this);
    }

    public void onComplete() {
        if (!g()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.Y.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }
    }

    public void onError(Throwable th) {
        if (!g()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.X.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.Y(new CompositeException(th, th2));
            }
        } else {
            RxJavaPlugins.Y(th);
        }
    }

    public void onNext(T t) {
        if (!g()) {
            try {
                this.s.accept(t);
            } catch (Throwable th) {
                Exceptions.b(th);
                ((Disposable) get()).m();
                onError(th);
            }
        }
    }
}
