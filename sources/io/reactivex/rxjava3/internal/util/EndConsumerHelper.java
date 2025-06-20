package io.reactivex.rxjava3.internal.util;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.ProtocolViolationException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class EndConsumerHelper {
    private EndConsumerHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class<?> cls) {
        RxJavaPlugins.Y(new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean c(AtomicReference<Disposable> atomicReference, Disposable disposable, Class<?> cls) {
        Objects.requireNonNull(disposable, "next is null");
        if (g.a(atomicReference, (Object) null, disposable)) {
            return true;
        }
        disposable.m();
        if (atomicReference.get() == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean d(AtomicReference<Subscription> atomicReference, Subscription subscription, Class<?> cls) {
        Objects.requireNonNull(subscription, "next is null");
        if (g.a(atomicReference, (Object) null, subscription)) {
            return true;
        }
        subscription.cancel();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean e(Disposable disposable, Disposable disposable2, Class<?> cls) {
        Objects.requireNonNull(disposable2, "next is null");
        if (disposable == null) {
            return true;
        }
        disposable2.m();
        if (disposable == DisposableHelper.DISPOSED) {
            return false;
        }
        b(cls);
        return false;
    }

    public static boolean f(Subscription subscription, Subscription subscription2, Class<?> cls) {
        Objects.requireNonNull(subscription2, "next is null");
        if (subscription == null) {
            return true;
        }
        subscription2.cancel();
        if (subscription == SubscriptionHelper.CANCELLED) {
            return false;
        }
        b(cls);
        return false;
    }
}
