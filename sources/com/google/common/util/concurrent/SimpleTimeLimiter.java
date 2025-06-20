package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class SimpleTimeLimiter implements TimeLimiter {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f23223a;

    private SimpleTimeLimiter(ExecutorService executorService) {
        this.f23223a = (ExecutorService) Preconditions.E(executorService);
    }

    /* access modifiers changed from: private */
    @ParametricNullness
    public <T> T h(Callable<T> callable, long j2, TimeUnit timeUnit, boolean z) throws Exception {
        Preconditions.E(callable);
        Preconditions.E(timeUnit);
        i(j2);
        Future<T> submit = this.f23223a.submit(callable);
        if (!z) {
            return Uninterruptibles.g(submit, j2, timeUnit);
        }
        try {
            return submit.get(j2, timeUnit);
        } catch (InterruptedException e2) {
            submit.cancel(true);
            throw e2;
        } catch (ExecutionException e3) {
            throw n(e3, true);
        } catch (TimeoutException e4) {
            submit.cancel(true);
            throw new UncheckedTimeoutException((Throwable) e4);
        }
    }

    private static void i(long j2) {
        Preconditions.p(j2 > 0, "timeout must be positive: %s", j2);
    }

    public static SimpleTimeLimiter j(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    private static boolean k(Method method) {
        for (Class<InterruptedException> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private static Set<Method> l(Class<?> cls) {
        HashSet u = Sets.u();
        for (Method method : cls.getMethods()) {
            if (k(method)) {
                u.add(method);
            }
        }
        return u;
    }

    private static <T> T m(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* access modifiers changed from: private */
    public static Exception n(Exception exc, boolean z) throws Exception {
        Throwable cause = exc.getCause();
        if (cause != null) {
            if (z) {
                cause.setStackTrace((StackTraceElement[]) ObjectArrays.f(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
            }
            if (cause instanceof Exception) {
                throw ((Exception) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw exc;
            }
        } else {
            throw exc;
        }
    }

    private void o(Throwable th) throws ExecutionException {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        } else if (th instanceof RuntimeException) {
            throw new UncheckedExecutionException(th);
        } else {
            throw new ExecutionException(th);
        }
    }

    private void p(Throwable th) {
        if (th instanceof Error) {
            throw new ExecutionError((Error) th);
        }
        throw new UncheckedExecutionException(th);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T a(Callable<T> callable, long j2, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        Preconditions.E(callable);
        Preconditions.E(timeUnit);
        i(j2);
        Future<T> submit = this.f23223a.submit(callable);
        try {
            return Uninterruptibles.g(submit, j2, timeUnit);
        } catch (TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        } catch (ExecutionException e3) {
            o(e3.getCause());
            throw new AssertionError();
        }
    }

    public void b(Runnable runnable, long j2, TimeUnit timeUnit) throws TimeoutException, InterruptedException {
        Preconditions.E(runnable);
        Preconditions.E(timeUnit);
        i(j2);
        Future<?> submit = this.f23223a.submit(runnable);
        try {
            submit.get(j2, timeUnit);
        } catch (InterruptedException | TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        } catch (ExecutionException e3) {
            p(e3.getCause());
            throw new AssertionError();
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <T> T c(Callable<T> callable, long j2, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        Preconditions.E(callable);
        Preconditions.E(timeUnit);
        i(j2);
        Future<T> submit = this.f23223a.submit(callable);
        try {
            return submit.get(j2, timeUnit);
        } catch (InterruptedException | TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        } catch (ExecutionException e3) {
            o(e3.getCause());
            throw new AssertionError();
        }
    }

    public <T> T d(T t, Class<T> cls, long j2, TimeUnit timeUnit) {
        Preconditions.E(t);
        Preconditions.E(cls);
        Preconditions.E(timeUnit);
        i(j2);
        Preconditions.e(cls.isInterface(), "interfaceType must be an interface type");
        final Set<Method> l2 = l(cls);
        final T t2 = t;
        final long j3 = j2;
        final TimeUnit timeUnit2 = timeUnit;
        return m(cls, new InvocationHandler() {
            /* access modifiers changed from: private */
            public static /* synthetic */ Object b(Method method, Object obj, Object[] objArr) throws Exception {
                try {
                    return method.invoke(obj, objArr);
                } catch (InvocationTargetException e2) {
                    throw SimpleTimeLimiter.n(e2, false);
                }
            }

            @CheckForNull
            public Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
                return SimpleTimeLimiter.this.h(new B(method, t2, objArr), j3, timeUnit2, l2.contains(method));
            }
        });
    }

    public void e(Runnable runnable, long j2, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.E(runnable);
        Preconditions.E(timeUnit);
        i(j2);
        Future<?> submit = this.f23223a.submit(runnable);
        try {
            Uninterruptibles.g(submit, j2, timeUnit);
        } catch (TimeoutException e2) {
            submit.cancel(true);
            throw e2;
        } catch (ExecutionException e3) {
            p(e3.getCause());
            throw new AssertionError();
        }
    }
}
