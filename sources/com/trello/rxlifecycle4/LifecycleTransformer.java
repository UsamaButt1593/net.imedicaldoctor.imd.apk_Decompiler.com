package com.trello.rxlifecycle4;

import com.dd.plist.ASCIIPropertyListParser;
import com.trello.rxlifecycle4.internal.Preconditions;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.CompletableTransformer;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.MaybeTransformer;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.ObservableTransformer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.core.SingleTransformer;
import javax.annotation.ParametersAreNonnullByDefault;
import org.reactivestreams.Publisher;

@ParametersAreNonnullByDefault
public final class LifecycleTransformer<T> implements ObservableTransformer<T, T>, FlowableTransformer<T, T>, SingleTransformer<T, T>, MaybeTransformer<T, T>, CompletableTransformer {

    /* renamed from: a  reason: collision with root package name */
    final Observable<?> f28250a;

    LifecycleTransformer(Observable<?> observable) {
        Preconditions.a(observable, "observable == null");
        this.f28250a = observable;
    }

    public MaybeSource<T> a(Maybe<T> maybe) {
        return maybe.d2(this.f28250a.n2());
    }

    public Publisher<T> b(Flowable<T> flowable) {
        return flowable.r7(this.f28250a.u7(BackpressureStrategy.LATEST));
    }

    public SingleSource<T> c(Single<T> single) {
        return single.U1(this.f28250a.o2());
    }

    public ObservableSource<T> d(Observable<T> observable) {
        return observable.K6(this.f28250a);
    }

    public CompletableSource e(Completable completable) {
        return Completable.g(completable, this.f28250a.D2(Functions.f28249c));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LifecycleTransformer.class != obj.getClass()) {
            return false;
        }
        return this.f28250a.equals(((LifecycleTransformer) obj).f28250a);
    }

    public int hashCode() {
        return this.f28250a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f28250a + ASCIIPropertyListParser.f18653k;
    }
}
