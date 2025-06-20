package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableScalarXMap {

    static final class ScalarXMapFlowable<T, R> extends Flowable<R> {
        final T X;
        final Function<? super T, ? extends Publisher<? extends R>> Y;

        ScalarXMapFlowable(T t, Function<? super T, ? extends Publisher<? extends R>> function) {
            this.X = t;
            this.Y = function;
        }

        public void K6(Subscriber<? super R> subscriber) {
            try {
                Object apply = this.Y.apply(this.X);
                Objects.requireNonNull(apply, "The mapper returned a null Publisher");
                Publisher publisher = (Publisher) apply;
                if (publisher instanceof Supplier) {
                    Object obj = ((Supplier) publisher).get();
                    if (obj == null) {
                        EmptySubscription.a(subscriber);
                    } else {
                        subscriber.h(new ScalarSubscription(subscriber, obj));
                    }
                } else {
                    publisher.e(subscriber);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
            }
        }
    }

    private FlowableScalarXMap() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flowable<U> a(T t, Function<? super T, ? extends Publisher<? extends U>> function) {
        return RxJavaPlugins.P(new ScalarXMapFlowable(t, function));
    }

    public static <T, R> boolean b(Publisher<T> publisher, Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function) {
        if (!(publisher instanceof Supplier)) {
            return false;
        }
        try {
            Object obj = ((Supplier) publisher).get();
            if (obj == null) {
                EmptySubscription.a(subscriber);
                return true;
            }
            Object apply = function.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            Publisher publisher2 = (Publisher) apply;
            if (publisher2 instanceof Supplier) {
                Object obj2 = ((Supplier) publisher2).get();
                if (obj2 == null) {
                    EmptySubscription.a(subscriber);
                    return true;
                }
                subscriber.h(new ScalarSubscription(subscriber, obj2));
            } else {
                publisher2.e(subscriber);
            }
            return true;
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
            return true;
        }
    }
}
