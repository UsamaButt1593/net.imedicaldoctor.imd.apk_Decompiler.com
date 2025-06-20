package com.google.firebase.messaging.threads;

import com.google.errorprone.annotations.CompileTimeConstant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public interface ExecutorFactory {
    ExecutorService a(ThreadPriority threadPriority);

    ExecutorService b(ThreadPriority threadPriority);

    Future<?> c(@CompileTimeConstant String str, @CompileTimeConstant String str2, ThreadPriority threadPriority, Runnable runnable);

    void d(@CompileTimeConstant String str, @CompileTimeConstant String str2, ThreadPriority threadPriority, Runnable runnable);

    ScheduledExecutorService e(int i2, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ScheduledExecutorService f(int i2, ThreadPriority threadPriority);

    ExecutorService g(int i2, ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService h(int i2, ThreadPriority threadPriority);

    ExecutorService i(ThreadFactory threadFactory, ThreadPriority threadPriority);

    ExecutorService j(ThreadFactory threadFactory, ThreadPriority threadPriority);
}
