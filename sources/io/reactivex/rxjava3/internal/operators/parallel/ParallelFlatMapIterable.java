package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMapIterable<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28438a;

    /* renamed from: b  reason: collision with root package name */
    final Function<? super T, ? extends Iterable<? extends R>> f28439b;

    /* renamed from: c  reason: collision with root package name */
    final int f28440c;

    public ParallelFlatMapIterable(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Iterable<? extends R>> function, int i2) {
        this.f28438a = parallelFlowable;
        this.f28439b = function;
        this.f28440c = i2;
    }

    public int M() {
        return this.f28438a.M();
    }

    public void X(Subscriber<? super R>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                subscriberArr2[i2] = FlowableFlattenIterable.j9(subscriberArr[i2], this.f28439b, this.f28440c);
            }
            this.f28438a.X(subscriberArr2);
        }
    }
}
