package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;

public final class ParallelFlatMapStream<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28390a;

    /* renamed from: b  reason: collision with root package name */
    final Function<? super T, ? extends Stream<? extends R>> f28391b;

    /* renamed from: c  reason: collision with root package name */
    final int f28392c;

    public ParallelFlatMapStream(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Stream<? extends R>> function, int i2) {
        this.f28390a = parallelFlowable;
        this.f28391b = function;
        this.f28392c = i2;
    }

    public int M() {
        return this.f28390a.M();
    }

    public void X(Subscriber<? super R>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                subscriberArr2[i2] = FlowableFlatMapStream.j9(subscriberArr[i2], this.f28391b, this.f28392c);
            }
            this.f28390a.X(subscriberArr2);
        }
    }
}
