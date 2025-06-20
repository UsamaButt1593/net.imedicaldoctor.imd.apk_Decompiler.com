package com.google.android.gms.tasks;

import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.tasks.zza;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {
    private Tasks() {
    }

    public static <TResult> TResult a(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.p();
        Preconditions.n();
        Preconditions.s(task, "Task must not be null");
        if (task.u()) {
            return s(task);
        }
        zzad zzad = new zzad((zzac) null);
        t(task, zzad);
        zzad.b();
        return s(task);
    }

    public static <TResult> TResult b(@NonNull Task<TResult> task, long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.p();
        Preconditions.n();
        Preconditions.s(task, "Task must not be null");
        Preconditions.s(timeUnit, "TimeUnit must not be null");
        if (task.u()) {
            return s(task);
        }
        zzad zzad = new zzad((zzac) null);
        t(task, zzad);
        if (zzad.d(j2, timeUnit)) {
            return s(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> c(@NonNull Callable<TResult> callable) {
        return d(TaskExecutors.f20522a, callable);
    }

    @NonNull
    @Deprecated
    public static <TResult> Task<TResult> d(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.s(executor, "Executor must not be null");
        Preconditions.s(callable, "Callback must not be null");
        zzw zzw = new zzw();
        executor.execute(new zzz(zzw, callable));
        return zzw;
    }

    @NonNull
    public static <TResult> Task<TResult> e() {
        zzw zzw = new zzw();
        zzw.A();
        return zzw;
    }

    @NonNull
    public static <TResult> Task<TResult> f(@NonNull Exception exc) {
        zzw zzw = new zzw();
        zzw.y(exc);
        return zzw;
    }

    @NonNull
    public static <TResult> Task<TResult> g(TResult tresult) {
        zzw zzw = new zzw();
        zzw.z(tresult);
        return zzw;
    }

    @NonNull
    public static Task<Void> h(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return g((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzw zzw = new zzw();
        zzaf zzaf = new zzaf(collection.size(), zzw);
        for (Task t : collection) {
            t(t, zzaf);
        }
        return zzw;
    }

    @NonNull
    public static Task<Void> i(@Nullable Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? g((Object) null) : h(Arrays.asList(taskArr));
    }

    @NonNull
    public static Task<List<Task<?>>> j(@Nullable Collection<? extends Task<?>> collection) {
        return k(TaskExecutors.f20522a, collection);
    }

    @NonNull
    public static Task<List<Task<?>>> k(@NonNull Executor executor, @Nullable Collection<? extends Task<?>> collection) {
        return (collection == null || collection.isEmpty()) ? g(Collections.emptyList()) : h(collection).p(executor, new zzab(collection));
    }

    @NonNull
    public static Task<List<Task<?>>> l(@NonNull Executor executor, @Nullable Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? g(Collections.emptyList()) : k(executor, Arrays.asList(taskArr));
    }

    @NonNull
    public static Task<List<Task<?>>> m(@Nullable Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? g(Collections.emptyList()) : j(Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> n(@Nullable Collection<? extends Task> collection) {
        return o(TaskExecutors.f20522a, collection);
    }

    @NonNull
    public static <TResult> Task<List<TResult>> o(@NonNull Executor executor, @Nullable Collection<? extends Task> collection) {
        return (collection == null || collection.isEmpty()) ? g(Collections.emptyList()) : h(collection).n(executor, new zzaa(collection));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> p(@NonNull Executor executor, @Nullable Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? g(Collections.emptyList()) : o(executor, Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> q(@Nullable Task... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? g(Collections.emptyList()) : n(Arrays.asList(taskArr));
    }

    @NonNull
    public static <T> Task<T> r(@NonNull Task<T> task, long j2, @NonNull TimeUnit timeUnit) {
        Preconditions.s(task, "Task must not be null");
        Preconditions.b(j2 > 0, "Timeout must be positive");
        Preconditions.s(timeUnit, "TimeUnit must not be null");
        zzb zzb = new zzb();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(zzb);
        zza zza = new zza(Looper.getMainLooper());
        zza.postDelayed(new zzx(taskCompletionSource), timeUnit.toMillis(j2));
        task.e(new zzy(zza, taskCompletionSource, zzb));
        return taskCompletionSource.a();
    }

    private static Object s(@NonNull Task task) throws ExecutionException {
        if (task.v()) {
            return task.r();
        }
        if (task.t()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.q());
    }

    private static void t(Task task, zzae zzae) {
        Executor executor = TaskExecutors.f20523b;
        task.l(executor, zzae);
        task.i(executor, zzae);
        task.c(executor, zzae);
    }
}
