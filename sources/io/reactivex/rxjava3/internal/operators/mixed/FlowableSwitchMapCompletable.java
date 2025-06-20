package io.reactivex.rxjava3.internal.operators.mixed;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableSwitchMapCompletable<T> extends Completable {
    final Function<? super T, ? extends CompletableSource> X;
    final boolean Y;
    final Flowable<T> s;

    static final class SwitchMapCompletableObserver<T> implements FlowableSubscriber<T>, Disposable {
        static final SwitchMapInnerObserver a3 = new SwitchMapInnerObserver((SwitchMapCompletableObserver<?>) null);
        final Function<? super T, ? extends CompletableSource> X;
        final AtomicReference<SwitchMapInnerObserver> X2 = new AtomicReference<>();
        final boolean Y;
        volatile boolean Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        Subscription Z2;
        final CompletableObserver s;

        static final class SwitchMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long X = -8003404460084760287L;
            final SwitchMapCompletableObserver<?> s;

            SwitchMapInnerObserver(SwitchMapCompletableObserver<?> switchMapCompletableObserver) {
                this.s = switchMapCompletableObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                this.s.b(this);
            }

            public void onError(Throwable th) {
                this.s.c(this, th);
            }
        }

        SwitchMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, boolean z) {
            this.s = completableObserver;
            this.X = function;
            this.Y = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            AtomicReference<SwitchMapInnerObserver> atomicReference = this.X2;
            SwitchMapInnerObserver switchMapInnerObserver = a3;
            SwitchMapInnerObserver andSet = atomicReference.getAndSet(switchMapInnerObserver);
            if (andSet != null && andSet != switchMapInnerObserver) {
                andSet.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(SwitchMapInnerObserver switchMapInnerObserver) {
            if (g.a(this.X2, switchMapInnerObserver, (Object) null) && this.Y2) {
                this.Z.f(this.s);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(SwitchMapInnerObserver switchMapInnerObserver, Throwable th) {
            if (!g.a(this.X2, switchMapInnerObserver, (Object) null)) {
                RxJavaPlugins.Y(th);
            } else if (this.Z.d(th)) {
                if (!this.Y) {
                    this.Z2.cancel();
                    a();
                } else if (!this.Y2) {
                    return;
                }
                this.Z.f(this.s);
            }
        }

        public boolean g() {
            return this.X2.get() == a3;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z2, subscription)) {
                this.Z2 = subscription;
                this.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.Z2.cancel();
            a();
            this.Z.e();
        }

        public void onComplete() {
            this.Y2 = true;
            if (this.X2.get() == null) {
                this.Z.f(this.s);
            }
        }

        public void onError(Throwable th) {
            if (!this.Z.d(th)) {
                return;
            }
            if (this.Y) {
                onComplete();
                return;
            }
            a();
            this.Z.f(this.s);
        }

        public void onNext(T t) {
            SwitchMapInnerObserver switchMapInnerObserver;
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                CompletableSource completableSource = (CompletableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver2 = new SwitchMapInnerObserver(this);
                do {
                    switchMapInnerObserver = this.X2.get();
                    if (switchMapInnerObserver == a3) {
                        return;
                    }
                } while (!g.a(this.X2, switchMapInnerObserver, switchMapInnerObserver2));
                if (switchMapInnerObserver != null) {
                    switchMapInnerObserver.a();
                }
                completableSource.a(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Z2.cancel();
                onError(th);
            }
        }
    }

    public FlowableSwitchMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, boolean z) {
        this.s = flowable;
        this.X = function;
        this.Y = z;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.J6(new SwitchMapCompletableObserver(completableObserver, this.X, this.Y));
    }
}
