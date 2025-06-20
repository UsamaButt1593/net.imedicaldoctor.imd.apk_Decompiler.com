package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class CompletableMerge extends Completable {
    final int X;
    final boolean Y;
    final Publisher<? extends CompletableSource> s;

    static final class CompletableMergeSubscriber extends AtomicInteger implements FlowableSubscriber<CompletableSource>, Disposable {
        private static final long Z2 = -2108443387387077490L;
        final int X;
        final CompositeDisposable X2 = new CompositeDisposable();
        final boolean Y;
        Subscription Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        final CompletableObserver s;

        final class MergeInnerObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
            private static final long X = 251330541679988317L;

            MergeInnerObserver() {
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public boolean g() {
                return DisposableHelper.b((Disposable) get());
            }

            public void m() {
                DisposableHelper.a(this);
            }

            public void onComplete() {
                CompletableMergeSubscriber.this.a(this);
            }

            public void onError(Throwable th) {
                CompletableMergeSubscriber.this.b(this, th);
            }
        }

        CompletableMergeSubscriber(CompletableObserver completableObserver, int i2, boolean z) {
            this.s = completableObserver;
            this.X = i2;
            this.Y = z;
            lazySet(1);
        }

        /* access modifiers changed from: package-private */
        public void a(MergeInnerObserver mergeInnerObserver) {
            this.X2.c(mergeInnerObserver);
            if (decrementAndGet() == 0) {
                this.Z.f(this.s);
            } else if (this.X != Integer.MAX_VALUE) {
                this.Y2.request(1);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(MergeInnerObserver mergeInnerObserver, Throwable th) {
            this.X2.c(mergeInnerObserver);
            if (!this.Y) {
                this.Y2.cancel();
                this.X2.m();
                if (!this.Z.d(th) || getAndSet(0) <= 0) {
                    return;
                }
            } else if (!this.Z.d(th)) {
                return;
            } else {
                if (decrementAndGet() != 0) {
                    if (this.X != Integer.MAX_VALUE) {
                        this.Y2.request(1);
                        return;
                    }
                    return;
                }
            }
            this.Z.f(this.s);
        }

        /* renamed from: c */
        public void onNext(CompletableSource completableSource) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.X2.b(mergeInnerObserver);
            completableSource.a(mergeInnerObserver);
        }

        public boolean g() {
            return this.X2.g();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y2, subscription)) {
                this.Y2 = subscription;
                this.s.b(this);
                int i2 = this.X;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i2);
            }
        }

        public void m() {
            this.Y2.cancel();
            this.X2.m();
            this.Z.e();
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                this.Z.f(this.s);
            }
        }

        public void onError(Throwable th) {
            if (!this.Y) {
                this.X2.m();
                if (!this.Z.d(th) || getAndSet(0) <= 0) {
                    return;
                }
            } else if (!this.Z.d(th) || decrementAndGet() != 0) {
                return;
            }
            this.Z.f(this.s);
        }
    }

    public CompletableMerge(Publisher<? extends CompletableSource> publisher, int i2, boolean z) {
        this.s = publisher;
        this.X = i2;
        this.Y = z;
    }

    public void Z0(CompletableObserver completableObserver) {
        this.s.e(new CompletableMergeSubscriber(completableObserver, this.X, this.Y));
    }
}
