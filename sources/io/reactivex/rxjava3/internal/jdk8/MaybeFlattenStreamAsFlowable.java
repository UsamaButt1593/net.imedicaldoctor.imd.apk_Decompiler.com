package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.e;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;

public final class MaybeFlattenStreamAsFlowable<T, R> extends Flowable<R> {
    final Maybe<T> X;
    final Function<? super T, ? extends Stream<? extends R>> Y;

    static final class FlattenStreamMultiObserver<T, R> extends BasicIntQueueSubscription<R> implements MaybeObserver<T>, SingleObserver<T> {
        private static final long e3 = 7363336003027148283L;
        final Subscriber<? super R> X;
        Disposable X2;
        final Function<? super T, ? extends Stream<? extends R>> Y;
        volatile Iterator<? extends R> Y2;
        final AtomicLong Z = new AtomicLong();
        AutoCloseable Z2;
        boolean a3;
        volatile boolean b3;
        boolean c3;
        long d3;

        FlattenStreamMultiObserver(Subscriber<? super R> subscriber, Function<? super T, ? extends Stream<? extends R>> function) {
            this.X = subscriber;
            this.Y = function;
        }

        public void a(@NonNull T t) {
            try {
                Object apply = this.Y.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Stream");
                Stream a2 = e.a(apply);
                Iterator<? extends R> a4 = a2.iterator();
                if (!a4.hasNext()) {
                    this.X.onComplete();
                    f(a2);
                    return;
                }
                this.Y2 = a4;
                this.Z2 = a2;
                d();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.X.onError(th);
            }
        }

        public void b(@NonNull Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.X.h(this);
            }
        }

        public void cancel() {
            this.b3 = true;
            this.X2.m();
            if (!this.c3) {
                d();
            }
        }

        public void clear() {
            this.Y2 = null;
            AutoCloseable autoCloseable = this.Z2;
            this.Z2 = null;
            f(autoCloseable);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.X;
                long j2 = this.d3;
                long j3 = this.Z.get();
                Iterator<? extends R> it2 = this.Y2;
                int i2 = 1;
                while (true) {
                    if (this.b3) {
                        clear();
                    } else if (this.c3) {
                        if (it2 != null) {
                            subscriber.onNext(null);
                            subscriber.onComplete();
                        }
                    } else if (!(it2 == null || j2 == j3)) {
                        try {
                            Object next = it2.next();
                            if (!this.b3) {
                                subscriber.onNext(next);
                                j2++;
                                if (!this.b3) {
                                    boolean hasNext = it2.hasNext();
                                    if (!this.b3 && !hasNext) {
                                        subscriber.onComplete();
                                        this.b3 = true;
                                    }
                                }
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            subscriber.onError(th);
                        }
                    }
                    this.d3 = j2;
                    i2 = addAndGet(-i2);
                    if (i2 != 0) {
                        j3 = this.Z.get();
                        if (it2 == null) {
                            it2 = this.Y2;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f(AutoCloseable autoCloseable) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.Y(th);
                }
            }
        }

        public boolean isEmpty() {
            Iterator<? extends R> it2 = this.Y2;
            if (it2 == null) {
                return true;
            }
            if (!this.a3 || it2.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(@NonNull Throwable th) {
            this.X.onError(th);
        }

        @Nullable
        public R poll() throws Throwable {
            Iterator<? extends R> it2 = this.Y2;
            if (it2 == null) {
                return null;
            }
            if (!this.a3) {
                this.a3 = true;
            } else if (!it2.hasNext()) {
                clear();
                return null;
            }
            return it2.next();
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.c3 = true;
            return 2;
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z, j2);
                d();
            }
        }
    }

    public MaybeFlattenStreamAsFlowable(Maybe<T> maybe, Function<? super T, ? extends Stream<? extends R>> function) {
        this.X = maybe;
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(@NonNull Subscriber<? super R> subscriber) {
        this.X.d(new FlattenStreamMultiObserver(subscriber, this.Y));
    }
}
