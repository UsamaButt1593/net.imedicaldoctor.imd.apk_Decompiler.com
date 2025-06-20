package io.reactivex.rxjava3.processors;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class AsyncProcessor<T> extends FlowableProcessor<T> {
    static final AsyncSubscription[] X2 = new AsyncSubscription[0];
    static final AsyncSubscription[] Y2 = new AsyncSubscription[0];
    final AtomicReference<AsyncSubscription<T>[]> X = new AtomicReference<>(X2);
    Throwable Y;
    T Z;

    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long g3 = 5629876084736248016L;
        final AsyncProcessor<T> f3;

        AsyncSubscription(Subscriber<? super T> subscriber, AsyncProcessor<T> asyncProcessor) {
            super(subscriber);
            this.f3 = asyncProcessor;
        }

        public void cancel() {
            if (super.i()) {
                this.f3.s9(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void onComplete() {
            if (!g()) {
                this.X.onComplete();
            }
        }

        /* access modifiers changed from: package-private */
        public void onError(Throwable th) {
            if (g()) {
                RxJavaPlugins.Y(th);
            } else {
                this.X.onError(th);
            }
        }
    }

    AsyncProcessor() {
    }

    @NonNull
    @CheckReturnValue
    public static <T> AsyncProcessor<T> p9() {
        return new AsyncProcessor<>();
    }

    /* access modifiers changed from: protected */
    public void K6(@NonNull Subscriber<? super T> subscriber) {
        AsyncSubscription asyncSubscription = new AsyncSubscription(subscriber, this);
        subscriber.h(asyncSubscription);
        if (!o9(asyncSubscription)) {
            Throwable th = this.Y;
            if (th != null) {
                subscriber.onError(th);
                return;
            }
            T t = this.Z;
            if (t != null) {
                asyncSubscription.f(t);
            } else {
                asyncSubscription.onComplete();
            }
        } else if (asyncSubscription.g()) {
            s9(asyncSubscription);
        }
    }

    public void h(@NonNull Subscription subscription) {
        if (this.X.get() == Y2) {
            subscription.cancel();
        } else {
            subscription.request(Long.MAX_VALUE);
        }
    }

    @CheckReturnValue
    @Nullable
    public Throwable j9() {
        if (this.X.get() == Y2) {
            return this.Y;
        }
        return null;
    }

    @CheckReturnValue
    public boolean k9() {
        return this.X.get() == Y2 && this.Y == null;
    }

    @CheckReturnValue
    public boolean l9() {
        return ((AsyncSubscription[]) this.X.get()).length != 0;
    }

    @CheckReturnValue
    public boolean m9() {
        return this.X.get() == Y2 && this.Y != null;
    }

    /* access modifiers changed from: package-private */
    public boolean o9(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.X.get();
            if (asyncSubscriptionArr == Y2) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[(length + 1)];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!g.a(this.X, asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    public void onComplete() {
        AsyncSubscription<T>[] asyncSubscriptionArr = this.X.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = Y2;
        if (asyncSubscriptionArr != asyncSubscriptionArr2) {
            T t = this.Z;
            AsyncSubscription[] asyncSubscriptionArr3 = (AsyncSubscription[]) this.X.getAndSet(asyncSubscriptionArr2);
            int i2 = 0;
            if (t == null) {
                int length = asyncSubscriptionArr3.length;
                while (i2 < length) {
                    asyncSubscriptionArr3[i2].onComplete();
                    i2++;
                }
                return;
            }
            int length2 = asyncSubscriptionArr3.length;
            while (i2 < length2) {
                asyncSubscriptionArr3[i2].f(t);
                i2++;
            }
        }
    }

    public void onError(@NonNull Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        AsyncSubscription<T>[] asyncSubscriptionArr = this.X.get();
        AsyncSubscription<T>[] asyncSubscriptionArr2 = Y2;
        if (asyncSubscriptionArr == asyncSubscriptionArr2) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Z = null;
        this.Y = th;
        for (AsyncSubscription onError : (AsyncSubscription[]) this.X.getAndSet(asyncSubscriptionArr2)) {
            onError.onError(th);
        }
    }

    public void onNext(@NonNull T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (this.X.get() != Y2) {
            this.Z = t;
        }
    }

    @CheckReturnValue
    @Nullable
    public T q9() {
        if (this.X.get() == Y2) {
            return this.Z;
        }
        return null;
    }

    @CheckReturnValue
    public boolean r9() {
        return this.X.get() == Y2 && this.Z != null;
    }

    /* access modifiers changed from: package-private */
    public void s9(AsyncSubscription<T> asyncSubscription) {
        AsyncSubscription<T>[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.X.get();
            int length = asyncSubscriptionArr.length;
            if (length != 0) {
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (asyncSubscriptionArr[i2] == asyncSubscription) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        asyncSubscriptionArr2 = X2;
                    } else {
                        AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[(length - 1)];
                        System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i2);
                        System.arraycopy(asyncSubscriptionArr, i2 + 1, asyncSubscriptionArr3, i2, (length - i2) - 1);
                        asyncSubscriptionArr2 = asyncSubscriptionArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X, asyncSubscriptionArr, asyncSubscriptionArr2));
    }
}
