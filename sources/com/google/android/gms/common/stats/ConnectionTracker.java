package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

@KeepForSdk
public class ConnectionTracker {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f20351b = new Object();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static volatile ConnectionTracker f20352c;
    @VisibleForTesting
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f20353a = new ConcurrentHashMap();

    private ConnectionTracker() {
    }

    @NonNull
    @KeepForSdk
    public static ConnectionTracker b() {
        if (f20352c == null) {
            synchronized (f20351b) {
                try {
                    if (f20352c == null) {
                        f20352c = new ConnectionTracker();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ConnectionTracker connectionTracker = f20352c;
        Preconditions.r(connectionTracker);
        return connectionTracker;
    }

    private static void f(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    private final boolean g(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i2, boolean z, @Nullable Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((Wrappers.a(context).c(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!h(serviceConnection)) {
            return i(context, intent, serviceConnection, i2, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f20353a.putIfAbsent(serviceConnection, serviceConnection);
        if (!(serviceConnection2 == null || serviceConnection == serviceConnection2)) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", new Object[]{serviceConnection, str, intent.getAction()}));
        }
        try {
            boolean i3 = i(context, intent, serviceConnection, i2, executor);
            if (i3) {
                return i3;
            }
            return false;
        } finally {
            this.f20353a.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean h(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof zzt);
    }

    private static final boolean i(Context context, Intent intent, ServiceConnection serviceConnection, int i2, @Nullable Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!PlatformVersion.p() || executor == null) ? context.bindService(intent, serviceConnection, i2) : context.bindService(intent, i2, executor, serviceConnection);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public boolean a(@NonNull Context context, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i2) {
        return g(context, context.getClass().getName(), intent, serviceConnection, i2, true, (Executor) null);
    }

    @KeepForSdk
    public void c(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        if (!h(serviceConnection) || !this.f20353a.containsKey(serviceConnection)) {
            f(context, serviceConnection);
            return;
        }
        try {
            f(context, (ServiceConnection) this.f20353a.get(serviceConnection));
        } finally {
            this.f20353a.remove(serviceConnection);
        }
    }

    @KeepForSdk
    public void d(@NonNull Context context, @NonNull ServiceConnection serviceConnection) {
        try {
            c(context, serviceConnection);
        } catch (IllegalArgumentException unused) {
        }
    }

    @ResultIgnorabilityUnspecified
    public final boolean e(@NonNull Context context, @NonNull String str, @NonNull Intent intent, @NonNull ServiceConnection serviceConnection, int i2, @Nullable Executor executor) {
        return g(context, str, intent, serviceConnection, 4225, true, executor);
    }
}
