package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaax implements zabf {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final zabi f20076a;

    public zaax(zabi zabi) {
        this.f20076a = zabi;
    }

    public final void a(@Nullable Bundle bundle) {
    }

    public final void b() {
        this.f20076a.r();
    }

    public final void c(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    public final void d(int i2) {
    }

    public final void e() {
        for (Api.Client l2 : this.f20076a.q.values()) {
            l2.l();
        }
        this.f20076a.y.s = Collections.emptySet();
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T f(T t) {
        this.f20076a.y.f20094k.add(t);
        return t;
    }

    public final boolean g() {
        return true;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T h(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
