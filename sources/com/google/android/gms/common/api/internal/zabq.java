package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zabq<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zau {

    /* renamed from: l  reason: collision with root package name */
    private final Queue<zai> f20106l = new LinkedList();
    /* access modifiers changed from: private */
    @NotOnlyInitialized

    /* renamed from: m  reason: collision with root package name */
    public final Api.Client f20107m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final ApiKey<O> f20108n;
    private final zaad o;
    private final Set<zal> p = new HashSet();
    private final Map<ListenerHolder.ListenerKey<?>, zaci> q = new HashMap();
    private final int r;
    @Nullable
    private final zact s;
    private boolean t;
    private final List<zabs> u = new ArrayList();
    @Nullable
    private ConnectionResult v = null;
    private int w = 0;
    final /* synthetic */ GoogleApiManager x;

    @WorkerThread
    public zabq(GoogleApiManager googleApiManager, GoogleApi<O> googleApi) {
        this.x = googleApiManager;
        Api.Client w2 = googleApi.w(googleApiManager.i3.getLooper(), this);
        this.f20107m = w2;
        this.f20108n = googleApi.b();
        this.o = new zaad();
        this.r = googleApi.v();
        if (w2.w()) {
            this.s = googleApi.x(googleApiManager.Z2, googleApiManager.i3);
        } else {
            this.s = null;
        }
    }

    static /* bridge */ /* synthetic */ void B(zabq zabq, zabs zabs) {
        if (!zabq.u.contains(zabs) || zabq.t) {
            return;
        }
        if (!zabq.f20107m.j()) {
            zabq.E();
        } else {
            zabq.h();
        }
    }

    static /* bridge */ /* synthetic */ void C(zabq zabq, zabs zabs) {
        Feature[] g2;
        if (zabq.u.remove(zabs)) {
            zabq.x.i3.removeMessages(15, zabs);
            zabq.x.i3.removeMessages(16, zabs);
            Feature a2 = zabs.f20110b;
            ArrayList arrayList = new ArrayList(zabq.f20106l.size());
            for (zai next : zabq.f20106l) {
                if ((next instanceof zac) && (g2 = ((zac) next).g(zabq)) != null && ArrayUtils.d(g2, a2)) {
                    arrayList.add(next);
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                zai zai = (zai) arrayList.get(i2);
                zabq.f20106l.remove(zai);
                zai.b(new UnsupportedApiCallException(a2));
            }
        }
    }

    @WorkerThread
    @Nullable
    private final Feature b(@Nullable Feature[] featureArr) {
        if (!(featureArr == null || featureArr.length == 0)) {
            Feature[] s2 = this.f20107m.s();
            if (s2 == null) {
                s2 = new Feature[0];
            }
            ArrayMap arrayMap = new ArrayMap(r3);
            for (Feature feature : s2) {
                arrayMap.put(feature.C(), Long.valueOf(feature.H()));
            }
            for (Feature feature2 : featureArr) {
                Long l2 = (Long) arrayMap.get(feature2.C());
                if (l2 == null || l2.longValue() < feature2.H()) {
                    return feature2;
                }
            }
        }
        return null;
    }

    @WorkerThread
    private final void c(ConnectionResult connectionResult) {
        for (zal c2 : this.p) {
            c2.c(this.f20108n, connectionResult, Objects.b(connectionResult, ConnectionResult.w3) ? this.f20107m.i() : null);
        }
        this.p.clear();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void d(Status status) {
        Preconditions.h(this.x.i3);
        g(status, (Exception) null, false);
    }

    @WorkerThread
    private final void g(@Nullable Status status, @Nullable Exception exc, boolean z) {
        Preconditions.h(this.x.i3);
        boolean z2 = true;
        boolean z3 = status == null;
        if (exc != null) {
            z2 = false;
        }
        if (z3 != z2) {
            Iterator<zai> it2 = this.f20106l.iterator();
            while (it2.hasNext()) {
                zai next = it2.next();
                if (!z || next.f20165a == 2) {
                    if (status != null) {
                        next.a(status);
                    } else {
                        next.b(exc);
                    }
                    it2.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    @WorkerThread
    private final void h() {
        ArrayList arrayList = new ArrayList(this.f20106l);
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zai zai = (zai) arrayList.get(i2);
            if (this.f20107m.j()) {
                if (n(zai)) {
                    this.f20106l.remove(zai);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void i() {
        D();
        c(ConnectionResult.w3);
        m();
        Iterator<zaci> it2 = this.q.values().iterator();
        while (it2.hasNext()) {
            zaci next = it2.next();
            if (b(next.f20132a.c()) == null) {
                try {
                    next.f20132a.d(this.f20107m, new TaskCompletionSource());
                } catch (DeadObjectException unused) {
                    e(3);
                    this.f20107m.g("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                }
            }
            it2.remove();
        }
        h();
        k();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void j(int i2) {
        D();
        this.t = true;
        this.o.e(i2, this.f20107m.u());
        GoogleApiManager googleApiManager = this.x;
        googleApiManager.i3.sendMessageDelayed(Message.obtain(googleApiManager.i3, 9, this.f20108n), this.x.s);
        GoogleApiManager googleApiManager2 = this.x;
        googleApiManager2.i3.sendMessageDelayed(Message.obtain(googleApiManager2.i3, 11, this.f20108n), this.x.X);
        this.x.b3.c();
        for (zaci zaci : this.q.values()) {
            zaci.f20134c.run();
        }
    }

    private final void k() {
        this.x.i3.removeMessages(12, this.f20108n);
        GoogleApiManager googleApiManager = this.x;
        googleApiManager.i3.sendMessageDelayed(googleApiManager.i3.obtainMessage(12, this.f20108n), this.x.Y);
    }

    @WorkerThread
    private final void l(zai zai) {
        zai.d(this.o, P());
        try {
            zai.c(this);
        } catch (DeadObjectException unused) {
            e(1);
            this.f20107m.g("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    @WorkerThread
    private final void m() {
        if (this.t) {
            this.x.i3.removeMessages(11, this.f20108n);
            this.x.i3.removeMessages(9, this.f20108n);
            this.t = false;
        }
    }

    @WorkerThread
    private final boolean n(zai zai) {
        if (!(zai instanceof zac)) {
            l(zai);
            return true;
        }
        zac zac = (zac) zai;
        Feature b2 = b(zac.g(this));
        if (b2 == null) {
            l(zai);
            return true;
        }
        String name = this.f20107m.getClass().getName();
        String C = b2.C();
        long H = b2.H();
        StringBuilder sb = new StringBuilder(name.length() + 77 + String.valueOf(C).length());
        sb.append(name);
        sb.append(" could not execute call because it requires feature (");
        sb.append(C);
        sb.append(", ");
        sb.append(H);
        sb.append(").");
        Log.w("GoogleApiManager", sb.toString());
        if (!this.x.j3 || !zac.f(this)) {
            zac.b(new UnsupportedApiCallException(b2));
            return true;
        }
        zabs zabs = new zabs(this.f20108n, b2, (zabr) null);
        int indexOf = this.u.indexOf(zabs);
        if (indexOf >= 0) {
            zabs zabs2 = this.u.get(indexOf);
            this.x.i3.removeMessages(15, zabs2);
            GoogleApiManager googleApiManager = this.x;
            googleApiManager.i3.sendMessageDelayed(Message.obtain(googleApiManager.i3, 15, zabs2), this.x.s);
            return false;
        }
        this.u.add(zabs);
        GoogleApiManager googleApiManager2 = this.x;
        googleApiManager2.i3.sendMessageDelayed(Message.obtain(googleApiManager2.i3, 15, zabs), this.x.s);
        GoogleApiManager googleApiManager3 = this.x;
        googleApiManager3.i3.sendMessageDelayed(Message.obtain(googleApiManager3.i3, 16, zabs), this.x.X);
        ConnectionResult connectionResult = new ConnectionResult(2, (PendingIntent) null);
        if (o(connectionResult)) {
            return false;
        }
        this.x.h(connectionResult, this.r);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return false;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean o(@androidx.annotation.NonNull com.google.android.gms.common.ConnectionResult r4) {
        /*
            r3 = this;
            java.lang.Object r0 = com.google.android.gms.common.api.internal.GoogleApiManager.m3
            monitor-enter(r0)
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r3.x     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.zaae r2 = r1.f3     // Catch:{ all -> 0x0027 }
            if (r2 == 0) goto L_0x0029
            java.util.Set r1 = r1.g3     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.ApiKey<O> r2 = r3.f20108n     // Catch:{ all -> 0x0027 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0029
            com.google.android.gms.common.api.internal.GoogleApiManager r1 = r3.x     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.zaae r1 = r1.f3     // Catch:{ all -> 0x0027 }
            int r2 = r3.r     // Catch:{ all -> 0x0027 }
            r1.t(r4, r2)     // Catch:{ all -> 0x0027 }
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 1
            return r4
        L_0x0027:
            r4 = move-exception
            goto L_0x002c
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            r4 = 0
            return r4
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zabq.o(com.google.android.gms.common.ConnectionResult):boolean");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final boolean p(boolean z) {
        Preconditions.h(this.x.i3);
        if (!this.f20107m.j() || this.q.size() != 0) {
            return false;
        }
        if (this.o.g()) {
            if (z) {
                k();
            }
            return false;
        }
        this.f20107m.g("Timing out service connection.");
        return true;
    }

    @WorkerThread
    public final void D() {
        Preconditions.h(this.x.i3);
        this.v = null;
    }

    @WorkerThread
    public final void E() {
        ConnectionResult connectionResult;
        Preconditions.h(this.x.i3);
        if (!this.f20107m.j() && !this.f20107m.h()) {
            try {
                GoogleApiManager googleApiManager = this.x;
                int b2 = googleApiManager.b3.b(googleApiManager.Z2, this.f20107m);
                if (b2 != 0) {
                    ConnectionResult connectionResult2 = new ConnectionResult(b2, (PendingIntent) null);
                    String name = this.f20107m.getClass().getName();
                    String obj = connectionResult2.toString();
                    StringBuilder sb = new StringBuilder(name.length() + 35 + obj.length());
                    sb.append("The service for ");
                    sb.append(name);
                    sb.append(" is not available: ");
                    sb.append(obj);
                    Log.w("GoogleApiManager", sb.toString());
                    H(connectionResult2, (Exception) null);
                    return;
                }
                GoogleApiManager googleApiManager2 = this.x;
                Api.Client client = this.f20107m;
                zabu zabu = new zabu(googleApiManager2, client, this.f20108n);
                if (client.w()) {
                    ((zact) Preconditions.r(this.s)).f1(zabu);
                }
                try {
                    this.f20107m.k(zabu);
                } catch (SecurityException e2) {
                    e = e2;
                    connectionResult = new ConnectionResult(10);
                    H(connectionResult, e);
                }
            } catch (IllegalStateException e3) {
                e = e3;
                connectionResult = new ConnectionResult(10);
                H(connectionResult, e);
            }
        }
    }

    @WorkerThread
    public final void F(zai zai) {
        Preconditions.h(this.x.i3);
        if (!this.f20107m.j()) {
            this.f20106l.add(zai);
            ConnectionResult connectionResult = this.v;
            if (connectionResult == null || !connectionResult.N()) {
                E();
            } else {
                H(this.v, (Exception) null);
            }
        } else if (n(zai)) {
            k();
        } else {
            this.f20106l.add(zai);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void G() {
        this.w++;
    }

    @WorkerThread
    public final void H(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
        Preconditions.h(this.x.i3);
        zact zact = this.s;
        if (zact != null) {
            zact.g1();
        }
        D();
        this.x.b3.c();
        c(connectionResult);
        if ((this.f20107m instanceof zap) && connectionResult.C() != 24) {
            this.x.Z = true;
            GoogleApiManager googleApiManager = this.x;
            googleApiManager.i3.sendMessageDelayed(googleApiManager.i3.obtainMessage(19), 300000);
        }
        if (connectionResult.C() == 4) {
            d(GoogleApiManager.l3);
        } else if (this.f20106l.isEmpty()) {
            this.v = connectionResult;
        } else if (exc != null) {
            Preconditions.h(this.x.i3);
            g((Status) null, exc, false);
        } else if (this.x.j3) {
            g(GoogleApiManager.i(this.f20108n, connectionResult), (Exception) null, true);
            if (!this.f20106l.isEmpty() && !o(connectionResult) && !this.x.h(connectionResult, this.r)) {
                if (connectionResult.C() == 18) {
                    this.t = true;
                }
                if (this.t) {
                    GoogleApiManager googleApiManager2 = this.x;
                    googleApiManager2.i3.sendMessageDelayed(Message.obtain(googleApiManager2.i3, 9, this.f20108n), this.x.s);
                    return;
                }
                d(GoogleApiManager.i(this.f20108n, connectionResult));
            }
        } else {
            d(GoogleApiManager.i(this.f20108n, connectionResult));
        }
    }

    @WorkerThread
    public final void I(@NonNull ConnectionResult connectionResult) {
        Preconditions.h(this.x.i3);
        Api.Client client = this.f20107m;
        String name = client.getClass().getName();
        String valueOf = String.valueOf(connectionResult);
        StringBuilder sb = new StringBuilder(name.length() + 25 + valueOf.length());
        sb.append("onSignInFailed for ");
        sb.append(name);
        sb.append(" with ");
        sb.append(valueOf);
        client.g(sb.toString());
        H(connectionResult, (Exception) null);
    }

    @WorkerThread
    public final void J(zal zal) {
        Preconditions.h(this.x.i3);
        this.p.add(zal);
    }

    @WorkerThread
    public final void K() {
        Preconditions.h(this.x.i3);
        if (this.t) {
            E();
        }
    }

    @WorkerThread
    public final void L() {
        Preconditions.h(this.x.i3);
        d(GoogleApiManager.k3);
        this.o.f();
        for (ListenerHolder.ListenerKey zah : (ListenerHolder.ListenerKey[]) this.q.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
            F(new zah(zah, new TaskCompletionSource()));
        }
        c(new ConnectionResult(4));
        if (this.f20107m.j()) {
            this.f20107m.m(new zabp(this));
        }
    }

    @WorkerThread
    public final void M() {
        Preconditions.h(this.x.i3);
        if (this.t) {
            m();
            GoogleApiManager googleApiManager = this.x;
            d(googleApiManager.a3.j(googleApiManager.Z2) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f20107m.g("Timing out connection while resuming.");
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O() {
        return this.f20107m.j();
    }

    public final boolean P() {
        return this.f20107m.w();
    }

    @WorkerThread
    public final boolean a() {
        return p(true);
    }

    public final void e(int i2) {
        if (Looper.myLooper() == this.x.i3.getLooper()) {
            j(i2);
        } else {
            this.x.i3.post(new zabn(this, i2));
        }
    }

    @WorkerThread
    public final void f(@NonNull ConnectionResult connectionResult) {
        H(connectionResult, (Exception) null);
    }

    public final int q() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int r() {
        return this.w;
    }

    @WorkerThread
    @Nullable
    public final ConnectionResult s() {
        Preconditions.h(this.x.i3);
        return this.v;
    }

    public final Api.Client u() {
        return this.f20107m;
    }

    public final void u0(ConnectionResult connectionResult, Api<?> api, boolean z) {
        throw null;
    }

    public final Map<ListenerHolder.ListenerKey<?>, zaci> w() {
        return this.q;
    }

    public final void z(@Nullable Bundle bundle) {
        if (Looper.myLooper() == this.x.i3.getLooper()) {
            i();
        } else {
            this.x.i3.post(new zabm(this));
        }
    }
}
