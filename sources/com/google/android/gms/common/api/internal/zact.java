package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zad;
import com.google.android.gms.signin.zae;
import java.util.Set;

public final class zact extends zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private static final Api.AbstractClientBuilder<? extends zae, SignInOptions> s = zad.f20496c;

    /* renamed from: l  reason: collision with root package name */
    private final Context f20139l;

    /* renamed from: m  reason: collision with root package name */
    private final Handler f20140m;

    /* renamed from: n  reason: collision with root package name */
    private final Api.AbstractClientBuilder<? extends zae, SignInOptions> f20141n;
    private final Set<Scope> o;
    private final ClientSettings p;
    private zae q;
    /* access modifiers changed from: private */
    public zacs r;

    @WorkerThread
    public zact(Context context, Handler handler, @NonNull ClientSettings clientSettings) {
        Api.AbstractClientBuilder<? extends zae, SignInOptions> abstractClientBuilder = s;
        this.f20139l = context;
        this.f20140m = handler;
        this.p = (ClientSettings) Preconditions.s(clientSettings, "ClientSettings must not be null");
        this.o = clientSettings.i();
        this.f20141n = abstractClientBuilder;
    }

    static /* bridge */ /* synthetic */ void e1(zact zact, zak zak) {
        ConnectionResult C = zak.C();
        if (C.O()) {
            zav zav = (zav) Preconditions.r(zak.H());
            C = zav.C();
            if (!C.O()) {
                String valueOf = String.valueOf(C);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(valueOf), new Exception());
            } else {
                zact.r.c(zav.H(), zact.o);
                zact.q.l();
            }
        }
        zact.r.b(C);
        zact.q.l();
    }

    @BinderThread
    public final void Y(zak zak) {
        this.f20140m.post(new zacr(this, zak));
    }

    @WorkerThread
    public final void e(int i2) {
        this.q.l();
    }

    @WorkerThread
    public final void f(@NonNull ConnectionResult connectionResult) {
        this.r.b(connectionResult);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.google.android.gms.common.api.Api$Client, com.google.android.gms.signin.zae] */
    @WorkerThread
    public final void f1(zacs zacs) {
        zae zae = this.q;
        if (zae != null) {
            zae.l();
        }
        this.p.o(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder abstractClientBuilder = this.f20141n;
        Context context = this.f20139l;
        Looper looper = this.f20140m.getLooper();
        ClientSettings clientSettings = this.p;
        this.q = abstractClientBuilder.c(context, looper, clientSettings, clientSettings.k(), this, this);
        this.r = zacs;
        Set<Scope> set = this.o;
        if (set == null || set.isEmpty()) {
            this.f20140m.post(new zacq(this));
        } else {
            this.q.c();
        }
    }

    public final void g1() {
        zae zae = this.q;
        if (zae != null) {
            zae.l();
        }
    }

    @WorkerThread
    public final void z(@Nullable Bundle bundle) {
        this.q.q(this);
    }
}
