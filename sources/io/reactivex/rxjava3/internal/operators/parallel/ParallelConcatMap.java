package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Objects;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28419a;

    /* renamed from: b  reason: collision with root package name */
    final Function<? super T, ? extends Publisher<? extends R>> f28420b;

    /* renamed from: c  reason: collision with root package name */
    final int f28421c;

    /* renamed from: d  reason: collision with root package name */
    final ErrorMode f28422d;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, ErrorMode errorMode) {
        this.f28419a = parallelFlowable;
        Objects.requireNonNull(function, "mapper");
        this.f28420b = function;
        this.f28421c = i2;
        Objects.requireNonNull(errorMode, "errorMode");
        this.f28422d = errorMode;
    }

    public int M() {
        return this.f28419a.M();
    }

    public void X(Subscriber<? super R>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                subscriberArr2[i2] = FlowableConcatMap.j9(subscriberArr[i2], this.f28420b, this.f28421c, this.f28422d);
            }
            this.f28419a.X(subscriberArr2);
        }
    }
}
