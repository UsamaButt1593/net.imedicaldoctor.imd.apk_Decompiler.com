package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@ElementTypesAreNonnullByDefault
abstract class Dispatcher {

    private static final class ImmediateDispatcher extends Dispatcher {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ImmediateDispatcher f22548a = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj, Iterator<Subscriber> it2) {
            Preconditions.E(obj);
            while (it2.hasNext()) {
                it2.next().d(obj);
            }
        }
    }

    private static final class LegacyAsyncDispatcher extends Dispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final ConcurrentLinkedQueue<EventWithSubscriber> f22549a;

        private static final class EventWithSubscriber {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public final Object f22550a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public final Subscriber f22551b;

            private EventWithSubscriber(Object obj, Subscriber subscriber) {
                this.f22550a = obj;
                this.f22551b = subscriber;
            }
        }

        private LegacyAsyncDispatcher() {
            this.f22549a = Queues.f();
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj, Iterator<Subscriber> it2) {
            Preconditions.E(obj);
            while (it2.hasNext()) {
                this.f22549a.add(new EventWithSubscriber(obj, it2.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.f22549a.poll();
                if (poll != null) {
                    poll.f22551b.d(poll.f22550a);
                } else {
                    return;
                }
            }
        }
    }

    private static final class PerThreadQueuedDispatcher extends Dispatcher {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadLocal<Queue<Event>> f22552a;

        /* renamed from: b  reason: collision with root package name */
        private final ThreadLocal<Boolean> f22553b;

        private static final class Event {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public final Object f22554a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public final Iterator<Subscriber> f22555b;

            private Event(Object obj, Iterator<Subscriber> it2) {
                this.f22554a = obj;
                this.f22555b = it2;
            }
        }

        private PerThreadQueuedDispatcher() {
            this.f22552a = new ThreadLocal<Queue<Event>>(this) {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Queue<Event> initialValue() {
                    return Queues.d();
                }
            };
            this.f22553b = new ThreadLocal<Boolean>(this) {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0052 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0034 A[Catch:{ all -> 0x0050 }, LOOP:1: B:6:0x0034->B:8:0x003e, LOOP_START] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.Object r4, java.util.Iterator<com.google.common.eventbus.Subscriber> r5) {
            /*
                r3 = this;
                com.google.common.base.Preconditions.E(r4)
                com.google.common.base.Preconditions.E(r5)
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r0 = r3.f22552a
                java.lang.Object r0 = r0.get()
                java.util.Queue r0 = (java.util.Queue) r0
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r1 = new com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event
                r2 = 0
                r1.<init>(r4, r5)
                r0.offer(r1)
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.f22553b
                java.lang.Object r4 = r4.get()
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 != 0) goto L_0x0068
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.f22553b
                java.lang.Boolean r5 = java.lang.Boolean.TRUE
                r4.set(r5)
            L_0x002c:
                java.lang.Object r4 = r0.poll()     // Catch:{ all -> 0x0050 }
                com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event r4 = (com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.Event) r4     // Catch:{ all -> 0x0050 }
                if (r4 == 0) goto L_0x0052
            L_0x0034:
                java.util.Iterator r5 = r4.f22555b     // Catch:{ all -> 0x0050 }
                boolean r5 = r5.hasNext()     // Catch:{ all -> 0x0050 }
                if (r5 == 0) goto L_0x002c
                java.util.Iterator r5 = r4.f22555b     // Catch:{ all -> 0x0050 }
                java.lang.Object r5 = r5.next()     // Catch:{ all -> 0x0050 }
                com.google.common.eventbus.Subscriber r5 = (com.google.common.eventbus.Subscriber) r5     // Catch:{ all -> 0x0050 }
                java.lang.Object r1 = r4.f22554a     // Catch:{ all -> 0x0050 }
                r5.d(r1)     // Catch:{ all -> 0x0050 }
                goto L_0x0034
            L_0x0050:
                r4 = move-exception
                goto L_0x005d
            L_0x0052:
                java.lang.ThreadLocal<java.lang.Boolean> r4 = r3.f22553b
                r4.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r4 = r3.f22552a
                r4.remove()
                goto L_0x0068
            L_0x005d:
                java.lang.ThreadLocal<java.lang.Boolean> r5 = r3.f22553b
                r5.remove()
                java.lang.ThreadLocal<java.util.Queue<com.google.common.eventbus.Dispatcher$PerThreadQueuedDispatcher$Event>> r5 = r3.f22552a
                r5.remove()
                throw r4
            L_0x0068:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.a(java.lang.Object, java.util.Iterator):void");
        }
    }

    Dispatcher() {
    }

    static Dispatcher b() {
        return ImmediateDispatcher.f22548a;
    }

    static Dispatcher c() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher d() {
        return new PerThreadQueuedDispatcher();
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Object obj, Iterator<Subscriber> it2);
}
