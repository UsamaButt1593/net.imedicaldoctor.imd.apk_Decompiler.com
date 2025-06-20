package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class Subscriber {
    @Weak

    /* renamed from: a  reason: collision with root package name */
    private EventBus f22563a;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final Object f22564b;

    /* renamed from: c  reason: collision with root package name */
    private final Method f22565c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f22566d;

    @VisibleForTesting
    static final class SynchronizedSubscriber extends Subscriber {
        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }

        /* access modifiers changed from: package-private */
        public void e(Object obj) throws InvocationTargetException {
            synchronized (this) {
                Subscriber.super.e(obj);
            }
        }
    }

    private Subscriber(EventBus eventBus, Object obj, Method method) {
        this.f22563a = eventBus;
        this.f22564b = Preconditions.E(obj);
        this.f22565c = method;
        method.setAccessible(true);
        this.f22566d = eventBus.a();
    }

    private SubscriberExceptionContext b(Object obj) {
        return new SubscriberExceptionContext(this.f22563a, obj, this.f22564b, this.f22565c);
    }

    static Subscriber c(EventBus eventBus, Object obj, Method method) {
        return f(method) ? new Subscriber(eventBus, obj, method) : new SynchronizedSubscriber(eventBus, obj, method);
    }

    private static boolean f(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Object obj) {
        try {
            e(obj);
        } catch (InvocationTargetException e2) {
            this.f22563a.b(e2.getCause(), b(obj));
        }
    }

    /* access modifiers changed from: package-private */
    public final void d(Object obj) {
        this.f22566d.execute(new a(this, obj));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void e(Object obj) throws InvocationTargetException {
        try {
            this.f22565c.invoke(this.f22564b, new Object[]{Preconditions.E(obj)});
        } catch (IllegalArgumentException e2) {
            throw new Error("Method rejected target/argument: " + obj, e2);
        } catch (IllegalAccessException e3) {
            throw new Error("Method became inaccessible: " + obj, e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof Error) {
                throw ((Error) e4.getCause());
            }
            throw e4;
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        return this.f22564b == subscriber.f22564b && this.f22565c.equals(subscriber.f22565c);
    }

    public final int hashCode() {
        return ((this.f22565c.hashCode() + 31) * 31) + System.identityHashCode(this.f22564b);
    }
}
