package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3376a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f3377b = Executors.newFixedThreadPool(4, new ThreadFactory() {
        private static final String Y = "arch_disk_io_";
        private final AtomicInteger s = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(Y + this.s.getAndIncrement());
            return thread;
        }
    });
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f3378c;

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @NonNull
        public static Handler a(@NonNull Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @NonNull
    private static Handler e(@NonNull Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    public void a(@NonNull Runnable runnable) {
        this.f3377b.execute(runnable);
    }

    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void d(@NonNull Runnable runnable) {
        if (this.f3378c == null) {
            synchronized (this.f3376a) {
                try {
                    if (this.f3378c == null) {
                        this.f3378c = e(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f3378c.post(runnable);
    }
}
