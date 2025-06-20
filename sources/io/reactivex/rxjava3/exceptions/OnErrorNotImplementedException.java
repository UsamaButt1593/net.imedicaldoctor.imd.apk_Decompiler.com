package io.reactivex.rxjava3.exceptions;

import io.reactivex.rxjava3.annotations.NonNull;

public final class OnErrorNotImplementedException extends RuntimeException {
    private static final long s = -6298857009889503852L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnErrorNotImplementedException(String str, @NonNull Throwable th) {
        super(str, th == null ? new NullPointerException() : th);
    }

    public OnErrorNotImplementedException(@NonNull Throwable th) {
        this("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | " + th, th);
    }
}
