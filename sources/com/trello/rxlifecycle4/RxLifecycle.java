package com.trello.rxlifecycle4;

import com.trello.rxlifecycle4.internal.Preconditions;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public class RxLifecycle {
    private RxLifecycle() {
        throw new AssertionError("No instances");
    }

    @CheckReturnValue
    @Nonnull
    public static <T, R> LifecycleTransformer<T> a(@Nonnull Observable<R> observable) {
        return new LifecycleTransformer<>(observable);
    }

    @CheckReturnValue
    @Nonnull
    public static <T, R> LifecycleTransformer<T> b(@Nonnull Observable<R> observable, @Nonnull Function<R, R> function) {
        Preconditions.a(observable, "lifecycle == null");
        Preconditions.a(function, "correspondingEvents == null");
        return a(d(observable.C5(), function));
    }

    @CheckReturnValue
    @Nonnull
    public static <T, R> LifecycleTransformer<T> c(@Nonnull Observable<R> observable, @Nonnull R r) {
        Preconditions.a(observable, "lifecycle == null");
        Preconditions.a(r, "event == null");
        return a(e(observable, r));
    }

    private static <R> Observable<Boolean> d(Observable<R> observable, Function<R, R> function) {
        return Observable.i0(observable.y6(1).Q3(function), observable.I5(1), new BiFunction<R, R, Boolean>() {
            /* renamed from: a */
            public Boolean apply(R r, R r2) throws Exception {
                return Boolean.valueOf(r2.equals(r));
            }
        }).A4(Functions.f28247a).l2(Functions.f28248b);
    }

    private static <R> Observable<R> e(Observable<R> observable, final R r) {
        return observable.l2(new Predicate<R>() {
            public boolean test(R r) throws Exception {
                return r.equals(r);
            }
        });
    }
}
