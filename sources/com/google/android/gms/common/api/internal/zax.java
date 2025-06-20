package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class zax implements zabz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaa f20182a;

    /* synthetic */ zax(zaaa zaaa, zaw zaw) {
        this.f20182a = zaaa;
    }

    public final void a(@Nullable Bundle bundle) {
        this.f20182a.x.lock();
        try {
            zaaa.B(this.f20182a, bundle);
            this.f20182a.u = ConnectionResult.w3;
            zaaa.C(this.f20182a);
        } finally {
            this.f20182a.x.unlock();
        }
    }

    public final void b(int i2, boolean z) {
        this.f20182a.x.lock();
        try {
            zaaa zaaa = this.f20182a;
            if (!zaaa.w && zaaa.v != null) {
                if (zaaa.v.O()) {
                    this.f20182a.w = true;
                    this.f20182a.p.e(i2);
                }
            }
            this.f20182a.w = false;
            zaaa.A(this.f20182a, i2, z);
        } finally {
            this.f20182a.x.unlock();
        }
    }

    public final void c(@NonNull ConnectionResult connectionResult) {
        this.f20182a.x.lock();
        try {
            this.f20182a.u = connectionResult;
            zaaa.C(this.f20182a);
        } finally {
            this.f20182a.x.unlock();
        }
    }
}
