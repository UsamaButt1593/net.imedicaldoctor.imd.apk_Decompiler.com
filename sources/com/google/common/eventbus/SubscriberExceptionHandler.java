package com.google.common.eventbus;

@ElementTypesAreNonnullByDefault
public interface SubscriberExceptionHandler {
    void a(Throwable th, SubscriberExceptionContext subscriberExceptionContext);
}
