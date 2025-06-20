package io.reactivex.rxjava3.plugins;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import io.reactivex.rxjava3.flowables.ConnectableFlowable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.BooleanSupplier;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.schedulers.ComputationScheduler;
import io.reactivex.rxjava3.internal.schedulers.IoScheduler;
import io.reactivex.rxjava3.internal.schedulers.NewThreadScheduler;
import io.reactivex.rxjava3.internal.schedulers.SingleScheduler;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;

public final class RxJavaPlugins {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    static volatile Consumer<? super Throwable> f28493a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    static volatile Function<? super Runnable, ? extends Runnable> f28494b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f28495c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f28496d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f28497e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    static volatile Function<? super Supplier<Scheduler>, ? extends Scheduler> f28498f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f28499g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f28500h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f28501i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    static volatile Function<? super Scheduler, ? extends Scheduler> f28502j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    static volatile Function<? super Flowable, ? extends Flowable> f28503k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> f28504l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    static volatile Function<? super Observable, ? extends Observable> f28505m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> f28506n;
    @Nullable
    static volatile Function<? super Maybe, ? extends Maybe> o;
    @Nullable
    static volatile Function<? super Single, ? extends Single> p;
    @Nullable
    static volatile Function<? super Completable, ? extends Completable> q;
    @Nullable
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> r;
    @Nullable
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> s;
    @Nullable
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> t;
    @Nullable
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> u;
    @Nullable
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> v;
    @Nullable
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> w;
    @Nullable
    static volatile BooleanSupplier x;
    static volatile boolean y;
    static volatile boolean z;

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }

    @Nullable
    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> A() {
        return u;
    }

    public static void A0(@Nullable BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> biFunction) {
        if (!y) {
            t = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> B() {
        return r;
    }

    public static void B0(@Nullable Function<? super Observable, ? extends Observable> function) {
        if (!y) {
            f28505m = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Single, ? extends Single> C() {
        return p;
    }

    public static void C0(@Nullable BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction) {
        if (!y) {
            u = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> D() {
        return v;
    }

    public static void D0(@Nullable Function<? super ParallelFlowable, ? extends ParallelFlowable> function) {
        if (!y) {
            r = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Runnable, ? extends Runnable> E() {
        return f28494b;
    }

    public static void E0(@Nullable Function<? super Single, ? extends Single> function) {
        if (!y) {
            p = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> F() {
        return f28500h;
    }

    public static void F0(@Nullable BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction) {
        if (!y) {
            v = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @NonNull
    public static Scheduler G(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f28495c;
        return function == null ? d(supplier) : c(function, supplier);
    }

    public static void G0(@Nullable Function<? super Runnable, ? extends Runnable> function) {
        if (!y) {
            f28494b = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @NonNull
    public static Scheduler H(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f28497e;
        return function == null ? d(supplier) : c(function, supplier);
    }

    public static void H0(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!y) {
            f28500h = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @NonNull
    public static Scheduler I(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f28498f;
        return function == null ? d(supplier) : c(function, supplier);
    }

    static void I0(@NonNull Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @NonNull
    public static Scheduler J(@NonNull Supplier<Scheduler> supplier) {
        Objects.requireNonNull(supplier, "Scheduler Supplier can't be null");
        Function<? super Supplier<Scheduler>, ? extends Scheduler> function = f28496d;
        return function == null ? d(supplier) : c(function, supplier);
    }

    static void J0() {
        y = false;
    }

    static boolean K(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static boolean L() {
        return z;
    }

    public static boolean M() {
        return y;
    }

    public static void N() {
        y = true;
    }

    @NonNull
    public static Completable O(@NonNull Completable completable) {
        Function<? super Completable, ? extends Completable> function = q;
        return function != null ? (Completable) b(function, completable) : completable;
    }

    @NonNull
    public static <T> Flowable<T> P(@NonNull Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f28503k;
        return function != null ? (Flowable) b(function, flowable) : flowable;
    }

    @NonNull
    public static <T> Maybe<T> Q(@NonNull Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = o;
        return function != null ? (Maybe) b(function, maybe) : maybe;
    }

    @NonNull
    public static <T> Observable<T> R(@NonNull Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f28505m;
        return function != null ? (Observable) b(function, observable) : observable;
    }

    @NonNull
    public static <T> Single<T> S(@NonNull Single<T> single) {
        Function<? super Single, ? extends Single> function = p;
        return function != null ? (Single) b(function, single) : single;
    }

    @NonNull
    public static <T> ConnectableFlowable<T> T(@NonNull ConnectableFlowable<T> connectableFlowable) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = f28504l;
        return function != null ? (ConnectableFlowable) b(function, connectableFlowable) : connectableFlowable;
    }

    @NonNull
    public static <T> ConnectableObservable<T> U(@NonNull ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = f28506n;
        return function != null ? (ConnectableObservable) b(function, connectableObservable) : connectableObservable;
    }

    @NonNull
    public static <T> ParallelFlowable<T> V(@NonNull ParallelFlowable<T> parallelFlowable) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> function = r;
        return function != null ? (ParallelFlowable) b(function, parallelFlowable) : parallelFlowable;
    }

    public static boolean W() {
        BooleanSupplier booleanSupplier = x;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.a();
        } catch (Throwable th) {
            throw ExceptionHelper.i(th);
        }
    }

    @NonNull
    public static Scheduler X(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f28499g;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    public static void Y(@NonNull Throwable th) {
        Consumer<? super Throwable> consumer = f28493a;
        if (th == null) {
            th = ExceptionHelper.b("onError called with a null Throwable.");
        } else if (!K(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                I0(th2);
            }
        }
        th.printStackTrace();
        I0(th);
    }

    @NonNull
    public static Scheduler Z(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f28501i;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    @NonNull
    static <T, U, R> R a(@NonNull BiFunction<T, U, R> biFunction, @NonNull T t2, @NonNull U u2) {
        try {
            return biFunction.apply(t2, u2);
        } catch (Throwable th) {
            throw ExceptionHelper.i(th);
        }
    }

    @NonNull
    public static Scheduler a0(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f28502j;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    @NonNull
    static <T, R> R b(@NonNull Function<T, R> function, @NonNull T t2) {
        try {
            return function.apply(t2);
        } catch (Throwable th) {
            throw ExceptionHelper.i(th);
        }
    }

    @NonNull
    public static Runnable b0(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f28494b;
        return function == null ? runnable : (Runnable) b(function, runnable);
    }

    @NonNull
    static Scheduler c(@NonNull Function<? super Supplier<Scheduler>, ? extends Scheduler> function, Supplier<Scheduler> supplier) {
        Object b2 = b(function, supplier);
        Objects.requireNonNull(b2, "Scheduler Supplier result can't be null");
        return (Scheduler) b2;
    }

    @NonNull
    public static Scheduler c0(@NonNull Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f28500h;
        return function == null ? scheduler : (Scheduler) b(function, scheduler);
    }

    @NonNull
    static Scheduler d(@NonNull Supplier<Scheduler> supplier) {
        try {
            Scheduler scheduler = supplier.get();
            Objects.requireNonNull(scheduler, "Scheduler Supplier result can't be null");
            return scheduler;
        } catch (Throwable th) {
            throw ExceptionHelper.i(th);
        }
    }

    @NonNull
    public static CompletableObserver d0(@NonNull Completable completable, @NonNull CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = w;
        return biFunction != null ? (CompletableObserver) a(biFunction, completable, completableObserver) : completableObserver;
    }

    @NonNull
    public static Scheduler e(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new ComputationScheduler(threadFactory);
    }

    @NonNull
    public static <T> MaybeObserver<? super T> e0(@NonNull Maybe<T> maybe, @NonNull MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = t;
        return biFunction != null ? (MaybeObserver) a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    @NonNull
    public static Scheduler f(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new IoScheduler(threadFactory);
    }

    @NonNull
    public static <T> Observer<? super T> f0(@NonNull Observable<T> observable, @NonNull Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = u;
        return biFunction != null ? (Observer) a(biFunction, observable, observer) : observer;
    }

    @NonNull
    public static Scheduler g(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new NewThreadScheduler(threadFactory);
    }

    @NonNull
    public static <T> SingleObserver<? super T> g0(@NonNull Single<T> single, @NonNull SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = v;
        return biFunction != null ? (SingleObserver) a(biFunction, single, singleObserver) : singleObserver;
    }

    @NonNull
    public static Scheduler h(@NonNull ThreadFactory threadFactory) {
        Objects.requireNonNull(threadFactory, "threadFactory is null");
        return new SingleScheduler(threadFactory);
    }

    @NonNull
    public static <T> Subscriber<? super T> h0(@NonNull Flowable<T> flowable, @NonNull Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = s;
        return biFunction != null ? (Subscriber) a(biFunction, flowable, subscriber) : subscriber;
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> i() {
        return f28499g;
    }

    public static void i0() {
        k0((Consumer<? super Throwable>) null);
        G0((Function<? super Runnable, ? extends Runnable>) null);
        j0((Function<? super Scheduler, ? extends Scheduler>) null);
        m0((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        q0((Function<? super Scheduler, ? extends Scheduler>) null);
        n0((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        H0((Function<? super Scheduler, ? extends Scheduler>) null);
        p0((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        r0((Function<? super Scheduler, ? extends Scheduler>) null);
        o0((Function<? super Supplier<Scheduler>, ? extends Scheduler>) null);
        x0((Function<? super Flowable, ? extends Flowable>) null);
        y0((BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber>) null);
        B0((Function<? super Observable, ? extends Observable>) null);
        C0((BiFunction<? super Observable, ? super Observer, ? extends Observer>) null);
        E0((Function<? super Single, ? extends Single>) null);
        F0((BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver>) null);
        t0((Function<? super Completable, ? extends Completable>) null);
        u0((BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver>) null);
        v0((Function<? super ConnectableFlowable, ? extends ConnectableFlowable>) null);
        w0((Function<? super ConnectableObservable, ? extends ConnectableObservable>) null);
        z0((Function<? super Maybe, ? extends Maybe>) null);
        A0((BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver>) null);
        D0((Function<? super ParallelFlowable, ? extends ParallelFlowable>) null);
        l0(false);
        s0((BooleanSupplier) null);
    }

    @Nullable
    public static Consumer<? super Throwable> j() {
        return f28493a;
    }

    public static void j0(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!y) {
            f28499g = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> k() {
        return f28495c;
    }

    public static void k0(@Nullable Consumer<? super Throwable> consumer) {
        if (!y) {
            f28493a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> l() {
        return f28497e;
    }

    public static void l0(boolean z2) {
        if (!y) {
            z = z2;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> m() {
        return f28498f;
    }

    public static void m0(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!y) {
            f28495c = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Supplier<Scheduler>, ? extends Scheduler> n() {
        return f28496d;
    }

    public static void n0(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!y) {
            f28497e = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> o() {
        return f28501i;
    }

    public static void o0(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!y) {
            f28498f = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Scheduler, ? extends Scheduler> p() {
        return f28502j;
    }

    public static void p0(@Nullable Function<? super Supplier<Scheduler>, ? extends Scheduler> function) {
        if (!y) {
            f28496d = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static BooleanSupplier q() {
        return x;
    }

    public static void q0(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!y) {
            f28501i = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Completable, ? extends Completable> r() {
        return q;
    }

    public static void r0(@Nullable Function<? super Scheduler, ? extends Scheduler> function) {
        if (!y) {
            f28502j = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> s() {
        return w;
    }

    public static void s0(@Nullable BooleanSupplier booleanSupplier) {
        if (!y) {
            x = booleanSupplier;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> t() {
        return f28504l;
    }

    public static void t0(@Nullable Function<? super Completable, ? extends Completable> function) {
        if (!y) {
            q = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> u() {
        return f28506n;
    }

    public static void u0(@Nullable BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction) {
        if (!y) {
            w = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Flowable, ? extends Flowable> v() {
        return f28503k;
    }

    public static void v0(@Nullable Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function) {
        if (!y) {
            f28504l = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> w() {
        return s;
    }

    public static void w0(@Nullable Function<? super ConnectableObservable, ? extends ConnectableObservable> function) {
        if (!y) {
            f28506n = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Maybe, ? extends Maybe> x() {
        return o;
    }

    public static void x0(@Nullable Function<? super Flowable, ? extends Flowable> function) {
        if (!y) {
            f28503k = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> y() {
        return t;
    }

    public static void y0(@Nullable BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction) {
        if (!y) {
            s = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    @Nullable
    public static Function<? super Observable, ? extends Observable> z() {
        return f28505m;
    }

    public static void z0(@Nullable Function<? super Maybe, ? extends Maybe> function) {
        if (!y) {
            o = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }
}
