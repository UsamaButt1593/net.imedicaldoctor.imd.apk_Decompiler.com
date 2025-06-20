package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28433a;

    /* renamed from: b  reason: collision with root package name */
    final Function<? super T, ? extends Publisher<? extends R>> f28434b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28435c;

    /* renamed from: d  reason: collision with root package name */
    final int f28436d;

    /* renamed from: e  reason: collision with root package name */
    final int f28437e;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, int i3) {
        this.f28433a = parallelFlowable;
        this.f28434b = function;
        this.f28435c = z;
        this.f28436d = i2;
        this.f28437e = i3;
    }

    public int M() {
        return this.f28433a.M();
    }

    public void X(Subscriber<? super R>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                subscriberArr2[i2] = FlowableFlatMap.j9(subscriberArr[i2], this.f28434b, this.f28435c, this.f28436d, this.f28437e);
            }
            this.f28433a.X(subscriberArr2);
        }
    }
}
