package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDebounceTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler X2;
    final long Y;
    final TimeUnit Z;

    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long X2 = 6812032969491025141L;
        final long X;
        final DebounceTimedSubscriber<T> Y;
        final AtomicBoolean Z = new AtomicBoolean();
        final T s;

        DebounceEmitter(T t, long j2, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.s = t;
            this.X = j2;
            this.Y = debounceTimedSubscriber;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.Z.compareAndSet(false, true)) {
                this.Y.a(this.X, this.s, this);
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        public boolean g() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void run() {
            a();
        }
    }

    static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long b3 = -9102637559663639004L;
        final long X;
        Subscription X2;
        final TimeUnit Y;
        Disposable Y2;
        final Scheduler.Worker Z;
        volatile long Z2;
        boolean a3;
        final Subscriber<? super T> s;

        DebounceTimedSubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.s = subscriber;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
        }

        /* access modifiers changed from: package-private */
        public void a(long j2, T t, DebounceEmitter<T> debounceEmitter) {
            if (j2 != this.Z2) {
                return;
            }
            if (get() != 0) {
                this.s.onNext(t);
                BackpressureHelper.e(this, 1);
                debounceEmitter.m();
                return;
            }
            cancel();
            this.s.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
        }

        public void cancel() {
            this.X2.cancel();
            this.Z.m();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X2, subscription)) {
                this.X2 = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            if (!this.a3) {
                this.a3 = true;
                Disposable disposable = this.Y2;
                if (disposable != null) {
                    disposable.m();
                }
                DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                if (debounceEmitter != null) {
                    debounceEmitter.a();
                }
                this.s.onComplete();
                this.Z.m();
            }
        }

        public void onError(Throwable th) {
            if (this.a3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.a3 = true;
            Disposable disposable = this.Y2;
            if (disposable != null) {
                disposable.m();
            }
            this.s.onError(th);
            this.Z.m();
        }

        public void onNext(T t) {
            if (!this.a3) {
                long j2 = this.Z2 + 1;
                this.Z2 = j2;
                Disposable disposable = this.Y2;
                if (disposable != null) {
                    disposable.m();
                }
                DebounceEmitter debounceEmitter = new DebounceEmitter(t, j2, this);
                this.Y2 = debounceEmitter;
                debounceEmitter.b(this.Z.c(debounceEmitter, this.X, this.Y));
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this, j2);
            }
        }
    }

    public FlowableDebounceTimed(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.Y, this.Z, this.X2.d()));
    }
}
