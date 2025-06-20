package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class MaybeConcatArray<T> extends Flowable<T> {
    final MaybeSource<? extends T>[] X;

    static final class ConcatMaybeObserver<T> extends AtomicInteger implements MaybeObserver<T>, Subscription {
        private static final long a3 = 3520831347801429610L;
        final AtomicLong X = new AtomicLong();
        final MaybeSource<? extends T>[] X2;
        final AtomicReference<Object> Y = new AtomicReference<>(NotificationLite.COMPLETE);
        int Y2;
        final SequentialDisposable Z = new SequentialDisposable();
        long Z2;
        final Subscriber<? super T> s;

        ConcatMaybeObserver(Subscriber<? super T> subscriber, MaybeSource<? extends T>[] maybeSourceArr) {
            this.s = subscriber;
            this.X2 = maybeSourceArr;
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
                            long j2 = this.Z2;
                            if (j2 != this.X.get()) {
                                this.Z2 = j2 + 1;
                                atomicReference.lazySet((Object) null);
                                subscriber.onNext(obj);
                            }
                        } else {
                            atomicReference.lazySet((Object) null);
                        }
                        if (!sequentialDisposable.g()) {
                            int i2 = this.Y2;
                            MaybeSource<? extends T>[] maybeSourceArr = this.X2;
                            if (i2 == maybeSourceArr.length) {
                                subscriber.onComplete();
                                return;
                            } else {
                                this.Y2 = i2 + 1;
                                maybeSourceArr[i2].d(this);
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

    public MaybeConcatArray(MaybeSource<? extends T>[] maybeSourceArr) {
        this.X = maybeSourceArr;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(subscriber, this.X);
        subscriber.h(concatMaybeObserver);
        concatMaybeObserver.c();
    }
}
