package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    Subscription X;
    boolean Y;
    final Subscriber<? super T> s;

    public SafeSubscriber(@NonNull Subscriber<? super T> subscriber) {
        this.s = subscriber;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.s.h(EmptySubscription.INSTANCE);
            try {
                this.s.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(nullPointerException, th2));
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.Y = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.s.h(EmptySubscription.INSTANCE);
            try {
                this.s.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.Y(new CompositeException(nullPointerException, th2));
        }
    }

    public void cancel() {
        try {
            this.X.cancel();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
    }

    public void h(@NonNull Subscription subscription) {
        if (SubscriptionHelper.l(this.X, subscription)) {
            this.X = subscription;
            try {
                this.s.h(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(new CompositeException(th, th));
            }
        }
    }

    public void onComplete() {
        if (!this.Y) {
            this.Y = true;
            if (this.X == null) {
                a();
                return;
            }
            try {
                this.s.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }
    }

    public void onError(@NonNull Throwable th) {
        if (this.Y) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Y = true;
        if (this.X == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.s.h(EmptySubscription.INSTANCE);
                try {
                    this.s.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.Y(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.Y(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            try {
                this.s.onError(th);
            } catch (Throwable th4) {
                Exceptions.b(th4);
                RxJavaPlugins.Y(new CompositeException(th, th4));
            }
        }
    }

    public void onNext(@NonNull T t) {
        CompositeException compositeException;
        if (!this.Y) {
            if (this.X == null) {
                b();
            } else if (t == null) {
                NullPointerException b2 = ExceptionHelper.b("onNext called with a null Throwable.");
                try {
                    this.X.cancel();
                    onError(b2);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    compositeException = new CompositeException(b2, th);
                    onError(compositeException);
                }
            } else {
                try {
                    this.s.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    compositeException = new CompositeException(th, th2);
                    onError(compositeException);
                }
            }
        }
    }

    public void request(long j2) {
        try {
            this.X.request(j2);
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(new CompositeException(th, th));
        }
    }
}
