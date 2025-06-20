package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> Y;

    static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {
        final Function<? super T, ? extends Notification<R>> X;
        boolean Y;
        Subscription Z;
        final Subscriber<? super R> s;

        DematerializeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Notification<R>> function) {
            this.s = subscriber;
            this.X = function;
        }

        public void cancel() {
            this.Z.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y) {
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification = (Notification) apply;
                    if (notification.g()) {
                        this.Z.cancel();
                        onError(notification.d());
                    } else if (notification.f()) {
                        this.Z.cancel();
                        onComplete();
                    } else {
                        this.s.onNext(notification.e());
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.cancel();
                    onError(th);
                }
            } else if (t instanceof Notification) {
                Notification notification2 = (Notification) t;
                if (notification2.g()) {
                    RxJavaPlugins.Y(notification2.d());
                }
            }
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    public FlowableDematerialize(Flowable<T> flowable, Function<? super T, ? extends Notification<R>> function) {
        super(flowable);
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.J6(new DematerializeSubscriber(subscriber, this.Y));
    }
}
