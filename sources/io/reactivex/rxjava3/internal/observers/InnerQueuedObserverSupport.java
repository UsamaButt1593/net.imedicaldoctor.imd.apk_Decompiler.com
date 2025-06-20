package io.reactivex.rxjava3.internal.observers;

public interface InnerQueuedObserverSupport<T> {
    void d();

    void e(InnerQueuedObserver<T> innerQueuedObserver, T t);

    void f(InnerQueuedObserver<T> innerQueuedObserver);

    void h(InnerQueuedObserver<T> innerQueuedObserver, Throwable th);
}
