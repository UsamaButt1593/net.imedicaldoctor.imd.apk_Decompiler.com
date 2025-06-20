package com.google.common.eventbus;

import com.google.common.eventbus.EventBus;
import java.util.concurrent.Executor;
import org.apache.commons.httpclient.cookie.CookiePolicy;

@ElementTypesAreNonnullByDefault
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String str, Executor executor) {
        super(str, executor, Dispatcher.c(), EventBus.LoggingHandler.f22562a);
    }

    public AsyncEventBus(Executor executor) {
        super(CookiePolicy.DEFAULT, executor, Dispatcher.c(), EventBus.LoggingHandler.f22562a);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super(CookiePolicy.DEFAULT, executor, Dispatcher.c(), subscriberExceptionHandler);
    }
}
