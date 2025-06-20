package androidx.emoji2.text;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class ConcurrencyHelpers {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7568a = 15;

    @RequiresApi(28)
    static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    private ConcurrencyHelpers() {
    }

    @NonNull
    @Deprecated
    static Executor b(@NonNull Handler handler) {
        Objects.requireNonNull(handler);
        return new a(handler);
    }

    static ThreadPoolExecutor c(@NonNull String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Thread d(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }

    static Handler e() {
        return Build.VERSION.SDK_INT >= 28 ? Handler28Impl.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper());
    }
}
