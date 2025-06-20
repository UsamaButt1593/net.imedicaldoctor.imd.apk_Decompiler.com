package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class DisposeOnCancel implements Future<Object> {
    final Disposable s;

    DisposeOnCancel(Disposable disposable) {
        this.s = disposable;
    }

    public boolean cancel(boolean z) {
        this.s.m();
        return false;
    }

    public Object get() {
        return null;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return false;
    }

    public Object get(long j2, @NonNull TimeUnit timeUnit) {
        return null;
    }
}
