package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.Objects;
import org.reactivestreams.Subscriber;

public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Supplier<? extends R> X2;
    final Function<? super T, ? extends R> Y;
    final Function<? super Throwable, ? extends R> Z;

    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long d3 = 2757120512858778108L;
        final Function<? super T, ? extends R> a3;
        final Function<? super Throwable, ? extends R> b3;
        final Supplier<? extends R> c3;

        MapNotificationSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Supplier<? extends R> supplier) {
            super(subscriber);
            this.a3 = function;
            this.b3 = function2;
            this.c3 = supplier;
        }

        public void onComplete() {
            try {
                Object obj = this.c3.get();
                Objects.requireNonNull(obj, "The onComplete publisher returned is null");
                c(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.b3.apply(th);
                Objects.requireNonNull(apply, "The onError publisher returned is null");
                c(apply);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.a3.apply(t);
                Objects.requireNonNull(apply, "The onNext publisher returned is null");
                this.Z++;
                this.s.onNext(apply);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }
    }

    public FlowableMapNotification(Flowable<T> flowable, Function<? super T, ? extends R> function, Function<? super Throwable, ? extends R> function2, Supplier<? extends R> supplier) {
        super(flowable);
        this.Y = function;
        this.Z = function2;
        this.X2 = supplier;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.J6(new MapNotificationSubscriber(subscriber, this.Y, this.Z, this.X2));
    }
}
