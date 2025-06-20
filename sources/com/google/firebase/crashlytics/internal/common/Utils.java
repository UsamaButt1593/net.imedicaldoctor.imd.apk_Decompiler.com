package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23686a = 4;

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f23687b = ExecutorUtils.c("awaitEvenIfOnMainThread task continuation executor");

    private Utils() {
    }

    public static <T> T f(Task<T> task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.n(f23687b, new t(countDownLatch));
        countDownLatch.await(Looper.getMainLooper() == Looper.myLooper() ? 3 : 4, TimeUnit.SECONDS);
        if (task.v()) {
            return task.r();
        }
        if (task.t()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.u()) {
            throw new IllegalStateException(task.q());
        } else {
            throw new TimeoutException();
        }
    }

    @CanIgnoreReturnValue
    public static boolean g(CountDownLatch countDownLatch, long j2, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static <T> Task<T> h(Executor executor, Callable<Task<T>> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new u(callable, executor, taskCompletionSource));
        return taskCompletionSource.a();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object j(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.v()) {
            taskCompletionSource.c(task.r());
            return null;
        } else if (task.q() == null) {
            return null;
        } else {
            taskCompletionSource.b(task.q());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void k(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).n(executor, new v(taskCompletionSource));
        } catch (Exception e2) {
            taskCompletionSource.b(e2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void l(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.v()) {
            taskCompletionSource.e(task.r());
            return null;
        } else if (task.q() == null) {
            return null;
        } else {
            taskCompletionSource.d(task.q());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void m(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.v()) {
            taskCompletionSource.e(task.r());
            return null;
        } else if (task.q() == null) {
            return null;
        } else {
            taskCompletionSource.d(task.q());
            return null;
        }
    }

    @SuppressLint({"TaskMainThread"})
    public static <T> Task<T> n(Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        s sVar = new s(taskCompletionSource);
        task.m(sVar);
        task2.m(sVar);
        return taskCompletionSource.a();
    }

    public static <T> Task<T> o(Executor executor, Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        w wVar = new w(taskCompletionSource);
        task.n(executor, wVar);
        task2.n(executor, wVar);
        return taskCompletionSource.a();
    }
}
