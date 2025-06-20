package io.reactivex.rxjava3.internal.util;

import org.reactivestreams.Subscriber;

public interface QueueDrain<T, U> {
    boolean a();

    boolean b(Subscriber<? super U> subscriber, T t);

    boolean c();

    boolean d();

    long e();

    Throwable f();

    int i(int i2);

    long j(long j2);
}
