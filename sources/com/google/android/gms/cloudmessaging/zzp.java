package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.cloudmessaging.zzf;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

final class zzp implements ServiceConnection {
    final Messenger X = new Messenger(new zzf(Looper.getMainLooper(), new zzm(this)));
    final SparseArray X2 = new SparseArray();
    zzq Y;
    final /* synthetic */ zzv Y2;
    final Queue Z = new ArrayDeque();
    int s = 0;

    /* synthetic */ zzp(zzv zzv, zzo zzo) {
        this.Y2 = zzv;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(int i2, @Nullable String str) {
        b(i2, str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(int i2, @Nullable String str, @Nullable Throwable th) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i3 = this.s;
            if (i3 == 0) {
                throw new IllegalStateException();
            } else if (i3 == 1 || i3 == 2) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.s = 4;
                ConnectionTracker.b().c(this.Y2.f19834a, this);
                zzt zzt = new zzt(i2, str, th);
                for (zzs c2 : this.Z) {
                    c2.c(zzt);
                }
                this.Z.clear();
                for (int i4 = 0; i4 < this.X2.size(); i4++) {
                    ((zzs) this.X2.valueAt(i4)).c(zzt);
                }
                this.X2.clear();
            } else if (i3 == 3) {
                this.s = 4;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.Y2.f19835b.execute(new zzj(this));
    }

    /* access modifiers changed from: package-private */
    public final synchronized void d() {
        if (this.s == 1) {
            a(1, "Timed out while binding");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e(int i2) {
        zzs zzs = (zzs) this.X2.get(i2);
        if (zzs != null) {
            Log.w("MessengerIpcClient", "Timing out request: " + i2);
            this.X2.remove(i2);
            zzs.c(new zzt(3, "Timed out waiting for response", (Throwable) null));
            f();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void f() {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.s     // Catch:{ all -> 0x0026 }
            r1 = 2
            if (r0 != r1) goto L_0x003a
            java.util.Queue r0 = r2.Z     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x003a
            android.util.SparseArray r0 = r2.X2     // Catch:{ all -> 0x0026 }
            int r0 = r0.size()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x003a
            java.lang.String r0 = "MessengerIpcClient"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "MessengerIpcClient"
            java.lang.String r1 = "Finished handling requests, unbinding"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r0 = move-exception
            goto L_0x003c
        L_0x0028:
            r0 = 3
            r2.s = r0     // Catch:{ all -> 0x0026 }
            com.google.android.gms.cloudmessaging.zzv r0 = r2.Y2     // Catch:{ all -> 0x0026 }
            com.google.android.gms.common.stats.ConnectionTracker r1 = com.google.android.gms.common.stats.ConnectionTracker.b()     // Catch:{ all -> 0x0026 }
            android.content.Context r0 = r0.f19834a     // Catch:{ all -> 0x0026 }
            r1.c(r0, r2)     // Catch:{ all -> 0x0026 }
            monitor-exit(r2)
            return
        L_0x003a:
            monitor-exit(r2)
            return
        L_0x003c:
            monitor-exit(r2)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzp.f():void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean g(zzs zzs) {
        int i2 = this.s;
        if (i2 == 0) {
            this.Z.add(zzs);
            Preconditions.x(this.s == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.s = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            try {
                if (!ConnectionTracker.b().a(this.Y2.f19834a, intent, this, 1)) {
                    a(0, "Unable to bind to service");
                } else {
                    this.Y2.f19835b.schedule(new zzk(this), 30, TimeUnit.SECONDS);
                }
            } catch (SecurityException e2) {
                b(0, "Unable to bind to service", e2);
            }
        } else if (i2 == 1) {
            this.Z.add(zzs);
            return true;
        } else if (i2 != 2) {
            return false;
        } else {
            this.Z.add(zzs);
            c();
            return true;
        }
        return true;
    }

    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.Y2.f19835b.execute(new zzi(this, iBinder));
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.Y2.f19835b.execute(new zzl(this));
    }
}
