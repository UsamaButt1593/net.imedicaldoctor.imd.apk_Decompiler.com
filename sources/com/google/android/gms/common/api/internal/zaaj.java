package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

public final class zaaj implements zabf {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final zabi f20050a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20051b = false;

    public zaaj(zabi zabi) {
        this.f20050a = zabi;
    }

    public final void a(@Nullable Bundle bundle) {
    }

    public final void b() {
        if (this.f20051b) {
            this.f20051b = false;
            this.f20050a.t(new zaai(this, this));
        }
    }

    public final void c(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final void d(int i2) {
        this.f20050a.s((ConnectionResult) null);
        this.f20050a.z.b(i2, this.f20051b);
    }

    public final void e() {
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T f(T t) {
        h(t);
        return t;
    }

    public final boolean g() {
        if (this.f20051b) {
            return false;
        }
        Set<zada> set = this.f20050a.y.z;
        if (set == null || set.isEmpty()) {
            this.f20050a.s((ConnectionResult) null);
            return true;
        }
        this.f20051b = true;
        for (zada k2 : set) {
            k2.k();
        }
        return false;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T h(T t) {
        try {
            this.f20050a.y.A.a(t);
            zabe zabe = this.f20050a.y;
            Api.Client client = zabe.r.get(t.y());
            Preconditions.s(client, "Appropriate Api was not requested.");
            if (client.j() || !this.f20050a.r.containsKey(t.y())) {
                t.A(client);
            } else {
                t.a(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.f20050a.t(new zaah(this, this));
        }
        return t;
    }

    /* access modifiers changed from: package-private */
    public final void j() {
        if (this.f20051b) {
            this.f20051b = false;
            this.f20050a.y.A.b();
            g();
        }
    }
}
