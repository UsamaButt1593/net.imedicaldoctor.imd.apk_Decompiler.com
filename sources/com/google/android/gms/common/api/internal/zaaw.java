package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zaaw implements zabf {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final zabi f20062a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Lock f20063b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f20064c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final GoogleApiAvailabilityLight f20065d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ConnectionResult f20066e;

    /* renamed from: f  reason: collision with root package name */
    private int f20067f;

    /* renamed from: g  reason: collision with root package name */
    private int f20068g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f20069h;

    /* renamed from: i  reason: collision with root package name */
    private final Bundle f20070i = new Bundle();

    /* renamed from: j  reason: collision with root package name */
    private final Set<Api.AnyClientKey> f20071j = new HashSet();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public zae f20072k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f20073l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f20074m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f20075n;
    /* access modifiers changed from: private */
    @Nullable
    public IAccountAccessor o;
    private boolean p;
    private boolean q;
    /* access modifiers changed from: private */
    @Nullable
    public final ClientSettings r;
    private final Map<Api<?>, Boolean> s;
    @Nullable
    private final Api.AbstractClientBuilder<? extends zae, SignInOptions> t;
    private final ArrayList<Future<?>> u = new ArrayList<>();

    public zaaw(zabi zabi, @Nullable ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, @Nullable Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.f20062a = zabi;
        this.r = clientSettings;
        this.s = map;
        this.f20065d = googleApiAvailabilityLight;
        this.t = abstractClientBuilder;
        this.f20063b = lock;
        this.f20064c = context;
    }

    static /* bridge */ /* synthetic */ void B(zaaw zaaw, zak zak) {
        if (zaaw.o(0)) {
            ConnectionResult C = zak.C();
            if (C.O()) {
                zav zav = (zav) Preconditions.r(zak.H());
                ConnectionResult C2 = zav.C();
                if (!C2.O()) {
                    String valueOf = String.valueOf(C2);
                    Log.wtf("GACConnecting", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
                    zaaw.l(C2);
                    return;
                }
                zaaw.f20075n = true;
                zaaw.o = (IAccountAccessor) Preconditions.r(zav.H());
                zaaw.p = zav.I();
                zaaw.q = zav.N();
                zaaw.n();
            } else if (zaaw.q(C)) {
                zaaw.i();
                zaaw.n();
            } else {
                zaaw.l(C);
            }
        }
    }

    private final void J() {
        ArrayList<Future<?>> arrayList = this.u;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).cancel(true);
        }
        this.u.clear();
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void i() {
        this.f20074m = false;
        this.f20062a.y.s = Collections.emptySet();
        for (Api.AnyClientKey next : this.f20071j) {
            if (!this.f20062a.r.containsKey(next)) {
                this.f20062a.r.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    @GuardedBy("mLock")
    private final void j(boolean z) {
        zae zae = this.f20072k;
        if (zae != null) {
            if (zae.j() && z) {
                zae.b();
            }
            zae.l();
            ClientSettings clientSettings = (ClientSettings) Preconditions.r(this.r);
            this.o = null;
        }
    }

    @GuardedBy("mLock")
    private final void k() {
        this.f20062a.q();
        zabj.a().execute(new zaak(this));
        zae zae = this.f20072k;
        if (zae != null) {
            if (this.p) {
                zae.t((IAccountAccessor) Preconditions.r(this.o), this.q);
            }
            j(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.f20062a.r.keySet()) {
            ((Api.Client) Preconditions.r(this.f20062a.q.get(anyClientKey))).l();
        }
        this.f20062a.z.a(this.f20070i.isEmpty() ? null : this.f20070i);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void l(ConnectionResult connectionResult) {
        J();
        j(!connectionResult.N());
        this.f20062a.s(connectionResult);
        this.f20062a.z.c(connectionResult);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void m(ConnectionResult connectionResult, Api<?> api, boolean z) {
        int b2 = api.c().b();
        if ((!z || connectionResult.N() || this.f20065d.d(connectionResult.C()) != null) && (this.f20066e == null || b2 < this.f20067f)) {
            this.f20066e = connectionResult;
            this.f20067f = b2;
        }
        this.f20062a.r.put(api.b(), connectionResult);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void n() {
        if (this.f20069h == 0) {
            if (!this.f20074m || this.f20075n) {
                ArrayList arrayList = new ArrayList();
                this.f20068g = 1;
                this.f20069h = this.f20062a.q.size();
                for (Api.AnyClientKey next : this.f20062a.q.keySet()) {
                    if (!this.f20062a.r.containsKey(next)) {
                        arrayList.add(this.f20062a.q.get(next));
                    } else if (p()) {
                        k();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.u.add(zabj.a().submit(new zaap(this, arrayList)));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean o(int i2) {
        if (this.f20068g == i2) {
            return true;
        }
        Log.w("GACConnecting", this.f20062a.y.M());
        Log.w("GACConnecting", "Unexpected callback in ".concat(toString()));
        int i3 = this.f20069h;
        StringBuilder sb = new StringBuilder(33);
        sb.append("mRemainingConnections=");
        sb.append(i3);
        Log.w("GACConnecting", sb.toString());
        String r2 = r(this.f20068g);
        String r3 = r(i2);
        StringBuilder sb2 = new StringBuilder(r2.length() + 70 + r3.length());
        sb2.append("GoogleApiClient connecting is in step ");
        sb2.append(r2);
        sb2.append(" but received callback for step ");
        sb2.append(r3);
        Log.e("GACConnecting", sb2.toString(), new Exception());
        l(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean p() {
        ConnectionResult connectionResult;
        int i2 = this.f20069h - 1;
        this.f20069h = i2;
        if (i2 > 0) {
            return false;
        }
        if (i2 < 0) {
            Log.w("GACConnecting", this.f20062a.y.M());
            Log.wtf("GACConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, (PendingIntent) null);
        } else {
            connectionResult = this.f20066e;
            if (connectionResult == null) {
                return true;
            }
            this.f20062a.x = this.f20067f;
        }
        l(connectionResult);
        return false;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean q(ConnectionResult connectionResult) {
        return this.f20073l && !connectionResult.N();
    }

    private static final String r(int i2) {
        return i2 != 0 ? "STEP_GETTING_REMOTE_SERVICE" : "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    }

    static /* bridge */ /* synthetic */ Set y(zaaw zaaw) {
        ClientSettings clientSettings = zaaw.r;
        if (clientSettings == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(clientSettings.i());
        Map<Api<?>, zab> n2 = zaaw.r.n();
        for (Api next : n2.keySet()) {
            if (!zaaw.f20062a.r.containsKey(next.b())) {
                hashSet.addAll(n2.get(next).f20282a);
            }
        }
        return hashSet;
    }

    @GuardedBy("mLock")
    public final void a(@Nullable Bundle bundle) {
        if (o(1)) {
            if (bundle != null) {
                this.f20070i.putAll(bundle);
            }
            if (p()) {
                k();
            }
        }
    }

    public final void b() {
    }

    @GuardedBy("mLock")
    public final void c(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (o(1)) {
            m(connectionResult, api, z);
            if (p()) {
                k();
            }
        }
    }

    @GuardedBy("mLock")
    public final void d(int i2) {
        l(new ConnectionResult(8, (PendingIntent) null));
    }

    /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @GuardedBy("mLock")
    public final void e() {
        this.f20062a.r.clear();
        this.f20074m = false;
        this.f20066e = null;
        this.f20068g = 0;
        this.f20073l = true;
        this.f20075n = false;
        this.p = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.s.keySet()) {
            Api.Client client = (Api.Client) Preconditions.r(this.f20062a.q.get(next.b()));
            z |= next.c().b() == 1;
            boolean booleanValue = this.s.get(next).booleanValue();
            if (client.w()) {
                this.f20074m = true;
                if (booleanValue) {
                    this.f20071j.add(next.b());
                } else {
                    this.f20073l = false;
                }
            }
            hashMap.put(client, new zaal(this, next, booleanValue));
        }
        if (z) {
            this.f20074m = false;
        }
        if (this.f20074m) {
            Preconditions.r(this.r);
            Preconditions.r(this.t);
            this.r.o(Integer.valueOf(System.identityHashCode(this.f20062a.y)));
            zaat zaat = new zaat(this, (zaas) null);
            Api.AbstractClientBuilder abstractClientBuilder = this.t;
            Context context = this.f20064c;
            Looper r2 = this.f20062a.y.r();
            ClientSettings clientSettings = this.r;
            this.f20072k = abstractClientBuilder.c(context, r2, clientSettings, clientSettings.k(), zaat, zaat);
        }
        this.f20069h = this.f20062a.q.size();
        this.u.add(zabj.a().submit(new zaao(this, hashMap)));
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T f(T t2) {
        this.f20062a.y.f20094k.add(t2);
        return t2;
    }

    @GuardedBy("mLock")
    public final boolean g() {
        J();
        j(true);
        this.f20062a.s((ConnectionResult) null);
        return true;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T h(T t2) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
