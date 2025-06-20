package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.dash.offline.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.WithinAppServiceBinder;
import java.util.concurrent.ExecutorService;

@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
public abstract class EnhancedIntentService extends Service {
    static final long Y2 = 20;
    private static final String Z2 = "EnhancedIntentService";
    private Binder X;
    private int X2 = 0;
    private final Object Y = new Object();
    private int Z;
    @VisibleForTesting
    final ExecutorService s = FcmExecutors.e();

    private void d(Intent intent) {
        if (intent != null) {
            WakeLockHolder.d(intent);
        }
        synchronized (this.Y) {
            try {
                int i2 = this.X2 - 1;
                this.X2 = i2;
                if (i2 == 0) {
                    k(this.Z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(Intent intent, Task task) {
        d(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Intent intent, TaskCompletionSource taskCompletionSource) {
        try {
            f(intent);
        } finally {
            taskCompletionSource.c(null);
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public Task<Void> j(Intent intent) {
        if (g(intent)) {
            return Tasks.g(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.s.execute(new C0487c(this, intent, taskCompletionSource));
        return taskCompletionSource.a();
    }

    /* access modifiers changed from: protected */
    public Intent e(Intent intent) {
        return intent;
    }

    public abstract void f(Intent intent);

    public boolean g(Intent intent) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean k(int i2) {
        return stopSelfResult(i2);
    }

    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable(Z2, 3)) {
                Log.d(Z2, "Service received bind request");
            }
            if (this.X == null) {
                this.X = new WithinAppServiceBinder(new WithinAppServiceBinder.IntentHandler() {
                    @KeepForSdk
                    public Task<Void> a(Intent intent) {
                        return EnhancedIntentService.this.j(intent);
                    }
                });
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.X;
    }

    @CallSuper
    public void onDestroy() {
        this.s.shutdown();
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.Y) {
            this.Z = i3;
            this.X2++;
        }
        Intent e2 = e(intent);
        if (e2 == null) {
            d(intent);
            return 2;
        }
        Task<Void> j2 = j(e2);
        if (j2.u()) {
            d(intent);
            return 2;
        }
        j2.f(new a(), new C0486b(this, intent));
        return 3;
    }
}
