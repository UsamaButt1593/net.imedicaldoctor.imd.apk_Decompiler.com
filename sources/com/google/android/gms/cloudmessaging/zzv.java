package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zze;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class zzv {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static zzv f19833e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f19834a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f19835b;

    /* renamed from: c  reason: collision with root package name */
    private zzp f19836c = new zzp(this, (zzo) null);

    /* renamed from: d  reason: collision with root package name */
    private int f19837d = 1;

    @VisibleForTesting
    zzv(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f19835b = scheduledExecutorService;
        this.f19834a = context.getApplicationContext();
    }

    public static synchronized zzv b(Context context) {
        zzv zzv;
        synchronized (zzv.class) {
            try {
                if (f19833e == null) {
                    zze.zza();
                    f19833e = new zzv(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
                }
                zzv = f19833e;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return zzv;
    }

    private final synchronized int f() {
        int i2;
        i2 = this.f19837d;
        this.f19837d = i2 + 1;
        return i2;
    }

    private final synchronized Task g(zzs zzs) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(zzs.toString()));
            }
            if (!this.f19836c.g(zzs)) {
                zzp zzp = new zzp(this, (zzo) null);
                this.f19836c = zzp;
                zzp.g(zzs);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return zzs.f19830b.a();
    }

    public final Task c(int i2, Bundle bundle) {
        return g(new zzr(f(), i2, bundle));
    }

    public final Task d(int i2, Bundle bundle) {
        return g(new zzu(f(), i2, bundle));
    }
}
