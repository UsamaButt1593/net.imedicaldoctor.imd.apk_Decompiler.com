package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class EventBus implements Subscriber, Publisher {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> f23406a = new HashMap();
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private Queue<Event<?>> f23407b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f23408c;

    EventBus(Executor executor) {
        this.f23408c = executor;
    }

    private synchronized Set<Map.Entry<EventHandler<Object>, Executor>> g(Event<?> event) {
        Map map;
        try {
            map = this.f23406a.get(event.b());
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    public <T> void a(Class<T> cls, EventHandler<? super T> eventHandler) {
        b(cls, this.f23408c, eventHandler);
    }

    public synchronized <T> void b(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        try {
            Preconditions.b(cls);
            Preconditions.b(eventHandler);
            Preconditions.b(executor);
            if (!this.f23406a.containsKey(cls)) {
                this.f23406a.put(cls, new ConcurrentHashMap());
            }
            this.f23406a.get(cls).put(eventHandler, executor);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r0 = g(r5).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r1 = r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(new com.google.firebase.components.o(r1, r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.google.firebase.events.Event<?> r5) {
        /*
            r4 = this;
            com.google.firebase.components.Preconditions.b(r5)
            monitor-enter(r4)
            java.util.Queue<com.google.firebase.events.Event<?>> r0 = r4.f23407b     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            r0.add(r5)     // Catch:{ all -> 0x000d }
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r5 = move-exception
            goto L_0x0034
        L_0x000f:
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            java.util.Set r0 = r4.g(r5)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            com.google.firebase.components.o r3 = new com.google.firebase.components.o
            r3.<init>(r1, r5)
            r2.execute(r3)
            goto L_0x0018
        L_0x0033:
            return
        L_0x0034:
            monitor-exit(r4)     // Catch:{ all -> 0x000d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.EventBus.c(com.google.firebase.events.Event):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> void d(java.lang.Class<T> r2, com.google.firebase.events.EventHandler<? super T> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.firebase.components.Preconditions.b(r2)     // Catch:{ all -> 0x0028 }
            com.google.firebase.components.Preconditions.b(r3)     // Catch:{ all -> 0x0028 }
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.f23406a     // Catch:{ all -> 0x0028 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)
            return
        L_0x0011:
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.f23406a     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0028 }
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0     // Catch:{ all -> 0x0028 }
            r0.remove(r3)     // Catch:{ all -> 0x0028 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r3 = r1.f23406a     // Catch:{ all -> 0x0028 }
            r3.remove(r2)     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r2 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r1)
            return
        L_0x002c:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.EventBus.d(java.lang.Class, com.google.firebase.events.EventHandler):void");
    }

    /* access modifiers changed from: package-private */
    public void f() {
        Queue<Event<?>> queue;
        synchronized (this) {
            try {
                queue = this.f23407b;
                if (queue != null) {
                    this.f23407b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (queue != null) {
            for (Event<?> c2 : queue) {
                c(c2);
            }
        }
    }
}
