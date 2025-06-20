package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

public final class FlowableSequenceEqualSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {
    final Publisher<? extends T> X;
    final BiPredicate<? super T, ? super T> Y;
    final int Z;
    final Publisher<? extends T> s;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual.EqualCoordinatorHelper {
        private static final long a3 = -6178010334400373240L;
        final BiPredicate<? super T, ? super T> X;
        final AtomicThrowable X2 = new AtomicThrowable();
        final FlowableSequenceEqual.EqualSubscriber<T> Y;
        T Y2;
        final FlowableSequenceEqual.EqualSubscriber<T> Z;
        T Z2;
        final SingleObserver<? super Boolean> s;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, int i2, BiPredicate<? super T, ? super T> biPredicate) {
            this.s = singleObserver;
            this.X = biPredicate;
            this.Y = new FlowableSequenceEqual.EqualSubscriber<>(this, i2);
            this.Z = new FlowableSequenceEqual.EqualSubscriber<>(this, i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.Y.a();
            this.Y.b();
            this.Z.a();
            this.Z.b();
        }

        /* access modifiers changed from: package-private */
        public void b(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
            publisher.e(this.Y);
            publisher2.e(this.Z);
        }

        public void c(Throwable th) {
            if (this.X2.d(th)) {
                d();
            }
        }

        public void d() {
            if (getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    SimpleQueue<T> simpleQueue = this.Y.X2;
                    SimpleQueue<T> simpleQueue2 = this.Z.X2;
                    if (simpleQueue != null && simpleQueue2 != null) {
                        while (!g()) {
                            if (((Throwable) this.X2.get()) != null) {
                                a();
                                this.X2.j(this.s);
                                return;
                            }
                            boolean z = this.Y.Y2;
                            T t = this.Y2;
                            if (t == null) {
                                try {
                                    t = simpleQueue.poll();
                                    this.Y2 = t;
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    a();
                                    this.X2.d(th);
                                    this.X2.j(this.s);
                                    return;
                                }
                            }
                            boolean z2 = false;
                            boolean z3 = t == null;
                            boolean z4 = this.Z.Y2;
                            T t2 = this.Z2;
                            if (t2 == null) {
                                try {
                                    t2 = simpleQueue2.poll();
                                    this.Z2 = t2;
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    a();
                                    this.X2.d(th2);
                                    this.X2.j(this.s);
                                    return;
                                }
                            }
                            if (t2 == null) {
                                z2 = true;
                            }
                            if (z && z4 && z3 && z2) {
                                this.s.a(Boolean.TRUE);
                                return;
                            } else if (z && z4 && z3 != z2) {
                                a();
                                this.s.a(Boolean.FALSE);
                                return;
                            } else if (!z3 && !z2) {
                                try {
                                    if (!this.X.a(t, t2)) {
                                        a();
                                        this.s.a(Boolean.FALSE);
                                        return;
                                    }
                                    this.Y2 = null;
                                    this.Z2 = null;
                                    this.Y.c();
                                    this.Z.c();
                                } catch (Throwable th3) {
                                    Exceptions.b(th3);
                                    a();
                                    this.X2.d(th3);
                                    this.X2.j(this.s);
                                    return;
                                }
                            }
                        }
                        this.Y.b();
                        this.Z.b();
                        return;
                    } else if (g()) {
                        this.Y.b();
                        this.Z.b();
                        return;
                    } else if (((Throwable) this.X2.get()) != null) {
                        a();
                        this.X2.j(this.s);
                        return;
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        public boolean g() {
            return this.Y.get() == SubscriptionHelper.CANCELLED;
        }

        public void m() {
            this.Y.a();
            this.Z.a();
            this.X2.e();
            if (getAndIncrement() == 0) {
                this.Y.b();
                this.Z.b();
            }
        }
    }

    public FlowableSequenceEqualSingle(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i2) {
        this.s = publisher;
        this.X = publisher2;
        this.Y = biPredicate;
        this.Z = i2;
    }

    public void O1(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.Z, this.Y);
        singleObserver.b(equalCoordinator);
        equalCoordinator.b(this.s, this.X);
    }

    public Flowable<Boolean> f() {
        return RxJavaPlugins.P(new FlowableSequenceEqual(this.s, this.X, this.Y, this.Z));
    }
}
