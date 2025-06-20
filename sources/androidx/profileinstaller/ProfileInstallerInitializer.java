package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements Initializer<Result> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f15111a = 5000;

    @RequiresApi(16)
    private static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        @DoNotInline
        public static void c(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new h(runnable));
        }
    }

    @RequiresApi(28)
    private static class Handler28Impl {
        private Handler28Impl() {
        }

        @DoNotInline
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class Result {
    }

    /* access modifiers changed from: private */
    public static void k(@NonNull Context context) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new g(context));
    }

    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    @NonNull
    /* renamed from: e */
    public Result a(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new Result();
        }
        f(context.getApplicationContext());
        return new Result();
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(16)
    public void f(@NonNull Context context) {
        Choreographer16Impl.c(new f(this, context));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void h(@NonNull Context context) {
        (Build.VERSION.SDK_INT >= 28 ? Handler28Impl.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new e(context), (long) (new Random().nextInt(Math.max(1000, 1)) + 5000));
    }
}
