package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import org.reactivestreams.Publisher;

@FunctionalInterface
public interface FlowableTransformer<Upstream, Downstream> {
    @NonNull
    Publisher<Downstream> b(@NonNull Flowable<Upstream> flowable);
}
