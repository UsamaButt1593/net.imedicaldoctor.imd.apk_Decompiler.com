package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class GlideExecutor implements ExecutorService {
    private static final String X = "source";
    private static final String X2 = "GlideExecutor";
    private static final String Y = "disk-cache";
    private static final String Y2 = "source-unlimited";
    private static final int Z = 1;
    private static final String Z2 = "animation";
    private static final long a3 = TimeUnit.SECONDS.toMillis(10);
    private static final int b3 = 4;
    private static volatile int c3;
    private final ExecutorService s;

    public static final class Builder {

        /* renamed from: g  reason: collision with root package name */
        public static final long f18083g = 0;

        /* renamed from: a  reason: collision with root package name */
        private final boolean f18084a;

        /* renamed from: b  reason: collision with root package name */
        private int f18085b;

        /* renamed from: c  reason: collision with root package name */
        private int f18086c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private UncaughtThrowableStrategy f18087d = UncaughtThrowableStrategy.f18093d;

        /* renamed from: e  reason: collision with root package name */
        private String f18088e;

        /* renamed from: f  reason: collision with root package name */
        private long f18089f;

        Builder(boolean z) {
            this.f18084a = z;
        }

        public GlideExecutor a() {
            if (!TextUtils.isEmpty(this.f18088e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f18085b, this.f18086c, this.f18089f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.f18088e, this.f18087d, this.f18084a));
                if (this.f18089f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f18088e);
        }

        public Builder b(String str) {
            this.f18088e = str;
            return this;
        }

        public Builder c(@IntRange(from = 1) int i2) {
            this.f18085b = i2;
            this.f18086c = i2;
            return this;
        }

        public Builder d(long j2) {
            this.f18089f = j2;
            return this;
        }

        public Builder e(@NonNull UncaughtThrowableStrategy uncaughtThrowableStrategy) {
            this.f18087d = uncaughtThrowableStrategy;
            return this;
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private static final int X2 = 9;
        final UncaughtThrowableStrategy X;
        final boolean Y;
        private int Z;
        private final String s;

        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.s = str;
            this.X = uncaughtThrowableStrategy;
            this.Y = z;
        }

        public synchronized Thread newThread(@NonNull Runnable runnable) {
            AnonymousClass1 r0;
            r0 = new Thread(runnable, "glide-" + this.s + "-thread-" + this.Z) {
                public void run() {
                    Process.setThreadPriority(9);
                    if (DefaultThreadFactory.this.Y) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.X.a(th);
                    }
                }
            };
            this.Z = this.Z + 1;
            return r0;
        }
    }

    public interface UncaughtThrowableStrategy {

        /* renamed from: a  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f18090a = new UncaughtThrowableStrategy() {
            public void a(Throwable th) {
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f18091b;

        /* renamed from: c  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f18092c = new UncaughtThrowableStrategy() {
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        /* renamed from: d  reason: collision with root package name */
        public static final UncaughtThrowableStrategy f18093d;

        static {
            AnonymousClass2 r0 = new UncaughtThrowableStrategy() {
                public void a(Throwable th) {
                    if (th != null && Log.isLoggable(GlideExecutor.X2, 6)) {
                        Log.e(GlideExecutor.X2, "Request threw uncaught throwable", th);
                    }
                }
            };
            f18091b = r0;
            f18093d = r0;
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    GlideExecutor(ExecutorService executorService) {
        this.s = executorService;
    }

    public static int a() {
        if (c3 == 0) {
            c3 = Math.min(4, RuntimeCompat.a());
        }
        return c3;
    }

    public static Builder b() {
        return new Builder(true).c(a() >= 4 ? 2 : 1).b(Z2);
    }

    public static GlideExecutor c() {
        return b().a();
    }

    @Deprecated
    public static GlideExecutor d(int i2, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return b().c(i2).e(uncaughtThrowableStrategy).a();
    }

    public static Builder e() {
        return new Builder(true).c(1).b(Y);
    }

    public static GlideExecutor f() {
        return e().a();
    }

    @Deprecated
    public static GlideExecutor g(int i2, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return e().c(i2).b(str).e(uncaughtThrowableStrategy).a();
    }

    @Deprecated
    public static GlideExecutor i(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return e().e(uncaughtThrowableStrategy).a();
    }

    public static Builder j() {
        return new Builder(false).c(a()).b("source");
    }

    public static GlideExecutor k() {
        return j().a();
    }

    @Deprecated
    public static GlideExecutor l(int i2, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return j().c(i2).b(str).e(uncaughtThrowableStrategy).a();
    }

    @Deprecated
    public static GlideExecutor m(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return j().e(uncaughtThrowableStrategy).a();
    }

    public static GlideExecutor n() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, a3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(Y2, UncaughtThrowableStrategy.f18093d, false)));
    }

    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.s.awaitTermination(j2, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.s.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.s.invokeAll(collection);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.s.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.s.isShutdown();
    }

    public boolean isTerminated() {
        return this.s.isTerminated();
    }

    public void shutdown() {
        this.s.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.s.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.s.submit(runnable);
    }

    public String toString() {
        return this.s.toString();
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.s.invokeAll(collection, j2, timeUnit);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.s.invokeAny(collection, j2, timeUnit);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.s.submit(runnable, t);
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.s.submit(callable);
    }
}
