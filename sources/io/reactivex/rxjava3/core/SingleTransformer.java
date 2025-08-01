package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface SingleTransformer<Upstream, Downstream> {
    @NonNull
    SingleSource<Downstream> c(@NonNull Single<Upstream> single);
}
