package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public interface FlowableSubscriber<T> extends Subscriber<T> {
    void h(@NonNull Subscription subscription);
}
