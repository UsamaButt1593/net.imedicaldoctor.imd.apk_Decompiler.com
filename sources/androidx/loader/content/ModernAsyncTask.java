package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final String Y2 = "AsyncTask";
    private static final int Z2 = 5;
    private static final int a3 = 128;
    private static final int b3 = 1;
    private static final ThreadFactory c3;
    private static final BlockingQueue<Runnable> d3;
    public static final Executor e3;
    private static final int f3 = 1;
    private static final int g3 = 2;
    private static InternalHandler h3;
    private static volatile Executor i3;
    private final FutureTask<Result> X;
    final AtomicBoolean X2 = new AtomicBoolean();
    private volatile Status Y = Status.PENDING;
    final AtomicBoolean Z = new AtomicBoolean();
    private final WorkerRunnable<Params, Result> s;

    /* renamed from: androidx.loader.content.ModernAsyncTask$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8832a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.loader.content.ModernAsyncTask$Status[] r0 = androidx.loader.content.ModernAsyncTask.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8832a = r0
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.RUNNING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8832a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.loader.content.ModernAsyncTask$Status r1 = androidx.loader.content.ModernAsyncTask.Status.FINISHED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.content.ModernAsyncTask.AnonymousClass4.<clinit>():void");
        }
    }

    private static class AsyncTaskResult<Data> {

        /* renamed from: a  reason: collision with root package name */
        final ModernAsyncTask f8833a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f8834b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f8833a = modernAsyncTask;
            this.f8834b = dataArr;
        }
    }

    private static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                asyncTaskResult.f8833a.f(asyncTaskResult.f8834b[0]);
            } else if (i2 == 2) {
                asyncTaskResult.f8833a.p(asyncTaskResult.f8834b);
            }
        }
    }

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] s;

        WorkerRunnable() {
        }
    }

    static {
        AnonymousClass1 r7 = new ThreadFactory() {
            private final AtomicInteger s = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ModernAsyncTask #" + this.s.getAndIncrement());
            }
        };
        c3 = r7;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        d3 = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, linkedBlockingQueue, r7);
        e3 = threadPoolExecutor;
        i3 = threadPoolExecutor;
    }

    ModernAsyncTask() {
        AnonymousClass2 r0 = new WorkerRunnable<Params, Result>() {
            public Result call() throws Exception {
                ModernAsyncTask.this.X2.set(true);
                Result result = null;
                try {
                    Process.setThreadPriority(10);
                    result = ModernAsyncTask.this.b(this.s);
                    Binder.flushPendingCommands();
                    ModernAsyncTask.this.q(result);
                    return result;
                } catch (Throwable th) {
                    ModernAsyncTask.this.q(result);
                    throw th;
                }
            }
        };
        this.s = r0;
        this.X = new FutureTask<Result>(r0) {
            /* access modifiers changed from: protected */
            public void done() {
                try {
                    ModernAsyncTask.this.r(get());
                } catch (InterruptedException e2) {
                    Log.w(ModernAsyncTask.Y2, e2);
                } catch (ExecutionException e3) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
                } catch (CancellationException unused) {
                    ModernAsyncTask.this.r(null);
                } catch (Throwable th) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", th);
                }
            }
        };
    }

    public static void d(Runnable runnable) {
        i3.execute(runnable);
    }

    private static Handler i() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            try {
                if (h3 == null) {
                    h3 = new InternalHandler();
                }
                internalHandler = h3;
            } catch (Throwable th) {
                throw th;
            }
        }
        return internalHandler;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void t(Executor executor) {
        i3 = executor;
    }

    public final boolean a(boolean z) {
        this.Z.set(true);
        return this.X.cancel(z);
    }

    /* access modifiers changed from: protected */
    public abstract Result b(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> c(Params... paramsArr) {
        return e(i3, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> e(Executor executor, Params... paramsArr) {
        if (this.Y != Status.PENDING) {
            int i2 = AnonymousClass4.f8832a[this.Y.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i2 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.Y = Status.RUNNING;
            o();
            this.s.s = paramsArr;
            executor.execute(this.X);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Result result) {
        if (k()) {
            m(result);
        } else {
            n(result);
        }
        this.Y = Status.FINISHED;
    }

    public final Result g() throws InterruptedException, ExecutionException {
        return this.X.get();
    }

    public final Result h(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.X.get(j2, timeUnit);
    }

    public final Status j() {
        return this.Y;
    }

    public final boolean k() {
        return this.Z.get();
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    /* access modifiers changed from: protected */
    public void m(Result result) {
        l();
    }

    /* access modifiers changed from: protected */
    public void n(Result result) {
    }

    /* access modifiers changed from: protected */
    public void o() {
    }

    /* access modifiers changed from: protected */
    public void p(Progress... progressArr) {
    }

    /* access modifiers changed from: package-private */
    public Result q(Result result) {
        i().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: package-private */
    public void r(Result result) {
        if (!this.X2.get()) {
            q(result);
        }
    }

    /* access modifiers changed from: protected */
    public final void s(Progress... progressArr) {
        if (!k()) {
            i().obtainMessage(2, new AsyncTaskResult(this, progressArr)).sendToTarget();
        }
    }
}
