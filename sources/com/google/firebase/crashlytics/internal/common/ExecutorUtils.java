package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final long f23649a = 2;

    private ExecutorUtils() {
    }

    private static void a(String str, ExecutorService executorService) {
        b(str, executorService, 2, TimeUnit.SECONDS);
    }

    @SuppressLint({"ThreadPoolCreation"})
    private static void b(String str, ExecutorService executorService, long j2, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j3 = j2;
        final TimeUnit timeUnit2 = timeUnit;
        AnonymousClass2 r2 = new BackgroundPriorityRunnable() {
            public void a() {
                try {
                    Logger f2 = Logger.f();
                    f2.b("Executing shutdown hook for " + str2);
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j3, timeUnit2)) {
                        Logger f3 = Logger.f();
                        f3.b(str2 + " did not shut down in the allocated time. Requesting immediate shutdown.");
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    Logger.f().b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        };
        runtime.addShutdownHook(new Thread(r2, "Crashlytics Shutdown Hook for " + str));
    }

    public static ExecutorService c(String str) {
        ExecutorService f2 = f(e(str), new ThreadPoolExecutor.DiscardPolicy());
        a(str, f2);
        return f2;
    }

    public static ScheduledExecutorService d(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(e(str));
        a(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static ThreadFactory e(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable() {
                    public void a() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        };
    }

    @SuppressLint({"ThreadPoolCreation"})
    private static ExecutorService f(ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler));
    }
}
