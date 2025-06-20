package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

public final /* synthetic */ class b {
    @NonNull
    public static Disposable a() {
        return EmptyDisposable.INSTANCE;
    }

    @NonNull
    public static Disposable b() {
        return g(Functions.f28373b);
    }

    @NonNull
    public static Disposable c(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return new ActionDisposable(action);
    }

    @NonNull
    public static Disposable d(@NonNull AutoCloseable autoCloseable) {
        Objects.requireNonNull(autoCloseable, "autoCloseable is null");
        return new AutoCloseableDisposable(autoCloseable);
    }

    @NonNull
    public static Disposable e(@NonNull Future<?> future) {
        Objects.requireNonNull(future, "future is null");
        return f(future, true);
    }

    @NonNull
    public static Disposable f(@NonNull Future<?> future, boolean z) {
        Objects.requireNonNull(future, "future is null");
        return new FutureDisposable(future, z);
    }

    @NonNull
    public static Disposable g(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }

    @NonNull
    public static Disposable h(@NonNull Subscription subscription) {
        Objects.requireNonNull(subscription, "subscription is null");
        return new SubscriptionDisposable(subscription);
    }

    @NonNull
    public static AutoCloseable i(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        return new a(disposable);
    }
}
