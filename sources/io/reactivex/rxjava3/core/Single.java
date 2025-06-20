package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Function3;
import io.reactivex.rxjava3.functions.Function4;
import io.reactivex.rxjava3.functions.Function5;
import io.reactivex.rxjava3.functions.Function6;
import io.reactivex.rxjava3.functions.Function7;
import io.reactivex.rxjava3.functions.Function8;
import io.reactivex.rxjava3.functions.Function9;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.jdk8.CompletionStageConsumer;
import io.reactivex.rxjava3.internal.jdk8.SingleFlattenStreamAsFlowable;
import io.reactivex.rxjava3.internal.jdk8.SingleFlattenStreamAsObservable;
import io.reactivex.rxjava3.internal.jdk8.SingleFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.SingleMapOptional;
import io.reactivex.rxjava3.internal.observers.BiConsumerSingleObserver;
import io.reactivex.rxjava3.internal.observers.BlockingDisposableMultiObserver;
import io.reactivex.rxjava3.internal.observers.BlockingMultiObserver;
import io.reactivex.rxjava3.internal.observers.ConsumerSingleObserver;
import io.reactivex.rxjava3.internal.observers.FutureMultiObserver;
import io.reactivex.rxjava3.internal.observers.SafeSingleObserver;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromSingle;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToFlowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapSinglePublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToSingle;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapSinglePublisher;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSinglePublisher;
import io.reactivex.rxjava3.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.rxjava3.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.rxjava3.internal.operators.single.SingleAmb;
import io.reactivex.rxjava3.internal.operators.single.SingleCache;
import io.reactivex.rxjava3.internal.operators.single.SingleContains;
import io.reactivex.rxjava3.internal.operators.single.SingleCreate;
import io.reactivex.rxjava3.internal.operators.single.SingleDefer;
import io.reactivex.rxjava3.internal.operators.single.SingleDelay;
import io.reactivex.rxjava3.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.rxjava3.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.rxjava3.internal.operators.single.SingleDematerialize;
import io.reactivex.rxjava3.internal.operators.single.SingleDetach;
import io.reactivex.rxjava3.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.rxjava3.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.rxjava3.internal.operators.single.SingleDoFinally;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnDispose;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnError;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnEvent;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnLifecycle;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.rxjava3.internal.operators.single.SingleDoOnTerminate;
import io.reactivex.rxjava3.internal.operators.single.SingleEquals;
import io.reactivex.rxjava3.internal.operators.single.SingleError;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMap;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapBiSelector;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapNotification;
import io.reactivex.rxjava3.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleFromCallable;
import io.reactivex.rxjava3.internal.operators.single.SingleFromPublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleFromSupplier;
import io.reactivex.rxjava3.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.rxjava3.internal.operators.single.SingleHide;
import io.reactivex.rxjava3.internal.operators.single.SingleInternalHelper;
import io.reactivex.rxjava3.internal.operators.single.SingleJust;
import io.reactivex.rxjava3.internal.operators.single.SingleLift;
import io.reactivex.rxjava3.internal.operators.single.SingleMap;
import io.reactivex.rxjava3.internal.operators.single.SingleMaterialize;
import io.reactivex.rxjava3.internal.operators.single.SingleNever;
import io.reactivex.rxjava3.internal.operators.single.SingleObserveOn;
import io.reactivex.rxjava3.internal.operators.single.SingleOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.single.SingleResumeNext;
import io.reactivex.rxjava3.internal.operators.single.SingleSubscribeOn;
import io.reactivex.rxjava3.internal.operators.single.SingleTakeUntil;
import io.reactivex.rxjava3.internal.operators.single.SingleTimeInterval;
import io.reactivex.rxjava3.internal.operators.single.SingleTimeout;
import io.reactivex.rxjava3.internal.operators.single.SingleTimer;
import io.reactivex.rxjava3.internal.operators.single.SingleToFlowable;
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable;
import io.reactivex.rxjava3.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.rxjava3.internal.operators.single.SingleUsing;
import io.reactivex.rxjava3.internal.operators.single.SingleZipArray;
import io.reactivex.rxjava3.internal.operators.single.SingleZipIterable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.reactivestreams.Publisher;

public abstract class Single<T> implements SingleSource<T> {
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> A(@NonNull SingleSource<? extends T>... singleSourceArr) {
        return Flowable.b3(singleSourceArr).e1(SingleInternalHelper.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> A2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull SingleSource<? extends T3> singleSource3, @NonNull SingleSource<? extends T4> singleSource4, @NonNull SingleSource<? extends T5> singleSource5, @NonNull SingleSource<? extends T6> singleSource6, @NonNull SingleSource<? extends T7> singleSource7, @NonNull SingleSource<? extends T8> singleSource8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        Objects.requireNonNull(singleSource5, "source5 is null");
        Objects.requireNonNull(singleSource6, "source6 is null");
        Objects.requireNonNull(singleSource7, "source7 is null");
        Objects.requireNonNull(singleSource8, "source8 is null");
        Objects.requireNonNull(function8, "zipper is null");
        return I2(Functions.D(function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> B(@NonNull SingleSource<? extends T>... singleSourceArr) {
        return Flowable.b3(singleSourceArr).g1(SingleInternalHelper.c(), true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> B2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull SingleSource<? extends T3> singleSource3, @NonNull SingleSource<? extends T4> singleSource4, @NonNull SingleSource<? extends T5> singleSource5, @NonNull SingleSource<? extends T6> singleSource6, @NonNull SingleSource<? extends T7> singleSource7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        Objects.requireNonNull(singleSource5, "source5 is null");
        Objects.requireNonNull(singleSource6, "source6 is null");
        Objects.requireNonNull(singleSource7, "source7 is null");
        Objects.requireNonNull(function7, "zipper is null");
        return I2(Functions.C(function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> C(@NonNull Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.h3(iterable).r1(Functions.k());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Single<R> C2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull SingleSource<? extends T3> singleSource3, @NonNull SingleSource<? extends T4> singleSource4, @NonNull SingleSource<? extends T5> singleSource5, @NonNull SingleSource<? extends T6> singleSource6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        Objects.requireNonNull(singleSource5, "source5 is null");
        Objects.requireNonNull(singleSource6, "source6 is null");
        Objects.requireNonNull(function6, "zipper is null");
        return I2(Functions.B(function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> D(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        return Flowable.l3(publisher).r1(Functions.k());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Single<R> D2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull SingleSource<? extends T3> singleSource3, @NonNull SingleSource<? extends T4> singleSource4, @NonNull SingleSource<? extends T5> singleSource5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        Objects.requireNonNull(singleSource5, "source5 is null");
        Objects.requireNonNull(function5, "zipper is null");
        return I2(Functions.A(function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> E(@NonNull Publisher<? extends SingleSource<? extends T>> publisher, int i2) {
        return Flowable.l3(publisher).t1(Functions.k(), true, i2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> E0(@NonNull Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.S(new SingleFromCallable(callable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> E1(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        return RxJavaPlugins.S(new SingleEquals(singleSource, singleSource2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Single<R> E2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull SingleSource<? extends T3> singleSource3, @NonNull SingleSource<? extends T4> singleSource4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        Objects.requireNonNull(function4, "zipper is null");
        return I2(Functions.z(function4), singleSource, singleSource2, singleSource3, singleSource4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> F(@NonNull Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.h3(iterable).g1(SingleInternalHelper.c(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> F0(@NonNull CompletionStage<T> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return RxJavaPlugins.S(new SingleFromCompletionStage(completionStage));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Single<R> F2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull SingleSource<? extends T3> singleSource3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(function3, "zipper is null");
        return I2(Functions.y(function3), singleSource, singleSource2, singleSource3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> G(@NonNull Iterable<? extends SingleSource<? extends T>> iterable, int i2) {
        return Flowable.h3(iterable).h1(SingleInternalHelper.c(), false, i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> G0(@NonNull Future<? extends T> future) {
        return t2(Flowable.f3(future));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Single<R> G2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return I2(Functions.x(biFunction), singleSource, singleSource2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> H(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        return Flowable.l3(publisher).e1(SingleInternalHelper.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> H0(@NonNull Future<? extends T> future, long j2, @NonNull TimeUnit timeUnit) {
        return t2(Flowable.g3(future, j2, timeUnit));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Single<R> H2(@NonNull Iterable<? extends SingleSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.S(new SingleZipIterable(iterable, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> I(@NonNull Publisher<? extends SingleSource<? extends T>> publisher, int i2) {
        return Flowable.l3(publisher).f1(SingleInternalHelper.c(), i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> I0(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "maybe is null");
        return RxJavaPlugins.S(new MaybeToSingle(maybeSource, null));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T, R> Single<R> I2(@NonNull Function<? super Object[], ? extends R> function, @NonNull SingleSource<? extends T>... singleSourceArr) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(singleSourceArr, "sources is null");
        return singleSourceArr.length == 0 ? r0(new NoSuchElementException()) : RxJavaPlugins.S(new SingleZipArray(singleSourceArr, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> J(@NonNull Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.h3(iterable).g1(SingleInternalHelper.c(), true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> J0(@NonNull MaybeSource<T> maybeSource, @NonNull T t) {
        Objects.requireNonNull(maybeSource, "maybe is null");
        Objects.requireNonNull(t, "defaultItem is null");
        return RxJavaPlugins.S(new MaybeToSingle(maybeSource, t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> K(@NonNull Iterable<? extends SingleSource<? extends T>> iterable, int i2) {
        return Flowable.h3(iterable).h1(SingleInternalHelper.c(), true, i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> K0(@NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "observable is null");
        return RxJavaPlugins.S(new ObservableSingleSingle(observableSource, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> L(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        return Flowable.l3(publisher).g1(SingleInternalHelper.c(), true);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> L0(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.S(new SingleFromPublisher(publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> M(@NonNull Publisher<? extends SingleSource<? extends T>> publisher, int i2) {
        return Flowable.l3(publisher).h1(SingleInternalHelper.c(), true, i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> M0(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.S(new SingleFromSupplier(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> P0(T t) {
        Objects.requireNonNull(t, "item is null");
        return RxJavaPlugins.S(new SingleJust(t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> R1(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.P(new FlowableSwitchMapSinglePublisher(publisher, Functions.k(), false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> S1(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.P(new FlowableSwitchMapSinglePublisher(publisher, Functions.k(), true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> T(@NonNull SingleOnSubscribe<T> singleOnSubscribe) {
        Objects.requireNonNull(singleOnSubscribe, "source is null");
        return RxJavaPlugins.S(new SingleCreate(singleOnSubscribe));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> U(@NonNull Supplier<? extends SingleSource<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.S(new SingleDefer(supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> U0(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        return Flowable.b3(singleSource, singleSource2).T2(Functions.k(), false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> V0(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2, @NonNull SingleSource<? extends T> singleSource3) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        return Flowable.b3(singleSource, singleSource2, singleSource3).T2(Functions.k(), false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> W0(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2, @NonNull SingleSource<? extends T> singleSource3, @NonNull SingleSource<? extends T> singleSource4) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        return Flowable.b3(singleSource, singleSource2, singleSource3, singleSource4).T2(Functions.k(), false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> X0(@NonNull Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.h3(iterable).S2(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> Y0(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.P(new FlowableFlatMapSinglePublisher(publisher, Functions.k(), false, Integer.MAX_VALUE));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> Z0(@NonNull SingleSource<? extends SingleSource<? extends T>> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return RxJavaPlugins.S(new SingleFlatMap(singleSource, Functions.k()));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> a1(SingleSource<? extends T>... singleSourceArr) {
        return Flowable.b3(singleSourceArr).T2(Functions.k(), false, Math.max(1, singleSourceArr.length));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> b1(@NonNull SingleSource<? extends T>... singleSourceArr) {
        return Flowable.b3(singleSourceArr).T2(Functions.k(), true, Math.max(1, singleSourceArr.length));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> c1(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        return Flowable.b3(singleSource, singleSource2).T2(Functions.k(), true, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> d1(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2, @NonNull SingleSource<? extends T> singleSource3) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        return Flowable.b3(singleSource, singleSource2, singleSource3).T2(Functions.k(), true, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> e1(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2, @NonNull SingleSource<? extends T> singleSource3, @NonNull SingleSource<? extends T> singleSource4) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        return Flowable.b3(singleSource, singleSource2, singleSource3, singleSource4).T2(Functions.k(), true, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> f1(@NonNull Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.h3(iterable).T2(Functions.k(), true, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> g(@NonNull Iterable<? extends SingleSource<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.S(new SingleAmb((SingleSource<? extends T>[]) null, iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> g1(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.P(new FlowableFlatMapSinglePublisher(publisher, Functions.k(), true, Integer.MAX_VALUE));
    }

    private Single<T> g2(long j2, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleTimeout(this, j2, timeUnit, scheduler, singleSource));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> h(@NonNull SingleSource<? extends T>... singleSourceArr) {
        Objects.requireNonNull(singleSourceArr, "sources is null");
        if (singleSourceArr.length == 0) {
            return q0(SingleInternalHelper.a());
        }
        return singleSourceArr.length == 1 ? y2(singleSourceArr[0]) : RxJavaPlugins.S(new SingleAmb(singleSourceArr, (Iterable) null));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Single<Long> h2(long j2, @NonNull TimeUnit timeUnit) {
        return i2(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> i1() {
        return RxJavaPlugins.S(SingleNever.s);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Single<Long> i2(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleTimer(j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> q0(@NonNull Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.S(new SingleError(supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> r(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        return Flowable.b3(singleSource, singleSource2).s1(Functions.k(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> r0(@NonNull Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return q0(Functions.o(th));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> s(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2, @NonNull SingleSource<? extends T> singleSource3) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        return Flowable.b3(singleSource, singleSource2, singleSource3).s1(Functions.k(), false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> t(@NonNull SingleSource<? extends T> singleSource, @NonNull SingleSource<? extends T> singleSource2, @NonNull SingleSource<? extends T> singleSource3, @NonNull SingleSource<? extends T> singleSource4) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        return Flowable.b3(singleSource, singleSource2, singleSource3, singleSource4).s1(Functions.k(), false);
    }

    @NonNull
    private static <T> Single<T> t2(@NonNull Flowable<T> flowable) {
        return RxJavaPlugins.S(new FlowableSingleSingle(flowable, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> u(@NonNull Iterable<? extends SingleSource<? extends T>> iterable) {
        return Flowable.h3(iterable).s1(Functions.k(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> u2(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "onSubscribe is null");
        if (!(singleSource instanceof Single)) {
            return RxJavaPlugins.S(new SingleFromUnsafeSource(singleSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> v(@NonNull Publisher<? extends SingleSource<? extends T>> publisher) {
        return w(publisher, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> w(@NonNull Publisher<? extends SingleSource<? extends T>> publisher, int i2) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapSinglePublisher(publisher, Functions.k(), ErrorMode.IMMEDIATE, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, U> Single<T> w2(@NonNull Supplier<U> supplier, @NonNull Function<? super U, ? extends SingleSource<? extends T>> function, @NonNull Consumer<? super U> consumer) {
        return x2(supplier, function, consumer, true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> x(@NonNull ObservableSource<? extends SingleSource<? extends T>> observableSource) {
        Objects.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.R(new ObservableConcatMapSingle(observableSource, Functions.k(), ErrorMode.IMMEDIATE, 2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, U> Single<T> x2(@NonNull Supplier<U> supplier, @NonNull Function<? super U, ? extends SingleSource<? extends T>> function, @NonNull Consumer<? super U> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "resourceCleanup is null");
        return RxJavaPlugins.S(new SingleUsing(supplier, function, consumer, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> y(@NonNull SingleSource<? extends T>... singleSourceArr) {
        return Flowable.b3(singleSourceArr).s1(Functions.k(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<T> y2(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return singleSource instanceof Single ? RxJavaPlugins.S((Single) singleSource) : RxJavaPlugins.S(new SingleFromUnsafeSource(singleSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> z(@NonNull SingleSource<? extends T>... singleSourceArr) {
        return Flowable.b3(singleSourceArr).s1(Functions.k(), true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> z2(@NonNull SingleSource<? extends T1> singleSource, @NonNull SingleSource<? extends T2> singleSource2, @NonNull SingleSource<? extends T3> singleSource3, @NonNull SingleSource<? extends T4> singleSource4, @NonNull SingleSource<? extends T5> singleSource5, @NonNull SingleSource<? extends T6> singleSource6, @NonNull SingleSource<? extends T7> singleSource7, @NonNull SingleSource<? extends T8> singleSource8, @NonNull SingleSource<? extends T9> singleSource9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(singleSource, "source1 is null");
        Objects.requireNonNull(singleSource2, "source2 is null");
        Objects.requireNonNull(singleSource3, "source3 is null");
        Objects.requireNonNull(singleSource4, "source4 is null");
        Objects.requireNonNull(singleSource5, "source5 is null");
        Objects.requireNonNull(singleSource6, "source6 is null");
        Objects.requireNonNull(singleSource7, "source7 is null");
        Objects.requireNonNull(singleSource8, "source8 is null");
        Objects.requireNonNull(singleSource9, "source9 is null");
        Objects.requireNonNull(function9, "zipper is null");
        return I2(Functions.E(function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> A0(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new SingleFlatMapIterableFlowable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> A1(@NonNull Predicate<? super Throwable> predicate) {
        return t2(p2().N5(predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<U> B0(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new SingleFlatMapIterableObservable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> B1(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return y1(Long.MAX_VALUE, Functions.v(booleanSupplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> C0(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new SingleFlattenStreamAsFlowable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> C1(@NonNull Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return t2(p2().P5(function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> D0(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new SingleFlattenStreamAsObservable(this, function));
    }

    @SchedulerSupport("none")
    public final void D1(@NonNull SingleObserver<? super T> singleObserver) {
        Objects.requireNonNull(singleObserver, "observer is null");
        e(new SafeSingleObserver(singleObserver));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> F1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return Flowable.z0(Completable.B1(completableSource).q1(), p2());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> G1(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return Flowable.z0(Maybe.K2(maybeSource).C2(), p2());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> H1(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return Flowable.z0(y2(singleSource).p2(), p2());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> I1(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return p2().B6(publisher);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> J1(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return Observable.l8(observableSource).s1(s2());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Single<R> J2(@NonNull SingleSource<U> singleSource, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return G2(this, singleSource, biFunction);
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable K1() {
        return N1(Functions.h(), Functions.f28377f);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable L1(@NonNull BiConsumer<? super T, ? super Throwable> biConsumer) {
        Objects.requireNonNull(biConsumer, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumer);
        e(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable M1(@NonNull Consumer<? super T> consumer) {
        return N1(consumer, Functions.f28377f);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> N(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.S(new SingleFlatMap(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> N0() {
        return RxJavaPlugins.S(new SingleHide(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable N1(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(consumer, "onSuccess is null");
        Objects.requireNonNull(consumer2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        e(consumerSingleObserver);
        return consumerSingleObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable O(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return w0(function);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable O0() {
        return RxJavaPlugins.O(new CompletableFromSingle(this));
    }

    /* access modifiers changed from: protected */
    public abstract void O1(@NonNull SingleObserver<? super T> singleObserver);

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> P(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return x0(function);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> P1(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleSubscribeOn(this, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Q(@NonNull SingleSource<? extends T> singleSource) {
        return r(this, singleSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> Q0(@NonNull SingleOperator<? extends R, ? super T> singleOperator) {
        Objects.requireNonNull(singleOperator, "lift is null");
        return RxJavaPlugins.S(new SingleLift(this, singleOperator));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E extends SingleObserver<? super T>> E Q1(E e2) {
        e(e2);
        return e2;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> R(@NonNull Object obj) {
        return S(obj, ObjectHelper.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> R0(@NonNull Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.S(new SingleMap(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> S(@NonNull Object obj, @NonNull BiPredicate<Object, Object> biPredicate) {
        Objects.requireNonNull(obj, "item is null");
        Objects.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.S(new SingleContains(this, obj, biPredicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> S0(@NonNull Function<? super T, Optional<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.Q(new SingleMapOptional(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Notification<T>> T0() {
        return RxJavaPlugins.S(new SingleMaterialize(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> T1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return V1(new CompletableToFlowable(completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E> Single<T> U1(@NonNull SingleSource<? extends E> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return V1(new SingleToFlowable(singleSource));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<T> V(long j2, @NonNull TimeUnit timeUnit) {
        return X(j2, timeUnit, Schedulers.a(), false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E> Single<T> V1(@NonNull Publisher<E> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.S(new SingleTakeUntil(this, publisher));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> W(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return X(j2, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<T> W1() {
        TestObserver<T> testObserver = new TestObserver<>();
        e(testObserver);
        return testObserver;
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> X(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleDelay(this, j2, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<T> X1(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.m();
        }
        e(testObserver);
        return testObserver;
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<T> Y(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return X(j2, timeUnit, Schedulers.a(), z);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> Y1() {
        return b2(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<T> Z(long j2, @NonNull TimeUnit timeUnit) {
        return a0(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> Z1(@NonNull Scheduler scheduler) {
        return b2(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> a0(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return c0(Observable.o7(j2, timeUnit, scheduler));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> a2(@NonNull TimeUnit timeUnit) {
        return b2(timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> b0(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "subscriptionIndicator is null");
        return RxJavaPlugins.S(new SingleDelayWithCompletable(this, completableSource));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> b2(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleTimeInterval(this, timeUnit, scheduler, true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<T> c0(@NonNull ObservableSource<U> observableSource) {
        Objects.requireNonNull(observableSource, "subscriptionIndicator is null");
        return RxJavaPlugins.S(new SingleDelayWithObservable(this, observableSource));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<T> c2(long j2, @NonNull TimeUnit timeUnit) {
        return g2(j2, timeUnit, Schedulers.a(), (SingleSource) null);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<T> d0(@NonNull SingleSource<U> singleSource) {
        Objects.requireNonNull(singleSource, "subscriptionIndicator is null");
        return RxJavaPlugins.S(new SingleDelayWithSingle(this, singleSource));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> d2(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return g2(j2, timeUnit, scheduler, (SingleSource) null);
    }

    @SchedulerSupport("none")
    public final void e(@NonNull SingleObserver<? super T> singleObserver) {
        Objects.requireNonNull(singleObserver, "observer is null");
        SingleObserver<? super Object> g0 = RxJavaPlugins.g0(this, singleObserver);
        Objects.requireNonNull(g0, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            O1(g0);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<T> e0(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "subscriptionIndicator is null");
        return RxJavaPlugins.S(new SingleDelayWithPublisher(this, publisher));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> e2(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "fallback is null");
        return g2(j2, timeUnit, scheduler, singleSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> f0(@NonNull Function<? super T, Notification<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return RxJavaPlugins.Q(new SingleDematerialize(this, function));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<T> f2(long j2, @NonNull TimeUnit timeUnit, @NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "fallback is null");
        return g2(j2, timeUnit, Schedulers.a(), singleSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> g0(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterSuccess is null");
        return RxJavaPlugins.S(new SingleDoAfterSuccess(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> h0(@NonNull Action action) {
        Objects.requireNonNull(action, "onAfterTerminate is null");
        return RxJavaPlugins.S(new SingleDoAfterTerminate(this, action));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> h1(@NonNull SingleSource<? extends T> singleSource) {
        return U0(this, singleSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> i(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return h(this, singleSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> i0(@NonNull Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.S(new SingleDoFinally(this, action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T j() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        e(blockingMultiObserver);
        return blockingMultiObserver.e();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> j0(@NonNull Action action) {
        Objects.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.S(new SingleDoOnDispose(this, action));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> j1(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleObserveOn(this, scheduler));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> j2() {
        return m2(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @SchedulerSupport("none")
    public final void k() {
        n(Functions.h(), Functions.f28376e);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> k0(@NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError is null");
        return RxJavaPlugins.S(new SingleDoOnError(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<U> k1(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return s0(Functions.l(cls)).q(cls);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> k2(@NonNull Scheduler scheduler) {
        return m2(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    public final void l(@NonNull SingleObserver<? super T> singleObserver) {
        Objects.requireNonNull(singleObserver, "observer is null");
        BlockingDisposableMultiObserver blockingDisposableMultiObserver = new BlockingDisposableMultiObserver();
        singleObserver.b(blockingDisposableMultiObserver);
        e(blockingDisposableMultiObserver);
        blockingDisposableMultiObserver.e(singleObserver);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> l0(@NonNull BiConsumer<? super T, ? super Throwable> biConsumer) {
        Objects.requireNonNull(biConsumer, "onEvent is null");
        return RxJavaPlugins.S(new SingleDoOnEvent(this, biConsumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> l1() {
        return m1(Functions.c());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> l2(@NonNull TimeUnit timeUnit) {
        return m2(timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    public final void m(@NonNull Consumer<? super T> consumer) {
        n(consumer, Functions.f28376e);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> m0(@NonNull Consumer<? super Disposable> consumer, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Objects.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.S(new SingleDoOnLifecycle(this, consumer, action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> m1(@NonNull Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.Q(new SingleOnErrorComplete(this, predicate));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<Timed<T>> m2(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleTimeInterval(this, timeUnit, scheduler, false));
    }

    @SchedulerSupport("none")
    public final void n(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        Objects.requireNonNull(consumer, "onSuccess is null");
        Objects.requireNonNull(consumer2, "onError is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        e(blockingMultiObserver);
        blockingMultiObserver.d(consumer, consumer2, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> n0(@NonNull Consumer<? super Disposable> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        return RxJavaPlugins.S(new SingleDoOnSubscribe(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> n1(@NonNull Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return RxJavaPlugins.S(new SingleResumeNext(this, function));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R n2(@NonNull SingleConverter<T, ? extends R> singleConverter) {
        Objects.requireNonNull(singleConverter, "converter is null");
        return singleConverter.c(this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> o() {
        return RxJavaPlugins.S(new SingleCache(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> o0(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onSuccess is null");
        return RxJavaPlugins.S(new SingleDoOnSuccess(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> o1(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "fallback is null");
        return n1(Functions.n(singleSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> o2() {
        return a.a(Q1(new CompletionStageConsumer(false, null)));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<U> p(@NonNull Class<? extends U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return R0(Functions.e(cls));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> p0(@NonNull Action action) {
        Objects.requireNonNull(action, "onTerminate is null");
        return RxJavaPlugins.S(new SingleDoOnTerminate(this, action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> p1(@NonNull Function<Throwable, ? extends T> function) {
        Objects.requireNonNull(function, "itemSupplier is null");
        return RxJavaPlugins.S(new SingleOnErrorReturn(this, function, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> p2() {
        return this instanceof FuseToFlowable ? ((FuseToFlowable) this).f() : RxJavaPlugins.P(new SingleToFlowable(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> q(@NonNull SingleTransformer<? super T, ? extends R> singleTransformer) {
        Objects.requireNonNull(singleTransformer, "transformer is null");
        return y2(singleTransformer.c(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> q1(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return RxJavaPlugins.S(new SingleOnErrorReturn(this, (Function) null, t));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Future<T> q2() {
        return (Future) Q1(new FutureMultiObserver());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> r1() {
        return RxJavaPlugins.S(new SingleDetach(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> r2() {
        return this instanceof FuseToMaybe ? ((FuseToMaybe) this).d() : RxJavaPlugins.Q(new MaybeFromSingle(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> s0(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.Q(new MaybeFilterSingle(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> s1() {
        return p2().n5();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> s2() {
        return this instanceof FuseToObservable ? ((FuseToObservable) this).c() : RxJavaPlugins.R(new SingleToObservable(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> t0(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.S(new SingleFlatMap(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> t1(long j2) {
        return p2().o5(j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Single<R> u0(@NonNull Function<? super T, ? extends SingleSource<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.S(new SingleFlatMapBiSelector(this, function, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> u1(@NonNull BooleanSupplier booleanSupplier) {
        return p2().p5(booleanSupplier);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> v0(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, @NonNull Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
        Objects.requireNonNull(function, "onSuccessMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        return RxJavaPlugins.S(new SingleFlatMapNotification(this, function, function2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> v1(@NonNull Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return p2().q5(function);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Single<T> v2(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.S(new SingleUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable w0(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.O(new SingleFlatMapCompletable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> w1() {
        return t2(p2().J5());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> x0(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.Q(new SingleFlatMapMaybe(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> x1(long j2) {
        return t2(p2().K5(j2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> y0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new SingleFlatMapObservable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> y1(long j2, @NonNull Predicate<? super Throwable> predicate) {
        return t2(p2().L5(j2, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> z0(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new SingleFlatMapPublisher(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> z1(@NonNull BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return t2(p2().M5(biPredicate));
    }
}
