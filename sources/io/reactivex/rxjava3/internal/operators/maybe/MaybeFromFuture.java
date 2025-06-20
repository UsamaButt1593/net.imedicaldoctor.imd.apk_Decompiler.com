package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T> extends Maybe<T> {
    final long X;
    final TimeUnit Y;
    final Future<? extends T> s;

    public MaybeFromFuture(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.s = future;
        this.X = j2;
        this.Y = timeUnit;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        Disposable b2 = b.b();
        maybeObserver.b(b2);
        if (!b2.g()) {
            try {
                long j2 = this.X;
                Object obj = j2 <= 0 ? this.s.get() : this.s.get(j2, this.Y);
                if (b2.g()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.a(obj);
                }
            } catch (Throwable th) {
                th = th;
                Exceptions.b(th);
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.b(th);
                if (!b2.g()) {
                    maybeObserver.onError(th);
                }
            }
        }
    }
}
