package com.bumptech.glide.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class Executors {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f18528a = new Executor() {
        private final Handler s = new Handler(Looper.getMainLooper());

        public void execute(@NonNull Runnable runnable) {
            this.s.post(runnable);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f18529b = new Executor() {
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    };

    private Executors() {
    }

    public static Executor a() {
        return f18529b;
    }

    public static Executor b() {
        return f18528a;
    }

    @VisibleForTesting
    public static void c(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (!executorService.awaitTermination(5, timeUnit)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5, timeUnit)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e2) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e2);
        }
    }
}
