package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublishSelector<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super Observable<T>, ? extends ObservableSource<R>> X;

    static final class SourceObserver<T> implements Observer<T> {
        final AtomicReference<Disposable> X;
        final PublishSubject<T> s;

        SourceObserver(PublishSubject<T> publishSubject, AtomicReference<Disposable> atomicReference) {
            this.s = publishSubject;
            this.X = atomicReference;
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.X, disposable);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    static final class TargetObserver<R> extends AtomicReference<Disposable> implements Observer<R>, Disposable {
        private static final long Y = 854110278590336484L;
        Disposable X;
        final Observer<? super R> s;

        TargetObserver(Observer<? super R> observer) {
            this.s = observer;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X, disposable)) {
                this.X = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X.g();
        }

        public void m() {
            this.X.m();
            DisposableHelper.a(this);
        }

        public void onComplete() {
            DisposableHelper.a(this);
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            DisposableHelper.a(this);
            this.s.onError(th);
        }

        public void onNext(R r) {
            this.s.onNext(r);
        }
    }

    public ObservablePublishSelector(ObservableSource<T> observableSource, Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        super(observableSource);
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        PublishSubject J8 = PublishSubject.J8();
        try {
            Object apply = this.X.apply(J8);
            Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
            ObservableSource observableSource = (ObservableSource) apply;
            TargetObserver targetObserver = new TargetObserver(observer);
            observableSource.a(targetObserver);
            this.s.a(new SourceObserver(J8, targetObserver));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
        }
    }
}
