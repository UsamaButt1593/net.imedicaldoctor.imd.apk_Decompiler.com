package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableConcatIterable extends Completable {
    final Iterable<? extends CompletableSource> s;

    static final class ConcatInnerObserver extends AtomicInteger implements CompletableObserver {
        private static final long Z = -7965400327305809232L;
        final Iterator<? extends CompletableSource> X;
        final SequentialDisposable Y = new SequentialDisposable();
        final CompletableObserver s;

        ConcatInnerObserver(CompletableObserver completableObserver, Iterator<? extends CompletableSource> it2) {
            this.s = completableObserver;
            this.X = it2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.Y.g() && getAndIncrement() == 0) {
                Iterator<? extends CompletableSource> it2 = this.X;
                while (!this.Y.g()) {
                    try {
                        if (!it2.hasNext()) {
                            this.s.onComplete();
                            return;
                        }
                        try {
                            Object next = it2.next();
                            Objects.requireNonNull(next, "The CompletableSource returned is null");
                            ((CompletableSource) next).a(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.s.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        this.s.onError(th2);
                        return;
                    }
                }
            }
        }

        public void b(Disposable disposable) {
            this.Y.a(disposable);
        }

        public void onComplete() {
            a();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> iterable) {
        this.s = iterable;
    }

    public void Z0(CompletableObserver completableObserver) {
        try {
            Iterator<? extends CompletableSource> it2 = this.s.iterator();
            Objects.requireNonNull(it2, "The iterator returned is null");
            ConcatInnerObserver concatInnerObserver = new ConcatInnerObserver(completableObserver, it2);
            completableObserver.b(concatInnerObserver.Y);
            concatInnerObserver.a();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, completableObserver);
        }
    }
}
