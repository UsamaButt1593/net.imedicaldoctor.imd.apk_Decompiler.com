package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;

final class FlowableWindowSubscribeIntercept<T> extends Flowable<T> {
    final FlowableProcessor<T> X;
    final AtomicBoolean Y = new AtomicBoolean();

    FlowableWindowSubscribeIntercept(FlowableProcessor<T> flowableProcessor) {
        this.X = flowableProcessor;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.e(subscriber);
        this.Y.set(true);
    }

    /* access modifiers changed from: package-private */
    public boolean j9() {
        return !this.Y.get() && this.Y.compareAndSet(false, true);
    }
}
