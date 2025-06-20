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
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.jdk8.ObservableCollectWithCollectorSingle;
import io.reactivex.rxjava3.internal.jdk8.ObservableFirstStageObserver;
import io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream;
import io.reactivex.rxjava3.internal.jdk8.ObservableFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.ObservableFromStream;
import io.reactivex.rxjava3.internal.jdk8.ObservableLastStageObserver;
import io.reactivex.rxjava3.internal.jdk8.ObservableMapOptional;
import io.reactivex.rxjava3.internal.jdk8.ObservableSingleStageObserver;
import io.reactivex.rxjava3.internal.observers.BlockingFirstObserver;
import io.reactivex.rxjava3.internal.observers.BlockingLastObserver;
import io.reactivex.rxjava3.internal.observers.ForEachWhileObserver;
import io.reactivex.rxjava3.internal.observers.FutureObserver;
import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToObservable;
import io.reactivex.rxjava3.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.rxjava3.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.rxjava3.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.rxjava3.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.rxjava3.internal.operators.observable.BlockingObservableNext;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAllSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAmb;
import io.reactivex.rxjava3.internal.operators.observable.ObservableAnySingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableBuffer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.rxjava3.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.rxjava3.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCache;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatMapScheduler;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCountSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCreate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDebounce;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDefer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDelay;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDematerialize;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDetach;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDistinct;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDoFinally;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.rxjava3.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableEmpty;
import io.reactivex.rxjava3.internal.operators.observable.ObservableError;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFilter;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromAction;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromArray;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCallable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCompletable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromFuture;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromIterable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromRunnable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromSupplier;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGenerate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupBy;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.rxjava3.internal.operators.observable.ObservableHide;
import io.reactivex.rxjava3.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.rxjava3.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.rxjava3.internal.operators.observable.ObservableInterval;
import io.reactivex.rxjava3.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.rxjava3.internal.operators.observable.ObservableJoin;
import io.reactivex.rxjava3.internal.operators.observable.ObservableJust;
import io.reactivex.rxjava3.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableLastSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableLift;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMapNotification;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMaterialize;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableNever;
import io.reactivex.rxjava3.internal.operators.observable.ObservableObserveOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.rxjava3.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.observable.ObservablePublish;
import io.reactivex.rxjava3.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRange;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRangeLong;
import io.reactivex.rxjava3.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRepeat;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.rxjava3.internal.operators.observable.ObservableReplay;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScan;
import io.reactivex.rxjava3.internal.operators.observable.ObservableScanSeed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSerialized;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSkip;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSkipLast;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTake;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTakeLast;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.rxjava3.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTimeout;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableTimer;
import io.reactivex.rxjava3.internal.operators.observable.ObservableToListSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.rxjava3.internal.operators.observable.ObservableUsing;
import io.reactivex.rxjava3.internal.operators.observable.ObservableWindow;
import io.reactivex.rxjava3.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.rxjava3.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.rxjava3.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.rxjava3.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.rxjava3.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.rxjava3.internal.operators.observable.ObservableZip;
import io.reactivex.rxjava3.internal.operators.observable.ObservableZipIterable;
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.HashMapSupplier;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.observers.SafeObserver;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterators;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.reactivestreams.Publisher;

public abstract class Observable<T> implements ObservableSource<T> {

    /* renamed from: io.reactivex.rxjava3.core.Observable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28369a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.rxjava3.core.BackpressureStrategy[] r0 = io.reactivex.rxjava3.core.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28369a = r0
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28369a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28369a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28369a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.core.Observable.AnonymousClass1.<clinit>():void");
        }
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> A0(int i2, int i3, @NonNull ObservableSource<? extends T>... observableSourceArr) {
        return R2(observableSourceArr).d1(Functions.k(), false, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> A3(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return RxJavaPlugins.R(new ObservableJust(t));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> A5(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull BiPredicate<? super T, ? super T> biPredicate, int i2) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(biPredicate, "isEqual is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.S(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i2));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> B0(@NonNull ObservableSource<? extends T>... observableSourceArr) {
        return A0(U(), U(), observableSourceArr);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> B1(@NonNull Supplier<? extends ObservableSource<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.R(new ObservableDefer(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> B3(@NonNull T t, @NonNull T t2) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        return R2(t, t2);
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> C0(int i2, int i3, @NonNull ObservableSource<? extends T>... observableSourceArr) {
        return R2(observableSourceArr).d1(Functions.k(), true, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> C3(@NonNull T t, @NonNull T t2, @NonNull T t3) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        return R2(t, t2, t3);
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> D0(@NonNull ObservableSource<? extends T>... observableSourceArr) {
        return C0(U(), U(), observableSourceArr);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> D3(@NonNull T t, @NonNull T t2, @NonNull T t3, @NonNull T t4) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        return R2(t, t2, t3, t4);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> E0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return F0(observableSource, U(), true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> E3(@NonNull T t, @NonNull T t2, @NonNull T t3, @NonNull T t4, @NonNull T t5) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        return R2(t, t2, t3, t4, t5);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> F0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2, boolean z) {
        Objects.requireNonNull(observableSource, "sources is null");
        ObjectHelper.b(i2, "bufferSize is null");
        return RxJavaPlugins.R(new ObservableConcatMap(observableSource, Functions.k(), i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> F3(@NonNull T t, @NonNull T t2, @NonNull T t3, @NonNull T t4, @NonNull T t5, @NonNull T t6) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        return R2(t, t2, t3, t4, t5, t6);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Observable<Integer> F4(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        } else if (i3 == 0) {
            return i2();
        } else {
            if (i3 == 1) {
                return A3(Integer.valueOf(i2));
            }
            if (((long) i2) + ((long) (i3 - 1)) <= 2147483647L) {
                return RxJavaPlugins.R(new ObservableRange(i2, i3));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> G0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return E0(X2(iterable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> G3(@NonNull T t, @NonNull T t2, @NonNull T t3, @NonNull T t4, @NonNull T t5, @NonNull T t6, @NonNull T t7) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        Objects.requireNonNull(t7, "item7 is null");
        return R2(t, t2, t3, t4, t5, t6, t7);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> G4(long j2, long j3) {
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        } else if (i2 == 0) {
            return i2();
        } else {
            if (j3 == 1) {
                return A3(Long.valueOf(j2));
            }
            long j4 = (j3 - 1) + j2;
            if (j2 <= 0 || j4 >= 0) {
                return RxJavaPlugins.R(new ObservableRangeLong(j2, j3));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> H0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return I0(observableSource, U(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> H3(@NonNull T t, @NonNull T t2, @NonNull T t3, @NonNull T t4, @NonNull T t5, @NonNull T t6, @NonNull T t7, @NonNull T t8) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        Objects.requireNonNull(t7, "item7 is null");
        Objects.requireNonNull(t8, "item8 is null");
        return R2(t, t2, t3, t4, t5, t6, t7, t8);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> I0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2, int i3) {
        return l8(observableSource).b1(Functions.k(), i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> I3(@NonNull T t, @NonNull T t2, @NonNull T t3, @NonNull T t4, @NonNull T t5, @NonNull T t6, @NonNull T t7, @NonNull T t8, @NonNull T t9) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        Objects.requireNonNull(t7, "item7 is null");
        Objects.requireNonNull(t8, "item8 is null");
        Objects.requireNonNull(t9, "item9 is null");
        return R2(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> J0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable) {
        return K0(iterable, U(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> J3(@NonNull T t, @NonNull T t2, @NonNull T t3, @NonNull T t4, @NonNull T t5, @NonNull T t6, @NonNull T t7, @NonNull T t8, @NonNull T t9, @NonNull T t10) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        Objects.requireNonNull(t7, "item7 is null");
        Objects.requireNonNull(t8, "item8 is null");
        Objects.requireNonNull(t9, "item9 is null");
        Objects.requireNonNull(t10, "item10 is null");
        return R2(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> K0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        return X2(iterable).d1(Functions.k(), false, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> K7(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "onSubscribe is null");
        if (!(observableSource instanceof Observable)) {
            return RxJavaPlugins.R(new ObservableFromUnsafeSource(observableSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> L0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return M0(observableSource, U(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> M0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2, int i3) {
        return l8(observableSource).d1(Functions.k(), true, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Observable<T> M7(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends ObservableSource<? extends T>> function, @NonNull Consumer<? super D> consumer) {
        return N7(supplier, function, consumer, true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> N0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable) {
        return O0(iterable, U(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Observable<T> N7(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends ObservableSource<? extends T>> function, @NonNull Consumer<? super D> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "resourceCleanup is null");
        return RxJavaPlugins.R(new ObservableUsing(supplier, function, consumer, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> O0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        return X2(iterable).d1(Functions.k(), true, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> Q2(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.R(new ObservableFromAction(action));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> R2(@NonNull T... tArr) {
        Objects.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return i2();
        }
        return tArr.length == 1 ? A3(tArr[0]) : RxJavaPlugins.R(new ObservableFromArray(tArr));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> S2(@NonNull Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.R(new ObservableFromCallable(callable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> T2(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "completableSource is null");
        return RxJavaPlugins.R(new ObservableFromCompletable(completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> T3(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        Objects.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.R(new ObservableFlatMap(observableSource, Functions.k(), false, Integer.MAX_VALUE, U()));
    }

    @CheckReturnValue
    public static int U() {
        return Flowable.Y();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> U2(@NonNull CompletionStage<T> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return RxJavaPlugins.R(new ObservableFromCompletionStage(completionStage));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> U3(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        Objects.requireNonNull(observableSource, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.R(new ObservableFlatMap(observableSource, Functions.k(), false, i2, U()));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> V2(@NonNull Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return RxJavaPlugins.R(new ObservableFromFuture(future, 0, (TimeUnit) null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> V3(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        return R2(observableSource, observableSource2).B2(Functions.k(), false, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> W2(@NonNull Future<? extends T> future, long j2, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.R(new ObservableFromFuture(future, j2, timeUnit));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> W3(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull ObservableSource<? extends T> observableSource3) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        return R2(observableSource, observableSource2, observableSource3).B2(Functions.k(), false, 3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> X2(@NonNull Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.R(new ObservableFromIterable(iterable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> X3(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull ObservableSource<? extends T> observableSource3, @NonNull ObservableSource<? extends T> observableSource4) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        return R2(observableSource, observableSource2, observableSource3, observableSource4).B2(Functions.k(), false, 4);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> Y2(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "maybe is null");
        return RxJavaPlugins.R(new MaybeToObservable(maybeSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> Y3(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable) {
        return X2(iterable).r2(Functions.k());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    private Observable<T> Z1(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action, @NonNull Action action2) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(action2, "onAfterTerminate is null");
        return RxJavaPlugins.R(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> Z2(@NonNull Optional<T> optional) {
        Objects.requireNonNull(optional, "optional is null");
        return (Observable) optional.map(new m()).orElseGet(new n());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> Z3(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, int i2) {
        return X2(iterable).s2(Functions.k(), i2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> a3(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.R(new ObservableFromPublisher(publisher));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> a4(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        return X2(iterable).C2(Functions.k(), false, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> b0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull ObservableSource<? extends T7> observableSource7, @NonNull ObservableSource<? extends T8> observableSource8, @NonNull ObservableSource<? extends T9> observableSource9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(observableSource7, "source7 is null");
        Objects.requireNonNull(observableSource8, "source8 is null");
        Objects.requireNonNull(observableSource9, "source9 is null");
        Objects.requireNonNull(function9, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9}, Functions.E(function9), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> b3(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return RxJavaPlugins.R(new ObservableFromRunnable(runnable));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> b4(int i2, int i3, @NonNull ObservableSource<? extends T>... observableSourceArr) {
        return R2(observableSourceArr).C2(Functions.k(), false, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> c0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull ObservableSource<? extends T7> observableSource7, @NonNull ObservableSource<? extends T8> observableSource8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(observableSource7, "source7 is null");
        Objects.requireNonNull(observableSource8, "source8 is null");
        Objects.requireNonNull(function8, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8}, Functions.D(function8), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> c3(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return RxJavaPlugins.R(new SingleToObservable(singleSource));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> c4(@NonNull ObservableSource<? extends T>... observableSourceArr) {
        return R2(observableSourceArr).s2(Functions.k(), observableSourceArr.length);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> d(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.R(new ObservableAmb((ObservableSource<? extends T>[]) null, iterable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> d0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull ObservableSource<? extends T7> observableSource7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(observableSource7, "source7 is null");
        Objects.requireNonNull(function7, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7}, Functions.C(function7), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> d3(@NonNull Stream<T> stream) {
        Objects.requireNonNull(stream, "stream is null");
        return RxJavaPlugins.R(new ObservableFromStream(stream));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> d4(int i2, int i3, @NonNull ObservableSource<? extends T>... observableSourceArr) {
        return R2(observableSourceArr).C2(Functions.k(), true, i2, i3);
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> e(@NonNull ObservableSource<? extends T>... observableSourceArr) {
        Objects.requireNonNull(observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return i2();
        }
        return length == 1 ? l8(observableSourceArr[0]) : RxJavaPlugins.R(new ObservableAmb(observableSourceArr, (Iterable) null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> e0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(function6, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6}, Functions.B(function6), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> e3(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.R(new ObservableFromSupplier(supplier));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> e4(@NonNull ObservableSource<? extends T>... observableSourceArr) {
        return R2(observableSourceArr).B2(Functions.k(), true, observableSourceArr.length);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> f0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(function5, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4, observableSource5}, Functions.A(function5), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> f3(@NonNull Consumer<Emitter<T>> consumer) {
        Objects.requireNonNull(consumer, "generator is null");
        return j3(Functions.u(), ObservableInternalHelper.l(consumer), Functions.h());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> f4(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        Objects.requireNonNull(observableSource, "sources is null");
        return RxJavaPlugins.R(new ObservableFlatMap(observableSource, Functions.k(), true, Integer.MAX_VALUE, U()));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> g0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(function4, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.z(function4), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Observable<T> g3(@NonNull Supplier<S> supplier, @NonNull BiConsumer<S, Emitter<T>> biConsumer) {
        Objects.requireNonNull(biConsumer, "generator is null");
        return j3(supplier, ObservableInternalHelper.k(biConsumer), Functions.h());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> g4(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        Objects.requireNonNull(observableSource, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.R(new ObservableFlatMap(observableSource, Functions.k(), true, i2, U()));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> h0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(function3, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.y(function3), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Observable<T> h3(@NonNull Supplier<S> supplier, @NonNull BiConsumer<S, Emitter<T>> biConsumer, @NonNull Consumer<? super S> consumer) {
        Objects.requireNonNull(biConsumer, "generator is null");
        return j3(supplier, ObservableInternalHelper.k(biConsumer), consumer);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> h4(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        return R2(observableSource, observableSource2).B2(Functions.k(), true, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> i0(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return m0(new ObservableSource[]{observableSource, observableSource2}, Functions.x(biFunction), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> i2() {
        return RxJavaPlugins.R(ObservableEmpty.s);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Observable<T> i3(@NonNull Supplier<S> supplier, @NonNull BiFunction<S, Emitter<T>, S> biFunction) {
        return j3(supplier, biFunction, Functions.h());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> i4(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull ObservableSource<? extends T> observableSource3) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        return R2(observableSource, observableSource2, observableSource3).B2(Functions.k(), true, 3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> j0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        return k0(iterable, function, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> j2(@NonNull Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.R(new ObservableError(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Observable<T> j3(@NonNull Supplier<S> supplier, @NonNull BiFunction<S, Emitter<T>, S> biFunction, @NonNull Consumer<? super S> consumer) {
        Objects.requireNonNull(supplier, "initialState is null");
        Objects.requireNonNull(biFunction, "generator is null");
        Objects.requireNonNull(consumer, "disposeState is null");
        return RxJavaPlugins.R(new ObservableGenerate(supplier, biFunction, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> j4(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull ObservableSource<? extends T> observableSource3, @NonNull ObservableSource<? extends T> observableSource4) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        return R2(observableSource, observableSource2, observableSource3, observableSource4).B2(Functions.k(), true, 4);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> k0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableCombineLatest((ObservableSource<? extends T>[]) null, iterable, function, i2 << 1, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> k2(@NonNull Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return j2(Functions.o(th));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> k4(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable) {
        return X2(iterable).A2(Functions.k(), true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> l0(@NonNull ObservableSource<? extends T>[] observableSourceArr, @NonNull Function<? super Object[], ? extends R> function) {
        return m0(observableSourceArr, function, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> l4(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, int i2) {
        return X2(iterable).B2(Functions.k(), true, i2);
    }

    @NonNull
    private Observable<T> l7(long j2, @NonNull TimeUnit timeUnit, @Nullable ObservableSource<? extends T> observableSource, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableTimeoutTimed(this, j2, timeUnit, scheduler, observableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> l8(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "source is null");
        return observableSource instanceof Observable ? RxJavaPlugins.R((Observable) observableSource) : RxJavaPlugins.R(new ObservableFromUnsafeSource(observableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> m0(@NonNull ObservableSource<? extends T>[] observableSourceArr, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return i2();
        }
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i2 << 1, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> m4(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, int i2, int i3) {
        return X2(iterable).C2(Functions.k(), true, i2, i3);
    }

    @NonNull
    private <U, V> Observable<T> m7(@NonNull ObservableSource<U> observableSource, @NonNull Function<? super T, ? extends ObservableSource<V>> function, @Nullable ObservableSource<? extends T> observableSource2) {
        Objects.requireNonNull(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.R(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> m8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull ObservableSource<? extends T7> observableSource7, @NonNull ObservableSource<? extends T8> observableSource8, @NonNull ObservableSource<? extends T9> observableSource9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(observableSource7, "source7 is null");
        Objects.requireNonNull(observableSource8, "source8 is null");
        Objects.requireNonNull(observableSource9, "source9 is null");
        Objects.requireNonNull(function9, "zipper is null");
        return y8(Functions.E(function9), false, U(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> n0(@NonNull ObservableSource<? extends T>[] observableSourceArr, @NonNull Function<? super Object[], ? extends R> function) {
        return o0(observableSourceArr, function, U());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> n7(long j2, @NonNull TimeUnit timeUnit) {
        return o7(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> n8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull ObservableSource<? extends T7> observableSource7, @NonNull ObservableSource<? extends T8> observableSource8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(observableSource7, "source7 is null");
        Objects.requireNonNull(observableSource8, "source8 is null");
        Objects.requireNonNull(function8, "zipper is null");
        return y8(Functions.D(function8), false, U(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> o0(@NonNull ObservableSource<? extends T>[] observableSourceArr, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(observableSourceArr, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        if (observableSourceArr.length == 0) {
            return i2();
        }
        return RxJavaPlugins.R(new ObservableCombineLatest(observableSourceArr, (Iterable) null, function, i2 << 1, true));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> o7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableTimer(Math.max(j2, 0), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> o8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull ObservableSource<? extends T7> observableSource7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(observableSource7, "source7 is null");
        Objects.requireNonNull(function7, "zipper is null");
        return y8(Functions.C(function7), false, U(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> p0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        return q0(iterable, function, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> p8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull ObservableSource<? extends T6> observableSource6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(observableSource6, "source6 is null");
        Objects.requireNonNull(function6, "zipper is null");
        return y8(Functions.B(function6), false, U(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> q0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableCombineLatest((ObservableSource<? extends T>[]) null, iterable, function, i2 << 1, true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Observable<R> q8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull ObservableSource<? extends T5> observableSource5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(observableSource5, "source5 is null");
        Objects.requireNonNull(function5, "zipper is null");
        return y8(Functions.A(function5), false, U(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> r4() {
        return RxJavaPlugins.R(ObservableNever.s);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Observable<R> r8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull ObservableSource<? extends T4> observableSource4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(function4, "zipper is null");
        return y8(Functions.z(function4), false, U(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> s0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return t0(observableSource, U());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> s3(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return t3(j2, j3, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Observable<R> s8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull ObservableSource<? extends T3> observableSource3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(function3, "zipper is null");
        return y8(Functions.y(function3), false, U(), observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> t0(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        Objects.requireNonNull(observableSource, "sources is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableConcatMap(observableSource, Functions.k(), i2, ErrorMode.IMMEDIATE));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> t3(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableInterval(Math.max(0, j2), Math.max(0, j3), timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> t8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return y8(Functions.x(biFunction), false, U(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> u0(@NonNull ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        return y0(observableSource, observableSource2);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> u3(long j2, @NonNull TimeUnit timeUnit) {
        return t3(j2, j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> u6(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return v6(observableSource, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> u8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return y8(Functions.x(biFunction), z, U(), observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> v0(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull ObservableSource<? extends T> observableSource3) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        return y0(observableSource, observableSource2, observableSource3);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> v3(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return t3(j2, j2, timeUnit, scheduler);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> v6(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        Objects.requireNonNull(observableSource, "sources is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableSwitchMap(observableSource, Functions.k(), i2, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Observable<R> v8(@NonNull ObservableSource<? extends T1> observableSource, @NonNull ObservableSource<? extends T2> observableSource2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i2) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return y8(Functions.x(biFunction), z, i2, observableSource, observableSource2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> w0(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull ObservableSource<? extends T> observableSource3, @NonNull ObservableSource<? extends T> observableSource4) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        return y0(observableSource, observableSource2, observableSource3, observableSource4);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> w1(@NonNull ObservableOnSubscribe<T> observableOnSubscribe) {
        Objects.requireNonNull(observableOnSubscribe, "source is null");
        return RxJavaPlugins.R(new ObservableCreate(observableOnSubscribe));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> w3(long j2, long j3, long j4, long j5, @NonNull TimeUnit timeUnit) {
        return x3(j2, j3, j4, j5, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> w6(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return x6(observableSource, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> w8(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.R(new ObservableZip((ObservableSource<? extends T>[]) null, iterable, function, U(), false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> x0(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return X2(iterable).Y0(Functions.k(), false, U());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Observable<Long> x3(long j2, long j3, long j4, long j5, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        long j6 = j3;
        long j7 = j4;
        TimeUnit timeUnit2 = timeUnit;
        Scheduler scheduler2 = scheduler;
        int i2 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j6);
        } else if (i2 == 0) {
            return i2().D1(j7, timeUnit2, scheduler2);
        } else {
            long j8 = j2 + (j6 - 1);
            if (j2 <= 0 || j8 >= 0) {
                Objects.requireNonNull(timeUnit2, "unit is null");
                Objects.requireNonNull(scheduler2, "scheduler is null");
                return RxJavaPlugins.R(new ObservableIntervalRange(j2, j8, Math.max(0, j7), Math.max(0, j5), timeUnit, scheduler));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> x5(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2) {
        return A5(observableSource, observableSource2, ObjectHelper.a(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> x6(@NonNull ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i2) {
        Objects.requireNonNull(observableSource, "sources is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableSwitchMap(observableSource, Functions.k(), i2, true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> x8(@NonNull Iterable<? extends ObservableSource<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, boolean z, int i2) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableZip((ObservableSource<? extends T>[]) null, iterable, function, i2, z));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> y0(@NonNull ObservableSource<? extends T>... observableSourceArr) {
        Objects.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return i2();
        }
        return observableSourceArr.length == 1 ? l8(observableSourceArr[0]) : RxJavaPlugins.R(new ObservableConcatMap(R2(observableSourceArr), Functions.k(), U(), ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> y5(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, int i2) {
        return A5(observableSource, observableSource2, ObjectHelper.a(), i2);
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T, R> Observable<R> y8(@NonNull Function<? super Object[], ? extends R> function, boolean z, int i2, @NonNull ObservableSource<? extends T>... observableSourceArr) {
        Objects.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return i2();
        }
        Objects.requireNonNull(function, "zipper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableZip(observableSourceArr, (Iterable) null, function, i2, z));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static <T> Observable<T> z0(@NonNull ObservableSource<? extends T>... observableSourceArr) {
        Objects.requireNonNull(observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return i2();
        }
        return observableSourceArr.length == 1 ? l8(observableSourceArr[0]) : E0(R2(observableSourceArr));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> z5(@NonNull ObservableSource<? extends T> observableSource, @NonNull ObservableSource<? extends T> observableSource2, @NonNull BiPredicate<? super T, ? super T> biPredicate) {
        return A5(observableSource, observableSource2, biPredicate, U());
    }

    @SchedulerSupport("none")
    public final void A(@NonNull Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.c(this, consumer, Functions.f28377f, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> A1(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        return j6(A3(t));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> A2(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return B2(function, z, Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> A4(@NonNull Function<? super Throwable, ? extends T> function) {
        Objects.requireNonNull(function, "itemSupplier is null");
        return RxJavaPlugins.R(new ObservableOnErrorReturn(this, function));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> A6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return K6(o7(j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> A7(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        return Y(HashMapSupplier.a(), Functions.G(function, function2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> A8(@NonNull ObservableSource<? extends U> observableSource, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return u8(this, observableSource, biFunction, z);
    }

    @SchedulerSupport("none")
    public final void B(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.c(this, consumer, consumer2, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> B2(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2) {
        return C2(function, z, i2, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> B4(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return A4(Functions.n(t));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> B5() {
        return RxJavaPlugins.R(new ObservableSerialized(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> B6(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i2);
        } else if (i2 == 0) {
            return RxJavaPlugins.R(new ObservableIgnoreElements(this));
        } else {
            return i2 == 1 ? RxJavaPlugins.R(new ObservableTakeLastOne(this)) : RxJavaPlugins.R(new ObservableTakeLast(this, i2));
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> B7(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<? extends Map<K, V>> supplier) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        Objects.requireNonNull(supplier, "mapSupplier is null");
        return Y(supplier, Functions.G(function, function2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> B8(@NonNull ObservableSource<? extends U> observableSource, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        return v8(this, observableSource, biFunction, z, i2);
    }

    @SchedulerSupport("none")
    public final void C(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        ObservableBlockingSubscribe.c(this, consumer, consumer2, action);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> C1(long j2, @NonNull TimeUnit timeUnit) {
        return E1(j2, timeUnit, Schedulers.a(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> C2(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.R(new ObservableFlatMap(this, function, z, i2, i3));
        }
        Object obj = ((ScalarSupplier) this).get();
        return obj == null ? i2() : ObservableScalarXMap.a(obj, function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> C4() {
        return RxJavaPlugins.R(new ObservableDetach(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> C5() {
        return E4().I8();
    }

    @SchedulerSupport("io.reactivex:trampoline")
    @NonNull
    @CheckReturnValue
    public final Observable<T> C6(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return E6(j2, j3, timeUnit, Schedulers.j(), false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> C7(@NonNull Function<? super T, ? extends K> function) {
        return F7(function, Functions.k(), HashMapSupplier.a(), ArrayListSupplier.b());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> C8(@NonNull Iterable<U> iterable, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(iterable, "other is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return RxJavaPlugins.R(new ObservableZipIterable(this, iterable, biFunction));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> D(int i2) {
        return E(i2, i2);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> D1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return E1(j2, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable D2(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return E2(function, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> D4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return RxJavaPlugins.R(new ObservablePublishSelector(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> D5(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        return RxJavaPlugins.S(new ObservableSingleSingle(this, t));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> D6(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return E6(j2, j3, timeUnit, scheduler, false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> D7(@NonNull Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return F7(function, function2, HashMapSupplier.a(), ArrayListSupplier.b());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> E(int i2, int i3) {
        return F(i2, i3, ArrayListSupplier.c());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> E1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableDelay(this, j2, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable E2(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.O(new ObservableFlatMapCompletableCompletable(this, function, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> E4() {
        return RxJavaPlugins.U(new ObservablePublish(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> E5() {
        return RxJavaPlugins.Q(new ObservableSingleMaybe(this));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> E6(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z, int i2) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        if (j2 >= 0) {
            return RxJavaPlugins.R(new ObservableTakeLastTimed(this, j2, j3, timeUnit, scheduler, i2, z));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> E7(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<Map<K, Collection<V>>> supplier) {
        return F7(function, function2, supplier, ArrayListSupplier.b());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> F(int i2, int i3, @NonNull Supplier<U> supplier) {
        ObjectHelper.b(i2, "count");
        ObjectHelper.b(i3, "skip");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.R(new ObservableBuffer(this, i2, i3, supplier));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> F1(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return E1(j2, timeUnit, Schedulers.a(), z);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<U> F2(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableFlattenIterable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> F5() {
        return RxJavaPlugins.S(new ObservableSingleSingle(this, null));
    }

    @SchedulerSupport("io.reactivex:trampoline")
    @NonNull
    @CheckReturnValue
    public final Observable<T> F6(long j2, @NonNull TimeUnit timeUnit) {
        return I6(j2, timeUnit, Schedulers.j(), false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> F7(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<? extends Map<K, Collection<V>>> supplier, @NonNull Function<? super K, ? extends Collection<? super V>> function3) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        Objects.requireNonNull(supplier, "mapSupplier is null");
        Objects.requireNonNull(function3, "collectionFactory is null");
        return Y(supplier, Functions.H(function, function2, function3));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> G(int i2, @NonNull Supplier<U> supplier) {
        return F(i2, i2, supplier);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.rxjava3.functions.Function, io.reactivex.rxjava3.functions.Function<? super T, ? extends io.reactivex.rxjava3.core.ObservableSource<V>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.rxjava3.annotations.SchedulerSupport("none")
    @io.reactivex.rxjava3.annotations.NonNull
    @io.reactivex.rxjava3.annotations.CheckReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <U, V> io.reactivex.rxjava3.core.Observable<T> G1(@io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.core.ObservableSource<U> r1, @io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.functions.Function<? super T, ? extends io.reactivex.rxjava3.core.ObservableSource<V>> r2) {
        /*
            r0 = this;
            io.reactivex.rxjava3.core.Observable r1 = r0.K1(r1)
            io.reactivex.rxjava3.core.Observable r1 = r1.H1(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.core.Observable.G1(io.reactivex.rxjava3.core.ObservableSource, io.reactivex.rxjava3.functions.Function):io.reactivex.rxjava3.core.Observable");
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Observable<V> G2(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends V> biFunction) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return x2(ObservableInternalHelper.a(function), biFunction, false, U(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> G5() {
        return a.a(i6(new ObservableSingleStageObserver(false, null)));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> G6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return I6(j2, timeUnit, scheduler, false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> G7() {
        return I7(Functions.q());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> H(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return J(j2, j3, timeUnit, Schedulers.a(), ArrayListSupplier.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<T> H1(@NonNull Function<? super T, ? extends ObservableSource<U>> function) {
        Objects.requireNonNull(function, "itemDelayIndicator is null");
        return r2(ObservableInternalHelper.c(function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> H2(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return I2(function, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> H4(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.Q(new ObservableReduceMaybe(this, biFunction));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> H5(@Nullable T t) {
        return a.a(i6(new ObservableSingleStageObserver(true, t)));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> H6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        return I6(j2, timeUnit, scheduler, z, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> H7(int i2) {
        return J7(Functions.q(), i2);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> I(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return J(j2, j3, timeUnit, scheduler, ArrayListSupplier.c());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> I1(long j2, @NonNull TimeUnit timeUnit) {
        return J1(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> I2(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableFlatMapMaybe(this, function, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> I4(R r, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(r, "seed is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.S(new ObservableReduceSeedSingle(this, r, biFunction));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> I5(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? RxJavaPlugins.R(this) : RxJavaPlugins.R(new ObservableSkip(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 expected but it was " + j2);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> I6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z, int i2) {
        return E6(Long.MAX_VALUE, j2, timeUnit, scheduler, z, i2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> I7(@NonNull Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return w7().R0(Functions.p(comparator));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> J(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull Supplier<U> supplier) {
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        Supplier<U> supplier2 = supplier;
        Objects.requireNonNull(supplier2, "bufferSupplier is null");
        return RxJavaPlugins.R(new ObservableBufferTimed(this, j2, j3, timeUnit2, scheduler2, supplier2, Integer.MAX_VALUE, false));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> J1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return K1(o7(j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> J2(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return K2(function, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> J4(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "seedSupplier is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.S(new ObservableReduceWithSingle(this, supplier, biFunction));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> J5(long j2, @NonNull TimeUnit timeUnit) {
        return R5(n7(j2, timeUnit));
    }

    @SchedulerSupport("io.reactivex:trampoline")
    @NonNull
    @CheckReturnValue
    public final Observable<T> J6(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return I6(j2, timeUnit, Schedulers.j(), z, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> J7(@NonNull Comparator<? super T> comparator, int i2) {
        Objects.requireNonNull(comparator, "comparator is null");
        return x7(i2).R0(Functions.p(comparator));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> K(long j2, @NonNull TimeUnit timeUnit) {
        return N(j2, timeUnit, Schedulers.a(), Integer.MAX_VALUE);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<T> K1(@NonNull ObservableSource<U> observableSource) {
        Objects.requireNonNull(observableSource, "subscriptionIndicator is null");
        return RxJavaPlugins.R(new ObservableDelaySubscriptionOther(this, observableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> K2(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableFlatMapSingle(this, function, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> K3(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        return RxJavaPlugins.S(new ObservableLastSingle(this, t));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> K4() {
        return L4(Long.MAX_VALUE);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> K5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return R5(o7(j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<T> K6(@NonNull ObservableSource<U> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.R(new ObservableTakeUntil(this, observableSource));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> L(long j2, @NonNull TimeUnit timeUnit, int i2) {
        return N(j2, timeUnit, Schedulers.a(), i2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> L1(@NonNull Function<? super T, Notification<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return RxJavaPlugins.R(new ObservableDematerialize(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> L2(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableFlatMapStream(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> L3() {
        return RxJavaPlugins.Q(new ObservableLastMaybe(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> L4(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? i2() : RxJavaPlugins.R(new ObservableRepeat(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> L5(int i2) {
        if (i2 >= 0) {
            return i2 == 0 ? RxJavaPlugins.R(this) : RxJavaPlugins.R(new ObservableSkipLast(this, i2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + i2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> L6(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "stopPredicate is null");
        return RxJavaPlugins.R(new ObservableTakeUntilPredicate(this, predicate));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> L7(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableUnsubscribeOn(this, scheduler));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> M(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return O(j2, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.c(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> M1() {
        return O1(Functions.k(), Functions.g());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable M2(@NonNull Consumer<? super T> consumer) {
        return d6(consumer);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> M3() {
        return RxJavaPlugins.S(new ObservableLastSingle(this, null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> M4(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return RxJavaPlugins.R(new ObservableRepeatUntil(this, booleanSupplier));
    }

    @SchedulerSupport("io.reactivex:trampoline")
    @NonNull
    @CheckReturnValue
    public final Observable<T> M5(long j2, @NonNull TimeUnit timeUnit) {
        return P5(j2, timeUnit, Schedulers.j(), false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> M6(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.R(new ObservableTakeWhile(this, predicate));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<List<T>> N(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2) {
        return O(j2, timeUnit, scheduler, i2, ArrayListSupplier.c(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Observable<T> N1(@NonNull Function<? super T, K> function) {
        return O1(function, Functions.g());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable N2(@NonNull Predicate<? super T> predicate) {
        return P2(predicate, Functions.f28377f, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> N3() {
        return a.a(i6(new ObservableLastStageObserver(false, null)));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> N4(@NonNull Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return RxJavaPlugins.R(new ObservableRepeatWhen(this, function));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> N5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return P5(j2, timeUnit, scheduler, false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<T> N6() {
        TestObserver<T> testObserver = new TestObserver<>();
        a(testObserver);
        return testObserver;
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Observable<U> O(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2, @NonNull Supplier<U> supplier, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        Supplier<U> supplier2 = supplier;
        Objects.requireNonNull(supplier2, "bufferSupplier is null");
        int i3 = i2;
        ObjectHelper.b(i3, "count");
        return RxJavaPlugins.R(new ObservableBufferTimed(this, j2, j2, timeUnit, scheduler2, supplier2, i3, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Observable<T> O1(@NonNull Function<? super T, K> function, @NonNull Supplier<? extends Collection<? super K>> supplier) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(supplier, "collectionSupplier is null");
        return RxJavaPlugins.R(new ObservableDistinct(this, function, supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable O2(@NonNull Predicate<? super T> predicate, @NonNull Consumer<? super Throwable> consumer) {
        return P2(predicate, consumer, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> O3(@Nullable T t) {
        return a.a(i6(new ObservableLastStageObserver(true, t)));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> O4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return ObservableReplay.U8(ObservableInternalHelper.g(this), function);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> O5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        return P5(j2, timeUnit, scheduler, z, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<T> O6(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.m();
        }
        a(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> O7(long j2) {
        return Q7(j2, j2, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Observable<List<T>> P(@NonNull ObservableSource<B> observableSource) {
        return T(observableSource, ArrayListSupplier.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> P0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return Q0(function, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> P1() {
        return R1(Functions.k());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable P2(@NonNull Predicate<? super T> predicate, @NonNull Consumer<? super Throwable> consumer, @NonNull Action action) {
        Objects.requireNonNull(predicate, "onNext is null");
        Objects.requireNonNull(consumer, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        a(forEachWhileObserver);
        return forEachWhileObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> P3(@NonNull ObservableOperator<? extends R, ? super T> observableOperator) {
        Objects.requireNonNull(observableOperator, "lifter is null");
        return RxJavaPlugins.R(new ObservableLift(this, observableOperator));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> P4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.b(i2, "bufferSize");
        return ObservableReplay.U8(ObservableInternalHelper.i(this, i2, false), function);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> P5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z, int i2) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableSkipLastTimed(this, j2, timeUnit, scheduler, i2 << 1, z));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> P6(long j2, @NonNull TimeUnit timeUnit) {
        return Q6(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> P7(long j2, long j3) {
        return Q7(j2, j3, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Observable<List<T>> Q(@NonNull ObservableSource<B> observableSource, int i2) {
        ObjectHelper.b(i2, "initialCapacity");
        return T(observableSource, Functions.f(i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> Q0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.R(new ObservableConcatMap(this, function, i2, ErrorMode.IMMEDIATE));
        }
        Object obj = ((ScalarSupplier) this).get();
        return obj == null ? i2() : ObservableScalarXMap.a(obj, function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> Q1(@NonNull BiPredicate<? super T, ? super T> biPredicate) {
        Objects.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.R(new ObservableDistinctUntilChanged(this, Functions.k(), biPredicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> Q3(@NonNull Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableMap(this, function));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> Q4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2, long j2, @NonNull TimeUnit timeUnit) {
        return R4(function, i2, j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("io.reactivex:trampoline")
    @NonNull
    @CheckReturnValue
    public final Observable<T> Q5(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return P5(j2, timeUnit, Schedulers.j(), z, U());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> Q6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableThrottleFirstTimed(this, j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> Q7(long j2, long j3, int i2) {
        ObjectHelper.c(j2, "count");
        ObjectHelper.c(j3, "skip");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableWindow(this, j2, j3, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TOpening, TClosing> Observable<List<T>> R(@NonNull ObservableSource<? extends TOpening> observableSource, @NonNull Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return S(observableSource, function, ArrayListSupplier.c());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> R0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableConcatMapScheduler(this, function, i2, ErrorMode.IMMEDIATE, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Observable<T> R1(@NonNull Function<? super T, K> function) {
        Objects.requireNonNull(function, "keySelector is null");
        return RxJavaPlugins.R(new ObservableDistinctUntilChanged(this, function, ObjectHelper.a()));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> R3(@NonNull Function<? super T, Optional<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableMapOptional(this, function));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> R4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.U8(ObservableInternalHelper.h(this, i2, j2, timeUnit, scheduler, false), function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<T> R5(@NonNull ObservableSource<U> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.R(new ObservableSkipUntil(this, observableSource));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> R6(long j2, @NonNull TimeUnit timeUnit) {
        return o5(j2, timeUnit);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> R7(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return T7(j2, j3, timeUnit, Schedulers.a(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> S(@NonNull ObservableSource<? extends TOpening> observableSource, @NonNull Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, @NonNull Supplier<U> supplier) {
        Objects.requireNonNull(observableSource, "openingIndicator is null");
        Objects.requireNonNull(function, "closingIndicator is null");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.R(new ObservableBufferBoundary(this, observableSource, function, supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable S0(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return T0(function, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> S1(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterNext is null");
        return RxJavaPlugins.R(new ObservableDoAfterNext(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Notification<T>> S3() {
        return RxJavaPlugins.R(new ObservableMaterialize(this));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> S4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.U8(ObservableInternalHelper.h(this, i2, j2, timeUnit, scheduler, z), function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> S5(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.R(new ObservableSkipWhile(this, predicate));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> S6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return p5(j2, timeUnit, scheduler);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> S7(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return T7(j2, j3, timeUnit, scheduler, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Observable<U> T(@NonNull ObservableSource<B> observableSource, @NonNull Supplier<U> supplier) {
        Objects.requireNonNull(observableSource, "boundaryIndicator is null");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.R(new ObservableBufferExactBoundary(this, observableSource, supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable T0(@NonNull Function<? super T, ? extends CompletableSource> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "capacityHint");
        return RxJavaPlugins.O(new ObservableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> T1(@NonNull Action action) {
        Objects.requireNonNull(action, "onAfterTerminate is null");
        return Z1(Functions.h(), Functions.h(), Functions.f28374c, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> T4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i2, boolean z) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.b(i2, "bufferSize");
        return ObservableReplay.U8(ObservableInternalHelper.i(this, i2, z), function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> T5() {
        return w7().s2().Q3(Functions.p(Functions.q())).F2(Functions.k());
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> T6(long j2, @NonNull TimeUnit timeUnit) {
        return V6(j2, timeUnit, Schedulers.a(), false);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> T7(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2) {
        ObjectHelper.c(j2, "timespan");
        long j4 = j3;
        ObjectHelper.c(j4, "timeskip");
        int i3 = i2;
        ObjectHelper.b(i3, "bufferSize");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        return RxJavaPlugins.R(new ObservableWindowTimed(this, j2, j4, timeUnit2, scheduler2, Long.MAX_VALUE, i3, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable U0(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return W0(function, true, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> U1(@NonNull Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.R(new ObservableDoFinally(this, action));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> U4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j2, @NonNull TimeUnit timeUnit) {
        return V4(function, j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> U5(@NonNull Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return w7().s2().Q3(Functions.p(comparator)).F2(Functions.k());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> U6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return V6(j2, timeUnit, scheduler, false);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> U7(long j2, @NonNull TimeUnit timeUnit) {
        return Z7(j2, timeUnit, Schedulers.a(), Long.MAX_VALUE, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> V() {
        return W(16);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable V0(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z) {
        return W0(function, z, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> V1(@NonNull Action action) {
        return Z1(Functions.h(), Functions.h(), action, Functions.f28374c);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> V4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.U8(ObservableInternalHelper.j(this, j2, timeUnit, scheduler, false), function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> V5(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return u0(Completable.B1(completableSource).u1(), this);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> V6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableThrottleLatest(this, j2, timeUnit, scheduler, z));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> V7(long j2, @NonNull TimeUnit timeUnit, long j3) {
        return Z7(j2, timeUnit, Schedulers.a(), j3, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> W(int i2) {
        ObjectHelper.b(i2, "initialCapacity");
        return RxJavaPlugins.R(new ObservableCache(this, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable W0(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.O(new ObservableConcatMapCompletable(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> W1(@NonNull Action action) {
        return b2(Functions.h(), action);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> W4(@NonNull Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.U8(ObservableInternalHelper.j(this, j2, timeUnit, scheduler, z), function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> W5(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return u0(Maybe.K2(maybeSource).E2(), this);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> W6(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return V6(j2, timeUnit, Schedulers.a(), z);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> W7(long j2, @NonNull TimeUnit timeUnit, long j3, boolean z) {
        return Z7(j2, timeUnit, Schedulers.a(), j3, z);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<U> X(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return Q3(Functions.e(cls));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> X0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return Y0(function, true, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> X1(@NonNull Observer<? super T> observer) {
        Objects.requireNonNull(observer, "observer is null");
        return Z1(ObservableInternalHelper.f(observer), ObservableInternalHelper.e(observer), ObservableInternalHelper.d(observer), Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> X4() {
        return ObservableReplay.T8(this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> X5(@NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return y0(observableSource, this);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> X6(long j2, @NonNull TimeUnit timeUnit) {
        return x1(j2, timeUnit);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> X7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return Z7(j2, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<U> Y(@NonNull Supplier<? extends U> supplier, @NonNull BiConsumer<? super U, ? super T> biConsumer) {
        Objects.requireNonNull(supplier, "initialItemSupplier is null");
        Objects.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.S(new ObservableCollectSingle(this, supplier, biConsumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> Y0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        if (this instanceof ScalarSupplier) {
            Object obj = ((ScalarSupplier) this).get();
            return obj == null ? i2() : ObservableScalarXMap.a(obj, function);
        }
        return RxJavaPlugins.R(new ObservableConcatMap(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> Y1(@NonNull Consumer<? super Notification<T>> consumer) {
        Objects.requireNonNull(consumer, "onNotification is null");
        return Z1(Functions.t(consumer), Functions.s(consumer), Functions.r(consumer), Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> Y4(int i2) {
        ObjectHelper.b(i2, "bufferSize");
        return ObservableReplay.P8(this, i2, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> Y5(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return u0(Single.y2(singleSource).s2(), this);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> Y6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return y1(j2, timeUnit, scheduler);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> Y7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j3) {
        return Z7(j2, timeUnit, scheduler, j3, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R, A> Single<R> Z(@NonNull Collector<T, A, R> collector) {
        Objects.requireNonNull(collector, "collector is null");
        return RxJavaPlugins.S(new ObservableCollectWithCollectorSingle(this, collector));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> Z0(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableConcatMapScheduler(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY, scheduler));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> Z4(int i2, long j2, @NonNull TimeUnit timeUnit) {
        return a5(i2, j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public final Observable<T> Z5(@NonNull T... tArr) {
        Observable R2 = R2(tArr);
        if (R2 == i2()) {
            return RxJavaPlugins.R(this);
        }
        return y0(R2, this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> Z6() {
        return c7(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> Z7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j3, boolean z) {
        return a8(j2, timeUnit, scheduler, j3, z, U());
    }

    @SchedulerSupport("none")
    public final void a(@NonNull Observer<? super T> observer) {
        Objects.requireNonNull(observer, "observer is null");
        try {
            Observer<? super Object> f0 = RxJavaPlugins.f0(this, observer);
            Objects.requireNonNull(f0, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            g6(f0);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<U> a0(@NonNull U u, @NonNull BiConsumer<? super U, ? super T> biConsumer) {
        Objects.requireNonNull(u, "initialItem is null");
        return Y(Functions.o(u), biConsumer);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> a1(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return b1(function, Integer.MAX_VALUE, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> a2(@NonNull Consumer<? super Throwable> consumer) {
        Consumer h2 = Functions.h();
        Action action = Functions.f28374c;
        return Z1(h2, consumer, action, action);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> a5(int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.Q8(this, j2, timeUnit, scheduler, i2, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> a6(@NonNull T t) {
        return y0(A3(t), this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> a7(@NonNull Scheduler scheduler) {
        return c7(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<Observable<T>> a8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j3, boolean z, int i2) {
        int i3 = i2;
        ObjectHelper.b(i3, "bufferSize");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        long j4 = j3;
        ObjectHelper.c(j4, "count");
        return RxJavaPlugins.R(new ObservableWindowTimed(this, j2, j2, timeUnit2, scheduler2, j4, i3, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> b1(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "bufferSize");
        return RxJavaPlugins.R(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i2, i3));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> b2(@NonNull Consumer<? super Disposable> consumer, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Objects.requireNonNull(action, "onDispose is null");
        return RxJavaPlugins.R(new ObservableDoOnLifecycle(this, consumer, action));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> b5(int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.Q8(this, j2, timeUnit, scheduler, i2, z);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> b6(@NonNull Iterable<? extends T> iterable) {
        return y0(X2(iterable), this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> b7(@NonNull TimeUnit timeUnit) {
        return c7(timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Observable<Observable<T>> b8(@NonNull ObservableSource<B> observableSource) {
        return c8(observableSource, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> c(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.S(new ObservableAllSingle(this, predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> c1(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return d1(function, z, Integer.MAX_VALUE, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> c2(@NonNull Consumer<? super T> consumer) {
        Consumer h2 = Functions.h();
        Action action = Functions.f28374c;
        return Z1(consumer, h2, action, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> c5(int i2, boolean z) {
        ObjectHelper.b(i2, "bufferSize");
        return ObservableReplay.P8(this, i2, z);
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable c6() {
        return f6(Functions.h(), Functions.f28377f, Functions.f28374c);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> c7(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableTimeInterval(this, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Observable<Observable<T>> c8(@NonNull ObservableSource<B> observableSource, int i2) {
        Objects.requireNonNull(observableSource, "boundaryIndicator is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableWindowBoundary(this, observableSource, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> d1(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "bufferSize");
        return RxJavaPlugins.R(new ObservableConcatMapEager(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2, i3));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> d2(@NonNull Consumer<? super Disposable> consumer) {
        return b2(consumer, Functions.f28374c);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> d5(long j2, @NonNull TimeUnit timeUnit) {
        return e5(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable d6(@NonNull Consumer<? super T> consumer) {
        return f6(consumer, Functions.f28377f, Functions.f28374c);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> d7(long j2, @NonNull TimeUnit timeUnit) {
        return l7(j2, timeUnit, (ObservableSource) null, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> d8(@NonNull ObservableSource<U> observableSource, @NonNull Function<? super U, ? extends ObservableSource<V>> function) {
        return e8(observableSource, function, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<U> e1(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableFlattenIterable(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> e2(@NonNull Action action) {
        Objects.requireNonNull(action, "onTerminate is null");
        return Z1(Functions.h(), Functions.a(action), action, Functions.f28374c);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> e5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.R8(this, j2, timeUnit, scheduler, false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable e6(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        return f6(consumer, consumer2, Functions.f28374c);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> e7(long j2, @NonNull TimeUnit timeUnit, @NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "fallback is null");
        return l7(j2, timeUnit, observableSource, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Observable<Observable<T>> e8(@NonNull ObservableSource<U> observableSource, @NonNull Function<? super U, ? extends ObservableSource<V>> function, int i2) {
        Objects.requireNonNull(observableSource, "openingIndicator is null");
        Objects.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableWindowBoundarySelector(this, observableSource, function, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> f(@NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return e(this, observableSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> f1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return g1(function, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> f2(long j2) {
        if (j2 >= 0) {
            return RxJavaPlugins.Q(new ObservableElementAtMaybe(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableObservable<T> f5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return ObservableReplay.R8(this, j2, timeUnit, scheduler, z);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable f6(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        LambdaObserver lambdaObserver = new LambdaObserver(consumer, consumer2, action, Functions.h());
        a(lambdaObserver);
        return lambdaObserver;
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> f7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return l7(j2, timeUnit, (ObservableSource) null, scheduler);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Observable<R> f8(@NonNull ObservableSource<T1> observableSource, @NonNull ObservableSource<T2> observableSource2, @NonNull ObservableSource<T3> observableSource3, @NonNull ObservableSource<T4> observableSource4, @NonNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(observableSource4, "source4 is null");
        Objects.requireNonNull(function5, "combiner is null");
        return k8(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.A(function5));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> g1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> g2(long j2, @NonNull T t) {
        if (j2 >= 0) {
            Objects.requireNonNull(t, "defaultItem is null");
            return RxJavaPlugins.S(new ObservableElementAtSingle(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> g5() {
        return i5(Long.MAX_VALUE, Functions.c());
    }

    /* access modifiers changed from: protected */
    public abstract void g6(@NonNull Observer<? super T> observer);

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> g7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "fallback is null");
        return l7(j2, timeUnit, observableSource, scheduler);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, T3, R> Observable<R> g8(@NonNull ObservableSource<T1> observableSource, @NonNull ObservableSource<T2> observableSource2, @NonNull ObservableSource<T3> observableSource3, @NonNull Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(observableSource3, "source3 is null");
        Objects.requireNonNull(function4, "combiner is null");
        return k8(new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.z(function4));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> h(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.S(new ObservableAnySingle(this, predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> h1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return j1(function, true, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> h2(long j2) {
        if (j2 >= 0) {
            return RxJavaPlugins.S(new ObservableElementAtSingle(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> h5(long j2) {
        return i5(j2, Functions.c());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> h6(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Observable<T> h7(@NonNull ObservableSource<U> observableSource, @NonNull Function<? super T, ? extends ObservableSource<V>> function) {
        Objects.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        return m7(observableSource, function, (ObservableSource) null);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, R> Observable<R> h8(@NonNull ObservableSource<T1> observableSource, @NonNull ObservableSource<T2> observableSource2, @NonNull Function3<? super T, ? super T1, ? super T2, R> function3) {
        Objects.requireNonNull(observableSource, "source1 is null");
        Objects.requireNonNull(observableSource2, "source2 is null");
        Objects.requireNonNull(function3, "combiner is null");
        return k8(new ObservableSource[]{observableSource, observableSource2}, Functions.y(function3));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T i() {
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        a(blockingFirstObserver);
        T a2 = blockingFirstObserver.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> i1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        return j1(function, z, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> i5(long j2, @NonNull Predicate<? super Throwable> predicate) {
        if (j2 >= 0) {
            Objects.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.R(new ObservableRetryPredicate(this, j2, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E extends Observer<? super T>> E i6(E e2) {
        a(e2);
        return e2;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Observable<T> i7(@NonNull ObservableSource<U> observableSource, @NonNull Function<? super T, ? extends ObservableSource<V>> function, @NonNull ObservableSource<? extends T> observableSource2) {
        Objects.requireNonNull(observableSource, "firstTimeoutIndicator is null");
        Objects.requireNonNull(observableSource2, "fallback is null");
        return m7(observableSource, function, observableSource2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> i8(@NonNull ObservableSource<? extends U> observableSource, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(observableSource, "other is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.R(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T j(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        BlockingFirstObserver blockingFirstObserver = new BlockingFirstObserver();
        a(blockingFirstObserver);
        T a2 = blockingFirstObserver.a();
        return a2 != null ? a2 : t;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> j1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableConcatMapMaybe(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> j5(@NonNull BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        Objects.requireNonNull(biPredicate, "predicate is null");
        return RxJavaPlugins.R(new ObservableRetryBiPredicate(this, biPredicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> j6(@NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return RxJavaPlugins.R(new ObservableSwitchIfEmpty(this, observableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <V> Observable<T> j7(@NonNull Function<? super T, ? extends ObservableSource<V>> function) {
        return m7((ObservableSource) null, function, (ObservableSource) null);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> j8(@NonNull Iterable<? extends ObservableSource<?>> iterable, @NonNull Function<? super Object[], R> function) {
        Objects.requireNonNull(iterable, "others is null");
        Objects.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.R(new ObservableWithLatestFromMany(this, iterable, function));
    }

    @SchedulerSupport("none")
    @NonNull
    public final void k(@NonNull Consumer<? super T> consumer) {
        l(consumer, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> k1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return l1(function, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> k3(@NonNull Function<? super T, ? extends K> function) {
        return n3(function, Functions.k(), false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> k5(@NonNull Predicate<? super Throwable> predicate) {
        return i5(Long.MAX_VALUE, predicate);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> k6(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return l6(function, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <V> Observable<T> k7(@NonNull Function<? super T, ? extends ObservableSource<V>> function, @NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "fallback is null");
        return m7((ObservableSource) null, function, observableSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> k8(@NonNull ObservableSource<?>[] observableSourceArr, @NonNull Function<? super Object[], R> function) {
        Objects.requireNonNull(observableSourceArr, "others is null");
        Objects.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.R(new ObservableWithLatestFromMany(this, observableSourceArr, function));
    }

    @SchedulerSupport("none")
    @NonNull
    public final void l(@NonNull Consumer<? super T> consumer, int i2) {
        Objects.requireNonNull(consumer, "onNext is null");
        Iterator it2 = o(i2).iterator();
        while (it2.hasNext()) {
            try {
                consumer.accept(it2.next());
            } catch (Throwable th) {
                Exceptions.b(th);
                ((Disposable) it2).m();
                throw ExceptionHelper.i(th);
            }
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> l1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> l2(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.R(new ObservableFilter(this, predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> l3(@NonNull Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return n3(function, function2, false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> l5(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return i5(Long.MAX_VALUE, Functions.v(booleanSupplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> l6(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.R(new ObservableSwitchMap(this, function, i2, false));
        }
        Object obj = ((ScalarSupplier) this).get();
        return obj == null ? i2() : ObservableScalarXMap.a(obj, function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> m1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return o1(function, true, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> m2(@NonNull T t) {
        return g2(0, t);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> m3(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z) {
        return n3(function, function2, z, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> m5(@NonNull Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return RxJavaPlugins.R(new ObservableRetryWhen(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable m6(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.O(new ObservableSwitchMapCompletable(this, function, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> n() {
        return o(U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> n1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        return o1(function, z, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> n2() {
        return f2(0);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Observable<GroupedObservable<K, V>> n3(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z, int i2) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableGroupBy(this, function, function2, i2, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> n4(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.R(new ObservableMergeWithCompletable(this, completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    public final void n5(@NonNull Observer<? super T> observer) {
        Objects.requireNonNull(observer, "observer is null");
        if (observer instanceof SafeObserver) {
            a(observer);
        } else {
            a(new SafeObserver(observer));
        }
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable n6(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.O(new ObservableSwitchMapCompletable(this, function, true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> o(int i2) {
        ObjectHelper.b(i2, "capacityHint");
        return new BlockingObservableIterable(this, i2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> o1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableConcatMapSingle(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> o2() {
        return h2(0);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Observable<GroupedObservable<K, T>> o3(@NonNull Function<? super T, ? extends K> function, boolean z) {
        return n3(function, Functions.k(), z, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> o4(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.R(new ObservableMergeWithMaybe(this, maybeSource));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> o5(long j2, @NonNull TimeUnit timeUnit) {
        return p5(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> o6(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return p6(function, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T p() {
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        a(blockingLastObserver);
        T a2 = blockingLastObserver.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> p1(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        return L2(function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> p2() {
        return a.a(i6(new ObservableFirstStageObserver(false, null)));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> p3(@NonNull ObservableSource<? extends TRight> observableSource, @NonNull Function<? super T, ? extends ObservableSource<TLeftEnd>> function, @NonNull Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, @NonNull BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        Objects.requireNonNull(observableSource, "other is null");
        Objects.requireNonNull(function, "leftEnd is null");
        Objects.requireNonNull(function2, "rightEnd is null");
        Objects.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.R(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> p4(@NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return V3(this, observableSource);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> p5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableSampleTimed(this, j2, timeUnit, scheduler, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> p6(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.R(new ObservableSwitchMap(this, function, i2, true));
        }
        Object obj = ((ScalarSupplier) this).get();
        return obj == null ? i2() : ObservableScalarXMap.a(obj, function);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> p7() {
        return s7(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T q(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        BlockingLastObserver blockingLastObserver = new BlockingLastObserver();
        a(blockingLastObserver);
        T a2 = blockingLastObserver.a();
        return a2 != null ? a2 : t;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> q1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.R(new ObservableConcatWithCompletable(this, completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> q2(@Nullable T t) {
        return a.a(i6(new ObservableFirstStageObserver(true, t)));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> q3() {
        return RxJavaPlugins.R(new ObservableHide(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> q4(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.R(new ObservableMergeWithSingle(this, singleSource));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> q5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableSampleTimed(this, j2, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> q6(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableSwitchMapMaybe(this, function, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> q7(@NonNull Scheduler scheduler) {
        return s7(TimeUnit.MILLISECONDS, scheduler);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> r() {
        return new BlockingObservableLatest(this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> r0(@NonNull ObservableTransformer<? super T, ? extends R> observableTransformer) {
        Objects.requireNonNull(observableTransformer, "composer is null");
        return l8(observableTransformer.d(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> r1(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.R(new ObservableConcatWithMaybe(this, maybeSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> r2(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return A2(function, false);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable r3() {
        return RxJavaPlugins.O(new ObservableIgnoreElementsCompletable(this));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> r5(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return q5(j2, timeUnit, Schedulers.a(), z);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> r6(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableSwitchMapMaybe(this, function, true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> r7(@NonNull TimeUnit timeUnit) {
        return s7(timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> s(@NonNull T t) {
        Objects.requireNonNull(t, "initialItem is null");
        return new BlockingObservableMostRecent(this, t);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> s1(@NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return u0(this, observableSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> s2(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, int i2) {
        return C2(function, false, i2, U());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> s4(@NonNull Scheduler scheduler) {
        return u4(scheduler, false, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<T> s5(@NonNull ObservableSource<U> observableSource) {
        Objects.requireNonNull(observableSource, "sampler is null");
        return RxJavaPlugins.R(new ObservableSampleWithObservable(this, observableSource, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> s6(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableSwitchMapSingle(this, function, false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<Timed<T>> s7(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return Q3(Functions.w(timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> t() {
        return new BlockingObservableNext(this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> t1(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.R(new ObservableConcatWithSingle(this, singleSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> t2(@NonNull Function<? super T, ? extends ObservableSource<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return x2(function, biFunction, false, U(), U());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> t4(@NonNull Scheduler scheduler, boolean z) {
        return u4(scheduler, z, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<T> t5(@NonNull ObservableSource<U> observableSource, boolean z) {
        Objects.requireNonNull(observableSource, "sampler is null");
        return RxJavaPlugins.R(new ObservableSampleWithObservable(this, observableSource, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> t6(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.R(new ObservableSwitchMapSingle(this, function, true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> R t7(@NonNull ObservableConverter<T, ? extends R> observableConverter) {
        Objects.requireNonNull(observableConverter, "converter is null");
        return observableConverter.d(this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T u() {
        T i2 = E5().i();
        if (i2 != null) {
            return i2;
        }
        throw new NoSuchElementException();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> u1(@NonNull Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return h(Functions.i(obj));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> u2(@NonNull Function<? super T, ? extends ObservableSource<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, int i2) {
        return x2(function, biFunction, false, i2, U());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> u4(@NonNull Scheduler scheduler, boolean z, int i2) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.R(new ObservableObserveOn(this, scheduler, z, i2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> u5(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.R(new ObservableScan(this, biFunction));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> u7(@NonNull BackpressureStrategy backpressureStrategy) {
        Objects.requireNonNull(backpressureStrategy, "strategy is null");
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(this);
        int i2 = AnonymousClass1.f28369a[backpressureStrategy.ordinal()];
        if (i2 == 1) {
            return flowableFromObservable.Q4();
        }
        if (i2 == 2) {
            return flowableFromObservable.S4();
        }
        if (i2 != 3) {
            return i2 != 4 ? flowableFromObservable.I4() : RxJavaPlugins.P(new FlowableOnBackpressureError(flowableFromObservable));
        }
        return flowableFromObservable;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T v(@NonNull T t) {
        return D5(t).j();
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Long> v1() {
        return RxJavaPlugins.S(new ObservableCountSingle(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> v2(@NonNull Function<? super T, ? extends ObservableSource<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return x2(function, biFunction, z, U(), U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<U> v4(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return l2(Functions.l(cls)).X(cls);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> v5(@NonNull R r, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(r, "initialValue is null");
        return w5(Functions.o(r), biFunction);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Future<T> v7() {
        return (Future) i6(new FutureObserver());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Stream<T> w() {
        return x(U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> w2(@NonNull Function<? super T, ? extends ObservableSource<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        return x2(function, biFunction, z, i2, U());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> w4() {
        return x4(Functions.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> w5(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "seedSupplier is null");
        Objects.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.R(new ObservableScanSeed(this, supplier, biFunction));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> w7() {
        return x7(16);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Stream<T> x(int i2) {
        Iterator it2 = o(i2).iterator();
        Stream a2 = StreamSupport.stream(Spliterators.spliteratorUnknownSize(it2, 0), false);
        Disposable disposable = (Disposable) it2;
        disposable.getClass();
        return e.a(a2.onClose(new h(disposable)));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Observable<T> x1(long j2, @NonNull TimeUnit timeUnit) {
        return y1(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> x2(@NonNull Function<? super T, ? extends ObservableSource<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return C2(ObservableInternalHelper.b(function, biFunction), z, i2, i3);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> x4(@NonNull Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.R(new ObservableOnErrorComplete(this, predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> x7(int i2) {
        ObjectHelper.b(i2, "capacityHint");
        return RxJavaPlugins.S(new ObservableToListSingle(this, i2));
    }

    @SchedulerSupport("none")
    public final void y() {
        ObservableBlockingSubscribe.a(this);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Observable<T> y1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.R(new ObservableDebounceTimed(this, j2, timeUnit, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> y2(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, @NonNull Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, @NonNull Supplier<? extends ObservableSource<? extends R>> supplier) {
        Objects.requireNonNull(function, "onNextMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteSupplier is null");
        return T3(new ObservableMapNotification(this, function, function2, supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> y3() {
        return c(Functions.b());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> y4(@NonNull Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return RxJavaPlugins.R(new ObservableOnErrorNext(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> y6(long j2) {
        if (j2 >= 0) {
            return RxJavaPlugins.R(new ObservableTake(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> y7(@NonNull Supplier<U> supplier) {
        Objects.requireNonNull(supplier, "collectionSupplier is null");
        return RxJavaPlugins.S(new ObservableToListSingle(this, supplier));
    }

    @SchedulerSupport("none")
    public final void z(@NonNull Observer<? super T> observer) {
        Objects.requireNonNull(observer, "observer is null");
        ObservableBlockingSubscribe.b(this, observer);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Observable<T> z1(@NonNull Function<? super T, ? extends ObservableSource<U>> function) {
        Objects.requireNonNull(function, "debounceIndicator is null");
        return RxJavaPlugins.R(new ObservableDebounce(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Observable<R> z2(@NonNull Function<? super T, ? extends ObservableSource<? extends R>> function, @NonNull Function<Throwable, ? extends ObservableSource<? extends R>> function2, @NonNull Supplier<? extends ObservableSource<? extends R>> supplier, int i2) {
        Objects.requireNonNull(function, "onNextMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteSupplier is null");
        return U3(new ObservableMapNotification(this, function, function2, supplier), i2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> z3(@NonNull ObservableSource<? extends TRight> observableSource, @NonNull Function<? super T, ? extends ObservableSource<TLeftEnd>> function, @NonNull Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, @NonNull BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        Objects.requireNonNull(observableSource, "other is null");
        Objects.requireNonNull(function, "leftEnd is null");
        Objects.requireNonNull(function2, "rightEnd is null");
        Objects.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.R(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> z4(@NonNull ObservableSource<? extends T> observableSource) {
        Objects.requireNonNull(observableSource, "fallback is null");
        return y4(Functions.n(observableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> z6(long j2, @NonNull TimeUnit timeUnit) {
        return K6(n7(j2, timeUnit));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Single<Map<K, T>> z7(@NonNull Function<? super T, ? extends K> function) {
        Objects.requireNonNull(function, "keySelector is null");
        return Y(HashMapSupplier.a(), Functions.F(function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Observable<R> z8(@NonNull ObservableSource<? extends U> observableSource, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(observableSource, "other is null");
        return t8(this, observableSource, biFunction);
    }
}
