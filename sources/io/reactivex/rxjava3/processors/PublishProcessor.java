package io.reactivex.rxjava3.processors;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class PublishProcessor<T> extends FlowableProcessor<T> {
    static final PublishSubscription[] X2 = new PublishSubscription[0];
    static final PublishSubscription[] Z = new PublishSubscription[0];
    final AtomicReference<PublishSubscription<T>[]> X = new AtomicReference<>(X2);
    Throwable Y;

    static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long Y = 3562861878281475070L;
        final PublishProcessor<T> X;
        final Subscriber<? super T> s;

        PublishSubscription(Subscriber<? super T> subscriber, PublishProcessor<T> publishProcessor) {
            this.s = subscriber;
            this.X = publishProcessor;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return get() == 0;
        }

        public void c() {
            if (get() != Long.MIN_VALUE) {
                this.s.onComplete();
            }
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.X.r9(this);
            }
        }

        public void d(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.s.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }

        public void e(T t) {
            long j2 = get();
            if (j2 != Long.MIN_VALUE) {
                if (j2 != 0) {
                    this.s.onNext(t);
                    BackpressureHelper.f(this, 1);
                    return;
                }
                cancel();
                this.s.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.b(this, j2);
            }
        }
    }

    PublishProcessor() {
    }

    @NonNull
    @CheckReturnValue
    public static <T> PublishProcessor<T> p9() {
        return new PublishProcessor<>();
    }

    /* access modifiers changed from: protected */
    public void K6(@NonNull Subscriber<? super T> subscriber) {
        PublishSubscription publishSubscription = new PublishSubscription(subscriber, this);
        subscriber.h(publishSubscription);
        if (!o9(publishSubscription)) {
            Throwable th = this.Y;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        } else if (publishSubscription.a()) {
            r9(publishSubscription);
        }
    }

    public void h(@NonNull Subscription subscription) {
        if (this.X.get() == Z) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @CheckReturnValue
    @Nullable
    public Throwable j9() {
        if (this.X.get() == Z) {
            return this.Y;
        }
        return null;
    }

    @CheckReturnValue
    public boolean k9() {
        return this.X.get() == Z && this.Y == null;
    }

    @CheckReturnValue
    public boolean l9() {
        return ((PublishSubscription[]) this.X.get()).length != 0;
    }

    @CheckReturnValue
    public boolean m9() {
        return this.X.get() == Z && this.Y != null;
    }

    /* access modifiers changed from: package-private */
    public boolean o9(PublishSubscription<T> publishSubscription) {
        PublishSubscription[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.X.get();
            if (publishSubscriptionArr == Z) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[(length + 1)];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!g.a(this.X, publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    public void onComplete() {
        PublishSubscription<T>[] publishSubscriptionArr = this.X.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = Z;
        if (publishSubscriptionArr != publishSubscriptionArr2) {
            for (PublishSubscription c2 : (PublishSubscription[]) this.X.getAndSet(publishSubscriptionArr2)) {
                c2.c();
            }
        }
    }

    public void onError(@NonNull Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        PublishSubscription<T>[] publishSubscriptionArr = this.X.get();
        PublishSubscription<T>[] publishSubscriptionArr2 = Z;
        if (publishSubscriptionArr == publishSubscriptionArr2) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Y = th;
        for (PublishSubscription d2 : (PublishSubscription[]) this.X.getAndSet(publishSubscriptionArr2)) {
            d2.d(th);
        }
    }

    public void onNext(@NonNull T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        for (PublishSubscription e2 : (PublishSubscription[]) this.X.get()) {
            e2.e(t);
        }
    }

    @CheckReturnValue
    public boolean q9(@NonNull T t) {
        ExceptionHelper.d(t, "offer called with a null value.");
        PublishSubscription[] publishSubscriptionArr = (PublishSubscription[]) this.X.get();
        for (PublishSubscription b2 : publishSubscriptionArr) {
            if (b2.b()) {
                return false;
            }
        }
        for (PublishSubscription e2 : publishSubscriptionArr) {
            e2.e(t);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void r9(PublishSubscription<T> publishSubscription) {
        PublishSubscription<T>[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.X.get();
            if (publishSubscriptionArr != Z && publishSubscriptionArr != X2) {
                int length = publishSubscriptionArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (publishSubscriptionArr[i2] == publishSubscription) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        publishSubscriptionArr2 = X2;
                    } else {
                        PublishSubscription[] publishSubscriptionArr3 = new PublishSubscription[(length - 1)];
                        System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i2);
                        System.arraycopy(publishSubscriptionArr, i2 + 1, publishSubscriptionArr3, i2, (length - i2) - 1);
                        publishSubscriptionArr2 = publishSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X, publishSubscriptionArr, publishSubscriptionArr2));
    }
}
