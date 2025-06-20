package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;

@KeepForSdk
public class ServiceStarter {

    /* renamed from: e  reason: collision with root package name */
    public static final int f24840e = -1;
    @KeepForSdk

    /* renamed from: f  reason: collision with root package name */
    public static final int f24841f = 500;

    /* renamed from: g  reason: collision with root package name */
    static final int f24842g = 404;

    /* renamed from: h  reason: collision with root package name */
    static final int f24843h = 401;

    /* renamed from: i  reason: collision with root package name */
    static final int f24844i = 402;

    /* renamed from: j  reason: collision with root package name */
    static final int f24845j = 403;

    /* renamed from: k  reason: collision with root package name */
    static final String f24846k = "com.google.firebase.MESSAGING_EVENT";

    /* renamed from: l  reason: collision with root package name */
    private static final String f24847l = "wrapped_intent";

    /* renamed from: m  reason: collision with root package name */
    private static final String f24848m = "this should normally be included by the manifest merger, but may needed to be manually added to your manifest";

    /* renamed from: n  reason: collision with root package name */
    private static ServiceStarter f24849n;
    @GuardedBy("this")
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f24850a = null;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f24851b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f24852c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Intent> f24853d = new ArrayDeque();

    private ServiceStarter() {
    }

    private int a(Context context, Intent intent) {
        ComponentName componentName;
        String f2 = f(context, intent);
        if (f2 != null) {
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "Restricting intent to a specific service: " + f2);
            }
            intent.setClassName(context.getPackageName(), f2);
        }
        try {
            if (e(context)) {
                componentName = WakeLockHolder.k(context, intent);
            } else {
                componentName = context.startService(intent);
                Log.d(Constants.f24670a, "Missing wake lock permission, service start may be delayed");
            }
            if (componentName != null) {
                return -1;
            }
            Log.e(Constants.f24670a, "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (SecurityException e2) {
            Log.e(Constants.f24670a, "Error while delivering the message to the serviceIntent", e2);
            return 401;
        } catch (IllegalStateException e3) {
            Log.e(Constants.f24670a, "Failed to start service while in background: " + e3);
            return 402;
        }
    }

    static synchronized ServiceStarter b() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            try {
                if (f24849n == null) {
                    f24849n = new ServiceStarter();
                }
                serviceStarter = f24849n;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return serviceStarter;
    }

    @Nullable
    private synchronized String f(Context context, Intent intent) {
        String str;
        try {
            String str2 = this.f24850a;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveService != null) {
                ServiceInfo serviceInfo = resolveService.serviceInfo;
                if (serviceInfo != null) {
                    if (context.getPackageName().equals(serviceInfo.packageName)) {
                        String str3 = serviceInfo.name;
                        if (str3 != null) {
                            if (str3.startsWith(".")) {
                                str = context.getPackageName() + serviceInfo.name;
                            } else {
                                str = serviceInfo.name;
                            }
                            this.f24850a = str;
                            return this.f24850a;
                        }
                    }
                    Log.e(Constants.f24670a, "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                    return null;
                }
            }
            Log.e(Constants.f24670a, "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public static void g(ServiceStarter serviceStarter) {
        f24849n = serviceStarter;
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public Intent c() {
        return this.f24853d.poll();
    }

    /* access modifiers changed from: package-private */
    public boolean d(Context context) {
        if (this.f24852c == null) {
            this.f24852c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f24851b.booleanValue() && Log.isLoggable(Constants.f24670a, 3)) {
            Log.d(Constants.f24670a, "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f24852c.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean e(Context context) {
        if (this.f24851b == null) {
            this.f24851b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f24851b.booleanValue() && Log.isLoggable(Constants.f24670a, 3)) {
            Log.d(Constants.f24670a, "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f24851b.booleanValue();
    }

    @MainThread
    public int h(Context context, Intent intent) {
        if (Log.isLoggable(Constants.f24670a, 3)) {
            Log.d(Constants.f24670a, "Starting service");
        }
        this.f24853d.offer(intent);
        Intent intent2 = new Intent(f24846k);
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
