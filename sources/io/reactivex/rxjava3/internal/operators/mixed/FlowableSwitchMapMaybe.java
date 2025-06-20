package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMapMaybe<T, R> extends Flowable<R> {
    final Flowable<T> X;
    final Function<? super T, ? extends MaybeSource<? extends R>> Y;
    final boolean Z;

    static final class SwitchMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long d3 = -5402190102429853762L;
        static final SwitchMapMaybeObserver<Object> e3 = new SwitchMapMaybeObserver<>((SwitchMapMaybeSubscriber) null);
        final Function<? super T, ? extends MaybeSource<? extends R>> X;
        final AtomicLong X2 = new AtomicLong();
        final boolean Y;
        final AtomicReference<SwitchMapMaybeObserver<R>> Y2 = new AtomicReference<>();
        final AtomicThrowable Z = new AtomicThrowable();
        Subscription Z2;
        volatile boolean a3;
        volatile boolean b3;
        long c3;
        final Subscriber<? super R> s;

        static final class SwitchMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long Y = 8042919737683345351L;
            volatile R X;
            final SwitchMapMaybeSubscriber<?, R> s;

            SwitchMapMaybeObserver(SwitchMapMaybeSubscriber<?, R> switchMapMaybeSubscriber) {
                this.s = switchMapMaybeSubscriber;
            }

            public void a(R r) {
                this.X = r;
                this.s.b();
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            /* access modifiers changed from: package-private */
            public void c() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                this.s.c(this);
            }

            public void onError(Throwable th) {
                this.s.d(this, th);
            }
        }

        SwitchMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
            this.s = subscriber;
            this.X = function;
            this.Y = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.Y2;
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver = e3;
            SwitchMapMaybeObserver<Object> andSet = atomicReference.getAndSet(switchMapMaybeObserver);
            if (andSet != null && andSet != switchMapMaybeObserver) {
                andSet.c();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.s;
                AtomicThrowable atomicThrowable = this.Z;
                AtomicReference<SwitchMapMaybeObserver<R>> atomicReference = this.Y2;
                AtomicLong atomicLong = this.X2;
                long j2 = this.c3;
                int i2 = 1;
                while (!this.b3) {
                    if (atomicThrowable.get() == null || this.Y) {
                        boolean z = this.a3;
                        SwitchMapMaybeObserver switchMapMaybeObserver = atomicReference.get();
                        boolean z2 = switchMapMaybeObserver == null;
                        if (z && z2) {
                            atomicThrowable.k(subscriber);
                            return;
                        } else if (z2 || switchMapMaybeObserver.X == null || j2 == atomicLong.get()) {
                            this.c3 = j2;
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else {
                            g.a(atomicReference, switchMapMaybeObserver, (Object) null);
                            subscriber.onNext(switchMapMaybeObserver.X);
                            j2++;
                        }
                    } else {
                        atomicThrowable.k(subscriber);
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(SwitchMapMaybeObserver<R> switchMapMaybeObserver) {
            if (g.a(this.Y2, switchMapMaybeObserver, (Object) null)) {
                b();
            }
        }

        public void cancel() {
            this.b3 = true;
            this.Z2.cancel();
            a();
            this.Z.e();
        }

        /* access modifiers changed from: package-private */
        public void d(SwitchMapMaybeObserver<R> switchMapMaybeObserver, Throwable th) {
            if (!g.a(this.Y2, switchMapMaybeObserver, (Object) null)) {
                RxJavaPlugins.Y(th);
            } else if (this.Z.d(th)) {
                if (!this.Y) {
                    this.Z2.cancel();
                    a();
                }
                b();
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.a3 = true;
            b();
        }

        public void onError(Throwable th) {
            if (this.Z.d(th)) {
                if (!this.Y) {
                    a();
                }
                this.a3 = true;
                b();
            }
        }

        public void onNext(T t) {
            SwitchMapMaybeObserver<Object> switchMapMaybeObserver;
            SwitchMapMaybeObserver switchMapMaybeObserver2 = this.Y2.get();
            if (switchMapMaybeObserver2 != null) {
                switchMapMaybeObserver2.c();
            }
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                SwitchMapMaybeObserver switchMapMaybeObserver3 = new SwitchMapMaybeObserver(this);
                do {
                    switchMapMaybeObserver = this.Y2.get();
                    if (switchMapMaybeObserver == e3) {
                        return;
                    }
                } while (!g.a(this.Y2, switchMapMaybeObserver, switchMapMaybeObserver3));
                maybeSource.d(switchMapMaybeObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Z2.cancel();
                this.Y2.getAndSet(e3);
                onError(th);
            }
        }

        public void request(long j2) {
            BackpressureHelper.a(this.X2, j2);
            b();
        }
    }

    public FlowableSwitchMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        this.X = flowable;
        this.Y = function;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.J6(new SwitchMapMaybeSubscriber(subscriber, this.Y, this.Z));
    }
}
