package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.media3.exoplayer.dash.offline.a;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;

final class ProxyNotificationInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24818a = "firebase_messaging_notification_delegation_enabled";

    private ProxyNotificationInitializer() {
    }

    private static boolean b(Context context) {
        return Binder.getCallingUid() == context.getApplicationInfo().uid;
    }

    @WorkerThread
    static void c(Context context) {
        if (!ProxyNotificationPreferences.c(context)) {
            f(new a(), context, g(context));
        }
    }

    static boolean d(Context context) {
        if (!PlatformVersion.p()) {
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "Platform doesn't support proxying.");
            }
            return false;
        } else if (!b(context)) {
            Log.e(Constants.f24670a, "error retrieving notification delegate for package " + context.getPackageName());
            return false;
        } else if (!"com.google.android.gms".equals(((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationDelegate())) {
            return false;
        } else {
            if (!Log.isLoggable(Constants.f24670a, 3)) {
                return true;
            }
            Log.d(Constants.f24670a, "GMS core is set for proxying");
            return true;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(Context context, boolean z, TaskCompletionSource taskCompletionSource) {
        try {
            if (!b(context)) {
                Log.e(Constants.f24670a, "error configuring notification delegate for package " + context.getPackageName());
                return;
            }
            ProxyNotificationPreferences.f(context, true);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
            if (z) {
                notificationManager.setNotificationDelegate("com.google.android.gms");
            } else if ("com.google.android.gms".equals(notificationManager.getNotificationDelegate())) {
                notificationManager.setNotificationDelegate((String) null);
            }
            taskCompletionSource.e(null);
        } finally {
            taskCompletionSource.e(null);
        }
    }

    @TargetApi(29)
    static Task<Void> f(Executor executor, Context context, boolean z) {
        if (!PlatformVersion.p()) {
            return Tasks.g(null);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new E(context, z, taskCompletionSource));
        return taskCompletionSource.a();
    }

    private static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            Context applicationContext = context.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(f24818a)) {
                return true;
            }
            return applicationInfo.metaData.getBoolean(f24818a);
        } catch (PackageManager.NameNotFoundException unused) {
            return true;
        }
    }
}
