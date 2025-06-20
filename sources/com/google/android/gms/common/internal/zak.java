package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zaq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zak implements Handler.Callback {
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> X = new ArrayList<>();
    private volatile boolean X2 = false;
    @VisibleForTesting
    final ArrayList<GoogleApiClient.ConnectionCallbacks> Y = new ArrayList<>();
    private final AtomicInteger Y2 = new AtomicInteger(0);
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> Z = new ArrayList<>();
    private boolean Z2 = false;
    private final Handler a3;
    private final Object b3 = new Object();
    @NotOnlyInitialized
    private final zaj s;

    public zak(Looper looper, zaj zaj) {
        this.s = zaj;
        this.a3 = new zaq(looper, this);
    }

    public final void a() {
        this.X2 = false;
        this.Y2.incrementAndGet();
    }

    public final void b() {
        this.X2 = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        return;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            android.os.Handler r0 = r5.a3
            java.lang.String r1 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.Preconditions.i(r0, r1)
            android.os.Handler r0 = r5.a3
            r1 = 1
            r0.removeMessages(r1)
            java.lang.Object r0 = r5.b3
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0046 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r5.Z     // Catch:{ all -> 0x0046 }
            r1.<init>(r2)     // Catch:{ all -> 0x0046 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.Y2     // Catch:{ all -> 0x0046 }
            int r2 = r2.get()     // Catch:{ all -> 0x0046 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0046 }
        L_0x0021:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0046 }
            if (r3 == 0) goto L_0x004a
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0046 }
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r3 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r3     // Catch:{ all -> 0x0046 }
            boolean r4 = r5.X2     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0048
            java.util.concurrent.atomic.AtomicInteger r4 = r5.Y2     // Catch:{ all -> 0x0046 }
            int r4 = r4.get()     // Catch:{ all -> 0x0046 }
            if (r4 == r2) goto L_0x003a
            goto L_0x0048
        L_0x003a:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r4 = r5.Z     // Catch:{ all -> 0x0046 }
            boolean r4 = r4.contains(r3)     // Catch:{ all -> 0x0046 }
            if (r4 == 0) goto L_0x0021
            r3.f(r6)     // Catch:{ all -> 0x0046 }
            goto L_0x0021
        L_0x0046:
            r6 = move-exception
            goto L_0x004c
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zak.c(com.google.android.gms.common.ConnectionResult):void");
    }

    @VisibleForTesting
    public final void d(@Nullable Bundle bundle) {
        Preconditions.i(this.a3, "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.b3) {
            try {
                Preconditions.x(!this.Z2);
                this.a3.removeMessages(1);
                this.Z2 = true;
                Preconditions.x(this.Y.isEmpty());
                ArrayList arrayList = new ArrayList(this.X);
                int i2 = this.Y2.get();
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it2.next();
                    if (!this.X2 || !this.s.j()) {
                        break;
                    } else if (this.Y2.get() != i2) {
                        break;
                    } else if (!this.Y.contains(connectionCallbacks)) {
                        connectionCallbacks.z(bundle);
                    }
                }
                this.Y.clear();
                this.Z2 = false;
            } finally {
            }
        }
    }

    @VisibleForTesting
    public final void e(int i2) {
        Preconditions.i(this.a3, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.a3.removeMessages(1);
        synchronized (this.b3) {
            try {
                this.Z2 = true;
                ArrayList arrayList = new ArrayList(this.X);
                int i3 = this.Y2.get();
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it2.next();
                    if (!this.X2) {
                        break;
                    } else if (this.Y2.get() != i3) {
                        break;
                    } else if (this.X.contains(connectionCallbacks)) {
                        connectionCallbacks.e(i2);
                    }
                }
                this.Y.clear();
                this.Z2 = false;
            } finally {
            }
        }
    }

    public final void f(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.r(connectionCallbacks);
        synchronized (this.b3) {
            try {
                if (this.X.contains(connectionCallbacks)) {
                    String valueOf = String.valueOf(connectionCallbacks);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 62);
                    sb.append("registerConnectionCallbacks(): listener ");
                    sb.append(valueOf);
                    sb.append(" is already registered");
                    Log.w("GmsClientEvents", sb.toString());
                } else {
                    this.X.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (this.s.j()) {
            Handler handler = this.a3;
            handler.sendMessage(handler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void g(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.r(onConnectionFailedListener);
        synchronized (this.b3) {
            try {
                if (this.Z.contains(onConnectionFailedListener)) {
                    String valueOf = String.valueOf(onConnectionFailedListener);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 67);
                    sb.append("registerConnectionFailedListener(): listener ");
                    sb.append(valueOf);
                    sb.append(" is already registered");
                    Log.w("GmsClientEvents", sb.toString());
                } else {
                    this.Z.add(onConnectionFailedListener);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.r(connectionCallbacks);
        synchronized (this.b3) {
            try {
                if (!this.X.remove(connectionCallbacks)) {
                    String valueOf = String.valueOf(connectionCallbacks);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 52);
                    sb.append("unregisterConnectionCallbacks(): listener ");
                    sb.append(valueOf);
                    sb.append(" not found");
                    Log.w("GmsClientEvents", sb.toString());
                } else if (this.Z2) {
                    this.Y.add(connectionCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.b3) {
                try {
                    if (this.X2 && this.s.j() && this.X.contains(connectionCallbacks)) {
                        connectionCallbacks.z((Bundle) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i2);
        Log.wtf("GmsClientEvents", sb.toString(), new Exception());
        return false;
    }

    public final void i(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.r(onConnectionFailedListener);
        synchronized (this.b3) {
            try {
                if (!this.Z.remove(onConnectionFailedListener)) {
                    String valueOf = String.valueOf(onConnectionFailedListener);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 57);
                    sb.append("unregisterConnectionFailedListener(): listener ");
                    sb.append(valueOf);
                    sb.append(" not found");
                    Log.w("GmsClientEvents", sb.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean j(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.r(connectionCallbacks);
        synchronized (this.b3) {
            contains = this.X.contains(connectionCallbacks);
        }
        return contains;
    }

    public final boolean k(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.r(onConnectionFailedListener);
        synchronized (this.b3) {
            contains = this.Z.contains(onConnectionFailedListener);
        }
        return contains;
    }
}
