package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable extends Completable {
    final Iterable<? extends CompletableSource> s;

    static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver, Disposable {
        private static final long Z = -7730517613164279224L;
        final CompletableObserver X;
        final AtomicInteger Y;
        final CompositeDisposable s;

        MergeCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
            this.X = completableObserver;
            this.s = compositeDisposable;
            this.Y = atomicInteger;
        }

        public void b(Disposable disposable) {
            this.s.b(disposable);
        }

        public boolean g() {
            return this.s.g();
        }

        public void m() {
            this.s.m();
            set(true);
        }

        public void onComplete() {
            if (this.Y.decrementAndGet() == 0) {
                this.X.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.s.m();
            if (compareAndSet(false, true)) {
                this.X.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }
    }

    public CompletableMergeIterable(Iterable<? extends CompletableSource> iterable) {
        this.s = iterable;
    }

    public void Z0(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(completableObserver, compositeDisposable, atomicInteger);
        completableObserver.b(mergeCompletableObserver);
        try {
            Iterator<? extends CompletableSource> it2 = this.s.iterator();
            Objects.requireNonNull(it2, "The source iterator returned is null");
            Iterator it3 = it2;
            while (!compositeDisposable.g()) {
                try {
                    if (!it3.hasNext()) {
                        mergeCompletableObserver.onComplete();
                        return;
                    } else if (!compositeDisposable.g()) {
                        try {
                            Object next = it3.next();
                            Objects.requireNonNull(next, "The iterator returned a null CompletableSource");
                            CompletableSource completableSource = (CompletableSource) next;
                            if (!compositeDisposable.g()) {
                                atomicInteger.getAndIncrement();
                                completableSource.a(mergeCompletableObserver);
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            compositeDisposable.m();
                            mergeCompletableObserver.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    compositeDisposable.m();
                    mergeCompletableObserver.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            completableObserver.onError(th3);
        }
    }
}
