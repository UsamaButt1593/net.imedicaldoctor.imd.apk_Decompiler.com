package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

public class Event<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<T> f24376a;

    /* renamed from: b  reason: collision with root package name */
    private final T f24377b;

    public Event(Class<T> cls, T t) {
        this.f24376a = (Class) Preconditions.b(cls);
        this.f24377b = Preconditions.b(t);
    }

    public T a() {
        return this.f24377b;
    }

    public Class<T> b() {
        return this.f24376a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", new Object[]{this.f24376a, this.f24377b});
    }
}
