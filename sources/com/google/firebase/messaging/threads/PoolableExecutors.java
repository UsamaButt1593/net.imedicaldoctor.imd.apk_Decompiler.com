package com.google.firebase.messaging.threads;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CompileTimeConstant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolableExecutors {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorFactory f24953a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile ExecutorFactory f24954b;

    private static class DefaultExecutorFactory implements ExecutorFactory {

        /* renamed from: a  reason: collision with root package name */
        private static final long f24955a = 60;

        private DefaultExecutorFactory() {
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ExecutorService a(ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        }

        @NonNull
        public ExecutorService b(ThreadPriority threadPriority) {
            return h(1, threadPriority);
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public Future<?> c(@CompileTimeConstant String str, @CompileTimeConstant String str2, ThreadPriority threadPriority, Runnable runnable) {
            FutureTask futureTask = new FutureTask(runnable, (Object) null);
            new Thread(futureTask, str2).start();
            return futureTask;
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public void d(@CompileTimeConstant String str, @CompileTimeConstant String str2, ThreadPriority threadPriority, Runnable runnable) {
            new Thread(runnable, str2).start();
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ScheduledExecutorService e(int i2, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i2, threadFactory));
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ScheduledExecutorService f(int i2, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i2));
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ExecutorService g(int i2, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }

        @NonNull
        public ExecutorService h(int i2, ThreadPriority threadPriority) {
            return g(i2, Executors.defaultThreadFactory(), threadPriority);
        }

        @NonNull
        public ExecutorService i(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return g(1, threadFactory, threadPriority);
        }

        @SuppressLint({"ThreadPoolCreation"})
        @NonNull
        public ExecutorService j(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(threadFactory));
        }
    }

    static {
        DefaultExecutorFactory defaultExecutorFactory = new DefaultExecutorFactory();
        f24953a = defaultExecutorFactory;
        f24954b = defaultExecutorFactory;
    }

    private PoolableExecutors() {
    }

    public static ExecutorFactory a() {
        return f24954b;
    }

    static void b(ExecutorFactory executorFactory) {
        if (f24954b == f24953a) {
            f24954b = executorFactory;
            return;
        }
        throw new IllegalStateException("Trying to install an ExecutorFactory twice!");
    }
}
