package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.parallel.ParallelFlowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class ParallelFromArray<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    final Publisher<T>[] f28441a;

    public ParallelFromArray(Publisher<T>[] publisherArr) {
        this.f28441a = publisherArr;
    }

    public int M() {
        return this.f28441a.length;
    }

    public void X(Subscriber<? super T>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f28441a[i2].e(subscriberArr[i2]);
            }
        }
    }
}
