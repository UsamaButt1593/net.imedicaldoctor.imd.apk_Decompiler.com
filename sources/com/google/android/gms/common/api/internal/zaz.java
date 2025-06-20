package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class zaz implements zabz {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zaaa f20183a;

    /* synthetic */ zaz(zaaa zaaa, zay zay) {
        this.f20183a = zaaa;
    }

    public final void a(@Nullable Bundle bundle) {
        this.f20183a.x.lock();
        try {
            this.f20183a.v = ConnectionResult.w3;
            zaaa.C(this.f20183a);
        } finally {
            this.f20183a.x.unlock();
        }
    }

    public final void b(int i2, boolean z) {
        this.f20183a.x.lock();
        try {
            zaaa zaaa = this.f20183a;
            if (zaaa.w) {
                zaaa.w = false;
                zaaa.A(this.f20183a, i2, z);
            } else {
                zaaa.w = true;
                this.f20183a.o.e(i2);
            }
        } finally {
            this.f20183a.x.unlock();
        }
    }

    public final void c(@NonNull ConnectionResult connectionResult) {
        this.f20183a.x.lock();
        try {
            this.f20183a.v = connectionResult;
            zaaa.C(this.f20183a);
        } finally {
            this.f20183a.x.unlock();
        }
    }
}
