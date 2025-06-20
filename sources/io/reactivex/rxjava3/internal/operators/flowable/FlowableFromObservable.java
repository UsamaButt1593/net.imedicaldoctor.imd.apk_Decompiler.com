package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final ObservableSource<T> X;

    static final class SubscriberObserver<T> implements Observer<T>, Subscription {
        Disposable X;
        final Subscriber<? super T> s;

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        public void b(Disposable disposable) {
            this.X = disposable;
            this.s.h(this);
        }

        public void cancel() {
            this.X.m();
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

        public void request(long j2) {
        }
    }

    public FlowableFromObservable(ObservableSource<T> observableSource) {
        this.X = observableSource;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.a(new SubscriberObserver(subscriber));
    }
}
