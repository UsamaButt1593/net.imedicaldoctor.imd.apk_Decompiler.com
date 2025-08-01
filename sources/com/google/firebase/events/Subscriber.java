package com.google.firebase.events;

import java.util.concurrent.Executor;

public interface Subscriber {
    <T> void a(Class<T> cls, EventHandler<? super T> eventHandler);

    <T> void b(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler);

    <T> void d(Class<T> cls, EventHandler<? super T> eventHandler);
}
