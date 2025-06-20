package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Callables {
    private Callables() {
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <T> AsyncCallable<T> e(Callable<T> callable, ListeningExecutorService listeningExecutorService) {
        Preconditions.E(callable);
        Preconditions.E(listeningExecutorService);
        return new n(listeningExecutorService, callable);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object g(Object obj) throws Exception {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object h(Supplier supplier, Callable callable) throws Exception {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean m2 = m((String) supplier.get(), currentThread);
        try {
            return callable.call();
        } finally {
            if (m2) {
                m(name, currentThread);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i(Supplier supplier, Runnable runnable) {
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        boolean m2 = m((String) supplier.get(), currentThread);
        try {
            runnable.run();
        } finally {
            if (m2) {
                m(name, currentThread);
            }
        }
    }

    public static <T> Callable<T> j(@ParametricNullness T t) {
        return new o(t);
    }

    @GwtIncompatible
    @J2ktIncompatible
    static Runnable k(Runnable runnable, Supplier<String> supplier) {
        Preconditions.E(supplier);
        Preconditions.E(runnable);
        return new p(supplier, runnable);
    }

    @GwtIncompatible
    @J2ktIncompatible
    static <T> Callable<T> l(Callable<T> callable, Supplier<String> supplier) {
        Preconditions.E(supplier);
        Preconditions.E(callable);
        return new m(supplier, callable);
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static boolean m(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
