package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.ResumeSingleObserver;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleResumeNext<T> extends Single<T> {
    final Function<? super Throwable, ? extends SingleSource<? extends T>> X;
    final SingleSource<? extends T> s;

    static final class ResumeMainSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long Y = -5314538511045349925L;
        final Function<? super Throwable, ? extends SingleSource<? extends T>> X;
        final SingleObserver<? super T> s;

        ResumeMainSingleObserver(SingleObserver<? super T> singleObserver, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
            this.s = singleObserver;
            this.X = function;
        }

        public void a(T t) {
            this.s.a(t);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.X.apply(th);
                Objects.requireNonNull(apply, "The nextFunction returned a null SingleSource.");
                ((SingleSource) apply).e(new ResumeSingleObserver(this, this.s));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }
    }

    public SingleResumeNext(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        this.s = singleSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new ResumeMainSingleObserver(singleObserver, this.X));
    }
}
