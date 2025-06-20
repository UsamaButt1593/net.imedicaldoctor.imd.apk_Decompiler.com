package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableFromIterable<T> extends Flowable<T> {
    final Iterable<? extends T> X;

    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long X2 = -2252972430506210021L;
        Iterator<? extends T> X;
        volatile boolean Y;
        boolean Z;

        BaseRangeSubscription(Iterator<? extends T> it2) {
            this.X = it2;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public abstract void b(long j2);

        public final void cancel() {
            this.Y = true;
        }

        public final void clear() {
            this.X = null;
        }

        public final boolean isEmpty() {
            Iterator<? extends T> it2 = this.X;
            if (it2 == null) {
                return true;
            }
            if (!this.Z || it2.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        @Nullable
        public final T poll() {
            Iterator<? extends T> it2 = this.X;
            if (it2 == null) {
                return null;
            }
            if (!this.Z) {
                this.Z = true;
            } else if (!it2.hasNext()) {
                return null;
            }
            T next = this.X.next();
            Objects.requireNonNull(next, "Iterator.next() returned a null value");
            return next;
        }

        public final int r(int i2) {
            return i2 & 1;
        }

        public final void request(long j2) {
            if (SubscriptionHelper.k(j2) && BackpressureHelper.a(this, j2) == 0) {
                if (j2 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j2);
                }
            }
        }
    }

    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long Z2 = -6022804456014692607L;
        final ConditionalSubscriber<? super T> Y2;

        IteratorConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<? extends T> it2) {
            super(it2);
            this.Y2 = conditionalSubscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Iterator<? extends T> it2 = this.X;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.Y2;
            while (!this.Y) {
                try {
                    Object next = it2.next();
                    if (!this.Y) {
                        if (next == null) {
                            th = new NullPointerException("Iterator.next() returned a null value");
                            conditionalSubscriber.onError(th);
                            return;
                        }
                        conditionalSubscriber.o(next);
                        if (!this.Y) {
                            if (!it2.hasNext()) {
                                if (!this.Y) {
                                    conditionalSubscriber.onComplete();
                                    return;
                                }
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    Exceptions.b(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j2) {
            Iterator<? extends T> it2 = this.X;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.Y2;
            loop0:
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    } else if (!this.Y) {
                        try {
                            Object next = it2.next();
                            if (!this.Y) {
                                if (next == null) {
                                    th = new NullPointerException("Iterator.next() returned a null value");
                                    break loop0;
                                }
                                boolean o = conditionalSubscriber.o(next);
                                if (!this.Y) {
                                    if (!it2.hasNext()) {
                                        if (!this.Y) {
                                            conditionalSubscriber.onComplete();
                                            return;
                                        }
                                        return;
                                    } else if (o) {
                                        j3++;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            Exceptions.b(th);
                        }
                    } else {
                        return;
                    }
                }
                conditionalSubscriber.onError(th);
                return;
            } while (j2 != 0);
        }
    }

    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long Z2 = -6022804456014692607L;
        final Subscriber<? super T> Y2;

        IteratorSubscription(Subscriber<? super T> subscriber, Iterator<? extends T> it2) {
            super(it2);
            this.Y2 = subscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Iterator<? extends T> it2 = this.X;
            Subscriber<? super T> subscriber = this.Y2;
            while (!this.Y) {
                try {
                    Object next = it2.next();
                    if (!this.Y) {
                        if (next == null) {
                            th = new NullPointerException("Iterator.next() returned a null value");
                            subscriber.onError(th);
                            return;
                        }
                        subscriber.onNext(next);
                        if (!this.Y) {
                            if (!it2.hasNext()) {
                                if (!this.Y) {
                                    subscriber.onComplete();
                                    return;
                                }
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    Exceptions.b(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j2) {
            Iterator<? extends T> it2 = this.X;
            Subscriber<? super T> subscriber = this.Y2;
            loop0:
            do {
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j2 = get();
                        if (j3 == j2) {
                            j2 = addAndGet(-j3);
                        }
                    } else if (!this.Y) {
                        try {
                            Object next = it2.next();
                            if (!this.Y) {
                                if (next == null) {
                                    th = new NullPointerException("Iterator.next() returned a null value");
                                    break loop0;
                                }
                                subscriber.onNext(next);
                                if (!this.Y) {
                                    if (it2.hasNext()) {
                                        j3++;
                                    } else if (!this.Y) {
                                        subscriber.onComplete();
                                        return;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            Exceptions.b(th);
                        }
                    } else {
                        return;
                    }
                }
                subscriber.onError(th);
                return;
            } while (j2 != 0);
        }
    }

    public FlowableFromIterable(Iterable<? extends T> iterable) {
        this.X = iterable;
    }

    public static <T> void j9(Subscriber<? super T> subscriber, Iterator<? extends T> it2) {
        try {
            if (!it2.hasNext()) {
                EmptySubscription.a(subscriber);
            } else {
                subscriber.h(subscriber instanceof ConditionalSubscriber ? new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it2) : new IteratorSubscription(subscriber, it2));
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }

    public void K6(Subscriber<? super T> subscriber) {
        try {
            j9(subscriber, this.X.iterator());
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
