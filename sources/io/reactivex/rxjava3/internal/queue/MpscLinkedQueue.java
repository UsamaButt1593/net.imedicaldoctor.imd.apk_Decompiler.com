package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class MpscLinkedQueue<T> implements SimplePlainQueue<T> {
    private final AtomicReference<LinkedQueueNode<T>> X = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<T>> s = new AtomicReference<>();

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long X = 2404266111789071508L;
        private E s;

        LinkedQueueNode() {
        }

        public E a() {
            E b2 = b();
            e((Object) null);
            return b2;
        }

        public E b() {
            return this.s;
        }

        public LinkedQueueNode<E> c() {
            return (LinkedQueueNode) get();
        }

        public void d(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void e(E e2) {
            this.s = e2;
        }

        LinkedQueueNode(E e2) {
            e(e2);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> a() {
        return this.X.get();
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> b() {
        return this.X.get();
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> c() {
        return this.s.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.queue.MpscLinkedQueue.clear():void");
    }

    /* access modifiers changed from: package-private */
    public void d(LinkedQueueNode<T> linkedQueueNode) {
        this.X.lazySet(linkedQueueNode);
    }

    /* access modifiers changed from: package-private */
    public LinkedQueueNode<T> e(LinkedQueueNode<T> linkedQueueNode) {
        return this.s.getAndSet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return b() == c();
    }

    public boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t);
            e(linkedQueueNode).d(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Nullable
    public T poll() {
        LinkedQueueNode a2 = a();
        LinkedQueueNode c2 = a2.c();
        if (c2 == null) {
            if (a2 == c()) {
                return null;
            }
            do {
                c2 = a2.c();
            } while (c2 == null);
        }
        T a3 = c2.a();
        d(c2);
        return a3;
    }

    public boolean q(T t, T t2) {
        offer(t);
        offer(t2);
        return true;
    }
}
