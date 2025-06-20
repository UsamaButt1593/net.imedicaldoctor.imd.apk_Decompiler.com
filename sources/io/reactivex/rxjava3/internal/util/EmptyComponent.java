package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum EmptyComponent implements FlowableSubscriber<Object>, Observer<Object>, MaybeObserver<Object>, SingleObserver<Object>, CompletableObserver, Subscription, Disposable {
    INSTANCE;

    public static <T> Observer<T> c() {
        return INSTANCE;
    }

    public static <T> Subscriber<T> e() {
        return INSTANCE;
    }

    public void a(Object obj) {
    }

    public void b(Disposable disposable) {
        disposable.m();
    }

    public void cancel() {
    }

    public boolean g() {
        return true;
    }

    public void h(Subscription subscription) {
        subscription.cancel();
    }

    public void m() {
    }

    public void onComplete() {
    }

    public void onError(Throwable th) {
        RxJavaPlugins.Y(th);
    }

    public void onNext(Object obj) {
    }

    public void request(long j2) {
    }
}
