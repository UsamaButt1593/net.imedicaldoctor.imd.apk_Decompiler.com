package io.reactivex.rxjava3.internal.subscribers;

public interface InnerQueuedSubscriberSupport<T> {
    void a(InnerQueuedSubscriber<T> innerQueuedSubscriber);

    void b(InnerQueuedSubscriber<T> innerQueuedSubscriber, Throwable th);

    void c(InnerQueuedSubscriber<T> innerQueuedSubscriber, T t);

    void d();
}
