package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import java.io.Serializable;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum NotificationLite {
    COMPLETE;

    static final class DisposableNotification implements Serializable {
        private static final long X = -7482590109178395495L;
        final Disposable s;

        DisposableNotification(Disposable disposable) {
            this.s = disposable;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.s + "]";
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long X = -8759979445933046293L;
        final Throwable s;

        ErrorNotification(Throwable th) {
            this.s = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return Objects.equals(this.s, ((ErrorNotification) obj).s);
            }
            return false;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.s + "]";
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long X = -1322257508628817540L;
        final Subscription s;

        SubscriptionNotification(Subscription subscription) {
            this.s = subscription;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.s + "]";
        }
    }

    public static <T> boolean a(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).s);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean b(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).s);
            return true;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean c(Object obj, Observer<? super T> observer) {
        if (obj == COMPLETE) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).s);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.b(((DisposableNotification) obj).s);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static <T> boolean e(Object obj, Subscriber<? super T> subscriber) {
        if (obj == COMPLETE) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).s);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.h(((SubscriptionNotification) obj).s);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static Object f() {
        return COMPLETE;
    }

    public static Object g(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static Object h(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Disposable i(Object obj) {
        return ((DisposableNotification) obj).s;
    }

    public static Throwable j(Object obj) {
        return ((ErrorNotification) obj).s;
    }

    public static Subscription k(Object obj) {
        return ((SubscriptionNotification) obj).s;
    }

    public static <T> T l(Object obj) {
        return obj;
    }

    public static boolean m(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean n(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean o(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean p(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object q(T t) {
        return t;
    }

    public static Object r(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public String toString() {
        return "NotificationLite.Complete";
    }
}
