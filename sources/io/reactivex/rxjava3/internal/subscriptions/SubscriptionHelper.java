package io.reactivex.rxjava3.internal.subscriptions;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public enum SubscriptionHelper implements Subscription {
    CANCELLED;

    public static boolean a(AtomicReference<Subscription> atomicReference) {
        Subscription andSet;
        Subscription subscription = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (subscription == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.cancel();
        return true;
    }

    public static void b(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, long j2) {
        Subscription subscription = atomicReference.get();
        if (subscription != null) {
            subscription.request(j2);
        } else if (k(j2)) {
            BackpressureHelper.a(atomicLong, j2);
            Subscription subscription2 = atomicReference.get();
            if (subscription2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    subscription2.request(andSet);
                }
            }
        }
    }

    public static boolean c(AtomicReference<Subscription> atomicReference, AtomicLong atomicLong, Subscription subscription) {
        if (!i(atomicReference, subscription)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        subscription.request(andSet);
        return true;
    }

    public static boolean e(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!g.a(atomicReference, subscription2, subscription));
        return true;
    }

    public static void f(long j2) {
        RxJavaPlugins.Y(new ProtocolViolationException("More produced than requested: " + j2));
    }

    public static void g() {
        RxJavaPlugins.Y(new ProtocolViolationException("Subscription already set!"));
    }

    public static boolean h(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = atomicReference.get();
            if (subscription2 == CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!g.a(atomicReference, subscription2, subscription));
        if (subscription2 == null) {
            return true;
        }
        subscription2.cancel();
        return true;
    }

    public static boolean i(AtomicReference<Subscription> atomicReference, Subscription subscription) {
        Objects.requireNonNull(subscription, "s is null");
        if (g.a(atomicReference, (Object) null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        g();
        return false;
    }

    public static boolean j(AtomicReference<Subscription> atomicReference, Subscription subscription, long j2) {
        if (!i(atomicReference, subscription)) {
            return false;
        }
        subscription.request(j2);
        return true;
    }

    public static boolean k(long j2) {
        if (j2 > 0) {
            return true;
        }
        RxJavaPlugins.Y(new IllegalArgumentException("n > 0 required but it was " + j2));
        return false;
    }

    public static boolean l(Subscription subscription, Subscription subscription2) {
        if (subscription2 == null) {
            RxJavaPlugins.Y(new NullPointerException("next is null"));
            return false;
        } else if (subscription == null) {
            return true;
        } else {
            subscription2.cancel();
            g();
            return false;
        }
    }

    public void cancel() {
    }

    public void request(long j2) {
    }
}
