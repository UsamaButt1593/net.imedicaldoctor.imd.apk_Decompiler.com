package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGenerate<T, S> extends Flowable<T> {
    final Supplier<S> X;
    final BiFunction<S, Emitter<T>, S> Y;
    final Consumer<? super S> Z;

    static final class GeneratorSubscription<T, S> extends AtomicLong implements Emitter<T>, Subscription {
        private static final long a3 = 7565982551505011832L;
        final BiFunction<S, ? super Emitter<T>, S> X;
        volatile boolean X2;
        final Consumer<? super S> Y;
        boolean Y2;
        S Z;
        boolean Z2;
        final Subscriber<? super T> s;

        GeneratorSubscription(Subscriber<? super T> subscriber, BiFunction<S, ? super Emitter<T>, S> biFunction, Consumer<? super S> consumer, S s2) {
            this.s = subscriber;
            this.X = biFunction;
            this.Y = consumer;
            this.Z = s2;
        }

        private void a(S s2) {
            try {
                this.Y.accept(s2);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }

        public void cancel() {
            if (!this.X2) {
                this.X2 = true;
                if (BackpressureHelper.a(this, 1) == 0) {
                    S s2 = this.Z;
                    this.Z = null;
                    a(s2);
                }
            }
        }

        public void onComplete() {
            if (!this.Y2) {
                this.Y2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y2) {
                RxJavaPlugins.Y(th);
                return;
            }
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            this.Y2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            Throwable b2;
            if (!this.Y2) {
                if (this.Z2) {
                    b2 = new IllegalStateException("onNext already called in this generate turn");
                } else if (t == null) {
                    b2 = ExceptionHelper.b("onNext called with a null value.");
                } else {
                    this.Z2 = true;
                    this.s.onNext(t);
                    return;
                }
                onError(b2);
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2) && BackpressureHelper.a(this, j2) == 0) {
                S s2 = this.Z;
                BiFunction<S, ? super Emitter<T>, S> biFunction = this.X;
                loop0:
                do {
                    long j3 = 0;
                    while (true) {
                        if (j3 == j2) {
                            j2 = get();
                            if (j3 == j2) {
                                this.Z = s2;
                                j2 = addAndGet(-j3);
                            }
                        } else if (this.X2) {
                            break loop0;
                        } else {
                            this.Z2 = false;
                            try {
                                s2 = biFunction.apply(s2, this);
                                if (this.Y2) {
                                    this.X2 = true;
                                    break loop0;
                                }
                                j3++;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.X2 = true;
                                this.Z = null;
                                onError(th);
                            }
                        }
                    }
                    this.Z = null;
                    a(s2);
                    return;
                } while (j2 != 0);
            }
        }
    }

    public FlowableGenerate(Supplier<S> supplier, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        this.X = supplier;
        this.Y = biFunction;
        this.Z = consumer;
    }

    public void K6(Subscriber<? super T> subscriber) {
        try {
            subscriber.h(new GeneratorSubscription(subscriber, this.Y, this.Z, this.X.get()));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
