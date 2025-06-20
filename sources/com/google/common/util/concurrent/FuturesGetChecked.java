package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
final class FuturesGetChecked {

    /* renamed from: a  reason: collision with root package name */
    private static final Ordering<List<Class<?>>> f23186a;

    /* renamed from: b  reason: collision with root package name */
    private static final Ordering<Constructor<?>> f23187b;

    @VisibleForTesting
    interface GetCheckedTypeValidator {
        void a(Class<? extends Exception> cls);
    }

    @VisibleForTesting
    static class GetCheckedTypeValidatorHolder {

        /* renamed from: a  reason: collision with root package name */
        static final GetCheckedTypeValidator f23188a = a();

        enum WeakSetValidator implements GetCheckedTypeValidator {
            INSTANCE;
            
            private static final Set<WeakReference<Class<? extends Exception>>> X = null;

            static {
                X = new CopyOnWriteArraySet();
            }

            public void a(Class<? extends Exception> cls) {
                for (WeakReference<Class<? extends Exception>> weakReference : X) {
                    if (cls.equals(weakReference.get())) {
                        return;
                    }
                }
                FuturesGetChecked.e(cls);
                Set<WeakReference<Class<? extends Exception>>> set = X;
                if (set.size() > 1000) {
                    set.clear();
                }
                set.add(new WeakReference(cls));
            }
        }

        GetCheckedTypeValidatorHolder() {
        }

        static GetCheckedTypeValidator a() {
            return FuturesGetChecked.q();
        }
    }

    static {
        Ordering<List<Class<?>>> E = Ordering.z().D(new v()).e(Ordering.z().D(new w())).E();
        f23186a = E;
        f23187b = E.D(new x());
    }

    private FuturesGetChecked() {
    }

    private static GetCheckedTypeValidator d() {
        return GetCheckedTypeValidatorHolder.f23188a;
    }

    @VisibleForTesting
    static void e(Class<? extends Exception> cls) {
        Preconditions.u(j(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        Preconditions.u(i(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    @CanIgnoreReturnValue
    @VisibleForTesting
    @ParametricNullness
    static <V, X extends Exception> V f(GetCheckedTypeValidator getCheckedTypeValidator, Future<V> future, Class<X> cls) throws Exception {
        getCheckedTypeValidator.a(cls);
        try {
            return future.get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw o(cls, e2);
        } catch (ExecutionException e3) {
            r(e3.getCause(), cls);
            throw new AssertionError();
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    static <V, X extends Exception> V g(Future<V> future, Class<X> cls) throws Exception {
        return f(d(), future, cls);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    static <V, X extends Exception> V h(Future<V> future, Class<X> cls, long j2, TimeUnit timeUnit) throws Exception {
        d().a(cls);
        try {
            return future.get(j2, timeUnit);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            throw o(cls, e2);
        } catch (TimeoutException e3) {
            throw o(cls, e3);
        } catch (ExecutionException e4) {
            r(e4.getCause(), cls);
            throw new AssertionError();
        }
    }

    private static boolean i(Class<? extends Exception> cls) {
        try {
            o(cls, new Exception());
            return true;
        } catch (Error | RuntimeException unused) {
            return false;
        }
    }

    @VisibleForTesting
    static boolean j(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    @CheckForNull
    private static <X> X n(Constructor<X> constructor, Throwable th) {
        Class[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            Class cls = parameterTypes[i2];
            if (cls.equals(String.class)) {
                objArr[i2] = th.toString();
            } else if (!cls.equals(Throwable.class)) {
                return null;
            } else {
                objArr[i2] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static <X extends Exception> X o(Class<X> cls, Throwable th) {
        for (Constructor n2 : p(Arrays.asList(cls.getConstructors()))) {
            X x = (Exception) n(n2, th);
            if (x != null) {
                if (x.getCause() == null) {
                    x.initCause(th);
                }
                return x;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + cls + " in response to chained exception", th);
    }

    private static <X extends Exception> List<Constructor<X>> p(List<Constructor<X>> list) {
        return f23187b.F(list);
    }

    @VisibleForTesting
    static GetCheckedTypeValidator q() {
        return GetCheckedTypeValidatorHolder.WeakSetValidator.INSTANCE;
    }

    private static <X extends Exception> void r(Throwable th, Class<X> cls) throws Exception {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw o(cls, th);
        }
    }
}
