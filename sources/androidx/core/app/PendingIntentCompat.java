package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.Closeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.CountDownLatch;

public final class PendingIntentCompat {

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static void a(@NonNull PendingIntent pendingIntent, @NonNull Context context, int i2, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
            pendingIntent.send(context, i2, intent, onFinished, handler, str, bundle);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static PendingIntent a(Context context, int i2, Intent intent, int i3) {
            return PendingIntent.getForegroundService(context, i2, intent, i3);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static class GatedCallback implements Closeable {
        @Nullable
        private PendingIntent.OnFinished X;
        private boolean Y;
        private final CountDownLatch s = new CountDownLatch(1);

        GatedCallback(@Nullable PendingIntent.OnFinished onFinished) {
            this.X = onFinished;
            this.Y = false;
        }

        /* access modifiers changed from: private */
        public void e(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
            boolean z = false;
            while (true) {
                try {
                    this.s.await();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            PendingIntent.OnFinished onFinished = this.X;
            if (onFinished != null) {
                onFinished.onSendFinished(pendingIntent, intent, i2, str, bundle);
                this.X = null;
            }
        }

        public void c() {
            this.Y = true;
        }

        public void close() {
            if (!this.Y) {
                this.X = null;
            }
            this.s.countDown();
        }

        @Nullable
        public PendingIntent.OnFinished d() {
            if (this.X == null) {
                return null;
            }
            return new s(this);
        }
    }

    private PendingIntentCompat() {
    }

    private static int a(boolean z, int i2) {
        int i3;
        if (z) {
            if (Build.VERSION.SDK_INT < 31) {
                return i2;
            }
            i3 = 33554432;
        } else if (Build.VERSION.SDK_INT < 23) {
            return i2;
        } else {
            i3 = 67108864;
        }
        return i2 | i3;
    }

    @NonNull
    public static PendingIntent b(@NonNull Context context, int i2, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i3, @Nullable Bundle bundle, boolean z) {
        return PendingIntent.getActivities(context, i2, intentArr, a(z, i3), bundle);
    }

    @NonNull
    public static PendingIntent c(@NonNull Context context, int i2, @SuppressLint({"ArrayReturn"}) @NonNull Intent[] intentArr, int i3, boolean z) {
        return PendingIntent.getActivities(context, i2, intentArr, a(z, i3));
    }

    @Nullable
    public static PendingIntent d(@NonNull Context context, int i2, @NonNull Intent intent, int i3, @Nullable Bundle bundle, boolean z) {
        return PendingIntent.getActivity(context, i2, intent, a(z, i3), bundle);
    }

    @Nullable
    public static PendingIntent e(@NonNull Context context, int i2, @NonNull Intent intent, int i3, boolean z) {
        return PendingIntent.getActivity(context, i2, intent, a(z, i3));
    }

    @Nullable
    public static PendingIntent f(@NonNull Context context, int i2, @NonNull Intent intent, int i3, boolean z) {
        return PendingIntent.getBroadcast(context, i2, intent, a(z, i3));
    }

    @RequiresApi(26)
    @NonNull
    public static PendingIntent g(@NonNull Context context, int i2, @NonNull Intent intent, int i3, boolean z) {
        return Api26Impl.a(context, i2, intent, a(z, i3));
    }

    @Nullable
    public static PendingIntent h(@NonNull Context context, int i2, @NonNull Intent intent, int i3, boolean z) {
        return PendingIntent.getService(context, i2, intent, a(z, i3));
    }

    @SuppressLint({"LambdaLast"})
    public static void i(@NonNull PendingIntent pendingIntent, int i2, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            pendingIntent.send(i2, gatedCallback.d(), handler);
            gatedCallback.c();
            gatedCallback.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @SuppressLint({"LambdaLast"})
    public static void j(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i2, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler) throws PendingIntent.CanceledException {
        k(pendingIntent, context, i2, intent, onFinished, handler, (String) null, (Bundle) null);
    }

    @SuppressLint({"LambdaLast"})
    public static void k(@NonNull PendingIntent pendingIntent, @SuppressLint({"ContextFirst"}) @NonNull Context context, int i2, @NonNull Intent intent, @Nullable PendingIntent.OnFinished onFinished, @Nullable Handler handler, @Nullable String str, @Nullable Bundle bundle) throws PendingIntent.CanceledException {
        GatedCallback gatedCallback = new GatedCallback(onFinished);
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Api23Impl.a(pendingIntent, context, i2, intent, onFinished, handler, str, bundle);
            } else {
                pendingIntent.send(context, i2, intent, gatedCallback.d(), handler, str);
            }
            gatedCallback.c();
            gatedCallback.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
