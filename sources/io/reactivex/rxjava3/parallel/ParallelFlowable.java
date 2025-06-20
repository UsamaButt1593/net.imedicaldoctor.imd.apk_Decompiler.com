package io.reactivex.rxjava3.parallel;

import io.reactivex.rxjava3.annotations.BackpressureKind;
import io.reactivex.rxjava3.annotations.BackpressureSupport;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.LongConsumer;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.jdk8.ParallelCollector;
import io.reactivex.rxjava3.internal.jdk8.ParallelFlatMapStream;
import io.reactivex.rxjava3.internal.jdk8.ParallelMapOptional;
import io.reactivex.rxjava3.internal.jdk8.ParallelMapTryOptional;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelCollect;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelConcatMap;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelFilter;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelFlatMap;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelFlatMapIterable;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelFromArray;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelFromPublisher;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelJoin;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelMap;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelPeek;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelReduce;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelReduceFull;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelRunOn;
import io.reactivex.rxjava3.internal.operators.parallel.ParallelSortedJoin;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.internal.util.ListAddBiConsumer;
import io.reactivex.rxjava3.internal.util.MergerBiFunction;
import io.reactivex.rxjava3.internal.util.SorterFunction;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class ParallelFlowable<T> {
    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> ParallelFlowable<T> C(@NonNull Publisher<? extends T> publisher) {
        return E(publisher, Runtime.getRuntime().availableProcessors(), Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> ParallelFlowable<T> D(@NonNull Publisher<? extends T> publisher, int i2) {
        return E(publisher, i2, Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public static <T> ParallelFlowable<T> E(@NonNull Publisher<? extends T> publisher, int i2, int i3) {
        Objects.requireNonNull(publisher, "source is null");
        ObjectHelper.b(i2, "parallelism");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.V(new ParallelFromPublisher(publisher, i2, i3));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @SafeVarargs
    @CheckReturnValue
    @NonNull
    public static <T> ParallelFlowable<T> F(@NonNull Publisher<T>... publisherArr) {
        Objects.requireNonNull(publisherArr, "publishers is null");
        if (publisherArr.length != 0) {
            return RxJavaPlugins.V(new ParallelFromArray(publisherArr));
        }
        throw new IllegalArgumentException("Zero publishers not supported");
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> A(@NonNull Function<? super T, ? extends Stream<? extends R>> function) {
        return B(function, Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> B(@NonNull Function<? super T, ? extends Stream<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.V(new ParallelFlatMapStream(this, function, i2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> G(@NonNull Function<? super T, ? extends R> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.V(new ParallelMap(this, function));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> H(@NonNull Function<? super T, ? extends R> function, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelMapTry(this, function, biFunction));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> I(@NonNull Function<? super T, ? extends R> function, @NonNull ParallelFailureHandling parallelFailureHandling) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelMapTry(this, function, parallelFailureHandling));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> J(@NonNull Function<? super T, Optional<? extends R>> function) {
        Objects.requireNonNull(function, "mapper is null");
        return RxJavaPlugins.V(new ParallelMapOptional(this, function));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> K(@NonNull Function<? super T, Optional<? extends R>> function, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(biFunction, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelMapTryOptional(this, function, biFunction));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> L(@NonNull Function<? super T, Optional<? extends R>> function, @NonNull ParallelFailureHandling parallelFailureHandling) {
        Objects.requireNonNull(function, "mapper is null");
        Objects.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelMapTryOptional(this, function, parallelFailureHandling));
    }

    @CheckReturnValue
    public abstract int M();

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> N(@NonNull BiFunction<T, T, T> biFunction) {
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.P(new ParallelReduceFull(this, biFunction));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> O(@NonNull Supplier<R> supplier, @NonNull BiFunction<R, ? super T, R> biFunction) {
        Objects.requireNonNull(supplier, "initialSupplier is null");
        Objects.requireNonNull(biFunction, "reducer is null");
        return RxJavaPlugins.V(new ParallelReduce(this, supplier, biFunction));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> P(@NonNull Scheduler scheduler) {
        return Q(scheduler, Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("custom")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> Q(@NonNull Scheduler scheduler, int i2) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.V(new ParallelRunOn(this, scheduler, i2));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> R() {
        return S(Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> S(int i2) {
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new ParallelJoin(this, i2, false));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> T() {
        return U(Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> U(int i2) {
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.P(new ParallelJoin(this, i2, true));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> V(@NonNull Comparator<? super T> comparator) {
        return W(comparator, 16);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<T> W(@NonNull Comparator<? super T> comparator, int i2) {
        Objects.requireNonNull(comparator, "comparator is null");
        ObjectHelper.b(i2, "capacityHint");
        return RxJavaPlugins.P(new ParallelSortedJoin(O(Functions.f((i2 / M()) + 1), ListAddBiConsumer.b()).G(new SorterFunction(comparator)), comparator));
    }

    @BackpressureSupport(BackpressureKind.SPECIAL)
    @SchedulerSupport("none")
    public abstract void X(@NonNull Subscriber<? super T>[] subscriberArr);

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> R Y(@NonNull ParallelFlowableConverter<T, R> parallelFlowableConverter) {
        Objects.requireNonNull(parallelFlowableConverter, "converter is null");
        return parallelFlowableConverter.a(this);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> Z(@NonNull Comparator<? super T> comparator) {
        return a0(comparator, 16);
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <A, R> Flowable<R> a(@NonNull Collector<T, A, R> collector) {
        Objects.requireNonNull(collector, "collector is null");
        return RxJavaPlugins.P(new ParallelCollector(this, collector));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final Flowable<List<T>> a0(@NonNull Comparator<? super T> comparator, int i2) {
        Objects.requireNonNull(comparator, "comparator is null");
        ObjectHelper.b(i2, "capacityHint");
        return RxJavaPlugins.P(O(Functions.f((i2 / M()) + 1), ListAddBiConsumer.b()).G(new SorterFunction(comparator)).N(new MergerBiFunction(comparator)));
    }

    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <C> ParallelFlowable<C> b(@NonNull Supplier<? extends C> supplier, @NonNull BiConsumer<? super C, ? super T> biConsumer) {
        Objects.requireNonNull(supplier, "collectionSupplier is null");
        Objects.requireNonNull(biConsumer, "collector is null");
        return RxJavaPlugins.V(new ParallelCollect(this, supplier, biConsumer));
    }

    /* access modifiers changed from: protected */
    public final boolean b0(@NonNull Subscriber<?>[] subscriberArr) {
        Objects.requireNonNull(subscriberArr, "subscribers is null");
        int M = M();
        if (subscriberArr.length == M) {
            return true;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("parallelism = " + M + ", subscribers = " + subscriberArr.length);
        for (Subscriber<?> b2 : subscriberArr) {
            EmptySubscription.b(illegalArgumentException, b2);
        }
        return false;
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> ParallelFlowable<U> c(@NonNull ParallelTransformer<T, U> parallelTransformer) {
        Objects.requireNonNull(parallelTransformer, "composer is null");
        return RxJavaPlugins.V(parallelTransformer.a(this));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> d(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return e(function, 2);
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> e(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.V(new ParallelConcatMap(this, function, i2, ErrorMode.IMMEDIATE));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> f(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "prefetch");
        return RxJavaPlugins.V(new ParallelConcatMap(this, function, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> g(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return f(function, 2, z);
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> h(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onAfterNext is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, h2, consumer, h3, action, action, Functions.h(), Functions.f28378g, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> i(@NonNull Action action) {
        Objects.requireNonNull(action, "onAfterTerminate is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Action action2 = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, h2, h3, h4, action2, action, Functions.h(), Functions.f28378g, action2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> j(@NonNull Action action) {
        Objects.requireNonNull(action, "onCancel is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Action action2 = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, h2, h3, h4, action2, action2, Functions.h(), Functions.f28378g, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> k(@NonNull Action action) {
        Objects.requireNonNull(action, "onComplete is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Action action2 = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, h2, h3, h4, action, action2, Functions.h(), Functions.f28378g, action2));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> l(@NonNull Consumer<? super Throwable> consumer) {
        Objects.requireNonNull(consumer, "onError is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, h2, h3, consumer, action, action, Functions.h(), Functions.f28378g, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> m(@NonNull Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer, "onNext is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Action action = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, consumer, h2, h3, action, action, Functions.h(), Functions.f28378g, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> n(@NonNull Consumer<? super T> consumer, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(biFunction, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelDoOnNextTry(this, consumer, biFunction));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> o(@NonNull Consumer<? super T> consumer, @NonNull ParallelFailureHandling parallelFailureHandling) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelDoOnNextTry(this, consumer, parallelFailureHandling));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> p(@NonNull LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer, "onRequest is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Action action = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, h2, h3, h4, action, action, Functions.h(), longConsumer, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> q(@NonNull Consumer<? super Subscription> consumer) {
        Objects.requireNonNull(consumer, "onSubscribe is null");
        Consumer h2 = Functions.h();
        Consumer h3 = Functions.h();
        Consumer h4 = Functions.h();
        Action action = Functions.f28374c;
        return RxJavaPlugins.V(new ParallelPeek(this, h2, h3, h4, action, action, consumer, Functions.f28378g, action));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> r(@NonNull Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate, "predicate is null");
        return RxJavaPlugins.V(new ParallelFilter(this, predicate));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> s(@NonNull Predicate<? super T> predicate, @NonNull BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        Objects.requireNonNull(predicate, "predicate is null");
        Objects.requireNonNull(biFunction, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelFilterTry(this, predicate, biFunction));
    }

    @BackpressureSupport(BackpressureKind.PASS_THROUGH)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final ParallelFlowable<T> t(@NonNull Predicate<? super T> predicate, @NonNull ParallelFailureHandling parallelFailureHandling) {
        Objects.requireNonNull(predicate, "predicate is null");
        Objects.requireNonNull(parallelFailureHandling, "errorHandler is null");
        return RxJavaPlugins.V(new ParallelFilterTry(this, predicate, parallelFailureHandling));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> u(@NonNull Function<? super T, ? extends Publisher<? extends R>> function) {
        return x(function, false, Flowable.Y(), Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> v(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return x(function, z, Flowable.Y(), Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> w(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2) {
        return x(function, z, i2, Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <R> ParallelFlowable<R> x(@NonNull Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i2, int i3) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "maxConcurrency");
        ObjectHelper.b(i3, "prefetch");
        return RxJavaPlugins.V(new ParallelFlatMap(this, function, z, i2, i3));
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> ParallelFlowable<U> y(@NonNull Function<? super T, ? extends Iterable<? extends U>> function) {
        return z(function, Flowable.Y());
    }

    @BackpressureSupport(BackpressureKind.FULL)
    @SchedulerSupport("none")
    @NonNull
    @CheckReturnValue
    public final <U> ParallelFlowable<U> z(@NonNull Function<? super T, ? extends Iterable<? extends U>> function, int i2) {
        Objects.requireNonNull(function, "mapper is null");
        ObjectHelper.b(i2, "bufferSize");
        return RxJavaPlugins.V(new ParallelFlatMapIterable(this, function, i2));
    }
}
