package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@KeepForSdk
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final BackgroundDetector X2 = new BackgroundDetector();
    private final AtomicBoolean X = new AtomicBoolean();
    @GuardedBy("instance")
    private final ArrayList Y = new ArrayList();
    @GuardedBy("instance")
    private boolean Z = false;
    private final AtomicBoolean s = new AtomicBoolean();

    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void a(boolean z);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    @NonNull
    @KeepForSdk
    public static BackgroundDetector b() {
        return X2;
    }

    @KeepForSdk
    public static void c(@NonNull Application application) {
        BackgroundDetector backgroundDetector = X2;
        synchronized (backgroundDetector) {
            try {
                if (!backgroundDetector.Z) {
                    application.registerActivityLifecycleCallbacks(backgroundDetector);
                    application.registerComponentCallbacks(backgroundDetector);
                    backgroundDetector.Z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void f(boolean z) {
        synchronized (X2) {
            try {
                Iterator it2 = this.Y.iterator();
                while (it2.hasNext()) {
                    ((BackgroundStateChangeListener) it2.next()).a(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @KeepForSdk
    public void a(@NonNull BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (X2) {
            this.Y.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public boolean d() {
        return this.s.get();
    }

    @TargetApi(16)
    @KeepForSdk
    public boolean e(boolean z) {
        if (!this.X.get()) {
            if (!PlatformVersion.e()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.X.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.s.set(true);
            }
        }
        return d();
    }

    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        AtomicBoolean atomicBoolean = this.X;
        boolean compareAndSet = this.s.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivityDestroyed(@NonNull Activity activity) {
    }

    public final void onActivityPaused(@NonNull Activity activity) {
    }

    public final void onActivityResumed(@NonNull Activity activity) {
        AtomicBoolean atomicBoolean = this.X;
        boolean compareAndSet = this.s.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public final void onActivityStarted(@NonNull Activity activity) {
    }

    public final void onActivityStopped(@NonNull Activity activity) {
    }

    public final void onConfigurationChanged(@NonNull Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.s.compareAndSet(false, true)) {
            this.X.set(true);
            f(true);
        }
    }
}
