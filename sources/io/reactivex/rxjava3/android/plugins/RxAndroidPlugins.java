package io.reactivex.rxjava3.android.plugins;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.Callable;

public final class RxAndroidPlugins {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Function<Callable<Scheduler>, Scheduler> f18881a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile Function<Scheduler, Scheduler> f18882b;

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }

    static <T, R> R a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.rxjava3.functions.Function<java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.functions.Function] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static io.reactivex.rxjava3.core.Scheduler b(io.reactivex.rxjava3.functions.Function<java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler>, io.reactivex.rxjava3.core.Scheduler> r0, java.util.concurrent.Callable<io.reactivex.rxjava3.core.Scheduler> r1) {
        /*
            java.lang.Object r0 = a(r0, r1)
            io.reactivex.rxjava3.core.Scheduler r0 = (io.reactivex.rxjava3.core.Scheduler) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.android.plugins.RxAndroidPlugins.b(io.reactivex.rxjava3.functions.Function, java.util.concurrent.Callable):io.reactivex.rxjava3.core.Scheduler");
    }

    static Scheduler c(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.a(th);
        }
    }

    public static Function<Callable<Scheduler>, Scheduler> d() {
        return f18881a;
    }

    public static Function<Scheduler, Scheduler> e() {
        return f18882b;
    }

    public static Scheduler f(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = f18881a;
            return function == null ? c(callable) : b(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Scheduler g(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = f18882b;
            return function == null ? scheduler : (Scheduler) a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static void h() {
        i((Function<Callable<Scheduler>, Scheduler>) null);
        j((Function<Scheduler, Scheduler>) null);
    }

    public static void i(Function<Callable<Scheduler>, Scheduler> function) {
        f18881a = function;
    }

    public static void j(Function<Scheduler, Scheduler> function) {
        f18882b = function;
    }
}
