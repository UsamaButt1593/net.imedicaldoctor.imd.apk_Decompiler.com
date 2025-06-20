package org.reactivestreams;

public interface Subscriber<T> {
    void h(Subscription subscription);

    void onComplete();

    void onError(Throwable th);

    void onNext(T t);
}
