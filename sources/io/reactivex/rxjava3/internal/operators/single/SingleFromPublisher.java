package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleFromPublisher<T> extends Single<T> {
    final Publisher<? extends T> s;

    static final class ToSingleObserver<T> implements FlowableSubscriber<T>, Disposable {
        Subscription X;
        volatile boolean X2;
        T Y;
        boolean Z;
        final SingleObserver<? super T> s;

        ToSingleObserver(SingleObserver<? super T> singleObserver) {
            this.s = singleObserver;
        }

        public boolean g() {
            return this.X2;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.s.b(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void m() {
            this.X2 = true;
            this.X.cancel();
        }

        public void onComplete() {
            if (!this.Z) {
                this.Z = true;
                T t = this.Y;
                this.Y = null;
                if (t == null) {
                    this.s.onError(new NoSuchElementException("The source Publisher is empty"));
                } else {
                    this.s.a(t);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.Y = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.Y != null) {
                    this.X.cancel();
                    this.Z = true;
                    this.Y = null;
                    this.s.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
                    return;
                }
                this.Y = t;
            }
        }
    }

    public SingleFromPublisher(Publisher<? extends T> publisher) {
        this.s = publisher;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(new ToSingleObserver(singleObserver));
    }
}
