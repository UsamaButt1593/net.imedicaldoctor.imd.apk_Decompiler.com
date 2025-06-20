package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;

public enum EmptyDisposable implements QueueDisposable<Object> {
    INSTANCE,
    NEVER;

    public static void a(CompletableObserver completableObserver) {
        completableObserver.b(INSTANCE);
        completableObserver.onComplete();
    }

    public static void b(MaybeObserver<?> maybeObserver) {
        maybeObserver.b(INSTANCE);
        maybeObserver.onComplete();
    }

    public static void c(Observer<?> observer) {
        observer.b(INSTANCE);
        observer.onComplete();
    }

    public static void e(Throwable th, CompletableObserver completableObserver) {
        completableObserver.b(INSTANCE);
        completableObserver.onError(th);
    }

    public static void f(Throwable th, MaybeObserver<?> maybeObserver) {
        maybeObserver.b(INSTANCE);
        maybeObserver.onError(th);
    }

    public static void h(Throwable th, Observer<?> observer) {
        observer.b(INSTANCE);
        observer.onError(th);
    }

    public static void i(Throwable th, SingleObserver<?> singleObserver) {
        singleObserver.b(INSTANCE);
        singleObserver.onError(th);
    }

    public void clear() {
    }

    public boolean g() {
        return this == INSTANCE;
    }

    public boolean isEmpty() {
        return true;
    }

    public void m() {
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Nullable
    public Object poll() {
        return null;
    }

    public boolean q(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public int r(int i2) {
        return i2 & 2;
    }
}
