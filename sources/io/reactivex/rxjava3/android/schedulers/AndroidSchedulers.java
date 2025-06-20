package io.reactivex.rxjava3.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins;
import io.reactivex.rxjava3.core.Scheduler;

public final class AndroidSchedulers {

    /* renamed from: a  reason: collision with root package name */
    private static final Scheduler f18883a = RxAndroidPlugins.f(new b());

    private static final class MainHolder {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public static final Scheduler f18884a = new HandlerScheduler(new Handler(Looper.getMainLooper()), true);

        private MainHolder() {
        }
    }

    private AndroidSchedulers() {
        throw new AssertionError("No instances.");
    }

    public static Scheduler b(Looper looper) {
        return c(looper, true);
    }

    @SuppressLint({"NewApi"})
    public static Scheduler c(Looper looper, boolean z) {
        if (looper != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (z && i2 < 22) {
                Message obtain = Message.obtain();
                try {
                    obtain.setAsynchronous(true);
                } catch (NoSuchMethodError unused) {
                    z = false;
                }
                obtain.recycle();
            }
            return new HandlerScheduler(new Handler(looper), z);
        }
        throw new NullPointerException("looper == null");
    }

    public static Scheduler e() {
        return RxAndroidPlugins.g(f18883a);
    }
}
