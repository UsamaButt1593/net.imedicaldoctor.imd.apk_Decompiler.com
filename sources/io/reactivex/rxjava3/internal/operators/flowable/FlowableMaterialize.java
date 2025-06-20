package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableMaterialize<T> extends AbstractFlowableWithUpstream<T, Notification<T>> {

    static final class MaterializeSubscriber<T> extends SinglePostCompleteSubscriber<T, Notification<T>> {
        private static final long a3 = -3740826063558713822L;

        MaterializeSubscriber(Subscriber<? super Notification<T>> subscriber) {
            super(subscriber);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void d(Notification<T> notification) {
            if (notification.g()) {
                RxJavaPlugins.Y(notification.d());
            }
        }

        public void onComplete() {
            c(Notification.a());
        }

        public void onError(Throwable th) {
            c(Notification.b(th));
        }

        public void onNext(T t) {
            this.Z++;
            this.s.onNext(Notification.c(t));
        }
    }

    public FlowableMaterialize(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super Notification<T>> subscriber) {
        this.X.J6(new MaterializeSubscriber(subscriber));
    }
}
