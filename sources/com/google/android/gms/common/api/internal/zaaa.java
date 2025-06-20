package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.media3.common.C;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zal;
import com.google.android.gms.internal.base.zaq;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

final class zaaa implements zaca {

    /* renamed from: l  reason: collision with root package name */
    private final Context f20036l;

    /* renamed from: m  reason: collision with root package name */
    private final zabe f20037m;

    /* renamed from: n  reason: collision with root package name */
    private final Looper f20038n;
    /* access modifiers changed from: private */
    public final zabi o;
    /* access modifiers changed from: private */
    public final zabi p;
    private final Map<Api.AnyClientKey<?>, zabi> q;
    private final Set<SignInConnectionListener> r = Collections.newSetFromMap(new WeakHashMap());
    @Nullable
    private final Api.Client s;
    @Nullable
    private Bundle t;
    /* access modifiers changed from: private */
    @Nullable
    public ConnectionResult u = null;
    /* access modifiers changed from: private */
    @Nullable
    public ConnectionResult v = null;
    /* access modifiers changed from: private */
    public boolean w = false;
    /* access modifiers changed from: private */
    public final Lock x;
    @GuardedBy("mLock")
    private int y = 0;

    private zaaa(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, @Nullable Api.Client client, ArrayList<zat> arrayList, ArrayList<zat> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.f20036l = context;
        this.f20037m = zabe;
        this.x = lock;
        this.f20038n = looper;
        this.s = client;
        Context context2 = context;
        zabe zabe2 = zabe;
        Lock lock2 = lock;
        Looper looper2 = looper;
        GoogleApiAvailabilityLight googleApiAvailabilityLight2 = googleApiAvailabilityLight;
        zabi zabi = r3;
        zabi zabi2 = new zabi(context2, zabe2, lock2, looper2, googleApiAvailabilityLight2, map2, (ClientSettings) null, map4, (Api.AbstractClientBuilder<? extends zae, SignInOptions>) null, arrayList2, new zax(this, (zaw) null));
        this.o = zabi;
        this.p = new zabi(context2, zabe2, lock2, looper2, googleApiAvailabilityLight2, map, clientSettings, map3, abstractClientBuilder, arrayList, new zaz(this, (zay) null));
        ArrayMap arrayMap = new ArrayMap();
        for (Api.AnyClientKey<?> put : map2.keySet()) {
            arrayMap.put(put, this.o);
        }
        for (Api.AnyClientKey<?> put2 : map.keySet()) {
            arrayMap.put(put2, this.p);
        }
        this.q = Collections.unmodifiableMap(arrayMap);
    }

    static /* bridge */ /* synthetic */ void A(zaaa zaaa, int i2, boolean z) {
        zaaa.f20037m.b(i2, z);
        zaaa.v = null;
        zaaa.u = null;
    }

    static /* bridge */ /* synthetic */ void B(zaaa zaaa, Bundle bundle) {
        Bundle bundle2 = zaaa.t;
        if (bundle2 == null) {
            zaaa.t = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    static /* bridge */ /* synthetic */ void C(zaaa zaaa) {
        ConnectionResult connectionResult;
        if (r(zaaa.u)) {
            if (r(zaaa.v) || zaaa.e()) {
                int i2 = zaaa.y;
                if (i2 != 1) {
                    if (i2 != 2) {
                        Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                        zaaa.y = 0;
                        return;
                    }
                    ((zabe) Preconditions.r(zaaa.f20037m)).a(zaaa.t);
                }
                zaaa.b();
                zaaa.y = 0;
                return;
            }
            ConnectionResult connectionResult2 = zaaa.v;
            if (connectionResult2 == null) {
                return;
            }
            if (zaaa.y == 1) {
                zaaa.b();
                return;
            }
            zaaa.a(connectionResult2);
            zaaa.o.m();
        } else if (zaaa.u == null || !r(zaaa.v)) {
            ConnectionResult connectionResult3 = zaaa.u;
            if (connectionResult3 != null && (connectionResult = zaaa.v) != null) {
                if (zaaa.p.x < zaaa.o.x) {
                    connectionResult3 = connectionResult;
                }
                zaaa.a(connectionResult3);
            }
        } else {
            zaaa.p.m();
            zaaa.a((ConnectionResult) Preconditions.r(zaaa.u));
        }
    }

    @Nullable
    private final PendingIntent E() {
        if (this.s == null) {
            return null;
        }
        return zal.zaa(this.f20036l, System.identityHashCode(this.f20037m), this.s.v(), zal.zaa | C.S0);
    }

    @GuardedBy("mLock")
    private final void a(ConnectionResult connectionResult) {
        int i2 = this.y;
        if (i2 != 1) {
            if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                this.y = 0;
            }
            this.f20037m.c(connectionResult);
        }
        b();
        this.y = 0;
    }

    @GuardedBy("mLock")
    private final void b() {
        for (SignInConnectionListener onComplete : this.r) {
            onComplete.onComplete();
        }
        this.r.clear();
    }

    @GuardedBy("mLock")
    private final boolean e() {
        ConnectionResult connectionResult = this.v;
        return connectionResult != null && connectionResult.C() == 4;
    }

    private final boolean q(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        zabi zabi = this.q.get(apiMethodImpl.y());
        Preconditions.s(zabi, "GoogleApiClient is not configured to use the API required for this call.");
        return zabi.equals(this.p);
    }

    private static boolean r(@Nullable ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.O();
    }

    public static zaaa t(Context context, zabe zabe, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, ArrayList<zat> arrayList) {
        Map<Api<?>, Boolean> map3 = map2;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.Client client = null;
        for (Map.Entry next : map.entrySet()) {
            Api.Client client2 = (Api.Client) next.getValue();
            if (true == client2.d()) {
                client = client2;
            }
            boolean w2 = client2.w();
            Api.AnyClientKey anyClientKey = (Api.AnyClientKey) next.getKey();
            if (w2) {
                arrayMap.put(anyClientKey, client2);
            } else {
                arrayMap2.put(anyClientKey, client2);
            }
        }
        Preconditions.y(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api next2 : map2.keySet()) {
            Api.AnyClientKey<?> b2 = next2.b();
            if (arrayMap.containsKey(b2)) {
                arrayMap3.put(next2, map3.get(next2));
            } else if (arrayMap2.containsKey(b2)) {
                arrayMap4.put(next2, map3.get(next2));
            } else {
                throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zat zat = arrayList.get(i2);
            if (arrayMap3.containsKey(zat.f20179l)) {
                arrayList2.add(zat);
            } else if (arrayMap4.containsKey(zat.f20179l)) {
                arrayList3.add(zat);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
            }
        }
        return new zaaa(context, zabe, lock, looper, googleApiAvailabilityLight, arrayMap, arrayMap2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    @GuardedBy("mLock")
    public final ConnectionResult c() {
        throw new UnsupportedOperationException();
    }

    public final boolean d() {
        this.x.lock();
        try {
            return this.y == 2;
        } finally {
            this.x.unlock();
        }
    }

    @GuardedBy("mLock")
    public final ConnectionResult f(long j2, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @GuardedBy("mLock")
    public final void g() {
        this.y = 2;
        this.w = false;
        this.v = null;
        this.u = null;
        this.o.g();
        this.p.g();
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T h(@NonNull T t2) {
        if (!q(t2)) {
            this.o.h(t2);
            return t2;
        } else if (e()) {
            t2.a(new Status(4, (String) null, E()));
            return t2;
        } else {
            this.p.h(t2);
            return t2;
        }
    }

    public final boolean i() {
        this.x.lock();
        try {
            boolean z = false;
            if (this.o.i() && (this.p.i() || e() || this.y == 1)) {
                z = true;
            }
            return z;
        } finally {
            this.x.unlock();
        }
    }

    @GuardedBy("mLock")
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T j(@NonNull T t2) {
        if (!q(t2)) {
            return this.o.j(t2);
        }
        if (!e()) {
            return this.p.j(t2);
        }
        t2.a(new Status(4, (String) null, E()));
        return t2;
    }

    @GuardedBy("mLock")
    public final void k() {
        this.o.k();
        this.p.k();
    }

    public final void l() {
        this.x.lock();
        try {
            boolean d2 = d();
            this.p.m();
            this.v = new ConnectionResult(4);
            if (d2) {
                new zaq(this.f20038n).post(new zav(this));
            } else {
                b();
            }
        } finally {
            this.x.unlock();
        }
    }

    @GuardedBy("mLock")
    public final void m() {
        this.v = null;
        this.u = null;
        this.y = 0;
        this.o.m();
        this.p.m();
        b();
    }

    public final boolean n(SignInConnectionListener signInConnectionListener) {
        this.x.lock();
        try {
            if (!d()) {
                if (i()) {
                }
                this.x.unlock();
                return false;
            }
            if (!this.p.i()) {
                this.r.add(signInConnectionListener);
                if (this.y == 0) {
                    this.y = 1;
                }
                this.v = null;
                this.p.g();
                this.x.unlock();
                return true;
            }
            this.x.unlock();
            return false;
        } catch (Throwable th) {
            this.x.unlock();
            throw th;
        }
    }

    public final void o(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.p.o(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.o.o(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @GuardedBy("mLock")
    @Nullable
    public final ConnectionResult p(@NonNull Api<?> api) {
        if (Objects.b(this.q.get(api.b()), this.p)) {
            return e() ? new ConnectionResult(4, E()) : this.p.p(api);
        }
        return this.o.p(api);
    }
}
