package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

public final class FlowableAutoConnect<T> extends Flowable<T> {
    final ConnectableFlowable<? extends T> X;
    final AtomicInteger X2 = new AtomicInteger();
    final int Y;
    final Consumer<? super Disposable> Z;

    public FlowableAutoConnect(ConnectableFlowable<? extends T> connectableFlowable, int i2, Consumer<? super Disposable> consumer) {
        this.X = connectableFlowable;
        this.Y = i2;
        this.Z = consumer;
    }

    public void K6(Subscriber<? super T> subscriber) {
        this.X.e(subscriber);
        if (this.X2.incrementAndGet() == this.Y) {
            this.X.n9(this.Z);
        }
    }
}
