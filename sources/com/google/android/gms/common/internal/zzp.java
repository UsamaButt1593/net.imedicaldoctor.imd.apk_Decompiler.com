package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

final class zzp implements ServiceConnection, zzt {
    private int X = 2;
    private final zzo X2;
    private boolean Y;
    private ComponentName Y2;
    @Nullable
    private IBinder Z;
    final /* synthetic */ zzs Z2;
    private final Map s = new HashMap();

    public zzp(zzs zzs, zzo zzo) {
        this.Z2 = zzs;
        this.X2 = zzo;
    }

    public final int a() {
        return this.X;
    }

    public final ComponentName b() {
        return this.Y2;
    }

    @Nullable
    public final IBinder c() {
        return this.Z;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.s.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, @Nullable Executor executor) {
        this.X = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.r()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            zzs zzs = this.Z2;
            boolean e2 = zzs.f20323j.e(zzs.f20320g, str, this.X2.b(zzs.f20320g), this, 4225, executor);
            this.Y = e2;
            if (e2) {
                this.Z2.f20321h.sendMessageDelayed(this.Z2.f20321h.obtainMessage(1, this.X2), this.Z2.f20325l);
            } else {
                this.X = 2;
                try {
                    zzs zzs2 = this.Z2;
                    zzs2.f20323j.c(zzs2.f20320g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.s.remove(serviceConnection);
    }

    public final void g(String str) {
        this.Z2.f20321h.removeMessages(1, this.X2);
        zzs zzs = this.Z2;
        zzs.f20323j.c(zzs.f20320g, this);
        this.Y = false;
        this.X = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.s.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.s.isEmpty();
    }

    public final boolean j() {
        return this.Y;
    }

    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.Z2.f20319f) {
            try {
                this.Z2.f20321h.removeMessages(1, this.X2);
                this.Z = iBinder;
                this.Y2 = componentName;
                for (ServiceConnection onServiceConnected : this.s.values()) {
                    onServiceConnected.onServiceConnected(componentName, iBinder);
                }
                this.X = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.Z2.f20319f) {
            try {
                this.Z2.f20321h.removeMessages(1, this.X2);
                this.Z = null;
                this.Y2 = componentName;
                for (ServiceConnection onServiceDisconnected : this.s.values()) {
                    onServiceDisconnected.onServiceDisconnected(componentName);
                }
                this.X = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
