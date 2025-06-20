package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class QueueDrainHelper {

    /* renamed from: a  reason: collision with root package name */
    static final long f28491a = Long.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    static final long f28492b = Long.MAX_VALUE;

    private QueueDrainHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> boolean a(boolean z, boolean z2, Observer<?> observer, boolean z3, SimpleQueue<?> simpleQueue, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        if (observableQueueDrain.d()) {
            simpleQueue.clear();
            disposable.m();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable f2 = observableQueueDrain.f();
                if (f2 != null) {
                    simpleQueue.clear();
                    if (disposable != null) {
                        disposable.m();
                    }
                    observer.onError(f2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    if (disposable != null) {
                        disposable.m();
                    }
                    observer.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                if (disposable != null) {
                    disposable.m();
                }
                Throwable f3 = observableQueueDrain.f();
                if (f3 != null) {
                    observer.onError(f3);
                } else {
                    observer.onComplete();
                }
                return true;
            }
        }
    }

    public static <T, U> boolean b(boolean z, boolean z2, Subscriber<?> subscriber, boolean z3, SimpleQueue<?> simpleQueue, QueueDrain<T, U> queueDrain) {
        if (queueDrain.d()) {
            simpleQueue.clear();
            return true;
        } else if (!z) {
            return false;
        } else {
            if (!z3) {
                Throwable f2 = queueDrain.f();
                if (f2 != null) {
                    simpleQueue.clear();
                    subscriber.onError(f2);
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    subscriber.onComplete();
                    return true;
                }
            } else if (!z2) {
                return false;
            } else {
                Throwable f3 = queueDrain.f();
                if (f3 != null) {
                    subscriber.onError(f3);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
    }

    public static <T> SimpleQueue<T> c(int i2) {
        return i2 < 0 ? new SpscLinkedArrayQueue(-i2) : new SpscArrayQueue(i2);
    }

    public static <T, U> void d(SimplePlainQueue<T> simplePlainQueue, Observer<? super U> observer, boolean z, Disposable disposable, ObservableQueueDrain<T, U> observableQueueDrain) {
        int i2 = 1;
        while (!a(observableQueueDrain.c(), simplePlainQueue.isEmpty(), observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
            while (true) {
                boolean c2 = observableQueueDrain.c();
                T poll = simplePlainQueue.poll();
                boolean z2 = poll == null;
                if (!a(c2, z2, observer, z, simplePlainQueue, disposable, observableQueueDrain)) {
                    if (z2) {
                        i2 = observableQueueDrain.i(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        observableQueueDrain.j(observer, poll);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public static <T, U> void e(SimplePlainQueue<T> simplePlainQueue, Subscriber<? super U> subscriber, boolean z, Disposable disposable, QueueDrain<T, U> queueDrain) {
        int i2 = 1;
        while (true) {
            boolean c2 = queueDrain.c();
            T poll = simplePlainQueue.poll();
            boolean z2 = poll == null;
            if (b(c2, z2, subscriber, z, simplePlainQueue, queueDrain)) {
                if (disposable != null) {
                    disposable.m();
                    return;
                }
                return;
            } else if (z2) {
                i2 = queueDrain.i(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                long e2 = queueDrain.e();
                if (e2 == 0) {
                    simplePlainQueue.clear();
                    if (disposable != null) {
                        disposable.m();
                    }
                    subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests."));
                    return;
                } else if (queueDrain.b(subscriber, poll) && e2 != Long.MAX_VALUE) {
                    queueDrain.j(1);
                }
            }
        }
    }

    static boolean f(BooleanSupplier booleanSupplier) {
        try {
            return booleanSupplier.a();
        } catch (Throwable th) {
            Exceptions.b(th);
            return true;
        }
    }

    public static <T> void g(Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j2;
        long j3;
        if (queue.isEmpty()) {
            subscriber.onComplete();
        } else if (!h(atomicLong.get(), subscriber, queue, atomicLong, booleanSupplier)) {
            do {
                j2 = atomicLong.get();
                if ((j2 & Long.MIN_VALUE) == 0) {
                    j3 = j2 | Long.MIN_VALUE;
                } else {
                    return;
                }
            } while (!atomicLong.compareAndSet(j2, j3));
            if (j2 != 0) {
                h(j3, subscriber, queue, atomicLong, booleanSupplier);
            }
        }
    }

    static <T> boolean h(long j2, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j3 = j2 & Long.MIN_VALUE;
        while (true) {
            if (j3 != j2) {
                if (f(booleanSupplier)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onComplete();
                    return true;
                }
                subscriber.onNext(poll);
                j3++;
            } else if (f(booleanSupplier)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    subscriber.onComplete();
                    return true;
                }
                j2 = atomicLong.get();
                if (j2 == j3) {
                    long addAndGet = atomicLong.addAndGet(-(j3 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j2 = addAndGet;
                    j3 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> boolean i(long j2, Subscriber<? super T> subscriber, Queue<T> queue, AtomicLong atomicLong, BooleanSupplier booleanSupplier) {
        long j3;
        long j4 = j2;
        do {
            j3 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j3, BackpressureHelper.c(Long.MAX_VALUE & j3, j2) | (j3 & Long.MIN_VALUE)));
        if (j3 != Long.MIN_VALUE) {
            return false;
        }
        h(j4 | Long.MIN_VALUE, subscriber, queue, atomicLong, booleanSupplier);
        return true;
    }

    public static void j(Subscription subscription, int i2) {
        subscription.request(i2 < 0 ? Long.MAX_VALUE : (long) i2);
    }
}
