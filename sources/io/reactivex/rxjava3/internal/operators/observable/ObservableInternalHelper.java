package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {

    static final class BufferedReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {
        final int X;
        final boolean Y;
        final Observable<T> s;

        BufferedReplaySupplier(Observable<T> observable, int i2, boolean z) {
            this.s = observable;
            this.X = i2;
            this.Y = z;
        }

        /* renamed from: a */
        public ConnectableObservable<T> get() {
            return this.s.c5(this.X, this.Y);
        }
    }

    static final class BufferedTimedReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {
        final int X;
        final Scheduler X2;
        final long Y;
        final boolean Y2;
        final TimeUnit Z;
        final Observable<T> s;

        BufferedTimedReplaySupplier(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = observable;
            this.X = i2;
            this.Y = j2;
            this.Z = timeUnit;
            this.X2 = scheduler;
            this.Y2 = z;
        }

        /* renamed from: a */
        public ConnectableObservable<T> get() {
            return this.s.b5(this.X, this.Y, this.Z, this.X2, this.Y2);
        }
    }

    static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> s;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.s = function;
        }

        /* renamed from: a */
        public ObservableSource<U> apply(T t) throws Throwable {
            Object apply = this.s.apply(t);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new ObservableFromIterable((Iterable) apply);
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

    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final Function<? super T, ? extends ObservableSource<? extends U>> X;
        private final BiFunction<? super T, ? super U, ? extends R> s;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.s = biFunction;
            this.X = function;
        }

        /* renamed from: a */
        public ObservableSource<R> apply(T t) throws Throwable {
            Object apply = this.X.apply(t);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            return new ObservableMap((ObservableSource) apply, new FlatMapWithCombinerInner(this.s, t));
        }
    }

    static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> s;

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.s = function;
        }

        /* renamed from: a */
        public ObservableSource<T> apply(T t) throws Throwable {
            Object apply = this.s.apply(t);
            Objects.requireNonNull(apply, "The itemDelay returned a null ObservableSource");
            return new ObservableTake((ObservableSource) apply, 1).Q3(Functions.n(t)).A1(t);
        }
    }

    enum MapToInt implements Function<Object, Object> {
        INSTANCE;

        public Object apply(Object obj) {
            return 0;
        }
    }

    static final class ObserverOnComplete<T> implements Action {
        final Observer<T> s;

        ObserverOnComplete(Observer<T> observer) {
            this.s = observer;
        }

        public void run() {
            this.s.onComplete();
        }
    }

    static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> s;

        ObserverOnError(Observer<T> observer) {
            this.s = observer;
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            this.s.onError(th);
        }
    }

    static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> s;

        ObserverOnNext(Observer<T> observer) {
            this.s = observer;
        }

        public void accept(T t) {
            this.s.onNext(t);
        }
    }

    static final class ReplaySupplier<T> implements Supplier<ConnectableObservable<T>> {
        private final Observable<T> s;

        ReplaySupplier(Observable<T> observable) {
            this.s = observable;
        }

        /* renamed from: a */
        public ConnectableObservable<T> get() {
            return this.s.X4();
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

    static final class TimedReplayCallable<T> implements Supplier<ConnectableObservable<T>> {
        final long X;
        final boolean X2;
        final TimeUnit Y;
        final Scheduler Z;
        final Observable<T> s;

        TimedReplayCallable(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.s = observable;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            this.X2 = z;
        }

        /* renamed from: a */
        public ConnectableObservable<T> get() {
            return this.s.f5(this.X, this.Y, this.Z, this.X2);
        }
    }

    private ObservableInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Function<T, ObservableSource<U>> a(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> b(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<T>> c(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Action d(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T> Consumer<Throwable> e(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Consumer<T> f(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Supplier<ConnectableObservable<T>> g(Observable<T> observable) {
        return new ReplaySupplier(observable);
    }

    public static <T> Supplier<ConnectableObservable<T>> h(Observable<T> observable, int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new BufferedTimedReplaySupplier(observable, i2, j2, timeUnit, scheduler, z);
    }

    public static <T> Supplier<ConnectableObservable<T>> i(Observable<T> observable, int i2, boolean z) {
        return new BufferedReplaySupplier(observable, i2, z);
    }

    public static <T> Supplier<ConnectableObservable<T>> j(Observable<T> observable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return new TimedReplayCallable(observable, j2, timeUnit, scheduler, z);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> k(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> l(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }
}
