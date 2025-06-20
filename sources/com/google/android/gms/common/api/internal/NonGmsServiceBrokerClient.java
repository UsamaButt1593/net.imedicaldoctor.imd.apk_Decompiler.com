package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

@KeepForSdk
public final class NonGmsServiceBrokerClient implements Api.Client, ServiceConnection {
    private static final String e3 = "NonGmsServiceBrokerClient";
    @Nullable
    private final String X;
    private final ConnectionCallbacks X2;
    @Nullable
    private final ComponentName Y;
    private final Handler Y2;
    private final Context Z;
    private final OnConnectionFailedListener Z2;
    @Nullable
    private IBinder a3;
    private boolean b3;
    @Nullable
    private String c3;
    @Nullable
    private String d3;
    @Nullable
    private final String s;

    @KeepForSdk
    public NonGmsServiceBrokerClient(@NonNull Context context, @NonNull Looper looper, @NonNull ComponentName componentName, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, (String) null, (String) null, componentName, connectionCallbacks, onConnectionFailedListener);
    }

    @WorkerThread
    private final void B() {
        if (Thread.currentThread() != this.Y2.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    private final void C(String str) {
        String.valueOf(this.a3);
    }

    public final void A(@Nullable String str) {
        this.d3 = str;
    }

    public final boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.b3 = false;
        this.a3 = null;
        C("Disconnected.");
        this.X2.e(1);
    }

    public final boolean d() {
        return false;
    }

    @NonNull
    public final Set<Scope> e() {
        return Collections.emptySet();
    }

    public final void f(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set) {
    }

    @WorkerThread
    public final void g(@NonNull String str) {
        B();
        this.c3 = str;
        l();
    }

    @WorkerThread
    public final boolean h() {
        B();
        return this.b3;
    }

    @NonNull
    public final String i() {
        String str = this.s;
        if (str != null) {
            return str;
        }
        Preconditions.r(this.Y);
        return this.Y.getPackageName();
    }

    @WorkerThread
    public final boolean j() {
        B();
        return this.a3 != null;
    }

    @WorkerThread
    public final void k(@NonNull BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        B();
        C("Connect started.");
        if (j()) {
            try {
                g("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.Y;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.s).setAction(this.X);
            }
            boolean bindService = this.Z.bindService(intent, this, GmsClientSupervisor.d());
            this.b3 = bindService;
            if (!bindService) {
                this.a3 = null;
                this.Z2.f(new ConnectionResult(16));
            }
            C("Finished connect.");
        } catch (SecurityException e2) {
            this.b3 = false;
            this.a3 = null;
            throw e2;
        }
    }

    @WorkerThread
    public final void l() {
        B();
        C("Disconnect called.");
        try {
            this.Z.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.b3 = false;
        this.a3 = null;
    }

    public final void m(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }

    @NonNull
    public final Feature[] n() {
        return new Feature[0];
    }

    public final void o(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.Y2.post(new zacg(this, iBinder));
    }

    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
        this.Y2.post(new zacf(this));
    }

    public final boolean p() {
        return false;
    }

    public final int r() {
        return 0;
    }

    @NonNull
    public final Feature[] s() {
        return new Feature[0];
    }

    @Nullable
    public final String u() {
        return this.c3;
    }

    @NonNull
    public final Intent v() {
        return new Intent();
    }

    public final boolean w() {
        return false;
    }

    @Nullable
    public final IBinder x() {
        return null;
    }

    @WorkerThread
    @KeepForSdk
    @Nullable
    public IBinder y() {
        B();
        return this.a3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void z(IBinder iBinder) {
        this.b3 = false;
        this.a3 = iBinder;
        C("Connected.");
        this.X2.z(new Bundle());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001e, code lost:
        if (r6 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private NonGmsServiceBrokerClient(android.content.Context r2, android.os.Looper r3, @androidx.annotation.Nullable java.lang.String r4, @androidx.annotation.Nullable java.lang.String r5, @androidx.annotation.Nullable android.content.ComponentName r6, com.google.android.gms.common.api.internal.ConnectionCallbacks r7, com.google.android.gms.common.api.internal.OnConnectionFailedListener r8) {
        /*
            r1 = this;
            r1.<init>()
            r0 = 0
            r1.b3 = r0
            r0 = 0
            r1.c3 = r0
            r1.Z = r2
            com.google.android.gms.internal.base.zaq r2 = new com.google.android.gms.internal.base.zaq
            r2.<init>(r3)
            r1.Y2 = r2
            r1.X2 = r7
            r1.Z2 = r8
            if (r4 == 0) goto L_0x001e
            if (r5 == 0) goto L_0x001e
            if (r6 != 0) goto L_0x0027
            r6 = r0
            goto L_0x0020
        L_0x001e:
            if (r6 == 0) goto L_0x0027
        L_0x0020:
            r1.s = r4
            r1.X = r5
            r1.Y = r6
            return
        L_0x0027:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            java.lang.String r3 = "Must specify either package or component, but not both"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient.<init>(android.content.Context, android.os.Looper, java.lang.String, java.lang.String, android.content.ComponentName, com.google.android.gms.common.api.internal.ConnectionCallbacks, com.google.android.gms.common.api.internal.OnConnectionFailedListener):void");
    }

    @KeepForSdk
    public NonGmsServiceBrokerClient(@NonNull Context context, @NonNull Looper looper, @NonNull String str, @NonNull String str2, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, str, str2, (ComponentName) null, connectionCallbacks, onConnectionFailedListener);
    }
}
