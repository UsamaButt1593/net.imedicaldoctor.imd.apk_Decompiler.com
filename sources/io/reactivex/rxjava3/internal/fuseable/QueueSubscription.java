package io.reactivex.rxjava3.internal.fuseable;

import org.reactivestreams.Subscription;

public interface QueueSubscription<T> extends QueueFuseable<T>, Subscription {
}
