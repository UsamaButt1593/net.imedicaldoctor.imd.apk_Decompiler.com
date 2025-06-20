package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArrayDelayError;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeDelayErrorIterable extends Completable {
    final Iterable<? extends CompletableSource> s;

    public CompletableMergeDelayErrorIterable(Iterable<? extends CompletableSource> iterable) {
        this.s = iterable;
    }

    public void Z0(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.b(compositeDisposable);
        try {
            Iterator<? extends CompletableSource> it2 = this.s.iterator();
            Objects.requireNonNull(it2, "The source iterator returned is null");
            Iterator it3 = it2;
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            compositeDisposable.b(new CompletableMergeArrayDelayError.TryTerminateAndReportDisposable(atomicThrowable));
            while (!compositeDisposable.g()) {
                try {
                    if (!it3.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            atomicThrowable.f(completableObserver);
                            return;
                        }
                        return;
                    } else if (!compositeDisposable.g()) {
                        Object next = it3.next();
                        Objects.requireNonNull(next, "The iterator returned a null CompletableSource");
                        CompletableSource completableSource = (CompletableSource) next;
                        if (!compositeDisposable.g()) {
                            atomicInteger.getAndIncrement();
                            completableSource.a(new CompletableMergeArrayDelayError.MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    atomicThrowable.d(th);
                }
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            completableObserver.onError(th2);
        }
    }
}
