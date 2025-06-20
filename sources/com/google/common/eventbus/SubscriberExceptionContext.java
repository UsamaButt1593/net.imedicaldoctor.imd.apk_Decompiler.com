package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

@ElementTypesAreNonnullByDefault
public class SubscriberExceptionContext {

    /* renamed from: a  reason: collision with root package name */
    private final EventBus f22567a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f22568b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f22569c;

    /* renamed from: d  reason: collision with root package name */
    private final Method f22570d;

    SubscriberExceptionContext(EventBus eventBus, Object obj, Object obj2, Method method) {
        this.f22567a = (EventBus) Preconditions.E(eventBus);
        this.f22568b = Preconditions.E(obj);
        this.f22569c = Preconditions.E(obj2);
        this.f22570d = (Method) Preconditions.E(method);
    }

    public Object a() {
        return this.f22568b;
    }

    public EventBus b() {
        return this.f22567a;
    }

    public Object c() {
        return this.f22569c;
    }

    public Method d() {
        return this.f22570d;
    }
}
