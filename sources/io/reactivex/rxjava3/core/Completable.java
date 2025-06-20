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
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.fuseable.FuseToFlowable;
import io.reactivex.rxjava3.internal.fuseable.FuseToMaybe;
import io.reactivex.rxjava3.internal.fuseable.FuseToObservable;
import io.reactivex.rxjava3.internal.jdk8.CompletableFromCompletionStage;
import io.reactivex.rxjava3.internal.jdk8.CompletionStageConsumer;
import io.reactivex.rxjava3.internal.observers.BlockingDisposableMultiObserver;
import io.reactivex.rxjava3.internal.observers.BlockingMultiObserver;
import io.reactivex.rxjava3.internal.observers.CallbackCompletableObserver;
import io.reactivex.rxjava3.internal.observers.EmptyCompletableObserver;
import io.reactivex.rxjava3.internal.observers.FutureMultiObserver;
import io.reactivex.rxjava3.internal.observers.SafeCompletableObserver;
import io.reactivex.rxjava3.internal.operators.completable.CompletableAmb;
import io.reactivex.rxjava3.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableCache;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcat;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcatArray;
import io.reactivex.rxjava3.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableCreate;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDefer;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDelay;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDetach;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDoFinally;
import io.reactivex.rxjava3.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.rxjava3.internal.operators.completable.CompletableEmpty;
import io.reactivex.rxjava3.internal.operators.completable.CompletableError;
import io.reactivex.rxjava3.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromAction;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromCallable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromObservable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromSingle;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromSupplier;
import io.reactivex.rxjava3.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.rxjava3.internal.operators.completable.CompletableHide;
import io.reactivex.rxjava3.internal.operators.completable.CompletableLift;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMaterialize;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMerge;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArray;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeArrayDelayError;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableNever;
import io.reactivex.rxjava3.internal.operators.completable.CompletableObserveOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.rxjava3.internal.operators.completable.CompletableOnErrorReturn;
import io.reactivex.rxjava3.internal.operators.completable.CompletablePeek;
import io.reactivex.rxjava3.internal.operators.completable.CompletableResumeNext;
import io.reactivex.rxjava3.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTimeout;
import io.reactivex.rxjava3.internal.operators.completable.CompletableTimer;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToFlowable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToObservable;
import io.reactivex.rxjava3.internal.operators.completable.CompletableToSingle;
import io.reactivex.rxjava3.internal.operators.completable.CompletableUsing;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.rxjava3.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.rxjava3.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapCompletablePublisher;
import io.reactivex.rxjava3.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.rxjava3.observers.TestObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Completable implements CompletableSource {
    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable A(@NonNull CompletableSource... completableSourceArr) {
        return Flowable.b3(completableSourceArr).a1(Functions.k(), true, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <R> Completable A1(@NonNull Supplier<R> supplier, @NonNull Function<? super R, ? extends CompletableSource> function, @NonNull Consumer<? super R> consumer, boolean z) {
        Objects.requireNonNull(supplier, "resourceSupplier is null");
        Objects.requireNonNull(function, "sourceSupplier is null");
        Objects.requireNonNull(consumer, "resourceCleanup is null");
        return RxJavaPlugins.O(new CompletableUsing(supplier, function, consumer, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable B(@NonNull Iterable<? extends CompletableSource> iterable) {
        return Flowable.h3(iterable).Y0(Functions.k());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable B1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "source is null");
        return completableSource instanceof Completable ? RxJavaPlugins.O((Completable) completableSource) : RxJavaPlugins.O(new CompletableFromUnsafeSource(completableSource));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable C(@NonNull Publisher<? extends CompletableSource> publisher) {
        return D(publisher, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable D(@NonNull Publisher<? extends CompletableSource> publisher, int i2) {
        return Flowable.l3(publisher).a1(Functions.k(), true, i2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable F(@NonNull CompletableOnSubscribe completableOnSubscribe) {
        Objects.requireNonNull(completableOnSubscribe, "source is null");
        return RxJavaPlugins.O(new CompletableCreate(completableOnSubscribe));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable G(@NonNull Supplier<? extends CompletableSource> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.O(new CompletableDefer(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Single<Boolean> Q0(@NonNull CompletableSource completableSource, @NonNull CompletableSource completableSource2) {
        Objects.requireNonNull(completableSource, "source1 is null");
        Objects.requireNonNull(completableSource2, "source2 is null");
        return q0(completableSource, completableSource2).m(Single.P0(Boolean.TRUE));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    private Completable T(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(action2, "onTerminate is null");
        Objects.requireNonNull(action3, "onAfterTerminate is null");
        Objects.requireNonNull(action4, "onDispose is null");
        return RxJavaPlugins.O(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable W(@NonNull Supplier<? extends Throwable> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.O(new CompletableErrorSupplier(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable X(@NonNull Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return RxJavaPlugins.O(new CompletableError(th));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable Y(@NonNull Action action) {
        Objects.requireNonNull(action, "action is null");
        return RxJavaPlugins.O(new CompletableFromAction(action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable Z(@NonNull Callable<?> callable) {
        Objects.requireNonNull(callable, "callable is null");
        return RxJavaPlugins.O(new CompletableFromCallable(callable));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable a0(@NonNull CompletionStage<?> completionStage) {
        Objects.requireNonNull(completionStage, "stage is null");
        return RxJavaPlugins.O(new CompletableFromCompletionStage(completionStage));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable b0(@NonNull Future<?> future) {
        Objects.requireNonNull(future, "future is null");
        return Y(Functions.j(future));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable c0(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "maybe is null");
        return RxJavaPlugins.O(new MaybeIgnoreElementCompletable(maybeSource));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable c1(@NonNull Publisher<? extends CompletableSource> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.O(new FlowableSwitchMapCompletablePublisher(publisher, Functions.k(), false));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable d0(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "observable is null");
        return RxJavaPlugins.O(new CompletableFromObservable(observableSource));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable d1(@NonNull Publisher<? extends CompletableSource> publisher) {
        Objects.requireNonNull(publisher, "sources is null");
        return RxJavaPlugins.O(new FlowableSwitchMapCompletablePublisher(publisher, Functions.k(), true));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable e(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.O(new CompletableAmb((CompletableSource[]) null, iterable));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable e0(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "publisher is null");
        return RxJavaPlugins.O(new CompletableFromPublisher(publisher));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable f0(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return RxJavaPlugins.O(new CompletableFromRunnable(runnable));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable g(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return u();
        }
        return completableSourceArr.length == 1 ? B1(completableSourceArr[0]) : RxJavaPlugins.O(new CompletableAmb(completableSourceArr, (Iterable<? extends CompletableSource>) null));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> Completable g0(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "single is null");
        return RxJavaPlugins.O(new CompletableFromSingle(singleSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable h0(@NonNull Supplier<?> supplier) {
        Objects.requireNonNull(supplier, "supplier is null");
        return RxJavaPlugins.O(new CompletableFromSupplier(supplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable l0(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.O(new CompletableMergeIterable(iterable));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    private Completable l1(long j2, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.O(new CompletableTimeout(this, j2, timeUnit, scheduler, completableSource));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable m0(@NonNull Publisher<? extends CompletableSource> publisher) {
        return o0(publisher, Integer.MAX_VALUE, false);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public static Completable m1(long j2, @NonNull TimeUnit timeUnit) {
        return n1(j2, timeUnit, Schedulers.a());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable n0(@NonNull Publisher<? extends CompletableSource> publisher, int i2) {
        return o0(publisher, i2, false);
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public static Completable n1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.O(new CompletableTimer(j2, timeUnit, scheduler));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    private static Completable o0(@NonNull Publisher<? extends CompletableSource> publisher, int i2, boolean z) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "maxConcurrency");
        return RxJavaPlugins.O(new CompletableMerge(publisher, i2, z));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable p0(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return u();
        }
        return completableSourceArr.length == 1 ? B1(completableSourceArr[0]) : RxJavaPlugins.O(new CompletableMergeArray(completableSourceArr));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable q0(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        return RxJavaPlugins.O(new CompletableMergeArrayDelayError(completableSourceArr));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable r0(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.O(new CompletableMergeDelayErrorIterable(iterable));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable s0(@NonNull Publisher<? extends CompletableSource> publisher) {
        return o0(publisher, Integer.MAX_VALUE, true);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable t0(@NonNull Publisher<? extends CompletableSource> publisher, int i2) {
        return o0(publisher, i2, true);
    }

    private static NullPointerException t1(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable u() {
        return RxJavaPlugins.O(CompletableEmpty.s);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public static Completable v0() {
        return RxJavaPlugins.O(CompletableNever.s);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable w(@NonNull Iterable<? extends CompletableSource> iterable) {
        Objects.requireNonNull(iterable, "sources is null");
        return RxJavaPlugins.O(new CompletableConcatIterable(iterable));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable x(@NonNull Publisher<? extends CompletableSource> publisher) {
        return y(publisher, 2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable x1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "onSubscribe is null");
        if (!(completableSource instanceof Completable)) {
            return RxJavaPlugins.O(new CompletableFromUnsafeSource(completableSource));
        }
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static Completable y(@NonNull Publisher<? extends CompletableSource> publisher, int i2) {
        Objects.requireNonNull(publisher, "sources is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.O(new CompletableConcat(publisher, i2));
    }

    @SchedulerSupport("none")
    @SafeVarargs
    @NonNull
    @CheckReturnValue
    public static Completable z(@NonNull CompletableSource... completableSourceArr) {
        Objects.requireNonNull(completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return u();
        }
        return completableSourceArr.length == 1 ? B1(completableSourceArr[0]) : RxJavaPlugins.O(new CompletableConcatArray(completableSourceArr));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <R> Completable z1(@NonNull Supplier<R> supplier, @NonNull Function<? super R, ? extends CompletableSource> function, @NonNull Consumer<? super R> consumer) {
        return A1(supplier, function, consumer, true);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable A0(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "fallback is null");
        return z0(Functions.n(completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> B0(@NonNull Function<? super Throwable, ? extends T> function) {
        Objects.requireNonNull(function, "itemSupplier is null");
        return RxJavaPlugins.Q(new CompletableOnErrorReturn(this, function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> C0(@NonNull T t) {
        Objects.requireNonNull(t, "item is null");
        return B0(Functions.n(t));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable D0() {
        return RxJavaPlugins.O(new CompletableDetach(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable E(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.O(new CompletableAndThenCompletable(this, completableSource));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable E0() {
        return e0(q1().n5());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable F0(long j2) {
        return e0(q1().o5(j2));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable G0(@NonNull BooleanSupplier booleanSupplier) {
        return e0(q1().p5(booleanSupplier));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Completable H(long j2, @NonNull TimeUnit timeUnit) {
        return J(j2, timeUnit, Schedulers.a(), false);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable H0(@NonNull Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return e0(q1().q5(function));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable I(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return J(j2, timeUnit, scheduler, false);
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable I0() {
        return e0(q1().J5());
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable J(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, boolean z) {
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.O(new CompletableDelay(this, j2, timeUnit, scheduler, z));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable J0(long j2) {
        return e0(q1().K5(j2));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Completable K(long j2, @NonNull TimeUnit timeUnit) {
        return L(j2, timeUnit, Schedulers.a());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable K0(long j2, @NonNull Predicate<? super Throwable> predicate) {
        return e0(q1().L5(j2, predicate));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable L(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return n1(j2, timeUnit, scheduler).i(this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable L0(@NonNull BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return e0(q1().M5(biPredicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable M(@NonNull Action action) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action2 = Functions.f28374c;
        return T(h2, h3, action2, action2, action, action2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable M0(@NonNull Predicate<? super Throwable> predicate) {
        return e0(q1().N5(predicate));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable N(@NonNull Action action) {
        Objects.requireNonNull(action, "onFinally is null");
        return RxJavaPlugins.O(new CompletableDoFinally(this, action));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable N0(@NonNull BooleanSupplier booleanSupplier) {
        Objects.requireNonNull(booleanSupplier, "stop is null");
        return K0(Long.MAX_VALUE, Functions.v(booleanSupplier));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable O(@NonNull Action action) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action2 = Functions.f28374c;
        return T(h2, h3, action, action2, action2, action2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable O0(@NonNull Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return e0(q1().P5(function));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable P(@NonNull Action action) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action2 = Functions.f28374c;
        return T(h2, h3, action2, action2, action2, action);
    }

    @SchedulerSupport("none")
    public final void P0(@NonNull CompletableObserver completableObserver) {
        Objects.requireNonNull(completableObserver, "observer is null");
        a(new SafeCompletableObserver(completableObserver));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable Q(@NonNull Consumer<? super Throwable> consumer) {
        Consumer h2 = Functions.h();
        Action action = Functions.f28374c;
        return T(h2, consumer, action, action, action, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable R(@NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onEvent is null");
        return RxJavaPlugins.O(new CompletableDoOnEvent(this, consumer));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable R0(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return z(completableSource, this);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable S(@NonNull Consumer<? super Disposable> consumer, @NonNull Action action) {
        Consumer h2 = Functions.h();
        Action action2 = Functions.f28374c;
        return T(consumer, h2, action2, action2, action2, action);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> S0(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "other is null");
        return Flowable.z0(Maybe.K2(maybeSource).C2(), q1());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> T0(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "other is null");
        return Flowable.z0(Single.y2(singleSource).p2(), q1());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable U(@NonNull Consumer<? super Disposable> consumer) {
        Consumer h2 = Functions.h();
        Action action = Functions.f28374c;
        return T(consumer, h2, action, action, action, action);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> U0(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "other is null");
        return q1().B6(publisher);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable V(@NonNull Action action) {
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action2 = Functions.f28374c;
        return T(h2, h3, action2, action, action2, action2);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Observable<T> V0(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "other is null");
        return Observable.l8(observableSource).s1(u1());
    }

    @NonNull
    @SchedulerSupport("none")
    public final Disposable W0() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        a(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable X0(@NonNull Action action) {
        Objects.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Disposable Y0(@NonNull Action action, @NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        a(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    /* access modifiers changed from: protected */
    public abstract void Z0(@NonNull CompletableObserver completableObserver);

    @SchedulerSupport("none")
    public final void a(@NonNull CompletableObserver completableObserver) {
        Objects.requireNonNull(completableObserver, "observer is null");
        try {
            CompletableObserver d0 = RxJavaPlugins.d0(this, completableObserver);
            Objects.requireNonNull(d0, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            Z0(d0);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
            throw t1(th);
        }
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable a1(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.O(new CompletableSubscribeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <E extends CompletableObserver> E b1(E e2) {
        a(e2);
        return e2;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable e1(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return RxJavaPlugins.O(new CompletableTakeUntilCompletable(this, completableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<Void> f1() {
        TestObserver<Void> testObserver = new TestObserver<>();
        a(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final TestObserver<Void> g1(boolean z) {
        TestObserver<Void> testObserver = new TestObserver<>();
        if (z) {
            testObserver.m();
        }
        a(testObserver);
        return testObserver;
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable h(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return g(this, completableSource);
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Completable h1(long j2, @NonNull TimeUnit timeUnit) {
        return l1(j2, timeUnit, Schedulers.a(), (CompletableSource) null);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable i(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "next is null");
        return RxJavaPlugins.O(new CompletableAndThenCompletable(this, completableSource));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable i0() {
        return RxJavaPlugins.O(new CompletableHide(this));
    }

    @SchedulerSupport("io.reactivex:computation")
    @NonNull
    @CheckReturnValue
    public final Completable i1(long j2, @NonNull TimeUnit timeUnit, @NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "fallback is null");
        return l1(j2, timeUnit, Schedulers.a(), completableSource);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> j(@NonNull Publisher<T> publisher) {
        Objects.requireNonNull(publisher, "next is null");
        return RxJavaPlugins.P(new CompletableAndThenPublisher(this, publisher));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable j0(@NonNull CompletableOperator completableOperator) {
        Objects.requireNonNull(completableOperator, "onLift is null");
        return RxJavaPlugins.O(new CompletableLift(this, completableOperator));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable j1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        return l1(j2, timeUnit, scheduler, (CompletableSource) null);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> k(@NonNull MaybeSource<T> maybeSource) {
        Objects.requireNonNull(maybeSource, "next is null");
        return RxJavaPlugins.Q(new MaybeDelayWithCompletable(maybeSource, this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<Notification<T>> k0() {
        return RxJavaPlugins.S(new CompletableMaterialize(this));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable k1(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, @NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "fallback is null");
        return l1(j2, timeUnit, scheduler, completableSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Observable<T> l(@NonNull ObservableSource<T> observableSource) {
        Objects.requireNonNull(observableSource, "next is null");
        return RxJavaPlugins.R(new CompletableAndThenObservable(this, observableSource));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<T> m(@NonNull SingleSource<T> singleSource) {
        Objects.requireNonNull(singleSource, "next is null");
        return RxJavaPlugins.S(new SingleDelayWithCompletable(singleSource, this));
    }

    @SchedulerSupport("none")
    public final void n() {
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        a(blockingMultiObserver);
        blockingMultiObserver.e();
    }

    @CheckReturnValue
    @SchedulerSupport("none")
    public final boolean o(long j2, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        a(blockingMultiObserver);
        return blockingMultiObserver.c(j2, timeUnit);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R o1(@NonNull CompletableConverter<? extends R> completableConverter) {
        Objects.requireNonNull(completableConverter, "converter is null");
        return completableConverter.e(this);
    }

    @SchedulerSupport("none")
    public final void p() {
        s(Functions.f28374c, Functions.f28376e);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> CompletionStage<T> p1(@Nullable T t) {
        return a.a(b1(new CompletionStageConsumer(true, t)));
    }

    @SchedulerSupport("none")
    public final void q(@NonNull CompletableObserver completableObserver) {
        Objects.requireNonNull(completableObserver, "observer is null");
        BlockingDisposableMultiObserver blockingDisposableMultiObserver = new BlockingDisposableMultiObserver();
        completableObserver.b(blockingDisposableMultiObserver);
        a(blockingDisposableMultiObserver);
        blockingDisposableMultiObserver.c(completableObserver);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Flowable<T> q1() {
        return this instanceof FuseToFlowable ? ((FuseToFlowable) this).f() : RxJavaPlugins.P(new CompletableToFlowable(this));
    }

    @SchedulerSupport("none")
    public final void r(@NonNull Action action) {
        s(action, Functions.f28376e);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Future<Void> r1() {
        return (Future) b1(new FutureMultiObserver());
    }

    @SchedulerSupport("none")
    public final void s(@NonNull Action action, @NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(action, "onComplete is null");
        Objects.requireNonNull(consumer, "onError is null");
        BlockingMultiObserver blockingMultiObserver = new BlockingMultiObserver();
        a(blockingMultiObserver);
        blockingMultiObserver.d(Functions.h(), consumer, action);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Maybe<T> s1() {
        return this instanceof FuseToMaybe ? ((FuseToMaybe) this).d() : RxJavaPlugins.Q(new MaybeFromCompletable(this));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable t() {
        return RxJavaPlugins.O(new CompletableCache(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable u0(@NonNull CompletableSource completableSource) {
        Objects.requireNonNull(completableSource, "other is null");
        return p0(this, completableSource);
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Observable<T> u1() {
        return this instanceof FuseToObservable ? ((FuseToObservable) this).c() : RxJavaPlugins.R(new CompletableToObservable(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable v(@NonNull CompletableTransformer completableTransformer) {
        Objects.requireNonNull(completableTransformer, "transformer is null");
        return B1(completableTransformer.e(this));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<T> v1(@NonNull Supplier<? extends T> supplier) {
        Objects.requireNonNull(supplier, "completionValueSupplier is null");
        return RxJavaPlugins.S(new CompletableToSingle(this, supplier, null));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable w0(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.O(new CompletableObserveOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <T> Single<T> w1(T t) {
        Objects.requireNonNull(t, "completionValue is null");
        return RxJavaPlugins.S(new CompletableToSingle(this, (Supplier) null, t));
    }

    @NonNull
    @CheckReturnValue
    @SchedulerSupport("none")
    public final Completable x0() {
        return y0(Functions.c());
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable y0(@NonNull Predicate<? super Throwable> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.O(new CompletableOnErrorComplete(this, predicate));
    }

    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final Completable y1(@NonNull Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return RxJavaPlugins.O(new CompletableDisposeOn(this, scheduler));
    }

    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Completable z0(@NonNull Function<? super Throwable, ? extends CompletableSource> function) {
        Objects.requireNonNull(function, "fallbackSupplier is null");
        return RxJavaPlugins.O(new CompletableResumeNext(this, function));
    }
}
