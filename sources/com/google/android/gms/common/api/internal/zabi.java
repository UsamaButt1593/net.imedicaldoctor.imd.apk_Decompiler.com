package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabi implements zaca, zau {
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Lock f20100l;

    /* renamed from: m  reason: collision with root package name */
    private final Condition f20101m;

    /* renamed from: n  reason: collision with root package name */
    private final Context f20102n;
    private final GoogleApiAvailabilityLight o;
    private final zabh p;
    final Map<Api.AnyClientKey<?>, Api.Client> q;
    final Map<Api.AnyClientKey<?>, ConnectionResult> r = new HashMap();
    @Nullable
    final ClientSettings s;
    final Map<Api<?>, Boolean> t;
    @Nullable
    final Api.AbstractClientBuilder<? extends zae, SignInOptions> u;
    /* access modifiers changed from: private */
    @NotOnlyInitialized
    public volatile zabf v;
    @Nullable
    private ConnectionResult w = null;
    int x;
    final zabe y;
    final zabz z;

    public zabi(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, @Nullable ClientSettings clientSettings, Map<Api<?>, Boolean> map2, @Nullable Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zat> arrayList, zabz zabz) {
        this.f20102n = context;
        this.f20100l = lock;
        this.o = googleApiAvailabilityLight;
        this.q = map;
        this.s = clientSettings;
        this.t = map2;
        this.u = abstractClientBuilder;
        this.y = zabe;
        this.z = zabz;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).a(this);
        }
        this.p = new zabh(this, looper);
        this.f20101m = lock.newCondition();
        this.v = new zaax(this);
    }

    @GuardedBy("mLock")
    public final ConnectionResult c() {
        g();
        while (this.v instanceof zaaw) {
            try {
                this.f20101m.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        if (this.v instanceof zaaj) {
            return ConnectionResult.w3;
        }
        ConnectionResult connectionResult = this.w;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    public final boolean d() {
        return this.v instanceof zaaw;
    }

    public final void e(int i2) {
        this.f20100l.lock();
        try {
            this.v.d(i2);
        } finally {
            this.f20100l.unlock();
        }
    }

    @GuardedBy("mLock")
    public final ConnectionResult f(long j2, TimeUnit timeUnit) {
        g();
        long nanos = timeUnit.toNanos(j2);
        while (this.v instanceof zaaw) {
            if (nanos <= 0) {
                try {
                    m();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.f20101m.awaitNanos(nanos);
            }
        }
        if (this.v instanceof zaaj) {
            return ConnectionResult.w3;
        }
        ConnectionResult connectionResult = this.w;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    @GuardedBy("mLock")
    public final void g() {
        this.v.b();
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T h(@NonNull T t2) {
        t2.s();
        this.v.f(t2);
        return t2;
    }

    public final boolean i() {
        return this.v instanceof zaaj;
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T j(@NonNull T t2) {
        t2.s();
        return this.v.h(t2);
    }

    @GuardedBy("mLock")
    public final void k() {
        if (this.v instanceof zaaj) {
            ((zaaj) this.v).j();
        }
    }

    public final void l() {
    }

    @GuardedBy("mLock")
    public final void m() {
        if (this.v.g()) {
            this.r.clear();
        }
    }

    public final boolean n(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    public final void o(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.v);
        for (Api next : this.t.keySet()) {
            printWriter.append(str).append(next.d()).println(":");
            ((Api.Client) Preconditions.r(this.q.get(next.b()))).o(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @GuardedBy("mLock")
    @Nullable
    public final ConnectionResult p(@NonNull Api<?> api) {
        Api.AnyClientKey<?> b2 = api.b();
        if (!this.q.containsKey(b2)) {
            return null;
        }
        if (this.q.get(b2).j()) {
            return ConnectionResult.w3;
        }
        if (this.r.containsKey(b2)) {
            return this.r.get(b2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void q() {
        this.f20100l.lock();
        try {
            this.y.R();
            this.v = new zaaj(this);
            this.v.e();
            this.f20101m.signalAll();
        } finally {
            this.f20100l.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        this.f20100l.lock();
        try {
            this.v = new zaaw(this, this.s, this.t, this.o, this.u, this.f20100l, this.f20102n);
            this.v.e();
            this.f20101m.signalAll();
        } finally {
            this.f20100l.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void s(@Nullable ConnectionResult connectionResult) {
        this.f20100l.lock();
        try {
            this.w = connectionResult;
            this.v = new zaax(this);
            this.v.e();
            this.f20101m.signalAll();
        } finally {
            this.f20100l.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final void t(zabg zabg) {
        this.p.sendMessage(this.p.obtainMessage(1, zabg));
    }

    /* access modifiers changed from: package-private */
    public final void u(RuntimeException runtimeException) {
        this.p.sendMessage(this.p.obtainMessage(2, runtimeException));
    }

    public final void u0(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, boolean z2) {
        this.f20100l.lock();
        try {
            this.v.c(connectionResult, api, z2);
        } finally {
            this.f20100l.unlock();
        }
    }

    public final void z(@Nullable Bundle bundle) {
        this.f20100l.lock();
        try {
            this.v.a(bundle);
        } finally {
            this.f20100l.unlock();
        }
    }
}
