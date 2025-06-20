package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;

public final class FlowableFromStream<T> extends Flowable<T> {
    final Stream<T> X;

    static abstract class AbstractStreamSubscription<T> extends AtomicLong implements QueueSubscription<T> {
        private static final long X2 = -9082954702547571853L;
        AutoCloseable X;
        volatile boolean Y;
        boolean Z;
        Iterator<T> s;

        AbstractStreamSubscription(Iterator<T> it2, AutoCloseable autoCloseable) {
            this.s = it2;
            this.X = autoCloseable;
        }

        /* access modifiers changed from: package-private */
        public abstract void a(long j2);

        public void cancel() {
            this.Y = true;
            request(1);
        }

        public void clear() {
            this.s = null;
            AutoCloseable autoCloseable = this.X;
            this.X = null;
            if (autoCloseable != null) {
                FlowableFromStream.j9(autoCloseable);
            }
        }

        public boolean isEmpty() {
            Iterator<T> it2 = this.s;
            if (it2 == null) {
                return true;
            }
            if (!this.Z || it2.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public boolean offer(@NonNull T t) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public T poll() {
            Iterator<T> it2 = this.s;
            if (it2 == null) {
                return null;
            }
            if (!this.Z) {
                this.Z = true;
            } else if (!it2.hasNext()) {
                clear();
                return null;
            }
            T next = this.s.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        public boolean q(@NonNull T t, @NonNull T t2) {
            throw new UnsupportedOperationException();
        }

        public int r(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            lazySet(Long.MAX_VALUE);
            return 1;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2) && BackpressureHelper.a(this, j2) == 0) {
                a(j2);
            }
        }
    }

    static final class StreamConditionalSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long Z2 = -9082954702547571853L;
        final ConditionalSubscriber<? super T> Y2;

        StreamConditionalSubscription(ConditionalSubscriber<? super T> conditionalSubscriber, Iterator<T> it2, AutoCloseable autoCloseable) {
            super(it2, autoCloseable);
            this.Y2 = conditionalSubscriber;
        }

        public void a(long j2) {
            Iterator<T> it2 = this.s;
            ConditionalSubscriber<? super T> conditionalSubscriber = this.Y2;
            long j3 = 0;
            while (!this.Y) {
                try {
                    T next = it2.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    if (conditionalSubscriber.o(next)) {
                        j3++;
                    }
                    if (this.Y) {
                        continue;
                    } else if (!it2.hasNext()) {
                        conditionalSubscriber.onComplete();
                        this.Y = true;
                    } else if (j3 != j2) {
                        continue;
                    } else {
                        j2 = get();
                        if (j3 != j2) {
                            continue;
                        } else if (!compareAndSet(j2, 0)) {
                            j2 = get();
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    conditionalSubscriber.onError(th);
                    this.Y = true;
                }
            }
            clear();
        }
    }

    static final class StreamSubscription<T> extends AbstractStreamSubscription<T> {
        private static final long Z2 = -9082954702547571853L;
        final Subscriber<? super T> Y2;

        StreamSubscription(Subscriber<? super T> subscriber, Iterator<T> it2, AutoCloseable autoCloseable) {
            super(it2, autoCloseable);
            this.Y2 = subscriber;
        }

        public void a(long j2) {
            Iterator<T> it2 = this.s;
            Subscriber<? super T> subscriber = this.Y2;
            long j3 = 0;
            while (!this.Y) {
                try {
                    T next = it2.next();
                    Objects.requireNonNull(next, "The Stream's Iterator returned a null value");
                    subscriber.onNext(next);
                    if (this.Y) {
                        continue;
                    } else if (!it2.hasNext()) {
                        subscriber.onComplete();
                        this.Y = true;
                    } else {
                        j3++;
                        if (j3 != j2) {
                            continue;
                        } else {
                            j2 = get();
                            if (j3 != j2) {
                                continue;
                            } else if (!compareAndSet(j2, 0)) {
                                j2 = get();
                            } else {
                                return;
                            }
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    subscriber.onError(th);
                    this.Y = true;
                }
            }
            clear();
        }
    }

    public FlowableFromStream(Stream<T> stream) {
        this.X = stream;
    }

    static void j9(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
    }

    public static <T> void k9(Subscriber<? super T> subscriber, Stream<T> stream) {
        try {
            Iterator a2 = stream.iterator();
            if (!a2.hasNext()) {
                EmptySubscription.a(subscriber);
                j9(stream);
                return;
            }
            subscriber.h(subscriber instanceof ConditionalSubscriber ? new StreamConditionalSubscription((ConditionalSubscriber) subscriber, a2, stream) : new StreamSubscription(subscriber, a2, stream));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
            j9(stream);
        }
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        k9(subscriber, this.X);
    }
}
