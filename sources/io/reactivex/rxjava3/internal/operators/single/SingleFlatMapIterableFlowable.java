package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;

public final class SingleFlatMapIterableFlowable<T, R> extends Flowable<R> {
    final SingleSource<T> X;
    final Function<? super T, ? extends Iterable<? extends R>> Y;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements SingleObserver<T> {
        private static final long b3 = -8938804753851907758L;
        final Subscriber<? super R> X;
        Disposable X2;
        final Function<? super T, ? extends Iterable<? extends R>> Y;
        volatile Iterator<? extends R> Y2;
        final AtomicLong Z = new AtomicLong();
        volatile boolean Z2;
        boolean a3;

        FlatMapIterableObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.X = subscriber;
            this.Y = function;
        }

        public void a(T t) {
            try {
                Iterator<? extends R> it2 = ((Iterable) this.Y.apply(t)).iterator();
                if (!it2.hasNext()) {
                    this.X.onComplete();
                    return;
                }
                this.Y2 = it2;
                d();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.X.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.X.h(this);
            }
        }

        public void cancel() {
            this.Z2 = true;
            this.X2.m();
            this.X2 = DisposableHelper.DISPOSED;
        }

        public void clear() {
            this.Y2 = null;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.X;
                Iterator<? extends R> it2 = this.Y2;
                if (!this.a3 || it2 == null) {
                    int i2 = 1;
                    while (true) {
                        if (it2 != null) {
                            long j2 = this.Z.get();
                            if (j2 == Long.MAX_VALUE) {
                                f(subscriber, it2);
                                return;
                            }
                            long j3 = 0;
                            while (j3 != j2) {
                                if (!this.Z2) {
                                    try {
                                        Object next = it2.next();
                                        Objects.requireNonNull(next, "The iterator returned a null value");
                                        subscriber.onNext(next);
                                        if (!this.Z2) {
                                            j3++;
                                            try {
                                                if (!it2.hasNext()) {
                                                    subscriber.onComplete();
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.b(th);
                                                subscriber.onError(th);
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.b(th2);
                                        subscriber.onError(th2);
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (j3 != 0) {
                                BackpressureHelper.e(this.Z, j3);
                            }
                        }
                        i2 = addAndGet(-i2);
                        if (i2 != 0) {
                            if (it2 == null) {
                                it2 = this.Y2;
                            }
                        } else {
                            return;
                        }
                    }
                } else {
                    subscriber.onNext(null);
                    subscriber.onComplete();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f(Subscriber<? super R> subscriber, Iterator<? extends R> it2) {
            while (!this.Z2) {
                try {
                    subscriber.onNext(it2.next());
                    if (!this.Z2) {
                        if (!it2.hasNext()) {
                            subscriber.onComplete();
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    subscriber.onError(th);
                    return;
                }
            }
        }

        public boolean isEmpty() {
            return this.Y2 == null;
        }

        public void onError(Throwable th) {
            this.X2 = DisposableHelper.DISPOSED;
            this.X.onError(th);
        }

        @Nullable
        public R poll() {
            Iterator<? extends R> it2 = this.Y2;
            if (it2 == null) {
                return null;
            }
            R next = it2.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.Y2 = null;
            }
            return next;
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.a3 = true;
            return 2;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                d();
            }
        }
    }

    public SingleFlatMapIterableFlowable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.X = singleSource;
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.e(new FlatMapIterableObserver(subscriber, this.Y));
    }
}
