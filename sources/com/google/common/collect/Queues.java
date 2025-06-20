package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Queues {
    private Queues() {
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @J2ktIncompatible
    public static <E> int a(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i2, long j2, TimeUnit timeUnit) throws InterruptedException {
        Preconditions.E(collection);
        long nanoTime = System.nanoTime() + timeUnit.toNanos(j2);
        int i3 = 0;
        while (i3 < i2) {
            i3 += blockingQueue.drainTo(collection, i2 - i3);
            if (i3 < i2) {
                E poll = blockingQueue.poll(nanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                if (poll == null) {
                    break;
                }
                collection.add(poll);
                i3++;
            }
        }
        return i3;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @J2ktIncompatible
    public static <E> int b(BlockingQueue<E> blockingQueue, Collection<? super E> collection, int i2, long j2, TimeUnit timeUnit) {
        E poll;
        Preconditions.E(collection);
        long nanoTime = System.nanoTime() + timeUnit.toNanos(j2);
        int i3 = 0;
        boolean z = false;
        while (i3 < i2) {
            try {
                i3 += blockingQueue.drainTo(collection, i2 - i3);
                if (i3 < i2) {
                    while (true) {
                        try {
                            poll = blockingQueue.poll(nanoTime - System.nanoTime(), TimeUnit.NANOSECONDS);
                            break;
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    }
                    if (poll == null) {
                        break;
                    }
                    collection.add(poll);
                    i3++;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return i3;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> ArrayBlockingQueue<E> c(int i2) {
        return new ArrayBlockingQueue<>(i2);
    }

    public static <E> ArrayDeque<E> d() {
        return new ArrayDeque<>();
    }

    public static <E> ArrayDeque<E> e(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ArrayDeque<>((Collection) iterable);
        }
        ArrayDeque<E> arrayDeque = new ArrayDeque<>();
        Iterables.a(arrayDeque, iterable);
        return arrayDeque;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> ConcurrentLinkedQueue<E> f() {
        return new ConcurrentLinkedQueue<>();
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> ConcurrentLinkedQueue<E> g(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new ConcurrentLinkedQueue<>((Collection) iterable);
        }
        ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        Iterables.a(concurrentLinkedQueue, iterable);
        return concurrentLinkedQueue;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> LinkedBlockingDeque<E> h() {
        return new LinkedBlockingDeque<>();
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> LinkedBlockingDeque<E> i(int i2) {
        return new LinkedBlockingDeque<>(i2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> LinkedBlockingDeque<E> j(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingDeque<>((Collection) iterable);
        }
        LinkedBlockingDeque<E> linkedBlockingDeque = new LinkedBlockingDeque<>();
        Iterables.a(linkedBlockingDeque, iterable);
        return linkedBlockingDeque;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> LinkedBlockingQueue<E> k() {
        return new LinkedBlockingQueue<>();
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> LinkedBlockingQueue<E> l(int i2) {
        return new LinkedBlockingQueue<>(i2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> LinkedBlockingQueue<E> m(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedBlockingQueue<>((Collection) iterable);
        }
        LinkedBlockingQueue<E> linkedBlockingQueue = new LinkedBlockingQueue<>();
        Iterables.a(linkedBlockingQueue, iterable);
        return linkedBlockingQueue;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> n() {
        return new PriorityBlockingQueue<>();
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E extends Comparable> PriorityBlockingQueue<E> o(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityBlockingQueue<>((Collection) iterable);
        }
        PriorityBlockingQueue<E> priorityBlockingQueue = new PriorityBlockingQueue<>();
        Iterables.a(priorityBlockingQueue, iterable);
        return priorityBlockingQueue;
    }

    public static <E extends Comparable> PriorityQueue<E> p() {
        return new PriorityQueue<>();
    }

    public static <E extends Comparable> PriorityQueue<E> q(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new PriorityQueue<>((Collection) iterable);
        }
        PriorityQueue<E> priorityQueue = new PriorityQueue<>();
        Iterables.a(priorityQueue, iterable);
        return priorityQueue;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> SynchronousQueue<E> r() {
        return new SynchronousQueue<>();
    }

    public static <E> Deque<E> s(Deque<E> deque) {
        return Synchronized.i(deque, (Object) null);
    }

    public static <E> Queue<E> t(Queue<E> queue) {
        return Synchronized.t(queue, (Object) null);
    }
}
