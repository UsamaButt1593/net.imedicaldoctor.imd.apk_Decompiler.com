package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
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
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.jdk8.CompletionStageConsumer;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsFlowable;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsObservable;
import io.reactivex.rxjava3.internal.jdk8.MaybeFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.MaybeMapOptional;
import io.reactivex.rxjava3.internal.observers.BlockingDisposableMultiObserver;
import io.reactivex.rxjava3.internal.observers.BlockingMultiObserver;
import io.reactivex.rxjava3.internal.observers.FutureMultiObserver;
import io.reactivex.rxjava3.internal.observers.SafeMaybeObserver;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtMaybePublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapMaybePublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeAmb;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCache;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeContains;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCount;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeCreate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDefer;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelay;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDematerialize;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDetach;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoAfterSuccess;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoOnEvent;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoOnLifecycle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDoOnTerminate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeEmpty;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeError;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeErrorCallable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFilter;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapIterableObservable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFlatten;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromAction;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromFuture;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromRunnable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromSupplier;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeHide;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeJust;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeLift;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMap;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMaterialize;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeNever;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybePeek;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimeInterval;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeTimer;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToObservable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToSingle;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeUnsafeCreate;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeUsing;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipArray;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybePublisher;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapMaybePublisher;
import io.reactivex.rxjava3.internal.operators.mixed.MaybeFlatMapObservable;
import io.reactivex.rxjava3.internal.operators.mixed.MaybeFlatMapPublisher;
import io.reactivex.rxjava3.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.reactivestreams.Publisher;

public abstract class Maybe<T> implements MaybeSource<T> {
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> A(@NonNull MaybeSource<? extends T>... maybeSourceArr) {
        return Flowable.b3(maybeSourceArr).e1(MaybeToPublisher.b());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> B(@NonNull MaybeSource<? extends T>... maybeSourceArr) {
        return Flowable.b3(maybeSourceArr).g1(MaybeToPublisher.b(), true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> C(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.h3(iterable).m1(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> D(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.l3(publisher).m1(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> E(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher, int i2) {
        return Flowable.l3(publisher).o1(Functions.k(), true, i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> F(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.h3(iterable).g1(MaybeToPublisher.b(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> F0(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.Q(new MaybeFromAction(action));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> G(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable, int i2) {
        return Flowable.h3(iterable).h1(MaybeToPublisher.b(), false, i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> G0(@NonNull Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.Q(new MaybeFromCallable(callable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> G2(@NonNull MaybeSource<T> maybeSource) {
        if (!(maybeSource instanceof Maybe)) {
            Objects.requireNonNull(maybeSource, "onSubscribe is null");
            return RxJavaPlugins.Q(new MaybeUnsafeCreate(maybeSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> H(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.l3(publisher).e1(MaybeToPublisher.b());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> H0(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "completableSource is null");
        return RxJavaPlugins.Q(new MaybeFromCompletable(completableSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> I(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher, int i2) {
        return Flowable.l3(publisher).f1(MaybeToPublisher.b(), i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> I0(@NonNull CompletionStage<T> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return RxJavaPlugins.Q(new MaybeFromCompletionStage(completionStage));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Maybe<T> I2(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends MaybeSource<? extends T>> function, @NonNull Consumer<? super D> consumer) {
        return J2(supplier, function, consumer, true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> J(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.h3(iterable).g1(MaybeToPublisher.b(), true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> J0(@NonNull Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return RxJavaPlugins.Q(new MaybeFromFuture(future, 0, (TimeUnit) null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Maybe<T> J2(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends MaybeSource<? extends T>> function, @NonNull Consumer<? super D> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "resourceCleanup is null");
        return RxJavaPlugins.Q(new MaybeUsing(supplier, function, consumer, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> K(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable, int i2) {
        return Flowable.h3(iterable).h1(MaybeToPublisher.b(), true, i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> K0(@NonNull Future<? extends T> future, long j2, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.Q(new MaybeFromFuture(future, j2, timeUnit));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> K2(@NonNull MaybeSource<T> maybeSource) {
        if (maybeSource instanceof Maybe) {
            return RxJavaPlugins.Q((Maybe) maybeSource);
        }
        Objects.requireNonNull(maybeSource, "source is null");
        return RxJavaPlugins.Q(new MaybeUnsafeCreate(maybeSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> L(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.l3(publisher).g1(MaybeToPublisher.b(), true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> L0(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "source is null");
        return RxJavaPlugins.Q(new ObservableElementAtMaybe(observableSource, 0));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> L1(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2) {
        return M1(maybeSource, maybeSource2, ObjectHelper.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Maybe<R> L2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull MaybeSource<? extends T3> maybeSource3, @NonNull MaybeSource<? extends T4> maybeSource4, @NonNull MaybeSource<? extends T5> maybeSource5, @NonNull MaybeSource<? extends T6> maybeSource6, @NonNull MaybeSource<? extends T7> maybeSource7, @NonNull MaybeSource<? extends T8> maybeSource8, @NonNull MaybeSource<? extends T9> maybeSource9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        Objects.requireNonNull(maybeSource5, "source5 is null");
        Objects.requireNonNull(maybeSource6, "source6 is null");
        Objects.requireNonNull(maybeSource7, "source7 is null");
        Objects.requireNonNull(maybeSource8, "source8 is null");
        Objects.requireNonNull(maybeSource9, "source9 is null");
        Objects.requireNonNull(function9, "zipper is null");
        return U2(Functions.E(function9), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> M(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher, int i2) {
        return Flowable.l3(publisher).h1(MaybeToPublisher.b(), true, i2, 1);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> M0(@NonNull Optional<T> optional) {
        Objects.requireNonNull(optional, "optional is null");
        return (Maybe) optional.map(new k()).orElseGet(new l());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> M1(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2, @NonNull BiPredicate<? super T, ? super T> biPredicate) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(biPredicate, "isEqual is null");
        return RxJavaPlugins.S(new MaybeEqualSingle(maybeSource, maybeSource2, biPredicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Maybe<R> M2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull MaybeSource<? extends T3> maybeSource3, @NonNull MaybeSource<? extends T4> maybeSource4, @NonNull MaybeSource<? extends T5> maybeSource5, @NonNull MaybeSource<? extends T6> maybeSource6, @NonNull MaybeSource<? extends T7> maybeSource7, @NonNull MaybeSource<? extends T8> maybeSource8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        Objects.requireNonNull(maybeSource5, "source5 is null");
        Objects.requireNonNull(maybeSource6, "source6 is null");
        Objects.requireNonNull(maybeSource7, "source7 is null");
        Objects.requireNonNull(maybeSource8, "source8 is null");
        Objects.requireNonNull(function8, "zipper is null");
        return U2(Functions.D(function8), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> N0(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "source is null");
        return RxJavaPlugins.Q(new FlowableElementAtMaybePublisher(publisher, 0));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Maybe<R> N2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull MaybeSource<? extends T3> maybeSource3, @NonNull MaybeSource<? extends T4> maybeSource4, @NonNull MaybeSource<? extends T5> maybeSource5, @NonNull MaybeSource<? extends T6> maybeSource6, @NonNull MaybeSource<? extends T7> maybeSource7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        Objects.requireNonNull(maybeSource5, "source5 is null");
        Objects.requireNonNull(maybeSource6, "source6 is null");
        Objects.requireNonNull(maybeSource7, "source7 is null");
        Objects.requireNonNull(function7, "zipper is null");
        return U2(Functions.C(function7), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> O0(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return RxJavaPlugins.Q(new MaybeFromRunnable(runnable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Maybe<R> O2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull MaybeSource<? extends T3> maybeSource3, @NonNull MaybeSource<? extends T4> maybeSource4, @NonNull MaybeSource<? extends T5> maybeSource5, @NonNull MaybeSource<? extends T6> maybeSource6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        Objects.requireNonNull(maybeSource5, "source5 is null");
        Objects.requireNonNull(maybeSource6, "source6 is null");
        Objects.requireNonNull(function6, "zipper is null");
        return U2(Functions.B(function6), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> P0(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "single is null");
        return RxJavaPlugins.Q(new MaybeFromSingle(singleSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Maybe<R> P2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull MaybeSource<? extends T3> maybeSource3, @NonNull MaybeSource<? extends T4> maybeSource4, @NonNull MaybeSource<? extends T5> maybeSource5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        Objects.requireNonNull(maybeSource5, "source5 is null");
        Objects.requireNonNull(function5, "zipper is null");
        return U2(Functions.A(function5), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> Q0(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.Q(new MaybeFromSupplier(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Maybe<R> Q2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull MaybeSource<? extends T3> maybeSource3, @NonNull MaybeSource<? extends T4> maybeSource4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        Objects.requireNonNull(function4, "zipper is null");
        return U2(Functions.z(function4), maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Maybe<R> R2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull MaybeSource<? extends T3> maybeSource3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(function3, "zipper is null");
        return U2(Functions.y(function3), maybeSource, maybeSource2, maybeSource3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Maybe<R> S2(@NonNull MaybeSource<? extends T1> maybeSource, @NonNull MaybeSource<? extends T2> maybeSource2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return U2(Functions.x(biFunction), maybeSource, maybeSource2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> T(@NonNull MaybeOnSubscribe<T> maybeOnSubscribe) {
        Objects.requireNonNull(maybeOnSubscribe, "onSubscribe is null");
        return RxJavaPlugins.Q(new MaybeCreate(maybeOnSubscribe));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Maybe<R> T2(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.Q(new MaybeZipIterable(iterable, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> U0(T t) {
        Objects.requireNonNull(t, "item is null");
        return RxJavaPlugins.Q(new MaybeJust(t));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T, R> Maybe<R> U2(@NonNull Function<? super Object[], ? extends R> function, @NonNull MaybeSource<? extends T>... maybeSourceArr) {
        Objects.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return q0();
        }
        Objects.requireNonNull(function, "zipper is null");
        return RxJavaPlugins.Q(new MaybeZipArray(maybeSourceArr, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> V(@NonNull Supplier<? extends MaybeSource<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.Q(new MaybeDefer(supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> Z0(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        return g1(maybeSource, maybeSource2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> a1(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2, @NonNull MaybeSource<? extends T> maybeSource3) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        return g1(maybeSource, maybeSource2, maybeSource3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> b1(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2, @NonNull MaybeSource<? extends T> maybeSource3, @NonNull MaybeSource<? extends T> maybeSource4) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        return g1(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> b2(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.P(new FlowableSwitchMapMaybePublisher(publisher, Functions.k(), false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> c1(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.h3(iterable).R2(Functions.k(), false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> c2(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.P(new FlowableSwitchMapMaybePublisher(publisher, Functions.k(), true));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> d1(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        return e1(publisher, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> e(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.Q(new MaybeAmb((MaybeSource<? extends T>[]) null, iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> e1(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher, int i2) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.P(new FlowableFlatMapMaybePublisher(publisher, Functions.k(), false, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> f1(@NonNull MaybeSource<? extends MaybeSource<? extends T>> maybeSource) {
        Objects.requireNonNull(maybeSource, "source is null");
        return RxJavaPlugins.Q(new MaybeFlatten(maybeSource, Functions.k()));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> g(@NonNull MaybeSource<? extends T>... maybeSourceArr) {
        Objects.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return q0();
        }
        return maybeSourceArr.length == 1 ? K2(maybeSourceArr[0]) : RxJavaPlugins.Q(new MaybeAmb(maybeSourceArr, (Iterable) null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> g1(MaybeSource<? extends T>... maybeSourceArr) {
        Objects.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return Flowable.p2();
        }
        return RxJavaPlugins.P(maybeSourceArr.length == 1 ? new MaybeToFlowable(maybeSourceArr[0]) : new MaybeMergeArray(maybeSourceArr));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> h1(@NonNull MaybeSource<? extends T>... maybeSourceArr) {
        Objects.requireNonNull(maybeSourceArr, "sources is null");
        return Flowable.b3(maybeSourceArr).R2(Functions.k(), true, Math.max(1, maybeSourceArr.length));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> i1(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        return h1(maybeSource, maybeSource2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> j1(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2, @NonNull MaybeSource<? extends T> maybeSource3) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        return h1(maybeSource, maybeSource2, maybeSource3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> k1(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2, @NonNull MaybeSource<? extends T> maybeSource3, @NonNull MaybeSource<? extends T> maybeSource4) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        return h1(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> l1(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.h3(iterable).R2(Functions.k(), true, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> m1(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        return n1(publisher, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> n1(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher, int i2) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.P(new FlowableFlatMapMaybePublisher(publisher, Functions.k(), true, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> p1() {
        return RxJavaPlugins.Q(MaybeNever.s);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> q0() {
        return RxJavaPlugins.Q(MaybeEmpty.s);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> r0(@NonNull Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.Q(new MaybeErrorCallable(supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> s(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        return y(maybeSource, maybeSource2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Maybe<T> s0(@NonNull Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return RxJavaPlugins.Q(new MaybeError(th));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> t(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2, @NonNull MaybeSource<? extends T> maybeSource3) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        return y(maybeSource, maybeSource2, maybeSource3);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Maybe<Long> t2(long j2, @NonNull TimeUnit timeUnit) {
        return u2(j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> u(@NonNull MaybeSource<? extends T> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2, @NonNull MaybeSource<? extends T> maybeSource3, @NonNull MaybeSource<? extends T> maybeSource4) {
        Objects.requireNonNull(maybeSource, "source1 is null");
        Objects.requireNonNull(maybeSource2, "source2 is null");
        Objects.requireNonNull(maybeSource3, "source3 is null");
        Objects.requireNonNull(maybeSource4, "source4 is null");
        return y(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Maybe<Long> u2(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.Q(new MaybeTimer(Math.max(0, j2), timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> v(@NonNull Iterable<? extends MaybeSource<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.P(new MaybeConcatIterable(iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> w(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher) {
        return x(publisher, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> x(@NonNull Publisher<? extends MaybeSource<? extends T>> publisher, int i2) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapMaybePublisher(publisher, Functions.k(), ErrorMode.IMMEDIATE, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> y(@NonNull MaybeSource<? extends T>... maybeSourceArr) {
        Objects.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return Flowable.p2();
        }
        return RxJavaPlugins.P(maybeSourceArr.length == 1 ? new MaybeToFlowable(maybeSourceArr[0]) : new MaybeConcatArray(maybeSourceArr));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> z(@NonNull MaybeSource<? extends T>... maybeSourceArr) {
        Objects.requireNonNull(maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return Flowable.p2();
        }
        return RxJavaPlugins.P(maybeSourceArr.length == 1 ? new MaybeToFlowable(maybeSourceArr[0]) : new MaybeConcatArrayDelayError(maybeSourceArr));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> A0(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.Q(new MaybeFlatMapSingle(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> A1(long j2) {
        return C2().o5(j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> A2() {
        return a.a(Y1(new CompletionStageConsumer(false, null)));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> B0(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new MaybeFlatMapIterableFlowable(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> B1(@NonNull BooleanSupplier booleanSupplier) {
        return C2().p5(booleanSupplier);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> B2(@Nullable T t) {
        return a.a(Y1(new CompletionStageConsumer(true, t)));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<U> C0(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new MaybeFlatMapIterableObservable(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> C1(@NonNull Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return C2().q5(function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> C2() {
        return this instanceof FuseToFlowable ? ((FuseToFlowable) this).f() : RxJavaPlugins.P(new MaybeToFlowable(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> D0(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new MaybeFlattenStreamAsFlowable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> D1() {
        return F1(Long.MAX_VALUE, Functions.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Future<T> D2() {
        return (Future) Y1(new FutureMultiObserver());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> E0(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new MaybeFlattenStreamAsObservable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> E1(long j2) {
        return F1(j2, Functions.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> E2() {
        return this instanceof FuseToObservable ? ((FuseToObservable) this).c() : RxJavaPlugins.R(new MaybeToObservable(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> F1(long j2, @NonNull Predicate<? super Throwable> predicate) {
        return C2().L5(j2, predicate).h6();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> F2() {
        return RxJavaPlugins.S(new MaybeToSingle(this, null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> G1(@NonNull BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return C2().M5(biPredicate).h6();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> H1(@NonNull Predicate<? super Throwable> predicate) {
        return F1(Long.MAX_VALUE, predicate);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> H2(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.Q(new MaybeUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> I1(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return F1(Long.MAX_VALUE, Functions.v(booleanSupplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> J1(@NonNull Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return C2().P5(function).h6();
    }

    @SchedulerSupport("none")
    public final void K1(@NonNull MaybeObserver<? super T> maybeObserver) {
        Objects.requireNonNull(maybeObserver, "observer is null");
        d(new SafeMaybeObserver(maybeObserver));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> N(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return u0(function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> N1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return Flowable.z0(Completable.B1(completableSource).q1(), C2());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable O(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return x0(function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> O1(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return Flowable.z0(K2(maybeSource).C2(), C2());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> P(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return A0(function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> P1(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return Flowable.z0(Single.y2(singleSource).p2(), C2());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Q(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return s(this, maybeSource);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Q1(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return C2().B6(publisher);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> R(@NonNull Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return RxJavaPlugins.S(new MaybeContains(this, obj));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> R0() {
        return RxJavaPlugins.Q(new MaybeHide(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> R1(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return Observable.l8(observableSource).s1(E2());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Long> S() {
        return RxJavaPlugins.S(new MaybeCount(this));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable S0() {
        return RxJavaPlugins.O(new MaybeIgnoreElementCompletable(this));
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable S1() {
        return V1(Functions.h(), Functions.f28377f, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> T0() {
        return RxJavaPlugins.S(new MaybeIsEmptySingle(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable T1(@NonNull Consumer<? super T> consumer) {
        return V1(consumer, Functions.f28377f, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> U(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        return RxJavaPlugins.S(new MaybeToSingle(this, t));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable U1(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        return V1(consumer, consumer2, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> V0(@NonNull MaybeOperator<? extends R, ? super T> maybeOperator) {
        Objects.requireNonNull(maybeOperator, "lift is null");
        return RxJavaPlugins.Q(new MaybeLift(this, maybeOperator));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable V1(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onSuccess is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        return (Disposable) Y1(new MaybeCallbackObserver(consumer, consumer2, action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Maybe<R> V2(@NonNull MaybeSource<? extends U> maybeSource, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(maybeSource, "other is null");
        return S2(this, maybeSource, biFunction);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> W(long j2, @NonNull TimeUnit timeUnit) {
        return Y(j2, timeUnit, Schedulers.a(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> W0(@NonNull Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.Q(new MaybeMap(this, function));
    }

    /* access modifiers changed from: protected */
    public abstract void W1(@NonNull MaybeObserver<? super T> maybeObserver);

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> X(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return Y(j2, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> X0(@NonNull Function<? super T, Optional<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.Q(new MaybeMapOptional(this, function));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> X1(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.Q(new MaybeSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> Y(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.Q(new MaybeDelay(this, Math.max(0, j2), timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Notification<T>> Y0() {
        return RxJavaPlugins.S(new MaybeMaterialize(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E extends MaybeObserver<? super T>> E Y1(E e2) {
        d(e2);
        return e2;
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> Z(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return Y(j2, timeUnit, Schedulers.a(), z);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> Z1(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.Q(new MaybeSwitchIfEmpty(this, maybeSource));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> a0(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "delayIndicator is null");
        return RxJavaPlugins.Q(new MaybeDelayOtherPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> a2(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.S(new MaybeSwitchIfEmptySingle(this, singleSource));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> b0(long j2, @NonNull TimeUnit timeUnit) {
        return c0(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> c0(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return d0(Flowable.V7(j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public final void d(@NonNull MaybeObserver<? super T> maybeObserver) {
        Objects.requireNonNull(maybeObserver, "observer is null");
        MaybeObserver<? super Object> e0 = RxJavaPlugins.e0(this, maybeObserver);
        Objects.requireNonNull(e0, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            W1(e0);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> d0(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "subscriptionIndicator is null");
        return RxJavaPlugins.Q(new MaybeDelaySubscriptionOtherPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> d2(@NonNull MaybeSource<U> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.Q(new MaybeTakeUntilMaybe(this, maybeSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> e0(@NonNull Function<? super T, Notification<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return RxJavaPlugins.Q(new MaybeDematerialize(this, function));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> e2(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.Q(new MaybeTakeUntilPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> f0(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterSuccess is null");
        return RxJavaPlugins.Q(new MaybeDoAfterSuccess(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<T> f2() {
        TestObserver<T> testObserver = new TestObserver<>();
        d(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> g0(@NonNull Action action) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Action action2 = Functions.f28374c;
        Objects.requireNonNull(action, "onAfterTerminate is null");
        return RxJavaPlugins.Q(new MaybePeek(this, h2, h3, h4, action2, action, action2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<T> g2(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.m();
        }
        d(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> h(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return g(this, maybeSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> h0(@NonNull Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.Q(new MaybeDoFinally(this, action));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> h2() {
        return k2(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @Nullable
    @SchedulerSupport("none")
    @CheckReturnValue
    public final T i() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        d(blockingMultiObserver);
        return blockingMultiObserver.e();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> i0(@NonNull Action action) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Objects.requireNonNull(action, "onComplete is null");
        Action action2 = Functions.f28374c;
        return RxJavaPlugins.Q(new MaybePeek(this, h2, h3, h4, action, action2, action2));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> i2(@NonNull Scheduler scheduler) {
        return k2(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T j(@NonNull T t) {
        Objects.requireNonNull(t, "defaultValue is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        d(blockingMultiObserver);
        return blockingMultiObserver.f(t);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> j0(@NonNull Action action) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Action action2 = Functions.f28374c;
        Objects.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.Q(new MaybePeek(this, h2, h3, h4, action2, action2, action));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> j2(@NonNull TimeUnit timeUnit) {
        return k2(timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    public final void k() {
        o(Functions.h(), Functions.f28376e, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> k0(@NonNull Consumer<? super Throwable> consumer) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Objects.requireNonNull(consumer, "onError is null");
        Action action = Functions.f28374c;
        return RxJavaPlugins.Q(new MaybePeek(this, h2, h3, consumer, action, action, action));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> k2(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.Q(new MaybeTimeInterval(this, timeUnit, scheduler, true));
    }

    @SchedulerSupport("none")
    public final void l(@NonNull MaybeObserver<? super T> maybeObserver) {
        Objects.requireNonNull(maybeObserver, "observer is null");
        BlockingDisposableMultiObserver blockingDisposableMultiObserver = new BlockingDisposableMultiObserver();
        maybeObserver.b(blockingDisposableMultiObserver);
        d(blockingDisposableMultiObserver);
        blockingDisposableMultiObserver.d(maybeObserver);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> l0(@NonNull BiConsumer<? super T, ? super Throwable> biConsumer) {
        Objects.requireNonNull(biConsumer, "onEvent is null");
        return RxJavaPlugins.Q(new MaybeDoOnEvent(this, biConsumer));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> l2(long j2, @NonNull TimeUnit timeUnit) {
        return n2(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    public final void m(@NonNull Consumer<? super T> consumer) {
        o(consumer, Functions.f28376e, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> m0(@NonNull Consumer<? super Disposable> consumer, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Objects.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.Q(new MaybeDoOnLifecycle(this, consumer, action));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> m2(long j2, @NonNull TimeUnit timeUnit, @NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "fallback is null");
        return o2(j2, timeUnit, Schedulers.a(), maybeSource);
    }

    @SchedulerSupport("none")
    public final void n(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        o(consumer, consumer2, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> n0(@NonNull Consumer<? super Disposable> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action = Functions.f28374c;
        return RxJavaPlugins.Q(new MaybePeek(this, consumer, h2, h3, action, action, action));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> n2(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return p2(u2(j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    public final void o(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onSuccess is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        d(blockingMultiObserver);
        blockingMultiObserver.d(consumer, consumer2, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> o0(@NonNull Consumer<? super T> consumer) {
        Consumer h2 = Functions.h();
        Objects.requireNonNull(consumer, "onSuccess is null");
        Consumer h3 = Functions.h();
        Action action = Functions.f28374c;
        return RxJavaPlugins.Q(new MaybePeek(this, h2, consumer, h3, action, action, action));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> o1(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return Z0(this, maybeSource);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> o2(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "fallback is null");
        return q2(u2(j2, timeUnit, scheduler), maybeSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> p() {
        return RxJavaPlugins.Q(new MaybeCache(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> p0(@NonNull Action action) {
        Objects.requireNonNull(action, "onTerminate is null");
        return RxJavaPlugins.Q(new MaybeDoOnTerminate(this, action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> p2(@NonNull MaybeSource<U> maybeSource) {
        Objects.requireNonNull(maybeSource, "timeoutIndicator is null");
        return RxJavaPlugins.Q(new MaybeTimeoutMaybe(this, maybeSource, (MaybeSource) null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<U> q(@NonNull Class<? extends U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return W0(Functions.e(cls));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> q1(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.Q(new MaybeObserveOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> q2(@NonNull MaybeSource<U> maybeSource, @NonNull MaybeSource<? extends T> maybeSource2) {
        Objects.requireNonNull(maybeSource, "timeoutIndicator is null");
        Objects.requireNonNull(maybeSource2, "fallback is null");
        return RxJavaPlugins.Q(new MaybeTimeoutMaybe(this, maybeSource, maybeSource2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> r(@NonNull MaybeTransformer<? super T, ? extends R> maybeTransformer) {
        Objects.requireNonNull(maybeTransformer, "transformer is null");
        return K2(maybeTransformer.a(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<U> r1(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return t0(Functions.l(cls)).q(cls);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> r2(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "timeoutIndicator is null");
        return RxJavaPlugins.Q(new MaybeTimeoutPublisher(this, publisher, (MaybeSource) null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> s1() {
        return t1(Functions.c());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Maybe<T> s2(@NonNull Publisher<U> publisher, @NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(publisher, "timeoutIndicator is null");
        Objects.requireNonNull(maybeSource, "fallback is null");
        return RxJavaPlugins.Q(new MaybeTimeoutPublisher(this, publisher, maybeSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> t0(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.Q(new MaybeFilter(this, predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> t1(@NonNull Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.Q(new MaybeOnErrorComplete(this, predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> u0(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.Q(new MaybeFlatten(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> u1(@NonNull Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return RxJavaPlugins.Q(new MaybeOnErrorNext(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Maybe<R> v0(@NonNull Function<? super T, ? extends MaybeSource<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.Q(new MaybeFlatMapBiSelector(this, function, biFunction));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> v1(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "fallback is null");
        return u1(Functions.n(maybeSource));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> v2() {
        return y2(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Maybe<R> w0(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, @NonNull Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, @NonNull Supplier<? extends MaybeSource<? extends R>> supplier) {
        Objects.requireNonNull(function, "onSuccessMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteSupplier is null");
        return RxJavaPlugins.Q(new MaybeFlatMapNotification(this, function, function2, supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> w1(@NonNull Function<? super Throwable, ? extends T> function) {
        Objects.requireNonNull(function, "itemSupplier is null");
        return RxJavaPlugins.Q(new MaybeOnErrorReturn(this, function));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> w2(@NonNull Scheduler scheduler) {
        return y2(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable x0(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.O(new MaybeFlatMapCompletable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> x1(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return w1(Functions.n(t));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> x2(@NonNull TimeUnit timeUnit) {
        return y2(timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> y0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new MaybeFlatMapObservable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> y1() {
        return RxJavaPlugins.Q(new MaybeDetach(this));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Maybe<Timed<T>> y2(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.Q(new MaybeTimeInterval(this, timeUnit, scheduler, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> z0(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new MaybeFlatMapPublisher(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> z1() {
        return A1(Long.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R z2(@NonNull MaybeConverter<T, ? extends R> maybeConverter) {
        Objects.requireNonNull(maybeConverter, "converter is null");
        return maybeConverter.a(this);
    }
}
