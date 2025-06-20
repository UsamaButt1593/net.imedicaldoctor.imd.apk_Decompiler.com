package io.reactivex.rxjava3.parallel;

import io.reactivex.rxjava3.functions.BiFunction;

public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    /* renamed from: a */
    public ParallelFailureHandling apply(Long l2, Throwable th) {
        return this;
    }
}
