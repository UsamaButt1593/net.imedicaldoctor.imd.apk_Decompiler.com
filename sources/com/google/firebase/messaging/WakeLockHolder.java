package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.WakeLock;
import com.google.errorprone.annotations.RestrictedApi;
import java.util.concurrent.TimeUnit;

final class WakeLockHolder {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24902a = "com.google.firebase.iid.WakeLockHolder.wakefulintent";

    /* renamed from: b  reason: collision with root package name */
    static final long f24903b = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f24904c = new Object();
    @GuardedBy("WakeLockHolder.syncObject")

    /* renamed from: d  reason: collision with root package name */
    private static WakeLock f24905d;

    WakeLockHolder() {
    }

    @RestrictedApi(allowedOnPath = ".*firebase(-|_)(iid|messaging)/.*", explanation = "To be used for testing purpose only", link = "")
    static void b(Intent intent, long j2) {
        synchronized (f24904c) {
            try {
                if (f24905d != null) {
                    j(intent, true);
                    f24905d.a(j2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @GuardedBy("WakeLockHolder.syncObject")
    private static void c(Context context) {
        if (f24905d == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f24905d = wakeLock;
            wakeLock.d(true);
        }
    }

    /* access modifiers changed from: package-private */
    public static void d(@NonNull Intent intent) {
        synchronized (f24904c) {
            try {
                if (f24905d != null && f(intent)) {
                    j(intent, false);
                    f24905d.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictedApi(allowedOnPath = ".*firebase(-|_)(iid|messaging)/.*", explanation = "To be used for testing purpose only", link = "")
    static void e(Context context) {
        synchronized (f24904c) {
            c(context);
        }
    }

    @VisibleForTesting
    static boolean f(@NonNull Intent intent) {
        return intent.getBooleanExtra(f24902a, false);
    }

    @RestrictedApi(allowedOnPath = ".*firebase(-|_)(iid|messaging)/.*", explanation = "To be used for testing purpose only", link = "")
    static void h() {
        synchronized (f24904c) {
            f24905d = null;
        }
    }

    @SuppressLint({"TaskMainThread"})
    static void i(Context context, WithinAppServiceConnection withinAppServiceConnection, Intent intent) {
        synchronized (f24904c) {
            try {
                c(context);
                boolean f2 = f(intent);
                j(intent, true);
                if (!f2) {
                    f24905d.a(f24903b);
                }
                withinAppServiceConnection.c(intent).e(new J(intent));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void j(@NonNull Intent intent, boolean z) {
        intent.putExtra(f24902a, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.content.ComponentName k(@androidx.annotation.NonNull android.content.Context r3, @androidx.annotation.NonNull android.content.Intent r4) {
        /*
            java.lang.Object r0 = f24904c
            monitor-enter(r0)
            c(r3)     // Catch:{ all -> 0x0017 }
            boolean r1 = f(r4)     // Catch:{ all -> 0x0017 }
            r2 = 1
            j(r4, r2)     // Catch:{ all -> 0x0017 }
            android.content.ComponentName r3 = r3.startService(r4)     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            r3 = 0
            return r3
        L_0x0017:
            r3 = move-exception
            goto L_0x0024
        L_0x0019:
            if (r1 != 0) goto L_0x0022
            com.google.android.gms.stats.WakeLock r4 = f24905d     // Catch:{ all -> 0x0017 }
            long r1 = f24903b     // Catch:{ all -> 0x0017 }
            r4.a(r1)     // Catch:{ all -> 0x0017 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            return r3
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0017 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.WakeLockHolder.k(android.content.Context, android.content.Intent):android.content.ComponentName");
    }
}
