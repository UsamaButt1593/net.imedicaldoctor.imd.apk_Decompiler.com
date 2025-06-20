package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.flowables.GroupedFlowable;
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
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.jdk8.FlowableCollectWithCollectorSingle;
import io.reactivex.rxjava3.internal.jdk8.FlowableFirstStageSubscriber;
import io.reactivex.rxjava3.internal.jdk8.FlowableFlatMapStream;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.FlowableFromStream;
import io.reactivex.rxjava3.internal.jdk8.FlowableLastStageSubscriber;
import io.reactivex.rxjava3.internal.jdk8.FlowableMapOptional;
import io.reactivex.rxjava3.internal.jdk8.FlowableSingleStageSubscriber;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.rxjava3.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAmb;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAnySingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBuffer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCache;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapScheduler;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableCreate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDebounce;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDefer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDelay;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDematerialize;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDetach;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDistinct;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoAfterNext;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnLifecycle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableEmpty;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableError;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFilter;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromAction;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromArray;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromRunnable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFromSupplier;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGenerate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableHide;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableInterval;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableJoin;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableJust;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableLastMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableLastSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableLift;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableNever;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowablePublish;
import io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRange;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReduceSeedSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReduceWithSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRepeat;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableReplay;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableScan;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSerialized;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkip;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSkipWhile;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTake;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeUntilPredicate;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTakeWhile;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeInterval;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeout;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTimer;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableUsing;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindow;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableZip;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleToFlowable;
import io.reactivex.rxjava3.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.rxjava3.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BlockingLastSubscriber;
import io.reactivex.rxjava3.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.rxjava3.internal.subscribers.FutureSubscriber;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.subscribers.StrictSubscriber;
import io.reactivex.rxjava3.internal.util.ArrayListSupplier;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.HashMapSupplier;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.Timed;
import io.reactivex.rxjava3.subscribers.SafeSubscriber;
import io.reactivex.rxjava3.subscribers.TestSubscriber;
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
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Flowable<T> implements Publisher<T> {
    static final int s = Math.max(1, Integer.getInteger("rx3.buffer-size", 128).intValue());

    /* renamed from: io.reactivex.rxjava3.core.Flowable$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28366a;

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
                f28366a = r0
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28366a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28366a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28366a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.rxjava3.core.BackpressureStrategy r1 = io.reactivex.rxjava3.core.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.core.Flowable.AnonymousClass1.<clinit>():void");
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> A0(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        return C0(publisher, publisher2, publisher3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> B0(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3, @NonNull Publisher<? extends T> publisher4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        return C0(publisher, publisher2, publisher3, publisher4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> C0(@NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return p2();
        }
        return publisherArr.length == 1 ? l3(publisherArr[0]) : RxJavaPlugins.P(new FlowableConcatArray(publisherArr, false));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> C1(@NonNull FlowableOnSubscribe<T> flowableOnSubscribe, @NonNull BackpressureStrategy backpressureStrategy) {
        Objects.requireNonNull(flowableOnSubscribe, "source is null");
        Objects.requireNonNull(backpressureStrategy, "mode is null");
        return RxJavaPlugins.P(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> D0(@NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return p2();
        }
        return publisherArr.length == 1 ? l3(publisherArr[0]) : RxJavaPlugins.P(new FlowableConcatArray(publisherArr, true));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> D4() {
        return RxJavaPlugins.P(FlowableNever.X);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> E0(int i2, int i3, @NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapEager(new FlowableFromArray(publisherArr), Functions.k(), i2, i3, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> E3(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return F3(j2, j3, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> F0(@NonNull Publisher<? extends T>... publisherArr) {
        return E0(Y(), Y(), publisherArr);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> F3(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableInterval(Math.max(0, j2), Math.max(0, j3), timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> G0(int i2, int i3, @NonNull Publisher<? extends T>... publisherArr) {
        return b3(publisherArr).h1(Functions.k(), true, i2, i3);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> G3(long j2, @NonNull TimeUnit timeUnit) {
        return F3(j2, j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> H0(@NonNull Publisher<? extends T>... publisherArr) {
        return G0(Y(), Y(), publisherArr);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> H1(@NonNull Supplier<? extends Publisher<? extends T>> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.P(new FlowableDefer(supplier));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> H3(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return F3(j2, j2, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> I0(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return h3(iterable).b1(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> I3(long j2, long j3, long j4, long j5, @NonNull TimeUnit timeUnit) {
        return J3(j2, j3, j4, j5, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> J0(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return K0(publisher, Y(), true);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> J3(long j2, long j3, long j4, long j5, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        long j6 = j3;
        long j7 = j4;
        TimeUnit timeUnit2 = timeUnit;
        Scheduler scheduler2 = scheduler;
        int i2 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j6);
        } else if (i2 == 0) {
            return p2().J1(j7, timeUnit2, scheduler2);
        } else {
            long j8 = j2 + (j6 - 1);
            if (j2 <= 0 || j8 >= 0) {
                Objects.requireNonNull(timeUnit2, "unit is null");
                Objects.requireNonNull(scheduler2, "scheduler is null");
                return RxJavaPlugins.P(new FlowableIntervalRange(j2, j8, Math.max(0, j7), Math.max(0, j5), timeUnit, scheduler));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> K0(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2, boolean z) {
        return l3(publisher).c1(Functions.k(), z, i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> L0(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return M0(iterable, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> M0(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i2, int i3) {
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.k(), i2, i3, ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> M3(T t) {
        Objects.requireNonNull(t, "item is null");
        return RxJavaPlugins.P(new FlowableJust(t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> N0(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return O0(publisher, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> N3(T t, T t2) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        return b3(t, t2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> O0(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2, int i3) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapEagerPublisher(publisher, Functions.k(), i2, i3, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> O3(T t, T t2, T t3) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        return b3(t, t2, t3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> P0(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return Q0(iterable, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> P3(T t, T t2, T t3, T t4) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        return b3(t, t2, t3, t4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> Q0(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i2, int i3) {
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.k(), i2, i3, ErrorMode.END));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> Q3(T t, T t2, T t3, T t4, T t5) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        return b3(t, t2, t3, t4, t5);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> R0(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return S0(publisher, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> R3(T t, T t2, T t3, T t4, T t5, T t6) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        return b3(t, t2, t3, t4, t5, t6);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> S0(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2, int i3) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapEagerPublisher(publisher, Functions.k(), i2, i3, ErrorMode.END));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> S3(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        Objects.requireNonNull(t7, "item7 is null");
        return b3(t, t2, t3, t4, t5, t6, t7);
    }

    private Flowable<T> S7(long j2, TimeUnit timeUnit, Publisher<? extends T> publisher, Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableTimeoutTimed(this, j2, timeUnit, scheduler, publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> S8(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.P(new FlowableZip((Publisher<? extends T>[]) null, iterable, function, Y(), false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> T3(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        Objects.requireNonNull(t7, "item7 is null");
        Objects.requireNonNull(t8, "item8 is null");
        return b3(t, t2, t3, t4, t5, t6, t7, t8);
    }

    private <U, V> Flowable<T> T7(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        Objects.requireNonNull(function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.P(new FlowableTimeout(this, publisher, function, publisher2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> T8(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, boolean z, int i2) {
        Objects.requireNonNull(function, "zipper is null");
        Objects.requireNonNull(iterable, "sources is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableZip((Publisher<? extends T>[]) null, iterable, function, i2, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> U3(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        Objects.requireNonNull(t, "item1 is null");
        Objects.requireNonNull(t2, "item2 is null");
        Objects.requireNonNull(t3, "item3 is null");
        Objects.requireNonNull(t4, "item4 is null");
        Objects.requireNonNull(t5, "item5 is null");
        Objects.requireNonNull(t6, "item6 is null");
        Objects.requireNonNull(t7, "item7 is null");
        Objects.requireNonNull(t8, "item8 is null");
        Objects.requireNonNull(t9, "item9 is null");
        return b3(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> U7(long j2, @NonNull TimeUnit timeUnit) {
        return V7(j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> U8(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return e9(Functions.x(biFunction), false, Y(), publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> V3(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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
        return b3(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> V7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableTimer(Math.max(0, j2), timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> V8(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return e9(Functions.x(biFunction), z, Y(), publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> W8(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return e9(Functions.x(biFunction), z, i2, publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Flowable<R> X8(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(function3, "zipper is null");
        return e9(Functions.y(function3), false, Y(), publisher, publisher2, publisher3);
    }

    @CheckReturnValue
    public static int Y() {
        return s;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Flowable<R> Y8(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(function4, "zipper is null");
        return e9(Functions.z(function4), false, Y(), publisher, publisher2, publisher3, publisher4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Flowable<R> Z8(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(function5, "zipper is null");
        return e9(Functions.A(function5), false, Y(), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> a3(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.P(new FlowableFromAction(action));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> a6(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        return d6(publisher, publisher2, ObjectHelper.a(), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> a7(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return l3(publisher).P6(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> a9(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(function6, "zipper is null");
        return e9(Functions.B(function6), false, Y(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> b(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.P(new FlowableAmb((Publisher<? extends T>[]) null, iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> b3(@NonNull T... tArr) {
        Objects.requireNonNull(tArr, "items is null");
        if (tArr.length == 0) {
            return p2();
        }
        return tArr.length == 1 ? M3(tArr[0]) : RxJavaPlugins.P(new FlowableFromArray(tArr));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> b6(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, int i2) {
        return d6(publisher, publisher2, ObjectHelper.a(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> b7(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        return l3(publisher).Q6(Functions.k(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> b9(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(function7, "zipper is null");
        return e9(Functions.C(function7), false, Y(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> c(@NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        int length = publisherArr.length;
        if (length == 0) {
            return p2();
        }
        return length == 1 ? l3(publisherArr[0]) : RxJavaPlugins.P(new FlowableAmb(publisherArr, (Iterable) null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> c3(@NonNull Callable<? extends T> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.P(new FlowableFromCallable(callable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> c6(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull BiPredicate<? super T, ? super T> biPredicate) {
        return d6(publisher, publisher2, biPredicate, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> c7(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return d7(publisher, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> c9(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(function8, "zipper is null");
        return e9(Functions.D(function8), false, Y(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> d3(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "completableSource is null");
        return RxJavaPlugins.P(new FlowableFromCompletable(completableSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Single<Boolean> d6(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull BiPredicate<? super T, ? super T> biPredicate, int i2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biPredicate, "isEqual is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.S(new FlowableSequenceEqualSingle(publisher, publisher2, biPredicate, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> d7(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        return l3(publisher).V6(Functions.k(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> d9(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Publisher<? extends T9> publisher9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(publisher9, "source9 is null");
        Objects.requireNonNull(function9, "zipper is null");
        return e9(Functions.E(function9), false, Y(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    private Flowable<T> e2(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, Action action, Action action2) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(action2, "onAfterTerminate is null");
        return RxJavaPlugins.P(new FlowableDoOnEach(this, consumer, consumer2, action, action2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> e3(@NonNull CompletionStage<T> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return RxJavaPlugins.P(new FlowableFromCompletionStage(completionStage));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T, R> Flowable<R> e9(@NonNull Function<? super Object[], ? extends R> function, boolean z, int i2, @NonNull Publisher<? extends T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return p2();
        }
        Objects.requireNonNull(function, "zipper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableZip(publisherArr, (Iterable) null, function, i2, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> f0(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        return g0(iterable, function, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> f3(@NonNull Future<? extends T> future) {
        Objects.requireNonNull(future, "future is null");
        return RxJavaPlugins.P(new FlowableFromFuture(future, 0, (TimeUnit) null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> f4(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return h3(iterable).y2(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> g0(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableCombineLatest(iterable, function, i2, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> g3(@NonNull Future<? extends T> future, long j2, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(future, "future is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        return RxJavaPlugins.P(new FlowableFromFuture(future, j2, timeUnit));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> g4(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i2) {
        return h3(iterable).z2(Functions.k(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, R> Flowable<R> h0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2}, Functions.x(biFunction), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> h3(@NonNull Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.P(new FlowableFromIterable(iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> h4(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i2, int i3) {
        return h3(iterable).J2(Functions.k(), false, i2, i3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Flowable<Integer> h5(int i2, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i3);
        } else if (i3 == 0) {
            return p2();
        } else {
            if (i3 == 1) {
                return M3(Integer.valueOf(i2));
            }
            if (((long) i2) + ((long) (i3 - 1)) <= 2147483647L) {
                return RxJavaPlugins.P(new FlowableRange(i2, i3));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, R> Flowable<R> i0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(function3, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2, publisher3}, Functions.y(function3), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> i3(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "maybe is null");
        return RxJavaPlugins.P(new MaybeToFlowable(maybeSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> i4(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return j4(publisher, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Flowable<Long> i5(long j2, long j3) {
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j3);
        } else if (i2 == 0) {
            return p2();
        } else {
            if (j3 == 1) {
                return M3(Long.valueOf(j2));
            }
            long j4 = (j3 - 1) + j2;
            if (j2 <= 0 || j4 >= 0) {
                return RxJavaPlugins.P(new FlowableRangeLong(j2, j3));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, R> Flowable<R> j0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(function4, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.z(function4), Y());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> j3(@NonNull ObservableSource<T> observableSource, @NonNull BackpressureStrategy backpressureStrategy) {
        Objects.requireNonNull(observableSource, "source is null");
        Objects.requireNonNull(backpressureStrategy, "strategy is null");
        FlowableFromObservable flowableFromObservable = new FlowableFromObservable(observableSource);
        int i2 = AnonymousClass1.f28366a[backpressureStrategy.ordinal()];
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

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> j4(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        return l3(publisher).z2(Functions.k(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, R> Flowable<R> k0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(function5, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5}, Functions.A(function5), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> k3(@NonNull Optional<T> optional) {
        Objects.requireNonNull(optional, "optional is null");
        return (Flowable) optional.map(new i()).orElseGet(new j());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> k4(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        return b3(publisher, publisher2).I2(Functions.k(), false, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> l0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(function6, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6}, Functions.B(function6), Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> l3(@NonNull Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.P((Flowable) publisher);
        }
        Objects.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.P(new FlowableFromPublisher(publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> l4(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        return b3(publisher, publisher2, publisher3).I2(Functions.k(), false, 3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> m0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(function7, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7}, Functions.C(function7), Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> m3(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return RxJavaPlugins.P(new FlowableFromRunnable(runnable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> m4(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3, @NonNull Publisher<? extends T> publisher4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        return b3(publisher, publisher2, publisher3, publisher4).I2(Functions.k(), false, 4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> n0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(function8, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8}, Functions.D(function8), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> n3(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "source is null");
        return RxJavaPlugins.P(new SingleToFlowable(singleSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> n4(int i2, int i3, @NonNull Publisher<? extends T>... publisherArr) {
        return b3(publisherArr).J2(Functions.k(), false, i2, i3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> o0(@NonNull Publisher<? extends T1> publisher, @NonNull Publisher<? extends T2> publisher2, @NonNull Publisher<? extends T3> publisher3, @NonNull Publisher<? extends T4> publisher4, @NonNull Publisher<? extends T5> publisher5, @NonNull Publisher<? extends T6> publisher6, @NonNull Publisher<? extends T7> publisher7, @NonNull Publisher<? extends T8> publisher8, @NonNull Publisher<? extends T9> publisher9, @NonNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(publisher5, "source5 is null");
        Objects.requireNonNull(publisher6, "source6 is null");
        Objects.requireNonNull(publisher7, "source7 is null");
        Objects.requireNonNull(publisher8, "source8 is null");
        Objects.requireNonNull(publisher9, "source9 is null");
        Objects.requireNonNull(function9, "combiner is null");
        return q0(new Publisher[]{publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9}, Functions.E(function9), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> o3(@NonNull Stream<T> stream) {
        Objects.requireNonNull(stream, "stream is null");
        return RxJavaPlugins.P(new FlowableFromStream(stream));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> o4(@NonNull Publisher<? extends T>... publisherArr) {
        return b3(publisherArr).z2(Functions.k(), publisherArr.length);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> p0(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function) {
        return q0(publisherArr, function, Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> p2() {
        return RxJavaPlugins.P(FlowableEmpty.X);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> p3(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.P(new FlowableFromSupplier(supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> p4(int i2, int i3, @NonNull Publisher<? extends T>... publisherArr) {
        return b3(publisherArr).J2(Functions.k(), true, i2, i3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> q0(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return p2();
        }
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableCombineLatest(publisherArr, function, i2, false));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> q2(@NonNull Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.P(new FlowableError(supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> q3(@NonNull Consumer<Emitter<T>> consumer) {
        Objects.requireNonNull(consumer, "generator is null");
        return u3(Functions.u(), FlowableInternalHelper.i(consumer), Functions.h());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> Flowable<T> q4(@NonNull Publisher<? extends T>... publisherArr) {
        return b3(publisherArr).I2(Functions.k(), true, publisherArr.length);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> r0(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function) {
        return s0(publisherArr, function, Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> r2(@NonNull Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return q2(Functions.o(th));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> r3(@NonNull Supplier<S> supplier, @NonNull BiConsumer<S, Emitter<T>> biConsumer) {
        Objects.requireNonNull(biConsumer, "generator is null");
        return u3(supplier, FlowableInternalHelper.h(biConsumer), Functions.h());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> r4(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        return h3(iterable).H2(Functions.k(), true);
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> r8(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "onSubscribe is null");
        if (!(publisher instanceof Flowable)) {
            return RxJavaPlugins.P(new FlowableFromPublisher(publisher));
        }
        throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> s0(@NonNull Publisher<? extends T>[] publisherArr, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(publisherArr, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        return publisherArr.length == 0 ? p2() : RxJavaPlugins.P(new FlowableCombineLatest(publisherArr, function, i2, true));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> s3(@NonNull Supplier<S> supplier, @NonNull BiConsumer<S, Emitter<T>> biConsumer, @NonNull Consumer<? super S> consumer) {
        Objects.requireNonNull(biConsumer, "generator is null");
        return u3(supplier, FlowableInternalHelper.h(biConsumer), consumer);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> s4(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i2) {
        return h3(iterable).I2(Functions.k(), true, i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> t0(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function) {
        return u0(iterable, function, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> t3(@NonNull Supplier<S> supplier, @NonNull BiFunction<S, Emitter<T>, S> biFunction) {
        return u3(supplier, biFunction, Functions.h());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> t4(@NonNull Iterable<? extends Publisher<? extends T>> iterable, int i2, int i3) {
        return h3(iterable).J2(Functions.k(), true, i2, i3);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Flowable<T> t8(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends Publisher<? extends T>> function, @NonNull Consumer<? super D> consumer) {
        return u8(supplier, function, consumer, true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, R> Flowable<R> u0(@NonNull Iterable<? extends Publisher<? extends T>> iterable, @NonNull Function<? super Object[], ? extends R> function, int i2) {
        Objects.requireNonNull(iterable, "sources is null");
        Objects.requireNonNull(function, "combiner is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableCombineLatest(iterable, function, i2, true));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, S> Flowable<T> u3(@NonNull Supplier<S> supplier, @NonNull BiFunction<S, Emitter<T>, S> biFunction, @NonNull Consumer<? super S> consumer) {
        Objects.requireNonNull(supplier, "initialState is null");
        Objects.requireNonNull(biFunction, "generator is null");
        Objects.requireNonNull(consumer, "disposeState is null");
        return RxJavaPlugins.P(new FlowableGenerate(supplier, biFunction, consumer));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> u4(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return v4(publisher, Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T, D> Flowable<T> u8(@NonNull Supplier<? extends D> supplier, @NonNull Function<? super D, ? extends Publisher<? extends T>> function, @NonNull Consumer<? super D> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "resourceCleanup is null");
        return RxJavaPlugins.P(new FlowableUsing(supplier, function, consumer, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> v4(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        return l3(publisher).I2(Functions.k(), true, i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> w0(@NonNull Iterable<? extends Publisher<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return h3(iterable).c1(Functions.k(), false, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> w4(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        return b3(publisher, publisher2).I2(Functions.k(), true, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> x0(@NonNull Publisher<? extends Publisher<? extends T>> publisher) {
        return y0(publisher, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> x4(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        return b3(publisher, publisher2, publisher3).I2(Functions.k(), true, 3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> y0(@NonNull Publisher<? extends Publisher<? extends T>> publisher, int i2) {
        return l3(publisher).U0(Functions.k(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> y4(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2, @NonNull Publisher<? extends T> publisher3, @NonNull Publisher<? extends T> publisher4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        return b3(publisher, publisher2, publisher3, publisher4).I2(Functions.k(), true, 4);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Flowable<T> z0(@NonNull Publisher<? extends T> publisher, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        return C0(publisher, publisher2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void A(@NonNull Consumer<? super T> consumer) {
        FlowableBlockingSubscribe.b(this, consumer, Functions.f28377f, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> A1(@NonNull Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return f(Functions.i(obj));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> A2(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return E2(function, biFunction, false, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> A3(@NonNull Function<? super T, ? extends K> function, boolean z) {
        return y3(function, Functions.k(), z, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> A4(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.P(new FlowableMergeWithMaybe(this, maybeSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> A5() {
        return FlowableReplay.z9(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> A6(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return z0(Single.y2(singleSource).p2(), this);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> A7(long j2, @NonNull TimeUnit timeUnit) {
        return C7(j2, timeUnit, Schedulers.a(), false);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> A8(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2) {
        int i3 = i2;
        ObjectHelper.b(i3, "bufferSize");
        ObjectHelper.c(j2, "timespan");
        long j4 = j3;
        ObjectHelper.c(j4, "timeskip");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        return RxJavaPlugins.P(new FlowableWindowTimed(this, j2, j4, timeUnit2, scheduler2, Long.MAX_VALUE, i3, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void B(@NonNull Consumer<? super T> consumer, int i2) {
        FlowableBlockingSubscribe.c(this, consumer, Functions.f28377f, Functions.f28374c, i2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Long> B1() {
        return RxJavaPlugins.S(new FlowableCountSingle(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> B2(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, int i2) {
        return E2(function, biFunction, false, i2, Y());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> B3(@NonNull Publisher<? extends TRight> publisher, @NonNull Function<? super T, ? extends Publisher<TLeftEnd>> function, @NonNull Function<? super TRight, ? extends Publisher<TRightEnd>> function2, @NonNull BiFunction<? super T, ? super Flowable<TRight>, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(function, "leftEnd is null");
        Objects.requireNonNull(function2, "rightEnd is null");
        Objects.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.P(new FlowableGroupJoin(this, publisher, function, function2, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> B4(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.P(new FlowableMergeWithSingle(this, singleSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> B5(int i2) {
        ObjectHelper.b(i2, "bufferSize");
        return FlowableReplay.v9(this, i2, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> B6(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return C0(publisher, this);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> B7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return C7(j2, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> B8(long j2, @NonNull TimeUnit timeUnit) {
        return G8(j2, timeUnit, Schedulers.a(), Long.MAX_VALUE, false);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void C(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        FlowableBlockingSubscribe.b(this, consumer, consumer2, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> C2(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return E2(function, biFunction, z, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> C3() {
        return RxJavaPlugins.P(new FlowableHide(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> C4(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return k4(this, publisher);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> C5(int i2, long j2, @NonNull TimeUnit timeUnit) {
        return D5(i2, j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public final Flowable<T> C6(@NonNull T... tArr) {
        Flowable b3 = b3(tArr);
        if (b3 == p2()) {
            return RxJavaPlugins.P(this);
        }
        return C0(b3, this);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> C7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableThrottleLatest(this, j2, timeUnit, scheduler, z));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> C8(long j2, @NonNull TimeUnit timeUnit, long j3) {
        return G8(j2, timeUnit, Schedulers.a(), j3, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void D(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, int i2) {
        FlowableBlockingSubscribe.c(this, consumer, consumer2, Functions.f28374c, i2);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> D1(long j2, @NonNull TimeUnit timeUnit) {
        return E1(j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> D2(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        return E2(function, biFunction, z, i2, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable D3() {
        return RxJavaPlugins.O(new FlowableIgnoreElementsCompletable(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> D5(int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        return FlowableReplay.w9(this, j2, timeUnit, scheduler, i2, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> D6(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return C0(M3(t), this);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> D7(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return C7(j2, timeUnit, Schedulers.a(), z);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> D8(long j2, @NonNull TimeUnit timeUnit, long j3, boolean z) {
        return G8(j2, timeUnit, Schedulers.a(), j3, z);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void E(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        FlowableBlockingSubscribe.b(this, consumer, consumer2, action);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> E1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableDebounceTimed(this, j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> E2(@NonNull Function<? super T, ? extends Publisher<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "bufferSize");
        return J2(FlowableInternalHelper.b(function, biFunction), z, i2, i3);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> E4(@NonNull Scheduler scheduler) {
        return G4(scheduler, false, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> E5(int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        return FlowableReplay.w9(this, j2, timeUnit, scheduler, i2, z);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> E6(@NonNull Iterable<? extends T> iterable) {
        return C0(h3(iterable), this);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> E7(long j2, @NonNull TimeUnit timeUnit) {
        return D1(j2, timeUnit);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> E8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return G8(j2, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void F(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action, int i2) {
        FlowableBlockingSubscribe.c(this, consumer, consumer2, action, i2);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> F1(@NonNull Function<? super T, ? extends Publisher<U>> function) {
        Objects.requireNonNull(function, "debounceIndicator is null");
        return RxJavaPlugins.P(new FlowableDebounce(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> F2(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, @NonNull Function<? super Throwable, ? extends Publisher<? extends R>> function2, @NonNull Supplier<? extends Publisher<? extends R>> supplier) {
        Objects.requireNonNull(function, "onNextMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteSupplier is null");
        return i4(new FlowableMapNotification(this, function, function2, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> F4(@NonNull Scheduler scheduler, boolean z) {
        return G4(scheduler, z, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> F5(int i2, boolean z) {
        ObjectHelper.b(i2, "bufferSize");
        return FlowableReplay.v9(this, i2, z);
    }

    @NonNull
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final Disposable F6() {
        return I6(Functions.h(), Functions.f28377f, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> F7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return E1(j2, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> F8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j3) {
        return G8(j2, timeUnit, scheduler, j3, false);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void G(@NonNull Subscriber<? super T> subscriber) {
        Objects.requireNonNull(subscriber, "subscriber is null");
        FlowableBlockingSubscribe.d(this, subscriber);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> G1(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        return O6(M3(t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> G2(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, @NonNull Function<Throwable, ? extends Publisher<? extends R>> function2, @NonNull Supplier<? extends Publisher<? extends R>> supplier, int i2) {
        Objects.requireNonNull(function, "onNextMapper is null");
        Objects.requireNonNull(function2, "onErrorMapper is null");
        Objects.requireNonNull(supplier, "onCompleteSupplier is null");
        return j4(new FlowableMapNotification(this, function, function2, supplier), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> G4(@NonNull Scheduler scheduler, boolean z, int i2) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableObserveOn(this, scheduler, z, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> G5(long j2, @NonNull TimeUnit timeUnit) {
        return H5(j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable G6(@NonNull Consumer<? super T> consumer) {
        return I6(consumer, Functions.f28377f, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> G7() {
        return J7(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> G8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j3, boolean z) {
        return H8(j2, timeUnit, scheduler, j3, z, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> H(int i2) {
        return I(i2, i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> H2(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return J2(function, z, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> H4(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return s2(Functions.l(cls)).b0(cls);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> H5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.x9(this, j2, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable H6(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2) {
        return I6(consumer, consumer2, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> H7(@NonNull Scheduler scheduler) {
        return J7(TimeUnit.MILLISECONDS, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> H8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, long j3, boolean z, int i2) {
        int i3 = i2;
        ObjectHelper.b(i3, "bufferSize");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        long j4 = j3;
        ObjectHelper.c(j4, "count");
        return RxJavaPlugins.P(new FlowableWindowTimed(this, j2, j2, timeUnit2, scheduler2, j4, i3, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> I(int i2, int i3) {
        return J(i2, i3, ArrayListSupplier.c());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> I1(long j2, @NonNull TimeUnit timeUnit) {
        return K1(j2, timeUnit, Schedulers.a(), false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> I2(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2) {
        return J2(function, z, i2, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> I4() {
        return M4(Y(), false, true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> I5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.x9(this, j2, timeUnit, scheduler, z);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable I6(@NonNull Consumer<? super T> consumer, @NonNull Consumer<? super Throwable> consumer2, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, FlowableInternalHelper.RequestMax.INSTANCE);
        J6(lambdaSubscriber);
        return lambdaSubscriber;
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> I7(@NonNull TimeUnit timeUnit) {
        return J7(timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> I8(@NonNull Publisher<B> publisher) {
        return J8(publisher, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> J(int i2, int i3, @NonNull Supplier<U> supplier) {
        ObjectHelper.b(i2, "count");
        ObjectHelper.b(i3, "skip");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.P(new FlowableBuffer(this, i2, i3, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> J1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return K1(j2, timeUnit, scheduler, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> J2(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.P(new FlowableFlatMap(this, function, z, i2, i3));
        }
        Object obj = ((ScalarSupplier) this).get();
        return obj == null ? p2() : FlowableScalarXMap.a(obj, function);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> J4(int i2) {
        return M4(i2, false, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> J5() {
        return L5(Long.MAX_VALUE, Functions.c());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void J6(@NonNull FlowableSubscriber<? super T> flowableSubscriber) {
        Objects.requireNonNull(flowableSubscriber, "subscriber is null");
        try {
            Subscriber<? super Object> h0 = RxJavaPlugins.h0(this, flowableSubscriber);
            Objects.requireNonNull(h0, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            K6(h0);
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

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> J7(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableTimeInterval(this, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<Flowable<T>> J8(@NonNull Publisher<B> publisher, int i2) {
        Objects.requireNonNull(publisher, "boundaryIndicator is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableWindowBoundary(this, publisher, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> K(int i2, @NonNull Supplier<U> supplier) {
        return J(i2, i2, supplier);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> K1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableDelay(this, Math.max(0, j2), timeUnit, scheduler, z));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable K2(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return L2(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> K3() {
        return a(Functions.b());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> K4(int i2, @NonNull Action action) {
        return N4(i2, false, false, action);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> K5(long j2) {
        return L5(j2, Functions.c());
    }

    /* access modifiers changed from: protected */
    public abstract void K6(@NonNull Subscriber<? super T> subscriber);

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> K7(long j2, @NonNull TimeUnit timeUnit) {
        return S7(j2, timeUnit, (Publisher) null, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<Flowable<T>> K8(@NonNull Publisher<U> publisher, @NonNull Function<? super U, ? extends Publisher<V>> function) {
        return L8(publisher, function, Y());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> L(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return N(j2, j3, timeUnit, Schedulers.a(), ArrayListSupplier.c());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> L1(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return K1(j2, timeUnit, Schedulers.a(), z);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable L2(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.O(new FlowableFlatMapCompletableCompletable(this, function, z, i2));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> L3(@NonNull Publisher<? extends TRight> publisher, @NonNull Function<? super T, ? extends Publisher<TLeftEnd>> function, @NonNull Function<? super TRight, ? extends Publisher<TRightEnd>> function2, @NonNull BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(function, "leftEnd is null");
        Objects.requireNonNull(function2, "rightEnd is null");
        Objects.requireNonNull(biFunction, "resultSelector is null");
        return RxJavaPlugins.P(new FlowableJoin(this, publisher, function, function2, biFunction));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> L4(int i2, boolean z) {
        return M4(i2, z, false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> L5(long j2, @NonNull Predicate<? super Throwable> predicate) {
        if (j2 >= 0) {
            Objects.requireNonNull(predicate, "predicate is null");
            return RxJavaPlugins.P(new FlowableRetryPredicate(this, j2, predicate));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> L6(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return M6(scheduler, !(this instanceof FlowableCreate));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> L7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return S7(j2, timeUnit, (Publisher) null, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<Flowable<T>> L8(@NonNull Publisher<U> publisher, @NonNull Function<? super U, ? extends Publisher<V>> function, int i2) {
        Objects.requireNonNull(publisher, "openingIndicator is null");
        Objects.requireNonNull(function, "closingIndicator is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableWindowBoundarySelector(this, publisher, function, i2));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> M(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return N(j2, j3, timeUnit, scheduler, ArrayListSupplier.c());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> M1(@NonNull Function<? super T, ? extends Publisher<U>> function) {
        Objects.requireNonNull(function, "itemDelayIndicator is null");
        return y2(FlowableInternalHelper.c(function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> M2(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        return N2(function, Y());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> M4(int i2, boolean z, boolean z2) {
        ObjectHelper.b(i2, "capacity");
        return RxJavaPlugins.P(new FlowableOnBackpressureBuffer(this, i2, z2, z, Functions.f28374c));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> M5(@NonNull BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        Objects.requireNonNull(biPredicate, "predicate is null");
        return RxJavaPlugins.P(new FlowableRetryBiPredicate(this, biPredicate));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> M6(@NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableSubscribeOn(this, scheduler, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> M7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return S7(j2, timeUnit, publisher, scheduler);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> M8(@NonNull Iterable<? extends Publisher<?>> iterable, @NonNull Function<? super Object[], R> function) {
        Objects.requireNonNull(iterable, "others is null");
        Objects.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.P(new FlowableWithLatestFromMany(this, iterable, function));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> N(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull Supplier<U> supplier) {
        TimeUnit timeUnit2 = timeUnit;
        Objects.requireNonNull(timeUnit2, "unit is null");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        Supplier<U> supplier2 = supplier;
        Objects.requireNonNull(supplier2, "bufferSupplier is null");
        return RxJavaPlugins.P(new FlowableBufferTimed(this, j2, j3, timeUnit2, scheduler2, supplier2, Integer.MAX_VALUE, false));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [io.reactivex.rxjava3.functions.Function, io.reactivex.rxjava3.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @io.reactivex.rxjava3.annotations.BackpressureSupport(io.reactivex.rxjava3.annotations.BackpressureKind.FULL)
    @io.reactivex.rxjava3.annotations.SchedulerSupport("none")
    @io.reactivex.rxjava3.annotations.NonNull
    @io.reactivex.rxjava3.annotations.CheckReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <U, V> io.reactivex.rxjava3.core.Flowable<T> N1(@io.reactivex.rxjava3.annotations.NonNull org.reactivestreams.Publisher<U> r1, @io.reactivex.rxjava3.annotations.NonNull io.reactivex.rxjava3.functions.Function<? super T, ? extends org.reactivestreams.Publisher<V>> r2) {
        /*
            r0 = this;
            io.reactivex.rxjava3.core.Flowable r1 = r0.Q1(r1)
            io.reactivex.rxjava3.core.Flowable r1 = r1.M1(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.core.Flowable.N1(org.reactivestreams.Publisher, io.reactivex.rxjava3.functions.Function):io.reactivex.rxjava3.core.Flowable");
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> N2(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableFlattenIterable(this, function, i2));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> N4(int i2, boolean z, boolean z2, @NonNull Action action) {
        Objects.requireNonNull(action, "onOverflow is null");
        ObjectHelper.b(i2, "capacity");
        return RxJavaPlugins.P(new FlowableOnBackpressureBuffer(this, i2, z2, z, action));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> N5(@NonNull Predicate<? super Throwable> predicate) {
        return L5(Long.MAX_VALUE, predicate);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E extends Subscriber<? super T>> E N6(E e2) {
        e(e2);
        return e2;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> N7(long j2, @NonNull TimeUnit timeUnit, @NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return S7(j2, timeUnit, publisher, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> N8(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return RxJavaPlugins.P(new FlowableWithLatestFrom(this, biFunction, publisher));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> O(long j2, @NonNull TimeUnit timeUnit) {
        return R(j2, timeUnit, Schedulers.a(), Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> O1(long j2, @NonNull TimeUnit timeUnit) {
        return P1(j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<V> O2(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends V> biFunction) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return E2(FlowableInternalHelper.a(function), biFunction, false, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> O4(long j2, @Nullable Action action, @NonNull BackpressureOverflowStrategy backpressureOverflowStrategy) {
        Objects.requireNonNull(backpressureOverflowStrategy, "overflowStrategy is null");
        ObjectHelper.c(j2, "capacity");
        return RxJavaPlugins.P(new FlowableOnBackpressureBufferStrategy(this, j2, action, backpressureOverflowStrategy));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> O5(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return L5(Long.MAX_VALUE, Functions.v(booleanSupplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> O6(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.P(new FlowableSwitchIfEmpty(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <V> Flowable<T> O7(@NonNull Function<? super T, ? extends Publisher<V>> function) {
        return T7((Publisher) null, function, (Publisher) null);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, R> Flowable<R> O8(@NonNull Publisher<T1> publisher, @NonNull Publisher<T2> publisher2, @NonNull Function3<? super T, ? super T1, ? super T2, R> function3) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(function3, "combiner is null");
        return R8(new Publisher[]{publisher, publisher2}, Functions.y(function3));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> P(long j2, @NonNull TimeUnit timeUnit, int i2) {
        return R(j2, timeUnit, Schedulers.a(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> P1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return Q1(V7(j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<V> P2(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, @NonNull BiFunction<? super T, ? super U, ? extends V> biFunction, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "combiner is null");
        return E2(FlowableInternalHelper.a(function), biFunction, false, Y(), i2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> P4(boolean z) {
        return M4(Y(), z, true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> P5(@NonNull Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return RxJavaPlugins.P(new FlowableRetryWhen(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> P6(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return Q6(function, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <V> Flowable<T> P7(@NonNull Function<? super T, ? extends Publisher<V>> function, @NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return T7((Publisher) null, function, publisher);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, T3, R> Flowable<R> P8(@NonNull Publisher<T1> publisher, @NonNull Publisher<T2> publisher2, @NonNull Publisher<T3> publisher3, @NonNull Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(function4, "combiner is null");
        return R8(new Publisher[]{publisher, publisher2, publisher3}, Functions.z(function4));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> Q(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return S(j2, timeUnit, scheduler, Integer.MAX_VALUE, ArrayListSupplier.c(), false);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> Q1(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "subscriptionIndicator is null");
        return RxJavaPlugins.P(new FlowableDelaySubscriptionOther(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> Q2(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return R2(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Q4() {
        return RxJavaPlugins.P(new FlowableOnBackpressureDrop(this));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    public final void Q5(@NonNull Subscriber<? super T> subscriber) {
        Objects.requireNonNull(subscriber, "subscriber is null");
        if (subscriber instanceof SafeSubscriber) {
            J6((SafeSubscriber) subscriber);
        } else {
            J6(new SafeSubscriber(subscriber));
        }
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> Q6(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        return R6(function, i2, false);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<T> Q7(@NonNull Publisher<U> publisher, @NonNull Function<? super T, ? extends Publisher<V>> function) {
        Objects.requireNonNull(publisher, "firstTimeoutIndicator is null");
        return T7(publisher, function, (Publisher) null);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T1, T2, T3, T4, R> Flowable<R> Q8(@NonNull Publisher<T1> publisher, @NonNull Publisher<T2> publisher2, @NonNull Publisher<T3> publisher3, @NonNull Publisher<T4> publisher4, @NonNull Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        Objects.requireNonNull(publisher, "source1 is null");
        Objects.requireNonNull(publisher2, "source2 is null");
        Objects.requireNonNull(publisher3, "source3 is null");
        Objects.requireNonNull(publisher4, "source4 is null");
        Objects.requireNonNull(function5, "combiner is null");
        return R8(new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.A(function5));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> R(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2) {
        return S(j2, timeUnit, scheduler, i2, ArrayListSupplier.c(), false);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> R1(@NonNull Function<? super T, Notification<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return RxJavaPlugins.P(new FlowableDematerialize(this, function));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> R2(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.P(new FlowableFlatMapMaybe(this, function, z, i2));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> R4(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onDrop is null");
        return RxJavaPlugins.P(new FlowableOnBackpressureDrop(this, consumer));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> R5(long j2, @NonNull TimeUnit timeUnit) {
        return S5(j2, timeUnit, Schedulers.a());
    }

    /* access modifiers changed from: package-private */
    public <R> Flowable<R> R6(Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.P(new FlowableSwitchMap(this, function, i2, z));
        }
        Object obj = ((ScalarSupplier) this).get();
        return obj == null ? p2() : FlowableScalarXMap.a(obj, function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, V> Flowable<T> R7(@NonNull Publisher<U> publisher, @NonNull Function<? super T, ? extends Publisher<V>> function, @NonNull Publisher<? extends T> publisher2) {
        Objects.requireNonNull(publisher, "firstTimeoutIndicator is null");
        Objects.requireNonNull(publisher2, "fallback is null");
        return T7(publisher, function, publisher2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> R8(@NonNull Publisher<?>[] publisherArr, @NonNull Function<? super Object[], R> function) {
        Objects.requireNonNull(publisherArr, "others is null");
        Objects.requireNonNull(function, "combiner is null");
        return RxJavaPlugins.P(new FlowableWithLatestFromMany(this, publisherArr, function));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Flowable<U> S(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2, @NonNull Supplier<U> supplier, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Scheduler scheduler2 = scheduler;
        Objects.requireNonNull(scheduler2, "scheduler is null");
        Supplier<U> supplier2 = supplier;
        Objects.requireNonNull(supplier2, "bufferSupplier is null");
        int i3 = i2;
        ObjectHelper.b(i3, "count");
        return RxJavaPlugins.P(new FlowableBufferTimed(this, j2, j2, timeUnit, scheduler2, supplier2, i3, z));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> S1() {
        return U1(Functions.k(), Functions.g());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> S2(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return T2(function, false, Integer.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> S4() {
        return RxJavaPlugins.P(new FlowableOnBackpressureLatest(this));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> S5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableSampleTimed(this, j2, timeUnit, scheduler, false));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable S6(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.O(new FlowableSwitchMapCompletable(this, function, false));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<List<T>> T(@NonNull Publisher<B> publisher) {
        return X(publisher, ArrayListSupplier.c());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> T0(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return U0(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<T> T1(@NonNull Function<? super T, K> function) {
        return U1(function, Functions.g());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> T2(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.P(new FlowableFlatMapSingle(this, function, z, i2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> T4() {
        return U4(Functions.c());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> T5(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableSampleTimed(this, j2, timeUnit, scheduler, z));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable T6(@NonNull Function<? super T, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.O(new FlowableSwitchMapCompletable(this, function, true));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B> Flowable<List<T>> U(@NonNull Publisher<B> publisher, int i2) {
        ObjectHelper.b(i2, "initialCapacity");
        return X(publisher, Functions.f(i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> U0(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        if (!(this instanceof ScalarSupplier)) {
            return RxJavaPlugins.P(new FlowableConcatMap(this, function, i2, ErrorMode.IMMEDIATE));
        }
        Object obj = ((ScalarSupplier) this).get();
        return obj == null ? p2() : FlowableScalarXMap.a(obj, function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<T> U1(@NonNull Function<? super T, K> function, @NonNull Supplier<? extends Collection<? super K>> supplier) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(supplier, "collectionSupplier is null");
        return RxJavaPlugins.P(new FlowableDistinct(this, function, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> U2(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        return V2(function, Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> U4(@NonNull Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.P(new FlowableOnErrorComplete(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> U5(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return T5(j2, timeUnit, Schedulers.a(), z);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> U6(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return V6(function, Y());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TOpening, TClosing> Flowable<List<T>> V(@NonNull Publisher<? extends TOpening> publisher, @NonNull Function<? super TOpening, ? extends Publisher<? extends TClosing>> function) {
        return W(publisher, function, ArrayListSupplier.c());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> V0(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableConcatMapScheduler(this, function, i2, ErrorMode.IMMEDIATE, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> V1() {
        return X1(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> V2(@NonNull Function<? super T, ? extends Stream<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableFlatMapStream(this, function, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> V4(@NonNull Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return RxJavaPlugins.P(new FlowableOnErrorNext(this, function));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> V5(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "sampler is null");
        return RxJavaPlugins.P(new FlowableSamplePublisher(this, publisher, false));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> V6(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        return R6(function, i2, true);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> W(@NonNull Publisher<? extends TOpening> publisher, @NonNull Function<? super TOpening, ? extends Publisher<? extends TClosing>> function, @NonNull Supplier<U> supplier) {
        Objects.requireNonNull(publisher, "openingIndicator is null");
        Objects.requireNonNull(function, "closingIndicator is null");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.P(new FlowableBufferBoundary(this, publisher, function, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable W0(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return X0(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> W1(@NonNull BiPredicate<? super T, ? super T> biPredicate) {
        Objects.requireNonNull(biPredicate, "comparer is null");
        return RxJavaPlugins.P(new FlowableDistinctUntilChanged(this, Functions.k(), biPredicate));
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable W2(@NonNull Consumer<? super T> consumer) {
        return G6(consumer);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> W3(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        return RxJavaPlugins.S(new FlowableLastSingle(this, t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> W4(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "fallback is null");
        return V4(Functions.n(publisher));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> W5(@NonNull Publisher<U> publisher, boolean z) {
        Objects.requireNonNull(publisher, "sampler is null");
        return RxJavaPlugins.P(new FlowableSamplePublisher(this, publisher, z));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> W6(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new FlowableSwitchMapMaybe(this, function, false));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> W7() {
        return Z7(TimeUnit.MILLISECONDS, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <B, U extends Collection<? super T>> Flowable<U> X(@NonNull Publisher<B> publisher, @NonNull Supplier<U> supplier) {
        Objects.requireNonNull(publisher, "boundaryIndicator is null");
        Objects.requireNonNull(supplier, "bufferSupplier is null");
        return RxJavaPlugins.P(new FlowableBufferExactBoundary(this, publisher, supplier));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable X0(@NonNull Function<? super T, ? extends CompletableSource> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.O(new FlowableConcatMapCompletable(this, function, ErrorMode.IMMEDIATE, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<T> X1(@NonNull Function<? super T, K> function) {
        Objects.requireNonNull(function, "keySelector is null");
        return RxJavaPlugins.P(new FlowableDistinctUntilChanged(this, function, ObjectHelper.a()));
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable X2(@NonNull Predicate<? super T> predicate) {
        return Z2(predicate, Functions.f28377f, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> X3() {
        return RxJavaPlugins.Q(new FlowableLastMaybe(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> X4(@NonNull Function<? super Throwable, ? extends T> function) {
        Objects.requireNonNull(function, "itemSupplier is null");
        return RxJavaPlugins.P(new FlowableOnErrorReturn(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> X5(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.P(new FlowableScan(this, biFunction));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> X6(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new FlowableSwitchMapMaybe(this, function, true));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> X7(@NonNull Scheduler scheduler) {
        return Z7(TimeUnit.MILLISECONDS, scheduler);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable Y0(@NonNull Function<? super T, ? extends CompletableSource> function) {
        return a1(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Y1(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterNext is null");
        return RxJavaPlugins.P(new FlowableDoAfterNext(this, consumer));
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable Y2(@NonNull Predicate<? super T> predicate, @NonNull Consumer<? super Throwable> consumer) {
        return Z2(predicate, consumer, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> Y3() {
        return RxJavaPlugins.S(new FlowableLastSingle(this, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Y4(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return X4(Functions.n(t));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> Y5(R r, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(r, "initialValue is null");
        return Z5(Functions.o(r), biFunction);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> Y6(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new FlowableSwitchMapSingle(this, function, false));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> Y7(@NonNull TimeUnit timeUnit) {
        return Z7(timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Z() {
        return a0(16);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable Z0(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z) {
        return a1(function, z, 2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Z1(@NonNull Action action) {
        return e2(Functions.h(), Functions.h(), Functions.f28374c, action);
    }

    @BackpressureSupport(BackpressureKind.NONE)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable Z2(@NonNull Predicate<? super T> predicate, @NonNull Consumer<? super Throwable> consumer, @NonNull Action action) {
        Objects.requireNonNull(predicate, "onNext is null");
        Objects.requireNonNull(consumer, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        ForEachWhileSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(predicate, consumer, action);
        J6(forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> Z3() {
        return a.a(N6(new FlowableLastStageSubscriber(false, null)));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> Z4() {
        return RxJavaPlugins.P(new FlowableDetach(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> Z5(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "seedSupplier is null");
        Objects.requireNonNull(biFunction, "accumulator is null");
        return RxJavaPlugins.P(new FlowableScanSeed(this, supplier, biFunction));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> Z6(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new FlowableSwitchMapSingle(this, function, true));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Timed<T>> Z7(@NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return c4(Functions.w(timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> a(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.S(new FlowableAllSingle(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> a0(int i2) {
        ObjectHelper.b(i2, "initialCapacity");
        return RxJavaPlugins.P(new FlowableCache(this, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable a1(@NonNull Function<? super T, ? extends CompletableSource> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.O(new FlowableConcatMapCompletable(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> a2(@NonNull Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.P(new FlowableDoFinally(this, action));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> a4(@Nullable T t) {
        return a.a(N6(new FlowableLastStageSubscriber(true, t)));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> a5() {
        return ParallelFlowable.C(this);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R a8(@NonNull FlowableConverter<T, ? extends R> flowableConverter) {
        Objects.requireNonNull(flowableConverter, "converter is null");
        return flowableConverter.b(this);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> b0(@NonNull Class<U> cls) {
        Objects.requireNonNull(cls, "clazz is null");
        return c4(Functions.e(cls));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> b1(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return c1(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> b2(@NonNull Action action) {
        return h2(Functions.h(), Functions.f28378g, action);
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> b4(@NonNull FlowableOperator<? extends R, ? super T> flowableOperator) {
        Objects.requireNonNull(flowableOperator, "lifter is null");
        return RxJavaPlugins.P(new FlowableLift(this, flowableOperator));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> b5(int i2) {
        return ParallelFlowable.D(this, i2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Future<T> b8() {
        return (Future) N6(new FutureSubscriber());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<U> c0(@NonNull Supplier<? extends U> supplier, @NonNull BiConsumer<? super U, ? super T> biConsumer) {
        Objects.requireNonNull(supplier, "initialItemSupplier is null");
        Objects.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.S(new FlowableCollectSingle(this, supplier, biConsumer));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> c1(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        if (this instanceof ScalarSupplier) {
            Object obj = ((ScalarSupplier) this).get();
            return obj == null ? p2() : FlowableScalarXMap.a(obj, function);
        }
        return RxJavaPlugins.P(new FlowableConcatMap(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> c2(@NonNull Action action) {
        return e2(Functions.h(), Functions.h(), action, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> c4(@NonNull Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new FlowableMap(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> c5(int i2, int i3) {
        return ParallelFlowable.E(this, i2, i3);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> c8() {
        return RxJavaPlugins.S(new FlowableToListSingle(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> d(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return c(this, publisher);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R, A> Single<R> d0(@NonNull Collector<T, A, R> collector) {
        Objects.requireNonNull(collector, "collector is null");
        return RxJavaPlugins.S(new FlowableCollectWithCollectorSingle(this, collector));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> d1(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableConcatMapScheduler(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY, scheduler));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> d2(@NonNull Consumer<? super Notification<T>> consumer) {
        Objects.requireNonNull(consumer, "onNotification is null");
        return e2(Functions.t(consumer), Functions.s(consumer), Functions.r(consumer), Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> d4(@NonNull Function<? super T, Optional<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.P(new FlowableMapOptional(this, function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> d5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        return e5(function, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> d8(int i2) {
        ObjectHelper.b(i2, "capacityHint");
        return RxJavaPlugins.S(new FlowableToListSingle(this, Functions.f(i2)));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public final void e(@NonNull Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            J6((FlowableSubscriber) subscriber);
            return;
        }
        Objects.requireNonNull(subscriber, "subscriber is null");
        J6(new StrictSubscriber(subscriber));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Single<U> e0(U u, @NonNull BiConsumer<? super U, ? super T> biConsumer) {
        Objects.requireNonNull(u, "initialItem is null");
        return c0(Functions.o(u), biConsumer);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> e1(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return f1(function, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Notification<T>> e4() {
        return RxJavaPlugins.P(new FlowableMaterialize(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> e5(@NonNull Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowablePublishMulticast(this, function, i2, false));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> e6() {
        return RxJavaPlugins.P(new FlowableSerialized(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> e7(long j2) {
        if (j2 >= 0) {
            return RxJavaPlugins.P(new FlowableTake(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U extends Collection<? super T>> Single<U> e8(@NonNull Supplier<U> supplier) {
        Objects.requireNonNull(supplier, "collectionSupplier is null");
        return RxJavaPlugins.S(new FlowableToListSingle(this, supplier));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<Boolean> f(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.S(new FlowableAnySingle(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> f1(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapEager(this, function, i2, i3, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> f2(@NonNull Subscriber<? super T> subscriber) {
        Objects.requireNonNull(subscriber, "subscriber is null");
        return e2(FlowableInternalHelper.l(subscriber), FlowableInternalHelper.k(subscriber), FlowableInternalHelper.j(subscriber), Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> f5() {
        return g5(Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> f6() {
        return f5().o9();
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> f7(long j2, @NonNull TimeUnit timeUnit) {
        return r7(U7(j2, timeUnit));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Single<Map<K, T>> f8(@NonNull Function<? super T, ? extends K> function) {
        Objects.requireNonNull(function, "keySelector is null");
        return c0(HashMapSupplier.a(), Functions.F(function));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> f9(@NonNull Iterable<U> iterable, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(iterable, "other is null");
        Objects.requireNonNull(biFunction, "zipper is null");
        return RxJavaPlugins.P(new FlowableZipIterable(this, iterable, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> g1(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return h1(function, z, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> g2(@NonNull Consumer<? super Throwable> consumer) {
        Consumer h2 = Functions.h();
        Action action = Functions.f28374c;
        return e2(h2, consumer, action, action);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ConnectableFlowable<T> g5(int i2) {
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.T(new FlowablePublish(this, i2));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> g6(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        return RxJavaPlugins.S(new FlowableSingleSingle(this, t));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> g7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return r7(V7(j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> g8(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        return c0(HashMapSupplier.a(), Functions.G(function, function2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> g9(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction) {
        Objects.requireNonNull(publisher, "other is null");
        return U8(this, publisher, biFunction);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> h1(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapEager(this, function, i2, i3, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> h2(@NonNull Consumer<? super Subscription> consumer, @NonNull LongConsumer longConsumer, @NonNull Action action) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Objects.requireNonNull(longConsumer, "onRequest is null");
        Objects.requireNonNull(action, "onCancel is null");
        return RxJavaPlugins.P(new FlowableDoOnLifecycle(this, consumer, longConsumer, action));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> h6() {
        return RxJavaPlugins.Q(new FlowableSingleMaybe(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> h7(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i2);
        } else if (i2 == 0) {
            return RxJavaPlugins.P(new FlowableIgnoreElements(this));
        } else {
            return i2 == 1 ? RxJavaPlugins.P(new FlowableTakeLastOne(this)) : RxJavaPlugins.P(new FlowableTakeLast(this, i2));
        }
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, V>> h8(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<? extends Map<K, V>> supplier) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        return c0(supplier, Functions.G(function, function2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> h9(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return V8(this, publisher, biFunction, z);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T i() {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        J6(blockingFirstSubscriber);
        T a2 = blockingFirstSubscriber.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> i1(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        return j1(function, 2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> i2(@NonNull Consumer<? super T> consumer) {
        Consumer h2 = Functions.h();
        Action action = Functions.f28374c;
        return e2(consumer, h2, action, action);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> i6() {
        return RxJavaPlugins.S(new FlowableSingleSingle(this, null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> i7(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return k7(j2, j3, timeUnit, Schedulers.a(), false, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Single<Map<K, Collection<T>>> i8(@NonNull Function<? super T, ? extends K> function) {
        return l8(function, Functions.k(), HashMapSupplier.a(), ArrayListSupplier.b());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U, R> Flowable<R> i9(@NonNull Publisher<? extends U> publisher, @NonNull BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i2) {
        return W8(this, publisher, biFunction, z, i2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T j(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        J6(blockingFirstSubscriber);
        T a2 = blockingFirstSubscriber.a();
        return a2 != null ? a2 : t;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<U> j1(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableFlattenIterable(this, function, i2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> j2(@NonNull LongConsumer longConsumer) {
        return h2(Functions.h(), longConsumer, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> j5(int i2) {
        return G4(ImmediateThinScheduler.X, true, i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> j6() {
        return a.a(N6(new FlowableSingleStageSubscriber(false, null)));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> j7(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return k7(j2, j3, timeUnit, scheduler, false, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> j8(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2) {
        return l8(function, function2, HashMapSupplier.a(), ArrayListSupplier.b());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void k(@NonNull Consumer<? super T> consumer) {
        l(consumer, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> k1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return l1(function, 2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> k2(@NonNull Consumer<? super Subscription> consumer) {
        return h2(consumer, Functions.f28378g, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> k5(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.Q(new FlowableReduceMaybe(this, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> k6(@Nullable T t) {
        return a.a(N6(new FlowableSingleStageSubscriber(true, t)));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> k7(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z, int i2) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        if (j2 >= 0) {
            return RxJavaPlugins.P(new FlowableTakeLastTimed(this, j2, j3, timeUnit, scheduler, i2, z));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> k8(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<Map<K, Collection<V>>> supplier) {
        return l8(function, function2, supplier, ArrayListSupplier.b());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    public final void l(@NonNull Consumer<? super T> consumer, int i2) {
        Objects.requireNonNull(consumer, "onNext is null");
        Iterator it2 = p(i2).iterator();
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

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> l1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapMaybe(this, function, ErrorMode.IMMEDIATE, i2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> l2(@NonNull Action action) {
        return e2(Functions.h(), Functions.a(action), action, Functions.f28374c);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> l5(R r, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(r, "seed is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.S(new FlowableReduceSeedSingle(this, r, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> l6(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? RxJavaPlugins.P(this) : RxJavaPlugins.P(new FlowableSkip(this, j2));
        }
        throw new IllegalArgumentException("count >= 0 expected but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> l7(long j2, @NonNull TimeUnit timeUnit) {
        return o7(j2, timeUnit, Schedulers.a(), false, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Single<Map<K, Collection<V>>> l8(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, @NonNull Supplier<? extends Map<K, Collection<V>>> supplier, @NonNull Function<? super K, ? extends Collection<? super V>> function3) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        Objects.requireNonNull(supplier, "mapSupplier is null");
        Objects.requireNonNull(function3, "collectionFactory is null");
        return c0(supplier, Functions.H(function, function2, function3));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> m1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return o1(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> m2(long j2) {
        if (j2 >= 0) {
            return RxJavaPlugins.Q(new FlowableElementAtMaybe(this, j2));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Single<R> m5(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "seedSupplier is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.S(new FlowableReduceWithSingle(this, supplier, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> m6(long j2, @NonNull TimeUnit timeUnit) {
        return u6(U7(j2, timeUnit));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> m7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return o7(j2, timeUnit, scheduler, false, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Observable<T> m8() {
        return RxJavaPlugins.R(new ObservableFromPublisher(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> n() {
        return p(Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> n1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        return o1(function, z, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> n2(long j2, @NonNull T t) {
        if (j2 >= 0) {
            Objects.requireNonNull(t, "defaultItem is null");
            return RxJavaPlugins.S(new FlowableElementAtSingle(this, j2, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> n5() {
        return o5(Long.MAX_VALUE);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> n6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return u6(V7(j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> n7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        return o7(j2, timeUnit, scheduler, z, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> n8() {
        return p8(Functions.q());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> o1(@NonNull Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapMaybe(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> o2(long j2) {
        if (j2 >= 0) {
            return RxJavaPlugins.S(new FlowableElementAtSingle(this, j2, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> o5(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 >= 0) {
            return i2 == 0 ? p2() : RxJavaPlugins.P(new FlowableRepeat(this, j2));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> o6(int i2) {
        if (i2 >= 0) {
            return i2 == 0 ? RxJavaPlugins.P(this) : RxJavaPlugins.P(new FlowableSkipLast(this, i2));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> o7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z, int i2) {
        return k7(Long.MAX_VALUE, j2, timeUnit, scheduler, z, i2);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> o8(int i2) {
        return q8(Functions.q(), i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> p(int i2) {
        ObjectHelper.b(i2, "bufferSize");
        return new BlockingFlowableIterable(this, i2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> p1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return q1(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> p5(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return RxJavaPlugins.P(new FlowableRepeatUntil(this, booleanSupplier));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> p6(long j2, @NonNull TimeUnit timeUnit) {
        return s6(j2, timeUnit, Schedulers.a(), false, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> p7(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return o7(j2, timeUnit, Schedulers.a(), z, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> p8(@NonNull Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return c8().R0(Functions.p(comparator));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T q() {
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        J6(blockingLastSubscriber);
        T a2 = blockingLastSubscriber.a();
        if (a2 != null) {
            return a2;
        }
        throw new NoSuchElementException();
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> q1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapSingle(this, function, ErrorMode.IMMEDIATE, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> q5(@NonNull Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        Objects.requireNonNull(function, "handler is null");
        return RxJavaPlugins.P(new FlowableRepeatWhen(this, function));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> q6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return s6(j2, timeUnit, scheduler, false, Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> q7(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "stopPredicate is null");
        return RxJavaPlugins.P(new FlowableTakeUntilPredicate(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<List<T>> q8(@NonNull Comparator<? super T> comparator, int i2) {
        Objects.requireNonNull(comparator, "comparator is null");
        return d8(i2).R0(Functions.p(comparator));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T r(@NonNull T t) {
        Objects.requireNonNull(t, "defaultItem is null");
        BlockingLastSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        J6(blockingLastSubscriber);
        T a2 = blockingLastSubscriber.a();
        return a2 != null ? a2 : t;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> r1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function) {
        return t1(function, true, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> r5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        Objects.requireNonNull(function, "selector is null");
        return FlowableReplay.A9(FlowableInternalHelper.d(this), function);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> r6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        return s6(j2, timeUnit, scheduler, z, Y());
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> r7(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.P(new FlowableTakeUntil(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> s() {
        return new BlockingFlowableLatest(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> s1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        return t1(function, z, 2);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> s2(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.P(new FlowableFilter(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> s5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.b(i2, "bufferSize");
        return FlowableReplay.A9(FlowableInternalHelper.f(this, i2, false), function);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> s6(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z, int i2) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableSkipLastTimed(this, j2, timeUnit, scheduler, i2 << 1, z));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> s7(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.P(new FlowableTakeWhile(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> s8(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableUnsubscribeOn(this, scheduler));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> t(@NonNull T t) {
        Objects.requireNonNull(t, "initialItem is null");
        return new BlockingFlowableMostRecent(this, t);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> t1(@NonNull Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableConcatMapSingle(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> t2(@NonNull T t) {
        return n2(0, t);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> t5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2, long j2, @NonNull TimeUnit timeUnit) {
        return u5(function, i2, j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> t6(long j2, @NonNull TimeUnit timeUnit, boolean z) {
        return s6(j2, timeUnit, Schedulers.a(), z, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestSubscriber<T> t7() {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>();
        J6(testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Iterable<T> u() {
        return new BlockingFlowableNext(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> u1(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        return V2(function, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Maybe<T> u2() {
        return m2(0);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> u5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.A9(FlowableInternalHelper.e(this, i2, j2, timeUnit, scheduler, false), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> Flowable<T> u6(@NonNull Publisher<U> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return RxJavaPlugins.P(new FlowableSkipUntil(this, publisher));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestSubscriber<T> u7(long j2) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j2);
        J6(testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T v() {
        return i6().j();
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> v0(@NonNull FlowableTransformer<? super T, ? extends R> flowableTransformer) {
        Objects.requireNonNull(flowableTransformer, "composer is null");
        return l3(flowableTransformer.b(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> v1(@NonNull Function<? super T, ? extends Stream<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new FlowableFlatMapStream(this, function, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Single<T> v2() {
        return o2(0);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K> Flowable<GroupedFlowable<K, T>> v3(@NonNull Function<? super T, ? extends K> function) {
        return y3(function, Functions.k(), false, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> v5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.A9(FlowableInternalHelper.e(this, i2, j2, timeUnit, scheduler, z), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> v6(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.P(new FlowableSkipWhile(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestSubscriber<T> v7(long j2, boolean z) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j2);
        if (z) {
            testSubscriber.cancel();
        }
        J6(testSubscriber);
        return testSubscriber;
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> v8(long j2) {
        return x8(j2, j2, Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final T w(@NonNull T t) {
        return g6(t).j();
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> w1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.P(new FlowableConcatWithCompletable(this, completableSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> w2() {
        return a.a(N6(new FlowableFirstStageSubscriber(false, null)));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> w3(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2) {
        return y3(function, function2, false, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> w5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, int i2, boolean z) {
        Objects.requireNonNull(function, "selector is null");
        ObjectHelper.b(i2, "bufferSize");
        return FlowableReplay.A9(FlowableInternalHelper.f(this, i2, z), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> w6() {
        return c8().p2().c4(Functions.p(Functions.q())).M2(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> w7(long j2, @NonNull TimeUnit timeUnit) {
        return x7(j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> w8(long j2, long j3) {
        return x8(j2, j3, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Stream<T> x() {
        return y(Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> x1(@NonNull MaybeSource<? extends T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return RxJavaPlugins.P(new FlowableConcatWithMaybe(this, maybeSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final CompletionStage<T> x2(@Nullable T t) {
        return a.a(N6(new FlowableFirstStageSubscriber(true, t)));
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> x3(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z) {
        return y3(function, function2, z, Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> x5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, long j2, @NonNull TimeUnit timeUnit) {
        return y5(function, j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> x6(@NonNull Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "comparator is null");
        return c8().p2().c4(Functions.p(comparator)).M2(Functions.k());
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> x7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.P(new FlowableThrottleFirstTimed(this, j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> x8(long j2, long j3, int i2) {
        ObjectHelper.c(j3, "skip");
        ObjectHelper.c(j2, "count");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableWindow(this, j2, j3, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Stream<T> y(int i2) {
        Iterator it2 = p(i2).iterator();
        Stream a2 = StreamSupport.stream(Spliterators.spliteratorUnknownSize(it2, 0), false);
        Disposable disposable = (Disposable) it2;
        disposable.getClass();
        return e.a(a2.onClose(new h(disposable)));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> y1(@NonNull SingleSource<? extends T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return RxJavaPlugins.P(new FlowableConcatWithSingle(this, singleSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> y2(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return J2(function, false, Y(), Y());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> y3(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z, int i2) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.P(new FlowableGroupBy(this, function, function2, i2, z, (Function) null));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> y5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.A9(FlowableInternalHelper.g(this, j2, timeUnit, scheduler, false), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> y6(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return z0(Completable.B1(completableSource).q1(), this);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> y7(long j2, @NonNull TimeUnit timeUnit) {
        return R5(j2, timeUnit);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> y8(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return A8(j2, j3, timeUnit, Schedulers.a(), Y());
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    public final void z() {
        FlowableBlockingSubscribe.a(this);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> z1(@NonNull Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return z0(this, publisher);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> z2(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        return J2(function, false, i2, Y());
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <K, V> Flowable<GroupedFlowable<K, V>> z3(@NonNull Function<? super T, ? extends K> function, @NonNull Function<? super T, ? extends V> function2, boolean z, int i2, @NonNull Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        Objects.requireNonNull(function, "keySelector is null");
        Objects.requireNonNull(function2, "valueSelector is null");
        ObjectHelper.b(i2, "bufferSize");
        Objects.requireNonNull(function3, "evictingMapFactory is null");
        return RxJavaPlugins.P(new FlowableGroupBy(this, function, function2, i2, z, function3));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> z4(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.P(new FlowableMergeWithCompletable(this, completableSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final <R> Flowable<R> z5(@NonNull Function<? super Flowable<T>, ? extends Publisher<R>> function, long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(function, "selector is null");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return FlowableReplay.A9(FlowableInternalHelper.g(this, j2, timeUnit, scheduler, z), function);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> z6(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return z0(Maybe.K2(maybeSource).C2(), this);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> z7(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return S5(j2, timeUnit, scheduler);
    }

    @BackpressureSupport(BackpressureKind.ERROR)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Flowable<Flowable<T>> z8(long j2, long j3, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return A8(j2, j3, timeUnit, scheduler, Y());
    }
}
