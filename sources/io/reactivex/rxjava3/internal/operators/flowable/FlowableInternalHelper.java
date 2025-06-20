package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInternalHelper {

    static final class BufferedReplaySupplier<T> implements Supplier<ConnectableFlowable<T>> {
        final int X;
        final boolean Y;
        final Flowable<T> s;

        BufferedReplaySupplier(Flowable<T> flowable, int i2, boolean z) {
            this.s = flowable;
            this.X = i2;
            this.Y = z;
        }

        /* renamed from: a */
        public ConnectableFlowable<T> get() {
            return this.s.F5(this.X, this.Y);
        }
    }

    static final class BufferedTimedReplay<T> implements Supplier<ConnectableFlowable<T>> {
        final int X;
        final Scheduler X2;
        final long Y;
        final boolean Y2;
        final TimeUnit Z;
        final Flowable<T> s;

        BufferedTimedReplay(Flowable<T> flowable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = flowable;
            this.X = i2;
            this.Y = j2;
            this.Z = timeUnit;
            this.X2 = scheduler;
            this.Y2 = z;
        }

        /* renamed from: a */
        public ConnectableFlowable<T> get() {
            return this.s.E5(this.X, this.Y, this.Z, this.X2, this.Y2);
        }
    }

    static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> s;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.s = function;
        }

        /* renamed from: a */
        public Publisher<U> apply(T t) throws Throwable {
            Object apply = this.s.apply(t);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new FlowableFromIterable((Iterable) apply);
        }
    }

    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final T X;
        private final BiFunction<? super T, ? super U, ? extends R> s;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.s = biFunction;
            this.X = t;
        }

        public R apply(U u) throws Throwable {
            return this.s.apply(this.X, u);
        }
    }

    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final Function<? super T, ? extends Publisher<? extends U>> X;
        private final BiFunction<? super T, ? super U, ? extends R> s;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.s = biFunction;
            this.X = function;
        }

        /* renamed from: a */
        public Publisher<R> apply(T t) throws Throwable {
            Object apply = this.X.apply(t);
            Objects.requireNonNull(apply, "The mapper returned a null Publisher");
            return new FlowableMapPublisher((Publisher) apply, new FlatMapWithCombinerInner(this.s, t));
        }
    }

    static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> s;

        ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
            this.s = function;
        }

        /* renamed from: a */
        public Publisher<T> apply(T t) throws Throwable {
            Object apply = this.s.apply(t);
            Objects.requireNonNull(apply, "The itemDelay returned a null Publisher");
            return new FlowableTakePublisher((Publisher) apply, 1).c4(Functions.n(t)).G1(t);
        }
    }

    static final class ReplaySupplier<T> implements Supplier<ConnectableFlowable<T>> {
        final Flowable<T> s;

        ReplaySupplier(Flowable<T> flowable) {
            this.s = flowable;
        }

        /* renamed from: a */
        public ConnectableFlowable<T> get() {
            return this.s.A5();
        }
    }

    public enum RequestMax implements Consumer<Subscription> {
        INSTANCE;

        /* renamed from: a */
        public void accept(Subscription subscription) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> s;

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.s = biConsumer;
        }

        /* renamed from: a */
        public S apply(S s2, Emitter<T> emitter) throws Throwable {
            this.s.accept(s2, emitter);
            return s2;
        }
    }

    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> s;

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.s = consumer;
        }

        /* renamed from: a */
        public S apply(S s2, Emitter<T> emitter) throws Throwable {
            this.s.accept(emitter);
            return s2;
        }
    }

    static final class SubscriberOnComplete<T> implements Action {
        final Subscriber<T> s;

        SubscriberOnComplete(Subscriber<T> subscriber) {
            this.s = subscriber;
        }

        public void run() {
            this.s.onComplete();
        }
    }

    static final class SubscriberOnError<T> implements Consumer<Throwable> {
        final Subscriber<T> s;

        SubscriberOnError(Subscriber<T> subscriber) {
            this.s = subscriber;
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            this.s.onError(th);
        }
    }

    static final class SubscriberOnNext<T> implements Consumer<T> {
        final Subscriber<T> s;

        SubscriberOnNext(Subscriber<T> subscriber) {
            this.s = subscriber;
        }

        public void accept(T t) {
            this.s.onNext(t);
        }
    }

    static final class TimedReplay<T> implements Supplier<ConnectableFlowable<T>> {
        private final long X;
        final boolean X2;
        private final TimeUnit Y;
        private final Scheduler Z;
        private final Flowable<T> s;

        TimedReplay(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = flowable;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            this.X2 = z;
        }

        /* renamed from: a */
        public ConnectableFlowable<T> get() {
            return this.s.I5(this.X, this.Y, this.Z, this.X2);
        }
    }

    private FlowableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, Publisher<U>> a(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, Publisher<R>> b(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, Publisher<T>> c(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Supplier<ConnectableFlowable<T>> d(Flowable<T> flowable) {
        return new ReplaySupplier(flowable);
    }

    public static <T> Supplier<ConnectableFlowable<T>> e(Flowable<T> flowable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new BufferedTimedReplay(flowable, i2, j2, timeUnit, scheduler, z);
    }

    public static <T> Supplier<ConnectableFlowable<T>> f(Flowable<T> flowable, int i2, boolean z) {
        return new BufferedReplaySupplier(flowable, i2, z);
    }

    public static <T> Supplier<ConnectableFlowable<T>> g(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new TimedReplay(flowable, j2, timeUnit, scheduler, z);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> h(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> i(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T> Action j(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
    }

    public static <T> Consumer<Throwable> k(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Consumer<T> l(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }
}
