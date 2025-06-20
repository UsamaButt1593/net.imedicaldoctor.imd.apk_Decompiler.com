package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.media3.exoplayer.dash.offline.a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@KeepForSdk
public class FcmBroadcastProcessor {

    /* renamed from: c  reason: collision with root package name */
    private static final String f24738c = "rawData";

    /* renamed from: d  reason: collision with root package name */
    private static final String f24739d = "gcm.rawData64";

    /* renamed from: e  reason: collision with root package name */
    private static final Object f24740e = new Object();
    @GuardedBy("lock")

    /* renamed from: f  reason: collision with root package name */
    private static WithinAppServiceConnection f24741f;

    /* renamed from: a  reason: collision with root package name */
    private final Context f24742a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f24743b;

    public FcmBroadcastProcessor(Context context) {
        this.f24742a = context;
        this.f24743b = new a();
    }

    private static Task<Integer> e(Context context, Intent intent, boolean z) {
        if (Log.isLoggable(Constants.f24670a, 3)) {
            Log.d(Constants.f24670a, "Binding to service");
        }
        WithinAppServiceConnection f2 = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z) {
            return f2.c(intent).n(new a(), new C0491g());
        }
        if (ServiceStarter.b().e(context)) {
            WakeLockHolder.i(context, f2, intent);
        } else {
            f2.c(intent);
        }
        return Tasks.g(-1);
    }

    private static WithinAppServiceConnection f(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (f24740e) {
            try {
                if (f24741f == null) {
                    f24741f = new WithinAppServiceConnection(context, str);
                }
                withinAppServiceConnection = f24741f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return withinAppServiceConnection;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer g(Task task) throws Exception {
        return -1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer i(Task task) throws Exception {
        return 403;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Task j(Context context, Intent intent, boolean z, Task task) throws Exception {
        return (!PlatformVersion.n() || ((Integer) task.r()).intValue() != 402) ? task : e(context, intent, z).n(new a(), new C0488d());
    }

    @VisibleForTesting
    public static void l() {
        synchronized (f24740e) {
            f24741f = null;
        }
    }

    @VisibleForTesting
    public static void m(WithinAppServiceConnection withinAppServiceConnection) {
        synchronized (f24740e) {
            f24741f = withinAppServiceConnection;
        }
    }

    @KeepForSdk
    public Task<Integer> k(Intent intent) {
        String stringExtra = intent.getStringExtra(f24739d);
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra(f24739d);
        }
        return n(this.f24742a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> n(Context context, Intent intent) {
        boolean z = false;
        boolean z2 = PlatformVersion.n() && context.getApplicationInfo().targetSdkVersion >= 26;
        if ((intent.getFlags() & 268435456) != 0) {
            z = true;
        }
        return (!z2 || z) ? Tasks.d(this.f24743b, new C0489e(context, intent)).p(this.f24743b, new C0490f(context, intent, z)) : e(context, intent, z);
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.f24742a = context;
        this.f24743b = executorService;
    }
}
