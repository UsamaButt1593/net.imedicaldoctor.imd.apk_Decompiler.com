package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatIterable<T> extends Flowable<T> {
    final Iterable<? extends MaybeSource<? extends T>> X;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long Z2 = 3520831347801429610L;
        final AtomicLong X = new AtomicLong();
        final Iterator<? extends MaybeSource<? extends T>> X2;
        final AtomicReference<Object> Y = new AtomicReference<>(NotificationLite.COMPLETE);
        long Y2;
        final SequentialDisposable Z = new SequentialDisposable();
        final Subscriber<? super T> s;

        ConcatMaybeObserver(Subscriber<? super T> subscriber, Iterator<? extends MaybeSource<? extends T>> it2) {
            this.s = subscriber;
            this.X2 = it2;
        }

        public void a(T t) {
            this.Y.lazySet(t);
            c();
        }

        public void b(Disposable disposable) {
            this.Z.a(disposable);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                AtomicReference<Object> atomicReference = this.Y;
                Subscriber<? super T> subscriber = this.s;
                SequentialDisposable sequentialDisposable = this.Z;
                while (!sequentialDisposable.g()) {
                    Object obj = atomicReference.get();
                    if (obj != null) {
                        if (obj != NotificationLite.COMPLETE) {
                            long j2 = this.Y2;
                            if (j2 != this.X.get()) {
                                this.Y2 = j2 + 1;
                                atomicReference.lazySet((Object) null);
                                subscriber.onNext(obj);
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (!sequentialDisposable.g()) {
                            try {
                                if (this.X2.hasNext()) {
                                    Object next = this.X2.next();
                                    Objects.requireNonNull(next, "The source Iterator returned a null MaybeSource");
                                    ((MaybeSource) next).d(this);
                                } else {
                                    subscriber.onComplete();
                                }
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                subscriber.onError(th);
                                return;
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void cancel() {
            this.Z.m();
        }

        public void onComplete() {
            this.Y.lazySet(NotificationLite.COMPLETE);
            c();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.X, j2);
                c();
            }
        }
    }

    public MaybeConcatIterable(Iterable<? extends MaybeSource<? extends T>> iterable) {
        this.X = iterable;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends MaybeSource<? extends T>> it2 = this.X.iterator();
            Objects.requireNonNull(it2, "The sources Iterable returned a null Iterator");
            ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, it2);
            subscriber.h(concatMaybeObserver);
            concatMaybeObserver.c();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
