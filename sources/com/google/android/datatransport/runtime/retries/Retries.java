package com.google.android.datatransport.runtime.retries;

public final class Retries {
    private Retries() {
    }

    public static <TInput, TResult, TException extends Throwable> TResult a(int i2, TInput tinput, Function<TInput, TResult, TException> function, RetryStrategy<TInput, TResult> retryStrategy) throws Throwable {
        TResult apply;
        if (i2 < 1) {
            return function.apply(tinput);
        }
        do {
            apply = function.apply(tinput);
            tinput = retryStrategy.a(tinput, apply);
            if (tinput == null || i2 - 1 < 1) {
                return apply;
            }
            apply = function.apply(tinput);
            tinput = retryStrategy.a(tinput, apply);
            break;
        } while (i2 - 1 < 1);
        return apply;
    }
}
