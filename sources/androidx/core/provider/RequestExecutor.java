package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class RequestExecutor {

    private static class DefaultThreadFactory implements ThreadFactory {
        private int X;
        private String s;

        private static class ProcessPriorityThread extends Thread {
            private final int s;

            ProcessPriorityThread(Runnable runnable, String str, int i2) {
                super(runnable, str);
                this.s = i2;
            }

            public void run() {
                Process.setThreadPriority(this.s);
                super.run();
            }
        }

        DefaultThreadFactory(@NonNull String str, int i2) {
            this.s = str;
            this.X = i2;
        }

        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.s, this.X);
        }
    }

    private static class HandlerExecutor implements Executor {
        private final Handler s;

        HandlerExecutor(@NonNull Handler handler) {
            this.s = (Handler) Preconditions.l(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (!this.s.post((Runnable) Preconditions.l(runnable))) {
                throw new RejectedExecutionException(this.s + " is shutting down");
            }
        }
    }

    private static class ReplyRunnable<T> implements Runnable {
        @NonNull
        private Consumer<T> X;
        @NonNull
        private Handler Y;
        @NonNull
        private Callable<T> s;

        ReplyRunnable(@NonNull Handler handler, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
            this.s = callable;
            this.X = consumer;
            this.Y = handler;
        }

        public void run() {
            final T t;
            try {
                t = this.s.call();
            } catch (Exception unused) {
                t = null;
            }
            final Consumer<T> consumer = this.X;
            this.Y.post(new Runnable() {
                public void run() {
                    consumer.accept(t);
                }
            });
        }
    }

    private RequestExecutor() {
    }

    static ThreadPoolExecutor a(@NonNull String str, int i2, @IntRange(from = 0) int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i3, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i2));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    static Executor b(@NonNull Handler handler) {
        return new HandlerExecutor(handler);
    }

    static <T> void c(@NonNull Executor executor, @NonNull Callable<T> callable, @NonNull Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.a(), callable, consumer));
    }

    static <T> T d(@NonNull ExecutorService executorService, @NonNull Callable<T> callable, @IntRange(from = 0) int i2) throws InterruptedException {
        try {
            return executorService.submit(callable).get((long) i2, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (InterruptedException e3) {
            throw e3;
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
