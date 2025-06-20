package org.reactivestreams;

public interface Publisher<T> {
    void e(Subscriber<? super T> subscriber);
}
