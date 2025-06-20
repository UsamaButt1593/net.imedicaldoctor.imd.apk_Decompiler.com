package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

abstract class ObservableStageObserver<T> extends CompletableFuture<T> implements Observer<T> {
    T X;
    final AtomicReference<Disposable> s = new AtomicReference<>();

    ObservableStageObserver() {
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.X = null;
        this.s.lazySet(DisposableHelper.DISPOSED);
    }

    public final void b(@NonNull Disposable disposable) {
        DisposableHelper.h(this.s, disposable);
    }

    /* access modifiers changed from: protected */
    public final void c() {
        DisposableHelper.a(this.s);
    }

    public final boolean cancel(boolean z) {
        c();
        return super.cancel(z);
    }

    public final boolean complete(T t) {
        c();
        return super.complete(t);
    }

    public final boolean completeExceptionally(Throwable th) {
        c();
        return super.completeExceptionally(th);
    }

    public final void onError(Throwable th) {
        a();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.Y(th);
        }
    }
}
