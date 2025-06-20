package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

final class zam {

    /* renamed from: a  reason: collision with root package name */
    private final int f20174a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f20175b;

    zam(ConnectionResult connectionResult, int i2) {
        Preconditions.r(connectionResult);
        this.f20175b = connectionResult;
        this.f20174a = i2;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f20174a;
    }

    /* access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.f20175b;
    }
}
