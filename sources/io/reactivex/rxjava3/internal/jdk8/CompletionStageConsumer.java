package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletionStageConsumer<T> extends CompletableFuture<T> implements MaybeObserver<T>, SingleObserver<T>, CompletableObserver {
    final boolean X;
    final T Y;
    final AtomicReference<Disposable> s = new AtomicReference<>();

    public CompletionStageConsumer(boolean z, T t) {
        this.X = z;
        this.Y = t;
    }

    public void a(@NonNull T t) {
        d();
        complete(t);
    }

    public void b(@NonNull Disposable disposable) {
        DisposableHelper.h(this.s, disposable);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        DisposableHelper.a(this.s);
    }

    public boolean cancel(boolean z) {
        c();
        return super.cancel(z);
    }

    public boolean complete(T t) {
        c();
        return super.complete(t);
    }

    public boolean completeExceptionally(Throwable th) {
        c();
        return super.completeExceptionally(th);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.s.lazySet(DisposableHelper.DISPOSED);
    }

    public void onComplete() {
        if (this.X) {
            complete(this.Y);
        } else {
            completeExceptionally(new NoSuchElementException("The source was empty"));
        }
    }

    public void onError(Throwable th) {
        d();
        if (!completeExceptionally(th)) {
            RxJavaPlugins.Y(th);
        }
    }
}
