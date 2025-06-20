package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import androidx.media3.exoplayer.dash.offline.a;
import com.google.android.gms.common.util.PlatformVersion;

final class ProxyNotificationPreferences {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24819a = "com.google.firebase.messaging";

    private ProxyNotificationPreferences() {
    }

    private static SharedPreferences b(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences("com.google.firebase.messaging", 0);
    }

    @WorkerThread
    static boolean c(Context context) {
        return b(context).getBoolean("proxy_notification_initialized", false);
    }

    @WorkerThread
    static boolean d(SharedPreferences sharedPreferences, boolean z) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z;
    }

    @WorkerThread
    static void f(Context context, boolean z) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putBoolean("proxy_notification_initialized", z);
        edit.apply();
    }

    @WorkerThread
    static void g(Context context, GmsRpc gmsRpc, boolean z) {
        if (PlatformVersion.p() && !d(b(context), z)) {
            gmsRpc.l(z).l(new a(), new F(context, z));
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public static void h(Context context, boolean z) {
        SharedPreferences.Editor edit = b(context).edit();
        edit.putBoolean("proxy_retention", z);
        edit.apply();
    }
}
