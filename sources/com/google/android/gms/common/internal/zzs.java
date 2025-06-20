package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.common.zzi;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.HashMap;
import java.util.concurrent.Executor;

final class zzs extends GmsClientSupervisor {
    /* access modifiers changed from: private */
    @GuardedBy("connectionStatus")

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f20319f = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Context f20320g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public volatile Handler f20321h;

    /* renamed from: i  reason: collision with root package name */
    private final zzr f20322i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ConnectionTracker f20323j;

    /* renamed from: k  reason: collision with root package name */
    private final long f20324k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final long f20325l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private volatile Executor f20326m;

    zzs(Context context, Looper looper, @Nullable Executor executor) {
        zzr zzr = new zzr(this, (zzq) null);
        this.f20322i = zzr;
        this.f20320g = context.getApplicationContext();
        this.f20321h = new zzi(looper, zzr);
        this.f20323j = ConnectionTracker.b();
        this.f20324k = 5000;
        this.f20325l = 300000;
        this.f20326m = executor;
    }

    /* access modifiers changed from: protected */
    public final void l(zzo zzo, ServiceConnection serviceConnection, String str) {
        Preconditions.s(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f20319f) {
            try {
                zzp zzp = (zzp) this.f20319f.get(zzo);
                if (zzp == null) {
                    String obj = zzo.toString();
                    throw new IllegalStateException("Nonexistent connection status for service config: " + obj);
                } else if (zzp.h(serviceConnection)) {
                    zzp.f(serviceConnection, str);
                    if (zzp.i()) {
                        this.f20321h.sendMessageDelayed(this.f20321h.obtainMessage(0, zzo), this.f20324k);
                    }
                } else {
                    String obj2 = zzo.toString();
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + obj2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean n(zzo zzo, ServiceConnection serviceConnection, String str, @Nullable Executor executor) {
        boolean j2;
        Preconditions.s(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f20319f) {
            try {
                zzp zzp = (zzp) this.f20319f.get(zzo);
                if (executor == null) {
                    executor = this.f20326m;
                }
                if (zzp == null) {
                    zzp = new zzp(this, zzo);
                    zzp.d(serviceConnection, serviceConnection, str);
                    zzp.e(str, executor);
                    this.f20319f.put(zzo, zzp);
                } else {
                    this.f20321h.removeMessages(0, zzo);
                    if (!zzp.h(serviceConnection)) {
                        zzp.d(serviceConnection, serviceConnection, str);
                        int a2 = zzp.a();
                        if (a2 == 1) {
                            serviceConnection.onServiceConnected(zzp.b(), zzp.c());
                        } else if (a2 == 2) {
                            zzp.e(str, executor);
                        }
                    } else {
                        String obj = zzo.toString();
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + obj);
                    }
                }
                j2 = zzp.j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public final void t(@Nullable Executor executor) {
        synchronized (this.f20319f) {
            this.f20326m = executor;
        }
    }

    /* access modifiers changed from: package-private */
    public final void u(Looper looper) {
        synchronized (this.f20319f) {
            this.f20321h = new zzi(looper, this.f20322i);
        }
    }
}
