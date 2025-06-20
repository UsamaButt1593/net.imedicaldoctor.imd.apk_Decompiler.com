package com.google.firebase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class FirebaseExecutors {

    private enum DirectExecutor implements Executor {
        INSTANCE;

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    private FirebaseExecutors() {
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    public static Executor b(Executor executor, int i2) {
        return new LimitedConcurrencyExecutor(executor, i2);
    }

    public static ExecutorService c(ExecutorService executorService, int i2) {
        return new LimitedConcurrencyExecutorService(executorService, i2);
    }

    public static ScheduledExecutorService d(ExecutorService executorService, int i2) {
        return new DelegatingScheduledExecutorService(c(executorService, i2), ExecutorsRegistrar.f23445d.get());
    }

    public static PausableExecutor e(Executor executor) {
        return new PausableExecutorImpl(false, executor);
    }

    public static PausableExecutorService f(ExecutorService executorService) {
        return new PausableExecutorServiceImpl(false, executorService);
    }

    public static PausableScheduledExecutorService g(ScheduledExecutorService scheduledExecutorService) {
        return new PausableScheduledExecutorServiceImpl(f(scheduledExecutorService), ExecutorsRegistrar.f23445d.get());
    }

    public static Executor h(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
